package vibrantjourneys.util;

import net.minecraftforge.oredict.OreDictionary;
import vibrantjourneys.init.PVJBlocks;

public class PVJOreDictionary
{
	public static void setValues()
	{
		//oof :(
		OreDictionary.registerOre("plankWood", PVJBlocks.willow_planks);
		OreDictionary.registerOre("plankWood", PVJBlocks.mangrove_planks);
		OreDictionary.registerOre("plankWood", PVJBlocks.palm_planks);
		OreDictionary.registerOre("plankWood", PVJBlocks.redwood_planks);
		
		OreDictionary.registerOre("logWood", PVJBlocks.willow_log);
		OreDictionary.registerOre("logWood", PVJBlocks.mangrove_log);
		OreDictionary.registerOre("logWood", PVJBlocks.palm_log);
		OreDictionary.registerOre("logWood", PVJBlocks.redwood_log);
		
		OreDictionary.registerOre("slabWood", PVJBlocks.willow_half_slab);
		OreDictionary.registerOre("slabWood", PVJBlocks.mangrove_half_slab);
		OreDictionary.registerOre("slabWood", PVJBlocks.palm_half_slab);
		OreDictionary.registerOre("slabWood", PVJBlocks.redwood_half_slab);
		
		OreDictionary.registerOre("treeSapling", PVJBlocks.willow_sapling);
		OreDictionary.registerOre("treeSapling", PVJBlocks.mangrove_sapling);
		OreDictionary.registerOre("treeSapling", PVJBlocks.palm_sapling);
		OreDictionary.registerOre("treeSapling", PVJBlocks.redwood_sapling);
		
		OreDictionary.registerOre("treeLeaves", PVJBlocks.willow_leaves);
		OreDictionary.registerOre("treeLeaves", PVJBlocks.mangrove_leaves);
		OreDictionary.registerOre("treeLeaves", PVJBlocks.palm_leaves);
		OreDictionary.registerOre("treeLeaves", PVJBlocks.redwood_leaves);
		
		OreDictionary.registerOre("stairWood", PVJBlocks.willow_stairs);
		OreDictionary.registerOre("stairWood", PVJBlocks.mangrove_stairs);
		OreDictionary.registerOre("stairWood", PVJBlocks.palm_stairs);
		OreDictionary.registerOre("stairWood", PVJBlocks.redwood_stairs);
		
		OreDictionary.registerOre("fenceWood", PVJBlocks.willow_fence);
		OreDictionary.registerOre("fenceWood", PVJBlocks.mangrove_fence);
		OreDictionary.registerOre("fenceWood", PVJBlocks.palm_fence);
		OreDictionary.registerOre("fenceWood", PVJBlocks.redwood_fence);
		
		OreDictionary.registerOre("fenceGateWood", PVJBlocks.willow_fence_gate);
		OreDictionary.registerOre("fenceGateWood", PVJBlocks.mangrove_fence_gate);
		OreDictionary.registerOre("fenceGateWood", PVJBlocks.palm_fence_gate);
		OreDictionary.registerOre("fenceGateWood", PVJBlocks.redwood_fence_gate);
		
		OreDictionary.registerOre("cobblestone", PVJBlocks.cobblestone_brick);
		
		//mod defined ore names
		OreDictionary.registerOre("twigs", PVJBlocks.acacia_twigs);
		OreDictionary.registerOre("twigs", PVJBlocks.birch_twigs);
		OreDictionary.registerOre("twigs", PVJBlocks.dark_oak_twigs);
		OreDictionary.registerOre("twigs", PVJBlocks.spruce_twigs);
		OreDictionary.registerOre("twigs", PVJBlocks.oak_twigs);
		OreDictionary.registerOre("twigs", PVJBlocks.jungle_twigs);
		OreDictionary.registerOre("twigs", PVJBlocks.willow_twigs);
		OreDictionary.registerOre("twigs", PVJBlocks.mangrove_twigs);
		OreDictionary.registerOre("twigs", PVJBlocks.palm_twigs);
		OreDictionary.registerOre("twigs", PVJBlocks.redwood_twigs);
	}
}
