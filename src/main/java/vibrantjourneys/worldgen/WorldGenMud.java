package vibrantjourneys.worldgen;

import java.util.Arrays;
import java.util.Random;

import com.google.common.base.Predicate;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.util.PVJConfig;

public class WorldGenMud implements IWorldGenerator
{
	private WorldGenMinable mudGen;
	private int maxHeight;
	private int frequency;
	private Biome[] biomes;
	
	public WorldGenMud(int frequency, Biome... biomes)
	{
		this.mudGen = new WorldGenMinable(PVJBlocks.mud.getDefaultState(), 11, new DirtPredicate());
		this.maxHeight = 70;
		this.frequency = (int)(frequency * (PVJConfig.global.stoneDepositsDensity / 100.0));
		this.biomes = biomes;
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		Random rand = new Random();
		int x = chunkX * 16 + 8;
		int z = chunkZ * 16 + 8;
		
		int xPos, yPos, zPos;
		
		Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 0, z));
		
		if(Arrays.asList(biomes).contains(biome))
		{
			for(int i = 0; i < frequency; i++)
			{
				xPos = x + rand.nextInt(5) -  + rand.nextInt(5);
				yPos = 55 + rand.nextInt(maxHeight);
				zPos = z + rand.nextInt(5) -  + rand.nextInt(5);
				
				this.mudGen.generate(world, rand, new BlockPos(xPos, yPos, zPos));
			}
		}
	}
	
    static class DirtPredicate implements Predicate<IBlockState>
    {
        private DirtPredicate()
        {
        }

        public boolean apply(IBlockState state)
        {
            if (state != null && (state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.GRASS))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
	
}
