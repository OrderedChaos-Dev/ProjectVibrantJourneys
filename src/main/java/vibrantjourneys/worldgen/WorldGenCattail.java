package vibrantjourneys.worldgen;

import java.util.Arrays;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.blocks.plant.BlockCattail;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.init.PVJWorldGen;
import vibrantjourneys.util.PVJConfig;

public class WorldGenCattail implements IWorldGenerator
{
	private int frequency;
	private Biome[] biomes;
	
	public WorldGenCattail(int frequency, Biome... biomes)
	{
		this.frequency = (int)(frequency * (PVJConfig.global.overworldPlantsDensity / 100.0));
		this.biomes = biomes;
	}
	
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
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
		        int xPos = rand.nextInt(16) + 8;
		        int zPos = rand.nextInt(16) + 8;
				
				ChunkPos chunkPos = world.getChunk(chunkX, chunkZ).getPos();
		        int y = world.getHeight(chunkPos.getBlock(0, 0, 0).add(xPos, 0, zPos)).getY() + rand.nextInt(4) - rand.nextInt(4);
		        BlockPos pos = chunkPos.getBlock(0, 0, 0).add(xPos, y, zPos);

		        if(canGenCattail(world, pos))
		        {
		        	((BlockCattail) PVJBlocks.cattail).placeAt(world, pos.up(), 2);
		        }
		        int neighbors = rand.nextInt(5);
		        for(int j = 0; j < neighbors; j++)
		        {
		        	int xOffset = rand.nextInt(5);
		        	int zOffset = rand.nextInt(5);
		        	
		        	BlockPos temp = pos.add(xOffset, 0, zOffset);
		        	if(canGenCattail(world, temp))
		        	{
		        		((BlockCattail) PVJBlocks.cattail).placeAt(world, temp.up(), 2);
		        	}
		        }		
			}
		}
	}
	
	private boolean canGenCattail(World world, BlockPos pos)
	{
		if(world.getBlockState(pos).getBlock() == Blocks.GRASS)
		{
			for(EnumFacing facing : EnumFacing.HORIZONTALS) //check for water
			{
				if(world.getBlockState(pos.offset(facing)).getMaterial() == Material.WATER)
				{
					if(world.isAirBlock(pos.up()) && world.isAirBlock(pos.up(2)))
					{
						return true;
					}
				}
			}
		}
		return false;
	}
}
