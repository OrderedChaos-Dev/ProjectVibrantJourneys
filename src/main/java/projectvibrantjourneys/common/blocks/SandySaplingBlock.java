package projectvibrantjourneys.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.GravelBlock;
import net.minecraft.world.level.block.SandBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;

public class SandySaplingBlock extends SaplingBlock {

	public SandySaplingBlock(AbstractTreeGrower tree, Properties props) {
		super(tree, props);
	}

	@Override
	protected boolean mayPlaceOn(BlockState state, BlockGetter world, BlockPos pos) {
		return super.mayPlaceOn(state, world, pos) || state.getBlock() instanceof SandBlock || state.getBlock() instanceof GravelBlock;
	}
}
