package vibrantjourneys.worldgen.feature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenPlant extends WorldGenerator
{
    private BlockBush plant;

    public WorldGenPlant(Block plant)
    {
       this.plant = (BlockBush)plant;
    }
    
    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
    	IBlockState state = plant.getDefaultState();
        for (int i = 0; i < 10; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && blockpos.getY() < 255 && this.plant.canBlockStay(worldIn, blockpos, state))
            {
                worldIn.setBlockState(blockpos, state, 2);
            }
        }

        return true;
    }
}