package vibrantjourneys.integration.biomesoplenty;

import java.util.ArrayList;

import com.google.common.base.Optional;

import biomesoplenty.api.biome.BOPBiomes;
import biomesoplenty.api.enums.BOPWoods;
import biomesoplenty.common.block.BlockBOPLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.biome.Biome;
import vibrantjourneys.util.BiomeReference;

public class BiomeReferenceBOP
{
	public static final IBlockState JACARANDA_LOG = BlockBOPLog.paging.getVariantState(BOPWoods.JACARANDA);
	public static final IBlockState PINE_LOG = BlockBOPLog.paging.getVariantState(BOPWoods.PINE);
	public static final IBlockState FIR_LOG = BlockBOPLog.paging.getVariantState(BOPWoods.FIR);
	public static final IBlockState WILLOW_LOG = BlockBOPLog.paging.getVariantState(BOPWoods.WILLOW);
	public static final IBlockState MANGROVE_LOG = BlockBOPLog.paging.getVariantState(BOPWoods.MANGROVE);
	public static final IBlockState EUCALYPTUS_LOG = BlockBOPLog.paging.getVariantState(BOPWoods.EUCALYPTUS);
	public static final IBlockState DEAD_LOG = BlockBOPLog.paging.getVariantState(BOPWoods.DEAD);
	public static final IBlockState REDWOOD_LOG = BlockBOPLog.paging.getVariantState(BOPWoods.REDWOOD);
	public static final IBlockState PALM_LOG = BlockBOPLog.paging.getVariantState(BOPWoods.PALM);
	public static final IBlockState MAHOGONY_LOG = BlockBOPLog.paging.getVariantState(BOPWoods.MAHOGANY);
	public static final IBlockState CHERRY_LOG = BlockBOPLog.paging.getVariantState(BOPWoods.CHERRY);
	public static final IBlockState UMBRAN_LOG = BlockBOPLog.paging.getVariantState(BOPWoods.UMBRAN);
	public static final IBlockState SACRED_OAK_LOG = BlockBOPLog.paging.getVariantState(BOPWoods.SACRED_OAK);
	public static final IBlockState EBONY_LOG = BlockBOPLog.paging.getVariantState(BOPWoods.EBONY);
	public static final IBlockState MAGIC_LOG = BlockBOPLog.paging.getVariantState(BOPWoods.MAGIC);
	
	public static void loadBOPBiomes()
	{
		//gotta preserve the origin island
		removeBiomeFromList(BiomeReference.ALL_BIOMES, BOPBiomes.origin_beach);
		removeBiomeFromList(BiomeReference.ALL_BIOMES, BOPBiomes.origin_island);
		removeBiomeFromList(BiomeReference.OVERWORLD_BIOMES, BOPBiomes.origin_beach);
		removeBiomeFromList(BiomeReference.OVERWORLD_BIOMES, BOPBiomes.origin_island);
		removeBiomeFromList(BiomeReference.FRESHWATER_BIOMES, BOPBiomes.origin_beach);
		removeBiomeFromList(BiomeReference.FRESHWATER_BIOMES, BOPBiomes.origin_island);
		
		addBiomeToList(BiomeReference.OAK_TREES, BOPBiomes.temperate_rainforest);
		addBiomeToList(BiomeReference.OAK_TREES, BOPBiomes.mystic_grove);
		addBiomeToList(BiomeReference.OAK_TREES, BOPBiomes.rainforest);
		addBiomeToList(BiomeReference.OAK_TREES, BOPBiomes.woodland);
		addBiomeToList(BiomeReference.OAK_TREES, BOPBiomes.orchard);
		addBiomeToList(BiomeReference.OAK_TREES, BOPBiomes.dead_forest);
		addBiomeToList(BiomeReference.OAK_TREES, BOPBiomes.seasonal_forest);
		addBiomeToList(BiomeReference.OAK_TREES, BOPBiomes.land_of_lakes);
		addBiomeToList(BiomeReference.OAK_TREES, BOPBiomes.boreal_forest);
		addBiomeToList(BiomeReference.OAK_TREES, BOPBiomes.sacred_springs);
		
		addBiomeToList(BiomeReference.OAK_TREES_SPARSE, BOPBiomes.shrubland);
		addBiomeToList(BiomeReference.OAK_TREES_SPARSE, BOPBiomes.snowy_forest);
		addBiomeToList(BiomeReference.OAK_TREES_SPARSE, BOPBiomes.meadow);
		addBiomeToList(BiomeReference.OAK_TREES_SPARSE, BOPBiomes.chaparral);
		addBiomeToList(BiomeReference.OAK_TREES_SPARSE, BOPBiomes.tundra);
		addBiomeToList(BiomeReference.OAK_TREES_SPARSE, BOPBiomes.prairie);
		addBiomeToList(BiomeReference.OAK_TREES_SPARSE, BOPBiomes.shield);
		addBiomeToList(BiomeReference.OAK_TREES_SPARSE, BOPBiomes.shrubland);
		addBiomeToList(BiomeReference.OAK_TREES_SPARSE, BOPBiomes.lavender_fields);
		addBiomeToList(BiomeReference.OAK_TREES_SPARSE, BOPBiomes.corrupted_sands);
		
		addBiomeToList(BiomeReference.BIRCH_TREES, BOPBiomes.boreal_forest);
		
		addBiomeToList(BiomeReference.BIRCH_TREES_SPARSE, BOPBiomes.rainforest);
		addBiomeToList(BiomeReference.BIRCH_TREES_SPARSE, BOPBiomes.grove);
		addBiomeToList(BiomeReference.BIRCH_TREES_SPARSE, BOPBiomes.bog);
		
		addBiomeToList(BiomeReference.SPRUCE_TREES, BOPBiomes.wetland);
		addBiomeToList(BiomeReference.SPRUCE_TREES, BOPBiomes.maple_woods);
		addBiomeToList(BiomeReference.SPRUCE_TREES, BOPBiomes.land_of_lakes);
		addBiomeToList(BiomeReference.SPRUCE_TREES, BOPBiomes.shield);
		addBiomeToList(BiomeReference.SPRUCE_TREES, BOPBiomes.boreal_forest);
		
		addBiomeToList(BiomeReference.SPRUCE_TREES_SPARSE, BOPBiomes.meadow);
		addBiomeToList(BiomeReference.SPRUCE_TREES_SPARSE, BOPBiomes.dead_forest);
		
		addBiomeToList(BiomeReference.JUNGLE_TREES_SPARSE, BOPBiomes.oasis);
		addBiomeToList(BiomeReference.JUNGLE_TREES_SPARSE, BOPBiomes.tropical_rainforest);
		addBiomeToList(BiomeReference.JUNGLE_TREES_SPARSE, BOPBiomes.overgrown_cliffs);
		
		addBiomeToList(BiomeReference.ACACIA_TREES, BOPBiomes.lush_desert);
		
		addBiomeToList(BiomeReference.ACACIA_TREES_SPARSE, BOPBiomes.brushland);
		addBiomeToList(BiomeReference.ACACIA_TREES_SPARSE, BOPBiomes.outback);
		
		addBiomeToList(BiomeReference.DARKOAK_TREES, BOPBiomes.fen);
		
		addBiomeToList(BiomeReference.DARKOAK_TREES_SPARSE, BOPBiomes.grove);
		addBiomeToList(BiomeReference.DARKOAK_TREES, BOPBiomes.bog);
		
		addBiomeToList(BiomeReference.WEEPING_WILLOW_TREES, BOPBiomes.lush_swamp);
		addBiomeToList(BiomeReference.WEEPING_WILLOW_TREES, BOPBiomes.bayou);
		
		addBiomeToList(BiomeReference.RED_MANGROVE_TREES, BOPBiomes.lush_swamp);
		addBiomeToList(BiomeReference.RED_MANGROVE_TREES, BOPBiomes.mangrove);
		addBiomeToList(BiomeReference.RED_MANGROVE_TREES, BOPBiomes.marsh);
		
		addBiomeToList(BiomeReference.BAMBOO_TREES, BOPBiomes.bamboo_forest);
		
		addBiomeToList(BiomeReference.MANGROVE_TREES, BOPBiomes.mangrove);

		addBiomeToList(BiomeReference.FLOWERING_OAK_TREES, BOPBiomes.mystic_grove);
		addBiomeToList(BiomeReference.FLOWERING_OAK_TREES, BOPBiomes.rainforest);
		addBiomeToList(BiomeReference.FLOWERING_OAK_TREES, BOPBiomes.orchard);
		addBiomeToList(BiomeReference.FLOWERING_OAK_TREES, BOPBiomes.flower_island);
		addBiomeToList(BiomeReference.FLOWERING_OAK_TREES, BOPBiomes.lavender_fields);
		
		addBiomeToList(BiomeReference.JACARANDA_TREES, BOPBiomes.lavender_fields);
		addBiomeToList(BiomeReference.JACARANDA_TREES, BOPBiomes.mystic_grove);
		
		addBiomeToList(BiomeReference.MAGIC_TREES, BOPBiomes.mystic_grove);
		
		addBiomeToList(BiomeReference.EUCALYPTUS_TREES, BOPBiomes.eucalyptus_forest);
		
		addBiomeToList(BiomeReference.EBONY_TREES, BOPBiomes.brushland);
		
		addBiomeToList(BiomeReference.PINE_TREES, BOPBiomes.mountain_foothills);
		addBiomeToList(BiomeReference.PINE_TREES, BOPBiomes.mountain);
		addBiomeToList(BiomeReference.PINE_TREES, BOPBiomes.shield);
		
		addBiomeToList(BiomeReference.DEAD_TREES, BOPBiomes.dead_forest);
		addBiomeToList(BiomeReference.DEAD_TREES, BOPBiomes.dead_swamp);
		addBiomeToList(BiomeReference.DEAD_TREES, BOPBiomes.ominous_woods);
		addBiomeToList(BiomeReference.DEAD_TREES, BOPBiomes.wasteland);
		
		addBiomeToList(BiomeReference.FIR_TREES, BOPBiomes.coniferous_forest);
		addBiomeToList(BiomeReference.FIR_TREES, BOPBiomes.snowy_coniferous_forest);
		
		addBiomeToList(BiomeReference.REDWOOD_TREES, BOPBiomes.redwood_forest);
		
		addBiomeToList(BiomeReference.YELLOW_AUTUMN_TREES, BOPBiomes.seasonal_forest);
		addBiomeToList(BiomeReference.ORANGE_AUTUMN_TREES, BOPBiomes.seasonal_forest);
		
		addBiomeToList(BiomeReference.MAPLE_TREES, BOPBiomes.seasonal_forest);
		addBiomeToList(BiomeReference.MAPLE_TREES, BOPBiomes.maple_woods);
		
		addBiomeToList(BiomeReference.PALM_TREES, BOPBiomes.oasis);
		addBiomeToList(BiomeReference.PALM_TREES, BOPBiomes.tropical_island);
		
		addBiomeToList(BiomeReference.WHITE_CHERRY_TREES, BOPBiomes.cherry_blossom_grove);
		
		addBiomeToList(BiomeReference.PINK_CHERRY_TREES, BOPBiomes.cherry_blossom_grove);
		
		addBiomeToList(BiomeReference.MAHOGANY_TREES, BOPBiomes.tropical_island);
		addBiomeToList(BiomeReference.MAHOGANY_TREES, BOPBiomes.overgrown_cliffs);
		
		addBiomeToList(BiomeReference.UMBRAN_TREES, BOPBiomes.ominous_woods);
		
		addBiomeToList(BiomeReference.HELLBARK_TREES, BOPBiomes.undergarden);
		
		addBiomeToList(BiomeReference.SACRED_OAK_TREES, BOPBiomes.sacred_springs);
		
		addBiomeToList(BiomeReference.SANDSTONE_BIOMES, BOPBiomes.oasis);
		addBiomeToList(BiomeReference.SANDSTONE_BIOMES, BOPBiomes.lush_desert);
		
		addBiomeToList(BiomeReference.MESA_BIOMES, BOPBiomes.outback);
	}
	
	public static void addBiomeToList(ArrayList<Biome> list, Optional<Biome> biome)
	{
		if(biome.isPresent())
		{
			list.add(biome.get());
		}
	}
	
	public static void removeBiomeFromList(ArrayList<Biome> list, Optional<Biome> biome)
	{
		if(biome.isPresent())
		{
			list.remove(biome.get());
		}
	}
	
	public static ArrayList<Biome> getBiomeReference(String name)
	{
		switch(name)
		{
			case "bamboo":
				return BiomeReference.BAMBOO_TREES;
			case "magic":
				return BiomeReference.MAGIC_TREES;
			case "yellow_autumn":
				return BiomeReference.YELLOW_AUTUMN_TREES;
			case "orange_autumn":
				return BiomeReference.ORANGE_AUTUMN_TREES;
			case "umbran":
				return BiomeReference.UMBRAN_TREES;
			case "fir":
				return BiomeReference.FIR_TREES;
			case "pink_cherry":
				return BiomeReference.PINK_CHERRY_TREES;
			case "white_cherry":
				return BiomeReference.WHITE_CHERRY_TREES;
			case "maple":
				return BiomeReference.MAPLE_TREES;
			case "hellbark":
				return BiomeReference.HELLBARK_TREES;
			case "flowering":
				return BiomeReference.FLOWERING_OAK_TREES;
			case "jacaranda":
				return BiomeReference.JACARANDA_TREES;
			case "sacred_oak":
				return BiomeReference.SACRED_OAK_TREES;
			case "mangrove":
				return BiomeReference.MANGROVE_TREES;
			case "palm":
				return BiomeReference.PALM_TREES;
			case "redwood":
				return BiomeReference.REDWOOD_TREES;
			case "willow":
				return BiomeReference.WILLOW_TREES;
			case "pine":
				return BiomeReference.PINE_TREES;
			case "mahogany":
				return BiomeReference.MAHOGANY_TREES;
			case "ebony":
				return BiomeReference.EBONY_TREES;
			case "eucalyptus":
				return BiomeReference.EUCALYPTUS_TREES;
			default:
				return new ArrayList<Biome>();
		}
	}
	

}
