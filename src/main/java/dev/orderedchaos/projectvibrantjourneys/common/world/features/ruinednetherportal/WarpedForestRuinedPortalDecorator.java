package dev.orderedchaos.projectvibrantjourneys.common.world.features.ruinednetherportal;

import dev.orderedchaos.projectvibrantjourneys.core.util.LevelUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.NetherFeatures;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class WarpedForestRuinedPortalDecorator extends RuinedPortalDecoratorBase {

  public WarpedForestRuinedPortalDecorator() {
    super("warped_forest_ruined_portal_decorator");
  }

  @Nullable
  @Override
  public BlockState getTopSoil(WorldGenLevel level, RandomSource random) {
    float chance = random.nextFloat();
    if (chance <= 0.75F) {
      return Blocks.WARPED_NYLIUM.defaultBlockState();
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
  public void decorate(WorldGenLevel level, ChunkGenerator generator, RandomSource random, BlockPos groundPos) {
    BlockPos pos = groundPos.above();
    if (LevelUtils.isEmptyOrReplaceable(level, pos)) {
      float chance = random.nextFloat();
      if (chance < 0.02F) {
        Optional<? extends Holder<ConfiguredFeature<?, ?>>> bigMushroom = level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolder(TreeFeatures.WARPED_FUNGUS);
        bigMushroom.ifPresent((feature) -> feature.value().place(level, generator, random, pos));
      } else if (chance < 0.15F) {
        Optional<? extends Holder<ConfiguredFeature<?, ?>>> warpedForestVegetation = level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolder(NetherFeatures.WARPED_FOREST_VEGETION);
        warpedForestVegetation.ifPresent((feature) -> feature.value().place(level, generator, random, pos));
      } else if (chance < 0.16F) {
        Optional<? extends Holder<ConfiguredFeature<?, ?>>> twistingVines = level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolder(NetherFeatures.TWISTING_VINES_BONEMEAL);
        twistingVines.ifPresent((feature) -> feature.value().place(level, generator, random, pos));
      }
    }
  }
}
