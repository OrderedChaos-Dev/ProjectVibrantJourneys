package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.init.PVJWorldGen;
import vibrantjourneys.util.EnumWoodType;

public class WorldGenMangroveRoot implements IWorldGenerator
{
	private int frequency;
	private Biome[] biomes;
	private IBlockState LOG = PVJBlocks.LOGS.get(EnumWoodType.MANGROVE.getID()).getDefaultState();
	
	public WorldGenMangroveRoot(int frequency, Biome... biomes)
	{
		this.frequency = frequency;
		this.biomes = biomes;
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		int x = chunkX * 16 + 8;
		int z = chunkZ * 16 + 8;
		int y = 63;
		
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
				x += random.nextInt(8);
				z += random.nextInt(8);
				
				BlockPos pos = new BlockPos(x, y, z);
				if(world.isAirBlock(pos) && world.getBlockState(pos.down()).getMaterial() == Material.WATER)
				{
					world.setBlockState(pos, LOG);
					if(random.nextInt(3) == 0 && world.isAirBlock(pos.up()))
					{
						world.setBlockState(pos.up(), LOG);
					}
					do
					{
						pos = pos.down();
						world.setBlockState(pos, LOG);
					}
					while(world.getBlockState(pos.down()).getMaterial() == Material.WATER);
				}
			}
		}
	}
}
