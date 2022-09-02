package com.projectvibrantjourneys.common.world.features;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;

public class ExtraLilyPadFeature extends Feature<ProbabilityFeatureConfiguration> {

	public ExtraLilyPadFeature(Codec<ProbabilityFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<ProbabilityFeatureConfiguration> context) {
		ProbabilityFeatureConfiguration config = context.config();
		WorldGenLevel level = context.level();
		BlockPos blockpos = context.origin();
		BlockState blockstate = Blocks.LILY_PAD.defaultBlockState();
		if (context.random().nextFloat() < config.probability && blockstate.canSurvive(level, blockpos)) {
			
			int surfaceY = level.getHeight(Types.WORLD_SURFACE, blockpos.getX(), blockpos.getZ());
			int oceanFloorY = level.getHeight(Types.OCEAN_FLOOR, blockpos.getX(), blockpos.getZ());
			int waterDepth = surfaceY - oceanFloorY;
			
			if(waterDepth <= 3) {
				return level.setBlock(blockpos, blockstate, 2);
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	
}
