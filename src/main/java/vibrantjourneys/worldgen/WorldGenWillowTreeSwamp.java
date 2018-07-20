package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenWillowTreeSwamp implements IWorldGenerator
{
	private int frequency;
	public WorldGenWillowTreeSwamp(int frequency)
	{
		this.frequency = frequency;
	}
	
	public WorldGenWillowTree willowtreegen = new WorldGenWillowTree();
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator generator, IChunkProvider provider)
	{
		int x = chunkX * 16 + 8;
		int z = chunkZ * 16 + 8;
		
		Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 0, z));

		if(BiomeDictionary.hasType(biome, Type.SWAMP))
		{
			for(int i = 0; i < frequency; i++)
			{
				int xPos = x + random.nextInt(7) - random.nextInt(7);
				int zPos = z + random.nextInt(7) - random.nextInt(7);
				int yPos;
				if(random.nextInt(10) == 0)
				{
					for(int y = 0; y < 15; y++)
					{
						yPos = 62 + y;
						BlockPos pos = new BlockPos(xPos, yPos, zPos);
						IBlockState state = world.getBlockState(pos.down());
						if(state.getBlock() == Blocks.GRASS)
						{
							if(willowtreegen.generate(world, random, pos))
							{
								System.out.println(pos);
								break;
							}
						}
					}
				}
			}
		}
	}
}
