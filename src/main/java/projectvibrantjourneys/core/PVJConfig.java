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
	public static final String CAT_MOBS = "mobs";
	
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
	public static ForgeConfigSpec.ConfigValue<List<String>> cobwebBiomes;
	
	public static ForgeConfigSpec.ConfigValue<List<String>> ironNuggetBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> goldNuggetBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> goldNuggetCommonBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> flintBiomes;
	
	public static ForgeConfigSpec.ConfigValue<List<String>> dungBiomes;
	
	public static ForgeConfigSpec.ConfigValue<List<String>> seaOatsBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> beachGrassBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> cattailBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> smallCactusBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> barkMushroomBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> frogbitBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> duckweedBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> glowcapBiomes;
	
	public static ForgeConfigSpec.ConfigValue<List<String>> flyBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> fireflyBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> starfishBiomes;
	
	public static ForgeConfigSpec.ConfigValue<List<String>> ghostBiomes;
	
	public static ForgeConfigSpec.ConfigValue<List<String>> skeletalKnightBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> shadeBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> bansheeBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> wraithBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> hauntBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> specterBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> phantasmBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> nightmareBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> iceCubeBiomes;
	
	static {
		ConfigDefaults.load();
		COMMON_BUILDER.comment("World Gen Settings").push(CAT_WORLDGEN);
		initWorldGen();
		COMMON_BUILDER.pop();
		COMMON_BUILDER.comment("Mob Settings").push(CAT_MOBS);
		initMobs();
		COMMON_BUILDER.pop();
		
		COMMON_CONFIG = COMMON_BUILDER.build();
		CLIENT_CONFIG = CLIENT_BUILDER.build();
	}
	
	private static void initWorldGen() {
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
		cobwebBiomes = COMMON_BUILDER.comment("Cobweb Biomes").define("cobwebBiomes", ConfigDefaults.COBWEB);
		
		ironNuggetBiomes = COMMON_BUILDER.comment("Iron Nugget Biomes").define("ironNuggetBiomes", ConfigDefaults.IRON_NUGGET);
		goldNuggetBiomes = COMMON_BUILDER.comment("Gold Nugget Biomes").define("goldNuggetBiomes", ConfigDefaults.GOLD_NUGGET);
		goldNuggetCommonBiomes = COMMON_BUILDER.comment("Gold Nugget Biomes (Common)").define("goldNuggetCommonBiomes", ConfigDefaults.GOLD_NUGGET_COMMON);
		flintBiomes = COMMON_BUILDER.comment("Flint Biomes").define("flintBiomes", ConfigDefaults.FLINT);
		
		dungBiomes = COMMON_BUILDER.comment("Dung Biomes").define("dungBiomes", ConfigDefaults.DUNG);
		
		seaOatsBiomes = COMMON_BUILDER.comment("Sea Oats Biomes").define("seaOatsBiomes", ConfigDefaults.SEA_OATS);
		beachGrassBiomes = COMMON_BUILDER.comment("Beach Grass Biomes").define("beachGrassBiomes", ConfigDefaults.BEACH_GRASS);
		cattailBiomes = COMMON_BUILDER.comment("Cattail Biomes").define("cattailBiomes", ConfigDefaults.CATTAIL);
		smallCactusBiomes = COMMON_BUILDER.comment("Small Cactus Biomes").define("smallCactusBiomes", ConfigDefaults.SMALL_CACTUS);
		barkMushroomBiomes = COMMON_BUILDER.comment("Bark Mushroom Biomes").define("barkMushroomBiomes", ConfigDefaults.BARK_MUSHROOM);
		frogbitBiomes = COMMON_BUILDER.comment("Frogbit Biomes").define("frogbitBiomes", ConfigDefaults.FROGBIT);
		duckweedBiomes = COMMON_BUILDER.comment("Duckweed Biomes").define("duckweedBiomes", ConfigDefaults.DUCKWEED);
		glowcapBiomes = COMMON_BUILDER.comment("Glowcap Biomes").define("glowcapBiomes", ConfigDefaults.GLOWCAP);
	}
	
	private static void initMobs() {
		flyBiomes = COMMON_BUILDER.comment("Fly Biomes").define("flyBiomes", ConfigDefaults.FLY);
		fireflyBiomes = COMMON_BUILDER.comment("Firefly Biomes").define("fireflyBiomes", ConfigDefaults.FIREFLY);
		starfishBiomes = COMMON_BUILDER.comment("Starfish Biomes").define("starfishBiomes", ConfigDefaults.STARFISH);
		
		ghostBiomes = COMMON_BUILDER.comment("Ghost Biomes").define("ghostBiomes", ConfigDefaults.GHOST);
		
		skeletalKnightBiomes = COMMON_BUILDER.comment("Skeletal Knight Biomes").define("skeletalKnightBiomes", ConfigDefaults.SKELETAL_KNIGHT);
		shadeBiomes = COMMON_BUILDER.comment("Shade Biomes").define("shadeBiomes", ConfigDefaults.SHADE);
		bansheeBiomes = COMMON_BUILDER.comment("Banshee Biomes").define("bansheeBiomes", ConfigDefaults.BANSHEE);
		wraithBiomes = COMMON_BUILDER.comment("Wraith Biomes").define("wraithBiomes", ConfigDefaults.WRAITH);
		hauntBiomes = COMMON_BUILDER.comment("Haunt Biomes").define("hauntBiomes", ConfigDefaults.HAUNT);
		specterBiomes = COMMON_BUILDER.comment("Specter Biomes").define("specterBiomes", ConfigDefaults.SPECTER);
		phantasmBiomes = COMMON_BUILDER.comment("Phantasm Biomes").define("phantasmBiomes", ConfigDefaults.PHANTASM);
		nightmareBiomes = COMMON_BUILDER.comment("Nightmare Biomes").define("nightmareBiomes", ConfigDefaults.NIGHTMARE);
		iceCubeBiomes = COMMON_BUILDER.comment("Ice Cube Biomes").define("icecubeBiomes", ConfigDefaults.ICE_CUBE);
	}
	
	public static void loadConfig(ForgeConfigSpec spec, Path path) {
		final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
		
		configData.load();
		spec.setConfig(configData);
	}
}
