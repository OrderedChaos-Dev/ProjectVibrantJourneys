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

public class WorldGenPalmTreeBeach implements IWorldGenerator
{
	public WorldGenPalmTree palmtreegen = new WorldGenPalmTree();
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator generator, IChunkProvider provider)
	{
		int x = chunkX * 16 + 8;
		int z = chunkZ * 16 + 8;
		
		Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 0, z));
		//beach but not cold beach
		//who wants a palm tree in the middle of a frozen beach?
		if(BiomeDictionary.hasType(biome, Type.BEACH) && !BiomeDictionary.hasType(biome, Type.COLD))
		{
			for(int i = 0; i < 6; i++)
			{
				int xPos = x + random.nextInt(16) - random.nextInt(16);
				int zPos = z + random.nextInt(16) - random.nextInt(16);
				int yPos;
				if(random.nextInt(6) == 0)
				{
					for(int y = 0; y < 4; y++)
					{
						yPos = 63 + y;
						BlockPos pos = new BlockPos(xPos, yPos, zPos);
						IBlockState state = world.getBlockState(pos.down());
						if(state.getBlock() == Blocks.SAND)
						{
							if(palmtreegen.generate(world, random, pos))
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
