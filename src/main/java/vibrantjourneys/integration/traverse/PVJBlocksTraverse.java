package vibrantjourneys.integration.traverse;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;
import vibrantjourneys.blocks.BlockFallenLeaves;
import vibrantjourneys.blocks.BlockGroundCover;
import vibrantjourneys.blocks.BlockGroundCover.GroundcoverType;
import vibrantjourneys.init.PVJBlocks;

public class PVJBlocksTraverse
{
	public static Block red_autumn_twigs;
	public static Block brown_autumn_twigs;
	public static Block orange_autumn_twigs;
	public static Block yellow_autumn_twigs;
	public static Block fir_twigs;
	
	public static Block red_autumn_fallen_leaves;
	public static Block brown_autumn_fallen_leaves;
	public static Block orange_autumn_fallen_leaves;
	public static Block yellow_autumn_fallen_leaves;
	public static Block fir_fallen_leaves;
	
	public static void initTraverseBlocks()
	{
		red_autumn_twigs = PVJBlocks.registerBlock(new BlockGroundCover(Material.PLANTS, GroundcoverType.TWIGS), "red_autumn_traverse_twigs");
		brown_autumn_twigs = PVJBlocks.registerBlock(new BlockGroundCover(Material.PLANTS, GroundcoverType.TWIGS), "brown_autumn_traverse_twigs");
		orange_autumn_twigs = PVJBlocks.registerBlock(new BlockGroundCover(Material.PLANTS, GroundcoverType.TWIGS), "orange_autumn_traverse_twigs");
		yellow_autumn_twigs = PVJBlocks.registerBlock(new BlockGroundCover(Material.PLANTS, GroundcoverType.TWIGS), "yellow_autumn_traverse_twigs");
		fir_twigs = PVJBlocks.registerBlock(new BlockGroundCover(Material.PLANTS, GroundcoverType.TWIGS), "fir_traverse_twigs");
		
		red_autumn_fallen_leaves = PVJBlocks.registerBlock(new BlockFallenLeaves(), "fallenleaves_traverse_red_autumn");
		brown_autumn_fallen_leaves = PVJBlocks.registerBlock(new BlockFallenLeaves(), "fallenleaves_traverse_brown_autumn");
		orange_autumn_fallen_leaves = PVJBlocks.registerBlock(new BlockFallenLeaves(), "fallenleaves_traverse_orange_autumn");
		yellow_autumn_fallen_leaves = PVJBlocks.registerBlock(new BlockFallenLeaves(), "fallenleaves_traverse_yellow_autumn");
		fir_fallen_leaves = PVJBlocks.registerBlock(new BlockFallenLeaves(), "fallenleaves_traverse_fir");
	}
	
	public static void setOreDictValues()
	{
		OreDictionary.registerOre("twigs", red_autumn_twigs);
		OreDictionary.registerOre("twigs", orange_autumn_twigs);
		OreDictionary.registerOre("twigs", brown_autumn_twigs);
		OreDictionary.registerOre("twigs", yellow_autumn_twigs);
		OreDictionary.registerOre("twigs", fir_twigs);
	}
}
