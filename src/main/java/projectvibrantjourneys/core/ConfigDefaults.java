package projectvibrantjourneys.core;

import java.util.ArrayList;
import java.util.List;

public class ConfigDefaults {

	public static final List<String> OAK_TREES = new ArrayList<String>();
	public static final List<String> OAK_TREES_SPARSE = new ArrayList<String>();
	public static final List<String> BIRCH_TREES = new ArrayList<String>();
	public static final List<String> BIRCH_TREES_SPARSE = new ArrayList<String>();
	public static final List<String> SPRUCE_TREES = new ArrayList<String>();
	public static final List<String> SPRUCE_TREES_SPARSE = new ArrayList<String>();
	public static final List<String> JUNGLE_TREES = new ArrayList<String>();
	public static final List<String> JUNGLE_TREES_SPARSE = new ArrayList<String>();
	public static final List<String> DARK_OAK_TREES = new ArrayList<String>();
	public static final List<String> DARK_OAK_TREES_SPARSE = new ArrayList<String>();
	public static final List<String> ACACIA_TREES = new ArrayList<String>();
	public static final List<String> ACACIA_TREES_SPARSE = new ArrayList<String>();
	public static final List<String> FIR_TREES = new ArrayList<String>();
	public static final List<String> FIR_TREES_SPARSE = new ArrayList<String>();
	public static final List<String> PINE_TREES = new ArrayList<String>();
	public static final List<String> PINE_TREES_SPARSE = new ArrayList<String>();
	public static final List<String> PALM_TREES = new ArrayList<String>();
	public static final List<String> PALM_TREES_SPARSE = new ArrayList<String>();
	public static final List<String> WILLOW_TREES = new ArrayList<String>();
	public static final List<String> WILLOW_TREES_SPARSE = new ArrayList<String>();
	
	public static final List<String> ROCKS = new ArrayList<String>();
	public static final List<String> NETHERRACK_ROCKS = new ArrayList<String>();
	public static final List<String> SANDSTONE_ROCKS = new ArrayList<String>();
	public static final List<String> RED_SANDSTONE_ROCKS = new ArrayList<String>();
	public static final List<String> ICE_CHUNKS = new ArrayList<String>();
	
	public static final List<String> BONES = new ArrayList<String>();
	public static final List<String> BONES_COMMON = new ArrayList<String>();
	public static final List<String> BONES_NETHER = new ArrayList<String>();
	
	public static final List<String> PINECONES = new ArrayList<String>();
	public static final List<String> SEASHELLS = new ArrayList<String>();
	
	public static final List<String> BUSH = new ArrayList<String>();
	public static final List<String> LILYPAD = new ArrayList<String>();
	public static final List<String> COBWEB = new ArrayList<String>();
	public static final List<String> SEAGRASS = new ArrayList<String>();
	public static final List<String> TROPICAL_FISH = new ArrayList<String>();
	
	public static final List<String> IRON_NUGGET = new ArrayList<String>();
	public static final List<String> GOLD_NUGGET = new ArrayList<String>();
	public static final List<String> GOLD_NUGGET_COMMON = new ArrayList<String>();
	public static final List<String> FLINT = new ArrayList<String>();
	
	public static final List<String> DUNG = new ArrayList<String>();
	
	public static final List<String> SEA_OATS = new ArrayList<String>();
	public static final List<String> BEACH_GRASS = new ArrayList<String>();
	public static final List<String> CATTAIL = new ArrayList<String>();
	public static final List<String> SMALL_CACTUS = new ArrayList<String>();
	public static final List<String> BARK_MUSHROOM = new ArrayList<String>();
	public static final List<String> FROGBIT = new ArrayList<String>();
	public static final List<String> DUCKWEED = new ArrayList<String>();
	public static final List<String> GLOWCAP = new ArrayList<String>();
	public static final List<String> SHORT_GRASS = new ArrayList<String>();
	
	public static final List<String> FLY = new ArrayList<String>();
	public static final List<String> FIREFLY = new ArrayList<String>();
	public static final List<String> STARFISH = new ArrayList<String>();
	public static final List<String> CLAM = new ArrayList<String>();
	public static final List<String> SNAIL = new ArrayList<String>();
	public static final List<String> SLUG = new ArrayList<String>();
	
	public static final List<String> GHOST = new ArrayList<String>();
	
	public static final List<String> SKELETAL_KNIGHT = new ArrayList<String>();
	public static final List<String> SHADE = new ArrayList<String>();
	public static final List<String> HAUNT = new ArrayList<String>();
	public static final List<String> WRAITH = new ArrayList<String>();
	public static final List<String> SPECTER = new ArrayList<String>();
	public static final List<String> BANSHEE = new ArrayList<String>();
	public static final List<String> PHANTASM = new ArrayList<String>();
	public static final List<String> NIGHTMARE = new ArrayList<String>();
	public static final List<String> ICE_CUBE = new ArrayList<String>();
	public static final List<String> MAW = new ArrayList<String>();
	
	public static final List<String> MAW_FOODS = new ArrayList<String>();
	
	public static void load() {
		//ocean
		addTo("minecraft:ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST, FLY, FIREFLY, STARFISH, CLAM, SHORT_GRASS);
		addTo("minecraft:warm_ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST, FLY, FIREFLY, STARFISH, CLAM, SHORT_GRASS);
		addTo("minecraft:lukewarm_ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST, FLY, FIREFLY, STARFISH, CLAM, SHORT_GRASS);
		addTo("minecraft:cold_ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST, FLY, FIREFLY, STARFISH, CLAM, SHORT_GRASS);
		addTo("minecraft:frozen_ocean", ICE_CHUNKS, BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST, ICE_CUBE, STARFISH, CLAM, SHORT_GRASS);
		addTo("minecraft:deep_ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST, FLY, FIREFLY, STARFISH, CLAM, SHORT_GRASS);
		addTo("minecraft:deep_warm_ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST, FLY, FIREFLY, STARFISH, CLAM, SHORT_GRASS);
		addTo("minecraft:deep_lukewarm_ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST, FLY, FIREFLY, STARFISH, CLAM, SHORT_GRASS);
		addTo("minecraft:deep_cold_ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST, FLY, FIREFLY, STARFISH, CLAM, SHORT_GRASS);
		addTo("minecraft:deep_frozen_ocean", ICE_CHUNKS, BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST, ICE_CUBE, STARFISH, CLAM, SHORT_GRASS);
		
		//plains
		addTo("minecraft:plains", OAK_TREES_SPARSE, ROCKS, BONES, BUSH, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, HAUNT, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS, SEAGRASS);
		addTo("minecraft:sunflower_plains", OAK_TREES_SPARSE, ROCKS, BONES, BUSH, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, HAUNT, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS, SEAGRASS);
		
		//forest
		addTo("minecraft:forest", OAK_TREES, BIRCH_TREES_SPARSE, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS, SEAGRASS);
		addTo("minecraft:wooded_hills", OAK_TREES, BIRCH_TREES_SPARSE, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS, SEAGRASS);
		addTo("minecraft:flower_forest", OAK_TREES, BIRCH_TREES_SPARSE, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS, SEAGRASS);
		
		//birch forest
		addTo("minecraft:birch_forest", BIRCH_TREES, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS, SEAGRASS);
		addTo("minecraft:birch_forest_hills", BIRCH_TREES, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS, SEAGRASS);
		addTo("minecraft:tall_birch_forest", BIRCH_TREES, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS, SEAGRASS);
		addTo("minecraft:tall_birch_hills", BIRCH_TREES, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS, SEAGRASS);
		
		//dark forest
		addTo("minecraft:dark_forest", OAK_TREES_SPARSE, DARK_OAK_TREES, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS, SEAGRASS);
		addTo("minecraft:dark_forest_hills", OAK_TREES_SPARSE, DARK_OAK_TREES, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS, SEAGRASS);
		
		//swamp
		addTo("minecraft:swamp", OAK_TREES, ROCKS, BONES, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS);
		addTo("minecraft:swamp_hills", OAK_TREES, ROCKS, FROGBIT, DUCKWEED, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS);
		
		//taiga
		addTo("minecraft:taiga", SPRUCE_TREES, ROCKS, BONES, PINECONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SEAGRASS);
		addTo("minecraft:taiga_hills", SPRUCE_TREES, ROCKS, BONES, PINECONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, SNAIL, SLUG, BARK_MUSHROOM, COBWEB, CLAM, SEAGRASS);
		addTo("minecraft:snowy_taiga", SPRUCE_TREES, ROCKS, BONES, PINECONES, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, BANSHEE, COBWEB, ICE_CUBE, CLAM, SEAGRASS);
		addTo("minecraft:snowy_taiga_hills", SPRUCE_TREES, ROCKS, BONES, PINECONES, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, BANSHEE, COBWEB, ICE_CUBE, CLAM, SEAGRASS);
		addTo("minecraft:giant_tree_taiga", SPRUCE_TREES, ROCKS, BONES, PINECONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SEAGRASS);
		addTo("minecraft:giant_tree_taiga_hills", SPRUCE_TREES, ROCKS, BONES, PINECONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, SNAIL, SLUG, BARK_MUSHROOM, COBWEB, CLAM, SEAGRASS);
		addTo("minecraft:taiga_mountains", SPRUCE_TREES, ROCKS, BONES, PINECONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, SNAIL, SLUG, BARK_MUSHROOM, COBWEB, CLAM, SEAGRASS);
		addTo("minecraft:snowy_taiga_mountains", SPRUCE_TREES, ROCKS, BONES, PINECONES, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, BANSHEE, COBWEB, ICE_CUBE, CLAM, SEAGRASS);
		addTo("minecraft:giant_spruce_taiga", SPRUCE_TREES, ROCKS, BONES, PINECONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SEAGRASS);
		addTo("minecraft:giant_spruce_taiga_hills", SPRUCE_TREES, ROCKS, BONES, PINECONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, SNAIL, SLUG, BARK_MUSHROOM, COBWEB, CLAM, SEAGRASS);
		
		//mountains
		addTo("minecraft:mountains", ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, PHANTASM, FLY, FIREFLY, SNAIL, SLUG, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS);
		addTo("minecraft:snowy_mountains", ROCKS, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, BANSHEE, COBWEB, ICE_CUBE, CLAM);
		addTo("minecraft:mountain_edge", ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, PHANTASM, FLY, FIREFLY, SNAIL, SLUG, BARK_MUSHROOM, COBWEB, CLAM);
		addTo("minecraft:wooded_mountains", OAK_TREES_SPARSE, SPRUCE_TREES, BONES, PINECONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, PHANTASM, FLY, FIREFLY, SNAIL, SLUG, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS);
		addTo("minecraft:gravelly_mountains", ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, PHANTASM, FLY, FIREFLY, SNAIL, SLUG, BARK_MUSHROOM, COBWEB, CLAM);
		addTo("minecraft:modified_gravelly_mountains", ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, PHANTASM, FLY, FIREFLY, SNAIL, SLUG, BARK_MUSHROOM, COBWEB, CLAM);
		
		//desert
		addTo("minecraft:desert", SANDSTONE_ROCKS, BONES_COMMON, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, WRAITH, SMALL_CACTUS);
		addTo("minecraft:desert_hills", SANDSTONE_ROCKS, BONES_COMMON, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, WRAITH, SMALL_CACTUS);
		addTo("minecraft:desert_lakes", SANDSTONE_ROCKS, BONES_COMMON, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, WRAITH, SMALL_CACTUS);
		
		//savanna
		addTo("minecraft:savanna", ACACIA_TREES, ROCKS, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, WRAITH, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB, SHORT_GRASS);
		addTo("minecraft:savanna_plateau", ACACIA_TREES, ROCKS, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, WRAITH, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB, SHORT_GRASS);
		addTo("minecraft:shattered_savanna", ACACIA_TREES, ROCKS, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, WRAITH, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB, SHORT_GRASS);
		addTo("minecraft:shattered_savanna_plateau", ACACIA_TREES, ROCKS, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, WRAITH, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB, SHORT_GRASS);
		
		//badlands
		addTo("minecraft:badlands", RED_SANDSTONE_ROCKS, BONES_COMMON, IRON_NUGGET, GOLD_NUGGET_COMMON, FLINT, SKELETAL_KNIGHT, GHOST, WRAITH);
		addTo("minecraft:wooded_badlands_plateau", OAK_TREES, IRON_NUGGET, GOLD_NUGGET_COMMON, FLINT, SKELETAL_KNIGHT, GHOST, WRAITH);
		addTo("minecraft:badlands_plateau", RED_SANDSTONE_ROCKS, IRON_NUGGET, GOLD_NUGGET_COMMON, FLINT, SKELETAL_KNIGHT, GHOST, WRAITH);
		addTo("minecraft:eroded_badlands", RED_SANDSTONE_ROCKS, BONES_COMMON, IRON_NUGGET, GOLD_NUGGET_COMMON, FLINT, SKELETAL_KNIGHT, GHOST, WRAITH);
		addTo("minecraft:modified_wooded_badlands_plateau", OAK_TREES, IRON_NUGGET, GOLD_NUGGET_COMMON, FLINT, SKELETAL_KNIGHT, GHOST, WRAITH);
		addTo("minecraft:modified_badlands_plateau", RED_SANDSTONE_ROCKS, IRON_NUGGET, GOLD_NUGGET_COMMON, FLINT, SKELETAL_KNIGHT, GHOST, WRAITH);
		
		//tundra
		addTo("minecraft:snowy_tundra", ROCKS, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, BANSHEE, COBWEB, ICE_CUBE, CLAM, SEAGRASS);
		addTo("minecraft:ice_spikes", ICE_CHUNKS, SKELETAL_KNIGHT, GHOST, BANSHEE, ICE_CUBE);
		
		//jungle
		addTo("minecraft:jungle", PALM_TREES, JUNGLE_TREES, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS, SEAGRASS, TROPICAL_FISH);
		addTo("minecraft:jungle_hills", JUNGLE_TREES, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS, SEAGRASS, TROPICAL_FISH);
		addTo("minecraft:jungle_edge", PALM_TREES, JUNGLE_TREES_SPARSE, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS, SEAGRASS, TROPICAL_FISH);
		addTo("minecraft:modified_jungle", PALM_TREES, JUNGLE_TREES, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS, SEAGRASS, TROPICAL_FISH);
		addTo("minecraft:modified_jungle_edge", PALM_TREES, JUNGLE_TREES_SPARSE, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS, SEAGRASS, TROPICAL_FISH);
		addTo("minecraft:bamboo_jungle", PALM_TREES, JUNGLE_TREES, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS, SEAGRASS, TROPICAL_FISH);
		addTo("minecraft:bamboo_jungle_hills", JUNGLE_TREES, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS, SEAGRASS, TROPICAL_FISH);
		
		//river
		addTo("minecraft:river", ROCKS, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS);
		addTo("minecraft:frozen_river", ICE_CHUNKS, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, ICE_CUBE, CLAM);
		
		//mushroom islands
		addTo("minecraft:mushroom_fields");
		addTo("minecraft:mushroom_field_shore");
		
		//beach
		addTo("minecraft:beach", PALM_TREES_SPARSE, SANDSTONE_ROCKS, BONES, SEASHELLS, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, FLY, FIREFLY, SEA_OATS, BEACH_GRASS, STARFISH, CLAM);
		addTo("minecraft:stone_shore", ROCKS, BONES, SEASHELLS, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, FLY, FIREFLY, STARFISH, CLAM);
		addTo("minecraft:snowy_beach", SANDSTONE_ROCKS, BONES, SEASHELLS, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, ICE_CUBE, STARFISH, CLAM);
		
		//dimensional
		addTo("minecraft:nether", NETHERRACK_ROCKS, BONES_NETHER, GOLD_NUGGET, MAW, NIGHTMARE, GLOWCAP);
		addTo("minecraft:the_end");
		addTo("minecraft:small_end_islands");
		addTo("minecraft:end_midlands");
		addTo("minecraft:end_highlands");
		addTo("minecraft:end_barrens");
		addTo("minecraft:the_void");
		
		//modded
		addTo("projectvibrantjourneys:overgrown_spires", PALM_TREES, OAK_TREES_SPARSE, JUNGLE_TREES, DARK_OAK_TREES, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, BUSH, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS, SEAGRASS, TROPICAL_FISH);
		addTo("projectvibrantjourneys:verdant_sands", OAK_TREES_SPARSE, JUNGLE_TREES_SPARSE, ACACIA_TREES_SPARSE, ROCKS, SANDSTONE_ROCKS, RED_SANDSTONE_ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, BUSH, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, WRAITH, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, SMALL_CACTUS, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS, SEAGRASS);
		addTo("projectvibrantjourneys:boreal_forest", FIR_TREES, PINE_TREES, ROCKS, BONES, PINECONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS, SEAGRASS);
		addTo("projectvibrantjourneys:snowy_boreal_forest", FIR_TREES, PINE_TREES, ROCKS, ICE_CHUNKS, BONES, PINECONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, BANSHEE, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS, SEAGRASS);
		addTo("projectvibrantjourneys:prairie", OAK_TREES_SPARSE, ROCKS, BONES, BUSH, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, HAUNT, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS, SEAGRASS);
		addTo("projectvibrantjourneys:willow_swamp", WILLOW_TREES, ROCKS, BONES, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, SNAIL, SLUG, CATTAIL, BARK_MUSHROOM, COBWEB, CLAM, SHORT_GRASS);
		
		addStringsTo(MAW_FOODS, "minecraft:rotten_flesh", "minecraft:chicken", "minecraft:cooked_chicken", "minecraft:beef", "minecraft:cooked_beef", 
						"minecraft:rabbit", "minecraft:cooked_rabbit", "minecraft:mutton", "minecraft:cooked_mutton", "minecraft:cod", "minecraft:salmon",
						"minecraft:tropical_fish", "minecraft:pufferfish", "minecraft:cooked_cod", "minecraft:cooked_salmon", "minceraft:porkchop",
						"minecraft:cooked_porkchop", "projectvibrantjourneys:clam", "projectvibrantjourneys:cooked_clam");
	}
	
	@SafeVarargs
	public static void addTo(String biome, List<String>... lists) {
		for(List<String> list : lists) {
			list.add(biome);
		}
	}
	
	public static void addStringsTo(List<String> list, String... strings) {
		for(String s : strings)
			list.add(s);
	}
}
