package vibrantjourneys.worldgen;

import java.util.Arrays;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.init.PVJWorldGen;
import vibrantjourneys.util.PVJConfig;

public class WorldGenRocks implements IWorldGenerator
{
	private WorldGenMinable rockGen;
	private int maxHeight;
	private int frequency;
	private Biome[] biomes;
	
	public WorldGenRocks(Block stone, int count, int maxHeight, int frequency, Biome... biomes)
	{
		this.rockGen = new WorldGenMinable(stone.getDefaultState(), count);
		this.maxHeight = maxHeight;
		this.frequency = (int)(frequency * (PVJConfig.global.stoneDepositsDensity / 100.0));
		this.biomes = biomes;
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		Random rand = new Random();
		int x = chunkX * 16 + 8;
		int z = chunkZ * 16 + 8;
	
		for(int id : PVJWorldGen.dimensionBlacklist)
			if(world.provider == DimensionManager.getProvider(id))
				return;
		
		int xPos, yPos, zPos;
		
		Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 0, z));
		
		if(Arrays.asList(biomes).contains(biome))
		{
			for(int i = 0; i < frequency; i++)
			{
				xPos = x + rand.nextInt(8);
				yPos = 1 + rand.nextInt(maxHeight);
				zPos = z + rand.nextInt(8);
				
				this.rockGen.generate(world, rand, new BlockPos(xPos, yPos, zPos));
			}
		}
	}
}
