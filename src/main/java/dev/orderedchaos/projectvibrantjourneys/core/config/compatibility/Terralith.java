package dev.orderedchaos.projectvibrantjourneys.core.config.compatibility;

import dev.orderedchaos.projectvibrantjourneys.util.PVJFeatureVars;
import dev.orderedchaos.projectvibrantjourneys.util.TreeFeatureUtils;

import java.util.Set;

import static dev.orderedchaos.projectvibrantjourneys.util.TreeFeatureUtils.entry;

public class Terralith {
    private static final String MOD_ID = "terralith";

    /* Check again
    alpha_islands
    alpha_islands_winter
    desert_spires
    sandstone_valley

    Does not spawn on Skylands yet (need to check height or sth.? Since the ocean counts as the biome as well)
    */

    public static final Set<TreeFeatureUtils.ChanceBiomeEntry> OAK_DEFAULT = Set.of(
            entry(MOD_ID + ":brushlands", 5),
            entry(MOD_ID + ":birch_taiga", 5),
            entry(MOD_ID + ":blooming_valley", 10),
            entry(MOD_ID + ":lush_valley", 10),
            entry(MOD_ID + ":shrublands", 5),
            entry(MOD_ID + ":snowy_shield", 5),
            entry(MOD_ID + ":haze_mountain", 10),
            entry(MOD_ID + ":ice_marsh", 10),
            entry(MOD_ID + ":rocky_jungle", 5),
            entry(MOD_ID + ":temperate_highlands", 10),
            entry(MOD_ID + ":shield", 5),
            entry(MOD_ID + ":skylands_autumn", 10),
            entry(MOD_ID + ":snowy_maple_forest", 5)
    );

    public static final Set<TreeFeatureUtils.ChanceBiomeEntry> BIRCH_DEFAULT = Set.of(
            entry(MOD_ID + ":alpine_highlands", 5),
            entry(MOD_ID + ":birch_taiga", 20),
            entry(MOD_ID + ":blooming_valley", 10),
            entry(MOD_ID + ":yellowstone", 5),
            entry(MOD_ID + ":lush_valley", 10),
            entry(MOD_ID + ":shield", 3),
            entry(MOD_ID + ":haze_mountain", 5),
            entry(MOD_ID + ":sakura_grove", 5),
            entry(MOD_ID + ":lavender_forest", 10),
            entry(MOD_ID + ":lavender_valley", 10),
            entry(MOD_ID + ":temperate_highlands", 10),
            entry(MOD_ID + ":skylands_autumn", 5),
            entry(MOD_ID + ":skylands_spring", 3),
            entry(MOD_ID + ":white_cliffs", 5),
            entry(MOD_ID + ":orchid_swamp", 10),
            entry(MOD_ID + ":sakura_valley", 5)
    );

    public static final Set<TreeFeatureUtils.ChanceBiomeEntry> SPRUCE_DEFAULT = Set.of(
            entry(MOD_ID + ":alpine_grove", 5),
            entry(MOD_ID + ":alpine_highlands", 5),
            entry(MOD_ID + ":moonlight_valley", 5), // Trees are made of Stripped Spruce Logs
            entry(MOD_ID + ":yellowstone", 10),
            entry(MOD_ID + ":lush_valley", 10),
            entry(MOD_ID + ":cold_shrublands", 5),
            entry(MOD_ID + ":forested_highlands", 10),
            entry(MOD_ID + ":shield", 10),
            entry(MOD_ID + ":snowy_shield", 10),
            entry(MOD_ID + ":highlands", 3),
            entry(MOD_ID + ":siberian_taiga", 10),
            entry(MOD_ID + ":skylands_winter", 10),
            entry(MOD_ID + ":wintry_lowlands", 15),
            entry(MOD_ID + ":wintry_forest", 15),
            entry(MOD_ID + ":moonlight_grove", 5), // Trees are made of Stripped Spruce Logs
            entry(MOD_ID + ":bryce_canyon", 5),
            entry(MOD_ID + ":rocky_shrublands", 5)
    );

    public static final Set<TreeFeatureUtils.ChanceBiomeEntry> JUNGLE_DEFAULT = Set.of(
            entry(MOD_ID + ":desert_oasis", 5),
            entry(MOD_ID + ":jungle_mountains", 10),
            entry(MOD_ID + ":rocky_jungle", 15),
            entry(MOD_ID + ":skylands_summer", 10),
            entry(MOD_ID + ":tropical_jungle", 15),
            entry(MOD_ID + ":red_oasis", 10)
    );

    public static final Set<TreeFeatureUtils.ChanceBiomeEntry> ACACIA_DEFAULT = Set.of(
            entry(MOD_ID + ":moonlight_valley", 5),
            entry(MOD_ID + ":arid_highlands", 3),
            entry(MOD_ID + ":hot_shrublands", 3),
            entry(MOD_ID + ":amethyst_rainforest", 20),
            entry(MOD_ID + ":lavender_forest", 3),
            entry(MOD_ID + ":lavender_valley", 3),
            entry(MOD_ID + ":skylands_summer", 10),
            entry(MOD_ID + ":tropical_jungle", 5),
            entry(MOD_ID + ":amethyst_canyon", 15),
            entry(MOD_ID + ":moonlight_grove", 5),
            entry(MOD_ID + ":savanna_badlands", 5)
    );

    public static final Set<TreeFeatureUtils.ChanceBiomeEntry> DARK_OAK_DEFAULT = Set.of(
            entry(MOD_ID + ":forested_highlands", 10),
            entry(MOD_ID + ":sakura_grove", 15),
            entry(MOD_ID + ":lavender_forest", 15),
            entry(MOD_ID + ":lavender_valley", 15),
            entry(MOD_ID + ":mirage_isles", 3), // Also has Stripped Warped Stem tree(s) (seems to be a small isle though)
            entry(MOD_ID + ":siberian_taiga", 10),
            entry(MOD_ID + ":skylands_autumn", 3),
            entry(MOD_ID + ":skylands_spring", 10),
            entry(MOD_ID + ":skylands_winter", 10),
            entry(MOD_ID + ":snowy_maple_forest", 5),
            entry(MOD_ID + ":sakura_valley", 10)
    );

    public static void init() {
        TreeFeatureUtils.serializeAndLoad("oak_trees", MOD_ID, OAK_DEFAULT, PVJFeatureVars.OAK);
        TreeFeatureUtils.serializeAndLoad("birch_trees", MOD_ID, BIRCH_DEFAULT, PVJFeatureVars.BIRCH);
        TreeFeatureUtils.serializeAndLoad("spruce_trees", MOD_ID, SPRUCE_DEFAULT, PVJFeatureVars.SPRUCE);
        TreeFeatureUtils.serializeAndLoad("jungle_trees", MOD_ID, JUNGLE_DEFAULT, PVJFeatureVars.JUNGLE);
        TreeFeatureUtils.serializeAndLoad("acacia_trees", MOD_ID, ACACIA_DEFAULT, PVJFeatureVars.ACACIA);
        TreeFeatureUtils.serializeAndLoad("dark_oak_trees", MOD_ID, DARK_OAK_DEFAULT, PVJFeatureVars.DARK_OAK);
    }
}
