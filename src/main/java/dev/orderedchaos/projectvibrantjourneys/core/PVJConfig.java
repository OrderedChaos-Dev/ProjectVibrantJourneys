package dev.orderedchaos.projectvibrantjourneys.core;

import java.util.HashMap;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJConfig
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static HashMap<String, ModConfigSpec.BooleanValue> configOptions = new HashMap<>();

    public static ModConfigSpec.BooleanValue enableRocks;
    public static ModConfigSpec.BooleanValue enableTwigs;
    public static ModConfigSpec.BooleanValue enableFallenLeaves;
    public static ModConfigSpec.BooleanValue enableBones;
    public static ModConfigSpec.BooleanValue enableCharredBones;
    public static ModConfigSpec.BooleanValue enableIceChunks;
    public static ModConfigSpec.BooleanValue enablePinecones;
    public static ModConfigSpec.BooleanValue enableSeashells;

    public static ModConfigSpec.BooleanValue enableFallenTrees;

    public static ModConfigSpec.BooleanValue enableSeaOats;
    public static ModConfigSpec.BooleanValue enableCattails;
    public static ModConfigSpec.BooleanValue enableBeachGrass;
    public static ModConfigSpec.BooleanValue enableBarkMushrooms;
    public static ModConfigSpec.BooleanValue enableGlowcap;
    public static ModConfigSpec.BooleanValue enableCindercane;
    public static ModConfigSpec.BooleanValue enableNetherNettles;
    public static ModConfigSpec.BooleanValue enableShortGrass;
    public static ModConfigSpec.BooleanValue enableNaturalCobwebs;
    public static ModConfigSpec.BooleanValue enableSmallCacti;
    public static ModConfigSpec.BooleanValue enablePricklyBush;
    public static ModConfigSpec.BooleanValue enableReeds;
    public static ModConfigSpec.BooleanValue enableIcicles;
    public static ModConfigSpec.BooleanValue enableSandySprouts;

    public static ModConfigSpec.BooleanValue enableExtraLilypads;
    public static ModConfigSpec.BooleanValue enableExtraSeagrass;
    public static ModConfigSpec.BooleanValue enableExtraRiverGrass;
    public static ModConfigSpec.BooleanValue enableMossCarpets;
    public static ModConfigSpec.BooleanValue enableTidePools;
    public static ModConfigSpec.BooleanValue enableCaveRoots;
    public static ModConfigSpec.BooleanValue enableBetterRuinedNetherPortals;

    public static ModConfigSpec.BooleanValue enableJungleTropicalFish;

    static {
        BUILDER.push("World Generation");
        config("enableRocks", enableRocks, BUILDER.comment("Enable generation of rocks").define("enableRocks", true));
        config("enableTwigs", enableTwigs, BUILDER.comment("Enable generation of twigs").define("enableTwigs", true));
        config("enableFallenLeaves", enableFallenLeaves, BUILDER.comment("Enable generation of fallen leaves").define("enableFallenLeaves", true));
        config("enableBones", enableBones, BUILDER.comment("Enable generation of bones").define("enableBones", true));
        config("enableCharredBones", enableCharredBones, BUILDER.comment("Enable generation of charred bones").define("enableCharredBones", true));
        config("enableIceChunks", enableIceChunks, BUILDER.comment("Enable generation of ice chunks").define("enableIceChunks", true));
        config("enablePinecones", enablePinecones, BUILDER.comment("Enable generation of pinecones").define("enablePinecones", true));
        config("enableSeashells", enableSeashells, BUILDER.comment("Enable generation of seashells").define("enableSeashells", true));

        config("enableFallenTrees", enableFallenTrees, BUILDER.comment("Enable generation of fallen trees").define("enableFallenTrees", true));

        config("enableSeaOats", enableSeaOats, BUILDER.comment("Enable generation of sea oats").define("enableSeaOats", true));
        config("enableCattails", enableCattails, BUILDER.comment("Enable generation of cattails").define("enableCattails", true));
        config("enableBeachGrass", enableBeachGrass, BUILDER.comment("Enable generation of beach grass").define("enableBeachGrass", true));
        config("enableBarkMushrooms", enableBarkMushrooms, BUILDER.comment("Enable generation of bark mushrooms").define("enableBarkMushrooms", true));
        config("enableGlowcap", enableGlowcap, BUILDER.comment("Enable generation of glowcap").define("enableGlowcap", true));
        config("enableCindercane", enableCindercane, BUILDER.comment("Enable generation of cindercane").define("enableCindercane", true));
        config("enableNetherNettles", enableNetherNettles, BUILDER.comment("Enable generation of nether nettles").define("enableNetherNettles", true));
        config("enableShortGrass", enableShortGrass, BUILDER.comment("Enable generation of short grass").define("enableShortGrass", true));
        config("enableNaturalCobwebs", enableNaturalCobwebs, BUILDER.comment("Enable generation of natural cobwebs").define("enableNaturalCobwebs", true));
        config("enableSmallCacti", enableSmallCacti, BUILDER.comment("Enable generation of small cacti").define("enableSmallCacti", true));
        config("enablePricklyBush", enablePricklyBush, BUILDER.comment("Enable generation of prickly bushes").define("enablePricklyBush", true));
        config("enableReeds", enableReeds, BUILDER.comment("Enable generation of reeds").define("enableReeds", true));
        config("enableIcicles", enableIcicles, BUILDER.comment("Enable generation of icicles").define("enableIcicles", true));
        config("enableSandySprouts", enableSandySprouts, BUILDER.comment("Enable generation of sandy sprouts").define("enableSandySprouts", true));

        config("enableExtraLilypads", enableExtraLilypads, BUILDER.comment("Enable generation of extra lilypads in lakes").define("enableExtraLilypads", true));
        config("enableExtraSeagrass", enableExtraSeagrass, BUILDER.comment("Enable generation of extra seagrass in lakes").define("enableExtraSeagrass", true));
        config("enableExtraRiverGrass", enableExtraRiverGrass, BUILDER.comment("Enable generation of extra grass in rivers").define("enableExtraRiverGrass", true));
        config("enableMossCarpets", enableMossCarpets, BUILDER.comment("Enable moss carpets in old growth taiga biomes").define("enableMossCarpets", true));
        config("enableTidePools", enableTidePools, BUILDER.comment("Enable of tide pools in stony shores").define("enableTidePools", true));
        config("enableCaveRoots", enableCaveRoots, BUILDER.comment("Enable cave roots").define("enableCaveRoots", true));
        config("enableBetterRuinedNetherPortals", enableBetterRuinedNetherPortals, BUILDER.comment("Enable better ruined nether portals").define("enableBetterRuinedNetherPortals", true));
        BUILDER.pop();

        BUILDER.push("Entity Options");
        config("enableJungleTropicalFish", enableJungleTropicalFish, BUILDER.comment("Enable spawning of tropical fish in jungles").define("enableJungleTropicalFish", true));
        BUILDER.pop();
    }

    static final ModConfigSpec COMMON_CONFIG = BUILDER.build();

    private static void config(String name, ModConfigSpec.BooleanValue spec, ModConfigSpec.BooleanValue value) {
        spec = value;
        configOptions.put(name, spec);
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {

    }
}
