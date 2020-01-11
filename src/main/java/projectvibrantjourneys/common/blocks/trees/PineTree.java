package projectvibrantjourneys.common.blocks.trees;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import projectvibrantjourneys.common.world.FeatureManager;
import projectvibrantjourneys.init.PVJFeatures;

public class PineTree extends Tree {
   @Nullable
   protected ConfiguredFeature<TreeFeatureConfig, ?> func_225546_b_(Random rand) {
      return PVJFeatures.pineTree.func_225566_b_(FeatureManager.PINE_TREE);
   }
}