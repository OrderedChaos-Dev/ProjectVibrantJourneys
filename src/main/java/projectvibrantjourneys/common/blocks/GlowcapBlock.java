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
	public boolean grow(ServerWorld world, BlockPos pos, BlockState state, Random rand) {
		world.removeBlock(pos, false);
		ConfiguredFeature<BigMushroomFeatureConfig, ?> configuredfeature;
		configuredfeature = Feature.HUGE_RED_MUSHROOM.withConfiguration(FeatureManager.glowcapFeatureConfig);

		if (configuredfeature.place(world, world.getChunkProvider().getChunkGenerator(), rand, pos)) {
			return true;
		} else {
			world.setBlockState(pos, state, 3);
			return false;
		}
	}
	
	@Override
	public void grow(ServerWorld world, Random rand, BlockPos pos, BlockState state) {
		this.grow(world, pos, state, rand);
	}
}
