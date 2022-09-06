package com.projectvibrantjourneys.common.blocks;

import java.util.Optional;
import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.projectvibrantjourneys.core.registry.PVJBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CauldronBlock;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class IcicleBlock extends Block implements Fallable {
	public static final DirectionProperty TIP_DIRECTION = BlockStateProperties.VERTICAL_DIRECTION;
	public static final EnumProperty<DripstoneThickness> THICKNESS = BlockStateProperties.DRIPSTONE_THICKNESS;
	private static final VoxelShape TIP_MERGE_SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
	private static final VoxelShape TIP_SHAPE_UP = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D);
	private static final VoxelShape TIP_SHAPE_DOWN = Block.box(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D);
	private static final VoxelShape FRUSTUM_SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
	private static final VoxelShape MIDDLE_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
	private static final VoxelShape BASE_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
	private static final VoxelShape REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);

	public IcicleBlock() {
		super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.ICE).noOcclusion().sound(SoundType.GLASS).randomTicks().strength(1.5F, 3.0F).dynamicShape());
		this.registerDefaultState(this.stateDefinition.any().setValue(TIP_DIRECTION, Direction.UP).setValue(THICKNESS, DripstoneThickness.TIP));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(TIP_DIRECTION, THICKNESS);
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
		return isValidPointedDripstonePlacement(level, pos, state.getValue(TIP_DIRECTION));
	}

	@Override
	public BlockState updateShape(BlockState state, Direction dir, BlockState state2, LevelAccessor level, BlockPos pos, BlockPos pos2) {
		if (dir != Direction.UP && dir != Direction.DOWN) {
			return state;
		} else {
			Direction direction = state.getValue(TIP_DIRECTION);
			if (direction == Direction.DOWN && level.getBlockTicks().hasScheduledTick(pos, this)) {
				return state;
			} else if (dir == direction.getOpposite() && !this.canSurvive(state, level, pos)) {
				if (direction == Direction.DOWN) {
					level.scheduleTick(pos, this, 2);
				} else {
					level.scheduleTick(pos, this, 1);
				}

				return state;
			} else {
				boolean flag = state.getValue(THICKNESS) == DripstoneThickness.TIP_MERGE;
				DripstoneThickness dripstonethickness = calculateDripstoneThickness(level, pos, direction, flag);
				return state.setValue(THICKNESS, dripstonethickness);
			}
		}
	}

	@Override
	public void onProjectileHit(Level level, BlockState pos, BlockHitResult result, Projectile projectile) {
		BlockPos blockpos = result.getBlockPos();
		if (!level.isClientSide && projectile.mayInteract(level, blockpos) && projectile instanceof ThrownTrident && projectile.getDeltaMovement().length() > 0.6D) {
			level.destroyBlock(blockpos, true);
		}

	}

	@Override
	public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float height) {
		if (state.getValue(TIP_DIRECTION) == Direction.UP && state.getValue(THICKNESS) == DripstoneThickness.TIP) {
			entity.causeFallDamage(height + 2.0F, 2.0F, DamageSource.STALAGMITE);
		} else {
			super.fallOn(level, state, pos, entity, height);
		}

	}

	@Override
	public void animateTick(BlockState state, Level level, BlockPos pos, Random random) {
		if (level.getBrightness(LightLayer.BLOCK, pos) > 11 - state.getLightBlock(level, pos) || level.getBiome(pos).value().shouldSnowGolemBurn(pos)) {
			if (canDrip(state)) {
				spawnDripParticle(level, pos, state);
			}
		}
	}

	@Override
	public void tick(BlockState p_154107_, ServerLevel p_154108_, BlockPos p_154109_, Random p_154110_) {
		if (isStalagmite(p_154107_) && !this.canSurvive(p_154107_, p_154108_, p_154109_)) {
			p_154108_.destroyBlock(p_154109_, true);
		} else {
			spawnFallingStalactite(p_154107_, p_154108_, p_154109_);
		}

	}

	@Override
	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
		if (level.getBrightness(LightLayer.BLOCK, pos) > 11 - state.getLightBlock(level, pos) || level.getBiome(pos).value().shouldSnowGolemBurn(pos)) {
			level.destroyBlock(pos, true);
			for(int i = 0; i < 10; i++) {
				spawnDripParticle(level, pos, state);
			}
			BlockPos blockpos = findTip(state, level, pos, 11, false);
			BlockPos cauldronPos = findFillableCauldronBelowStalactiteTip(level, blockpos);
			if(cauldronPos != null) {
				BlockState cauldron = level.getBlockState(cauldronPos);
				if(cauldron.getBlock() instanceof CauldronBlock) {
					level.setBlockAndUpdate(cauldronPos, Blocks.WATER_CAULDRON.defaultBlockState());
				} else if(cauldron.getBlock() == Blocks.WATER_CAULDRON) {
					if(!((LayeredCauldronBlock)cauldron.getBlock()).isFull(cauldron)) {
						level.setBlockAndUpdate(cauldronPos, cauldron.setValue(LayeredCauldronBlock.LEVEL, Integer.valueOf(cauldron.getValue(LayeredCauldronBlock.LEVEL) + 1)));
					}
				}
			}
		}
	}
	
	@Nullable
	private static BlockPos findFillableCauldronBelowStalactiteTip(Level level, BlockPos pos) {
		Predicate<BlockState> predicate = (state) -> {
			return state.getBlock() == Blocks.CAULDRON || state.getBlock() == Blocks.WATER_CAULDRON;
		};
		BiPredicate<BlockPos, BlockState> bipredicate = (blockpos, state) -> {
			return canDripThrough(level, blockpos, state);
		};
		return findBlockVertical(level, pos, Direction.DOWN.getAxisDirection(), bipredicate, predicate, 11).orElse((BlockPos)null);
	}

	@Override
	public PushReaction getPistonPushReaction(BlockState state) {
		return PushReaction.DESTROY;
	}

	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		LevelAccessor levelaccessor = context.getLevel();
		BlockPos blockpos = context.getClickedPos();
		Direction direction = context.getNearestLookingVerticalDirection().getOpposite();
		Direction direction1 = calculateTipDirection(levelaccessor, blockpos, direction);
		if (direction1 == null) {
			return null;
		} else {
			boolean flag = !context.isSecondaryUseActive();
			DripstoneThickness dripstonethickness = calculateDripstoneThickness(levelaccessor, blockpos, direction1, flag);
			return dripstonethickness == null ? null : this.defaultBlockState().setValue(TIP_DIRECTION, direction1).setValue(THICKNESS, dripstonethickness);
		}
	}

	@Override
	public VoxelShape getOcclusionShape(BlockState state, BlockGetter level, BlockPos pos) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		DripstoneThickness dripstonethickness = state.getValue(THICKNESS);
		VoxelShape voxelshape;
		if (dripstonethickness == DripstoneThickness.TIP_MERGE) {
			voxelshape = TIP_MERGE_SHAPE;
		} else if (dripstonethickness == DripstoneThickness.TIP) {
			if (state.getValue(TIP_DIRECTION) == Direction.DOWN) {
				voxelshape = TIP_SHAPE_DOWN;
			} else {
				voxelshape = TIP_SHAPE_UP;
			}
		} else if (dripstonethickness == DripstoneThickness.FRUSTUM) {
			voxelshape = FRUSTUM_SHAPE;
		} else if (dripstonethickness == DripstoneThickness.MIDDLE) {
			voxelshape = MIDDLE_SHAPE;
		} else {
			voxelshape = BASE_SHAPE;
		}

		Vec3 vec3 = state.getOffset(level, pos);
		return voxelshape.move(vec3.x, 0.0D, vec3.z);
	}

	@Override
	public boolean isCollisionShapeFullBlock(BlockState state, BlockGetter level, BlockPos pos) {
		return false;
	}

	@Override
	public BlockBehaviour.OffsetType getOffsetType() {
		return BlockBehaviour.OffsetType.XZ;
	}

	@Override
	public float getMaxHorizontalOffset() {
		return 0.125F;
	}

	@Override
	public void onBrokenAfterFall(Level level, BlockPos pos, FallingBlockEntity entity) {
		if (!entity.isSilent()) {
			level.levelEvent(1045, pos, 0);
		}

	}

	@Override
	public DamageSource getFallDamageSource() {
		return DamageSource.FALLING_STALACTITE;
	}

	@Override
	public Predicate<Entity> getHurtsEntitySelector() {
		return EntitySelector.NO_CREATIVE_OR_SPECTATOR.and(EntitySelector.LIVING_ENTITY_STILL_ALIVE);
	}

	private static void spawnFallingStalactite(BlockState state, ServerLevel level, BlockPos pos) {
		BlockPos.MutableBlockPos blockpos$mutableblockpos = pos.mutable();

		for(BlockState blockstate = state; isStalactite(blockstate); blockstate = level.getBlockState(blockpos$mutableblockpos)) {
			FallingBlockEntity fallingblockentity = FallingBlockEntity.fall(level, blockpos$mutableblockpos, blockstate);
			if (isTip(blockstate, true)) {
				int i = Math.max(1 + pos.getY() - blockpos$mutableblockpos.getY(), 6);
				float f = 1.0F * (float)i;
				fallingblockentity.setHurtsEntities(f, 40);
				break;
			}

			blockpos$mutableblockpos.move(Direction.DOWN);
		}

	}

	private static void spawnDripParticle(Level level, BlockPos pos, BlockState state) {
		Vec3 vec3 = state.getOffset(level, pos);
		double d1 = (double)pos.getX() + 0.5D + vec3.x;
		double d2 = (double)((float)(pos.getY() + 1) - 0.6875F) - 0.0625D;
		double d3 = (double)pos.getZ() + 0.5D + vec3.z;
		ParticleOptions particleoptions = ParticleTypes.DRIPPING_DRIPSTONE_WATER;
		level.addParticle(particleoptions, d1, d2, d3, 0.0D, 0.0D, 0.0D);
	}

	@Nullable
	private static BlockPos findTip(BlockState state, LevelAccessor level, BlockPos pos, int p_154134_, boolean p_154135_) {
		if (isTip(state, p_154135_)) {
			return pos;
		} else {
			Direction direction = state.getValue(TIP_DIRECTION);
			BiPredicate<BlockPos, BlockState> bipredicate = (p_202023_, p_202024_) -> {
				return p_202024_.is(PVJBlocks.ICICLE.get()) && p_202024_.getValue(TIP_DIRECTION) == direction;
			};
			return findBlockVertical(level, pos, direction.getAxisDirection(), bipredicate, (p_154168_) -> {
				return isTip(p_154168_, p_154135_);
			}, p_154134_).orElse((BlockPos)null);
		}
	}

	@Nullable
	private static Direction calculateTipDirection(LevelReader level, BlockPos pos, Direction dir) {
		Direction direction;
		if (isValidPointedDripstonePlacement(level, pos, dir)) {
			direction = dir;
		} else {
			if (!isValidPointedDripstonePlacement(level, pos, dir.getOpposite())) {
				return null;
			}

			direction = dir.getOpposite();
		}

		return direction;
	}

	private static DripstoneThickness calculateDripstoneThickness(LevelReader level, BlockPos pos, Direction dir, boolean p_154096_) {
		Direction direction = dir.getOpposite();
		BlockState blockstate = level.getBlockState(pos.relative(dir));
		if (isPointedDripstoneWithDirection(blockstate, direction)) {
			return !p_154096_ && blockstate.getValue(THICKNESS) != DripstoneThickness.TIP_MERGE ? DripstoneThickness.TIP : DripstoneThickness.TIP_MERGE;
		} else if (!isPointedDripstoneWithDirection(blockstate, dir)) {
			return DripstoneThickness.TIP;
		} else {
			DripstoneThickness dripstonethickness = blockstate.getValue(THICKNESS);
			if (dripstonethickness != DripstoneThickness.TIP && dripstonethickness != DripstoneThickness.TIP_MERGE) {
				BlockState blockstate1 = level.getBlockState(pos.relative(direction));
				return !isPointedDripstoneWithDirection(blockstate1, dir) ? DripstoneThickness.BASE : DripstoneThickness.MIDDLE;
			} else {
				return DripstoneThickness.FRUSTUM;
			}
		}
	}

	public static boolean canDrip(BlockState state) {
		return isStalactite(state) && state.getValue(THICKNESS) == DripstoneThickness.TIP;
	}

	private static boolean isValidPointedDripstonePlacement(LevelReader level, BlockPos pos, Direction dir) {
		BlockPos blockpos = pos.relative(dir.getOpposite());
		BlockState blockstate = level.getBlockState(blockpos);
		return blockstate.isFaceSturdy(level, blockpos, dir) || isPointedDripstoneWithDirection(blockstate, dir);
	}

	private static boolean isTip(BlockState state, boolean p_154155_) {
		if (!state.is(PVJBlocks.ICICLE.get())) {
			return false;
		} else {
			DripstoneThickness dripstonethickness = state.getValue(THICKNESS);
			return dripstonethickness == DripstoneThickness.TIP || p_154155_ && dripstonethickness == DripstoneThickness.TIP_MERGE;
		}
	}

	private static boolean isStalactite(BlockState state) {
		return isPointedDripstoneWithDirection(state, Direction.DOWN);
	}

	private static boolean isStalagmite(BlockState state) {
		return isPointedDripstoneWithDirection(state, Direction.UP);
	}

	private static boolean isStalactiteStartPos(BlockState state, LevelReader level, BlockPos pos) {
		return isStalactite(state) && !level.getBlockState(pos.above()).is(PVJBlocks.ICICLE.get());
	}

	@Override
	public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
		return false;
	}

	private static boolean isPointedDripstoneWithDirection(BlockState state, Direction dir) {
		return state.is(PVJBlocks.ICICLE.get()) && state.getValue(TIP_DIRECTION) == dir;
	}

	@Nullable
	public static BlockPos findStalactiteTipAboveCauldron(Level level, BlockPos pos) {
		BiPredicate<BlockPos, BlockState> bipredicate = (p_202030_, p_202031_) -> {
			return canDripThrough(level, p_202030_, p_202031_);
		};
		return findBlockVertical(level, pos, Direction.UP.getAxisDirection(), bipredicate, IcicleBlock::canDrip, 11).orElse((BlockPos)null);
	}

	private static Optional<BlockPos> findBlockVertical(LevelAccessor level, BlockPos pos, Direction.AxisDirection dir, BiPredicate<BlockPos, BlockState> p_202010_, Predicate<BlockState> p_202011_, int p_202012_) {
		Direction direction = Direction.get(dir, Direction.Axis.Y);
		BlockPos.MutableBlockPos blockpos$mutableblockpos = pos.mutable();

		for(int i = 1; i < p_202012_; ++i) {
			blockpos$mutableblockpos.move(direction);
			BlockState blockstate = level.getBlockState(blockpos$mutableblockpos);
			if (p_202011_.test(blockstate)) {
				return Optional.of(blockpos$mutableblockpos.immutable());
			}

			if (level.isOutsideBuildHeight(blockpos$mutableblockpos.getY()) || !p_202010_.test(blockpos$mutableblockpos, blockstate)) {
				return Optional.empty();
			}
		}

		return Optional.empty();
	}

	private static boolean canDripThrough(BlockGetter level, BlockPos pos, BlockState state) {
		if (state.isAir()) {
			return true;
		} else if (state.isSolidRender(level, pos)) {
			return false;
		} else if (!state.getFluidState().isEmpty()) {
			return false;
		} else {
			VoxelShape voxelshape = state.getCollisionShape(level, pos);
			return !Shapes.joinIsNotEmpty(REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK, voxelshape, BooleanOp.AND);
		}
	}
}