package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.BlockSapling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenSmallBush implements IWorldGenerator
{
	private int frequency;
	private Biome[] biomes;
	
	public WorldGenSmallBush(int frequency, Biome... biomes)
	{
		this.frequency = frequency;
		this.biomes = biomes;
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
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
			for(int i = 0; i < 10; i++)
			{
				int xPos = x + random.nextInt(4) - random.nextInt(4);
				int zPos = z + random.nextInt(4) - random.nextInt(4);
				int yPos = 63 + random.nextInt(13);
				
				BlockPos pos = new BlockPos(xPos, yPos, zPos);
				if(random.nextInt(20) < frequency)
				{
					if(world.getBlockState(pos).getBlock().isReplaceable(world, pos))
					{
						IBlockState soil = world.getBlockState(pos.down());
						
						if(soil.getBlock().canSustainPlant(soil, world, pos, EnumFacing.UP,(BlockSapling)Blocks.SAPLING))
						{
							world.setBlockState(pos, Blocks.LOG.getDefaultState());
							if(world.getBlockState(pos.up()).getBlock().isReplaceable(world, pos.up()))
							{
								world.setBlockState(pos.up(), Blocks.LEAVES.getDefaultState());
							}
							if(world.getBlockState(pos.north()).getBlock().isReplaceable(world, pos.north()))
							{
								world.setBlockState(pos.north(), Blocks.LEAVES.getDefaultState());
							}
							if(world.getBlockState(pos.west()).getBlock().isReplaceable(world, pos.west()))
							{
								world.setBlockState(pos.west(), Blocks.LEAVES.getDefaultState());
							}
							if(world.getBlockState(pos.south()).getBlock().isReplaceable(world, pos.south()))
							{
								world.setBlockState(pos.south(), Blocks.LEAVES.getDefaultState());
							}
							if(world.getBlockState(pos.east()).getBlock().isReplaceable(world, pos.east()))
							{
								world.setBlockState(pos.east(), Blocks.LEAVES.getDefaultState());
							}
						}
					}
				}
			}	
		}
	}
}
