package vibrantjourneys.worldgen;

import java.util.Arrays;
import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.init.PVJWorldGen;
import vibrantjourneys.util.PVJConfig;

public class WorldGenBoulder implements IWorldGenerator
{
	private int frequency;
	private Biome[] biomes;
	
	public WorldGenBoulder(int frequency, Biome... biomes)
	{
		this.frequency = (int)(frequency * (PVJConfig.global.overworldPlantsDensity / 100.0));
		this.biomes = biomes;
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator generator, IChunkProvider provider)
	{
		int x = chunkX * 16 + 8;
		int z = chunkZ * 16 + 8;
		
		for(int id : PVJWorldGen.dimensionBlacklist)
			if(world.provider == DimensionManager.getProvider(id))
				return;
		
		Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 0, z));
		if(Arrays.asList(biomes).contains(biome))
		{
			for(int i = 0; i < frequency; i++)
			{
				if(random.nextInt(350) == 0)
				{
					int xPos = x + random.nextInt(8) + 8;
					int zPos = z + random.nextInt(8) + 8;
					int yPos = 63 + random.nextInt(100);
					
					BlockPos blockpos = world.getHeight(new BlockPos(xPos, yPos, zPos));
					(new WorldGenBlockBlob(Blocks.STONE, 0)).generate(world, random, blockpos);
				}
			}
		}
	}
}
