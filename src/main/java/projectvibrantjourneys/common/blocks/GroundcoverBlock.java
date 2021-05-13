package projectvibrantjourneys.common.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class GroundcoverBlock extends Block {

	public static final IntegerProperty MODEL = IntegerProperty.create("model", 0, 4);
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D);
	
	public GroundcoverBlock(Material material) {
		super(Block.Properties.of(material).strength(0.05F, 0.0F).noOcclusion());
		this.registerDefaultState(defaultBlockState().setValue(MODEL, 0).setValue(WATERLOGGED, false));
	}
	
	public GroundcoverBlock(Material material, SoundType soundType) {
		super(Block.Properties.of(material).strength(0.1F, 0.0F).sound(soundType).noOcclusion());
		this.registerDefaultState(defaultBlockState().setValue(MODEL, 0).setValue(WATERLOGGED, false));
	}

	@Override
	public void setPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
		if(!world.isClientSide) {
			int model = world.getRandom().nextInt(5);
			FluidState ifluidstate = world.getFluidState(pos);
			world.setBlock(pos, this.defaultBlockState().setValue(MODEL, model).setValue(WATERLOGGED, Boolean.valueOf(ifluidstate.getType() == Fluids.WATER)), 2);
		}
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		int model = context.getLevel().getRandom().nextInt(5);
		FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
		return this.defaultBlockState().setValue(MODEL, model).setValue(WATERLOGGED, Boolean.valueOf(ifluidstate.getType() == Fluids.WATER));
	}
	
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.getLiquidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return state;
	}
	
	@Override
	public boolean canSurvive(BlockState state, IWorldReader world, BlockPos pos) {
		return world.getBlockState(pos.below()).isCollisionShapeFullBlock(world, pos);
	}
	
	@Override
	public void neighborChanged(BlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		if(!canSurvive(state, world, pos)) {
			world.destroyBlock(pos, false);
		}
	}
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return VoxelShapes.empty();
	}
	
	@Override
	public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult brt) {
		world.removeBlock(pos, true);
		if(!player.isCreative() && player.mayBuild()) {
			InventoryHelper.dropItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this));
		}
		return ActionResultType.SUCCESS;
	}
	
	@Override
	public Block.OffsetType getOffsetType() {
		return Block.OffsetType.XZ;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}
	
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(MODEL, WATERLOGGED);
	}
}
