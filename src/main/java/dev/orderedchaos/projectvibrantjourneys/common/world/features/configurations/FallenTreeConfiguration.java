package dev.orderedchaos.projectvibrantjourneys.common.world.features.configurations;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.PrimitiveCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;
import java.util.Optional;

public record FallenTreeConfiguration(BlockState hollowLog, BlockState baseLog,
                                      List<FallenTreeVegetation> vegetationProviders,
                                      boolean canBeMossy) implements FeatureConfiguration {

  public static final Codec<FallenTreeConfiguration> CODEC = RecordCodecBuilder.create((builder) -> {
    return builder.group(
      BlockState.CODEC.fieldOf("hollowLog").forGetter(FallenTreeConfiguration::hollowLog),
      BlockState.CODEC.fieldOf("baseLog").forGetter(FallenTreeConfiguration::baseLog),
      FallenTreeVegetation.CODEC.listOf().fieldOf("vegetationProviders").forGetter(FallenTreeConfiguration::vegetationProviders),
      PrimitiveCodec.BOOL.fieldOf("canBeMossy").forGetter(FallenTreeConfiguration::canBeMossy)
    ).apply(builder, FallenTreeConfiguration::new);
  });

  public record FallenTreeVegetation(BlockStateProvider provider, Optional<String> configOption) {
    public static Codec<FallenTreeVegetation> CODEC = RecordCodecBuilder.create((builder) -> {
      return builder.group(
        BlockStateProvider.CODEC.fieldOf("provider").forGetter(FallenTreeVegetation::provider),
        PrimitiveCodec.STRING.optionalFieldOf("configOption").forGetter(FallenTreeVegetation::configOption)
      ).apply(builder, FallenTreeVegetation::new);
    });
  }
}