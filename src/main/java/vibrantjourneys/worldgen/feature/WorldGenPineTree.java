package vibrantjourneys.worldgen.feature;

import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.util.EnumLeafType;
import vibrantjourneys.util.EnumWoodType;

public class WorldGenPineTree extends WorldGenAbstractTree
{
    private static final IBlockState TRUNK = PVJBlocks.LOGS.get(EnumWoodType.PINE.getID()).getDefaultState();
    private static final IBlockState LEAF = PVJBlocks.LEAVES.get(EnumLeafType.PINE.getID()).getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));

    public WorldGenPineTree(boolean notify)
    {
        super(notify);
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos position)
    {
        int height = 9 + rand.nextInt(4);
        int j = 1 + rand.nextInt(2);
        int l = 3 + rand.nextInt(2);
        
        boolean flag = true;

        if (position.getY() >= 1 && position.getY() + height + 1 <= world.getHeight())
        {
            for (int i1 = position.getY(); i1 <= position.getY() + 1 + height && flag; ++i1)
            {
                int j1;

                if (i1 - position.getY() < j)
                {
                    j1 = 0;
                }
                else
                {
                    j1 = l;
                }

                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                for (int k1 = position.getX() - j1; k1 <= position.getX() + j1 && flag; ++k1)
                {
                    for (int l1 = position.getZ() - j1; l1 <= position.getZ() + j1 && flag; ++l1)
                    {
                        if (i1 >= 0 && i1 < world.getHeight())
                        {
                            IBlockState state = world.getBlockState(blockpos$mutableblockpos.setPos(k1, i1, l1));

                            if (!state.getBlock().isAir(state, world, blockpos$mutableblockpos.setPos(k1, i1, l1)) && !state.getBlock().isLeaves(state, world, blockpos$mutableblockpos.setPos(k1, i1, l1)))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                BlockPos down = position.down();
                IBlockState state = world.getBlockState(down);
                int p = 6 + rand.nextInt(2);

                if (state.getBlock().canSustainPlant(state, world, down, net.minecraft.util.EnumFacing.UP, (net.minecraft.block.BlockSapling)Blocks.SAPLING) && position.getY() < world.getHeight() - height - 1)
                {
                    state.getBlock().onPlantGrow(state, world, down, position);
                    int branch = 1;
                    
                    for(int i = 0; i <= height; i++)
                    {
                    	int y = position.getY() + height - i;
                    	int y1 = height - i;
                    	BlockPos pos = new BlockPos(position.getX(), y, position.getZ());
                    	state = world.getBlockState(pos);
                        if (state.getBlock().isAir(state, world, pos) || state.getBlock().isLeaves(state, world, pos))
                        {
                            this.setBlockAndNotifyAdequately(world, pos, TRUNK);
                    		if(i < p && i % 2 == 0)
                    		{
                    			this.growLeavesLayerStrict(world, pos, i < p / 2 ? 1 : 2);
                    		}
                        	if(branch % 2 == 0 && y1 > j)
                        	{
                        		EnumFacing facing = EnumFacing.Plane.HORIZONTAL.random(rand);
                        		int branchX = position.getX() + facing.getXOffset();
                        		int branchZ = position.getZ() + facing.getZOffset();
                        		pos =  new BlockPos(branchX, y, branchZ);
                                if (state.getBlock().isAir(state, world, pos) || state.getBlock().isLeaves(state, world, pos))
                                {
                                	this.setBlockAndNotifyAdequately(world, pos, TRUNK.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.fromFacingAxis(facing.getAxis())));
                                	for(EnumFacing f : EnumFacing.VALUES)
                                	{
                                		BlockPos pos1 = pos.offset(f);
                                		IBlockState state1 = world.getBlockState(pos1);
                                		if(state1.getBlock().canBeReplacedByLeaves(state1, world, pos1))
                                		{
                                			this.setBlockAndNotifyAdequately(world, pos1, LEAF);
                                		}
                                	}
                                }
                        	}
                        }
                    	branch++;
                    	if(i == 0)
                    	{
            				pos = pos.up();
            				state = world.getBlockState(pos);
                            if (state.getBlock().canBeReplacedByLeaves(state, world, pos))
                            {
                            	this.setBlockAndNotifyAdequately(world, pos, LEAF);
                            }
                    	}
                    }
                    
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }
    
    //stolen from WorldGenHugeTrees hehe
    protected void growLeavesLayerStrict(World worldIn, BlockPos layerCenter, int width)
    {
        int i = width * width;

        for (int j = -width; j <= width + 1; ++j)
        {
            for (int k = -width; k <= width + 1; ++k)
            {
                int l = j - 1;
                int i1 = k - 1;

                if (j * j + k * k <= i || l * l + i1 * i1 <= i || j * j + i1 * i1 <= i || l * l + k * k <= i)
                {
                    BlockPos blockpos = layerCenter.add(j, 0, k);
                    IBlockState state = worldIn.getBlockState(blockpos);

                    if (state.getBlock().isAir(state, worldIn, blockpos) || state.getBlock().isLeaves(state, worldIn, blockpos))
                    {
                        this.setBlockAndNotifyAdequately(worldIn, blockpos, LEAF);
                    }
                }
            }
        }
    }
}