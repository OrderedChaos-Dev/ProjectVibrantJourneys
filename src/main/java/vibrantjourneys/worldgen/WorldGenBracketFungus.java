package vibrantjourneys.worldgen;

import java.util.Arrays;
import java.util.Random;

import net.minecraft.block.BlockLog;
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
import vibrantjourneys.blocks.plant.BlockBracketFungus;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.init.PVJWorldGen;
import vibrantjourneys.util.PVJConfig;

public class WorldGenBracketFungus implements IWorldGenerator
{
	private int frequency;
	private Biome[] biomes;
	
	public WorldGenBracketFungus(int frequency, Biome... biomes)
	{
		this.frequency = (int)(frequency * (PVJConfig.global.overworldPlantsDensity / 100.0));
		this.biomes = biomes;
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator generator, IChunkProvider provider)
	{	
		for(int id : PVJWorldGen.dimensionBlacklist)
			if(world.provider == DimensionManager.getProvider(id))
				return;
		
		ChunkPos chunkPos = world.getChunk(chunkX, chunkZ).getPos();
		Biome biome = world.getBiomeForCoordsBody(chunkPos.getBlock(0, 0, 0));
		
		if(Arrays.asList(biomes).contains(biome))
		{
			for(int i = 0; i < frequency; i++)
			{
		        int xPos = random.nextInt(16) + 8;
		        int zPos = random.nextInt(16) + 8;
		        int y = world.getHeight(chunkPos.getBlock(0, 0, 0).add(xPos, 0, zPos)).getY() + random.nextInt(16) - random.nextInt(16);
		        BlockPos pos = chunkPos.getBlock(0, 0, 0).add(xPos, y, zPos);
				
				IBlockState state = world.getBlockState(pos);
				
				if(state.getBlock() instanceof BlockLog)
				{
					Random rand = new Random();
					EnumFacing facing = EnumFacing.Plane.HORIZONTAL.random(rand);
					
					if(world.isAirBlock(pos.offset(facing)))
					{
						world.setBlockState(pos.offset(facing), PVJBlocks.bracket_fungus.getDefaultState().withProperty(BlockBracketFungus.FACING, facing));
					}
				}
			}
		}
	}
}
