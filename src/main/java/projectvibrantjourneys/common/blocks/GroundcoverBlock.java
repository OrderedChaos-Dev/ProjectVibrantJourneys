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
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D);
	
	public GroundcoverBlock(Material material) {
		super(Block.Properties.create(material).hardnessAndResistance(0.05F, 0.0F).notSolid());
		this.setDefaultState(getDefaultState().with(MODEL, 0).with(WATERLOGGED, false));
	}
	
	public GroundcoverBlock(Material material, SoundType soundType) {
		super(Block.Properties.create(material).hardnessAndResistance(0.1F, 0.0F).sound(soundType).notSolid());
		this.setDefaultState(getDefaultState().with(MODEL, 0).with(WATERLOGGED, false));
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
		if(!world.isRemote) {
			int model = world.getRandom().nextInt(5);
			FluidState ifluidstate = world.getFluidState(pos);
			world.setBlockState(pos, this.getDefaultState().with(MODEL, model).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER)));
		}
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		int model = context.getWorld().getRandom().nextInt(5);
		FluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
		return this.getDefaultState().with(MODEL, model).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
	}
	
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
		if (state.get(WATERLOGGED)) {
			world.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
		}
		return state;
	}
	
	@Override
	public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {
		return world.getBlockState(pos.down()).isSolid();
	}
	
	@Override
	public void neighborChanged(BlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		if(!isValidPosition(state, world, pos)) {
			world.destroyBlock(pos, false);
		}
	}
	
	@Override
	public boolean canSpawnInBlock() {
		return true;
	}
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return VoxelShapes.empty();
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult brt) {
		if (!player.abilities.allowEdit) {
			return ActionResultType.PASS;
		} else {
			int model = state.get(MODEL).intValue();
			if(model < 4)
				model++;
			else
				model = 0;
			world.setBlockState(pos, state.with(MODEL, model));
			return ActionResultType.SUCCESS;
		}
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
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(MODEL, WATERLOGGED);
	}
}
