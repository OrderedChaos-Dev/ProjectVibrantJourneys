package projectvibrantjourneys.common.world.features;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SeaGrassConfig;
import projectvibrantjourneys.common.blocks.CattailBlock;
import projectvibrantjourneys.init.PVJBlocks;

public class WaterCattailFeature extends Feature<SeaGrassConfig> {
	public WaterCattailFeature(Function<Dynamic<?>, ? extends SeaGrassConfig> config) {
		super(config);
	}

	public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, SeaGrassConfig config) {
		int i = 0;

		for (int j = 0; j < config.count; ++j) {
			int k = rand.nextInt(8) - rand.nextInt(8);
			int l = rand.nextInt(8) - rand.nextInt(8);
			int i1 = world.getHeight(Heightmap.Type.OCEAN_FLOOR, pos.getX() + k, pos.getZ() + l);
			BlockPos blockpos = new BlockPos(pos.getX() + k, i1, pos.getZ() + l);
			if (world.getBlockState(blockpos).getBlock() == Blocks.WATER && world.getBlockState(blockpos.up()).getBlock() == Blocks.AIR) {
				BlockState state = PVJBlocks.cattail.getDefaultState();
				if (state.isValidPosition(world, blockpos)) {
					((CattailBlock) state.getBlock()).placeInWater(world, blockpos, 2);

					++i;
				}
			}
		}

		return i > 0;
	}
}