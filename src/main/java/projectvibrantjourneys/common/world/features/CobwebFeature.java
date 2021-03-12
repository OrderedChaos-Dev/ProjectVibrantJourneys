package projectvibrantjourneys.common.world.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import projectvibrantjourneys.init.PVJBlocks;

public class CobwebFeature extends Feature<ProbabilityConfig> {
	public CobwebFeature(Codec<ProbabilityConfig> codec) {
		super(codec);
	}

	@Override
	public boolean generate(ISeedReader world, ChunkGenerator chunkGen, Random rand, BlockPos pos, ProbabilityConfig config) {
		BlockPos.Mutable blockpos = new BlockPos.Mutable(pos.getX(), pos.getY(), pos.getZ());

		for (int i = 64; i < world.getHeight(); i++) {
			blockpos.setPos(pos);
			blockpos.move(rand.nextInt(4) - rand.nextInt(4), 0, rand.nextInt(4) - rand.nextInt(4));
			blockpos.setY(i);
			if (world.getBlockState(blockpos).getBlock() instanceof LeavesBlock) {
				if(world.isAirBlock(blockpos.down())) {
					if(rand.nextFloat() < config.probability) {
						world.setBlockState(blockpos.down(), PVJBlocks.natural_cobweb.getDefaultState(), 2);
						break;
					}
				}
			}
		}
		return true;
	}
}