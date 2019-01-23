package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.init.PVJWorldGen;
import vibrantjourneys.util.PVJConfig;
import vibrantjourneys.worldgen.feature.WorldGenPlant;

public class WorldGenPVJPlant implements IWorldGenerator
{
	public static final int OVERWORLD = 0;
	public static final int NETHER = -1;
	public static final int END = 1;
	
	private int frequency;
	private Biome[] biomes;
	private WorldGenPlant plant_gen;
	
	public WorldGenPVJPlant(Block block, int frequency, Biome... biomes)
	{
		this(block, frequency, OVERWORLD, biomes);
	}
	
	public WorldGenPVJPlant(Block block, int frequency, int dimension, Biome... biomes)
	{
		this.biomes = biomes;
		
		plant_gen = new WorldGenPlant(block);
		
		if(dimension == NETHER)
			this.frequency = (int)(frequency * (PVJConfig.global.netherPlantsDensity / 100.0));
		if(dimension == END)
			this.frequency = (int)(frequency * (PVJConfig.global.endPlantsDensity / 100.0));
		else
			this.frequency = (int)(frequency * (PVJConfig.global.overworldPlantsDensity / 100.0));
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
				ChunkPos chunkPos = world.getChunk(chunkX, chunkZ).getPos();
		        int xPos = rand.nextInt(16) + 8;
		        int zPos = rand.nextInt(16) + 8;
		        int y = rand.nextInt(world.getHeight(chunkPos.getBlock(0, 0, 0).add(xPos, 0, zPos)).getY() + 32);
		        BlockPos pos = chunkPos.getBlock(0, 0, 0).add(xPos, y, zPos);

				plant_gen.generate(world, rand, pos);
			}
		}
	}
	
	
}
