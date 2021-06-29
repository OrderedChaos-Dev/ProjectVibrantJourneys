package projectvibrantjourneys.common.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.GravelBlock;
import net.minecraft.block.SandBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class SandySaplingBlock extends SaplingBlock {

	public SandySaplingBlock(Tree tree, Properties props) {
		super(tree, props);
	}

	@Override
	protected boolean mayPlaceOn(BlockState state, IBlockReader world, BlockPos pos) {
		return super.mayPlaceOn(state, world, pos) || state.getBlock() instanceof SandBlock || state.getBlock() instanceof GravelBlock;
	}
}
