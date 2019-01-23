package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.BlockHardenedClay;
import net.minecraft.block.BlockSand;
import net.minecraft.block.state.IBlockState;
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
import vibrantjourneys.worldgen.feature.WorldGenJuniperTree;

public class WorldGenJuniperTreeMesa implements IWorldGenerator
{
	private int frequency;
	
	public WorldGenJuniperTreeMesa(int frequency)
	{
		this.frequency = frequency;
	}
	
	public WorldGenJuniperTree juniper_gen = new WorldGenJuniperTree(false);
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator generator, IChunkProvider provider)
	{
		int x = chunkX * 16 + 8;
		int z = chunkZ * 16 + 8;
		
		for(int id : PVJWorldGen.dimensionBlacklist)
			if(world.provider == DimensionManager.getProvider(id))
				return;
		
		Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 0, z));
		//beach but not cold beach
		//who wants a palm tree in the middle of a frozen beach?
		if(BiomeDictionary.hasType(biome, Type.MESA))
		{
			for(int i = 0; i < frequency; i++)
			{
				int xPos = x + random.nextInt(4) - random.nextInt(4);
				int zPos = z + random.nextInt(4) - random.nextInt(4);
				int yPos;
				if(random.nextInt(45) == 0)
				{
					for(int y = 0; y < 4; y++)
					{
						yPos = 63 + y;
						BlockPos pos = new BlockPos(xPos, yPos, zPos);
						IBlockState state = world.getBlockState(pos.down());
						if(state.getBlock() instanceof BlockSand || state.getBlock() instanceof BlockHardenedClay)
						{
							if(juniper_gen.generate(world, random, pos))
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
