package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.blocks.plant.BlockSeaOats;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.util.PVJConfig;

public class WorldGenSeaOats implements IWorldGenerator
{
	private int frequency;
	private Biome[] biomes;
	public WorldGenSeaOats(int frequency, Biome... biomes)
	{
		this.biomes = biomes;
		this.frequency = (int)(frequency * (PVJConfig.global.overworldPlantsDensity / 100.0));
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		Random rand = new Random();
		int x = chunkX * 16 + 8;
		int z = chunkZ * 16 + 8;
		Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 0, z));
		
		boolean isValidBiome = false;
		for(int i = 0; i < biomes.length; i++)
		{
			if(biome == biomes[i])
			{
				isValidBiome = true;
				break;
			}
		}
		
		if(isValidBiome)
		{
			for(int i = 0; i < frequency; i++)
			{
				ChunkPos chunkPos = world.getChunkFromChunkCoords(chunkX, chunkZ).getPos();
		        int xPos = rand.nextInt(16) + 8;
		        int zPos = rand.nextInt(16) + 8;
		        int y = rand.nextInt(world.getHeight(chunkPos.getBlock(0, 0, 0).add(xPos, 0, zPos)).getY() + 32);
		        BlockPos pos = chunkPos.getBlock(0, 0, 0).add(xPos, y, zPos);

		        for (int j = 0; j < 15; j++)
		        {
		            BlockPos blockpos = pos.add(rand.nextInt(4) - rand.nextInt(4), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(4) - rand.nextInt(4));

		            if (world.isAirBlock(blockpos) && blockpos.getY() < 255 && PVJBlocks.sea_oats.canPlaceBlockAt(world, blockpos))
		            {
		                ((BlockSeaOats)PVJBlocks.sea_oats).placeAt(world, blockpos, 2);
		            }
		        }
			}
		}
	}
	
	
}
