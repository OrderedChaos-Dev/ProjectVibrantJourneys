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
	public static ForgeConfigSpec.ConfigValue<Boolean> fallenTrees;
	public static ForgeConfigSpec.ConfigValue<Boolean> moreSeagrass;
	public static ForgeConfigSpec.ConfigValue<Boolean> moreGrassInRivers;
	
	public static ForgeConfigSpec.ConfigValue<Boolean> enableFlies;
	public static ForgeConfigSpec.ConfigValue<Boolean> muteFlies;
	public static ForgeConfigSpec.ConfigValue<Boolean> jungleTropicalFish;
	
	public static ForgeConfigSpec.ConfigValue<Boolean> overgrownSpires;
	public static ForgeConfigSpec.ConfigValue<Boolean> verdantSands;
	
	public static ForgeConfigSpec.ConfigValue<Integer> groundcoverChance;
	public static ConfigValue<List<String>> groundcoverBlacklist;
	
	static {
		
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
		groundcoverBlacklist = COMMON_BUILDER.comment("Groundcover Biome Blacklist, example: [\"minecraft:plains\", \"minecraft:beach\"]").define("groundcoverBlacklist", new ArrayList<String>());
		COMMON_BUILDER.pop();
		seaOats = COMMON_BUILDER.define("seaOats", true);
		cattails = COMMON_BUILDER.define("cattails", true);
		barkMushrooms = COMMON_BUILDER.define("barkMushrooms", true);
		cobwebs = COMMON_BUILDER.define("cobwebs", true);
		bushes = COMMON_BUILDER.define("bushes", true);
		glowcap = COMMON_BUILDER.define("glowcap", true);
		netherNettles = COMMON_BUILDER.define("netherNettles", true);
		fallenTrees = COMMON_BUILDER.define("fallenTrees", true);
		moreSeagrass = COMMON_BUILDER.comment("Seagrass in lakes").define("moreSeagrass", true);
		moreGrassInRivers = COMMON_BUILDER.comment("Denser river grass").define("moreGrassInRivers", true);

		COMMON_BUILDER.pop();
		
		COMMON_BUILDER.push("Mob Settings");
		COMMON_BUILDER.push("Mob Toggles");
		enableFlies = COMMON_BUILDER.define("Enable Flies", true);
		COMMON_BUILDER.pop();
		COMMON_BUILDER.push("Misc Mob Settings");
		muteFlies = COMMON_BUILDER.define("Mute Flies", false);
		COMMON_BUILDER.pop();
		COMMON_BUILDER.push("Vanilla Mob Settings");
		jungleTropicalFish = COMMON_BUILDER.comment("Tropical fish in jungles").define("jungleTropicalFish", true);
		COMMON_BUILDER.pop();
		COMMON_BUILDER.pop();
		
		COMMON_BUILDER.comment("Biome Settings").push("Biomes");
		overgrownSpires = COMMON_BUILDER.define("overgrownSpires", true);
		verdantSands = COMMON_BUILDER.define("verdantSands", true);
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
