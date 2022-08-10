package com.projectvibrantjourneys.blocks.grower;

import java.util.Random;

import com.projectvibrantjourneys.init.world.features.PVJConfiguredFeatures;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class RedwoodTreeGrower extends AbstractMegaTreeGrower {
	
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean canSpawnBeehive) {
		return canSpawnBeehive ? PVJConfiguredFeatures.SMALL_REDWOOD_TREE_BEES_005.getHolder().get() : PVJConfiguredFeatures.SMALL_REDWOOD_TREE.getHolder().get();
	}

	@Override
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredMegaFeature(Random random) {
		return PVJConfiguredFeatures.BIG_REDWOOD_TREE.getHolder().get();
	}
	
}