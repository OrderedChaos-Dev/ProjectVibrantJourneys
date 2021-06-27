package projectvibrantjourneys.common.world.surfacebuilders;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class VerdantSandsSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
	public VerdantSandsSurfaceBuilder(Codec<SurfaceBuilderConfig> codec) {
		super(codec);
	}

	@Override
	public void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
//		if (random.nextFloat() < 0.33F) {
//			SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
//					defaultFluid, seaLevel, seed, SurfaceBuilder.CONFIG_DESERT);
//		} else if (random.nextFloat() < 0.33F) {
//			SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
//					defaultFluid, seaLevel, seed, SurfaceBuilder.CONFIG_DESERT);
//		} else {
//			SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
//					defaultFluid, seaLevel, seed, SurfaceBuilder.CONFIG_GRASS);
//		}

		
		if (noise > 1.8D) {
			SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed, SurfaceBuilder.CONFIG_DESERT);
		} else if (noise <= 1.8D && noise > 1.2D) {
			SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed, SurfaceBuilder.CONFIG_GRASS);
		} else if (noise > -0.95D) {
			SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed, SurfaceBuilder.CONFIG_DESERT);
		} else {
			SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed, SurfaceBuilder.CONFIG_GRASS);
		}
	}
}