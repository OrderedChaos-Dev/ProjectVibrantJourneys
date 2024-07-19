package dev.orderedchaos.projectvibrantjourneys.common.blocks;

import com.mojang.serialization.MapCodec;
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
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PinkVinesPlantBlock extends GrowingPlantBodyBlock {

  private static final VoxelShape SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);
  public static final MapCodec<PinkVinesPlantBlock> CODEC = simpleCodec(PinkVinesPlantBlock::new);

  @Override
  public MapCodec<PinkVinesPlantBlock> codec() {
    return CODEC;
  }

  public PinkVinesPlantBlock(BlockBehaviour.Properties props) {
    super(props, Direction.DOWN, SHAPE, false);
    this.registerDefaultState(this.stateDefinition.any());
  }

  @Override
  protected GrowingPlantHeadBlock getHeadBlock() {
    return (GrowingPlantHeadBlock) PVJBlocks.PINK_VINES.get();
  }

  @Override
  protected boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
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
