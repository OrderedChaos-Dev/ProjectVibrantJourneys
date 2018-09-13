package vibrantjourneys.integration.biomesoplenty;

import biomesoplenty.api.enums.BOPTrees;
import biomesoplenty.common.block.BlockBOPLeaves;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
import vibrantjourneys.ProjectVibrantJourneys;

public class PVJRenderingHandlerBOP
{
	public static void registerBOPColors()
	{
		int index = 0;
		for(Block block : PVJBlocksBOP.FALLENLEAVES_BOP)
		{
			if(BlockBOPLeaves.getColoringType(BOPTrees.values()[index]) == BlockBOPLeaves.ColoringType.TINTED
					|| BlockBOPLeaves.getColoringType(BOPTrees.values()[index]) == BlockBOPLeaves.ColoringType.OVERLAY)
			{
				IBlockState state = BlockBOPLeaves.paging.getVariantState(BOPTrees.values()[index]);
				registerFallenLeavesColors(block, state, -1);
			}
			index++;
		}
		
		index = 0;
		for(Block block : PVJBlocksBOP.TWIGS_BOP)
		{
			if(BlockBOPLeaves.getColoringType(BOPTrees.values()[index]) == BlockBOPLeaves.ColoringType.TINTED
					|| BlockBOPLeaves.getColoringType(BOPTrees.values()[index]) == BlockBOPLeaves.ColoringType.OVERLAY)
			{
				IBlockState state = BlockBOPLeaves.paging.getVariantState(BOPTrees.values()[index]);
				registerFallenLeavesColors(block, state, -1);
			}
			index++;
		}
	}
	
    public static void registerFallenLeavesColors(Block leafBlock, IBlockState leafState, int color)
    {
    	BlockColors blockColors = Minecraft.getMinecraft().getBlockColors();
    	
    	IBlockColor blockColor = new IBlockColor(){

			@Override
			public int colorMultiplier(IBlockState state, IBlockAccess world, BlockPos pos, int tintIndex)
			{
				if(world != null && pos != null)
					return BiomeColorHelper.getFoliageColorAtPos(world, pos);
				else
					return ColorizerFoliage.getFoliageColorBasic();
			}
    	};
    	
    	//set color to -1 to use the biome foliage color
    	if(color == -1)
    		ProjectVibrantJourneys.proxy.registerBlockColor(blockColor, leafBlock);
    	else
    		ProjectVibrantJourneys.proxy.registerBlockColor((state, world, pos, tintindex) -> color, leafBlock);
    	
    	ProjectVibrantJourneys.proxy.registerItemColor((stack, tintindex) -> blockColors.colorMultiplier(leafState, null, null, tintindex), 
		Item.getItemFromBlock(leafBlock));
    }
}
