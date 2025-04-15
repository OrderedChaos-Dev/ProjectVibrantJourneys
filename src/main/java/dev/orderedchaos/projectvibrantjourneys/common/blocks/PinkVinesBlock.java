package dev.orderedchaos.projectvibrantjourneys.common.blocks;

import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PinkVinesBlock extends GrowingPlantHeadBlock {

  private static final VoxelShape SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);

  public PinkVinesBlock(BlockBehaviour.Properties props) {
    super(props, Direction.DOWN, SHAPE, false, 0);
    this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
  }

  @Override
  protected Block getBodyBlock() {
    return PVJBlocks.PINK_VINES_PLANT.get();
  }

  @Override
  protected int getBlocksToGrowWhenBonemealed(RandomSource randomSource) {
    return 1;
  }

  @Override
  protected boolean canGrowInto(BlockState p_152998_) {
    return p_152998_.isAir();
  }

  @Override
  public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
    BlockPos blockpos = pPos.relative(this.growthDirection.getOpposite());
    BlockState blockstate = pLevel.getBlockState(blockpos);
    return blockstate.is(this.getHeadBlock()) || blockstate.is(this.getBodyBlock()) || blockstate.is(BlockTags.LEAVES);
  }

  @Override
  public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource randomSource) {
    super.animateTick(state, level, pos, randomSource);
    if (randomSource.nextInt(10) == 0) {
      BlockPos blockpos = pos.below();
      BlockState blockstate = level.getBlockState(blockpos);
      if (!isFaceFull(blockstate.getCollisionShape(level, blockpos), Direction.UP)) {
        ParticleUtils.spawnParticleBelow(level, pos, randomSource, ParticleTypes.CHERRY_LEAVES);
      }
    }
  }
}