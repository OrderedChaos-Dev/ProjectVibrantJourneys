package vibrantjourneys.worldgen.feature;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import vibrantjourneys.blocks.wood.BlockPVJLeaves;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.util.EnumLeafType;
import vibrantjourneys.util.EnumWoodType;

public class WorldGenSequoiaTree extends WorldGenHugeTrees
{
    private static final IBlockState LOG = PVJBlocks.LOGS.get(EnumWoodType.REDWOOD.getID()).getDefaultState();
    
    private static final IBlockState LEAF = PVJBlocks.LEAVES.get(EnumLeafType.REDWOOD.getID()).getDefaultState()
    		.withProperty(BlockPVJLeaves.CHECK_DECAY, Boolean.valueOf(false));
    
    
    public WorldGenSequoiaTree(boolean notify, int baseHeightIn, int extraRandomHeightIn)
    {
        super(notify, baseHeightIn, extraRandomHeightIn, LOG, LEAF);
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos position)
    {
    	IBlockState BARK = PVJBlocks.redwood_bark.getDefaultState();
        int i = this.getHeight(rand);
        if (!this.ensureGrowable(world, rand, position, i))
        {
            return false;
        }
        else
        {
            this.createCrown(world, position.up(i), 0, rand);
            for (int j = 0; j < i; ++j)
            {
                if (isAirLeaves(world, position.up(j)))
                {
                    this.setBlockAndNotifyAdequately(world, position.up(j), this.woodMetadata);
                }

                if (j < i - 1)
                {
                    if (isAirLeaves(world, position.add(1, j, 0)))
                    {
                        this.setBlockAndNotifyAdequately(world, position.add(1, j, 0), this.woodMetadata);
                    }

                    if (isAirLeaves(world, position.add(1, j, 1)))
                    {
                        this.setBlockAndNotifyAdequately(world, position.add(1, j, 1), this.woodMetadata);
                    }


                    if (isAirLeaves(world, position.add(0, j, 1)))
                    {
                        this.setBlockAndNotifyAdequately(world, position.add(0, j, 1), this.woodMetadata);
                    }
                }
            }

            for (int i2 = 0; i2 < i; ++i2)
            {
                BlockPos blockpos = position.up(i2);

                if (this.isAirLeaves(world,blockpos))
                {
                    this.setBlockAndNotifyAdequately(world, blockpos, this.woodMetadata);
                }

                if (i2 < i - 1)
                {
                    BlockPos blockpos1 = blockpos.east();

                    if (this.isAirLeaves(world,blockpos1))
                    {
                        this.setBlockAndNotifyAdequately(world, blockpos1, this.woodMetadata);
                    }

                    BlockPos blockpos2 = blockpos.south().east();

                    if (this.isAirLeaves(world,blockpos2))
                    {
                        this.setBlockAndNotifyAdequately(world, blockpos2, this.woodMetadata);
                    }

                    BlockPos blockpos3 = blockpos.south();

                    if (this.isAirLeaves(world,blockpos3))
                    {
                        this.setBlockAndNotifyAdequately(world, blockpos3, this.woodMetadata);
                    }
                }
                //forming the logs around the base, incredibly painful to write
                if(i2 == 0)
                {
                	//inner layer
                	for(int ilike = -2; ilike < 2; ilike++)
                	{
                		int height = 3 + rand.nextInt(3);
                		int rootStart = 0;
                		BlockPos blockpos1 = blockpos.north().west(ilike);
                		while(world.getBlockState(blockpos1.up(rootStart)).getBlock().isReplaceable(world, blockpos1.up(rootStart)) || this.isAirLeaves(world, blockpos1.up(rootStart)))
                		{
                			rootStart--;
                			if(rootStart < -5)
                				break;
                		}
                		for(int tacos = rootStart; tacos < height; tacos++)
                		{
                            if (this.isAirLeaves(world, blockpos1.up(tacos)))
                            {
                                this.setBlockAndNotifyAdequately(world, blockpos1.up(tacos), BARK);
                            }
                		}
                		
                		height = 3 + rand.nextInt(3);
                		rootStart = 0;
                		BlockPos blockpos2 = blockpos.south(2).west(ilike);
                		while(world.getBlockState(blockpos2.up(rootStart)).getBlock().isReplaceable(world, blockpos2.up(rootStart)) || this.isAirLeaves(world, blockpos2.up(rootStart)))
                		{
                			rootStart--;
                			if(rootStart < -5)
                				break;
                		}
                		for(int sausages = rootStart; sausages < height; sausages++)
                		{
                            if (this.isAirLeaves(world, blockpos2.up(sausages)))
                            {
                                this.setBlockAndNotifyAdequately(world, blockpos2.up(sausages), BARK);
                            }
                		}
                	}
                	for(int jugs = 0; jugs < 2; jugs++)
                	{
                		int height = 3 + rand.nextInt(3);
                		int rootStart = 0;
                		BlockPos blockpos3 = blockpos.west().south(jugs);
                		while(world.getBlockState(blockpos3.up(rootStart)).getBlock().isReplaceable(world, blockpos3.up(rootStart)) || this.isAirLeaves(world, blockpos3.up(rootStart)))
                		{
                			rootStart--;
                			if(rootStart < -5)
                				break;
                		}
                		for(int and = rootStart; and < height; and++)
                		{
                            if (this.isAirLeaves(world, blockpos3.up(and)))
                            {
                                this.setBlockAndNotifyAdequately(world, blockpos3.up(and), BARK);
                            }
                		}
                		
                		height = 3 + rand.nextInt(3);
                		rootStart = 0;
                		BlockPos blockpos4 = blockpos.east(2).south(jugs);
                		while(world.getBlockState(blockpos4.up(rootStart)).getBlock().isReplaceable(world, blockpos4.up(rootStart)) || this.isAirLeaves(world, blockpos4.up(rootStart)))
                		{
                			rootStart--;
                			if(rootStart < -5)
                				break;
                		}
                		for(int buns = rootStart; buns < height; buns++)
                		{
                            if (this.isAirLeaves(world, blockpos4.up(buns)))
                            {
                                this.setBlockAndNotifyAdequately(world, blockpos4.up(buns), BARK);
                            }
                		}
                	}
                	
                	//outer layer
                	for(int l = 0; l < 2; l++)
                	{
                		int height = 1 + rand.nextInt(3);
                		int rootStart = 0;
                		BlockPos blockpos5 = blockpos.west(2).south(l);
                		while(world.getBlockState(blockpos5.up(rootStart)).getBlock().isReplaceable(world, blockpos5.up(rootStart)) || this.isAirLeaves(world, blockpos5.up(rootStart)))
                		{
                			rootStart--;
                			if(rootStart < -5)
                				break;
                		}
                		for(int g = rootStart; g < height; g++)
                		{
                            if (this.isAirLeaves(world, blockpos5.up(g)))
                            {
                                this.setBlockAndNotifyAdequately(world, blockpos5.up(g), BARK);
                            }
                		}
                		
                		height = 1 + rand.nextInt(3);
                		rootStart = 0;
                		BlockPos blockpos6 = blockpos.east(3).south(l);
                		while(world.getBlockState(blockpos6.up(rootStart)).getBlock().isReplaceable(world, blockpos6.up(rootStart)) || this.isAirLeaves(world, blockpos6.up(rootStart)))
                		{
                			rootStart--;
                			if(rootStart < -5)
                				break;
                		}
                		for(int b = rootStart; b < height; b++)
                		{
                            if (this.isAirLeaves(world, blockpos6.up(b)))
                            {
                                this.setBlockAndNotifyAdequately(world, blockpos6.up(b), BARK);
                            }
                		}
                		
                		height = 1 + rand.nextInt(3);
                		rootStart = 0;
                		BlockPos blockpos7 = blockpos.north(2).east(l);
                		while(world.getBlockState(blockpos7.up(rootStart)).getBlock().isReplaceable(world, blockpos7.up(rootStart)) || this.isAirLeaves(world, blockpos7.up(rootStart)))
                		{
                			rootStart--;
                			if(rootStart < -5)
                				break;
                		}
                		for(int t = rootStart; t < height; t++)
                		{
                            if (this.isAirLeaves(world, blockpos7.up(t)))
                            {
                                this.setBlockAndNotifyAdequately(world, blockpos7.up(t), BARK);
                            }
                		}
                		
                		height = 1 + rand.nextInt(3);
                		rootStart = 0;
                		BlockPos blockpos8 = blockpos.south(3).east(l);
                		while(world.getBlockState(blockpos8.up(rootStart)).getBlock().isReplaceable(world, blockpos8.up(rootStart)) || this.isAirLeaves(world, blockpos8.up(rootStart)))
                		{
                			rootStart--;
                			if(rootStart < -5)
                				break;
                		}
                		for(int pride = rootStart; pride < height; pride++)
                		{
                            if (this.isAirLeaves(world, blockpos8.up(pride)))
                            {
                                this.setBlockAndNotifyAdequately(world, blockpos8.up(pride), BARK);
                            }
                		}
                	}
                }
            }

            return true;
        }
    }

    private void createCrown(World worldIn, BlockPos pos, int p_150541_5_, Random rand)
    {
        int i = rand.nextInt(5) + (this.baseHeight - 5);
        int j = 0;
        int y = pos.getY();
        int x = pos.getX();
        int z = pos.getZ();

        for (int k = y - i; k <= y; ++k)
        {
            int l = y - k;
            int i1 = p_150541_5_ + MathHelper.floor((float)l / (float)i * 3.5F);
            this.growLeavesLayerStrict(worldIn, new BlockPos(x, k, z), i1 + (l > 0 && i1 == j && (k & 1) == 0 ? 1 : 0));
            j = i1;
        }
    }

    private boolean isAirLeaves(World world, BlockPos pos)
    {
        IBlockState state = world.getBlockState(pos);
        return state.getBlock().isAir(state, world, pos) || state.getBlock().isLeaves(state, world, pos);
    }
}