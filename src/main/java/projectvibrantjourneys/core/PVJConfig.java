package projectvibrantjourneys.core;

import java.nio.file.Path;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
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
	public static ForgeConfigSpec.ConfigValue<Boolean> jungleTropicalFish;
	
	public static ForgeConfigSpec.ConfigValue<Integer> groundcoverChance;
	
	static {
		rocks = COMMON_BUILDER.define("rocks", true);
		twigs = COMMON_BUILDER.define("twigs", true);
		fallenLeaves = COMMON_BUILDER.define("fallenLeaves", true);
		bones = COMMON_BUILDER.define("bones", true);
		charredBones = COMMON_BUILDER.define("charredBones", true);
		iceChunks = COMMON_BUILDER.define("iceChunks", true);
		pinecones = COMMON_BUILDER.define("pinecones", true);
		seashells = COMMON_BUILDER.define("seashells", true);
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
		jungleTropicalFish = COMMON_BUILDER.comment("Tropical fish in jungles").define("jungleTropicalFish", true);
		
		groundcoverChance = COMMON_BUILDER.comment(" % chance of groundcover placement").defineInRange("groundcoverChance", 100, 0, 100);
		
		COMMON_CONFIG = COMMON_BUILDER.build();
	}
	
	public static void loadConfig(ForgeConfigSpec spec, Path path) {
		final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
		
		configData.load();
		spec.setConfig(configData);
	}
}
