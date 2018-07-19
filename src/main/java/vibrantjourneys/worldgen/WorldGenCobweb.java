package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
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

public class WorldGenCobweb implements IWorldGenerator
{
	public Block cobweb = Blocks.WEB;
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator generator, IChunkProvider provider)
	{
		int x = chunkX * 16 + 8;
		int z = chunkZ * 16 + 8;
		
		Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 0, z));
		if(BiomeDictionary.hasType(biome, Type.FOREST) || BiomeDictionary.hasType(biome, Type.SWAMP) || BiomeDictionary.hasType(biome, Type.JUNGLE))
		{
			for(int i = 0; i < 100; i++)
			{
				int xPos = x + random.nextInt(8) - random.nextInt(8);
				int zPos = z + random.nextInt(8) - random.nextInt(8);
				int yPos = 63 + random.nextInt(20);
				if(random.nextInt(7) == 0)
				{
					BlockPos pos = new BlockPos(xPos, yPos, zPos);
					IBlockState state = world.getBlockState(pos.up());
					
					if(state.getBlock() instanceof BlockLeaves)
					{
						if(world.isAirBlock(pos))
						{
							world.setBlockState(pos, cobweb.getDefaultState());
						}
					}
				}
			}
		}
	}
}
