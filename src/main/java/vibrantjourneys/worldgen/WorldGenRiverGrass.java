package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.blocks.plant.BlockShortGrass;
import vibrantjourneys.init.PVJBlocks;

public class WorldGenRiverGrass implements IWorldGenerator
{
	private int frequency;
	
	public WorldGenRiverGrass(int frequency)
	{
		this.frequency = frequency;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		if(world.provider.getDimensionType() != DimensionType.OVERWORLD && world.provider.getDimensionType() != DimensionType.NETHER)
			return;
		
		int x = chunkX * 16 + 8;
		int z = chunkZ * 16 + 8;
		
		Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 0, z));
		if(biome == Biomes.RIVER)
		{
			BlockPos pos = world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z));
			int xPos = pos.getX();
			int yPos = pos.getY();
			int zPos = pos.getZ();
			
			for(BlockPos position : BlockPos.getAllInBoxMutable(new BlockPos(xPos - 7, yPos - 10, zPos - 7), new BlockPos(xPos + 7, yPos + 10, zPos + 7)))
			{	
				IBlockState state = world.getBlockState(position.down());
				if(state.getBlock().canSustainPlant(state, world, position.down(), EnumFacing.UP, Blocks.TALLGRASS))
				{
					if(random.nextInt(100) < frequency)
					{
						int model = random.nextInt(7);
						Block block = random.nextBoolean() ? Blocks.TALLGRASS : PVJBlocks.short_grass;
						if(random.nextInt(2) == 0)
						{
							if(world.isAirBlock(position))
							{
								if(block == PVJBlocks.short_grass)
									world.setBlockState(position, block.getDefaultState().withProperty(BlockShortGrass.MODEL, model));
								else
									world.setBlockState(position, block.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.GRASS));
							}

						}
					}
				}
			}
		}
	}
	
	
}
