package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.init.PVJWorldGen;
import vibrantjourneys.util.EnumStoneType;
import vibrantjourneys.util.PVJConfig;

public class WorldGenPillowBasalt implements IWorldGenerator
{
	private int frequency;
	
	public WorldGenPillowBasalt(int frequency)
	{
		this.frequency = (int)(frequency * (PVJConfig.global.stoneDepositsDensity / 100.0));
	}
	
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		int x = chunkX * 16 + 8 + rand.nextInt(8);
		int z = chunkZ * 16 + 8 + rand.nextInt(8);
		
		for(int id : PVJWorldGen.dimensionBlacklist)
			if(world.provider == DimensionManager.getProvider(id))
				return;
		
		Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 0, z));
		if(!BiomeDictionary.hasType(biome, Type.OCEAN))
			return;
		
		for(int i = 0; i < frequency; i++)
		{
			int y = 30 + rand.nextInt(15);
			BlockPos pos = new BlockPos(x, y, z);
			if(world.isSideSolid(pos, EnumFacing.UP))
			{
				if(world.getBlockState(pos.up()).getMaterial() == Material.WATER)
				{
					for(int up = 1; up < rand.nextInt(3) + 2; up++)
						this.formCircleLayer(world, pos.up(up), 4 - up);
					
					for(int p = 0; p <= 2; p++)
					{
						if(rand.nextBoolean())
						{
							BlockPos pos1 = pos.add(rand.nextInt(5) - rand.nextInt(5), 0, rand.nextInt(5) - rand.nextInt(5));
							for(int up = 1; up < rand.nextInt(3) + 2; up++)
								this.formCircleLayer(world, pos1.up(up), 4 - up);
						}
					}
					
					break;
				}
			}
		}
    }
	
	public void formCircleLayer(World world, BlockPos pos, int width)
	{
        int widthSq = width * width;

        for (int j = -width; j <= width + 1; ++j)
        {
            for (int k = -width; k <= width + 1; ++k)
            {
                int l = j - 1;
                int i1 = k - 1;

                if (j * j + k * k <= widthSq || l * l + i1 * i1 <= widthSq || j * j + i1 * i1 <= widthSq || l * l + k * k <= widthSq)
                {
                    BlockPos blockpos = pos.add(j, 0, k);
                    IBlockState state = world.getBlockState(blockpos);

                    if (state.getMaterial() == Material.WATER)
                    {
                       world.setBlockState(blockpos, PVJBlocks.STONES.get(EnumStoneType.BASALT.getID()).getDefaultState());
                    }
                }
            }
        }
	}
}