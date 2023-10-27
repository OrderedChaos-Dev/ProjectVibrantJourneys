package dev.orderedchaos.projectvibrantjourneys.core.config;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;

@Mod.EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID)
public class PVJConfig {
  private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
  public static HashMap<String, ForgeConfigSpec.BooleanValue> configOptions = new HashMap<>();

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
  public static ForgeConfigSpec.BooleanValue enableSandySprouts;

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
    config("enableIcicles", enableIcicles, BUILDER.comment("Enable generation of icicles").define("enableIcicles ", true));
    config("enableSandySprouts", enableSandySprouts, BUILDER.comment("Enable generation of sandy sprouts").define("enableSandySprouts ", true));

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

  private static void config(String name, ForgeConfigSpec.BooleanValue spec, ForgeConfigSpec.BooleanValue value) {
    spec = value;
    configOptions.put(name, spec);
  }

  public static final ForgeConfigSpec COMMON_CONFIG = BUILDER.build();
}
