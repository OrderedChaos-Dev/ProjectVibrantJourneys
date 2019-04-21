package vibrantjourneys.worldgen;

import java.util.Arrays;
import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.init.PVJWorldGen;

public class WorldGenBoulder implements IWorldGenerator
{
	private int frequency;
	private Biome[] biomes;
	
	public WorldGenBoulder(int frequency, Biome... biomes)
	{
		this.frequency = frequency;
		this.biomes = biomes;
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator generator, IChunkProvider provider)
	{
		for(int id : PVJWorldGen.dimensionBlacklist)
			if(world.provider == DimensionManager.getProvider(id))
				return;
		
		ChunkPos chunkPos = world.getChunk(chunkX, chunkZ).getPos();
		
		Biome biome = world.getBiomeForCoordsBody(chunkPos.getBlock(0, 0, 0));
		if(Arrays.asList(biomes).contains(biome))
		{
			for(int i = 0; i < frequency; i++)
			{
				if(random.nextInt(50) == 0)
				{
			        int xPos = random.nextInt(16) + 8;
			        int zPos = random.nextInt(16) + 8;
			        int y = world.getHeight(chunkPos.getBlock(0, 0, 0).add(xPos, 0, zPos)).getY() + random.nextInt(8) - random.nextInt(8);
			        BlockPos pos = chunkPos.getBlock(0, 0, 0).add(xPos, y, zPos);
					(new WorldGenBlockBlob(Blocks.STONE, 0)).generate(world, random, pos);
				}
			}
		}
	}
}
