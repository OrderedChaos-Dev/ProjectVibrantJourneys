package com.projectvibrantjourneys.blocks.grower;

import java.util.Random;

import com.projectvibrantjourneys.init.world.features.PVJConfiguredFeatures;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class WhiteSakuraTreeGrower extends AbstractTreeGrower {
	
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean canSpawnBeehive) {
		return canSpawnBeehive ? PVJConfiguredFeatures.WHITE_SAKURA_TREE_BEES_005.getHolder().get() : PVJConfiguredFeatures.WHITE_SAKURA_TREE.getHolder().get();
	}
	
}