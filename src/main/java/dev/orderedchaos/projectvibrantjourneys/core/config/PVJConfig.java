package dev.orderedchaos.projectvibrantjourneys.core.config;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID)
public class PVJConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec COMMON_CONFIG = BUILDER.build();

    public static ForgeConfigSpec.BooleanValue enableRocks;
    public static ForgeConfigSpec.BooleanValue enableTwigs;
    public static ForgeConfigSpec.BooleanValue enableFallenLeaves;
    public static ForgeConfigSpec.BooleanValue enableBones;
    public static ForgeConfigSpec.BooleanValue enableCharredBones;
    public static ForgeConfigSpec.BooleanValue enableIceChunks;
    public static ForgeConfigSpec.BooleanValue enablePinecones;
    public static ForgeConfigSpec.BooleanValue enableSeashells;

    public static ForgeConfigSpec.BooleanValue enableFallenTrees;

    public static ForgeConfigSpec.BooleanValue enableSeaOats;
    public static ForgeConfigSpec.BooleanValue enableCattails;
    public static ForgeConfigSpec.BooleanValue enableBeachGrass;
    public static ForgeConfigSpec.BooleanValue enableBarkMushrooms;
    public static ForgeConfigSpec.BooleanValue enableGlowcap;
    public static ForgeConfigSpec.BooleanValue enableCindercane;
    public static ForgeConfigSpec.BooleanValue enableNetherNettles;
    public static ForgeConfigSpec.BooleanValue enableShortGrass;
    public static ForgeConfigSpec.BooleanValue enableNaturalCobwebs;
    public static ForgeConfigSpec.BooleanValue enableSmallCacti;
    public static ForgeConfigSpec.BooleanValue enablePricklyBush;
    public static ForgeConfigSpec.BooleanValue enableReeds;
    public static ForgeConfigSpec.BooleanValue enableIcicles;

    public static ForgeConfigSpec.BooleanValue enableExtraLilypads;
    public static ForgeConfigSpec.BooleanValue enableExtraSeagrass;
    public static ForgeConfigSpec.BooleanValue enableExtraRiverGrass;
    public static ForgeConfigSpec.BooleanValue enableMossCarpets;
    public static ForgeConfigSpec.BooleanValue enableTidePools;
    public static ForgeConfigSpec.BooleanValue enableCaveRoots;
    public static ForgeConfigSpec.BooleanValue enableBetterRuinedNetherPortals;

    public static ForgeConfigSpec.BooleanValue enableJungleTropicalFish;

    static {
        BUILDER.push("World Generation");
        enableRocks = BUILDER.comment("Enable generation of rocks").define("enableRocks", true);
        enableTwigs = BUILDER.comment("Enable generation of twigs").define("enableTwigs", true);
        enableFallenLeaves = BUILDER.comment("Enable generation of fallen leaves").define("enableFallenLeaves", true);
        enableBones = BUILDER.comment("Enable generation of bones").define("enableBones", true);
        enableCharredBones = BUILDER.comment("Enable generation of charred bones").define("enableCharredBones", false);
        enableIceChunks = BUILDER.comment("Enable generation of ice chunks").define("enableIceChunks", true);
        enablePinecones = BUILDER.comment("Enable generation of pinecones").define("enablePinecones", true);
        enableSeashells = BUILDER.comment("Enable generation of seashells").define("enableSeashells", true);

        enableFallenTrees = BUILDER.comment("Enable generation of fallen trees").define("enableFallenTrees", true);

        enableSeaOats = BUILDER.comment("Enable generation of sea oats").define("enableSeaOats", true);
        enableCattails = BUILDER.comment("Enable generation of cattails").define("enableCattails", true);
        enableBeachGrass = BUILDER.comment("Enable generation of beach grass").define("enableBeachGrass", true);
        enableBarkMushrooms = BUILDER.comment("Enable generation of bark mushrooms").define("enableBarkMushrooms", true);
        enableGlowcap = BUILDER.comment("Enable generation of glowcap").define("enableGlowcap", true);
        enableCindercane = BUILDER.comment("Enable generation of cindercane").define("enableCindercane", true);
        enableNetherNettles = BUILDER.comment("Enable generation of nether nettles").define("enableNetherNettles", true);
        enableShortGrass = BUILDER.comment("Enable generation of short grass").define("enableShortGrass", true);
        enableNaturalCobwebs = BUILDER.comment("Enable generation of natural cobwebs").define("enableNaturalCobwebs", true);
        enableSmallCacti = BUILDER.comment("Enable generation of small cacti").define("enableSmallCacti", true);
        enablePricklyBush = BUILDER.comment("Enable generation of prickly bushes").define("enablePricklyBush", true);
        enableReeds = BUILDER.comment("Enable generation of reeds").define("enableReeds", true);
        enableIcicles = BUILDER.comment("Enable generation of icicles").define("enableIcicles", true);

        enableExtraLilypads = BUILDER.comment("Enable generation of extra lilypads in lakes").define("enableExtraLilypads", true);
        enableExtraSeagrass = BUILDER.comment("Enable generation of extra seagrass in lakes").define("enableExtraSeagrass", true);
        enableExtraRiverGrass = BUILDER.comment("Enable generation of extra grass in rivers").define("enableExtraRiverGrass", true);
        enableMossCarpets = BUILDER.comment("Enable moss carpets in old growth taiga biomes").define("enableMossCarpets", true);
        enableTidePools = BUILDER.comment("Enable of tide pools in stony shores").define("enableTidePools", true);
        enableCaveRoots = BUILDER.comment("Enable cave roots").define("enableCaveRoots", true);
        enableBetterRuinedNetherPortals = BUILDER.comment("Enable better ruined nether portals").define("enableBetterRuinedNetherPortals", true);
        BUILDER.pop();

        BUILDER.push("Entity Options");
        enableJungleTropicalFish = BUILDER.comment("Enable spawning of tropical fish in jungles").define("enableJungleTropicalFish", true);
        BUILDER.pop();

    }
}
