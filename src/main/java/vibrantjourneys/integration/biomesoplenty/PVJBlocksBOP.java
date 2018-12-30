package vibrantjourneys.integration.biomesoplenty;

import java.util.ArrayList;

import biomesoplenty.api.enums.BOPTrees;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;
import vibrantjourneys.blocks.BlockFallenLeaves;
import vibrantjourneys.blocks.BlockGroundCover;
import vibrantjourneys.blocks.BlockGroundCover.GroundcoverType;
import vibrantjourneys.init.PVJBlocks;

public class PVJBlocksBOP
{
	public static final ArrayList<Block> FALLENLEAVES_BOP = new ArrayList<Block>();
	public static final ArrayList<Block> TWIGS_BOP = new ArrayList<Block>();
	public static final ArrayList<BOPBlockInfo> BLOCK_INFO_FALLENLEAVES = new ArrayList<BOPBlockInfo>();
	public static final ArrayList<BOPBlockInfo> BLOCK_INFO_TWIGS = new ArrayList<BOPBlockInfo>();
	
	public static void initBOPBlocks()
	{
		//do not combine these loops or the creative tab will be ugly
		for(BOPTrees trees : BOPTrees.values())
		{
			String name = trees.getName();
			Block block = PVJBlocks.registerBlock(new BlockFallenLeaves(), "fallenleaves_bop_" + name);
			FALLENLEAVES_BOP.add(block);
			BLOCK_INFO_FALLENLEAVES.add(new BOPBlockInfo(block, PVJWorldGenBOP.getDensityFallenLeaves(name), BiomeReferenceBOP.getBiomeReference(name)));
		}
		for(BOPTrees trees : BOPTrees.values())
		{
			String name = trees.getName();
			Block block = PVJBlocks.registerBlock(new BlockGroundCover(Material.PLANTS, GroundcoverType.TWIGS), name + "_bop_twigs");
			TWIGS_BOP.add(block);
		}
	}
	
	public static void setOreDictValues()
	{
		for(Block twig : TWIGS_BOP)
			OreDictionary.registerOre("twigs", twig);
	}
}
