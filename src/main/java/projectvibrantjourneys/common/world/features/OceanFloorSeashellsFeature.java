package projectvibrantjourneys.common.world.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import projectvibrantjourneys.common.blocks.GroundcoverBlock;
import projectvibrantjourneys.init.PVJBlocks;

public class OceanFloorSeashellsFeature extends Feature<ProbabilityConfig> {
	public OceanFloorSeashellsFeature(Codec<ProbabilityConfig> config) {
		super(config);
	}

	@Override
	public boolean generate(ISeedReader world, ChunkGenerator chunkGen, Random rand, BlockPos pos, ProbabilityConfig config) {
		int i = 0;

		int k = rand.nextInt(8) - rand.nextInt(8);
		int l = rand.nextInt(8) - rand.nextInt(8);
		int i1 = world.getHeight(Heightmap.Type.OCEAN_FLOOR, pos.getX() + k, pos.getZ() + l);
		BlockPos blockpos = new BlockPos(pos.getX() + k, i1, pos.getZ() + l);
		if (world.getBlockState(blockpos).getBlock() == Blocks.WATER) {
			int model = rand.nextInt(5);
			BlockState state = PVJBlocks.seashells.getDefaultState().with(GroundcoverBlock.MODEL, model).with(GroundcoverBlock.WATERLOGGED, true);
			if (state.isValidPosition(world, blockpos)) {
				world.setBlockState(blockpos, state, 2);

				++i;
			}
		}

		return i > 0;
	}
}