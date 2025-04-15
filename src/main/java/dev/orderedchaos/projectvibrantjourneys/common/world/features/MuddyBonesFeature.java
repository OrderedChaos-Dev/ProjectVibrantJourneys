package dev.orderedchaos.projectvibrantjourneys.common.world.features;

import com.mojang.serialization.Codec;
import dev.orderedchaos.projectvibrantjourneys.common.blocks.MuddyBonesBlock;
import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class MuddyBonesFeature extends Feature<NoneFeatureConfiguration> {
  public MuddyBonesFeature(Codec<NoneFeatureConfiguration> codec) {
    super(codec);
  }

  @Override
  public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
    WorldGenLevel world = context.level();
    BlockPos origin = context.origin();
    RandomSource randomSource = context.random();

    Direction dir = Direction.Plane.HORIZONTAL.getRandomDirection(randomSource);
    int model = randomSource.nextInt(3);

    if (world.getBlockState(origin).is(Blocks.MUD)) {
      BlockState state = PVJBlocks.MUDDY_BONES.get().defaultBlockState().setValue(MuddyBonesBlock.FACING, dir).setValue(MuddyBonesBlock.MODEL, model);
      if(world.setBlock(origin, state, 2)) {
        ProjectVibrantJourneys.LOGGER.info(origin.toString());
      }
    }

    return true;
  }


}