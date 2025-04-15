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

  public static ForgeConfigSpec.BooleanValue enableWatergrass;
  public static ForgeConfigSpec.BooleanValue enableGravelPits;
  public static ForgeConfigSpec.BooleanValue enableGoldPits;
  public static ForgeConfigSpec.BooleanValue enableBeachedKelp;
  public static ForgeConfigSpec.BooleanValue enableDriedBeachedKelp;
  public static ForgeConfigSpec.BooleanValue enableGlowingBlueFungus;
  public static ForgeConfigSpec.BooleanValue enableMuddyBones;
  public static ForgeConfigSpec.BooleanValue enableLotusPonds;
  public static ForgeConfigSpec.BooleanValue enableFloatingPinkLotus;
  public static ForgeConfigSpec.BooleanValue enableHotSprings;
  public static ForgeConfigSpec.BooleanValue enableBushes;
  public static ForgeConfigSpec.BooleanValue enableWildflowers;
  public static ForgeConfigSpec.BooleanValue enableSlimeNodules;
  public static ForgeConfigSpec.BooleanValue enablePinkVines;

  public static ForgeConfigSpec.BooleanValue enableJungleTropicalFish;

  public static ForgeConfigSpec.BooleanValue replaceableGroundcover;

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
    config("enableDriedBeachedKelp", enableDriedBeachedKelp, BUILDER.comment("Enable generation of dried beached kelp").define("enableDriedBeachedKelp", true));
    config("enableGlowingBlueFungus", enableGlowingBlueFungus, BUILDER.comment("Enable generation of glowing blue fungus").define("enableGlowingBlueFungus", true));
    config("enableMuddyBones", enableMuddyBones, BUILDER.comment("Enable generation of muddy bones").define("enableMuddyBones", true));
    config("enableLotusPonds", enableLotusPonds, BUILDER.comment("Enable generation of lotus ponds in cherry groves").define("enableLotusPonds", true));
    config("enableFloatingPinkLotus", enableFloatingPinkLotus, BUILDER.comment("Enable generation of pink lotuses in flower forests").define("enableFloatingPinkLotus", true));
    config("enableHotSprings", enableHotSprings, BUILDER.comment("Enable generation of hot springs").define("enableHotSprings", true));
    config("enableBushes", enableBushes, BUILDER.comment("Enable generation of bushes").define("enableBushes", true));
    config("enableWildflowers", enableWildflowers, BUILDER.comment("Enable generation of wildflowers").define("enableWildflowers", true));
    config("enableSlimeNodules", enableSlimeNodules, BUILDER.comment("Enable generation of slime nodules").define("enableSlimeNodules", true));
    config("enablePinkVines", enablePinkVines, BUILDER.comment("Enable generation of pink vines").define("enablePinkVines", true));
    config("enableWatergrass", enableWatergrass, BUILDER.comment("Enable generation of watergrass").define("enableWatergrass", true));
    config("enableGravelPits", enableGravelPits, BUILDER.comment("Enable generation of gravel pits").define("enableGravelPits", true));
    config("enableGoldPits", enableGoldPits, BUILDER.comment("Enable generation of gold pits").define("enableGoldPits", true));
    config("enableBeachedKelp", enableBeachedKelp, BUILDER.comment("Enable generation of beached kelp").define("enableBeachedKelp", true));

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

    BUILDER.push("Misc Options");
    config("replaceableGroundcover", replaceableGroundcover, BUILDER.comment("Enable replaceable groundcover behavior - i.e. makes it behave like tall grass when placing blocks").define("replaceableGroundcover", true));
    BUILDER.pop();
  }

  private static void config(String name, ForgeConfigSpec.BooleanValue spec, ForgeConfigSpec.BooleanValue value) {
    spec = value;
    configOptions.put(name, spec);
  }

  public static final ForgeConfigSpec COMMON_CONFIG = BUILDER.build();
}
