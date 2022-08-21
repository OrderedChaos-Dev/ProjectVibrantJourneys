package com.projectvibrantjourneys.common.world.features.configs;

import java.util.List;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.projectvibrantjourneys.util.TreeFeatureUtils;
import com.projectvibrantjourneys.util.TreeFeatureUtils.ChanceBiomeEntry;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record FallenTreeConfiguration(BlockState hollowLog, BlockState baseLog, List<ChanceBiomeEntry> data) implements FeatureConfiguration {

	   public static final Codec<FallenTreeConfiguration> CODEC = RecordCodecBuilder.create((builder) -> {
		   return builder.group(
				   BlockState.CODEC.fieldOf("hollowLog").forGetter(FallenTreeConfiguration::hollowLog),
				   BlockState.CODEC.fieldOf("baseLog").forGetter(FallenTreeConfiguration::baseLog),
				   TreeFeatureUtils.ChanceBiomeEntry.CODEC.listOf().fieldOf("data").forGetter(FallenTreeConfiguration::data)
				   ).apply(builder, FallenTreeConfiguration::new);
	   });

}
