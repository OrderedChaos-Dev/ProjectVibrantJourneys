package dev.orderedchaos.projectvibrantjourneys.common.world.features.configurations;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record FallenTreeConfiguration(BlockState hollowLog, BlockState baseLog) implements FeatureConfiguration {

    public static final Codec<FallenTreeConfiguration> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder.group(
                BlockState.CODEC.fieldOf("hollowLog").forGetter(FallenTreeConfiguration::hollowLog),
                BlockState.CODEC.fieldOf("baseLog").forGetter(FallenTreeConfiguration::baseLog)
        ).apply(builder, FallenTreeConfiguration::new);
    });

}