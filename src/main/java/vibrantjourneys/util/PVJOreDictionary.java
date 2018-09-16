package vibrantjourneys.util;

import net.minecraftforge.oredict.OreDictionary;
import vibrantjourneys.init.PVJBlocks;

public class PVJOreDictionary
{
	public static void setValues()
	{	
		for(EnumWoodType woodType : EnumWoodType.values())
		{
			OreDictionary.registerOre("logWood", PVJBlocks.LOGS.get(woodType.getID()));
			OreDictionary.registerOre("plankWood", PVJBlocks.PLANKS.get(woodType.getID()));
			OreDictionary.registerOre("slabWood", PVJBlocks.SLABS.get(woodType.getID()));
			OreDictionary.registerOre("stairWood", PVJBlocks.STAIRS.get(woodType.getID()));
			OreDictionary.registerOre("fenceWood", PVJBlocks.FENCES.get(woodType.getID()));
			OreDictionary.registerOre("fenceGateWood", PVJBlocks.FENCE_GATES.get(woodType.getID()));
		}
		
		for(EnumLeafType leafType : EnumLeafType.values())
		{
			OreDictionary.registerOre("treeSapling", PVJBlocks.SAPLINGS.get(leafType.getID()));
			OreDictionary.registerOre("treeLeaves", PVJBlocks.LEAVES.get(leafType.getID()));
			OreDictionary.registerOre("twigs", PVJBlocks.TWIGS.get(leafType.getID()));
		}
		OreDictionary.registerOre("twigs", PVJBlocks.acacia_twigs);
		OreDictionary.registerOre("twigs", PVJBlocks.birch_twigs);
		OreDictionary.registerOre("twigs", PVJBlocks.dark_oak_twigs);
		OreDictionary.registerOre("twigs", PVJBlocks.spruce_twigs);
		OreDictionary.registerOre("twigs", PVJBlocks.oak_twigs);
		OreDictionary.registerOre("twigs", PVJBlocks.jungle_twigs);
		
		OreDictionary.registerOre("rocks", PVJBlocks.andesite_rocks);
		OreDictionary.registerOre("rocks", PVJBlocks.diorite_rocks);
		OreDictionary.registerOre("rocks", PVJBlocks.granite_rocks);
		OreDictionary.registerOre("rocks", PVJBlocks.stone_rocks);
		OreDictionary.registerOre("rocks", PVJBlocks.cobblestone_rocks);
		OreDictionary.registerOre("rocks", PVJBlocks.sandstone_rocks);
		OreDictionary.registerOre("rocks", PVJBlocks.red_sandstone_rocks);
		OreDictionary.registerOre("rocks", PVJBlocks.mossy_cobblestone_rocks);
	}
}
