package vibrantjourneys.worldgen;

import java.util.Arrays;
import java.util.Random;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.blocks.plant.BlockBracketFungus;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.init.PVJWorldGen;
import vibrantjourneys.util.PVJConfig;

public class WorldGenFlouropore implements IWorldGenerator
{
	private int frequency;
	private Biome[] biomes;
	
	public WorldGenFlouropore(int frequency, Biome... biomes)
	{
		this.frequency = (int)(frequency * (PVJConfig.global.overworldPlantsDensity / 100.0));
		this.biomes = biomes;
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator generator, IChunkProvider provider)
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
				int xPos = x + random.nextInt(16);
				int zPos = z + random.nextInt(16);
				int yPos = 1 + random.nextInt(40);
				
				BlockPos pos = new BlockPos(xPos, yPos, zPos);
				
				Random rand = new Random();
				EnumFacing facing = EnumFacing.Plane.HORIZONTAL.random(rand);
				
				if(world.isBlockFullCube(pos))
				{	
					if(world.isAirBlock(pos.offset(facing)))
					{
						world.setBlockState(pos.offset(facing), PVJBlocks.flouropore.getDefaultState().withProperty(BlockBracketFungus.FACING, facing));
					}
				}
			}
		}
	}
}
