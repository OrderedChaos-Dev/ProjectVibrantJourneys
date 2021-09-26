package projectvibrantjourneys.common.world.surfacebuilders;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import projectvibrantjourneys.init.world.PVJSurfaceBuilders;

public class StonyFieldsSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
	public StonyFieldsSurfaceBuilder(Codec<SurfaceBuilderConfig> CODEC) {
		super(CODEC);
	}

	@Override
	public void apply(Random rand, IChunk chunk, Biome biome, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		float f = rand.nextFloat();
		if(f >= 0.85F) {
			SurfaceBuilder.DEFAULT.apply(rand, chunk, biome, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed, SurfaceBuilder.CONFIG_STONE);
		} else if (f >= 0.70F) {
			SurfaceBuilder.DEFAULT.apply(rand, chunk, biome, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed, SurfaceBuilder.CONFIG_GRAVEL);
		} else if (f >= 0.55F) {
			SurfaceBuilder.DEFAULT.apply(rand, chunk, biome, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed, SurfaceBuilder.CONFIG_GRASS);
		} else if (f >= 0.4F) {
			SurfaceBuilder.DEFAULT.apply(rand, chunk, biome, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed, PVJSurfaceBuilders.CONFIG_ANDESITE);
		} else {
			SurfaceBuilder.DEFAULT.apply(rand, chunk, biome, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed, SurfaceBuilder.CONFIG_GRASS);
		}
	}
}
