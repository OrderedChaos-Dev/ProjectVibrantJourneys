package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
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
import vibrantjourneys.util.PVJConfig;

public class WorldGenFallenLeaves implements IWorldGenerator
{
	private Block block;
	private int frequency;
	private Biome[] biomes;
	
	public WorldGenFallenLeaves(Block block, int frequency, Biome... biomes)
	{
		this.block = block;
		this.frequency = (int)(frequency * (PVJConfig.global.fallenLeavesDensity / 100.0) * (PVJConfig.global.groundcoverDensity / 100.0));
		this.biomes = biomes;
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		Random rand = new Random();
		ChunkPos chunkPos = world.getChunk(chunkX, chunkZ).getPos();
		
		for(int id : PVJWorldGen.dimensionBlacklist)
			if(world.provider == DimensionManager.getProvider(id))
				return;
		
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
		        int xPos = rand.nextInt(16) + 8;
		        int zPos = rand.nextInt(16) + 8;

		        int y = world.getHeight(chunkPos.getBlock(0, 0, 0).add(xPos, 0, zPos)).getY() + rand.nextInt(8) - rand.nextInt(8);
		        BlockPos pos = chunkPos.getBlock(0, 0, 0).add(xPos, y, zPos);
				
				if(world.isSideSolid(pos.down(), EnumFacing.UP))
				{
					IBlockState state = world.getBlockState(pos);
					if(world.isAirBlock(pos) || world.getBlockState(pos).getBlock().isReplaceable(world, pos))
					{
						if(state.getMaterial() != Material.WATER)
						{
							if(y > 60 || (y < 60 && world.canSeeSky(pos)))
							{
								world.setBlockState(pos, block.getDefaultState());
							}
						}
					}
				}
			}
		}
	}

}
