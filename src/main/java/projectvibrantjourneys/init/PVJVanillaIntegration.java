package projectvibrantjourneys.init;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.util.IItemProvider;

public class PVJVanillaIntegration {
	
	public static void init() {
		setFlameInfo(PVJBlocks.oak_twigs, 5, 15);
		setFlameInfo(PVJBlocks.birch_twigs, 5, 15);
		setFlameInfo(PVJBlocks.spruce_twigs, 5, 15);
		setFlameInfo(PVJBlocks.jungle_twigs, 5, 15);
		setFlameInfo(PVJBlocks.dark_oak_twigs, 5, 15);
		setFlameInfo(PVJBlocks.acacia_twigs, 5, 15);
		setFlameInfo(PVJBlocks.oak_fallen_leaves, 30, 60);
		setFlameInfo(PVJBlocks.birch_fallen_leaves, 30, 60);
		setFlameInfo(PVJBlocks.spruce_fallen_leaves, 30, 60);
		setFlameInfo(PVJBlocks.jungle_fallen_leaves, 30, 60);
		setFlameInfo(PVJBlocks.dark_oak_fallen_leaves, 30, 60);
		setFlameInfo(PVJBlocks.acacia_fallen_leaves, 30, 60);
		setFlameInfo(PVJBlocks.pinecones, 5, 20);
		
		setCompostInfo(PVJBlocks.oak_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.birch_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.spruce_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.jungle_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.dark_oak_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.acacia_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.pinecones, 0.1F);
		setCompostInfo(PVJBlocks.dung, 1.0F);
	}

	public static void setFlameInfo(Block block, int encouragement, int flammability) {
		((FireBlock)Blocks.FIRE).setFireInfo(block, encouragement, flammability);
	}
	
	public static void setCompostInfo(IItemProvider item, float chance) {
		ComposterBlock.CHANCES.put(item.asItem(), chance);
	}
}
