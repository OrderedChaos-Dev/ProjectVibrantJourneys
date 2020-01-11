package projectvibrantjourneys.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.Tree;

public class PVJSaplingBlock extends SaplingBlock {

	public PVJSaplingBlock(Tree tree) {
		super(tree, Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0, 0)
				.sound(SoundType.PLANT));
	}

}
