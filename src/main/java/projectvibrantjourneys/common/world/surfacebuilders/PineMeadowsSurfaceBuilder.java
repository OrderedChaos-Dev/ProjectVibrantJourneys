package projectvibrantjourneys.common.world.surfacebuilders;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import projectvibrantjourneys.init.world.PVJSurfaceBuilders;

public class PineMeadowsSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderBaseConfiguration> {
	public PineMeadowsSurfaceBuilder(Codec<SurfaceBuilderBaseConfiguration> codec) {
		super(codec);
	}

	@Override
	public void apply(Random rand, ChunkAccess chunk, Biome biome, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, int bottom, long seed, SurfaceBuilderBaseConfiguration config) {
		if (noise > 1.75D) {
			SurfaceBuilder.DEFAULT.apply(rand, chunk, biome, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, bottom, seed, SurfaceBuilder.CONFIG_GRASS);
		} else if (noise <= 1.75D && noise > 0.2D && rand.nextBoolean()) {
			SurfaceBuilder.DEFAULT.apply(rand, chunk, biome, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, bottom, seed, PVJSurfaceBuilders.CONFIG_DIORITE);
		} else {
			SurfaceBuilder.DEFAULT.apply(rand, chunk, biome, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, bottom, seed, SurfaceBuilder.CONFIG_GRASS);
		}

	}
}
