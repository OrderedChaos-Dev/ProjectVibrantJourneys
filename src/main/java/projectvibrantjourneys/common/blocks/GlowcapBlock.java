package projectvibrantjourneys.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MushroomBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.server.ServerWorld;
import projectvibrantjourneys.common.world.FeatureManager;

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
	      world.removeBlock(pos, false);
		ConfiguredFeature<BigMushroomFeatureConfig, ?> configuredfeature;
		configuredfeature = Feature.HUGE_RED_MUSHROOM.func_225566_b_(FeatureManager.glowcapFeatureConfig);

		if (configuredfeature.place(world, world.getChunkProvider().getChunkGenerator(), rand, pos)) {
			return true;
		} else {
			world.setBlockState(pos, state, 3);
			return false;
		}
	}
	
	@Override
	public void func_225535_a_(ServerWorld p_225535_1_, Random p_225535_2_, BlockPos p_225535_3_, BlockState p_225535_4_) {
		this.func_226940_a_(p_225535_1_, p_225535_3_, p_225535_4_, p_225535_2_);
	}
}
