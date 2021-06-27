package projectvibrantjourneys.common.blocks.trees;

import java.util.Random;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import projectvibrantjourneys.init.world.PVJConfiguredFeatures;

public class FirTree extends Tree {

	@Override
	protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random randomIn, boolean largeHive) {
		return PVJConfiguredFeatures.fir_tree;
	}
}
