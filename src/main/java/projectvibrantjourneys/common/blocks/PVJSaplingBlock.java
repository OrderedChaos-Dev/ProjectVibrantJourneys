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

public class PVJSaplingBlock extends SaplingBlock {
	
	private static final Block[] TERRACOTTA_BLOCKS = {
			Blocks.TERRACOTTA,
			Blocks.BLACK_TERRACOTTA,
			Blocks.BLUE_TERRACOTTA,
			Blocks.BROWN_TERRACOTTA,
			Blocks.CYAN_TERRACOTTA,
			Blocks.GRAY_TERRACOTTA,
			Blocks.GREEN_TERRACOTTA,
			Blocks.LIGHT_BLUE_TERRACOTTA,
			Blocks.LIGHT_GRAY_TERRACOTTA,
			Blocks.LIME_TERRACOTTA,
			Blocks.MAGENTA_TERRACOTTA,
			Blocks.ORANGE_TERRACOTTA,
			Blocks.PINK_TERRACOTTA,
			Blocks.PURPLE_TERRACOTTA,
			Blocks.RED_TERRACOTTA,
			Blocks.WHITE_TERRACOTTA,
			Blocks.YELLOW_TERRACOTTA
	};

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
			return state.getBlock() instanceof SandBlock;
		} else if (this == PVJBlocks.juniper_sapling) {
			return state.getBlock() instanceof SandBlock || Arrays.asList(TERRACOTTA_BLOCKS).contains(state.getBlock());
		}
		return flag;
	}
}
