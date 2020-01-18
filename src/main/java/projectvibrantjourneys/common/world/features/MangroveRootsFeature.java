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
import net.minecraft.world.gen.feature.NoFeatureConfig;
import projectvibrantjourneys.init.PVJBlocks;

public class MangroveRootsFeature extends Feature<NoFeatureConfig> {
	public MangroveRootsFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
		super(config);
	}

	public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		int i = 0;
		
		if(rand.nextFloat() <= 0.33F) {
			BlockState log = PVJBlocks.mangrove_log.getDefaultState();
			int k = rand.nextInt(8) - rand.nextInt(8);
			int l = rand.nextInt(8) - rand.nextInt(8);
			int i1 = world.getHeight(Heightmap.Type.WORLD_SURFACE_WG, pos.getX() + k, pos.getZ() + l);
			BlockPos blockpos = new BlockPos(pos.getX() + k, i1, pos.getZ() + l).down();
			if (world.getBlockState(blockpos).getBlock() == Blocks.WATER && world.getBlockState(blockpos.up()).getBlock() == Blocks.AIR) {
				for(BlockPos temp = blockpos; !world.getBlockState(temp).isSolid(); temp = temp.down()) {
					world.setBlockState(temp, log, 2);
				}
				
				int extraHeight = rand.nextInt(4);
				for(int a = 1; a <= extraHeight; a++) {
					if(world.getBlockState(blockpos.up(a)).getBlock() == Blocks.AIR) {
						world.setBlockState(blockpos.up(a), log, 2);
					} else {
						break;
					}
				}
			}
		}

		
		return i > 0;
	}
}