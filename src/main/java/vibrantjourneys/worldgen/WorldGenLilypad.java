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
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.util.BiomeReference;

public class WorldGenLilypad implements IWorldGenerator
{
	private boolean isRiver;
	private int frequency;
	private boolean checkDepth;
	
	public WorldGenLilypad(boolean isRiver, int frequency, boolean checkDepth)
	{
		this.isRiver = isRiver;
		this.frequency = frequency;
		this.checkDepth = checkDepth;
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		int x = chunkX * 16 + 8;
		int z = chunkZ * 16 + 8;
		
		Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 0, z));
		
		boolean isFreshwater = true;
		if(!BiomeReference.FRESHWATER_BIOMES.contains(biome))
			isFreshwater = false;
		
		if(biome == Biomes.RIVER || (isFreshwater && !isRiver && !BiomeDictionary.hasType(biome, Type.SNOWY)))
		{	
			for(int i = 0; i < frequency; i++)
			{
				int xPos = x + random.nextInt(4) - random.nextInt(4);
				int zPos = z + random.nextInt(4) - random.nextInt(4);
				int yPos = isRiver? 63 : 63 + random.nextInt(30);
				BlockPos pos = new BlockPos(xPos, yPos, zPos);
				IBlockState state = world.getBlockState(pos.down());
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
								if(world.isAirBlock(pos))
								{
									world.setBlockState(pos, Blocks.WATERLILY.getDefaultState());
								}
							}
						}
						else
						{
							if(world.isAirBlock(pos))
							{
								world.setBlockState(pos, Blocks.WATERLILY.getDefaultState());
							}
						}
					}
				}
			}
		}
	}
}
