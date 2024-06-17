package dev.orderedchaos.projectvibrantjourneys.common.world.features.ruinednetherportal;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import org.jetbrains.annotations.Nullable;

public class NetherWastesRuinedPortalDecorator extends RuinedPortalDecoratorBase {

  public NetherWastesRuinedPortalDecorator() {
    super("nether_wastes_ruined_portal_decorator");
  }

  @Nullable
  @Override
  public BlockState getTopSoil(WorldGenLevel level, RandomSource random) {
    float oreChance = random.nextFloat();
    if (oreChance <= 0.03F) {
      return Blocks.NETHER_QUARTZ_ORE.defaultBlockState();
    } else if (oreChance <= 0.05F) {
      return Blocks.NETHER_GOLD_ORE.defaultBlockState();
    }
    return null;
  }

  @Nullable
  @Override
  public BlockState getFillerSoil(WorldGenLevel level, RandomSource random) {
    float oreChance = random.nextFloat();
    if (oreChance <= 0.03F) {
      return Blocks.NETHER_QUARTZ_ORE.defaultBlockState();
    } else if (oreChance <= 0.05F) {
      return Blocks.NETHER_GOLD_ORE.defaultBlockState();
    }
    return null;
  }

  @Override
  public void decorate(WorldGenLevel level, ChunkGenerator generator, RandomSource random, BlockPos groundPos) {}
}
