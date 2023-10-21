package dev.orderedchaos.projectvibrantjourneys.common.blocks;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GroundcoverBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {

	public static final IntegerProperty MODEL = IntegerProperty.create("model", 0, 4);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D);
	
	public GroundcoverBlock(BlockBehaviour.Properties props) {
		super(props);
		this.registerDefaultState(this.stateDefinition.any().setValue(MODEL, 0).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
	}
	
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		int model = context.getLevel().getRandom().nextInt(5);
		Direction facing = Direction.Plane.HORIZONTAL.getRandomDirection(context.getLevel().getRandom());
		FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
		return this.defaultBlockState()
				.setValue(MODEL, model)
				.setValue(FACING, facing)
				.setValue(WATERLOGGED, ifluidstate.getType() == Fluids.WATER);
	}
	
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return state;
	}
	
	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		return Block.canSupportRigidBlock(world, pos.below());
	}
	
	@Override
	public void neighborChanged(BlockState state, Level world, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		if(!canSurvive(state, world, pos)) {
			world.destroyBlock(pos, false);
		}
	}
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}
	
	@Override
	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult brt) {
		if (!player.getItemInHand(hand).isEmpty()) {
			return super.use(state, world, pos, player, hand, brt);
		}

		if(!player.isCreative() && player.mayBuild()) {
			ItemStack loot = null;

			if (!world.isClientSide()) {
				ItemStack tool = new ItemStack(Items.APPLE);
				tool.enchant(Enchantments.SILK_TOUCH, 1); // right click mimics silk touch
				LootTable lootTable = world.getServer().getLootData().getLootTable(this.getLootTable());
				LootParams lootParams = new LootParams.Builder((ServerLevel) world)
						.withParameter(LootContextParams.BLOCK_STATE, state)
						.withParameter(LootContextParams.ORIGIN, pos.getCenter())
						.withParameter(LootContextParams.TOOL, tool)
						.create(LootContextParamSets.BLOCK);
				ObjectArrayList<ItemStack> randomItems = lootTable.getRandomItems(lootParams);

				if (randomItems.size() > 0) {
					loot = randomItems.get(0);
				}
			}

			if (loot == null) {
				loot = new ItemStack(this);
			}

			Containers.dropItemStack(world, pos.getX(), pos.getY(), pos.getZ(), loot);
		}

		world.removeBlock(pos, true);

		return InteractionResult.SUCCESS;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(MODEL, FACING, WATERLOGGED);
	}
}
