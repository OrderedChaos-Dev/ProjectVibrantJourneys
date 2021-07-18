package projectvibrantjourneys.common.world.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class BushFeature extends Feature<ProbabilityConfig> {
	
	public BushFeature(Codec<ProbabilityConfig> config) {
		super(config);
	}

	@Override
	public boolean place(ISeedReader world, ChunkGenerator chunkGen, Random rand, BlockPos pos, ProbabilityConfig config) {
		//check dirt/grass
		Block dirt = world.getBlockState(pos.below()).getBlock();
		if(dirt != Blocks.DIRT && dirt != Blocks.GRASS_BLOCK)
			return false;
		
		//check space
		for(Direction dir : Direction.Plane.HORIZONTAL) {
			BlockPos offsetPos = pos.offset(dir.getNormal());
			Block block = world.getBlockState(offsetPos).getBlock();
			if(block != Blocks.AIR && block != Blocks.TALL_GRASS) {
				return false;
			}
		}
		if (rand.nextFloat() < config.probability) {
			for(Direction dir : Direction.Plane.HORIZONTAL) {
				BlockPos offsetPos = pos.offset(dir.getNormal());
				if(world.isStateAtPosition(offsetPos, (state) -> state.getMaterial().isReplaceable()));
					world.setBlock(offsetPos, Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
			}
			if(world.isStateAtPosition(pos.above(), (state) -> state.getMaterial().isReplaceable()));
				world.setBlock(pos.above(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
			world.setBlock(pos, Blocks.OAK_LOG.defaultBlockState(), 2);
		}

		return true;
	}
}
