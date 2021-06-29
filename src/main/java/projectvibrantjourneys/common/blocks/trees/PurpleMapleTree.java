package projectvibrantjourneys.common.blocks.trees;

import java.util.Random;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import projectvibrantjourneys.init.world.PVJConfiguredFeatures;

public class PurpleMapleTree extends Tree {

	@Override
	protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random randomIn, boolean largeHive) {
		if(randomIn.nextInt(10) == 0) 
			return PVJConfiguredFeatures.large_purple_maple_tree;
		
		return PVJConfiguredFeatures.purple_maple_tree;
	}
}
