package dev.orderedchaos.projectvibrantjourneys.common.world.features.ruinednetherportal;

import dev.orderedchaos.projectvibrantjourneys.core.util.LevelUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import org.jetbrains.annotations.Nullable;

public class BasaltDeltasRuinedPortalDecorator extends RuinedPortalDecoratorBase {

  public BasaltDeltasRuinedPortalDecorator() {
    super("basalt_deltas_ruined_portal_decorator");
  }

  @Nullable
  @Override
  public BlockState getTopSoil(WorldGenLevel level, RandomSource random) {
    float oreChance = random.nextFloat();
    if (oreChance < 0.45F) {
      return Blocks.BASALT.defaultBlockState();
    } else if (oreChance < 0.9F) {
      return Blocks.BLACKSTONE.defaultBlockState();
    }
    return Blocks.MAGMA_BLOCK.defaultBlockState();
  }

  @Nullable
  @Override
  public BlockState getFillerSoil(WorldGenLevel level, RandomSource random) {
    return Blocks.BASALT.defaultBlockState();
  }

  @Override
  public void decorate(WorldGenLevel level, ChunkGenerator generator, RandomSource random, BlockPos groundPos) {
    float chance = random.nextFloat();
    if (chance < 0.8F) {
      if (level.getBlockState(groundPos).is(Blocks.BASALT)) {
        int height = 1 + random.nextInt(4);
        for (int i = 1; i <= height; i++) {
          BlockPos pos = groundPos.above(i);
          if (LevelUtils.isEmptyOrReplaceable(level, pos)) {
            level.setBlock(pos, Blocks.BASALT.defaultBlockState(), 2);
          } else {
            break;
          }
        }
      }
    }
  }
}
