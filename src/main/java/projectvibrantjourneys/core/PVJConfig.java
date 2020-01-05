package projectvibrantjourneys.core;

import java.nio.file.Path;
import java.util.List;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PVJConfig {
	
	public static final String CAT_WORLDGEN = "worldgen";
	public static final String CAT_GROUNDCOVER = "groundcover";
	public static final String CAT_GROUNDCOVER_TWIGS = "twigs";
	public static final String CAT_GROUNDCOVER_FALLEN_LEAVES = "fallen leaves";
	public static final String CAT_GROUNDCOVER_ROCKS = "rocks";
	public static final String CAT_GROUNDCOVER_BONES = "bones";
	public static final String CAT_GROUNDCOVER_OTHER = "other";
	public static final String CAT_WORLDGEN_MISC = "misc";
	
	private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
	
	public static ForgeConfigSpec COMMON_CONFIG;
	public static ForgeConfigSpec CLIENT_CONFIG;
	
	/* WORLD GEN */
	public static ForgeConfigSpec.ConfigValue<List<String>> oakTwigsBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> oakTwigsSparseBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> birchTwigsBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> birchTwigsSparseBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> spruceTwigsBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> spruceTwigsSparseBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> jungleTwigsBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> jungleTwigsSparseBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> darkOakTwigsBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> darkOakTwigsSparseBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> acaciaTwigsBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> acaciaTwigsSparseBiomes;
	
	public static ForgeConfigSpec.ConfigValue<List<String>> rocksBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> sandstoneBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> redSandstoneBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> iceChunksBiomes;
	
	public static ForgeConfigSpec.ConfigValue<List<String>> bonesBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> bonesCommonBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> bonesNetherBiomes;
	
	public static ForgeConfigSpec.ConfigValue<List<String>> pineconesBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> seashellsBiomes;
	
	public static ForgeConfigSpec.ConfigValue<List<String>> bushBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> lilypadBiomes;
	
	public static ForgeConfigSpec.ConfigValue<List<String>> ironNuggetBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> goldNuggetBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> goldNuggetCommonBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> flintBiomes;
	
	static {
		ConfigDefaults.load();
		COMMON_BUILDER.comment("World Gen Settings").push(CAT_WORLDGEN);
		init();
		COMMON_BUILDER.pop();
		
		COMMON_CONFIG = COMMON_BUILDER.build();
		CLIENT_CONFIG = CLIENT_BUILDER.build();
	}
	
	private static void init() {
		oakTwigsBiomes = COMMON_BUILDER.comment("Normal frequency").define("oakTwigsBiomes", ConfigDefaults.OAK_TWIGS);
		oakTwigsSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("oakTwigsSparseBiomes", ConfigDefaults.OAK_TWIGS_SPARSE);
		COMMON_BUILDER.comment("Birch Twigs Biomes");
		birchTwigsBiomes = COMMON_BUILDER.comment("Normal frequency").define("birchTwigsBiomes", ConfigDefaults.BIRCH_TWIGS);
		birchTwigsSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("birchTwigsSparseBiomes", ConfigDefaults.BIRCH_TWIGS_SPARSE);
		COMMON_BUILDER.comment("Spruce Twigs Biomes");
		spruceTwigsBiomes = COMMON_BUILDER.comment("Normal frequency").define("spruceTwigsBiomes", ConfigDefaults.SPRUCE_TWIGS);
		spruceTwigsSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("spruceTwigsSparseBiomes", ConfigDefaults.SPRUCE_TWIGS_SPARSE);
		COMMON_BUILDER.comment("Jungle Twigs Biomes");
		jungleTwigsBiomes = COMMON_BUILDER.comment("Normal frequency").define("jungleTwigsBiomes", ConfigDefaults.JUNGLE_TWIGS);
		jungleTwigsSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("jungleTwigsSparseBiomes", ConfigDefaults.JUNGLE_TWIGS_SPARSE);
		COMMON_BUILDER.comment("Dark Oak Twigs Biomes");
		darkOakTwigsBiomes = COMMON_BUILDER.comment("Normal frequency").define("darkOakTwigsBiomes", ConfigDefaults.DARK_OAK_TWIGS);
		darkOakTwigsSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("darkOakTwigsSparseBiomes", ConfigDefaults.DARK_OAK_TWIGS_SPARSE);
		COMMON_BUILDER.comment("Acacia Twigs Biomes");
		acaciaTwigsBiomes = COMMON_BUILDER.comment("Normal frequency").define("acaciaTwigsBiomes", ConfigDefaults.ACACIA_TWIGS);
		acaciaTwigsSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("acaciaTwigsSparseBiomes", ConfigDefaults.ACACIA_TWIGS_SPARSE);
		
		rocksBiomes = COMMON_BUILDER.comment("Rocks Biomes (Stone, Cobblestone, Andesite, Diorite, Granite)").define("rocksBiomes", ConfigDefaults.ROCKS);
		sandstoneBiomes = COMMON_BUILDER.comment("Sandstone Rocks Biomes").define("sandstoneRocksBiomes", ConfigDefaults.SANDSTONE_ROCKS);
		redSandstoneBiomes = COMMON_BUILDER.comment("Red Sandstone Rocks Biomes").define("redSandstoneRocksBiomes", ConfigDefaults.RED_SANDSTONE_ROCKS);
		iceChunksBiomes = COMMON_BUILDER.comment("Ice Chunks Biomes").define("iceChunksBiomes", ConfigDefaults.ICE_CHUNKS);
		
		bonesBiomes = COMMON_BUILDER.comment("Bones Biomes").define("bonesBiomes", ConfigDefaults.BONES);
		bonesCommonBiomes = COMMON_BUILDER.comment("Bones Biomes (Common)").define("bonesCommonBiomes", ConfigDefaults.BONES_COMMON);
		bonesNetherBiomes = COMMON_BUILDER.comment("Bones Nether Biomes").define("bonesNetherBiomes", ConfigDefaults.BONES_NETHER);
		
		pineconesBiomes = COMMON_BUILDER.comment("Pinecones Biomes").define("pineconesBiomes", ConfigDefaults.PINECONES);
		seashellsBiomes = COMMON_BUILDER.comment("Seashells Biomes").define("seashellsBiomes", ConfigDefaults.SEASHELLS);
		
		bushBiomes = COMMON_BUILDER.comment("Bush Biomes").define("bushBiomes", ConfigDefaults.BUSH);
		lilypadBiomes = COMMON_BUILDER.comment("Lily Pad Biomes").define("lilypadBiomes", ConfigDefaults.LILYPAD);
		
		ironNuggetBiomes = COMMON_BUILDER.comment("Iron Nugget Biomes").define("ironNuggetBiomes", ConfigDefaults.IRON_NUGGET);
		goldNuggetBiomes = COMMON_BUILDER.comment("Gold Nugget Biomes").define("goldNuggetBiomes", ConfigDefaults.GOLD_NUGGET);
		goldNuggetCommonBiomes = COMMON_BUILDER.comment("Gold Nugget Biomes (Common)").define("goldNuggetCommonBiomes", ConfigDefaults.GOLD_NUGGET_COMMON);
		flintBiomes = COMMON_BUILDER.comment("Flint Biomes").define("flintBiomes", ConfigDefaults.FLINT);
	}
	
	public static void loadConfig(ForgeConfigSpec spec, Path path) {
		final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
		
		configData.load();
		spec.setConfig(configData);
	}
}
