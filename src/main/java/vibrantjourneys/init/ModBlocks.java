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
import vibrantjourneys.blocks.BlockPVJLeaves;
import vibrantjourneys.blocks.BlockPVJLog;
import vibrantjourneys.blocks.BlockPVJPlanks;
import vibrantjourneys.blocks.BlockPVJSapling;
import vibrantjourneys.items.ItemPVJBlock;
import vibrantjourneys.util.CreativeTabPVJ;
import vibrantjourneys.util.IPVJBlock;
import vibrantjourneys.util.Reference;

public class ModBlocks
{
	public static Block cobblestone_brick;
	public static Block pvj_planks;
	public static Block pvj_log;
	public static Block pvj_leaves;
	public static Block pvj_sapling;
	
	public static void initBlocks()
	{
		cobblestone_brick = registerBlock(new BlockCobblestoneBrick(), "cobblestone_brick", false);
		pvj_planks = registerBlockWithVariants(new BlockPVJPlanks(), "planks");
		pvj_log = registerBlockWithVariants(new BlockPVJLog(), "log");
		pvj_leaves = registerBlockWithVariants(new BlockPVJLeaves(), "leaves");
		pvj_sapling = registerBlockWithVariants(new BlockPVJSapling(), "sapling");
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
			String variantName = PVJblock.getStateName(state);
			int meta = block.getMetaFromState(state);
			ModelResourceLocation resource = new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, name + "_" + variantName), "inventory");
			ProjectVibrantJourneys.proxy.registerItemVariantRenderer(Item.getItemFromBlock(block), meta, resource);
		}
		
		return block;
	}
}
