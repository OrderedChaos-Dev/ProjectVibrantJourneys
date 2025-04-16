package dev.orderedchaos.projectvibrantjourneys.common.world.features;

import com.mojang.serialization.Codec;
import dev.orderedchaos.projectvibrantjourneys.common.tags.PVJTags;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;

public class GroundcoverFeature extends Feature<RandomPatchConfiguration> {
  public GroundcoverFeature(Codec<RandomPatchConfiguration> codec) {
    super(codec);
  }

  public boolean place(FeaturePlaceContext<RandomPatchConfiguration> context) {
    RandomPatchConfiguration randompatchconfiguration = context.config();
    RandomSource randomsource = context.random();
    BlockPos blockpos = context.origin();
    WorldGenLevel worldgenlevel = context.level();
    int i = 0;
    BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
    int j = randompatchconfiguration.xzSpread() + 1;
    int k = randompatchconfiguration.ySpread() + 1;

    for(int l = 0; l < randompatchconfiguration.tries(); ++l) {
      blockpos$mutableblockpos.setWithOffset(blockpos, randomsource.nextInt(j) - randomsource.nextInt(j), randomsource.nextInt(k) - randomsource.nextInt(k), randomsource.nextInt(j) - randomsource.nextInt(j));
      if (!worldgenlevel.getBlockState(blockpos$mutableblockpos.below()).is(PVJTags.GROUNDCOVER_CANNOT_GENERATE_ON)) {
        if (randompatchconfiguration.feature().value().place(worldgenlevel, context.chunkGenerator(), randomsource, blockpos$mutableblockpos)) {
          if (worldgenlevel.getBlockState(blockpos$mutableblockpos.above()).hasProperty(BlockStateProperties.DOUBLE_BLOCK_HALF) && worldgenlevel.getBlockState(blockpos$mutableblockpos.above()).getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.UPPER) {
            worldgenlevel.removeBlock(blockpos$mutableblockpos.above(), false);
          }
          ++i;
        }
      }
    }

    return i > 0;
  }
}