package dev.orderedchaos.projectvibrantjourneys.common.world.features.ruinednetherportal;

import dev.orderedchaos.projectvibrantjourneys.common.util.LevelUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.features.NetherFeatures;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import org.jetbrains.annotations.Nullable;

public class SoulSandValleyRuinedPortalDecorator extends RuinedPortalDecoratorBase {

  public SoulSandValleyRuinedPortalDecorator() {
    super("soul_sand_valley_ruined_portal_decorator");
  }

  @Nullable
  @Override
  public BlockState getTopSoil(WorldGenLevel level, RandomSource random) {
    float oreChance = random.nextFloat();
    if (oreChance < 0.5F) {
      return Blocks.SOUL_SAND.defaultBlockState();
    }
    return Blocks.SOUL_SOIL.defaultBlockState();
  }

  @Nullable
  @Override
  public BlockState getFillerSoil(WorldGenLevel level, RandomSource random) {
    return Blocks.SOUL_SAND.defaultBlockState();
  }

  @Override
  public void decorate(WorldGenLevel level, ChunkGenerator generator, RandomSource random, BlockPos groundPos) {
    float chance = random.nextFloat();
    if (chance < 0.15F) {
      level.setBlock(groundPos.above(), Blocks.SOUL_FIRE.defaultBlockState(), 2);
    } else if (chance < 0.18F) {
      int height = 3 + random.nextInt(3);
      boolean placeExtraBlock = false;
      for (int i = 1; i <= height; i++) {
        BlockPos pos = groundPos.above(i);
        if (LevelUtils.isEmptyOrReplaceable(level, pos)) {
          level.setBlock(pos, Blocks.BONE_BLOCK.defaultBlockState(), 2);
          if (i == height) { // if the loop completed without reaching break statement
            placeExtraBlock = random.nextBoolean();
          }
        } else {
          break;
        }
      }
      if (placeExtraBlock) {
        Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
        BlockPos pos = groundPos.above(height).offset(direction.getNormal()).above(random.nextBoolean() ? 1 : 0);
        if (LevelUtils.isEmptyOrReplaceable(level, pos)) {
          level.setBlock(pos, Blocks.BONE_BLOCK.defaultBlockState(), 2);
        }
      }
    }
  }
}
