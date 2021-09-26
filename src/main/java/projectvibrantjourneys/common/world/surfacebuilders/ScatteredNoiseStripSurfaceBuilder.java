package projectvibrantjourneys.common.world.surfacebuilders;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ScatteredNoiseStripSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
	public ScatteredNoiseStripSurfaceBuilder(Codec<SurfaceBuilderConfig> CODEC) {
		super(CODEC);
	}

	@Override
	public void apply(Random rand, IChunk chunk, Biome biome, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		if (noise > 1.75D) {
			SurfaceBuilder.DEFAULT.apply(rand, chunk, biome, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed, SurfaceBuilder.CONFIG_GRASS);
		} else if (noise <= 1.75D && noise > 0.2D && rand.nextBoolean()) {
			SurfaceBuilder.DEFAULT.apply(rand, chunk, biome, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed, config);
		} else {
			SurfaceBuilder.DEFAULT.apply(rand, chunk, biome, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed, SurfaceBuilder.CONFIG_GRASS);
		}

	}
}
