package projectvibrantjourneys.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MushroomBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class GlowcapBlock extends MushroomBlock {

	public GlowcapBlock() {
		super(Block.Properties.from(Blocks.BROWN_MUSHROOM).lightValue(10));
	}
	
	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.down();
		BlockState blockstate = worldIn.getBlockState(blockpos);
		Block block = blockstate.getBlock();
		if (block != Blocks.MYCELIUM && block != Blocks.PODZOL && block != Blocks.NETHERRACK && block != Blocks.SOUL_SAND) {
			return blockstate.canSustainPlant(worldIn, blockpos, net.minecraft.util.Direction.UP, this);
		} else {
			return true;
		}
	}
	
	@Override
	public boolean func_226940_a_(ServerWorld world, BlockPos pos, BlockState state, Random rand) {
		return false;
	}
	
	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return false;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return false;
	}
}
