package projectvibrantjourneys.common.world.surfacebuilders;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import projectvibrantjourneys.init.world.PVJSurfaceBuilders;

public class WindsweptCliffsSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderBaseConfiguration> {
	public WindsweptCliffsSurfaceBuilder(Codec<SurfaceBuilderBaseConfiguration> CODEC) {
		super(CODEC);
	}

	@Override
	public void apply(Random rand, ChunkAccess chunk, Biome biome, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, int bottom, long seed, SurfaceBuilderBaseConfiguration config) {
		float f = rand.nextFloat();
		if(f >= 0.85F) {
			SurfaceBuilder.DEFAULT.apply(rand, chunk, biome, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, bottom, seed, SurfaceBuilder.CONFIG_STONE);
		} else if (f >= 0.70F) {
			SurfaceBuilder.DEFAULT.apply(rand, chunk, biome, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, bottom, seed, SurfaceBuilder.CONFIG_GRAVEL);
		} else if (f >= 0.55F) {
			SurfaceBuilder.DEFAULT.apply(rand, chunk, biome, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, bottom, seed, SurfaceBuilder.CONFIG_GRASS);
		} else if (f >= 0.4F) {
			SurfaceBuilder.DEFAULT.apply(rand, chunk, biome, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, bottom, seed, PVJSurfaceBuilders.CONFIG_ANDESITE);
		} else if (f >= 0.25F) {
			SurfaceBuilder.DEFAULT.apply(rand, chunk, biome, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, bottom, seed, PVJSurfaceBuilders.CONFIG_MOSS);
		} else  {
			SurfaceBuilder.DEFAULT.apply(rand, chunk, biome, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, bottom, seed, PVJSurfaceBuilders.CONFIG_COBBLESTONE);
		}
	}
}
