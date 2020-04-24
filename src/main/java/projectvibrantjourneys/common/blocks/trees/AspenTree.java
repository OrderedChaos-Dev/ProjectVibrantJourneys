package projectvibrantjourneys.common.blocks.trees;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import projectvibrantjourneys.common.world.FeatureManager;
import projectvibrantjourneys.init.PVJFeatures;

public class AspenTree extends Tree {
	
	@Nullable
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean flag) {
		return PVJFeatures.aspenTree.withConfiguration(FeatureManager.ASPEN_TREE);
	}
}