package dev.orderedchaos.projectvibrantjourneys.common.world.features.configurations;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record BushConfiguration(BlockState log, BlockState leaves) implements FeatureConfiguration {

  public static final Codec<BushConfiguration> CODEC = RecordCodecBuilder.create(builder -> {
    return builder.group(
      BlockState.CODEC.fieldOf("log").forGetter(BushConfiguration::log),
      BlockState.CODEC.fieldOf("leaves").forGetter(BushConfiguration::leaves)
    ).apply(builder, BushConfiguration::new);
  });
}
