package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.blocks.plant.BlockShortGrass;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.init.PVJWorldGen;

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
		
		for(int id : PVJWorldGen.dimensionBlacklist)
			if(world.provider == DimensionManager.getProvider(id))
				return;
		
		ChunkPos chunkPos = world.getChunk(chunkX, chunkZ).getPos();
		Biome biome = world.getBiomeForCoordsBody(chunkPos.getBlock(0, 0, 0));
		
		if(biome == Biomes.RIVER)
		{
			for(int i = 0; i < frequency; i++)
			{
		        int xPos = random.nextInt(16) + 8;
		        int zPos = random.nextInt(16) + 8;
		        int y = world.getHeight(chunkPos.getBlock(0, 0, 0).add(xPos, 0, zPos)).getY() + random.nextInt(4) - random.nextInt(4);
		        BlockPos pos = chunkPos.getBlock(0, 0, 0).add(xPos, y, zPos);
		        IBlockState state = world.getBlockState(pos.down());
				if(state.getBlock().canSustainPlant(state, world, pos.down(), EnumFacing.UP, Blocks.TALLGRASS))
				{
					int model = random.nextInt(7);
					Block block = random.nextBoolean() ? Blocks.TALLGRASS : PVJBlocks.short_grass;
					if(world.isAirBlock(pos))
					{
						if(block == PVJBlocks.short_grass)
							world.setBlockState(pos, block.getDefaultState().withProperty(BlockShortGrass.MODEL, model));
						else
							world.setBlockState(pos, block.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.GRASS));
					}
				}
			}
		}
	}
	
	
}
