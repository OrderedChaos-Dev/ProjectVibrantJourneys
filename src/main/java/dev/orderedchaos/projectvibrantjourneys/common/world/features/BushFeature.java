package dev.orderedchaos.projectvibrantjourneys.common.world.features;

import com.mojang.serialization.Codec;
import dev.orderedchaos.projectvibrantjourneys.common.world.features.configurations.BushConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class BushFeature extends Feature<BushConfiguration> {
  public BushFeature(Codec<BushConfiguration> codec) {
    super(codec);
  }

  @Override
  public boolean place(FeaturePlaceContext<BushConfiguration> context) {
    WorldGenLevel world = context.level();
    BlockPos origin = context.origin();

    if (world.isEmptyBlock(origin)) {
      if (world.getBlockState(origin.below()).is(Blocks.GRASS_BLOCK) || world.getBlockState(origin.below()).is(BlockTags.DIRT)) {
        for (Direction dir : Direction.Plane.HORIZONTAL) {
          if (!world.getBlockState(origin.offset(dir.getNormal())).canBeReplaced()) {
            return false;
          }
        }
        world.setBlock(origin, context.config().log(), 2);
        for (Direction dir : Direction.Plane.HORIZONTAL) {
          world.setBlock(origin.offset(dir.getNormal()), context.config().leaves().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        world.setBlock(origin.above(), context.config().leaves().setValue(LeavesBlock.DISTANCE, 1), 2);
      }
    }
    return true;
  }


}