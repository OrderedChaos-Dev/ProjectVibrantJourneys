package projectvibrantjourneys.common.blocks;

import java.util.Arrays;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SandBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import projectvibrantjourneys.init.PVJBlocks;
import projectvibrantjourneys.init.PVJTags;

public class PVJSaplingBlock extends SaplingBlock {
	
	public PVJSaplingBlock(Tree tree) {
		super(tree, Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0, 0)
				.sound(SoundType.PLANT));
	}

	@Override
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		boolean flag = super.isValidGround(state, worldIn, pos);
		
		if(this == PVJBlocks.palm_sapling || this == PVJBlocks.mangrove_sapling) {
			return state.isIn(PVJTags.TROPICAL_SAPLING_PLANTABLE);
		} else if (this == PVJBlocks.juniper_sapling) {
			return state.isIn(PVJTags.JUNIPER_SAPLING_PLANTABLE);
		}
		return flag;
	}
}
