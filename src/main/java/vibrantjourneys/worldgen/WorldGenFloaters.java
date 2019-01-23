package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.init.PVJWorldGen;
import vibrantjourneys.util.BiomeReference;
import vibrantjourneys.util.PVJConfig;

public class WorldGenFloaters implements IWorldGenerator
{
	private boolean isRiver;
	private int frequency;
	private boolean checkDepth;
	
	public WorldGenFloaters(boolean isRiver, int frequency, boolean checkDepth)
	{
		this.isRiver = isRiver;
		this.frequency = (int)(frequency * (PVJConfig.global.overworldPlantsDensity / 100.0));
		this.checkDepth = checkDepth;
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
		
		boolean isFreshwater = true;
		if(!BiomeReference.LILYPAD_BIOMES.contains(biome))
			isFreshwater = false;
		
		if(isRiver && !(biome == Biomes.RIVER))
			isFreshwater = false;
		
		if(isFreshwater)
		{	
			int yPos = 62;
			for(int i = 0; i < frequency; i++)
			{
				int xPos = x + random.nextInt(8);
				int zPos = z + random.nextInt(8);
				
				if(!isRiver)
				{
					yPos = 60;
					for(int j = 0; j < 20; j++)
					{
						yPos += 1;
						BlockPos waterPos = new BlockPos(xPos, yPos, zPos);
						if(world.getBlockState(waterPos).getMaterial() == Material.WATER)
							break;
					}
				}
				
				BlockPos pos = new BlockPos(xPos, yPos, zPos);
				IBlockState state = world.getBlockState(pos);
				if(random.nextInt(4) == 0)
				{
					if(state.getMaterial() == Material.WATER)
					{
						//checks depth of water, do not spawn lily pad if too deep
						if(checkDepth)
						{
							int depth = 1;
							for(int d = 2; d < 5; d++)
							{
								state = world.getBlockState(pos.down(d));
								if(state.getMaterial() == Material.WATER)
									depth++;
								else
									break;
							}
							
							if(depth <= 3)
							{
								if(world.isAirBlock(pos.up()))
								{
									world.setBlockState(pos.up(), pickRandomFloater(world.rand));
								}
							}
						}
						else
						{
							if(world.isAirBlock(pos.up()))
							{
								world.setBlockState(pos.up(), pickRandomFloater(world.rand));
							}
						}
					}
				}
			}
		}
	}
	
	public IBlockState pickRandomFloater(Random rand)
	{
		int x = rand.nextInt(3);
		if(x == 0) return Blocks.WATERLILY.getDefaultState();
		else if(x == 1) return PVJBlocks.frogbit.getDefaultState();
		else return PVJBlocks.duckweed.getDefaultState();
	}
}
