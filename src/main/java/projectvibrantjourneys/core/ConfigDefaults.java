package projectvibrantjourneys.core;

import java.util.ArrayList;
import java.util.List;

public class ConfigDefaults {

	public static final List<String> OAK_TWIGS_DEFAULT = new ArrayList<String>();
	public static final List<String> OAK_TWIGS_SPARSE_DEFAULT = new ArrayList<String>();
	
	public static final List<String> BIRCH_TWIGS_DEFAULT = new ArrayList<String>();
	public static final List<String> BIRCH_TWIGS_SPARSE_DEFAULT = new ArrayList<String>();
	
	public static final List<String> SPRUCE_TWIGS_DEFAULT = new ArrayList<String>();
	public static final List<String> SPRUCE_TWIGS_SPARSE_DEFAULT = new ArrayList<String>();
	
	public static final List<String> JUNGLE_TWIGS_DEFAULT = new ArrayList<String>();
	public static final List<String> JUNGLE_TWIGS_SPARSE_DEFAULT = new ArrayList<String>();
	
	public static final List<String> DARK_OAK_TWIGS_DEFAULT = new ArrayList<String>();
	public static final List<String> DARK_OAK_TWIGS_SPARSE_DEFAULT = new ArrayList<String>();
	
	public static final List<String> ACACIA_TWIGS_DEFAULT = new ArrayList<String>();
	public static final List<String> ACACIA_TWIGS_SPARSE_DEFAULT = new ArrayList<String>();
	
	public static final List<String> ROCKS_DEFAULT = new ArrayList<String>();
	public static final List<String> SANDSTONE_ROCKS_DEFAULT = new ArrayList<String>();
	public static final List<String> RED_SANDSTONE_ROCKS_DEFAULT = new ArrayList<String>();
	public static final List<String> ICE_CHUNKS_DEFAULT = new ArrayList<String>();
	
	public static final List<String> BONES_DEFAULT = new ArrayList<String>();
	public static final List<String> BONES_COMMON_DEFAULT = new ArrayList<String>();
	public static final List<String> BONES_NETHER_DEFAULT = new ArrayList<String>();
	
	public static final List<String> PINECONES_DEFAULT = new ArrayList<String>();
	public static final List<String> SEASHELLS_DEFAULT = new ArrayList<String>();
	
	public static final List<String> BUSH_DEFAULT = new ArrayList<String>();
	public static final List<String> LILYPAD_DEFAULT = new ArrayList<String>();
	
	public static void load() {
		OAK_TWIGS_DEFAULT.add("minecraft:forest");
		OAK_TWIGS_DEFAULT.add("minecraft:flower_forest");
		OAK_TWIGS_DEFAULT.add("minecraft:wooded_hills");
		OAK_TWIGS_DEFAULT.add("minecraft:swamp");
		OAK_TWIGS_DEFAULT.add("minecraft:swamp_hills");
		OAK_TWIGS_DEFAULT.add("minecraft:wooded_badlands_plateau");
		OAK_TWIGS_DEFAULT.add("minecraft:modified_wooded_badlands_plateau");
		OAK_TWIGS_SPARSE_DEFAULT.add("minecraft:plains");
		OAK_TWIGS_SPARSE_DEFAULT.add("minecraft:sunflower_plains");
		OAK_TWIGS_SPARSE_DEFAULT.add("minecraft:dark_forest");
		OAK_TWIGS_SPARSE_DEFAULT.add("minecraft:dark_forest_hills");
		OAK_TWIGS_SPARSE_DEFAULT.add("minecraft:wooded_mountains");
		OAK_TWIGS_SPARSE_DEFAULT.add("projectvibrantjourneys:overgrown_spires");
		
		BIRCH_TWIGS_DEFAULT.add("minecraft:birch_forest");
		BIRCH_TWIGS_DEFAULT.add("minecraft:birch_forest_hills");
		BIRCH_TWIGS_DEFAULT.add("minecraft:tall_birch_forest");
		BIRCH_TWIGS_DEFAULT.add("minecraft:tall_birch_hills");
		BIRCH_TWIGS_SPARSE_DEFAULT.add("minecraft:forest");
		BIRCH_TWIGS_SPARSE_DEFAULT.add("minecraft:flower_forest");
		BIRCH_TWIGS_SPARSE_DEFAULT.add("minecraft:wooded_hills");
		
		SPRUCE_TWIGS_DEFAULT.add("minecraft:taiga");
		SPRUCE_TWIGS_DEFAULT.add("minecraft:taiga_hills");
		SPRUCE_TWIGS_DEFAULT.add("minecraft:snowy_taiga");
		SPRUCE_TWIGS_DEFAULT.add("minecraft:snowy_taiga_hills");
		SPRUCE_TWIGS_DEFAULT.add("minecraft:giant_tree_taiga");
		SPRUCE_TWIGS_DEFAULT.add("minecraft:giant_tree_taiga_hills");
		SPRUCE_TWIGS_DEFAULT.add("minecraft:wooded_mountains");
		SPRUCE_TWIGS_DEFAULT.add("minecraft:taiga_mountains");
		SPRUCE_TWIGS_DEFAULT.add("minecraft:taiga_mountains");
		SPRUCE_TWIGS_DEFAULT.add("minecraft:taiga_mountains");
		SPRUCE_TWIGS_DEFAULT.add("minecraft:snowy_taiga_mountains");
		SPRUCE_TWIGS_DEFAULT.add("minecraft:giant_spruce_taiga");
		SPRUCE_TWIGS_DEFAULT.add("minecraft:giant_spruce_taiga_hills");
		
		JUNGLE_TWIGS_DEFAULT.add("minecraft:jungle");
		JUNGLE_TWIGS_DEFAULT.add("minecraft:jungle_hills");
		JUNGLE_TWIGS_DEFAULT.add("minecraft:modified_jungle");
		JUNGLE_TWIGS_DEFAULT.add("minecraft:bamboo_jungle");
		JUNGLE_TWIGS_DEFAULT.add("minecraft:bamboo_jungle_hills");
		JUNGLE_TWIGS_DEFAULT.add("projectvibrantjourneys:overgrown_spires");
		JUNGLE_TWIGS_SPARSE_DEFAULT.add("minecraft:jungle_edge");
		JUNGLE_TWIGS_SPARSE_DEFAULT.add("minecraft:modified_jungle_edge");
		
		DARK_OAK_TWIGS_DEFAULT.add("minecraft:dark_forest");
		DARK_OAK_TWIGS_DEFAULT.add("projectvibrantjourneys:overgrown_spires");
		
		ACACIA_TWIGS_DEFAULT.add("minecraft:savanna");
		ACACIA_TWIGS_DEFAULT.add("minecraft:savanna_plateau");
		ACACIA_TWIGS_DEFAULT.add("minecraft:shattered_savanna");
		ACACIA_TWIGS_DEFAULT.add("minecraft:shattered_savanna_plateau");
		
		ROCKS_DEFAULT.add("minecraft:plains");
		ROCKS_DEFAULT.add("minecraft:mountains");
		ROCKS_DEFAULT.add("minecraft:forest");
		ROCKS_DEFAULT.add("minecraft:taiga");
		ROCKS_DEFAULT.add("minecraft:swamp");
		ROCKS_DEFAULT.add("minecraft:river");
		ROCKS_DEFAULT.add("minecraft:frozen_river");
		ROCKS_DEFAULT.add("minecraft:snowy_tundra");
		ROCKS_DEFAULT.add("minecraft:snowy_mountains");
		ROCKS_DEFAULT.add("minecraft:wooded_hills");
		ROCKS_DEFAULT.add("minecraft:taiga_hills");
		ROCKS_DEFAULT.add("minecraft:mountain_edge");
		ROCKS_DEFAULT.add("minecraft:jungle");
		ROCKS_DEFAULT.add("minecraft:jungle_edge");
		ROCKS_DEFAULT.add("minecraft:stone_shore");
		ROCKS_DEFAULT.add("minecraft:birch_forest");
		ROCKS_DEFAULT.add("minecraft:birch_forest_hills");
		ROCKS_DEFAULT.add("minecraft:dark_forest");
		ROCKS_DEFAULT.add("minecraft:snowy_taiga");
		ROCKS_DEFAULT.add("minecraft:snowy_taiga_hills");
		ROCKS_DEFAULT.add("minecraft:giant_tree_taiga");
		ROCKS_DEFAULT.add("minecraft:giant_tree_taiga_hills");
		ROCKS_DEFAULT.add("minecraft:wooded_mountains");
		ROCKS_DEFAULT.add("minecraft:savanna");
		ROCKS_DEFAULT.add("minecraft:sunflower_plains");
		ROCKS_DEFAULT.add("minecraft:gravelly_mountains");
		ROCKS_DEFAULT.add("minecraft:flower_forest");
		ROCKS_DEFAULT.add("minecraft:taiga_mountains");
		ROCKS_DEFAULT.add("minecraft:swamp_hills");
		ROCKS_DEFAULT.add("minecraft:modified_jungle");
		ROCKS_DEFAULT.add("minecraft:modified_jungle_edge");
		ROCKS_DEFAULT.add("minecraft:tall_birch_forest");
		ROCKS_DEFAULT.add("minecraft:tall_birch_hills");
		ROCKS_DEFAULT.add("minecraft:dark_forest_hills");
		ROCKS_DEFAULT.add("minecraft:snowy_taiga_mountains");
		ROCKS_DEFAULT.add("minecraft:giant_spruce_taiga");
		ROCKS_DEFAULT.add("minecraft:modified_gravelly_mountains");
		ROCKS_DEFAULT.add("minecraft:shattered_savanna");
		ROCKS_DEFAULT.add("minecraft:shattered_savanna_plateau");
		ROCKS_DEFAULT.add("minecraft:bamboo_jungle");
		ROCKS_DEFAULT.add("minecraft:bamboo_jungle_hills");
		ROCKS_DEFAULT.add("projectvibrantjourneys:overgrown_spires");
		
		SANDSTONE_ROCKS_DEFAULT.add("minecraft:desert");
		SANDSTONE_ROCKS_DEFAULT.add("minecraft:beach");
		SANDSTONE_ROCKS_DEFAULT.add("minecraft:desert_lakes");

		RED_SANDSTONE_ROCKS_DEFAULT.add("minecraft:badlands");
		RED_SANDSTONE_ROCKS_DEFAULT.add("minecraft:eroded_badlands");
		
		ICE_CHUNKS_DEFAULT.add("minecraft:frozen_ocean");
		ICE_CHUNKS_DEFAULT.add("minecraft:frozen_river");
		ICE_CHUNKS_DEFAULT.add("minecraft:snowy_tundra");
		ICE_CHUNKS_DEFAULT.add("minecraft:ice_spikes");
		
		BONES_DEFAULT.add("minecraft:ocean");
		BONES_DEFAULT.add("minecraft:plains");
		BONES_DEFAULT.add("minecraft:mountains");
		BONES_DEFAULT.add("minecraft:forest");
		BONES_DEFAULT.add("minecraft:taiga");
		BONES_DEFAULT.add("minecraft:swamp");
		BONES_DEFAULT.add("minecraft:river");
		BONES_DEFAULT.add("minecraft:frozen_ocean");
		BONES_DEFAULT.add("minecraft:frozen_river");
		BONES_DEFAULT.add("minecraft:snowy_tundra");
		BONES_DEFAULT.add("minecraft:snowy_mountains");
		BONES_DEFAULT.add("minecraft:beach");
		BONES_DEFAULT.add("minecraft:wooded_hills");
		BONES_DEFAULT.add("minecraft:taiga_hills");
		BONES_DEFAULT.add("minecraft:mountain_edge");
		BONES_DEFAULT.add("minecraft:jungle");
		BONES_DEFAULT.add("minecraft:jungle_hills");
		BONES_DEFAULT.add("minecraft:jungle_edge");
		BONES_DEFAULT.add("minecraft:deep_ocean");
		BONES_DEFAULT.add("minecraft:stone_shore");
		BONES_DEFAULT.add("minecraft:snowy_beach");
		BONES_DEFAULT.add("minecraft:birch_forest");
		BONES_DEFAULT.add("minecraft:birch_forest_hills");
		BONES_DEFAULT.add("minecraft:dark_forest");
		BONES_DEFAULT.add("minecraft:snowy_taiga");
		BONES_DEFAULT.add("minecraft:snowy_taiga_hills");
		BONES_DEFAULT.add("minecraft:giant_tree_taiga");
		BONES_DEFAULT.add("minecraft:giant_tree_taiga_hills");
		BONES_DEFAULT.add("minecraft:wooded_mountains");
		BONES_DEFAULT.add("minecraft:savanna");
		BONES_DEFAULT.add("minecraft:savanna_plateau");
		BONES_DEFAULT.add("minecraft:warm_ocean");
		BONES_DEFAULT.add("minecraft:lukewarm_ocean");
		BONES_DEFAULT.add("minecraft:cold_ocean");
		BONES_DEFAULT.add("minecraft:deep_warm_ocean");
		BONES_DEFAULT.add("minecraft:deep_cold_ocean");
		BONES_DEFAULT.add("minecraft:deep_frozen_ocean");
		BONES_DEFAULT.add("minecraft:sunflower_plains");
		BONES_DEFAULT.add("minecraft:gravelly_mountains");
		BONES_DEFAULT.add("minecraft:flower_forest");
		BONES_DEFAULT.add("minecraft:taiga_mountains");
		BONES_DEFAULT.add("minecraft:swamp_hills");
		BONES_DEFAULT.add("minecraft:modified_jungle");
		BONES_DEFAULT.add("minecraft:modified_jungle_edge");
		BONES_DEFAULT.add("minecraft:tall_birch_forest");
		BONES_DEFAULT.add("minecraft:tall_birch_hills");
		BONES_DEFAULT.add("minecraft:dark_forest_hills");
		BONES_DEFAULT.add("minecraft:snowy_taiga_mountains");
		BONES_DEFAULT.add("minecraft:giant_spruce_taiga");
		BONES_DEFAULT.add("minecraft:giant_spruce_taiga_hills");
		BONES_DEFAULT.add("minecraft:modified_gravelly_mountains");
		BONES_DEFAULT.add("minecraft:shattered_savanna");
		BONES_DEFAULT.add("minecraft:shattered_savanna_plateau");
		BONES_DEFAULT.add("minecraft:bamboo_jungle");
		BONES_DEFAULT.add("minecraft:bamboo_jungle_hills");
		BONES_DEFAULT.add("projectvibrantjourneys:overgrown_spires");
		BONES_COMMON_DEFAULT.add("minecraft:desert");
		BONES_COMMON_DEFAULT.add("minecraft:badlands");
		BONES_COMMON_DEFAULT.add("minecraft:desert_lakes");
		BONES_COMMON_DEFAULT.add("minecraft:eroded_badlands");
		BONES_NETHER_DEFAULT.add("minecraft:nether");
		
		PINECONES_DEFAULT.add("minecraft:taiga");
		PINECONES_DEFAULT.add("minecraft:taiga_hills");
		PINECONES_DEFAULT.add("minecraft:snowy_taiga");
		PINECONES_DEFAULT.add("minecraft:snowy_taiga_hills");
		PINECONES_DEFAULT.add("minecraft:giant_tree_taiga");
		PINECONES_DEFAULT.add("minecraft:giant_tree_taiga_hills");
		PINECONES_DEFAULT.add("minecraft:taiga_mountains");
		PINECONES_DEFAULT.add("minecraft:snowy_taiga_mountains");
		PINECONES_DEFAULT.add("minecraft:giant_spruce_taiga");
		PINECONES_DEFAULT.add("minecraft:giant_spruce_taiga_hills");
		
		SEASHELLS_DEFAULT.add("minecraft:ocean");
		SEASHELLS_DEFAULT.add("minecraft:frozen_ocean");
		SEASHELLS_DEFAULT.add("minecraft:beach");
		SEASHELLS_DEFAULT.add("minecraft:deep_ocean");
		SEASHELLS_DEFAULT.add("minecraft:stone_shore");
		SEASHELLS_DEFAULT.add("minecraft:snowy_beach");
		SEASHELLS_DEFAULT.add("minecraft:warm_ocean");
		SEASHELLS_DEFAULT.add("minecraft:lukewarm_ocean");
		SEASHELLS_DEFAULT.add("minecraft:cold_ocean");
		SEASHELLS_DEFAULT.add("minecraft:deep_warm_ocean");
		SEASHELLS_DEFAULT.add("minecraft:deep_lukewarm_ocean");
		SEASHELLS_DEFAULT.add("minecraft:deep_cold_ocean");
		SEASHELLS_DEFAULT.add("minecraft:deep_frozen_ocean");
		
		BUSH_DEFAULT.add("minecraft:plains");
		BUSH_DEFAULT.add("minecraft:sunflower:plains");
		BUSH_DEFAULT.add("projectvibrantjourneys:overgrown_spires");
		
		LILYPAD_DEFAULT.add("minecraft:plains");
		LILYPAD_DEFAULT.add("minecraft:forest");
		LILYPAD_DEFAULT.add("minecraft:taiga");
		LILYPAD_DEFAULT.add("minecraft:river");
		LILYPAD_DEFAULT.add("minecraft:wooded_hills");
		LILYPAD_DEFAULT.add("minecraft:taiga_hills");
		LILYPAD_DEFAULT.add("minecraft:jungle");
		LILYPAD_DEFAULT.add("minecraft:jungle_edge");
		LILYPAD_DEFAULT.add("minecraft:birch_forest");
		LILYPAD_DEFAULT.add("minecraft:birch_forest_hills");
		LILYPAD_DEFAULT.add("minecraft:dark_forest");
		LILYPAD_DEFAULT.add("minecraft:giant_tree_taiga");
		LILYPAD_DEFAULT.add("minecraft:giant_tree_taiga_hills");
		LILYPAD_DEFAULT.add("minecraft:wooded_mountains");
		LILYPAD_DEFAULT.add("minecraft:sunflower_plains");
		LILYPAD_DEFAULT.add("minecraft:flower_forest");
		LILYPAD_DEFAULT.add("minecraft:taiga_mountains");
		LILYPAD_DEFAULT.add("minecraft:modified_jungle");
		LILYPAD_DEFAULT.add("minecraft:modified_jungle_edge");
		LILYPAD_DEFAULT.add("minecraft:tall_birch_forest");
		LILYPAD_DEFAULT.add("minecraft:tall_birch_hills");
		LILYPAD_DEFAULT.add("minecraft:dark_forest_hills");
		LILYPAD_DEFAULT.add("minecraft:giant_spruce_taiga");
		LILYPAD_DEFAULT.add("minecraft:giant_spruce_taiga_hills");
		LILYPAD_DEFAULT.add("minecraft:bamboo_jungle");
		LILYPAD_DEFAULT.add("minecraft:bamboo_jungle_hills");
		LILYPAD_DEFAULT.add("projectvibrantjourneys:overgrown_spires");
	}
}
