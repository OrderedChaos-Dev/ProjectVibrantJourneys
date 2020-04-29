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
	public static final String CAT_BIOMES = "biomes";
	public static final String CAT_MOBS = "mobs";
	
	private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
	
	public static ForgeConfigSpec COMMON_CONFIG;
	public static ForgeConfigSpec CLIENT_CONFIG;
	
	public static ForgeConfigSpec.ConfigValue<Boolean> moreGrassInRivers;
	
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
	public static ForgeConfigSpec.ConfigValue<List<String>> palmTreesBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> palmTreesSparseBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> willowTreesBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> willowTreesSparseBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> mangroveTreesBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> mangroveTreesSparseBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> redwoodTreesBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> redwoodTreesSparseBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> baobabTreesBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> baobabTreesSparseBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> aspenTreesBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> aspenTreesSparseBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> redMapleTreesBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> redMapleTreesSparseBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> orangeMapleTreesBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> orangeMapleTreesSparseBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> purpleMapleTreesBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> purpleMapleTreesSparseBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> cottonwoodTreesBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> cottonwoodTreesSparseBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> juniperTreesBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> juniperTreesSparseBiomes;
	
	public static ForgeConfigSpec.ConfigValue<List<String>> rocksBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> netherrackRocksBiomes;
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
	public static ForgeConfigSpec.ConfigValue<List<String>> tropicalFishBiomes;
	
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
	
	public static ForgeConfigSpec.IntValue overgrownSpiresWeight;
	public static ForgeConfigSpec.IntValue verdantSandsWeight;
	public static ForgeConfigSpec.IntValue borealForestWeight;
	public static ForgeConfigSpec.IntValue snowyBorealForestWeight;
	public static ForgeConfigSpec.IntValue borealPlateauWeight;
	public static ForgeConfigSpec.IntValue willowWetlandsWeight;
	public static ForgeConfigSpec.IntValue redwoodsWeight;
	public static ForgeConfigSpec.IntValue redwoodPeaksWeight;
	public static ForgeConfigSpec.IntValue baobabFieldsWeight;
	public static ForgeConfigSpec.IntValue aspenGroveWeight;
	public static ForgeConfigSpec.IntValue crimsonThicketWeight;
	public static ForgeConfigSpec.IntValue prairieWeight;
	
	public static ForgeConfigSpec.ConfigValue<List<String>> flyBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> fireflyBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> starfishBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> clamBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> snailBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> slugBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> smallSpiderBiomes;
	
	public static ForgeConfigSpec.ConfigValue<List<String>> ghostBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> watcherBiomes;
	
	public static ForgeConfigSpec.ConfigValue<List<String>> skeletalKnightBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> shadeBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> bansheeBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> wraithBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> hauntBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> specterBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> phantasmBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> nightmareBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> iceCubeBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> mawBiomes;
	public static ForgeConfigSpec.ConfigValue<List<String>> mawFoods;
	
	public static ForgeConfigSpec.BooleanValue muteFlies;
	public static ForgeConfigSpec.BooleanValue skeletalKnightDungeons;
	
	static {
		ConfigDefaults.load();
		COMMON_BUILDER.comment("World Gen Settings").push(CAT_WORLDGEN);
		initWorldGen();
		COMMON_BUILDER.pop();
		COMMON_BUILDER.comment("Biome Settings").push(CAT_BIOMES);
		initBiomes();
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
		COMMON_BUILDER.comment("Palm Trees Biomes");
		palmTreesBiomes = COMMON_BUILDER.comment("Normal frequency").define("palmTreesBiomes", ConfigDefaults.PALM_TREES);
		palmTreesSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("palmTreesSparseBiomes", ConfigDefaults.PALM_TREES_SPARSE);
		COMMON_BUILDER.comment("Willow Trees Biomes");
		willowTreesBiomes = COMMON_BUILDER.comment("Normal frequency").define("willowTreesBiomes", ConfigDefaults.WILLOW_TREES);
		willowTreesSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("willowTreesSparseBiomes", ConfigDefaults.WILLOW_TREES_SPARSE);
		COMMON_BUILDER.comment("Mangrove Trees Biomes");
		mangroveTreesBiomes = COMMON_BUILDER.comment("Normal frequency").define("mangroveTreesBiomes", ConfigDefaults.MANGROVE_TREES);
		mangroveTreesSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("mangroveTreesSparseBiomes", ConfigDefaults.MANGROVE_TREES_SPARSE);
		COMMON_BUILDER.comment("Redwood Trees Biomes");
		redwoodTreesBiomes = COMMON_BUILDER.comment("Normal frequency").define("redwoodTreesBiomes", ConfigDefaults.REDWOOD_TREES);
		redwoodTreesSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("redwoodTreesSparseBiomes", ConfigDefaults.REDWOOD_TREES_SPARSE);
		COMMON_BUILDER.comment("Baobab Trees Biomes");
		baobabTreesBiomes = COMMON_BUILDER.comment("Normal frequency").define("baobabTreesBiomes", ConfigDefaults.BAOBAB_TREES);
		baobabTreesSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("baobabTreesSparseBiomes", ConfigDefaults.BAOBAB_TREES_SPARSE);
		COMMON_BUILDER.comment("Aspen Trees Biomes");
		aspenTreesBiomes = COMMON_BUILDER.comment("Normal frequency").define("aspenTreesBiomes", ConfigDefaults.ASPEN_TREES);
		aspenTreesSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("aspenTreesSparseBiomes", ConfigDefaults.ASPEN_TREES_SPARSE);
		COMMON_BUILDER.comment("Maple Trees Biomes");
		redMapleTreesBiomes = COMMON_BUILDER.comment("Normal frequency").define("redMapleTreesBiomes", ConfigDefaults.RED_MAPLE_TREES);
		redMapleTreesSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("redMapleTreesSparseBiomes", ConfigDefaults.RED_MAPLE_TREES_SPARSE);
		orangeMapleTreesBiomes = COMMON_BUILDER.comment("Normal frequency").define("orangeMapleTreesBiomes", ConfigDefaults.ORANGE_MAPLE_TREES);
		orangeMapleTreesSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("orangeMapleTreesSparseBiomes", ConfigDefaults.ORANGE_MAPLE_TREES_SPARSE);
		purpleMapleTreesBiomes = COMMON_BUILDER.comment("Normal frequency").define("purpleMapleTreesBiomes", ConfigDefaults.PURPLE_MAPLE_TREES);
		purpleMapleTreesSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("purpleMapleTreesSparseBiomes", ConfigDefaults.PURPLE_MAPLE_TREES_SPARSE);
		COMMON_BUILDER.comment("Cottonwood Trees Biomes");
		cottonwoodTreesBiomes = COMMON_BUILDER.comment("Normal frequency").define("cottonwoodTreesBiomes", ConfigDefaults.COTTONWOOD_TREES);
		cottonwoodTreesSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("cottonwoodTreesSparseBiomes", ConfigDefaults.COTTONWOOD_TREES_SPARSE);
		COMMON_BUILDER.comment("Juniper Trees Biomes");
		juniperTreesBiomes = COMMON_BUILDER.comment("Normal frequency").define("juniperTreesBiomes", ConfigDefaults.JUNIPER_TREES);
		juniperTreesSparseBiomes = COMMON_BUILDER.comment("Sparse frequency").define("juniperTreesSparseBiomes", ConfigDefaults.JUNIPER_TREES_SPARSE);
		
		rocksBiomes = COMMON_BUILDER.comment("Rocks Biomes (Stone, Cobblestone, Andesite, Diorite, Granite)").define("rocksBiomes", ConfigDefaults.ROCKS);
		netherrackRocksBiomes = COMMON_BUILDER.comment("Netherrack Rocks Biomes").define("netherrackRocksBiomes", ConfigDefaults.NETHERRACK_ROCKS);
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
		
		moreGrassInRivers = COMMON_BUILDER.comment("Denser River Grass").define("moreGrassInRivers", ConfigDefaults.RIVER_GRASS);
	}
	
	private static void initBiomes() {
		overgrownSpiresWeight = COMMON_BUILDER.comment("Overgrown Spires Weight").defineInRange("overgrownSpiresWeight", ConfigDefaults.OVERGROWN_SPIRES_WEIGHT, 0, 100);
		verdantSandsWeight = COMMON_BUILDER.comment("Verdant Sands Weight").defineInRange("verdantSandsWeight", ConfigDefaults.VERDANT_SANDS_WEIGHT, 0, 100);
		borealForestWeight = COMMON_BUILDER.comment("Boreal Forest Weight").defineInRange("borealForestWeight", ConfigDefaults.BOREAL_FOREST_WEIGHT, 0, 100);
		snowyBorealForestWeight = COMMON_BUILDER.comment("Snowy Boreal Forest Weight").defineInRange("snowyBorealForestWeight", ConfigDefaults.SNOWY_BOREAL_FOREST_WEIGHT, 0, 100);
		borealPlateauWeight = COMMON_BUILDER.comment("Boreal Plateau Weight").defineInRange("borealPlateauWeight", ConfigDefaults.BOREAL_PLATEAU_WEIGHT, 0, 100);
		willowWetlandsWeight = COMMON_BUILDER.comment("Willow Wetlands Weight").defineInRange("willowWetlandsWeight", ConfigDefaults.WILLOW_WETLANDS_WEIGHT, 0, 100);
		redwoodsWeight = COMMON_BUILDER.comment("Redwoods Weight").defineInRange("redwoodsWeight", ConfigDefaults.REDWOODS_WEIGHT, 0, 100);
		redwoodPeaksWeight = COMMON_BUILDER.comment("Redwood Peaks Weight").defineInRange("redwoodPeaksWeight", ConfigDefaults.REDWOOD_PEAKS_WEIGHT, 0, 100);
		baobabFieldsWeight = COMMON_BUILDER.comment("Baobab Fields Weight").defineInRange("baobabFieldsWeight", ConfigDefaults.BAOBAB_FIELDS_WEIGHT, 0, 100);
		aspenGroveWeight = COMMON_BUILDER.comment("Aspen Grove Weight").defineInRange("aspenGroveWeight", ConfigDefaults.ASPEN_GROVE_WEIGHT, 0, 100);
		crimsonThicketWeight = COMMON_BUILDER.comment("Crimson Thicket Weight").defineInRange("crimsonThicketWeight", ConfigDefaults.CRIMSON_THICKET_WEIGHT, 0, 100);
		prairieWeight = COMMON_BUILDER.comment("Prairie Weight").defineInRange("prairieWeight", ConfigDefaults.PRAIRIE_WEIGHT, 0, 100);
	}
	
	private static void initMobs() {
		flyBiomes = COMMON_BUILDER.comment("Fly Biomes").define("flyBiomes", ConfigDefaults.FLY);
		fireflyBiomes = COMMON_BUILDER.comment("Firefly Biomes").define("fireflyBiomes", ConfigDefaults.FIREFLY);
		starfishBiomes = COMMON_BUILDER.comment("Starfish Biomes").define("starfishBiomes", ConfigDefaults.STARFISH);
		clamBiomes = COMMON_BUILDER.comment("Clam Biomes").define("clamBiomes", ConfigDefaults.CLAM);
		snailBiomes = COMMON_BUILDER.comment("Snail Biomes").define("snailBiomes", ConfigDefaults.SNAIL);
		slugBiomes = COMMON_BUILDER.comment("Slug Biomes").define("slugBiomes", ConfigDefaults.SLUG);
		smallSpiderBiomes = COMMON_BUILDER.comment("Small Spider Biomes").define("smallSpiderBiomes", ConfigDefaults.SMALL_SPIDER);
		tropicalFishBiomes = COMMON_BUILDER.comment("Tropical Fish Biomes").define("tropicalFishBiomes", ConfigDefaults.TROPICAL_FISH);
		
		ghostBiomes = COMMON_BUILDER.comment("Ghost Biomes").define("ghostBiomes", ConfigDefaults.GHOST);
		watcherBiomes = COMMON_BUILDER.comment("Watcher Biomes").define("watcherBiomes", ConfigDefaults.WATCHER);
		
		skeletalKnightBiomes = COMMON_BUILDER.comment("Skeletal Knight Biomes").define("skeletalKnightBiomes", ConfigDefaults.SKELETAL_KNIGHT);
		shadeBiomes = COMMON_BUILDER.comment("Shade Biomes").define("shadeBiomes", ConfigDefaults.SHADE);
		bansheeBiomes = COMMON_BUILDER.comment("Banshee Biomes").define("bansheeBiomes", ConfigDefaults.BANSHEE);
		wraithBiomes = COMMON_BUILDER.comment("Wraith Biomes").define("wraithBiomes", ConfigDefaults.WRAITH);
		hauntBiomes = COMMON_BUILDER.comment("Haunt Biomes").define("hauntBiomes", ConfigDefaults.HAUNT);
		specterBiomes = COMMON_BUILDER.comment("Specter Biomes").define("specterBiomes", ConfigDefaults.SPECTER);
		phantasmBiomes = COMMON_BUILDER.comment("Phantasm Biomes").define("phantasmBiomes", ConfigDefaults.PHANTASM);
		nightmareBiomes = COMMON_BUILDER.comment("Nightmare Biomes").define("nightmareBiomes", ConfigDefaults.NIGHTMARE);
		iceCubeBiomes = COMMON_BUILDER.comment("Ice Cube Biomes").define("icecubeBiomes", ConfigDefaults.ICE_CUBE);
		mawBiomes = COMMON_BUILDER.comment("Maw Biomes").define("mawBiomes", ConfigDefaults.MAW);
		
		skeletalKnightDungeons = COMMON_BUILDER.comment("Add skeletal knights to dungeons").define("skeletalKnightDungeons", ConfigDefaults.SKELETAL_KNIGHT_DUNGEONS);
		mawFoods = COMMON_BUILDER.comment("Friendly Maw Foods").define("mawFoods", ConfigDefaults.MAW_FOODS);
		muteFlies = COMMON_BUILDER.comment("Mute Flies").define("muteFlies", ConfigDefaults.MUTE_FLIES);
	}
	
	public static void loadConfig(ForgeConfigSpec spec, Path path) {
		final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
		
		configData.load();
		spec.setConfig(configData);
	}
}
