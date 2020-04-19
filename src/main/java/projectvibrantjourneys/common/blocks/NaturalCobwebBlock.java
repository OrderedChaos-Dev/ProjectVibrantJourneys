package projectvibrantjourneys.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.WebBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class NaturalCobwebBlock extends WebBlock {

	public NaturalCobwebBlock() {
		super(Block.Properties.from(Blocks.COBWEB));
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {
		for(Direction d : Direction.values()) {
			if(world.getBlockState(pos.offset(d)).getBlock() instanceof LeavesBlock) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void neighborChanged(BlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		if(!isValidPosition(state, world, pos))
			world.removeBlock(pos, isMoving);
	}
}
