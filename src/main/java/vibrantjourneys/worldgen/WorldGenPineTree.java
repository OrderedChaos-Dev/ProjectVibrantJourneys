package vibrantjourneys.worldgen;

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

public class WorldGenPineTree extends WorldGenAbstractTree
{
    private static final IBlockState TRUNK = PVJBlocks.pine_log.getDefaultState();
    private static final IBlockState LEAF = PVJBlocks.pine_leaves.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));

    public WorldGenPineTree(boolean notify)
    {
        super(notify);
    }

    public boolean generate(World world, Random rand, BlockPos position)
    {
        int height = 6 + rand.nextInt(3);
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
                        	if(branch % 2 == 0 && y1 > j)
                        	{
                        		EnumFacing facing = EnumFacing.Plane.HORIZONTAL.random(rand);
                        		int branchX = position.getX() + facing.getFrontOffsetX();
                        		int branchZ = position.getZ() + facing.getFrontOffsetZ();
                        		pos =  new BlockPos(branchX, y, branchZ);
                                if (state.getBlock().isAir(state, world, pos) || state.getBlock().isLeaves(state, world, pos))
                                {
                                	this.setBlockAndNotifyAdequately(world, pos, TRUNK.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.fromFacingAxis(facing.getAxis())));
                                	
                                	for(int k = -1; k <= 1; k++)
                                	{
                                		for(int p = -1; p <= 1; p++)
                                		{
                                			if(!(Math.abs(k) == Math.abs(p)))
                                			{
                                				BlockPos leafPos = new BlockPos(branchX + k, y, branchZ + p);
                                				state = world.getBlockState(leafPos);
                                                if (state.getBlock().canBeReplacedByLeaves(state, world, leafPos))
                                                {
                                                	this.setBlockAndNotifyAdequately(world, leafPos, LEAF);
                                                }
                                			}
                                		}
                                	}
                                	
                                    if (state.getBlock().canBeReplacedByLeaves(state, world, pos.up()))
                                    {
                                    	this.setBlockAndNotifyAdequately(world, pos.up(), LEAF);
                                    }
                                    if (state.getBlock().canBeReplacedByLeaves(state, world, pos.down()))
                                    {
                                    	this.setBlockAndNotifyAdequately(world, pos.down(), LEAF);
                                    }
                                }
                            	for(int k = -1; k <= 1; k++)
                            	{
                            		for(int p = -1; p <= 1; p++)
                            		{
                        				BlockPos leafPos = new BlockPos(position.getX() + k, y, position.getZ() + p);
                        				state = world.getBlockState(leafPos);
                                        if (state.getBlock().canBeReplacedByLeaves(state, world, leafPos))
                                        {
                                        	this.setBlockAndNotifyAdequately(world, leafPos, LEAF);
                                        }
                            		}
                            	}
                        	}
                        	else
                        	{
                        		if(i == 0 || rand.nextInt(3) == 0)
                        		{
                                	for(int k = -1; k <= 1; k++)
                                	{
                                		for(int p = -1; p <= 1; p++)
                                		{
                                			if(!(Math.abs(k) == Math.abs(p)))
                                			{
                                				BlockPos leafPos = new BlockPos(pos.getX() + k, y, pos.getZ() + p);
                                				state = world.getBlockState(leafPos);
                                                if (state.getBlock().canBeReplacedByLeaves(state, world, leafPos))
                                                {
                                                	this.setBlockAndNotifyAdequately(world, leafPos, LEAF);
                                                }
                                			}
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
}