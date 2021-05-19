package projectvibrantjourneys.common.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SandBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class CattailBlock extends DoublePlantBlock implements IWaterLoggable {

	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public CattailBlock() {
		super(Block.Properties.of(Material.PLANT).noCollission().instabreak()
				.sound(SoundType.GRASS));
		this.registerDefaultState(
				this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, false));
	}

	@Override
	public boolean canSurvive(BlockState state, IWorldReader world, BlockPos pos) {
		if (state.getValue(HALF) == DoubleBlockHalf.UPPER && state.getValue(WATERLOGGED)) {
			return false;
		}
		if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
			BlockPos groundPos = pos.below();
			Block ground = world.getBlockState(groundPos).getBlock();

			if (world.getFluidState(pos).getType() == Fluids.WATER)
				return canGrow(ground);

			for (Direction direction : Direction.Plane.HORIZONTAL) {
				if (world.getFluidState(groundPos.offset(direction.getNormal())).getType() == Fluids.WATER) {
					return canGrow(ground);
				}
			}

			return false;
		} else {
			BlockState blockstate = world.getBlockState(pos.below());
			if (state.getBlock() != this)
				return false;
			return blockstate.getBlock() == this && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER;
		}
	}
	
	public boolean canGrow(Block ground) {
		return ground == Blocks.DIRT || ground instanceof GrassBlock || ground instanceof SandBlock
				|| ground == Blocks.GRAVEL || ground == Blocks.CLAY;
	}

	@Override
	public void neighborChanged(BlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos,
			boolean isMoving) {
		if (!canSurvive(state, world, pos)) {
			if (state.getValue(WATERLOGGED)) {
				world.setBlock(pos, Blocks.WATER.defaultBlockState(), 2);
			} else {
				world.destroyBlock(pos, false);
			}
		}
		if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
			BlockState stateUpper = world.getBlockState(pos.above());
			if (stateUpper.getBlock() instanceof CattailBlock) {
				if (!canSurvive(stateUpper, world, pos.above())) {
					world.destroyBlock(pos.above(), false);
				}
			}
		}
	}

	@Override
	public void playerWillDestroy(World world, BlockPos pos, BlockState state, PlayerEntity player) {
		DoubleBlockHalf doubleblockhalf = state.getValue(HALF);
		BlockPos blockpos = doubleblockhalf == DoubleBlockHalf.LOWER ? pos.above() : pos.below();
		BlockState blockstate = world.getBlockState(blockpos);
		if (blockstate.getBlock() == this && blockstate.getValue(HALF) != doubleblockhalf) {
			if (blockstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
				if (blockstate.getValue(WATERLOGGED)) {
					world.setBlock(blockpos, Blocks.WATER.defaultBlockState(), 2);
				} else {
					world.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
				}
			}

			world.levelEvent(player, 2001, blockpos, Block.getId(blockstate));
			if (!world.isClientSide && !player.isCreative()) {
				dropResources(state, world, pos, (TileEntity) null, player, player.getMainHandItem());
				dropResources(blockstate, world, blockpos, (TileEntity) null, player, player.getMainHandItem());
			}
		}
		world.levelEvent(player, 2001, pos, Block.getId(state));
	}
	
	public void placeInWater(IWorld worldIn, BlockPos pos, int flags) {
		worldIn.setBlock(pos, this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, true), flags);
		worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER), flags);
	}

	@Override
	public boolean canBeReplaced(BlockState state, BlockItemUseContext useContext) {
		return false;
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld world,
			BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.getLiquidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}

		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());

		BlockState state = super.getStateForPlacement(context);
		if (state != null) {
			return state.setValue(WATERLOGGED, Boolean.valueOf(ifluidstate.getType() == Fluids.WATER));
		} else {
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}
	
	@Override
	public AbstractBlock.OffsetType getOffsetType() {
		return AbstractBlock.OffsetType.XYZ;
	}

	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HALF, WATERLOGGED);
	}
}
