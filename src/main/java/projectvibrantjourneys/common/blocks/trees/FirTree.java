package projectvibrantjourneys.common.blocks.trees;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import projectvibrantjourneys.common.world.FeatureManager;

public class FirTree extends Tree {
	
	@Nullable
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean flag) {
		return Feature.NORMAL_TREE.withConfiguration(FeatureManager.FIR_TREE);
	}
}