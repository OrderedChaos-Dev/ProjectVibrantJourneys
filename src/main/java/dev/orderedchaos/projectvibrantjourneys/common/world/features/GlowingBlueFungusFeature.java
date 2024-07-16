package dev.orderedchaos.projectvibrantjourneys.common.world.features;

import com.mojang.serialization.Codec;
import dev.orderedchaos.projectvibrantjourneys.common.blocks.BarkMushroomBlock;
import dev.orderedchaos.projectvibrantjourneys.common.blocks.GlowingFungusBlock;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class GlowingBlueFungusFeature extends Feature<NoneFeatureConfiguration> {

  public GlowingBlueFungusFeature(Codec<NoneFeatureConfiguration> codec) {
    super(codec);
  }

  @Override
  public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
    RandomSource randomSource = context.random();
    BlockPos origin = context.origin();
    WorldGenLevel level = context.level();
    BlockPos.MutableBlockPos mutable = origin.mutable();
    GlowingFungusBlock blockToPlace = (GlowingFungusBlock) PVJBlocks.GLOWING_BLUE_FUNGUS.get();
    int count = 0;

    for (int i = -64; i < origin.getY(); i++) {
      mutable.set(origin);
      mutable.move(randomSource.nextInt(4) - randomSource.nextInt(4), 0, randomSource.nextInt(4) - randomSource.nextInt(4));
      mutable.setY(i);
      if (blockToPlace.canAttachTo(level, mutable, Direction.DOWN)) {
        boolean flag = false;
        while (!flag) {
          Direction dir = Direction.Plane.HORIZONTAL.getRandomDirection(randomSource);
          if (level.isEmptyBlock(mutable.offset(dir.getNormal())) && level.getBlockState(mutable).isCollisionShapeFullBlock(level, mutable)) {
            if (level.setBlock(mutable.offset(dir.getNormal()), blockToPlace.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, dir), 2)) {
              count++;
            }
          }

          if (randomSource.nextFloat() < 0.8F) {
            flag = true;
          }
        }
      }
    }

    return count > 0;
  }
}
