package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.init.PVJWorldGen;

public class WorldGenDesertCaves implements IWorldGenerator
{
	private Biome[] biomes;
	
	public WorldGenDesertCaves(Biome... biomes)
	{
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
			int y = 30;
			for(BlockPos position : BlockPos.getAllInBoxMutable(x - 7, y - 28, z - 7, x + 7, y + 40, z + 7))
			{	
				if(!world.canSeeSky(position) && world.getBlockState(position).getBlock() instanceof BlockStone)
				{
					boolean isSandstone = false;
					for(EnumFacing facing : EnumFacing.VALUES)
					{
						if(world.isAirBlock(position.offset(facing)) && random.nextInt(5) < 3)
						{
							isSandstone = true;
							break;
						}
					}
					if(isSandstone)
						world.setBlockState(position, Blocks.SANDSTONE.getDefaultState());
				}
		}
		}
	}
}
