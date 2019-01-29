package vibrantjourneys.util;

import java.util.ArrayList;
import java.util.stream.Collectors;

import net.minecraft.block.BlockNewLog;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import vibrantjourneys.init.PVJBiomes;
import vibrantjourneys.integration.biomesoplenty.BiomeReferenceBOP;
import vibrantjourneys.integration.traverse.BiomeReferenceTraverse;

/**
 * Used by PVJWorldGen.class to generate biome/tree based structures.
 * BiomeDictionary.Type is not used for reasons (oak trees do not spawn in all Type.FOREST)
 */
public class BiomeReference
{
	//BIOMES LISTS
    public static final ArrayList<Biome> ALL_BIOMES = new ArrayList<Biome>();
    public static final ArrayList<Biome> OVERWORLD_BIOMES = new ArrayList<Biome>();
    public static final ArrayList<Biome> FRESHWATER_BIOMES = new ArrayList<Biome>();
	public static final ArrayList<Biome> DESERT_BIOMES = new ArrayList<Biome>();
	public static final ArrayList<Biome> MESA_BIOMES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BEACH_BIOMES = new ArrayList<Biome>();
	public static final ArrayList<Biome> SNOWY_BIOMES = new ArrayList<Biome>();
	public static final ArrayList<Biome> NETHER_BIOMES = new ArrayList<Biome>();
	public static final ArrayList<Biome> END_BIOMES = new ArrayList<Biome>();
	public static final ArrayList<Biome> MOSSY_COBBLESTONE_BIOMES = new ArrayList<Biome>();
	public static final ArrayList<Biome> SANDSTONE_BIOMES = new ArrayList<Biome>();
	public static final ArrayList<Biome> LILYPAD_BIOMES = new ArrayList<Biome>();
	public static final ArrayList<Biome> MOUNTAIN_BIOMES = new ArrayList<Biome>();
	public static final ArrayList<Biome> COYOTE_BIOMES = new ArrayList<Biome>();
	public static final ArrayList<Biome> MARINE_BIOMES = new ArrayList<Biome>();
	public static final ArrayList<Biome> DUCK_BIOMES = new ArrayList<Biome>();
	
	//TREES LISTS
	//VANILLA TREES
	public static final ArrayList<Biome> OAK_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BIRCH_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> SPRUCE_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> JUNGLE_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> ACACIA_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> DARKOAK_TREES = new ArrayList<Biome>();
	
	public static final ArrayList<Biome> OAK_TREES_SPARSE = new ArrayList<Biome>();
	public static final ArrayList<Biome> BIRCH_TREES_SPARSE = new ArrayList<Biome>();
	public static final ArrayList<Biome> SPRUCE_TREES_SPARSE = new ArrayList<Biome>();
	public static final ArrayList<Biome> JUNGLE_TREES_SPARSE = new ArrayList<Biome>();
	public static final ArrayList<Biome> ACACIA_TREES_SPARSE = new ArrayList<Biome>();
	public static final ArrayList<Biome> DARKOAK_TREES_SPARSE = new ArrayList<Biome>();
	
	//Project: Vibrant Journeys TREES
	public static final ArrayList<Biome> WILLOW_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> MANGROVE_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> PALM_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> REDWOOD_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> FIR_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> PINE_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> ASPEN_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> RED_MAPLE_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> ORANGE_MAPLE_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BAOBAB_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> COTTONWOOD_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> JUNIPER_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> WHITE_CHERRY_BLOSSOM_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> PINK_CHERRY_BLOSSOM_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> JACARANDA_TREES = new ArrayList<Biome>();
	
	//BOP TREES
	public static final ArrayList<Biome> BOP_MANGROVE_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BOP_WILLOW_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BOP_BAMBOO_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BOP_FLOWERING_OAK_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BOP_JACARANDA_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BOP_MAGIC_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BOP_EUCALYPTUS_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BOP_EBONY_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BOP_PINE_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BOP_FIR_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BOP_DEAD_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BOP_REDWOOD_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BOP_YELLOW_AUTUMN_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BOP_ORANGE_AUTUMN_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BOP_MAPLE_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BOP_PALM_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BOP_WHITE_CHERRY_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BOP_PINK_CHERRY_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BOP_MAHOGANY_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BOP_UMBRAN_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BOP_HELLBARK_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BOP_SACRED_OAK_TREES = new ArrayList<Biome>();
	
	//TRAVERSE TREES
	public static final ArrayList<Biome> TRAVERSE_RED_AUTUMN_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> TRAVERSE_BROWN_AUTUMN_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> TRAVERSE_ORANGE_AUTUMN_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> TRAVERSE_YELLOW_AUTUMN_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> TRAVERSE_FIR_TREES = new ArrayList<Biome>();
	
	public static void loadAllBiomeReferences()
	{
		loadOakTrees();
		loadBirchTrees();
		loadSpruceTrees();
		loadJungleTrees();
		loadAcaciaTrees();
		loadDarkOakTrees();
		loadWillowTrees();
		loadMangroveTrees();
		loadPalmTrees();
		loadRedwoodTrees();
		loadFirTrees();
		loadPineTrees();
		loadAspenTrees();
		loadMapleTrees();
		loadBaobabTrees();
		loadCottonwoodTrees();
		loadJuniperTrees();
		loadCherryBlossomTrees();
		loadJacarandaTrees();
		
		ALL_BIOMES.addAll(ForgeRegistries.BIOMES.getValuesCollection());
		OVERWORLD_BIOMES.addAll(ALL_BIOMES.stream()
			.filter(biome -> !(BiomeDictionary.hasType(biome, Type.NETHER) || BiomeDictionary.hasType(biome, Type.END)))
			.collect(Collectors.toList()));
		FRESHWATER_BIOMES.addAll(OVERWORLD_BIOMES.stream()
			.filter(biome -> !(BiomeDictionary.hasType(biome, Type.OCEAN) || BiomeDictionary.hasType(biome, Type.BEACH)))
			.collect(Collectors.toList()));
		SNOWY_BIOMES.addAll(BiomeDictionary.getBiomes(Type.SNOWY));
		NETHER_BIOMES.addAll(BiomeDictionary.getBiomes(Type.NETHER));
		END_BIOMES.addAll(BiomeDictionary.getBiomes(Type.END));
		BEACH_BIOMES.addAll(OVERWORLD_BIOMES.stream()
				.filter(biome -> BiomeDictionary.hasType(biome, Type.BEACH))
				.collect(Collectors.toList()));
		MARINE_BIOMES.addAll(BEACH_BIOMES);
		MARINE_BIOMES.addAll(OVERWORLD_BIOMES.stream()
				.filter(biome -> BiomeDictionary.hasType(biome, Type.OCEAN))
				.collect(Collectors.toList()));
		loadMesaBiomes();
		loadDesertBiomes();
		loadMossyCobblestoneBiomes();
		loadSandstoneBiomes();
		loadLilyPadBiomes();
		loadMountainBiomes();
		loadCoyoteBiomes();
		loadDuckBiomes();
		
		if(Reference.isBOPLoaded)
			BiomeReferenceBOP.loadBOPBiomes();
		if(Reference.isTraverseLoaded)
			BiomeReferenceTraverse.loadTraverseBiomes();
	}

	public static void loadOakTrees()
	{
		OAK_TREES.add(Biomes.FOREST);
		OAK_TREES.add(Biomes.FOREST_HILLS);
		OAK_TREES.add(Biomes.SWAMPLAND);
		OAK_TREES.add(Biomes.MUTATED_FOREST);
		OAK_TREES.add(Biomes.MUTATED_SWAMPLAND);
		
		OAK_TREES_SPARSE.add(Biomes.JUNGLE);
		OAK_TREES_SPARSE.add(Biomes.MUTATED_JUNGLE);
		OAK_TREES_SPARSE.add(Biomes.PLAINS);
		OAK_TREES_SPARSE.add(Biomes.MUTATED_PLAINS);
		OAK_TREES_SPARSE.add(Biomes.ROOFED_FOREST);
		OAK_TREES_SPARSE.add(Biomes.MUTATED_ROOFED_FOREST);
		OAK_TREES_SPARSE.add(PVJBiomes.prairie);
		OAK_TREES_SPARSE.add(PVJBiomes.aspen_grove);
		OAK_TREES_SPARSE.add(PVJBiomes.overgrown_spires);
	}
	
	public static void loadBirchTrees()
	{
		BIRCH_TREES.add(Biomes.BIRCH_FOREST);
		BIRCH_TREES.add(Biomes.BIRCH_FOREST_HILLS);
		BIRCH_TREES.add(Biomes.MUTATED_BIRCH_FOREST);
		BIRCH_TREES.add(Biomes.MUTATED_BIRCH_FOREST_HILLS);
		
		BIRCH_TREES_SPARSE.add(Biomes.FOREST);
		BIRCH_TREES_SPARSE.add(Biomes.FOREST_HILLS);
		BIRCH_TREES_SPARSE.add(Biomes.MUTATED_FOREST);
		BIRCH_TREES_SPARSE.add(Biomes.ROOFED_FOREST);
		BIRCH_TREES_SPARSE.add(Biomes.MUTATED_ROOFED_FOREST);
	}

	public static void loadSpruceTrees()
	{
		SPRUCE_TREES.add(Biomes.COLD_TAIGA);
		SPRUCE_TREES.add(Biomes.COLD_TAIGA_HILLS);
		SPRUCE_TREES.add(Biomes.EXTREME_HILLS_WITH_TREES);
		SPRUCE_TREES.add(Biomes.MUTATED_REDWOOD_TAIGA);
		SPRUCE_TREES.add(Biomes.MUTATED_REDWOOD_TAIGA_HILLS);
		SPRUCE_TREES.add(Biomes.TAIGA);
		SPRUCE_TREES.add(Biomes.TAIGA_HILLS);
		
		SPRUCE_TREES_SPARSE.add(Biomes.EXTREME_HILLS_WITH_TREES);
		SPRUCE_TREES_SPARSE.add(Biomes.MUTATED_EXTREME_HILLS_WITH_TREES);
		SPRUCE_TREES_SPARSE.add(Biomes.EXTREME_HILLS_EDGE);
		SPRUCE_TREES_SPARSE.add(PVJBiomes.boreal_forest);
		SPRUCE_TREES_SPARSE.add(PVJBiomes.snowy_boreal_forest);
	}
	
	public static void loadJungleTrees()
	{
		JUNGLE_TREES.add(Biomes.JUNGLE);
		JUNGLE_TREES.add(Biomes.JUNGLE_EDGE);
		JUNGLE_TREES.add(Biomes.JUNGLE_HILLS);
		JUNGLE_TREES.add(Biomes.MUTATED_JUNGLE);
		JUNGLE_TREES.add(Biomes.MUTATED_JUNGLE_EDGE);
		JUNGLE_TREES.add(PVJBiomes.overgrown_spires);
	}
	
	public static void loadAcaciaTrees()
	{
		ACACIA_TREES.add(Biomes.SAVANNA);
		ACACIA_TREES.add(Biomes.SAVANNA_PLATEAU);
		ACACIA_TREES.add(Biomes.MUTATED_SAVANNA);
		ACACIA_TREES.add(Biomes.MUTATED_SAVANNA_ROCK);
	}
	
	public static void loadDarkOakTrees()
	{
		DARKOAK_TREES.add(Biomes.ROOFED_FOREST);
		DARKOAK_TREES.add(Biomes.MUTATED_ROOFED_FOREST);
		DARKOAK_TREES.add(PVJBiomes.overgrown_spires);
	}

	public static void loadWillowTrees()
	{
		WILLOW_TREES.add(PVJBiomes.willow_swamp);
	}
	
	public static void loadMangroveTrees()
	{
		MANGROVE_TREES.add(PVJBiomes.willow_swamp);
		MANGROVE_TREES.add(Biomes.SWAMPLAND);
		MANGROVE_TREES.add(Biomes.MUTATED_SWAMPLAND);
		MANGROVE_TREES.add(Biomes.JUNGLE);
		MANGROVE_TREES.add(Biomes.JUNGLE_EDGE);
		MANGROVE_TREES.add(Biomes.JUNGLE_HILLS);
		MANGROVE_TREES.add(Biomes.MUTATED_JUNGLE);
		MANGROVE_TREES.add(Biomes.MUTATED_JUNGLE_EDGE);
		MANGROVE_TREES.add(PVJBiomes.overgrown_spires);
	}
	
	public static void loadPalmTrees()
	{
		PALM_TREES.add(Biomes.BEACH);
	}
	
	public static void loadRedwoodTrees()
	{
		REDWOOD_TREES.add(PVJBiomes.redwoods);
		REDWOOD_TREES.add(PVJBiomes.redwood_peaks);
	}
	
	public static void loadFirTrees()
	{
		FIR_TREES.add(PVJBiomes.boreal_forest);
		FIR_TREES.add(PVJBiomes.snowy_boreal_forest);
	}
	
	public static void loadPineTrees()
	{
		PINE_TREES.add(PVJBiomes.boreal_forest);
		PINE_TREES.add(PVJBiomes.snowy_boreal_forest);
	}
	
	public static void loadAspenTrees()
	{
		ASPEN_TREES.add(PVJBiomes.aspen_grove);
	}
	
	public static void loadMapleTrees()
	{
		RED_MAPLE_TREES.add(PVJBiomes.aspen_grove);
		ORANGE_MAPLE_TREES.add(PVJBiomes.aspen_grove);
	}
	
	public static void loadBaobabTrees()
	{
		BAOBAB_TREES.add(Biomes.SAVANNA);
		BAOBAB_TREES.add(Biomes.SAVANNA_PLATEAU);
		BAOBAB_TREES.add(Biomes.MUTATED_SAVANNA);
		BAOBAB_TREES.add(Biomes.MUTATED_SAVANNA_ROCK);
	}
	
	public static void loadCottonwoodTrees()
	{
		COTTONWOOD_TREES.add(PVJBiomes.prairie);
	}
	
	public static void loadJuniperTrees()
	{
		JUNIPER_TREES.add(Biomes.MESA);
		JUNIPER_TREES.add(Biomes.MESA_CLEAR_ROCK);
		JUNIPER_TREES.add(Biomes.MESA_ROCK);
		JUNIPER_TREES.add(Biomes.MUTATED_MESA);
		JUNIPER_TREES.add(Biomes.MUTATED_MESA_CLEAR_ROCK);
		JUNIPER_TREES.add(Biomes.MUTATED_MESA_ROCK);
	}
	
	public static void loadCherryBlossomTrees()
	{
		WHITE_CHERRY_BLOSSOM_TREES.add(Biomes.MUTATED_FOREST);
		WHITE_CHERRY_BLOSSOM_TREES.add(PVJBiomes.blossoming_fields);
		PINK_CHERRY_BLOSSOM_TREES.add(Biomes.MUTATED_FOREST);
		PINK_CHERRY_BLOSSOM_TREES.add(PVJBiomes.blossoming_fields);
	}
	
	public static void loadJacarandaTrees()
	{
		JACARANDA_TREES.add(Biomes.JUNGLE);
		JACARANDA_TREES.add(Biomes.JUNGLE_EDGE);
		JACARANDA_TREES.add(Biomes.JUNGLE_HILLS);
		JACARANDA_TREES.add(Biomes.MUTATED_JUNGLE);
		JACARANDA_TREES.add(Biomes.MUTATED_JUNGLE_EDGE);
		JACARANDA_TREES.add(Biomes.MUTATED_FOREST);
		JACARANDA_TREES.add(PVJBiomes.blossoming_fields);
	}
	
	public static void loadMesaBiomes()
	{
		MESA_BIOMES.add(Biomes.MESA);
		MESA_BIOMES.add(Biomes.MESA_CLEAR_ROCK);
		MESA_BIOMES.add(Biomes.MESA_ROCK);
		MESA_BIOMES.add(Biomes.MUTATED_MESA);
		MESA_BIOMES.add(Biomes.MUTATED_MESA_CLEAR_ROCK);
		MESA_BIOMES.add(Biomes.MUTATED_MESA_ROCK);
	}
	
	public static void loadDesertBiomes()
	{
		DESERT_BIOMES.add(Biomes.DESERT);
		DESERT_BIOMES.add(Biomes.DESERT_HILLS);
		DESERT_BIOMES.add(Biomes.MUTATED_DESERT);
	}
	
	public static void loadMossyCobblestoneBiomes()
	{
		MOSSY_COBBLESTONE_BIOMES.add(Biomes.MUTATED_REDWOOD_TAIGA);
		MOSSY_COBBLESTONE_BIOMES.add(Biomes.MUTATED_REDWOOD_TAIGA_HILLS);
		MOSSY_COBBLESTONE_BIOMES.add(Biomes.SWAMPLAND);
		MOSSY_COBBLESTONE_BIOMES.add(Biomes.MUTATED_SWAMPLAND);
		MOSSY_COBBLESTONE_BIOMES.add(PVJBiomes.redwoods);
		MOSSY_COBBLESTONE_BIOMES.add(Biomes.JUNGLE);
		MOSSY_COBBLESTONE_BIOMES.add(Biomes.JUNGLE_EDGE);
		MOSSY_COBBLESTONE_BIOMES.add(Biomes.JUNGLE_HILLS);
		MOSSY_COBBLESTONE_BIOMES.add(Biomes.MUTATED_JUNGLE);
		MOSSY_COBBLESTONE_BIOMES.add(Biomes.MUTATED_JUNGLE_EDGE);
		MOSSY_COBBLESTONE_BIOMES.add(PVJBiomes.overgrown_spires);
	}
	
	public static void loadSandstoneBiomes()
	{
		SANDSTONE_BIOMES.addAll(DESERT_BIOMES);
		SANDSTONE_BIOMES.add(Biomes.BEACH);
	}
	
	public static void loadLilyPadBiomes()
	{
		for(Biome biome : FRESHWATER_BIOMES)
		{
			//hehe
			if(!BiomeDictionary.hasType(biome, Type.DEAD))
				if(!BiomeDictionary.hasType(biome, Type.MESA))
					if(!BiomeDictionary.hasType(biome, Type.DRY))
						if(!BiomeDictionary.hasType(biome, Type.SNOWY))
							if(!BiomeDictionary.hasType(biome, Type.SAVANNA))
								if(!BiomeDictionary.hasType(biome, Type.WASTELAND))
									LILYPAD_BIOMES.add(biome);
		}
	}
	
	public static void loadMountainBiomes()
	{
		MOUNTAIN_BIOMES.add(Biomes.EXTREME_HILLS);
		MOUNTAIN_BIOMES.add(Biomes.EXTREME_HILLS_EDGE);
		MOUNTAIN_BIOMES.add(Biomes.EXTREME_HILLS_WITH_TREES);
		MOUNTAIN_BIOMES.add(Biomes.MUTATED_EXTREME_HILLS);
		MOUNTAIN_BIOMES.add(Biomes.MUTATED_EXTREME_HILLS_WITH_TREES);
	}
	
	public static void loadCoyoteBiomes()
	{
		COYOTE_BIOMES.addAll(DESERT_BIOMES);
		COYOTE_BIOMES.addAll(MESA_BIOMES);
		COYOTE_BIOMES.add(PVJBiomes.prairie);
	}
	
	public static void loadDuckBiomes()
	{
		DUCK_BIOMES.addAll(FRESHWATER_BIOMES);
		DUCK_BIOMES.removeAll(DESERT_BIOMES);
		DUCK_BIOMES.removeAll(MESA_BIOMES);
		DUCK_BIOMES.removeAll(BiomeDictionary.getBiomes(Type.JUNGLE));
		DUCK_BIOMES.removeAll(BiomeDictionary.getBiomes(Type.SAVANNA));
		DUCK_BIOMES.removeAll(SNOWY_BIOMES);
	}
    
    //REMOVE IN 1.13
    //---------------------------------------------------
    public static final IBlockState OAK_LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK);
    public static final IBlockState BIRCH_LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH);
    public static final IBlockState SPRUCE_LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE);
    public static final IBlockState ACACIA_LOG = Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA);
    //----------------------------------------------------
    
	/**
	 * Used by PVJWorldGen to convert between BiomeReference's arraylists to arrays.
	 * @param biomeList an ArrayList of biome values
	 * @return array version of biomeList
	 */
	public static Biome[] getBiomes(ArrayList<Biome> biomeList)
	{
		return biomeList.toArray(new Biome[0]);
	}
}
