package projectvibrantjourneys.core;

import java.util.ArrayList;
import java.util.List;

public class ConfigDefaults {

	public static final List<String> OAK_TWIGS = new ArrayList<String>();
	public static final List<String> OAK_TWIGS_SPARSE = new ArrayList<String>();
	public static final List<String> BIRCH_TWIGS = new ArrayList<String>();
	public static final List<String> BIRCH_TWIGS_SPARSE = new ArrayList<String>();
	public static final List<String> SPRUCE_TWIGS = new ArrayList<String>();
	public static final List<String> SPRUCE_TWIGS_SPARSE = new ArrayList<String>();
	public static final List<String> JUNGLE_TWIGS = new ArrayList<String>();
	public static final List<String> JUNGLE_TWIGS_SPARSE = new ArrayList<String>();
	public static final List<String> DARK_OAK_TWIGS = new ArrayList<String>();
	public static final List<String> DARK_OAK_TWIGS_SPARSE = new ArrayList<String>();
	public static final List<String> ACACIA_TWIGS = new ArrayList<String>();
	public static final List<String> ACACIA_TWIGS_SPARSE = new ArrayList<String>();
	
	public static final List<String> ROCKS = new ArrayList<String>();
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
	
	public static final List<String> FLY = new ArrayList<String>();
	public static final List<String> FIREFLY = new ArrayList<String>();
	public static final List<String> STARFISH = new ArrayList<String>();
	
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
	
	public static void load() {
		//ocean
		addTo("minecraft:ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST, FLY, FIREFLY, STARFISH);
		addTo("minecraft:warm_ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST, FLY, FIREFLY, STARFISH);
		addTo("minecraft:lukewarm_ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST, FLY, FIREFLY, STARFISH);
		addTo("minecraft:cold_ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST, FLY, FIREFLY, STARFISH);
		addTo("minecraft:frozen_ocean", ICE_CHUNKS, BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST, ICE_CUBE, STARFISH);
		addTo("minecraft:deep_ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST, FLY, FIREFLY, STARFISH);
		addTo("minecraft:deep_warm_ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST, FLY, FIREFLY, STARFISH);
		addTo("minecraft:deep_lukewarm_ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST, FLY, FIREFLY, STARFISH);
		addTo("minecraft:deep_cold_ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST, FLY, FIREFLY, STARFISH);
		addTo("minecraft:deep_frozen_ocean", ICE_CHUNKS, BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST, ICE_CUBE, STARFISH);
		
		//plains
		addTo("minecraft:plains", OAK_TWIGS_SPARSE, ROCKS, BONES, BUSH, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, HAUNT, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:sunflower_plains", OAK_TWIGS_SPARSE, ROCKS, BONES, BUSH, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, HAUNT, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		
		//forest
		addTo("minecraft:forest", OAK_TWIGS, BIRCH_TWIGS_SPARSE, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:wooded_hills", OAK_TWIGS, BIRCH_TWIGS_SPARSE, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:flower_forest", OAK_TWIGS, BIRCH_TWIGS_SPARSE, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		
		//birch forest
		addTo("minecraft:birch_forest", BIRCH_TWIGS, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:birch_forest_hills", BIRCH_TWIGS, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:tall_birch_forest", BIRCH_TWIGS, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:tall_birch_hills", BIRCH_TWIGS, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		
		//dark forest
		addTo("minecraft:dark_forest", OAK_TWIGS_SPARSE, DARK_OAK_TWIGS, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:dark_forest_hills", OAK_TWIGS_SPARSE, DARK_OAK_TWIGS, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		
		//swamp
		addTo("minecraft:swamp", OAK_TWIGS, ROCKS, BONES, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:swamp_hills", OAK_TWIGS, ROCKS, FROGBIT, DUCKWEED, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		
		//taiga
		addTo("minecraft:taiga", SPRUCE_TWIGS, ROCKS, BONES, PINECONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:taiga_hills", SPRUCE_TWIGS, ROCKS, BONES, PINECONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:snowy_taiga", SPRUCE_TWIGS, ROCKS, BONES, PINECONES, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, BANSHEE, COBWEB, ICE_CUBE);
		addTo("minecraft:snowy_taiga_hills", SPRUCE_TWIGS, ROCKS, BONES, PINECONES, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, BANSHEE, COBWEB, ICE_CUBE);
		addTo("minecraft:giant_tree_taiga", SPRUCE_TWIGS, ROCKS, BONES, PINECONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:giant_tree_taiga_hills", SPRUCE_TWIGS, ROCKS, BONES, PINECONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:taiga_mountains", SPRUCE_TWIGS, ROCKS, BONES, PINECONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:snowy_taiga_mountains", SPRUCE_TWIGS, ROCKS, BONES, PINECONES, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, BANSHEE, COBWEB, ICE_CUBE);
		addTo("minecraft:giant_spruce_taiga", SPRUCE_TWIGS, ROCKS, BONES, PINECONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:giant_spruce_taiga_hills", SPRUCE_TWIGS, ROCKS, BONES, PINECONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SPECTER, FLY, FIREFLY, BARK_MUSHROOM, COBWEB);
		
		//mountains
		addTo("minecraft:mountains", ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, PHANTASM, FLY, FIREFLY, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:snowy_mountains", ROCKS, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, BANSHEE, COBWEB, ICE_CUBE);
		addTo("minecraft:mountain_edge", ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, PHANTASM, FLY, FIREFLY, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:wooded_mountains", OAK_TWIGS_SPARSE, SPRUCE_TWIGS, BONES, PINECONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, PHANTASM, FLY, FIREFLY, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:gravelly_mountains", ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, PHANTASM, FLY, FIREFLY, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:modified_gravelly_mountains", ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, PHANTASM, FLY, FIREFLY, BARK_MUSHROOM, COBWEB);
		
		//desert
		addTo("minecraft:desert", SANDSTONE_ROCKS, BONES_COMMON, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, WRAITH, SMALL_CACTUS);
		addTo("minecraft:desert_hills", SANDSTONE_ROCKS, BONES_COMMON, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, WRAITH, SMALL_CACTUS);
		addTo("minecraft:desert_lakes", SANDSTONE_ROCKS, BONES_COMMON, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, WRAITH, SMALL_CACTUS);
		
		//savanna
		addTo("minecraft:savanna", ACACIA_TWIGS, ROCKS, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, WRAITH, FLY, FIREFLY, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:savanna_plateau", ACACIA_TWIGS, ROCKS, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, WRAITH, FLY, FIREFLY, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:shattered_savanna", ACACIA_TWIGS, ROCKS, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, WRAITH, FLY, FIREFLY, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:shattered_savanna_plateau", ACACIA_TWIGS, ROCKS, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, WRAITH, FLY, FIREFLY, BARK_MUSHROOM, COBWEB);
		
		//badlands
		addTo("minecraft:badlands", RED_SANDSTONE_ROCKS, BONES_COMMON, IRON_NUGGET, GOLD_NUGGET_COMMON, FLINT, SKELETAL_KNIGHT, GHOST, WRAITH);
		addTo("minecraft:wooded_badlands_plateau", OAK_TWIGS, IRON_NUGGET, GOLD_NUGGET_COMMON, FLINT, SKELETAL_KNIGHT, GHOST, WRAITH);
		addTo("minecraft:badlands_plateau", RED_SANDSTONE_ROCKS, IRON_NUGGET, GOLD_NUGGET_COMMON, FLINT, SKELETAL_KNIGHT, GHOST, WRAITH);
		addTo("minecraft:eroded_badlands", RED_SANDSTONE_ROCKS, BONES_COMMON, IRON_NUGGET, GOLD_NUGGET_COMMON, FLINT, SKELETAL_KNIGHT, GHOST, WRAITH);
		addTo("minecraft:modified_wooded_badlands_plateau", OAK_TWIGS, IRON_NUGGET, GOLD_NUGGET_COMMON, FLINT, SKELETAL_KNIGHT, GHOST, WRAITH);
		addTo("minecraft:modified_badlands_plateau", RED_SANDSTONE_ROCKS, IRON_NUGGET, GOLD_NUGGET_COMMON, FLINT, SKELETAL_KNIGHT, GHOST, WRAITH);
		
		//tundra
		addTo("minecraft:snowy_tundra", ROCKS, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, BANSHEE, COBWEB, ICE_CUBE);
		addTo("minecraft:ice_spikes", ICE_CHUNKS, SKELETAL_KNIGHT, GHOST, BANSHEE, ICE_CUBE);
		
		//jungle
		addTo("minecraft:jungle", JUNGLE_TWIGS, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:jungle_hills", JUNGLE_TWIGS, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:jungle_edge", JUNGLE_TWIGS_SPARSE, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:modified_jungle", JUNGLE_TWIGS, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:modified_jungle_edge", JUNGLE_TWIGS_SPARSE, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:bamboo_jungle", JUNGLE_TWIGS, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:bamboo_jungle_hills", JUNGLE_TWIGS, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		
		//river
		addTo("minecraft:river", ROCKS, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		addTo("minecraft:frozen_river", ICE_CHUNKS, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, ICE_CUBE);
		
		//mushroom islands
		addTo("minecraft:mushroom_fields");
		addTo("minecraft:mushroom_field_shore");
		
		//beach
		addTo("minecraft:beach", SANDSTONE_ROCKS, BONES, SEASHELLS, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, FLY, FIREFLY, SEA_OATS, BEACH_GRASS, STARFISH);
		addTo("minecraft:stone_shore", ROCKS, BONES, SEASHELLS, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, FLY, FIREFLY, STARFISH);
		addTo("minecraft:snowy_beach", SANDSTONE_ROCKS, BONES, SEASHELLS, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST, ICE_CUBE, STARFISH);
		
		//dimensional
		addTo("minecraft:nether", BONES_NETHER, GOLD_NUGGET, NIGHTMARE, GLOWCAP);
		addTo("minecraft:the_end");
		addTo("minecraft:small_end_islands");
		addTo("minecraft:end_midlands");
		addTo("minecraft:end_highlands");
		addTo("minecraft:end_barrens");
		addTo("minecraft:the_void");
		
		//modded
		addTo("projectvibrantjourneys:overgrown_spires", OAK_TWIGS_SPARSE, JUNGLE_TWIGS, DARK_OAK_TWIGS, ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, BUSH, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE, FLY, FIREFLY, CATTAIL, BARK_MUSHROOM, COBWEB);
		addTo("projectvibrantjourneys:verdant_sands", OAK_TWIGS_SPARSE, JUNGLE_TWIGS_SPARSE, ACACIA_TWIGS_SPARSE, ROCKS, SANDSTONE_ROCKS, RED_SANDSTONE_ROCKS, BONES, LILYPAD, FROGBIT, DUCKWEED, BUSH, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, WRAITH, FLY, FIREFLY, CATTAIL, SMALL_CACTUS, BARK_MUSHROOM, COBWEB);
	}
	
	@SafeVarargs
	public static void addTo(String biome, List<String>... lists) {
		for(List<String> list : lists) {
			list.add(biome);
		}
	}
}
