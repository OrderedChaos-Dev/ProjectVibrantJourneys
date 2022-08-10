package com.projectvibrantjourneys.blocks.grower;

import java.util.Random;

import com.projectvibrantjourneys.init.world.features.PVJConfiguredFeatures;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class RedMapleTreeGrower extends AbstractTreeGrower {
	
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean canSpawnBeehive) {
		return random.nextInt(10) == 0 ? PVJConfiguredFeatures.FANCY_RED_MAPLE_TREE.getHolder().get() : PVJConfiguredFeatures.RED_MAPLE_TREE.getHolder().get();
	}
	
}