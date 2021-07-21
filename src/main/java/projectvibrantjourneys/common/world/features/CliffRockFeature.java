package projectvibrantjourneys.common.world.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class CliffRockFeature extends Feature<ProbabilityConfig> {
	
	private Block[] bottom = {Blocks.STONE, Blocks.COBBLESTONE, Blocks.MOSSY_COBBLESTONE, Blocks.ANDESITE};
	private Block[] top = {Blocks.COBBLESTONE_WALL, Blocks.MOSSY_COBBLESTONE_WALL, Blocks.ANDESITE_WALL};
	
	public CliffRockFeature(Codec<ProbabilityConfig> config) {
		super(config);
	}

	@Override
	public boolean place(ISeedReader world, ChunkGenerator chunkGen, Random rand, BlockPos pos, ProbabilityConfig config) {
		if (rand.nextFloat() < config.probability) {
			if(world.getBlockState(pos).getMaterial().isReplaceable() && world.getBlockState(pos.above()).getMaterial().isReplaceable()) {
				world.setBlock(pos, bottom[rand.nextInt(bottom.length)].defaultBlockState(), 2);
				world.setBlock(pos.above(), top[rand.nextInt(top.length)].defaultBlockState(), 2);
				if(rand.nextBoolean() && world.getBlockState(pos.above(2)).getMaterial().isReplaceable()) {
					world.setBlock(pos.above(2), top[rand.nextInt(top.length)].defaultBlockState(), 2);
				}
				return true;
			}
		}
		
		return false;
	}
}
