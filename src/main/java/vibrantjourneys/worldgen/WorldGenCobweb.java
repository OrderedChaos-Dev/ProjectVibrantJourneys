package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.init.PVJWorldGen;

public class WorldGenCobweb implements IWorldGenerator
{
	private int frequency;
	
	public WorldGenCobweb(int frequency)
	{
		this.frequency = frequency;
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
		if(BiomeDictionary.hasType(biome, Type.FOREST) || BiomeDictionary.hasType(biome, Type.SWAMP) || BiomeDictionary.hasType(biome, Type.JUNGLE))
		{
			for(int i = 0; i < frequency; i++)
			{
				int xPos = x + random.nextInt(8) - random.nextInt(8);
				int zPos = z + random.nextInt(8) - random.nextInt(8);
				int yPos = 63 + random.nextInt(20);
				if(random.nextInt(6) == 0)
				{
					BlockPos pos = new BlockPos(xPos, yPos, zPos);
					IBlockState state = world.getBlockState(pos.up());
					
					if(state.getBlock() instanceof BlockLeaves)
					{
						if(world.isAirBlock(pos))
						{
							world.setBlockState(pos,Blocks.WEB.getDefaultState());
						}
					}
				}
			}
		}
	}
}
