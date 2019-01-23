package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.blocks.plant.BlockShortGrass;
import vibrantjourneys.init.PVJWorldGen;

public class WorldGenShortGrass implements IWorldGenerator
{
	private Block block;
	private int frequency;
	private Biome[] biomes;
	
	public WorldGenShortGrass(Block block, int frequency, Biome... biomes)
	{
		this.block = block;
		this.frequency = frequency;
		this.biomes = biomes;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
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
			BlockPos pos = world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z));
			int xPos = pos.getX();
			int yPos = pos.getY();
			int zPos = pos.getZ();
			
			for(BlockPos position : BlockPos.getAllInBoxMutable(new BlockPos(xPos - 7, yPos - 40, zPos - 7), new BlockPos(xPos + 7, yPos + 40, zPos + 7)))
			{	
				IBlockState state = world.getBlockState(position);
				if(state.getBlock() instanceof BlockTallGrass && state.getValue(BlockTallGrass.TYPE) == BlockTallGrass.EnumType.GRASS)
				{
					if(random.nextInt(8) < frequency)
					{
						int model = random.nextInt(7);
						world.setBlockState(position, block.getDefaultState().withProperty(BlockShortGrass.MODEL, model));
					}
				}
			}
		}
	}
	
	
}
