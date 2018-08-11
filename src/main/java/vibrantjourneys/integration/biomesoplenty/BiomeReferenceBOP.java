package vibrantjourneys.integration.biomesoplenty;

import java.util.ArrayList;

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
		BiomeReference.ALL_BIOMES.remove(BOPBiomes.origin_beach.get());
		BiomeReference.ALL_BIOMES.remove(BOPBiomes.origin_island.get());
		BiomeReference.OVERWORLD_BIOMES.remove(BOPBiomes.origin_beach.get());
		BiomeReference.OVERWORLD_BIOMES.remove(BOPBiomes.origin_island.get());
		BiomeReference.FRESHWATER_BIOMES.remove(BOPBiomes.origin_beach.get());
		BiomeReference.FRESHWATER_BIOMES.remove(BOPBiomes.origin_island.get());
		
		BiomeReference.OAK_TREES.add(BOPBiomes.temperate_rainforest.get());
		BiomeReference.OAK_TREES.add(BOPBiomes.mystic_grove.get());
		BiomeReference.OAK_TREES.add(BOPBiomes.rainforest.get());
		BiomeReference.OAK_TREES.add(BOPBiomes.woodland.get());
		BiomeReference.OAK_TREES.add(BOPBiomes.orchard.get());
		BiomeReference.OAK_TREES.add(BOPBiomes.dead_forest.get());
		BiomeReference.OAK_TREES.add(BOPBiomes.seasonal_forest.get());
		BiomeReference.OAK_TREES.add(BOPBiomes.land_of_lakes.get());
		BiomeReference.OAK_TREES.add(BOPBiomes.boreal_forest.get());
		BiomeReference.OAK_TREES.add(BOPBiomes.sacred_springs.get());
		
		BiomeReference.OAK_TREES_SPARSE.add(BOPBiomes.shrubland.get());
		BiomeReference.OAK_TREES_SPARSE.add(BOPBiomes.snowy_forest.get());
		BiomeReference.OAK_TREES_SPARSE.add(BOPBiomes.meadow.get());
		BiomeReference.OAK_TREES_SPARSE.add(BOPBiomes.chaparral.get());
		BiomeReference.OAK_TREES_SPARSE.add(BOPBiomes.tundra.get());
		BiomeReference.OAK_TREES_SPARSE.add(BOPBiomes.prairie.get());
		BiomeReference.OAK_TREES_SPARSE.add(BOPBiomes.shield.get());
		BiomeReference.OAK_TREES_SPARSE.add(BOPBiomes.shrubland.get());
		BiomeReference.OAK_TREES_SPARSE.add(BOPBiomes.lavender_fields.get());
		BiomeReference.OAK_TREES_SPARSE.add(BOPBiomes.corrupted_sands.get());
		
		BiomeReference.BIRCH_TREES.add(BOPBiomes.boreal_forest.get());
		
		BiomeReference.BIRCH_TREES_SPARSE.add(BOPBiomes.rainforest.get());
		BiomeReference.BIRCH_TREES_SPARSE.add(BOPBiomes.grove.get());
		BiomeReference.BIRCH_TREES_SPARSE.add(BOPBiomes.bog.get());
		
		BiomeReference.SPRUCE_TREES.add(BOPBiomes.wetland.get());
		BiomeReference.SPRUCE_TREES.add(BOPBiomes.maple_woods.get());
		BiomeReference.SPRUCE_TREES.add(BOPBiomes.land_of_lakes.get());
		BiomeReference.SPRUCE_TREES.add(BOPBiomes.shield.get());
		BiomeReference.SPRUCE_TREES.add(BOPBiomes.boreal_forest.get());
		
		BiomeReference.SPRUCE_TREES_SPARSE.add(BOPBiomes.meadow.get());
		BiomeReference.SPRUCE_TREES_SPARSE.add(BOPBiomes.dead_forest.get());
		
		BiomeReference.JUNGLE_TREES_SPARSE.add(BOPBiomes.oasis.get());
		BiomeReference.JUNGLE_TREES_SPARSE.add(BOPBiomes.tropical_rainforest.get());
		BiomeReference.JUNGLE_TREES_SPARSE.add(BOPBiomes.overgrown_cliffs.get());
		
		BiomeReference.ACACIA_TREES.add(BOPBiomes.lush_desert.get());
		
		BiomeReference.ACACIA_TREES_SPARSE.add(BOPBiomes.brushland.get());
		BiomeReference.ACACIA_TREES_SPARSE.add(BOPBiomes.outback.get());
		
		BiomeReference.DARKOAK_TREES.add(BOPBiomes.fen.get());
		
		BiomeReference.DARKOAK_TREES_SPARSE.add(BOPBiomes.grove.get());
		BiomeReference.DARKOAK_TREES.add(BOPBiomes.bog.get());
		
		BiomeReference.WEEPING_WILLOW_TREES.add(BOPBiomes.lush_swamp.get());
		BiomeReference.WEEPING_WILLOW_TREES.add(BOPBiomes.bayou.get());
		
		BiomeReference.RED_MANGROVE_TREES.add(BOPBiomes.lush_swamp.get());
		BiomeReference.RED_MANGROVE_TREES.add(BOPBiomes.mangrove.get());
		BiomeReference.RED_MANGROVE_TREES.add(BOPBiomes.marsh.get());
		
		BiomeReference.BAMBOO_TREES.add(BOPBiomes.bamboo_forest.get());
		
		BiomeReference.MANGROVE_TREES.add(BOPBiomes.mangrove.get());

		BiomeReference.FLOWERING_OAK_TREES.add(BOPBiomes.mystic_grove.get());
		BiomeReference.FLOWERING_OAK_TREES.add(BOPBiomes.rainforest.get());
		BiomeReference.FLOWERING_OAK_TREES.add(BOPBiomes.orchard.get());
		BiomeReference.FLOWERING_OAK_TREES.add(BOPBiomes.flower_island.get());
		BiomeReference.FLOWERING_OAK_TREES.add(BOPBiomes.lavender_fields.get());
		
		BiomeReference.JACARANDA_TREES.add(BOPBiomes.lavender_fields.get());
		BiomeReference.JACARANDA_TREES.add(BOPBiomes.mystic_grove.get());
		
		BiomeReference.MAGIC_TREES.add(BOPBiomes.mystic_grove.get());
		
		BiomeReference.EUCALYPTUS_TREES.add(BOPBiomes.eucalyptus_forest.get());
		
		BiomeReference.EBONY_TREES.add(BOPBiomes.brushland.get());
		
		BiomeReference.PINE_TREES.add(BOPBiomes.mountain_foothills.get());
		BiomeReference.PINE_TREES.add(BOPBiomes.mountain.get());
		BiomeReference.PINE_TREES.add(BOPBiomes.shield.get());
		
		BiomeReference.DEAD_TREES.add(BOPBiomes.dead_forest.get());
		BiomeReference.DEAD_TREES.add(BOPBiomes.dead_swamp.get());
		BiomeReference.DEAD_TREES.add(BOPBiomes.ominous_woods.get());
		BiomeReference.DEAD_TREES.add(BOPBiomes.wasteland.get());
		
		BiomeReference.FIR_TREES.add(BOPBiomes.coniferous_forest.get());
		BiomeReference.FIR_TREES.add(BOPBiomes.snowy_coniferous_forest.get());
		
		BiomeReference.REDWOOD_TREES.add(BOPBiomes.redwood_forest.get());
		
		BiomeReference.YELLOW_AUTUMN_TREES.add(BOPBiomes.seasonal_forest.get());
		BiomeReference.ORANGE_AUTUMN_TREES.add(BOPBiomes.seasonal_forest.get());
		
		BiomeReference.MAPLE_TREES.add(BOPBiomes.seasonal_forest.get());
		BiomeReference.MAPLE_TREES.add(BOPBiomes.maple_woods.get());
		
		BiomeReference.PALM_TREES.add(BOPBiomes.oasis.get());
		BiomeReference.PALM_TREES.add(BOPBiomes.tropical_island.get());
		
		BiomeReference.WHITE_CHERRY_TREES.add(BOPBiomes.cherry_blossom_grove.get());
		
		BiomeReference.PINK_CHERRY_TREES.add(BOPBiomes.cherry_blossom_grove.get());
		
		BiomeReference.MAHOGANY_TREES.add(BOPBiomes.tropical_island.get());
		BiomeReference.MAHOGANY_TREES.add(BOPBiomes.overgrown_cliffs.get());
		
		BiomeReference.UMBRAN_TREES.add(BOPBiomes.ominous_woods.get());
		
		BiomeReference.HELLBARK_TREES.add(BOPBiomes.undergarden.get());
		
		BiomeReference.SACRED_OAK_TREES.add(BOPBiomes.sacred_springs.get());
		
		BiomeReference.SANDSTONE_BIOMES.add(BOPBiomes.oasis.get());
		BiomeReference.SANDSTONE_BIOMES.add(BOPBiomes.lush_desert.get());
		
		BiomeReference.MESA_BIOMES.add(BOPBiomes.outback.get());
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
