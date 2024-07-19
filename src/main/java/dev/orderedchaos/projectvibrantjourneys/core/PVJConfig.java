package dev.orderedchaos.projectvibrantjourneys.core;

import com.mojang.datafixers.util.Pair;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Optional;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJConfig
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static HashMap<String, Pair<ModConfigSpec.BooleanValue, Optional<ModConfigSpec.DoubleValue>>> configOptions = new HashMap<>();
    public static HashMap<String, ModConfigSpec.DoubleValue> weightOptions = new HashMap<>();

    // Features
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
    public static ModConfigSpec.BooleanValue enableWatergrass;
    public static ModConfigSpec.BooleanValue enableGravelPits;
    public static ModConfigSpec.BooleanValue enableGoldPits;
    public static ModConfigSpec.BooleanValue enableBeachedKelp;
    public static ModConfigSpec.BooleanValue enableDriedBeachedKelp;
    public static ModConfigSpec.BooleanValue enableGlowingBlueFungus;
    public static ModConfigSpec.BooleanValue enableCherryGroveBamboo;
    public static ModConfigSpec.BooleanValue enableMuddyBones;
    public static ModConfigSpec.BooleanValue enableLotusPonds;
    public static ModConfigSpec.BooleanValue enableFloatingPinkLotus;
    public static ModConfigSpec.BooleanValue enableHotSprings;
    public static ModConfigSpec.BooleanValue enableBushes;
    public static ModConfigSpec.BooleanValue enableWildflowers;
    public static ModConfigSpec.BooleanValue enableBoggedRemains;
    public static ModConfigSpec.BooleanValue enableSlimeNodules;

    // Feature Weights
    public static ModConfigSpec.DoubleValue rocksWeight;
    public static ModConfigSpec.DoubleValue twigsWeight;
    public static ModConfigSpec.DoubleValue fallenLeavesWeight;
    public static ModConfigSpec.DoubleValue bonesWeight;
    public static ModConfigSpec.DoubleValue charredBonesWeight;
    public static ModConfigSpec.DoubleValue iceChunksWeight;
    public static ModConfigSpec.DoubleValue pineconesWeight;
    public static ModConfigSpec.DoubleValue seashellsWeight;
    public static ModConfigSpec.DoubleValue fallenTreesWeight;
    public static ModConfigSpec.DoubleValue seaOatsWeight;
    public static ModConfigSpec.DoubleValue cattailsWeight;
    public static ModConfigSpec.DoubleValue beachGrassWeight;
    public static ModConfigSpec.DoubleValue barkMushroomsWeight;
    public static ModConfigSpec.DoubleValue glowcapWeight;
    public static ModConfigSpec.DoubleValue cindercaneWeight;
    public static ModConfigSpec.DoubleValue netherNettlesWeight;
    public static ModConfigSpec.DoubleValue shortGrassWeight;
    public static ModConfigSpec.DoubleValue naturalCobwebsWeight;
    public static ModConfigSpec.DoubleValue smallCactiWeight;
    public static ModConfigSpec.DoubleValue pricklyBushWeight;
    public static ModConfigSpec.DoubleValue reedsWeight;
    public static ModConfigSpec.DoubleValue iciclesWeight;
    public static ModConfigSpec.DoubleValue sandySproutsWeight;
    public static ModConfigSpec.DoubleValue extraLilypadsWeight;
    public static ModConfigSpec.DoubleValue extraSeagrassWeight;
    public static ModConfigSpec.DoubleValue extraRiverGrassWeight;
    public static ModConfigSpec.DoubleValue mossCarpetsWeight;
    public static ModConfigSpec.DoubleValue tidePoolsWeight;
    public static ModConfigSpec.DoubleValue caveRootsWeight;
    public static ModConfigSpec.DoubleValue betterRuinedNetherPortalsWeight;
    public static ModConfigSpec.DoubleValue watergrassWeight;
    public static ModConfigSpec.DoubleValue gravelPitWeight;
    public static ModConfigSpec.DoubleValue goldPitWeight;
    public static ModConfigSpec.DoubleValue beachedKelpWeight;
    public static ModConfigSpec.DoubleValue driedBeachedKelpWeight;
    public static ModConfigSpec.DoubleValue glowingBlueFungusWeight;
    public static ModConfigSpec.DoubleValue cherryGroveBambooWeight;
    public static ModConfigSpec.DoubleValue muddyBonesWeight;
    public static ModConfigSpec.DoubleValue lotusPondWeight;
    public static ModConfigSpec.DoubleValue floatingPinkLotusWeight;
    public static ModConfigSpec.DoubleValue hotSpringsWeight;
    public static ModConfigSpec.DoubleValue bushWeight;
    public static ModConfigSpec.DoubleValue wildflowersWeight;
    public static ModConfigSpec.DoubleValue boggedRemainsWeight;
    public static ModConfigSpec.DoubleValue slimeNodulesWeight;

    // Spawns
    public static ModConfigSpec.BooleanValue enableJungleTropicalFish;

    // Other
    public static ModConfigSpec.BooleanValue allowBoggedFromBoggedRemains;
    public static ModConfigSpec.DoubleValue boggedChance;

    static {
        BUILDER.push("World Generation");
        assignWeightedConfigValues("enableRocks", enableRocks,"rocksWeight", rocksWeight, "Enable generation of rocks");
        assignWeightedConfigValues("enableTwigs", enableTwigs, "twigsWeight", twigsWeight, "Enable generation of twigs");
        assignWeightedConfigValues("enableFallenLeaves", enableFallenLeaves, "fallenLeavesWeight", fallenLeavesWeight, "Enable generation of fallen leaves");
        assignWeightedConfigValues("enableBones", enableBones, "bonesWeight", bonesWeight, "Enable generation of bones");
        assignWeightedConfigValues("enableCharredBones", enableCharredBones, "charredBonesWeight", charredBonesWeight, "Enable generation of charred bones");
        assignWeightedConfigValues("enableIceChunks", enableIceChunks, "iceChunksWeight", iceChunksWeight, "Enable generation of ice chunks");
        assignWeightedConfigValues("enablePinecones", enablePinecones, "pineconesWeight", pineconesWeight,  "Enable generation of pinecones");
        assignWeightedConfigValues("enableSeashells", enableSeashells, "seashellsWeight", seashellsWeight, "Enable generation of seashells");

        assignWeightedConfigValues("enableFallenTrees", enableFallenTrees, "fallenTreesWeight", fallenTreesWeight, "Enable generation of fallen trees");

        assignWeightedConfigValues("enableSeaOats", enableSeaOats, "seaOatsWeight", seaOatsWeight, "Enable generation of sea oats");
        assignWeightedConfigValues("enableCattails", enableCattails, "cattailsWeight", cattailsWeight, "Enable generation of cattails");
        assignWeightedConfigValues("enableBeachGrass", enableBeachGrass, "beachGrassWeight", beachGrassWeight, "Enable generation of beach grass");
        assignWeightedConfigValues("enableBarkMushrooms", enableBarkMushrooms, "barkMushroomsWeight", barkMushroomsWeight, "Enable generation of bark mushrooms");
        assignWeightedConfigValues("enableGlowcap", enableGlowcap, "glowcapWeight", glowcapWeight, "Enable generation of glowcap");
        assignWeightedConfigValues("enableCindercane", enableCindercane, "cindercaneWeight", cindercaneWeight, "Enable generation of cindercane");
        assignWeightedConfigValues("enableNetherNettles", enableNetherNettles, "netherNettlesWeight", netherNettlesWeight, "Enable generation of nether nettles");
        assignWeightedConfigValues("enableShortGrass", enableShortGrass, "shortGrassWeight", shortGrassWeight, "Enable generation of short grass");
        assignWeightedConfigValues("enableNaturalCobwebs", enableNaturalCobwebs, "naturalCobwebsWeight", naturalCobwebsWeight, "Enable generation of natural cobwebs");
        assignWeightedConfigValues("enableSmallCacti", enableSmallCacti, "smallCactiWeight", smallCactiWeight, "Enable generation of small cacti");
        assignWeightedConfigValues("enablePricklyBush", enablePricklyBush, "pricklyBushWeight", pricklyBushWeight, "Enable generation of prickly bushes");
        assignWeightedConfigValues("enableReeds", enableReeds, "reedsWeight", reedsWeight, "Enable generation of reeds");
        assignWeightedConfigValues("enableIcicles", enableIcicles, "iciclesWeight", iciclesWeight, "Enable generation of icicles");
        assignWeightedConfigValues("enableSandySprouts", enableSandySprouts, "sandySproutsWeight", sandySproutsWeight, "Enable generation of sandy sprouts");
        assignWeightedConfigValues("enableWatergrass", enableWatergrass, "watergrassWeight", watergrassWeight, "Enable generation of watergrass");
        assignWeightedConfigValues("enableGravelPits", enableGravelPits, "gravelPitWeight", gravelPitWeight, "Enable generation of gravel pits");
        assignWeightedConfigValues("enableGoldPits", enableGoldPits, "goldPitWeight", goldPitWeight, "Enable generation of gold pits");
        assignWeightedConfigValues("enableBeachedKelp", enableBeachedKelp, "beachedKelpWeight", beachedKelpWeight, "Enable generation of beached kelp");
        assignWeightedConfigValues("enableExtraLilypads", enableExtraLilypads, "extraLilypadsWeight", extraLilypadsWeight, "Enable generation of extra lilypads in lakes");
        assignWeightedConfigValues("enableExtraSeagrass", enableExtraSeagrass, "extraSeagrassWeight", extraSeagrassWeight, "Enable generation of extra seagrass in lakes");
        assignWeightedConfigValues("enableExtraRiverGrass", enableExtraRiverGrass, "extraRiverGrassWeight", extraRiverGrassWeight, "Enable generation of extra grass in rivers");
        assignWeightedConfigValues("enableMossCarpets", enableMossCarpets, "mossCarpetsWeight", mossCarpetsWeight, "Enable moss carpets in old growth taiga biomes");
        assignWeightedConfigValues("enableTidePools", enableTidePools, "tidePoolsWeight", tidePoolsWeight, "Enable of tide pools in stony shores");
        assignWeightedConfigValues("enableCaveRoots", enableCaveRoots, "caveRootsWeight", caveRootsWeight, "Enable cave roots");
        assignWeightedConfigValues("enableBetterRuinedNetherPortals", enableBetterRuinedNetherPortals, "betterRuinedNetherPortalsWeight", betterRuinedNetherPortalsWeight, "Enable better ruined nether portals");
        assignWeightedConfigValues("enableDriedBeachedKelp", enableDriedBeachedKelp, "driedBeachedKelpWeight", driedBeachedKelpWeight, "Enable generation of dried beached kelp");
        assignWeightedConfigValues("enableGlowingBlueFungus", enableGlowingBlueFungus, "glowingBlueFungusWeight", glowingBlueFungusWeight, "Enable generation of glowing blue fungus");
        assignWeightedConfigValues("enableCherryGroveBamboo", enableCherryGroveBamboo, "cherryGroveBambooWeight", cherryGroveBambooWeight, "Enable generation of bamboo in cherry groves");
        assignWeightedConfigValues("enableMuddyBones", enableMuddyBones, "muddyBonesWeight", muddyBonesWeight, "Enable generation of muddy bones");
        assignWeightedConfigValues("enableLotusPonds", enableLotusPonds, "lotusPondWeight", lotusPondWeight, "Enable generation of lotus ponds in cherry groves");
        assignWeightedConfigValues("enableFloatingPinkLotus", enableFloatingPinkLotus, "floatingPinkLotusWeight", floatingPinkLotusWeight, "Enable generation of pink lotuses in flower forests");
        assignWeightedConfigValues("enableHotSprings", enableHotSprings, "hotSpringsWeight", hotSpringsWeight, "Enable generation of hot springs");
        assignWeightedConfigValues("enableBushes", enableBushes, "bushWeight", bushWeight, "Enable generation of bushes");
        assignWeightedConfigValues("enableWildflowers", enableWildflowers, "wildflowersWeight", wildflowersWeight, "Enable generation of wildflowers");
        assignWeightedConfigValues("enableBoggedRemains", enableBoggedRemains, "boggedRemainsWeight", boggedRemainsWeight, "Enable generation of bogged remains");
        assignWeightedConfigValues("enableSlimeNodules", enableSlimeNodules, "slimeNodulesWeight", slimeNodulesWeight, "Enable generation of slime nodules");
        BUILDER.pop();

        BUILDER.push("Entity Options");
        assignSpawnConfigValue("enableJungleTropicalFish", enableJungleTropicalFish, "Enable spawning of tropical fish in jungles");
        BUILDER.pop();

        BUILDER.push("Feature Options");
        allowBoggedFromBoggedRemains = BUILDER.comment("Allow bogged to spawn from bogged remains").define("allowBoggedFromBoggedRemains", true);
        boggedChance = BUILDER.comment("Chance for a bogged to spawn from bogged remains").defineInRange("boggedChance", 0.15D, 0.0D, 1.0D);
        BUILDER.pop();
    }

    static final ModConfigSpec COMMON_CONFIG = BUILDER.build();

    private static void assignWeightedConfigValues(String name, ModConfigSpec.BooleanValue spec, @Nullable String weightSpecName, ModConfigSpec.DoubleValue weightSpec, @Nullable String specComment, @Nullable String weightSpecComment) {
        if (specComment != null) {
            BUILDER.comment(specComment);
        }
        spec = BUILDER.define(name, true);
        if (weightSpecComment != null) {
            BUILDER.comment(weightSpecComment);
        }
        weightSpec = BUILDER.defineInRange(weightSpecName, 1.0D, 0.0D, 1.0D);

        weightOptions.put(weightSpecName, weightSpec);
        configOptions.put(name, Pair.of(spec, Optional.ofNullable(weightSpec)));
    }

    private static void assignSpawnConfigValue(String name, ModConfigSpec.BooleanValue spec, @Nullable String specComment) {
        if (specComment != null) {
            BUILDER.comment(specComment);
        }
        spec = BUILDER.define(name, true);
        configOptions.put(name, Pair.of(spec, Optional.empty()));
    }

    private static void assignWeightedConfigValues(String name, ModConfigSpec.BooleanValue spec, @Nullable String weightSpecName, @Nullable ModConfigSpec.DoubleValue weightSpec, @Nullable String specComment) {
        assignWeightedConfigValues(name, spec, weightSpecName, weightSpec, specComment, null);
    }
    
    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {

    }
}
