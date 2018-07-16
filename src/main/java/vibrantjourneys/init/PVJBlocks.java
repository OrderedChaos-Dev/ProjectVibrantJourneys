package vibrantjourneys.init;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import vibrantjourneys.ProjectVibrantJourneys;
import vibrantjourneys.blocks.BlockCobblestoneBrick;
import vibrantjourneys.blocks.BlockCoconut;
import vibrantjourneys.blocks.BlockPVJLeaves;
import vibrantjourneys.blocks.BlockPVJLog;
import vibrantjourneys.blocks.BlockPVJPlanks;
import vibrantjourneys.blocks.BlockPVJSapling;
import vibrantjourneys.items.ItemPVJBlock;
import vibrantjourneys.util.CreativeTabPVJ;
import vibrantjourneys.util.EnumWoodType;
import vibrantjourneys.util.IPVJBlock;
import vibrantjourneys.util.Reference;

public class PVJBlocks
{
	public static Block cobblestone_brick;
	
	//THE FLATTENING..DUN DUN DUNNN
	public static Block willow_planks;
	public static Block mangrove_planks;
	public static Block palm_planks;
	public static Block redwood_planks;
	
	//1.13: add bark
	public static Block willow_log;
	public static Block mangrove_log;
	public static Block palm_log;
	public static Block redwood_log;
	
	public static Block willow_leaves;
	public static Block mangrove_leaves;
	public static Block palm_leaves;
	public static Block redwood_leaves;
	
	//1.13: mangrove saplings can be waterlogged
	public static Block willow_sapling;
	public static Block mangrove_sapling;
	public static Block palm_sapling;
	public static Block redwood_sapling;
	
	public static Block coconut;
	
	public static void initBlocks()
	{
		cobblestone_brick = registerBlock(new BlockCobblestoneBrick(), "cobblestone_brick", false);
		
		willow_planks = registerBlock(new BlockPVJPlanks(EnumWoodType.WILLOW), "planks_willow", false);
		mangrove_planks = registerBlock(new BlockPVJPlanks(EnumWoodType.MANGROVE), "planks_mangrove", false);
		palm_planks = registerBlock(new BlockPVJPlanks(EnumWoodType.PALM), "planks_palm", false);
		redwood_planks = registerBlock(new BlockPVJPlanks(EnumWoodType.REDWOOD), "planks_redwood", false);
		
		willow_log = registerBlockWithVariants(new BlockPVJLog(EnumWoodType.WILLOW), "log_willow");
		mangrove_log = registerBlockWithVariants(new BlockPVJLog(EnumWoodType.MANGROVE), "log_mangrove");
		palm_log = registerBlockWithVariants(new BlockPVJLog(EnumWoodType.PALM), "log_palm");
		redwood_log = registerBlockWithVariants(new BlockPVJLog(EnumWoodType.REDWOOD), "log_redwood");
		
		willow_leaves = registerBlockWithVariants(new BlockPVJLeaves(EnumWoodType.WILLOW), "leaves_willow");
		mangrove_leaves = registerBlockWithVariants(new BlockPVJLeaves(EnumWoodType.MANGROVE), "leaves_mangrove");
		palm_leaves = registerBlockWithVariants(new BlockPVJLeaves(EnumWoodType.PALM), "leaves_palm");
		redwood_leaves = registerBlockWithVariants(new BlockPVJLeaves(EnumWoodType.REDWOOD), "leaves_redwood");
		
		willow_sapling = registerBlockWithVariants(new BlockPVJSapling(EnumWoodType.WILLOW), "sapling_willow");
		mangrove_sapling = registerBlockWithVariants(new BlockPVJSapling(EnumWoodType.MANGROVE), "sapling_mangrove");
		palm_sapling = registerBlockWithVariants(new BlockPVJSapling(EnumWoodType.PALM), "sapling_palm");
		redwood_sapling = registerBlockWithVariants(new BlockPVJSapling(EnumWoodType.REDWOOD), "sapling_redwood");
		
		coconut = registerBlock(new BlockCoconut(), "coconut", false);
	}
	
	private static Block registerBlock(Block block, String name, boolean hasVariants)
	{
		block.setUnlocalizedName(name);
		block.setCreativeTab(CreativeTabPVJ.instance);
		
		block.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		ForgeRegistries.BLOCKS.register(block);
		
		Item itemBlock = new ItemPVJBlock(block);
		itemBlock.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		ForgeRegistries.ITEMS.register(itemBlock);
		
		if(!hasVariants)
			ProjectVibrantJourneys.proxy.registerItemRenderer(Item.getItemFromBlock(block), name);
		
		return block;
	}
	
	private static Block registerBlockWithVariants(Block block, String name)
	{
		registerBlock(block, name, true);
		IPVJBlock PVJblock = (IPVJBlock)block;
		
		ImmutableList<IBlockState> variants = PVJblock.getVariants();
		
		for(IBlockState state : variants)
		{
			int meta = block.getMetaFromState(state);
			ModelResourceLocation resource = new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, name), "inventory");
			ProjectVibrantJourneys.proxy.registerItemVariantRenderer(Item.getItemFromBlock(block), meta, resource);
		}
		
		return block;
	}
}
