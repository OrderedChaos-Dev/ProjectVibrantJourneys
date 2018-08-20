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
	//I call them differently here to distinguish between different mod's trees
	//They also make sense
	public static final ArrayList<Biome> WEEPING_WILLOW_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> RED_MANGROVE_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> COCONUT_PALM_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> COAST_REDWOOD_TREES = new ArrayList<Biome>();
	
	//BOP TREES
	public static final ArrayList<Biome> MANGROVE_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> WILLOW_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> BAMBOO_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> FLOWERING_OAK_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> JACARANDA_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> MAGIC_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> EUCALYPTUS_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> EBONY_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> PINE_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> FIR_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> DEAD_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> REDWOOD_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> YELLOW_AUTUMN_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> ORANGE_AUTUMN_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> MAPLE_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> PALM_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> WHITE_CHERRY_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> PINK_CHERRY_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> MAHOGANY_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> UMBRAN_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> HELLBARK_TREES = new ArrayList<Biome>();
	public static final ArrayList<Biome> SACRED_OAK_TREES = new ArrayList<Biome>();
	
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
		loadMesaBiomes();
		loadDesertBiomes();
		loadMossyCobblestoneBiomes();
		loadSandstoneBiomes();
		loadLilyPadBiomes();
		
		if(Reference.isBOPLoaded)
		{
			BiomeReferenceBOP.loadBOPBiomes();
		}
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
	}
	
	public static void loadJungleTrees()
	{
		JUNGLE_TREES.add(Biomes.JUNGLE);
		JUNGLE_TREES.add(Biomes.JUNGLE_EDGE);
		JUNGLE_TREES.add(Biomes.JUNGLE_HILLS);
		JUNGLE_TREES.add(Biomes.MUTATED_JUNGLE);
		JUNGLE_TREES.add(Biomes.MUTATED_JUNGLE_EDGE);
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
	}

	public static void loadWillowTrees()
	{
		WEEPING_WILLOW_TREES.add(PVJBiomes.willow_swamp);
	}
	
	public static void loadMangroveTrees()
	{
		RED_MANGROVE_TREES.add(PVJBiomes.willow_swamp);
		RED_MANGROVE_TREES.add(Biomes.SWAMPLAND);
		RED_MANGROVE_TREES.add(Biomes.MUTATED_SWAMPLAND);
		RED_MANGROVE_TREES.add(Biomes.JUNGLE);
		RED_MANGROVE_TREES.add(Biomes.JUNGLE_EDGE);
		RED_MANGROVE_TREES.add(Biomes.JUNGLE_HILLS);
		RED_MANGROVE_TREES.add(Biomes.MUTATED_JUNGLE);
		RED_MANGROVE_TREES.add(Biomes.MUTATED_JUNGLE_EDGE);
	}
	
	public static void loadPalmTrees()
	{
		COCONUT_PALM_TREES.add(Biomes.BEACH);
	}
	
	public static void loadRedwoodTrees()
	{
		COAST_REDWOOD_TREES.add(PVJBiomes.redwoods);
		COAST_REDWOOD_TREES.add(PVJBiomes.redwood_peaks);
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
	public static Biome[] getValidBiomes(ArrayList<Biome> biomeList)
	{
		return biomeList.toArray(new Biome[0]);
	}
}
