package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.init.PVJWorldGen;

public class WorldGenCrackedSand implements IWorldGenerator
{
	private Block block, replacedBlock;
	private int minY, maxY;
	private int frequency;
	private Biome[] biomes;
	
	public WorldGenCrackedSand(Block block, Block replacedBlock, int minY, int maxY, int frequency, Biome... biomes)
	{
		this.block = block;
		this.replacedBlock = replacedBlock;
		this.minY = minY;
		this.maxY = maxY;
		this.frequency = frequency;
		this.biomes = biomes;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		int x = chunkX * 16 + 8;
		int z = chunkZ * 16 + 8;
		
		for(int id : PVJWorldGen.dimensionBlacklist)
			if(world.provider == DimensionManager.getProvider(id))
				return;
		
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
				int xPos = x + random.nextInt(6) - random.nextInt(6);
				int zPos = z + random.nextInt(6) - random.nextInt(6);
				int yPos = minY + random.nextInt(maxY - minY + 1);
				
				BlockPos pos = new BlockPos(xPos, yPos, zPos);
				if(world.getBlockState(pos).getBlock() == replacedBlock)
				{
					world.setBlockState(pos, block.getDefaultState());
				}
			}
		}
	}
	
	
}
