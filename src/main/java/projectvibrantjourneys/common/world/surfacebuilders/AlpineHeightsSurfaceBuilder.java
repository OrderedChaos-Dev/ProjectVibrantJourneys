package projectvibrantjourneys.common.world.surfacebuilders;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderConfiguration;

public class AlpineHeightsSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderBaseConfiguration> {
	
	public AlpineHeightsSurfaceBuilder(Codec<SurfaceBuilderBaseConfiguration> codec) {
		super(codec);
	}
	
	@Override
	public void apply(Random random, ChunkAccess chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, int bottom, long seed, SurfaceBuilderBaseConfiguration config) {
		int i = x & 15;
		int j = z & 15;
		BlockState blockstate = Blocks.STONE.defaultBlockState();
		SurfaceBuilderConfiguration isurfacebuilderconfig = biomeIn.getGenerationSettings().getSurfaceBuilderConfig();
		BlockState blockstate1 = isurfacebuilderconfig.getUnderMaterial();
		BlockState blockstate3 = blockstate1;
		int k = (int) (noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
		int l = -1;
		int i1 = 0;
		BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

		for (int j1 = startHeight; j1 >= 0; --j1) {
			if (i1 < 15) {
				blockpos$mutable.set(i, j1, j);
				BlockState blockstate4 = chunkIn.getBlockState(blockpos$mutable);
				if (blockstate4.isAir()) {
					l = -1;
				} else if (blockstate4.is(defaultBlock.getBlock())) {
					if (l == -1) {
						if (k <= 0) {
							blockstate = Blocks.AIR.defaultBlockState();
							blockstate3 = defaultBlock;
						} else if (j1 >= seaLevel - 4 && j1 <= seaLevel + 1) {
							blockstate = Blocks.STONE.defaultBlockState();
							blockstate3 = blockstate1;
						}

						if (j1 < seaLevel && (blockstate == null || blockstate.isAir())) {
							blockstate = defaultFluid;
						}

						l = k + Math.max(0, j1 - seaLevel);
						if(j1 > 127 + 13 * Math.sin(noise)) {
							chunkIn.setBlockState(blockpos$mutable, Blocks.SNOW_BLOCK.defaultBlockState(), false);
						} else if (j1 >= seaLevel - 1) {
							if (j1 > seaLevel + 3 + k) {
								chunkIn.setBlockState(blockpos$mutable, Blocks.STONE.defaultBlockState(), false);
							} else {
								chunkIn.setBlockState(blockpos$mutable, Blocks.SNOW_BLOCK.defaultBlockState(), false);
							}
						} else {
							chunkIn.setBlockState(blockpos$mutable, blockstate3, false);
						}
					} else if (l > 0) {
						if(j1 > 127 + 13 * Math.sin(noise))
							chunkIn.setBlockState(blockpos$mutable, Blocks.SNOW_BLOCK.defaultBlockState(), false);
						else
							chunkIn.setBlockState(blockpos$mutable, Blocks.STONE.defaultBlockState(), false);
					}

					++i1;
				}
			}
		}

	}
}
