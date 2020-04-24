package projectvibrantjourneys.common.blocks.trees;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import projectvibrantjourneys.common.world.FeatureManager;

public class PurpleMapleTree extends Tree {

   @Nullable
   protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
      return randomIn.nextInt(10) == 0 ? Feature.FANCY_TREE.withConfiguration(FeatureManager.BIG_PURPLE_MAPLE_TREE)
    		  : Feature.NORMAL_TREE.withConfiguration(FeatureManager.PURPLE_MAPLE_TREE);
   }
}