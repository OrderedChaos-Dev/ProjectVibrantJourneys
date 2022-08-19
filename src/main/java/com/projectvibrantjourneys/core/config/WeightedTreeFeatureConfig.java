package com.projectvibrantjourneys.core.config;

import static com.projectvibrantjourneys.util.TreeFeatureUtils.entry;

import java.util.Set;

import com.projectvibrantjourneys.util.PVJFeatureVars;
import com.projectvibrantjourneys.util.TreeFeatureUtils;
import com.projectvibrantjourneys.util.TreeFeatureUtils.WeightedBiomeEntry;

public class WeightedTreeFeatureConfig {
	
	public static final Set<WeightedBiomeEntry> OAK_DEFAULT = Set.of(entry("minecraft:forest", 20),
																		 entry("minecraft:plains", 5),
																		 entry("mineraft:flower_forest", 20),
																		 entry("minecraft:sunflower_plains", 5),
																		 entry("minecraft:swamp", 20),
																		 entry("minecraft:meadow", 5),
																		 entry("minecraft:windswept_forest", 5),
																		 entry("minecraft:dark_forest", 2));

	public static final Set<WeightedBiomeEntry> BIRCH_DEFAULT = Set.of(entry("minecraft:forest", 10),
																		   entry("minecraft:birch_forest", 20),
																		   entry("minecraft:old_growth_birch_forest", 20),
																		   entry("minecraft:meadow", 5),
																		   entry("minecraft:dark_forest", 2));

	public static final Set<WeightedBiomeEntry> SPRUCE_DEFAULT = Set.of(entry("minecraft:old_growth_pine_taiga", 20),
																			entry("minecraft:old_growth_spruce_taiga", 20),
																			entry("minecraft:taiga", 20),
																			entry("minecraft:windswept_forest", 5),
																			entry("minecraft:grove", 5));

	public static final Set<WeightedBiomeEntry> JUNGLE_DEFAULT = Set.of(entry("minecraft:bamboo_jungle", 20),
																			entry("minecraft:jungle", 20),
																			entry("minecraft:sparse_jungle", 25));

	public static final Set<WeightedBiomeEntry> ACACIA_DEFAULT = Set.of(entry("minecraft:savanna", 20),
																			entry("minecraft:savanna_plateau", 20),
																			entry("minecraft:windswept_savanna", 20));

	public static final Set<WeightedBiomeEntry> DARK_OAK_DEFAULT = Set.of(entry("minecraft:dark_forest", 20));
	
	
	public static void init() {
		TreeFeatureUtils.serializeAndLoad("oak_fallen_tree", OAK_DEFAULT, PVJFeatureVars.OAK);
		TreeFeatureUtils.serializeAndLoad("birch_fallen_tree", BIRCH_DEFAULT, PVJFeatureVars.BIRCH);
		TreeFeatureUtils.serializeAndLoad("spruce_fallen_tree", SPRUCE_DEFAULT, PVJFeatureVars.SPRUCE);
		TreeFeatureUtils.serializeAndLoad("jungle_fallen_tree", JUNGLE_DEFAULT, PVJFeatureVars.JUNGLE);
		TreeFeatureUtils.serializeAndLoad("acacia_fallen_tree", ACACIA_DEFAULT, PVJFeatureVars.ACACIA);
		TreeFeatureUtils.serializeAndLoad("dark_oak_fallen_tree", DARK_OAK_DEFAULT, PVJFeatureVars.DARK_OAK);
	}
}
