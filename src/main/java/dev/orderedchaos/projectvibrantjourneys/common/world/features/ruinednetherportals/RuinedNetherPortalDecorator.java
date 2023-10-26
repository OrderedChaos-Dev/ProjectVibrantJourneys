package dev.orderedchaos.projectvibrantjourneys.common.world.features.ruinednetherportals;

import dev.orderedchaos.projectvibrantjourneys.util.LevelUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;

public abstract class RuinedNetherPortalDecorator {

  public static final List<RuinedNetherPortalDecorator> PORTAL_DECORATORS = new ArrayList<>();

  public static void registerPortalDecorators() {
    PORTAL_DECORATORS.add(new NetherWastesPortalDecorator());
    PORTAL_DECORATORS.add(new SoulSandValleyPortalDecorator());
    PORTAL_DECORATORS.add(new BasaltDeltasPortalDecorator());
    PORTAL_DECORATORS.add(new WarpedForestPortalDecorator());
    PORTAL_DECORATORS.add(new CrimsonForestPortalDecorator());
  }

  public abstract BlockState getTopSoil(WorldGenLevel level, RandomSource randomSource);
  public abstract void decorate(WorldGenLevel level, RandomSource randomSource, BlockPos pos);

  public static RuinedNetherPortalDecorator getRandomDecorator(RandomSource randomSource) {
    int random = randomSource.nextInt(PORTAL_DECORATORS.size());
    return PORTAL_DECORATORS.get(random);
  }

  private static class NetherWastesPortalDecorator extends RuinedNetherPortalDecorator {

    @Override
    public BlockState getTopSoil(WorldGenLevel level, RandomSource randomSource) {
      float random = randomSource.nextFloat();
      if(random <= 0.03F) {
        return Blocks.NETHER_QUARTZ_ORE.defaultBlockState();
      } else if(random <= 0.05F) {
        return Blocks.NETHER_GOLD_ORE.defaultBlockState();
      }
      return null;
    }

    @Override
    public void decorate(WorldGenLevel level, RandomSource randomSource, BlockPos pos) {}
  }

  private static class SoulSandValleyPortalDecorator extends RuinedNetherPortalDecorator {

    @Override
    public BlockState getTopSoil(WorldGenLevel level, RandomSource randomSource) {
      if(randomSource.nextFloat() < 0.75F) {
        return Blocks.SOUL_SAND.defaultBlockState();
      }
      return null;
    }

    @Override
    public void decorate(WorldGenLevel level, RandomSource randomSource, BlockPos pos) {
      if (randomSource.nextFloat() < 0.4F) {
        LevelUtils.setBlock(level, pos.above(), Blocks.SOUL_FIRE.defaultBlockState(), 3);
      } else if (randomSource.nextFloat() < 0.05F) {
        int height = randomSource.nextInt(3) + 2;
        for (int i = 1; i <= height; i++) {
          if (level.isEmptyBlock(pos.above(i)) || level.getBlockState(pos.above(i)).canBeReplaced()) {
            LevelUtils.setBlock(level, pos.above(i), Blocks.BONE_BLOCK.defaultBlockState(), 3);
          } else {
            break;
          }
        }
      }
    }
  }

  private static class BasaltDeltasPortalDecorator extends RuinedNetherPortalDecorator {

    @Override
    public BlockState getTopSoil(WorldGenLevel level, RandomSource randomSource) {
      float random = randomSource.nextFloat();
      if(random < 0.33F) {
        return Blocks.BLACKSTONE.defaultBlockState();
      } else if(random < 0.666F) {
        return Blocks.BASALT.defaultBlockState();
      }
      return null;
    }

    @Override
    public void decorate(WorldGenLevel level, RandomSource randomSource, BlockPos pos) {
      if(randomSource.nextFloat() < 0.33F) {
        int height = randomSource.nextInt(3) + 1;
        for (int i = 1; i <= height; i++) {
          if (level.isEmptyBlock(pos.above(i)) || level.getBlockState(pos.above(i)).canBeReplaced()) {
            LevelUtils.setBlock(level, pos.above(i), Blocks.BASALT.defaultBlockState(), 3);
          } else {
            break;
          }
        }
      }
    }
  }

  private static class WarpedForestPortalDecorator extends RuinedNetherPortalDecorator {

    @Override
    public BlockState getTopSoil(WorldGenLevel level, RandomSource randomSource) {
      if(randomSource.nextFloat() < 0.75F) {
        return Blocks.WARPED_NYLIUM.defaultBlockState();
      }
      return null;
    }

    @Override
    public void decorate(WorldGenLevel level, RandomSource randomSource, BlockPos pos) {
      float random = randomSource.nextFloat();
      if(random < 0.17F) {
        LevelUtils.setBlock(level, pos.above(), Blocks.WARPED_FUNGUS.defaultBlockState(), 3);
      } else if(random < 0.34F) {
        LevelUtils.setBlock(level, pos.above(), Blocks.NETHER_SPROUTS.defaultBlockState(), 3);
      } else if(random < 0.5F) {
        LevelUtils.setBlock(level, pos.above(), Blocks.WARPED_ROOTS.defaultBlockState(), 3);
      } else if(random < 0.8F) {
        int length = randomSource.nextInt(3) + 1;
        int i = 1;
        while (length > 0) {
          if (level.isEmptyBlock(pos.above(i))) {
            LevelUtils.setBlock(level, pos.above(i), Blocks.TWISTING_VINES_PLANT.defaultBlockState(), 3);
          } else {
            break;
          }

          length--;
          i++;
        }
        LevelUtils.setBlock(level, pos.above(i - 1), Blocks.TWISTING_VINES.defaultBlockState(), 3);
      }
    }
  }

  private static class CrimsonForestPortalDecorator extends RuinedNetherPortalDecorator {

    @Override
    public BlockState getTopSoil(WorldGenLevel level, RandomSource randomSource) {
      if(randomSource.nextFloat() < 0.75F) {
        return Blocks.CRIMSON_NYLIUM.defaultBlockState();
      }
      return null;
    }

    @Override
    public void decorate(WorldGenLevel level, RandomSource randomSource, BlockPos pos) {
      float random = randomSource.nextFloat();
      if(random < 0.25F) {
        LevelUtils.setBlock(level, pos.above(), Blocks.CRIMSON_FUNGUS.defaultBlockState(), 3);
      } else if(random < 0.5F) {
        LevelUtils.setBlock(level, pos.above(), Blocks.CRIMSON_ROOTS.defaultBlockState(), 3);
      }
    }
  }
}
