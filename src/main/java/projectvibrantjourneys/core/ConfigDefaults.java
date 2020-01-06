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
	
	public static final List<String> IRON_NUGGET = new ArrayList<String>();
	public static final List<String> GOLD_NUGGET = new ArrayList<String>();
	public static final List<String> GOLD_NUGGET_COMMON = new ArrayList<String>();
	public static final List<String> FLINT = new ArrayList<String>();
	
	public static final List<String> DUNG = new ArrayList<String>();
	
	public static final List<String> SKELETAL_KNIGHT = new ArrayList<String>();
	public static final List<String> SHADE = new ArrayList<String>();
	public static final List<String> GHOST = new ArrayList<String>();
	
	public static void load() {
		//ocean
		addTo("minecraft:ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:warm_ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:lukewarm_ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:cold_ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:frozen_ocean", ICE_CHUNKS, BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:deep_ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:deep_warm_ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:deep_lukewarm_ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:deep_cold_ocean", BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:deep_frozen_ocean", ICE_CHUNKS, BONES, SEASHELLS, SKELETAL_KNIGHT, GHOST);
		
		//plains
		addTo("minecraft:plains", OAK_TWIGS_SPARSE, ROCKS, BONES, BUSH, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:sunflower_plains", OAK_TWIGS_SPARSE, ROCKS, BONES, BUSH, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		
		//forest
		addTo("minecraft:forest", OAK_TWIGS, BIRCH_TWIGS_SPARSE, ROCKS, BONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:wooded_hills", OAK_TWIGS, BIRCH_TWIGS_SPARSE, ROCKS, BONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:flower_forest", OAK_TWIGS, BIRCH_TWIGS_SPARSE, ROCKS, BONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		
		//birch forest
		addTo("minecraft:birch_forest", BIRCH_TWIGS, ROCKS, BONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:birch_forest_hills", BIRCH_TWIGS, ROCKS, BONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:tall_birch_forest", BIRCH_TWIGS, ROCKS, BONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:tall_birch_hills", BIRCH_TWIGS, ROCKS, BONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		
		//dark forest
		addTo("minecraft:dark_forest", OAK_TWIGS_SPARSE, DARK_OAK_TWIGS, ROCKS, BONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE);
		addTo("minecraft:dark_forest_hills", OAK_TWIGS_SPARSE, DARK_OAK_TWIGS, ROCKS, BONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE);
		
		//swamp
		addTo("minecraft:swamp", OAK_TWIGS, ROCKS, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE);
		addTo("minecraft:swamp_hills", OAK_TWIGS, ROCKS, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE);
		
		//taiga
		addTo("minecraft:taiga", SPRUCE_TWIGS, ROCKS, BONES, PINECONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:taiga_hills", SPRUCE_TWIGS, ROCKS, BONES, PINECONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:snowy_taiga", SPRUCE_TWIGS, ROCKS, BONES, PINECONES, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:snowy_taiga_hills", SPRUCE_TWIGS, ROCKS, BONES, PINECONES, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:giant_tree_taiga", SPRUCE_TWIGS, ROCKS, BONES, PINECONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:giant_tree_taiga_hills", SPRUCE_TWIGS, ROCKS, BONES, PINECONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:taiga_mountains", SPRUCE_TWIGS, ROCKS, BONES, PINECONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:snowy_taiga_mountains", SPRUCE_TWIGS, ROCKS, BONES, PINECONES, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:giant_spruce_taiga", SPRUCE_TWIGS, ROCKS, BONES, PINECONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:giant_spruce_taiga_hills", SPRUCE_TWIGS, ROCKS, BONES, PINECONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		
		//mountains
		addTo("minecraft:mountains", ROCKS, BONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:snowy_mountains", ROCKS, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:mountain_edge", ROCKS, BONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:wooded_mountains", OAK_TWIGS_SPARSE, SPRUCE_TWIGS, BONES, PINECONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:gravelly_mountains", ROCKS, BONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:modified_gravelly_mountains", ROCKS, BONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		
		//desert
		addTo("minecraft:desert", SANDSTONE_ROCKS, BONES_COMMON, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:desert_hills", SANDSTONE_ROCKS, BONES_COMMON, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:desert_lakes", SANDSTONE_ROCKS, BONES_COMMON, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST);
		
		//savanna
		addTo("minecraft:savanna", ACACIA_TWIGS, ROCKS, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:savanna_plateau", ACACIA_TWIGS, ROCKS, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:shattered_savanna", ACACIA_TWIGS, ROCKS, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:shattered_savanna_plateau", ACACIA_TWIGS, ROCKS, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST);
		
		//badlands
		addTo("minecraft:badlands", RED_SANDSTONE_ROCKS, BONES_COMMON, IRON_NUGGET, GOLD_NUGGET_COMMON, FLINT, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:wooded_badlands_plateau", OAK_TWIGS, IRON_NUGGET, GOLD_NUGGET_COMMON, FLINT, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:badlands_plateau", RED_SANDSTONE_ROCKS, IRON_NUGGET, GOLD_NUGGET_COMMON, FLINT, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:eroded_badlands", RED_SANDSTONE_ROCKS, BONES_COMMON, IRON_NUGGET, GOLD_NUGGET_COMMON, FLINT, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:modified_wooded_badlands_plateau", OAK_TWIGS, IRON_NUGGET, GOLD_NUGGET_COMMON, FLINT, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:modified_badlands_plateau", RED_SANDSTONE_ROCKS, IRON_NUGGET, GOLD_NUGGET_COMMON, FLINT, SKELETAL_KNIGHT, GHOST);
		
		//tundra
		addTo("minecraft:snowy_tundra", ROCKS, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:ice_spikes", ICE_CHUNKS, SKELETAL_KNIGHT, GHOST);
		
		//jungle
		addTo("minecraft:jungle", JUNGLE_TWIGS, ROCKS, BONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE);
		addTo("minecraft:jungle_hills", JUNGLE_TWIGS, ROCKS, BONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE);
		addTo("minecraft:jungle_edge", JUNGLE_TWIGS_SPARSE, ROCKS, BONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE);
		addTo("minecraft:modified_jungle", JUNGLE_TWIGS, ROCKS, BONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE);
		addTo("minecraft:modified_jungle_edge", JUNGLE_TWIGS_SPARSE, ROCKS, BONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE);
		addTo("minecraft:bamboo_jungle", JUNGLE_TWIGS, ROCKS, BONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE);
		addTo("minecraft:bamboo_jungle_hills", JUNGLE_TWIGS, ROCKS, BONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE);
		
		//river
		addTo("minecraft:river", ROCKS, ROCKS, BONES, LILYPAD, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:frozen_river", ICE_CHUNKS, BONES, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST);
		
		//mushroom islands
		addTo("minecraft:mushroom_fields");
		addTo("minecraft:mushroom_field_shore");
		
		//beach
		addTo("minecraft:beach", SANDSTONE_ROCKS, BONES, SEASHELLS, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:stone_shore", ROCKS, BONES, SEASHELLS, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST);
		addTo("minecraft:snowy_beach", SANDSTONE_ROCKS, BONES, SEASHELLS, IRON_NUGGET, GOLD_NUGGET, FLINT, SKELETAL_KNIGHT, GHOST);
		
		//dimensional
		addTo("minecraft:nether", BONES_NETHER, GOLD_NUGGET);
		addTo("minecraft:the_end");
		addTo("minecraft:small_end_islands");
		addTo("minecraft:end_midlands");
		addTo("minecraft:end_highlands");
		addTo("minecraft:end_barrens");
		addTo("minecraft:the_void");
		
		//modded
		addTo("projectvibrantjourneys:overgrown_spires", OAK_TWIGS_SPARSE, JUNGLE_TWIGS, DARK_OAK_TWIGS, ROCKS, BONES, BUSH, IRON_NUGGET, GOLD_NUGGET, FLINT, DUNG, SKELETAL_KNIGHT, GHOST, SHADE);
	}
	
	@SafeVarargs
	public static void addTo(String biome, List<String>... lists) {
		for(List<String> list : lists) {
			list.add(biome);
		}
	}
}
