package projectvibrantjourneys.common.blocks.trees;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.trees.BigTree;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import projectvibrantjourneys.common.world.FeatureManager;
import projectvibrantjourneys.init.PVJFeatures;

public class BaobabTree extends BigTree {

	@Nullable
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
		return null;
	}

	@Nullable
	@Override
	protected ConfiguredFeature<HugeTreeFeatureConfig, ?> getHugeTreeFeature(Random p_225547_1_) {
		return PVJFeatures.baobabTree.withConfiguration(FeatureManager.BAOBAB_TREE);
	}
}