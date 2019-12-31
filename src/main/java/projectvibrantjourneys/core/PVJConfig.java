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
	
	static {
		ConfigDefaults.load();
		COMMON_BUILDER.comment("World Gen Settings").push(CAT_WORLDGEN);
		twigsBiomes();
		rocksBiomes();
		bonesBiomes();
		pineconesSeashellsBiomes();
		COMMON_BUILDER.pop();
		
		COMMON_CONFIG = COMMON_BUILDER.build();
		CLIENT_CONFIG = CLIENT_BUILDER.build();
	}
	
	private static void twigsBiomes() {
		COMMON_BUILDER.comment("Oak Twigs Biomes");
		oakTwigsBiomes = COMMON_BUILDER.comment("Normal frequency").define("oakTwigsBiomes", ConfigDefaults.OAK_TWIGS_DEFAULT);
		oakTwigsSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("oakTwigsSparseBiomes", ConfigDefaults.OAK_TWIGS_SPARSE_DEFAULT);
		COMMON_BUILDER.comment("Birch Twigs Biomes");
		birchTwigsBiomes = COMMON_BUILDER.comment("Normal frequency").define("birchTwigsBiomes", ConfigDefaults.BIRCH_TWIGS_DEFAULT);
		birchTwigsSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("birchTwigsSparseBiomes", ConfigDefaults.BIRCH_TWIGS_SPARSE_DEFAULT);
		COMMON_BUILDER.comment("Spruce Twigs Biomes");
		spruceTwigsBiomes = COMMON_BUILDER.comment("Normal frequency").define("spruceTwigsBiomes", ConfigDefaults.SPRUCE_TWIGS_DEFAULT);
		spruceTwigsSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("spruceTwigsSparseBiomes", ConfigDefaults.SPRUCE_TWIGS_SPARSE_DEFAULT);
		COMMON_BUILDER.comment("Jungle Twigs Biomes");
		jungleTwigsBiomes = COMMON_BUILDER.comment("Normal frequency").define("jungleTwigsBiomes", ConfigDefaults.JUNGLE_TWIGS_DEFAULT);
		jungleTwigsSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("jungleTwigsSparseBiomes", ConfigDefaults.JUNGLE_TWIGS_SPARSE_DEFAULT);
		COMMON_BUILDER.comment("Dark Oak Twigs Biomes");
		darkOakTwigsBiomes = COMMON_BUILDER.comment("Normal frequency").define("darkOakTwigsBiomes", ConfigDefaults.DARK_OAK_TWIGS_DEFAULT);
		darkOakTwigsSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("darkOakTwigsSparseBiomes", ConfigDefaults.DARK_OAK_TWIGS_SPARSE_DEFAULT);
		COMMON_BUILDER.comment("Acacia Twigs Biomes");
		acaciaTwigsBiomes = COMMON_BUILDER.comment("Normal frequency").define("acaciaTwigsBiomes", ConfigDefaults.ACACIA_TWIGS_DEFAULT);
		acaciaTwigsSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("acaciaTwigsSparseBiomes", ConfigDefaults.ACACIA_TWIGS_SPARSE_DEFAULT);
	}
	
	private static void rocksBiomes() {
		rocksBiomes = COMMON_BUILDER.comment("Rocks Biomes (Stone, Cobblestone, Andesite, Diorite, Granite)").define("rocksBiomes", ConfigDefaults.ROCKS_DEFAULT);
		sandstoneBiomes = COMMON_BUILDER.comment("Sandstone Rocks Biomes").define("sandstoneRocksBiomes", ConfigDefaults.SANDSTONE_ROCKS_DEFAULT);
		redSandstoneBiomes = COMMON_BUILDER.comment("Red Sandstone Rocks Biomes").define("redSandstoneRocksBiomes", ConfigDefaults.RED_SANDSTONE_ROCKS_DEFAULT);
		iceChunksBiomes = COMMON_BUILDER.comment("Ice Chunks Biomes").define("iceChunksBiomes", ConfigDefaults.ICE_CHUNKS_DEFAULT);
	}
	
	private static void bonesBiomes() {
		bonesBiomes = COMMON_BUILDER.comment("Bones Biomes").define("bonesBiomes", ConfigDefaults.BONES_DEFAULT);
		bonesCommonBiomes = COMMON_BUILDER.comment("Bones Biomes (Common)").define("bonesCommonBiomes", ConfigDefaults.BONES_COMMON_DEFAULT);
		bonesNetherBiomes = COMMON_BUILDER.comment("Bones Nether Biomes").define("bonesNetherBiomes", ConfigDefaults.BONES_NETHER_DEFAULT);
	}
	
	private static void pineconesSeashellsBiomes() {
		pineconesBiomes = COMMON_BUILDER.comment("Pinecones Biomes").define("pineconesBiomes", ConfigDefaults.PINECONES_DEFAULT);
		seashellsBiomes = COMMON_BUILDER.comment("Seashells Biomes").define("seashellsBiomes", ConfigDefaults.SEASHELLS_DEFAULT);
	}
	
	public static void loadConfig(ForgeConfigSpec spec, Path path) {
		final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
		
		configData.load();
		spec.setConfig(configData);
	}
}
