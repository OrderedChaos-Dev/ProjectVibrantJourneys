package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenFallenLeaves implements IWorldGenerator
{
	private Block block;
	private int frequency;
	private Biome[] biomes;
	
	public WorldGenFallenLeaves(Block block, int frequency, Biome... biomes)
	{
		this.block = block;
		this.frequency = frequency;
		this.biomes = biomes;
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		Random rand = new Random();
		//generating fallen leaves in a forest without adding +8 caused the worst cascading world gen lag i have ever seen
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
				int xPos = x + rand.nextInt(4) - rand.nextInt(4);
				int zPos = z + rand.nextInt(4) - rand.nextInt(4);
				
				for(int j = 0; j < 10; j++)
				{
					int yPos = 25 + rand.nextInt(150);
					
					BlockPos pos = new BlockPos(xPos, yPos, zPos);
					
					if(world.isSideSolid(pos.down(), EnumFacing.UP))
					{
						IBlockState state = world.getBlockState(pos);
						if(world.isAirBlock(pos) || world.getBlockState(pos).getBlock().isReplaceable(world, pos))
						{
							if(state.getMaterial() != Material.WATER)
							{
								if(yPos < 60 && world.canSeeSky(pos))
								{
									if(world.setBlockState(pos, block.getDefaultState()))
									{
										break;
									}
								}
								else if(yPos > 60)
								{
									if(world.setBlockState(pos, block.getDefaultState()))
									{
										break;
									}
								}
							}
						}
					}
				}
			}
		}
	}

}
