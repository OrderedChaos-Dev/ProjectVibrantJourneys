package dev.orderedchaos.projectvibrantjourneys.common.world.features;

import com.mojang.serialization.Codec;
import dev.orderedchaos.projectvibrantjourneys.common.blocks.BarkMushroomBlock;
import dev.orderedchaos.projectvibrantjourneys.common.blocks.FallenLeavesBlock;
import dev.orderedchaos.projectvibrantjourneys.common.blocks.GroundcoverBlock;
import dev.orderedchaos.projectvibrantjourneys.common.blocks.HollowLogBlock;
import dev.orderedchaos.projectvibrantjourneys.common.world.features.configurations.FallenTreeConfiguration;
import dev.orderedchaos.projectvibrantjourneys.common.world.features.configurations.FallenTreeConfiguration.FallenTreeVegetation;
import dev.orderedchaos.projectvibrantjourneys.core.config.PVJConfig;
import dev.orderedchaos.projectvibrantjourneys.util.LevelUtils;
import dev.orderedchaos.projectvibrantjourneys.util.PVJFeatureVars;
import dev.orderedchaos.projectvibrantjourneys.util.TreeFeatureUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.material.Fluids;

import java.util.HashSet;
import java.util.List;

public class FallenTreeFeature extends Feature<FallenTreeConfiguration> {

  public FallenTreeFeature(Codec<FallenTreeConfiguration> codec) {
    super(codec);
  }

  @Override
  public boolean place(FeaturePlaceContext<FallenTreeConfiguration> context) {
    WorldGenLevel level = context.level();
    BlockPos pos = context.origin();
    RandomSource rand = context.random();
    BlockState hollowLog = context.config().hollowLog();
    BlockState baseLog = context.config().baseLog();

    String biome = level.getBiome(pos).unwrapKey().get().location().toString();
    HashSet<TreeFeatureUtils.ChanceBiomeEntry> biomeEntries = getEntrySet(baseLog.getBlock());
    int chance = TreeFeatureUtils.getChance(biome, biomeEntries);
    if(chance == -1) {
      chance = 10; //set default
    }

    if (rand.nextFloat() > chance / 100.0F)
      return false;

    BlockState below = level.getBlockState(pos.below());
    if (below.is(BlockTags.ICE) || below.getBlock() == Blocks.SNOW_BLOCK || below.getFluidState().isSource())
      return false;

    int length = rand.nextInt(3) + 4;
    Direction dir = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
    Direction dirCounterClockwise = dir.getCounterClockWise();
    Direction dirClockwise = dir.getClockWise();
    boolean branched = false;

    for (int i = 0; i < length; i++) {
      if (!canReplace(level, pos)) {
        return false;
      }
      pos = pos.offset(dir.getNormal());
    }

    pos = context.origin();
    List<FallenTreeVegetation> vegetationProviders = context.config().vegetationProviders();
    RandomSource randomSource = level.getRandom();

    for (int i = 0; i < length; i++) {
      if (canReplace(level, pos)) {
        if (!(below.canBeReplaced() || below.getFluidState().is(Fluids.WATER)) || i > (length / 2)) {
          boolean mossy = context.config().canBeMossy() ? randomSource.nextBoolean() : false;
          LevelUtils.setBlock(level, pos, hollowLog.setValue(RotatedPillarBlock.AXIS, dir.getAxis()).setValue(HollowLogBlock.MOSSY, mossy), 2);

          if (level.isEmptyBlock(pos.above()) && rand.nextFloat() < 0.75F) {
            LevelUtils.setBlock(level, pos.above(), this.getVegetationToPlace(vegetationProviders, randomSource, pos.above()), 2);
          }

          if (!branched && i <= (length / 2) + 1 && rand.nextFloat() < 0.5F) {
            BlockPos branchPos = rand.nextBoolean() ? pos.offset(dirCounterClockwise.getNormal()) : pos.offset(dirClockwise.getNormal());
            ;
            LevelUtils.setBlock(level, branchPos, baseLog.setValue(RotatedPillarBlock.AXIS, dirCounterClockwise.getAxis()), 2);
            if (level.isEmptyBlock(branchPos.above()) && rand.nextFloat() < 0.4F) {
              LevelUtils.setBlock(level, branchPos.above(), this.getVegetationToPlace(vegetationProviders, randomSource, branchPos.above()), 2);
            }
            branched = true;
          }

          BlockPos original = pos;

          pos = pos.offset(dirCounterClockwise.getNormal());
          if (canReplace(level, pos)) {
            if (rand.nextFloat() < 0.4F && Block.isFaceFull(level.getBlockState(pos.below()).getCollisionShape(level, pos.below()), Direction.UP)) {
              BlockState state = this.getVegetationToPlace(vegetationProviders, randomSource, pos);
              if (state.canSurvive(level, pos)) {
                LevelUtils.setBlock(level, pos, state, 2);
              }
            } else if (rand.nextFloat() < 0.4F && PVJConfig.configOptions.get("enableBarkMushrooms").get()) {
              BarkMushroomBlock mushroom = BarkMushroomBlock.getRandom(rand);
              LevelUtils.setBlock(level, pos, mushroom.defaultBlockState().setValue(BarkMushroomBlock.FACING, dirCounterClockwise), 2);
            }
          }

          pos = original;
          pos = pos.offset(dirClockwise.getNormal());
          if (canReplace(level, pos)) {
            if (rand.nextFloat() < 0.4F && Block.isFaceFull(level.getBlockState(pos.below()).getCollisionShape(level, pos.below()), Direction.UP)) {
              BlockState state = this.getVegetationToPlace(vegetationProviders, randomSource, pos);
              if (state.canSurvive(level, pos)) {
                LevelUtils.setBlock(level, pos, state, 2);
              }
            } else if (rand.nextFloat() < 0.4F && PVJConfig.configOptions.get("enableBarkMushrooms").get()) {
              BarkMushroomBlock mushroom = BarkMushroomBlock.getRandom(rand);
              LevelUtils.setBlock(level, pos, mushroom.defaultBlockState().setValue(BarkMushroomBlock.FACING, dirClockwise), 2);
            }
          }

          pos = original;
          pos = pos.offset(dir.getNormal());
        } else {
          dir = dir.getOpposite();
          pos = context.origin().offset(dir.getNormal());
        }
        below = level.getBlockState(pos.below());
      } else {
        return length - i < length;
      }
    }

    return true;
  }

  public boolean canReplace(WorldGenLevel world, BlockPos pos) {
    return world.getBlockState(pos).canBeReplaced()
      || world.isEmptyBlock(pos)
      || world.getBlockState(pos).getBlock() instanceof FallenLeavesBlock
      || world.getBlockState(pos).getBlock() instanceof GroundcoverBlock;
  }

  public HashSet<TreeFeatureUtils.ChanceBiomeEntry> getEntrySet(Block log) {
    if (log == Blocks.OAK_LOG) {
      return PVJFeatureVars.OAK;
    } else if (log == Blocks.BIRCH_LOG) {
      return PVJFeatureVars.BIRCH;
    } else if (log == Blocks.SPRUCE_LOG) {
      return PVJFeatureVars.SPRUCE;
    } else if (log == Blocks.JUNGLE_LOG) {
      return PVJFeatureVars.JUNGLE;
    } else if (log == Blocks.ACACIA_LOG) {
      return PVJFeatureVars.ACACIA;
    } else if (log == Blocks.DARK_OAK_LOG) {
      return PVJFeatureVars.DARK_OAK;
    } else if (log == Blocks.MANGROVE_LOG) {
      return PVJFeatureVars.MANGROVE;
    } else if (log == Blocks.CHERRY_LOG) {
      return PVJFeatureVars.CHERRY;
    }

    return PVJFeatureVars.OAK;
  }

  private BlockState getVegetationToPlace(List<FallenTreeVegetation> vegetationProviders, RandomSource randomSource, BlockPos pos) {
    int numProviders = vegetationProviders.size();
    FallenTreeVegetation vegetation = null;
    while (vegetation == null) {
      int random = randomSource.nextInt(numProviders);
      FallenTreeVegetation temp = vegetationProviders.get(random);
      if (temp.configOption().isPresent()) {
        String configOption = temp.configOption().get();
        if (!PVJConfig.configOptions.get(configOption).get()) {
          continue;
        }
      }
      vegetation = temp;
    }

    return vegetation.provider().getState(randomSource, pos);
  }
}