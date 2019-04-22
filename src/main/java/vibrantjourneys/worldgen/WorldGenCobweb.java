package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.init.PVJBlocks;
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
		for(int id : PVJWorldGen.dimensionBlacklist)
			if(world.provider == DimensionManager.getProvider(id))
				return;
		
		ChunkPos chunkPos = world.getChunk(chunkX, chunkZ).getPos();
		
		Biome biome = world.getBiomeForCoordsBody(chunkPos.getBlock(0, 0, 0));
		if(BiomeDictionary.hasType(biome, Type.FOREST) || BiomeDictionary.hasType(biome, Type.SWAMP) || BiomeDictionary.hasType(biome, Type.JUNGLE))
		{
			for(int i = 0; i < frequency; i++)
			{
		        int xPos = random.nextInt(16) + 8;
		        int zPos = random.nextInt(16) + 8;
		        int y = world.getHeight(chunkPos.getBlock(0, 0, 0).add(xPos, 0, zPos)).getY() + random.nextInt(16) - random.nextInt(16);
		        
				BlockPos pos = chunkPos.getBlock(0, 0, 0).add(xPos, y, zPos);
				IBlockState state = world.getBlockState(pos.up());
				
				if(state.getBlock() instanceof BlockLeaves)
				{
					if(world.isAirBlock(pos))
					{
						world.setBlockState(pos, PVJBlocks.pvj_cobweb.getDefaultState());
					}
				}
			}
		}
	}
}
