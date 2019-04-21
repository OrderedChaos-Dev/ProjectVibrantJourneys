package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.BlockSapling;
import net.minecraft.block.state.IBlockState;
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
import vibrantjourneys.init.PVJWorldGen;

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
		for(int id : PVJWorldGen.dimensionBlacklist)
			if(world.provider == DimensionManager.getProvider(id))
				return;
		
		ChunkPos chunkPos = world.getChunk(chunkX, chunkZ).getPos();
		Biome biome = world.getBiomeForCoordsBody(chunkPos.getBlock(0, 0, 0));
		
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
		        int xPos = random.nextInt(16) + 8;
		        int zPos = random.nextInt(16) + 8;
		        int y = world.getHeight(chunkPos.getBlock(0, 0, 0).add(xPos, 0, zPos)).getY() + random.nextInt(4) - random.nextInt(4);
		        BlockPos pos = chunkPos.getBlock(0, 0, 0).add(xPos, y, zPos);
		        
				if(world.getBlockState(pos).getBlock().isReplaceable(world, pos))
				{
					IBlockState soil = world.getBlockState(pos.down());
					
					if(soil.getBlock().canSustainPlant(soil, world, pos.down(), EnumFacing.UP,(BlockSapling)Blocks.SAPLING))
					{
						world.setBlockState(pos, Blocks.LOG.getDefaultState());
						for(EnumFacing facing : EnumFacing.HORIZONTALS)
						{
							BlockPos temp = pos.offset(facing);
							if(world.getBlockState(temp).getBlock().isReplaceable(world, temp))
							{
								world.setBlockState(temp, Blocks.LEAVES.getDefaultState());
							}
						}
						if(world.getBlockState(pos.up()).getBlock().isReplaceable(world, pos.up()))
						{
							world.setBlockState(pos.up(), Blocks.LEAVES.getDefaultState());
						}
					}
				}
			}	
		}
	}
}
