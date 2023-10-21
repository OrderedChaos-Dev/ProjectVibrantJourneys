package dev.orderedchaos.projectvibrantjourneys.core.config;

import dev.orderedchaos.projectvibrantjourneys.core.config.compatibility.BOP;
import dev.orderedchaos.projectvibrantjourneys.core.config.compatibility.BYG;
import dev.orderedchaos.projectvibrantjourneys.core.config.compatibility.Pioneer;
import dev.orderedchaos.projectvibrantjourneys.core.config.compatibility.Terralith;
import dev.orderedchaos.projectvibrantjourneys.util.PVJFeatureVars;
import dev.orderedchaos.projectvibrantjourneys.util.TreeFeatureUtils;
import dev.orderedchaos.projectvibrantjourneys.util.TreeFeatureUtils.ChanceBiomeEntry;

import java.util.Set;

import static dev.orderedchaos.projectvibrantjourneys.util.TreeFeatureUtils.entry;

public class ChanceTreeFeatureConfig {
    public static final Set<ChanceBiomeEntry> OAK_DEFAULT = Set.of(entry("minecraft:forest", 20),
            entry("minecraft:plains", 5),
            entry("minecraft:flower_forest", 20),
            entry("minecraft:sunflower_plains", 5),
            entry("minecraft:swamp", 20),
            entry("minecraft:meadow", 5),
            entry("minecraft:windswept_forest", 5),
            entry("minecraft:dark_forest", 2));

    public static final Set<ChanceBiomeEntry> BIRCH_DEFAULT = Set.of(entry("minecraft:forest", 10),
            entry("minecraft:flower_forest", 20),
            entry("minecraft:birch_forest", 20),
            entry("minecraft:old_growth_birch_forest", 20),
            entry("minecraft:meadow", 5),
            entry("minecraft:dark_forest", 2));

    public static final Set<ChanceBiomeEntry> SPRUCE_DEFAULT = Set.of(entry("minecraft:old_growth_pine_taiga", 20),
            entry("minecraft:old_growth_spruce_taiga", 20),
            entry("minecraft:taiga", 20),
            entry("minecraft:windswept_forest", 5),
            entry("minecraft:grove", 5));

    public static final Set<ChanceBiomeEntry> JUNGLE_DEFAULT = Set.of(entry("minecraft:bamboo_jungle", 20),
            entry("minecraft:jungle", 20),
            entry("minecraft:sparse_jungle", 25));

    public static final Set<ChanceBiomeEntry> ACACIA_DEFAULT = Set.of(entry("minecraft:savanna", 20),
            entry("minecraft:savanna_plateau", 20),
            entry("minecraft:windswept_savanna", 20));

    public static final Set<ChanceBiomeEntry> DARK_OAK_DEFAULT = Set.of(entry("minecraft:dark_forest", 20));

    public static void init() {
        TreeFeatureUtils.serializeAndLoad("oak_trees", "minecraft", OAK_DEFAULT, PVJFeatureVars.OAK);
        TreeFeatureUtils.serializeAndLoad("birch_trees", "minecraft", BIRCH_DEFAULT, PVJFeatureVars.BIRCH);
        TreeFeatureUtils.serializeAndLoad("spruce_trees", "minecraft", SPRUCE_DEFAULT, PVJFeatureVars.SPRUCE);
        TreeFeatureUtils.serializeAndLoad("jungle_trees", "minecraft", JUNGLE_DEFAULT, PVJFeatureVars.JUNGLE);
        TreeFeatureUtils.serializeAndLoad("acacia_trees", "minecraft", ACACIA_DEFAULT, PVJFeatureVars.ACACIA);
        TreeFeatureUtils.serializeAndLoad("dark_oak_trees", "minecraft", DARK_OAK_DEFAULT, PVJFeatureVars.DARK_OAK);

        /* Mod Compatibility */
        BYG.init();
        BOP.init();
        Pioneer.init();
        Terralith.init();
    }
}