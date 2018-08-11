package vibrantjourneys.integration.biomesoplenty;

import java.util.ArrayList;

import biomesoplenty.api.enums.BOPTrees;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import vibrantjourneys.blocks.BlockFallenLeaves;
import vibrantjourneys.blocks.BlockGroundLitter;
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
			BLOCK_INFO_FALLENLEAVES.add(new BOPBlockInfo(block, PVJWorldGenerationBOP.getDensityFallenLeaves(name), BiomeReferenceBOP.getBiomeReference(name)));
		}
		for(BOPTrees trees : BOPTrees.values())
		{
			String name = trees.getName();
			Block block = PVJBlocks.registerBlock(new BlockGroundLitter(Material.PLANTS), name + "_bop_twigs");
			TWIGS_BOP.add(block);
			BLOCK_INFO_TWIGS.add(new BOPBlockInfo(block, PVJWorldGenerationBOP.getDensityTwigs(name), BiomeReferenceBOP.getBiomeReference(name)));
		}
	}
}
