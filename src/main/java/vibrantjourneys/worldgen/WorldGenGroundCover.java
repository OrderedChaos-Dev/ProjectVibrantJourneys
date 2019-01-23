package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.blocks.BlockGroundCover;
import vibrantjourneys.init.PVJWorldGen;
import vibrantjourneys.util.PVJConfig;

public class WorldGenGroundCover implements IWorldGenerator
{
	private Block block;
	private int minY, maxY;
	private int frequency;
	private Biome[] biomes;
	
	public WorldGenGroundCover(Block block, int minY, int maxY, int frequency, Biome... biomes)
	{
		this.block = block;
		this.minY = minY;
		this.maxY = maxY;
		double multiplier = 1.0;
		
		if(((BlockGroundCover)block).getGroundcoverType() == BlockGroundCover.GroundcoverType.TWIGS)
			multiplier = PVJConfig.global.twigsDensity / 100.0;
		if(((BlockGroundCover)block).getGroundcoverType() == BlockGroundCover.GroundcoverType.ROCKS)
			multiplier = PVJConfig.global.rocksDensity / 100.0;
		
		this.frequency = (int)(frequency * (PVJConfig.global.groundcoverDensity / 100.0) * multiplier);
		this.biomes = biomes;
	}

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		Random random = new Random();
		if(world.provider.getDimensionType() != DimensionType.OVERWORLD && world.provider.getDimensionType() != DimensionType.NETHER)
			return;
		
		int x = chunkX * 16 + 8;
		int z = chunkZ * 16 + 8;
		
		for(int id : PVJWorldGen.dimensionBlacklist)
			if(world.provider == DimensionManager.getProvider(id))
				return;
		
		Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 0, z));
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
				int xPos = x + random.nextInt(16);
				int zPos = z + random.nextInt(16);
				int yPos = minY + random.nextInt(maxY - minY + 1);
				
				BlockPos pos = new BlockPos(xPos, yPos, zPos);
				int model = random.nextInt(5);
				
				if(world.isSideSolid(pos.down(), EnumFacing.UP) && world.isAirBlock(pos))
				{
					world.setBlockState(pos, block.getDefaultState().withProperty(BlockGroundCover.MODEL, model));
				}
			}
		}
	}
	
	
}
