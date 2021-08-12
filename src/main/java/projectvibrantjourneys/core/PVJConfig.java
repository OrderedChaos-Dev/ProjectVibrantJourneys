package projectvibrantjourneys.core;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PVJConfig {
	private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
	
	public static ForgeConfigSpec COMMON_CONFIG;
	
	public static ForgeConfigSpec.ConfigValue<Boolean> rocks;
	public static ForgeConfigSpec.ConfigValue<Boolean> twigs;
	public static ForgeConfigSpec.ConfigValue<Boolean> fallenLeaves;
	public static ForgeConfigSpec.ConfigValue<Boolean> bones;
	public static ForgeConfigSpec.ConfigValue<Boolean> charredBones;
	public static ForgeConfigSpec.ConfigValue<Boolean> iceChunks;
	public static ForgeConfigSpec.ConfigValue<Boolean> pinecones;
	public static ForgeConfigSpec.ConfigValue<Boolean> seashells;
	public static ForgeConfigSpec.ConfigValue<Boolean> seaOats;
	public static ForgeConfigSpec.ConfigValue<Boolean> cattails;
	public static ForgeConfigSpec.ConfigValue<Boolean> barkMushrooms;
	public static ForgeConfigSpec.ConfigValue<Boolean> cobwebs;
	public static ForgeConfigSpec.ConfigValue<Boolean> bushes;
	public static ForgeConfigSpec.ConfigValue<Boolean> glowcap;
	public static ForgeConfigSpec.ConfigValue<Boolean> netherNettles;
	public static ForgeConfigSpec.ConfigValue<Boolean> shortGrass;
	public static ForgeConfigSpec.ConfigValue<Boolean> beachGrass;
	public static ForgeConfigSpec.ConfigValue<Boolean> fallenTrees;
	public static ForgeConfigSpec.ConfigValue<Boolean> moreSeagrass;
	public static ForgeConfigSpec.ConfigValue<Boolean> moreGrassInRivers;
	
	public static ForgeConfigSpec.ConfigValue<Boolean> enableFlies;
	public static ForgeConfigSpec.ConfigValue<Boolean> enableFireflies;
	public static ForgeConfigSpec.ConfigValue<Boolean> enableStarfish;
	public static ForgeConfigSpec.ConfigValue<Boolean> enableClams;
	public static ForgeConfigSpec.ConfigValue<Boolean> enableSnails;
	public static ForgeConfigSpec.ConfigValue<Boolean> enableSlugs;
	public static ForgeConfigSpec.ConfigValue<Boolean> enableSmallSpiders;
	public static ForgeConfigSpec.ConfigValue<Boolean> enableFrogs;
	public static ForgeConfigSpec.ConfigValue<Boolean> muteFlies;
	public static ForgeConfigSpec.ConfigValue<Boolean> jungleTropicalFish;
	public static ForgeConfigSpec.ConfigValue<Boolean> nightBats;
	
	public static ForgeConfigSpec.ConfigValue<Integer> flySpawnWeight;
	public static ForgeConfigSpec.ConfigValue<Integer> fireflySpawnWeight;
	public static ForgeConfigSpec.ConfigValue<Integer> starfishSpawnWeight;
	public static ForgeConfigSpec.ConfigValue<Integer> clamSpawnWeight;
	public static ForgeConfigSpec.ConfigValue<Integer> snailSpawnWeight;
	public static ForgeConfigSpec.ConfigValue<Integer> slugSpawnWeight;
	public static ForgeConfigSpec.ConfigValue<Integer> smallSpiderSpawnWeight;
	public static ForgeConfigSpec.ConfigValue<Integer> frogSpawnWeight;
	
	public static ForgeConfigSpec.ConfigValue<Boolean> enablePalmTrees;
	public static ForgeConfigSpec.ConfigValue<Boolean> enableJuniperTrees;
	
	public static ForgeConfigSpec.ConfigValue<Boolean> overgrown_spires;
	public static ForgeConfigSpec.ConfigValue<Boolean> verdant_sands;
	public static ForgeConfigSpec.ConfigValue<Boolean> boreal_forest;
	public static ForgeConfigSpec.ConfigValue<Boolean> snowy_boreal_forest;
	public static ForgeConfigSpec.ConfigValue<Boolean> redwoods;
	public static ForgeConfigSpec.ConfigValue<Boolean> snowy_redwoods;
	public static ForgeConfigSpec.ConfigValue<Boolean> redwood_peaks;
	public static ForgeConfigSpec.ConfigValue<Boolean> pine_meadows;
	public static ForgeConfigSpec.ConfigValue<Boolean> alpine_heights;
	public static ForgeConfigSpec.ConfigValue<Boolean> boreal_plateau;
	public static ForgeConfigSpec.ConfigValue<Boolean> willow_wetlands;
	public static ForgeConfigSpec.ConfigValue<Boolean> mangrove_marsh;
	public static ForgeConfigSpec.ConfigValue<Boolean> baobab_fields;
	public static ForgeConfigSpec.ConfigValue<Boolean> aspen_grove;
	public static ForgeConfigSpec.ConfigValue<Boolean> crimson_thicket;
	public static ForgeConfigSpec.ConfigValue<Boolean> prairie;
	public static ForgeConfigSpec.ConfigValue<Boolean> blossoming_fields;
	public static ForgeConfigSpec.ConfigValue<Boolean> autumnal_coniferous_forest;
	public static ForgeConfigSpec.ConfigValue<Boolean> desert_shrubland;
	public static ForgeConfigSpec.ConfigValue<Boolean> red_rock_valley;
	public static ForgeConfigSpec.ConfigValue<Boolean> crystal_lakes;
	public static ForgeConfigSpec.ConfigValue<Boolean> windswept_cliffs;
	
	public static ForgeConfigSpec.ConfigValue<Integer> overgrown_spires_weight;
	public static ForgeConfigSpec.ConfigValue<Integer> verdant_sands_weight;
	public static ForgeConfigSpec.ConfigValue<Integer> boreal_forest_weight;
	public static ForgeConfigSpec.ConfigValue<Integer> snowy_boreal_forest_weight;
	public static ForgeConfigSpec.ConfigValue<Integer> redwoods_weight;
	public static ForgeConfigSpec.ConfigValue<Integer> snowy_redwoods_weight;
	public static ForgeConfigSpec.ConfigValue<Integer> redwood_peaks_weight;
	public static ForgeConfigSpec.ConfigValue<Integer> pine_meadows_weight;
	public static ForgeConfigSpec.ConfigValue<Integer> alpine_heights_weight;
	public static ForgeConfigSpec.ConfigValue<Integer> boreal_plateau_weight;
	public static ForgeConfigSpec.ConfigValue<Integer> willow_wetlands_weight;
	public static ForgeConfigSpec.ConfigValue<Integer> mangrove_marsh_weight;
	public static ForgeConfigSpec.ConfigValue<Integer> baobab_fields_weight;
	public static ForgeConfigSpec.ConfigValue<Integer> aspen_grove_weight;
	public static ForgeConfigSpec.ConfigValue<Integer> crimson_thicket_weight;
	public static ForgeConfigSpec.ConfigValue<Integer> prairie_weight;
	public static ForgeConfigSpec.ConfigValue<Integer> blossoming_fields_weight;
	public static ForgeConfigSpec.ConfigValue<Integer> autumnal_coniferous_forest_weight;
	public static ForgeConfigSpec.ConfigValue<Integer> desert_shrubland_weight;
	public static ForgeConfigSpec.ConfigValue<Integer> red_rock_valley_weight;
	public static ForgeConfigSpec.ConfigValue<Integer> crystal_lakes_weight;
	public static ForgeConfigSpec.ConfigValue<Integer> windswept_cliffs_weight;
	
	public static ForgeConfigSpec.ConfigValue<Boolean> windswept_cliffs_particles;
	
	public static ForgeConfigSpec.ConfigValue<Integer> groundcoverChance;
	public static ConfigValue<List<String>> groundcoverBlacklist;
	
	public static ArrayList<String> groundcoverBlacklistDefault = new ArrayList<String>();
	
	static {
		groundcoverBlacklistDefault.add("minecraft:snowy_tundra");
		groundcoverBlacklistDefault.add("minecraft:snowy_mountains");
		
		COMMON_BUILDER.comment("Project: Vibrant Journeys settings").push("Settings");
		COMMON_BUILDER.comment("World Gen Settings").push("World Gen");
		COMMON_BUILDER.push("Groundcover");
		rocks = COMMON_BUILDER.define("rocks", true);
		twigs = COMMON_BUILDER.define("twigs", true);
		fallenLeaves = COMMON_BUILDER.define("fallenLeaves", true);
		bones = COMMON_BUILDER.define("bones", true);
		charredBones = COMMON_BUILDER.define("charredBones", true);
		iceChunks = COMMON_BUILDER.define("iceChunks", true);
		pinecones = COMMON_BUILDER.define("pinecones", true);
		seashells = COMMON_BUILDER.define("seashells", true);
		groundcoverChance = COMMON_BUILDER.comment(" % chance of groundcover placement").defineInRange("groundcoverChance", 100, 0, 100);
		groundcoverBlacklist = COMMON_BUILDER.comment("Groundcover Biome Blacklist, example: [\"minecraft:plains\", \"minecraft:beach\"]").define("groundcoverBlacklist", groundcoverBlacklistDefault);
		COMMON_BUILDER.pop();
		seaOats = COMMON_BUILDER.define("seaOats", true);
		cattails = COMMON_BUILDER.define("cattails", true);
		barkMushrooms = COMMON_BUILDER.define("barkMushrooms", true);
		cobwebs = COMMON_BUILDER.define("cobwebs", true);
		bushes = COMMON_BUILDER.define("bushes", true);
		glowcap = COMMON_BUILDER.define("glowcap", true);
		netherNettles = COMMON_BUILDER.define("netherNettles", true);
		shortGrass = COMMON_BUILDER.define("shortGrass", true);
		beachGrass = COMMON_BUILDER.define("beachGrass", true);
		fallenTrees = COMMON_BUILDER.define("fallenTrees", true);
		moreSeagrass = COMMON_BUILDER.comment("Seagrass in lakes").define("moreSeagrass", true);
		moreGrassInRivers = COMMON_BUILDER.comment("Denser river grass").define("moreGrassInRivers", true);

		COMMON_BUILDER.pop();
		
		COMMON_BUILDER.push("Mob Settings");
		COMMON_BUILDER.push("Mob Toggles");
		enableFlies = COMMON_BUILDER.define("Enable Flies", true);
		enableFireflies = COMMON_BUILDER.define("Enable Fireflies", true);
		enableStarfish = COMMON_BUILDER.define("Enable Starfish", true);
		enableClams = COMMON_BUILDER.define("Enable Clams", true);
		enableSnails = COMMON_BUILDER.define("Enable Snails", true);
		enableSlugs = COMMON_BUILDER.define("Enable Slugs", true);
		enableSmallSpiders = COMMON_BUILDER.define("Enable Small Spiders", true);
		enableFrogs = COMMON_BUILDER.define("Enable Frogs", true);
		COMMON_BUILDER.push("Mob Spawn Weights");
		flySpawnWeight = COMMON_BUILDER.define("Fly Spawn Weight", 15);
		fireflySpawnWeight = COMMON_BUILDER.define("Firefly Spawn Weight", 30);
		starfishSpawnWeight = COMMON_BUILDER.define("Starfish Spawn Weight", 30);
		clamSpawnWeight = COMMON_BUILDER.define("Clam Spawn Weight", 10);
		snailSpawnWeight = COMMON_BUILDER.define("Snail Spawn Weight", 30);
		slugSpawnWeight = COMMON_BUILDER.define("Slug Spawn Weight", 25);
		smallSpiderSpawnWeight = COMMON_BUILDER.define("Small Spider Spawn Weight", 5);
		frogSpawnWeight = COMMON_BUILDER.define("Frog Spawn Weight", 30);
		
		COMMON_BUILDER.pop(2);
		COMMON_BUILDER.push("Misc Mob Settings");
		muteFlies = COMMON_BUILDER.define("Mute Flies", false);
		COMMON_BUILDER.pop();
		COMMON_BUILDER.push("Vanilla Mob Settings");
		jungleTropicalFish = COMMON_BUILDER.comment("Tropical fish in jungles").define("jungleTropicalFish", true);
		nightBats = COMMON_BUILDER.comment("Bats spawn outside at night").define("nightBats", true);
		COMMON_BUILDER.pop();
		COMMON_BUILDER.pop();
		
		COMMON_BUILDER.comment("Biome Settings").push("Biomes");
		overgrown_spires = COMMON_BUILDER.define("overgrown_spires", true);
		verdant_sands = COMMON_BUILDER.define("verdant_sands", true);
		boreal_forest = COMMON_BUILDER.define("boreal_forest", true);
		snowy_boreal_forest = COMMON_BUILDER.define("snowy_boreal_forest", true);
		redwoods = COMMON_BUILDER.define("redwoods", true);
		snowy_redwoods = COMMON_BUILDER.define("snowy_redwoods", true);
		redwood_peaks = COMMON_BUILDER.define("redwood_peaks", true);
		pine_meadows = COMMON_BUILDER.define("pine_meadows", true);
		alpine_heights = COMMON_BUILDER.define("alpine_heights", true);
		boreal_plateau = COMMON_BUILDER.define("boreal_plateau", true);
		aspen_grove = COMMON_BUILDER.define("aspen_grove", true);
		mangrove_marsh = COMMON_BUILDER.define("mangrove_marsh", true);
		willow_wetlands = COMMON_BUILDER.define("willow_wetlands", true);
		baobab_fields = COMMON_BUILDER.define("baobab_fields", true);
		prairie = COMMON_BUILDER.define("prairie", true);
		blossoming_fields = COMMON_BUILDER.define("blossoming_fields", true);
		autumnal_coniferous_forest = COMMON_BUILDER.define("autumnal_coniferous_forest", true);
		crimson_thicket = COMMON_BUILDER.define("crimson_thicket", true);
		desert_shrubland = COMMON_BUILDER.define("desert_shrubland", true);
		red_rock_valley = COMMON_BUILDER.define("red_rock_valley", true);
		crystal_lakes = COMMON_BUILDER.define("crystal_lakes", true);
		windswept_cliffs = COMMON_BUILDER.define("windswept_cliffs", true);
		
		COMMON_BUILDER.comment("Biome Weights").push("Biome Weights");
		overgrown_spires_weight = COMMON_BUILDER.define("overgrown_spires_weight", 3);
		verdant_sands_weight = COMMON_BUILDER.define("verdant_sands_weight", 3);
		boreal_forest_weight = COMMON_BUILDER.define("boreal_forest_weight", 3);
		snowy_boreal_forest_weight = COMMON_BUILDER.define("snowy_boreal_forest_weight", 3);
		redwoods_weight = COMMON_BUILDER.define("redwoods_weight", 3);
		snowy_redwoods_weight = COMMON_BUILDER.define("snowy_redwoods_weight", 3);
		redwood_peaks_weight = COMMON_BUILDER.define("redwood_peaks_weight", 3);
		pine_meadows_weight = COMMON_BUILDER.define("pine_meadows_weight", 3);
		alpine_heights_weight = COMMON_BUILDER.define("alpine_heights_weight", 3);
		boreal_plateau_weight = COMMON_BUILDER.define("boreal_plateau_weight", 3);
		aspen_grove_weight = COMMON_BUILDER.define("aspen_grove_weight", 3);
		mangrove_marsh_weight = COMMON_BUILDER.define("mangrove_marsh_weight", 3);
		willow_wetlands_weight = COMMON_BUILDER.define("willow_wetlands_weight", 3);
		baobab_fields_weight = COMMON_BUILDER.define("baobab_fields_weight", 3);
		prairie_weight = COMMON_BUILDER.define("prairie_weight", 3);
		blossoming_fields_weight = COMMON_BUILDER.define("blossoming_fields_weight", 3);
		autumnal_coniferous_forest_weight = COMMON_BUILDER.define("autumnal_coniferous_forest_weight", 3);
		crimson_thicket_weight = COMMON_BUILDER.define("crimson_thicket_weight", 3);
		desert_shrubland_weight = COMMON_BUILDER.define("desert_shrubland_weight", 3);
		red_rock_valley_weight = COMMON_BUILDER.define("red_rock_valley_weight", 3);
		crystal_lakes_weight = COMMON_BUILDER.define("crystal_lakes_weight", 3);
		windswept_cliffs_weight = COMMON_BUILDER.define("windswept_cliffs_weight", 3);
		COMMON_BUILDER.pop();
		
		COMMON_BUILDER.comment("Biome Ambience Settings").push("Biome Ambience");
		windswept_cliffs_particles = COMMON_BUILDER.define("windswept_cliffs_particles", true);
		COMMON_BUILDER.pop(2);
		
		COMMON_BUILDER.comment("Tree Settings").push("Tree Settings");
		enablePalmTrees = COMMON_BUILDER.define("enablePalmTrees", true);
		enableJuniperTrees = COMMON_BUILDER.define("enableJuniperTrees", true);
		COMMON_BUILDER.pop();
		
		COMMON_BUILDER.pop();
		COMMON_CONFIG = COMMON_BUILDER.build();
	}
	
	public static void loadConfig(ForgeConfigSpec spec, Path path) {
		final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
		
		configData.load();
		spec.setConfig(configData);
	}
}
