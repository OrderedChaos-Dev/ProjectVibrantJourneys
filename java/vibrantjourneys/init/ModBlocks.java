package vibrantjourneys.init;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import vibrantjourneys.ProjectVibrantJourneys;
import vibrantjourneys.blocks.BlockCobblestoneBrick;
import vibrantjourneys.blocks.BlockPVJLog;
import vibrantjourneys.blocks.BlockPVJPlanks;
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
		cobblestone_brick = registerBlock(new BlockCobblestoneBrick(), "cobblestone_brick");
		pvj_planks = registerBlockWithVariants(new BlockPVJPlanks(), "pvj_planks");
		pvj_log = registerBlockWithVariants(new BlockPVJLog(), "pvj_log");
	}
	
	private static Block registerBlock(Block block, String name)
	{
		block.setUnlocalizedName(name);
		block.setCreativeTab(CreativeTabPVJ.instance);
		
		block.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		ForgeRegistries.BLOCKS.register(block);
		
		Item itemBlock = new ItemPVJBlock(block);
		itemBlock.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		ForgeRegistries.ITEMS.register(itemBlock);
		
		return block;
	}
	
	private static Block registerBlockWithVariants(Block block, String name)
	{
		registerBlock(block, name);
		IPVJBlock PVJblock = (IPVJBlock)block;
		
		ImmutableList<IBlockState> variants = PVJblock.getVariants();
		
		for(IBlockState state : variants)
		{
			String variantName = PVJblock.getStateName(state);
			int meta = block.getMetaFromState(state);
			Item itemBlock = new ItemPVJBlock(block);
			ProjectVibrantJourneys.proxy.registerItemVariantRenderer(itemBlock, variantName, meta);
		}
		
		return block;
	}
}
