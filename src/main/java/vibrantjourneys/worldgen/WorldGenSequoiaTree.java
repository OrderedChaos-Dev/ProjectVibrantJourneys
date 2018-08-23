package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import vibrantjourneys.blocks.BlockPVJLeaves;
import vibrantjourneys.init.PVJBlocks;

public class WorldGenSequoiaTree extends WorldGenHugeTrees
{
    private static final IBlockState LOG = PVJBlocks.redwood_log.getDefaultState();
    
    private static final IBlockState LEAF = PVJBlocks.redwood_leaves.getDefaultState()
    		.withProperty(BlockPVJLeaves.CHECK_DECAY, Boolean.valueOf(false));
    
    
    public WorldGenSequoiaTree(boolean notify, int baseHeightIn, int extraRandomHeightIn)
    {
        super(notify, baseHeightIn, extraRandomHeightIn, LOG, LEAF);
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        int i = this.getHeight(rand);
        if (!this.ensureGrowable(worldIn, rand, position, i))
        {
            return false;
        }
        else
        {
            this.createCrown(worldIn, position.up(i), 0, rand);
            for (int j = 0; j < i; ++j)
            {
                if (isAirLeaves(worldIn, position.up(j)))
                {
                    this.setBlockAndNotifyAdequately(worldIn, position.up(j), this.woodMetadata);
                }

                if (j < i - 1)
                {
                    if (isAirLeaves(worldIn, position.add(1, j, 0)))
                    {
                        this.setBlockAndNotifyAdequately(worldIn, position.add(1, j, 0), this.woodMetadata);
                    }

                    if (isAirLeaves(worldIn, position.add(1, j, 1)))
                    {
                        this.setBlockAndNotifyAdequately(worldIn, position.add(1, j, 1), this.woodMetadata);
                    }


                    if (isAirLeaves(worldIn, position.add(0, j, 1)))
                    {
                        this.setBlockAndNotifyAdequately(worldIn, position.add(0, j, 1), this.woodMetadata);
                    }
                }
            }

            for (int i2 = 0; i2 < i; ++i2)
            {
                BlockPos blockpos = position.up(i2);

                if (this.isAirLeaves(worldIn,blockpos))
                {
                    this.setBlockAndNotifyAdequately(worldIn, blockpos, this.woodMetadata);
                }

                if (i2 < i - 1)
                {
                    BlockPos blockpos1 = blockpos.east();

                    if (this.isAirLeaves(worldIn,blockpos1))
                    {
                        this.setBlockAndNotifyAdequately(worldIn, blockpos1, this.woodMetadata);
                    }

                    BlockPos blockpos2 = blockpos.south().east();

                    if (this.isAirLeaves(worldIn,blockpos2))
                    {
                        this.setBlockAndNotifyAdequately(worldIn, blockpos2, this.woodMetadata);
                    }

                    BlockPos blockpos3 = blockpos.south();

                    if (this.isAirLeaves(worldIn,blockpos3))
                    {
                        this.setBlockAndNotifyAdequately(worldIn, blockpos3, this.woodMetadata);
                    }
                }
                //forming the logs around the base, incredibly painful to write
                if(i2 == 0)
                {
                	//inner layer
                	for(int ilike = -2; ilike < 2; ilike++)
                	{
                		int height = 3 + rand.nextInt(3);
                		for(int tacos = 0; tacos < height; tacos++)
                		{
                            if (this.isAirLeaves(worldIn, blockpos.north().west(ilike).up(tacos)))
                            {
                                this.setBlockAndNotifyAdequately(worldIn, blockpos.north().west(ilike).up(tacos), this.woodMetadata);
                            }
                		}
                		height = 3 + rand.nextInt(3);
                		for(int sausages = 0; sausages < height; sausages++)
                		{
                            if (this.isAirLeaves(worldIn, blockpos.south(2).west(ilike).up(sausages)))
                            {
                                this.setBlockAndNotifyAdequately(worldIn, blockpos.south(2).west(ilike).up(sausages), this.woodMetadata);
                            }
                		}
                	}
                	for(int jugs = 0; jugs < 2; jugs++)
                	{
                		int height = 3 + rand.nextInt(3);
                		for(int and = 0; and < height; and++)
                		{
                            if (this.isAirLeaves(worldIn, blockpos.west().south(jugs).up(and)))
                            {
                                this.setBlockAndNotifyAdequately(worldIn, blockpos.west().south(jugs).up(and), this.woodMetadata);
                            }
                		}
                		
                		height = 3 + rand.nextInt(3);
                		for(int buns = 0; buns < height; buns++)
                		{
                            if (this.isAirLeaves(worldIn, blockpos.east(2).south(jugs).up(buns)))
                            {
                                this.setBlockAndNotifyAdequately(worldIn, blockpos.east(2).south(jugs).up(buns), this.woodMetadata);
                            }
                		}
                	}
                	
                	//outer layer
                	for(int l = 0; l < 2; l++)
                	{
                		int height = 1 + rand.nextInt(3);
                		for(int g = 0; g < height; g++)
                		{
                            if (this.isAirLeaves(worldIn, blockpos.west(2).south(l).up(g)))
                            {
                                this.setBlockAndNotifyAdequately(worldIn, blockpos.west(2).south(l).up(g), this.woodMetadata);
                            }
                		}
                		
                		height = 1 + rand.nextInt(3);
                		for(int b = 0; b < height; b++)
                		{
                            if (this.isAirLeaves(worldIn, blockpos.east(3).south(l).up(b)))
                            {
                                this.setBlockAndNotifyAdequately(worldIn, blockpos.east(3).south(l).up(b), this.woodMetadata);
                            }
                		}
                		
                		height = 1 + rand.nextInt(3);
                		for(int t = 0; t < height; t++)
                		{
                            if (this.isAirLeaves(worldIn, blockpos.north(2).east(l).up(t)))
                            {
                                this.setBlockAndNotifyAdequately(worldIn, blockpos.north(2).east(l).up(t), this.woodMetadata);
                            }
                		}
                		
                		height = 1 + rand.nextInt(3);
                		for(int pride = 0; pride < height; pride++)
                		{
                            if (this.isAirLeaves(worldIn, blockpos.south(3).east(l).up(pride)))
                            {
                                this.setBlockAndNotifyAdequately(worldIn, blockpos.south(3).east(l).up(pride), this.woodMetadata);
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