package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.blocks.BlockGroundCover;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.init.PVJWorldGen;
import vibrantjourneys.util.PVJConfig;

public class WorldGenFlowerPatch implements IWorldGenerator
{
	private int frequency;
	private Biome[] biomes;

	public WorldGenFlowerPatch(int frequency, Biome... biomes)
	{
		this.biomes = biomes;
		this.frequency = (int)(frequency * (PVJConfig.global.groundcoverDensity / 100.0));
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		Random rand = new Random();
		int x = chunkX * 16 + 8;
		int z = chunkZ * 16 + 8;
		Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 0, z));
		
		for(int id : PVJWorldGen.dimensionBlacklist)
			if(world.provider == DimensionManager.getProvider(id))
				return;
		
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
				ChunkPos chunkPos = world.getChunk(chunkX, chunkZ).getPos();
		        int xPos = rand.nextInt(16) + 8;
		        int zPos = rand.nextInt(16) + 8;
		        int y = world.getHeight(chunkPos.getBlock(0, 0, 0).add(xPos, 0, zPos)).getY() + random.nextInt(4) - random.nextInt(4);
		        BlockPos pos = chunkPos.getBlock(0, 0, 0).add(xPos, y, zPos);

            	int model = random.nextInt(5);
            	
		        for (int j = 0; j < 5; j++)
		        {
		            BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

		            Block soil = world.getBlockState(blockpos.down()).getBlock();
		            boolean isSoil = false;
		            if(soil instanceof BlockGrass || soil instanceof BlockDirt)
		            	isSoil = true;
		            
		            if (world.isAirBlock(blockpos) && blockpos.getY() < 255 && isSoil)
		            {
		                world.setBlockState(blockpos, PVJBlocks.flower_patch.getDefaultState().withProperty(BlockGroundCover.MODEL, model), 2);
		            }
		        }
			}
		}
	}
	
	
}
