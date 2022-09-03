package com.projectvibrantjourneys.common.blocks;

import java.util.Optional;
import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.projectvibrantjourneys.core.registry.PVJBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class IcicleBlock extends Block implements Fallable, SimpleWaterloggedBlock {
//	
//	public static final DirectionProperty TIP_DIRECTION = BlockStateProperties.VERTICAL_DIRECTION;
//	public static final EnumProperty<DripstoneThickness> THICKNESS = BlockStateProperties.DRIPSTONE_THICKNESS;
//	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
//	private static final VoxelShape REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);
//
	public IcicleBlock() {
		super(BlockBehaviour.Properties.of(Material.ICE, MaterialColor.ICE).noOcclusion().sound(SoundType.GLASS).randomTicks().strength(1.5F, 3.0F).dynamicShape());
	}
//
//	@Override
//	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
//		builder.add(TIP_DIRECTION, THICKNESS, WATERLOGGED);
//	}
//
//	@Override
//	public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
//		return isValidPlacement(level, pos, state.getValue(TIP_DIRECTION));
//	}
//	
//	private static boolean isValidPlacement(LevelReader level, BlockPos pos, Direction dir) {
//		BlockPos blockpos = pos.relative(dir.getOpposite());
//		BlockState blockstate = level.getBlockState(blockpos);
//		return blockstate.isFaceSturdy(level, blockpos, dir) || isIcicleWithDirection(blockstate, dir);
//	}
//	
//	private static boolean isIcicleWithDirection(BlockState p_154208_, Direction p_154209_) {
//		return p_154208_.is(PVJBlocks.ICICLE.get()) && p_154208_.getValue(TIP_DIRECTION) == p_154209_;
//	}
//	
//	@Nullable
//	private static BlockPos findFillableCauldronBelowTip(Level level, BlockPos pos, Fluid fluid) {
//		Predicate<BlockState> predicate = (state) -> {
//			return state.getBlock() instanceof AbstractCauldronBlock && ((AbstractCauldronBlock)state.getBlock()).canReceiveStalactiteDrip(fluid);
//		};
//		BiPredicate<BlockPos, BlockState> bipredicate = (blockpos, blockstate) -> {
//			return canDripThrough(level, blockpos, blockstate);
//		};
//		return findBlockVertical(level, pos, Direction.DOWN.getAxisDirection(), bipredicate, predicate, 11).orElse((BlockPos)null);
//	}
//
//	@Nullable
//	public static BlockPos findTipAboveCauldron(Level level, BlockPos pos) {
//		BiPredicate<BlockPos, BlockState> bipredicate = (blockpos, blockstate) -> {
//			return canDripThrough(level, blockpos, blockstate);
//		};
//		return findBlockVertical(level, pos, Direction.UP.getAxisDirection(), bipredicate, PointedDripstoneBlock::canDrip, 11).orElse((BlockPos)null);
//	}
//	
//	private static Optional<BlockPos> findBlockVertical(LevelAccessor level, BlockPos pos, Direction.AxisDirection axisDir, BiPredicate<BlockPos, BlockState> condition, Predicate<BlockState> blockCondition, int maxHeight) {
//		Direction direction = Direction.get(axisDir, Direction.Axis.Y);
//		BlockPos.MutableBlockPos blockpos$mutableblockpos = pos.mutable();
//
//		for(int i = 1; i < maxHeight; ++i) {
//			blockpos$mutableblockpos.move(direction);
//			BlockState blockstate = level.getBlockState(blockpos$mutableblockpos);
//			if (blockCondition.test(blockstate)) {
//				return Optional.of(blockpos$mutableblockpos.immutable());
//			}
//
//			if (level.isOutsideBuildHeight(blockpos$mutableblockpos.getY()) || !condition.test(blockpos$mutableblockpos, blockstate)) {
//				return Optional.empty();
//			}
//		}
//
//		return Optional.empty();
//	}
//
//	private static boolean canDripThrough(BlockGetter level, BlockPos pos, BlockState state) {
//		if (state.isAir()) {
//			return true;
//		} else if (state.isSolidRender(level, pos)) {
//			return false;
//		} else if (!state.getFluidState().isEmpty()) {
//			return false;
//		} else {
//			VoxelShape voxelshape = state.getCollisionShape(level, pos);
//			return !Shapes.joinIsNotEmpty(REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK, voxelshape, BooleanOp.AND);
//		}
//	}
//
//	@Override
//	public BlockState updateShape(BlockState state, Direction dir, BlockState state2, LevelAccessor level, BlockPos pos1, BlockPos pos2) {
//		if (state.getValue(WATERLOGGED)) {
//			level.scheduleTick(pos1, Fluids.WATER, Fluids.WATER.getTickDelay(level));
//		}
//
//		if (dir != Direction.UP && dir != Direction.DOWN) {
//			return state;
//		} else {
//			Direction direction = state.getValue(TIP_DIRECTION);
//			if (direction == Direction.DOWN && level.getBlockTicks().hasScheduledTick(pos1, this)) {
//				return state;
//			} else if (dir == direction.getOpposite() && !this.canSurvive(state, level, pos1)) {
//				if (direction == Direction.DOWN) {
//					level.scheduleTick(pos1, this, 2);
//				} else {
//					level.scheduleTick(pos1, this, 1);
//				}
//
//				return state;
//			} else {
//				boolean flag = state.getValue(THICKNESS) == DripstoneThickness.TIP_MERGE;
//				DripstoneThickness dripstonethickness = calculateDripstoneThickness(level, pos1, direction, flag);
//				return state.setValue(THICKNESS, dripstonethickness);
//			}
//		}
//	}
//
//	@Override
//	public void onProjectileHit(Level level, BlockState state, BlockHitResult result, Projectile projectile) {
//		BlockPos blockpos = result.getBlockPos();
//		if (!level.isClientSide && projectile.mayInteract(level, blockpos) && projectile instanceof ThrownTrident && projectile.getDeltaMovement().length() > 0.6D) {
//			level.destroyBlock(blockpos, true);
//		}
//	}
//
//	@Override
//	public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float height) {
//		if (state.getValue(TIP_DIRECTION) == Direction.UP && state.getValue(THICKNESS) == DripstoneThickness.TIP) {
//			entity.causeFallDamage(height + 2.0F, 2.0F, DamageSource.STALAGMITE);
//		} else {
//			super.fallOn(level, state, pos, entity, height);
//		}
//	}
//	
//	private static DripstoneThickness calculateDripstoneThickness(LevelReader level, BlockPos pos, Direction dir, boolean b) {
//		Direction direction = dir.getOpposite();
//		BlockState blockstate = level.getBlockState(pos.relative(dir));
//		if (isIcicleWithDirection(blockstate, direction)) {
//			return !b && blockstate.getValue(THICKNESS) != DripstoneThickness.TIP_MERGE ? DripstoneThickness.TIP : DripstoneThickness.TIP_MERGE;
//		} else if (!isIcicleWithDirection(blockstate, dir)) {
//			return DripstoneThickness.TIP;
//		} else {
//			DripstoneThickness dripstonethickness = blockstate.getValue(THICKNESS);
//			if (dripstonethickness != DripstoneThickness.TIP && dripstonethickness != DripstoneThickness.TIP_MERGE) {
//				BlockState blockstate1 = level.getBlockState(pos.relative(direction));
//				return !isIcicleWithDirection(blockstate1, dir) ? DripstoneThickness.BASE : DripstoneThickness.MIDDLE;
//			} else {
//				return DripstoneThickness.FRUSTUM;
//			}
//		}
//	}
//
//	//melt behavior
//	@Override
//	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
//		if (level.getBrightness(LightLayer.BLOCK, pos) > 11 - state.getLightBlock(level, pos)) {
//			this.melt(state, level, pos);
//			
//		}
//	}
//
//	protected void melt(BlockState state, Level level, BlockPos pos) {
//		if (level.dimensionType().ultraWarm()) {
//			level.removeBlock(pos, false);
//		} else {
//			level.setBlockAndUpdate(pos, Blocks.WATER.defaultBlockState());
//			level.neighborChanged(pos, Blocks.WATER, pos);
//		}
//	}
}
