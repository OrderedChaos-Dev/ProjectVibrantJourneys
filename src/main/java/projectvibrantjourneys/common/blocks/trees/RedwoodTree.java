package projectvibrantjourneys.common.blocks.trees;

import java.util.Random;

import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import projectvibrantjourneys.init.world.PVJConfiguredFeatures;

public class RedwoodTree extends AbstractMegaTreeGrower {

	@Override
	protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random randomIn, boolean largeHive) {
		return PVJConfiguredFeatures.redwood_tree;
	}

	@Override
	protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredMegaFeature(Random rand) {
		return PVJConfiguredFeatures.mega_redwood_tree;
	}
}
