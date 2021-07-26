package projectvibrantjourneys.common.world.surfacebuilders;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

public class RedwoodsSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderBaseConfiguration> {
	public RedwoodsSurfaceBuilder(Codec<SurfaceBuilderBaseConfiguration> CODEC) {
		super(CODEC);
	}

	@Override
	public void apply(Random rand, ChunkAccess chunk, Biome biome, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, int bottom, long seed, SurfaceBuilderBaseConfiguration config) {
		if (noise > 1.75D) {
			SurfaceBuilder.DEFAULT.apply(rand, chunk, biome, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, bottom, seed, SurfaceBuilder.CONFIG_COARSE_DIRT);
		} else if (noise <= 1.75D && noise > 1.2D) {
			SurfaceBuilder.DEFAULT.apply(rand, chunk, biome, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, bottom, seed, SurfaceBuilder.CONFIG_STONE);
		} else if (noise > -0.90D) {
			SurfaceBuilder.DEFAULT.apply(rand, chunk, biome, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, bottom, seed, SurfaceBuilder.CONFIG_PODZOL);
		} else {
			SurfaceBuilder.DEFAULT.apply(rand, chunk, biome, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, bottom, seed, SurfaceBuilder.CONFIG_GRASS);
		}

	}
}
