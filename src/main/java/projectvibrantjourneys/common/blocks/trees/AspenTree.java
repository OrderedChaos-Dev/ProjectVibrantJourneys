package projectvibrantjourneys.common.blocks.trees;

import java.util.Random;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import projectvibrantjourneys.init.world.PVJConfiguredFeatures;

public class AspenTree extends Tree {

	@Override
	protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random randomIn, boolean largeHive) {
		return PVJConfiguredFeatures.aspen_tree;
	}
}
