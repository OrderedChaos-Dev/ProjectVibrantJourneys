package dev.orderedchaos.projectvibrantjourneys.common.blocks;

import dev.orderedchaos.projectvibrantjourneys.util.LevelUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

import javax.annotation.Nullable;

public class DoubleHighWaterPlantBlock extends DoublePlantBlock implements SimpleWaterloggedBlock {

	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public DoubleHighWaterPlantBlock(BlockBehaviour.Properties props) {
		super(props);
		this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, false));
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
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
		return ground.defaultBlockState().is(BlockTags.DIRT) || ground instanceof GrassBlock || ground.defaultBlockState().is(BlockTags.SAND)
				|| ground == Blocks.GRAVEL || ground == Blocks.CLAY || ground == Blocks.MOSS_BLOCK;
	}

	@Override
	public void neighborChanged(BlockState state, Level world, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		if (!canSurvive(state, world, pos)) {
			if (state.getValue(WATERLOGGED)) {
				LevelUtils.setBlock(world, pos, Blocks.WATER.defaultBlockState(), 2);
			} else {
				world.destroyBlock(pos, false);
			}
		}
		if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
			BlockState stateUpper = world.getBlockState(pos.above());
			if (stateUpper.getBlock() instanceof DoubleHighWaterPlantBlock) {
				if (!canSurvive(stateUpper, world, pos.above())) {
					world.destroyBlock(pos.above(), false);
				}
			}
		}
	}

	@Override
	public void playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {
		DoubleBlockHalf doubleblockhalf = state.getValue(HALF);
		BlockPos blockpos = doubleblockhalf == DoubleBlockHalf.LOWER ? pos.above() : pos.below();
		BlockState blockstate = world.getBlockState(blockpos);
		if (blockstate.getBlock() == this && blockstate.getValue(HALF) != doubleblockhalf) {
			if (blockstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
				if (blockstate.getValue(WATERLOGGED)) {
					LevelUtils.setBlock(world, blockpos, Blocks.WATER.defaultBlockState(), 2);
				} else {
					LevelUtils.setBlock(world, blockpos, Blocks.AIR.defaultBlockState(), 35);
				}
			}

			world.levelEvent(player, 2001, blockpos, Block.getId(blockstate));
			if (!world.isClientSide && !player.isCreative()) {
				dropResources(state, world, pos, (BlockEntity) null, player, player.getMainHandItem());
			}
		}
		world.levelEvent(player, 2001, pos, Block.getId(state));
	}
	
	public void placeInWater(LevelAccessor worldIn, BlockPos pos, int flags) {
		LevelUtils.setBlock(worldIn, pos, this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, true), flags);
		LevelUtils.setBlock(worldIn, pos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER), flags);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}

		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context) {
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
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(HALF, WATERLOGGED);
	}
}