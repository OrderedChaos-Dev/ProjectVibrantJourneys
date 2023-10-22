package dev.orderedchaos.projectvibrantjourneys.common.world.features;

import com.mojang.serialization.Codec;
import dev.orderedchaos.projectvibrantjourneys.util.LevelUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.material.Fluids;

public class SimpleBlockMatchWaterFeature extends Feature<SimpleBlockConfiguration> {

  public SimpleBlockMatchWaterFeature(Codec<SimpleBlockConfiguration> codec) {
    super(codec);
  }

  @Override
  public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> context) {
    boolean placed = false;

    SimpleBlockConfiguration config = context.config();
    WorldGenLevel level = context.level();
    BlockPos origin = context.origin();
    BlockState state = config.toPlace().getState(context.random(), origin);

    if (state.canSurvive(level, origin)) {
      if (state.getBlock() instanceof DoublePlantBlock) {
        if (!level.isEmptyBlock(origin.above())) {
          return false;
        }

        DoublePlantBlock.placeAt(level, state, origin, 2);
      } else {
        if (state.getBlock() instanceof SimpleWaterloggedBlock) {
          if (level.isFluidAtPosition(origin, (fluidstate) -> fluidstate.getType() == Fluids.WATER)) {
            placed = LevelUtils.setBlock(level, origin, state.setValue(BlockStateProperties.WATERLOGGED, true), 2);
          } else {
            placed = LevelUtils.setBlock(level, origin, state, 2);
          }
        } else {
          placed = LevelUtils.setBlock(level, origin, state, 2);
        }
      }

      return placed;
    } else {
      return false;
    }
  }
}