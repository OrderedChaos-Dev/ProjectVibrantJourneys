package com.projectvibrantjourneys.core.config.compatibility;

import static com.projectvibrantjourneys.util.TreeFeatureUtils.entry;

import java.util.Set;

import com.projectvibrantjourneys.util.PVJFeatureVars;
import com.projectvibrantjourneys.util.TreeFeatureUtils;
import com.projectvibrantjourneys.util.TreeFeatureUtils.ChanceBiomeEntry;

public class BYG {
	
	public static final Set<ChanceBiomeEntry> OAK_DEFAULT = Set.of(entry("byg:allium_fields", 5),
																	 entry("byg:araucaria_savanna", 5),
																	 entry("byg:autumnal_forest", 30),
																	 entry("byg:baobab_savanna", 5),
																	 entry("byg:coconino_meadow", 5),
																	 entry("byg:fragment_forest", 5),
																	 entry("byg:orchard", 15),
																	 entry("byg:prairie", 5),
																	 entry("byg:red_oak_forest", 15),
																	 entry("byg:temperate_rainforest", 10),
																	 entry("byg:white_mangrove_marshes", 5));

	public static final Set<ChanceBiomeEntry> BIRCH_DEFAULT = Set.of(entry("byg:autumnal_forest", 10),
																	   entry("byg:borealis_grove", 10),
																	   entry("byg:howling_peaks", 5),
																	   entry("byg:temperate_grove", 10));

	public static final Set<ChanceBiomeEntry> SPRUCE_DEFAULT = Set.of(entry("byg:autumnal_taiga", 20),
																		entry("byg:borealis_grove", 10),
																		entry("byg:canadian_shield", 15),
																		entry("byg:dacite_ridges", 10),
																		entry("byg:frosted_taiga", 15),
																		entry("byg:howling_peaks", 5),
																		entry("byg:maple_taiga", 5),
																		entry("byg:rose_fields", 5),
																		entry("byg:weeping_witch_forest", 5));
	
	public static final Set<ChanceBiomeEntry> JUNGLE_DEFAULT = Set.of(entry("byg:crag_gardens", 10));
	
	public static final Set<ChanceBiomeEntry> ACACIA_DEFAULT = Set.of(entry("byg:araucaria_savanna", 10),
																		entry("byg:baobab_savanna", 10));
	
	public static final Set<ChanceBiomeEntry> DARK_OAK_DEFAULT = Set.of(entry("byg:temperate_rainforest", 10));
	
	public static void init() {
		TreeFeatureUtils.serializeAndLoad("oak_trees", "byg", OAK_DEFAULT, PVJFeatureVars.OAK);
		TreeFeatureUtils.serializeAndLoad("birch_trees", "byg", BIRCH_DEFAULT, PVJFeatureVars.BIRCH);
		TreeFeatureUtils.serializeAndLoad("spruce_trees", "byg", SPRUCE_DEFAULT, PVJFeatureVars.SPRUCE);
		TreeFeatureUtils.serializeAndLoad("jungle_trees", "byg", JUNGLE_DEFAULT, PVJFeatureVars.JUNGLE);
		TreeFeatureUtils.serializeAndLoad("acacia_trees", "byg", ACACIA_DEFAULT, PVJFeatureVars.ACACIA);
		TreeFeatureUtils.serializeAndLoad("dark_oak_trees", "byg", DARK_OAK_DEFAULT, PVJFeatureVars.DARK_OAK);
	}
}
