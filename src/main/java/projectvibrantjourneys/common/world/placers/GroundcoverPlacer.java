package projectvibrantjourneys.common.world.placers;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.blockplacer.BlockPlacer;
import net.minecraft.world.gen.blockplacer.BlockPlacerType;
import projectvibrantjourneys.common.blocks.FallenLeavesBlock;
import projectvibrantjourneys.common.blocks.GroundcoverBlock;

public class GroundcoverPlacer extends BlockPlacer {

	@Override
	public void place(IWorld world, BlockPos pos, BlockState state, Random rand) {
		if (world.getBlockState(pos.down()).isOpaqueCube(world, pos) && world.getBlockState(pos.down()).isSolid()) {
			if (state.getBlock() instanceof FallenLeavesBlock) {
				world.setBlockState(pos, state, 2);
			} else {
				world.setBlockState(pos, state.with(GroundcoverBlock.MODEL, rand.nextInt(5)), 2);
			}
		}
	}

	@Override
	protected BlockPlacerType<?> getBlockPlacerType() {
		return BlockPlacerType.SIMPLE_BLOCK;
	}
}