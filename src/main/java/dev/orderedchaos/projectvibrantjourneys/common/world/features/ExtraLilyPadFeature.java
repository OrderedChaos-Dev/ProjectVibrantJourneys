package dev.orderedchaos.projectvibrantjourneys.common.world.features;

import com.mojang.serialization.Codec;
import dev.orderedchaos.projectvibrantjourneys.util.LevelUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;

public class ExtraLilyPadFeature extends Feature<ProbabilityFeatureConfiguration> {

  public ExtraLilyPadFeature(Codec<ProbabilityFeatureConfiguration> codec) {
    super(codec);
  }

  @Override
  public boolean place(FeaturePlaceContext<ProbabilityFeatureConfiguration> context) {
    ProbabilityFeatureConfiguration config = context.config();
    WorldGenLevel level = context.level();
    BlockPos origin = context.origin();
    BlockState blockstate = Blocks.LILY_PAD.defaultBlockState();

    if (level.getBlockState(origin.below()).is(Blocks.ICE)) {
      return false;
    }

    if (context.random().nextFloat() < config.probability && level.getBlockState(origin.below()).is(Blocks.WATER)) {
      int surfaceY = level.getHeight(Heightmap.Types.WORLD_SURFACE, origin.getX(), origin.getZ());
      int oceanFloorY = level.getHeight(Heightmap.Types.OCEAN_FLOOR, origin.getX(), origin.getZ());
      int waterDepth = surfaceY - oceanFloorY;

      if (waterDepth <= 3) {
        return LevelUtils.setBlock(level, origin, blockstate, 2);
      } else {
        return false;
      }
    } else {
      return false;
    }
  }
}