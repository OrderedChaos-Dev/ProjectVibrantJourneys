package vibrantjourneys.init;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import vibrantjourneys.crafting.FurnaceFuelHandler;
import vibrantjourneys.integration.biomesoplenty.BOPCrafting;
import vibrantjourneys.integration.biomesoplenty.PVJBlocksBOP;
import vibrantjourneys.integration.traverse.PVJBlocksTraverse;
import vibrantjourneys.integration.traverse.TraverseCrafting;
import vibrantjourneys.util.EnumLeafType;
import vibrantjourneys.util.EnumWoodType;
import vibrantjourneys.util.Reference;

public class PVJCrafting
{
	public static FurnaceFuelHandler fuelHandler = new FurnaceFuelHandler();
	
	public static void initCrafting()
	{
		for(EnumWoodType woodType: EnumWoodType.values())
		{
			GameRegistry.addSmelting(PVJBlocks.LOGS.get(woodType.getID()), new ItemStack(Items.COAL, 1, 1), 0.15F);
		}
		
		GameRegistry.addSmelting(PVJBlocks.small_cactus, new ItemStack(Items.DYE, 1, EnumDyeColor.GREEN.getDyeDamage()), 0.2F);
		GameRegistry.addSmelting(PVJItems.raw_squid, new ItemStack(PVJItems.cooked_squid, 1), 0.35F);
		GameRegistry.addSmelting(PVJItems.raw_duck, new ItemStack(PVJItems.cooked_duck, 1), 0.35F);
		GameRegistry.addSmelting(PVJItems.clam, new ItemStack(PVJItems.steamed_clam, 1), 0.35F);
		
		for(Block sapling : PVJBlocks.SAPLINGS)
		{
			fuelHandler.addFuel(sapling, 100);
		}
		fuelHandler.addFuel(PVJBlocks.fallenleaves_oak, 100);
		fuelHandler.addFuel(PVJBlocks.fallenleaves_birch, 100);
		fuelHandler.addFuel(PVJBlocks.fallenleaves_spruce, 100);
		fuelHandler.addFuel(PVJBlocks.fallenleaves_jungle, 100);
		fuelHandler.addFuel(PVJBlocks.fallenleaves_darkoak, 100);
		fuelHandler.addFuel(PVJBlocks.fallenleaves_acacia, 100);
		fuelHandler.addFuel(PVJBlocks.fallenleaves_dead, 100);
		fuelHandler.addFuel(PVJBlocks.oak_twigs, 100);
		fuelHandler.addFuel(PVJBlocks.birch_twigs, 100);
		fuelHandler.addFuel(PVJBlocks.spruce_twigs, 100);
		fuelHandler.addFuel(PVJBlocks.jungle_twigs, 100);
		fuelHandler.addFuel(PVJBlocks.dark_oak_twigs, 100);
		fuelHandler.addFuel(PVJBlocks.acacia_twigs, 100);
		fuelHandler.addFuel(PVJBlocks.pinecones, 100);
		for(Block twigs : PVJBlocks.TWIGS)
		{
			fuelHandler.addFuel(twigs, 100);
		}
		for(Block fallenleaves : PVJBlocks.FALLEN_LEAVES)
		{
			fuelHandler.addFuel(fallenleaves, 100);
		}
		for(Item boat : PVJItems.BOATS)
		{
			fuelHandler.addFuel(boat, 200);
		}
		
		if(Reference.isBOPLoaded)
			BOPCrafting.initCrafting();
		
		if(Reference.isTraverseLoaded)
			TraverseCrafting.initCrafting();
		
		MinecraftForge.EVENT_BUS.register(fuelHandler);
		
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
		
		OreDictionary.registerOre("cactus", PVJBlocks.small_cactus);
		OreDictionary.registerOre("cactus", Blocks.CACTUS);
		
		if(Reference.isBOPLoaded)
			PVJBlocksBOP.setOreDictValues();
		
		if(Reference.isTraverseLoaded)
			PVJBlocksTraverse.setOreDictValues();
	}
}
