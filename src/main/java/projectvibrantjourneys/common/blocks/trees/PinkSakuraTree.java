package projectvibrantjourneys.common.blocks.trees;

import java.util.Random;

import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import projectvibrantjourneys.init.world.PVJConfiguredFeatures;

public class PinkSakuraTree extends AbstractTreeGrower {

	@Override
	protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random randomIn, boolean largeHive) {
		return PVJConfiguredFeatures.pink_sakura_tree;
	}
}
