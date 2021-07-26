package projectvibrantjourneys.common.blocks.trees;

import java.util.Random;

import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import projectvibrantjourneys.init.world.PVJConfiguredFeatures;

public class RedMapleTree extends AbstractTreeGrower {

	@Override
	protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random randomIn, boolean largeHive) {
		if(randomIn.nextInt(10) == 0) 
			return PVJConfiguredFeatures.large_red_maple_tree;
		
		return PVJConfiguredFeatures.red_maple_tree;
	}
}
