package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockVine;
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

public class WorldGenOvergrownCaves implements IWorldGenerator
{
	private Biome[] biomes;
	
	public WorldGenOvergrownCaves(Biome... biomes)
	{
		this.biomes = biomes;
	}

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		Random random = new Random();
		if(world.provider.getDimensionType() != DimensionType.OVERWORLD && world.provider.getDimensionType() != DimensionType.NETHER)
			return;
		
		for(int id : PVJWorldGen.dimensionBlacklist)
			if(world.provider == DimensionManager.getProvider(id))
				return;
		
		int x = chunkX * 16 + 8;
		int z = chunkZ * 16 + 8;
		
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
			for(BlockPos position : BlockPos.getAllInBoxMutable(x - 6, y - 28, z - 6, x + 6, y + 40, z + 6))
			{	
				if(!world.canSeeSky(position) && world.getBlockState(position).getBlock() instanceof BlockStone)
				{
					for(EnumFacing facing : EnumFacing.VALUES)
					{
						if(world.isAirBlock(position.offset(facing)) && random.nextInt(9) < 3)
						{
							if(facing != EnumFacing.UP)
							{
								world.setBlockState(position.offset(facing), Blocks.VINE.getDefaultState().withProperty(BlockVine.getPropertyFor(facing.getOpposite()), true));
								break;
							}
						}
					}
				}
		}
		}
	}
}
