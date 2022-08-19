package com.projectvibrantjourneys.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.WebBlock;
import net.minecraft.world.level.block.state.BlockState;

/**
 * 
 * Mimic vanilla block but make it destroy itself when not adjacent to any leaves
 * to prevent odd floating cobwebs when trees are cut down
 *
 */
public class NaturalCobwebBlock extends WebBlock {

	public NaturalCobwebBlock() {
		super(Block.Properties.copy(Blocks.COBWEB));
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		for(Direction d : Direction.values()) {
			if(world.getBlockState(pos.offset(d.getNormal())).getBlock() instanceof LeavesBlock) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void neighborChanged(BlockState state, Level world, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		if(!canSurvive(state, world, pos))
			world.removeBlock(pos, isMoving);
	}
}