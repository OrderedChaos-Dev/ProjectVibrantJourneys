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
	public static ForgeConfigSpec.ConfigValue<List<String>> oakTreesBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> oakTreesSparseBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> birchTreesBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> birchTreesSparseBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> spruceTreesBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> spruceTreesSparseBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> jungleTreesBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> jungleTreesSparseBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> darkOakTreesBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> darkOakTreesSparseBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> acaciaTreesBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> acaciaTreesSparseBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> firTreesBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> firTreesSparseBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> pineTreesBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> pineTreesSparseBiomes;
	
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
	public static ForgeConfigSpec.ConfigValue<List<String>> seagrassBiomes;
	
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
	public static ForgeConfigSpec.ConfigValue<List<String>> shortGrassBiomes;
	
	public static ForgeConfigSpec.ConfigValue<List<String>> flyBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> fireflyBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> starfishBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> clamBiomes;
	
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
	
	public static ForgeConfigSpec.BooleanValue skeletalKnightDungeons;
	
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
		oakTreesBiomes = COMMON_BUILDER.comment("Normal frequency").define("oakTreesBiomes", ConfigDefaults.OAK_TREES);
		oakTreesSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("oakTreesSparseBiomes", ConfigDefaults.OAK_TREES_SPARSE);
		COMMON_BUILDER.comment("Birch Trees Biomes");
		birchTreesBiomes = COMMON_BUILDER.comment("Normal frequency").define("birchTreesBiomes", ConfigDefaults.BIRCH_TREES);
		birchTreesSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("birchTreesSparseBiomes", ConfigDefaults.BIRCH_TREES_SPARSE);
		COMMON_BUILDER.comment("Spruce Trees Biomes");
		spruceTreesBiomes = COMMON_BUILDER.comment("Normal frequency").define("spruceTreesBiomes", ConfigDefaults.SPRUCE_TREES);
		spruceTreesSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("spruceTreesSparseBiomes", ConfigDefaults.SPRUCE_TREES_SPARSE);
		COMMON_BUILDER.comment("Jungle Trees Biomes");
		jungleTreesBiomes = COMMON_BUILDER.comment("Normal frequency").define("jungleTreesBiomes", ConfigDefaults.JUNGLE_TREES);
		jungleTreesSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("jungleTreesSparseBiomes", ConfigDefaults.JUNGLE_TREES_SPARSE);
		COMMON_BUILDER.comment("Dark Oak Trees Biomes");
		darkOakTreesBiomes = COMMON_BUILDER.comment("Normal frequency").define("darkOakTreesBiomes", ConfigDefaults.DARK_OAK_TREES);
		darkOakTreesSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("darkOakTreesSparseBiomes", ConfigDefaults.DARK_OAK_TREES_SPARSE);
		COMMON_BUILDER.comment("Acacia Trees Biomes");
		acaciaTreesBiomes = COMMON_BUILDER.comment("Normal frequency").define("acaciaTreesBiomes", ConfigDefaults.ACACIA_TREES);
		acaciaTreesSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("acaciaTreesSparseBiomes", ConfigDefaults.ACACIA_TREES_SPARSE);
		COMMON_BUILDER.comment("Fir Trees Biomes");
		firTreesBiomes = COMMON_BUILDER.comment("Normal frequency").define("firTreesBiomes", ConfigDefaults.FIR_TREES);
		firTreesSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("firTreesSparseBiomes", ConfigDefaults.FIR_TREES_SPARSE);
		COMMON_BUILDER.comment("Pine Trees Biomes");
		pineTreesBiomes = COMMON_BUILDER.comment("Normal frequency").define("pineTreesBiomes", ConfigDefaults.PINE_TREES);
		pineTreesSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("pineTreesSparseBiomes", ConfigDefaults.PINE_TREES_SPARSE);
		
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
		shortGrassBiomes = COMMON_BUILDER.comment("Short Grass Biomes").define("shortGrassBiomes", ConfigDefaults.SHORT_GRASS);
		seagrassBiomes = COMMON_BUILDER.comment("Seagrass Biomes").define("seagrassBiomes", ConfigDefaults.SEAGRASS);
	}
	
	private static void initMobs() {
		flyBiomes = COMMON_BUILDER.comment("Fly Biomes").define("flyBiomes", ConfigDefaults.FLY);
		fireflyBiomes = COMMON_BUILDER.comment("Firefly Biomes").define("fireflyBiomes", ConfigDefaults.FIREFLY);
		starfishBiomes = COMMON_BUILDER.comment("Starfish Biomes").define("starfishBiomes", ConfigDefaults.STARFISH);
		clamBiomes = COMMON_BUILDER.comment("Clam Biomes").define("clamBiomes", ConfigDefaults.CLAM);
		
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
		
		skeletalKnightDungeons = COMMON_BUILDER.comment("Add skeletal knights to dungoens").define("skeletalKnightDungeons", true);
	}
	
	public static void loadConfig(ForgeConfigSpec spec, Path path) {
		final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
		
		configData.load();
		spec.setConfig(configData);
	}
}
