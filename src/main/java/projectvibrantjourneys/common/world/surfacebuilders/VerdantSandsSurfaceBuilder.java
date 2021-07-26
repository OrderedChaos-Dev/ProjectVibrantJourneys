package projectvibrantjourneys.common.world.surfacebuilders;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

public class VerdantSandsSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderBaseConfiguration> {
	public VerdantSandsSurfaceBuilder(Codec<SurfaceBuilderBaseConfiguration> codec) {
		super(codec);
	}

	@Override
	public void apply(Random random, ChunkAccess chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, int bottom, long seed, SurfaceBuilderBaseConfiguration config) {
		if (noise > 1.8D) {
			SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, bottom, seed, SurfaceBuilder.CONFIG_DESERT);
		} else if (noise <= 1.8D && noise > 1.2D) {
			SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, bottom, seed, SurfaceBuilder.CONFIG_GRASS);
		} else if (noise > -0.95D) {
			SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, bottom, seed, SurfaceBuilder.CONFIG_DESERT);
		} else {
			SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, bottom, seed, SurfaceBuilder.CONFIG_GRASS);
		}
	}
}