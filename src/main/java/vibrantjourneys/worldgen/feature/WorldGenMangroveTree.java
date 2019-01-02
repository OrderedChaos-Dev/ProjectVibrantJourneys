package vibrantjourneys.worldgen.feature;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import vibrantjourneys.blocks.wood.BlockPVJSapling;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.util.EnumLeafType;
import vibrantjourneys.util.EnumWoodType;

public class WorldGenMangroveTree extends WorldGenAbstractTree
{
	private static final IBlockState LOG = PVJBlocks.LOGS.get(EnumWoodType.MANGROVE.getID()).getDefaultState();
	private static final IBlockState LEAVES = PVJBlocks.LEAVES.get(EnumLeafType.MANGROVE.getID()).getDefaultState();
	
	public WorldGenMangroveTree()
	{
		super(false);
	}
	
	@Override
	public boolean generate(World world, Random rand, BlockPos pos)
	{
        int height = 6 + rand.nextInt(3);
        boolean flag = true;

        if (pos.getY() >= 1 && pos.getY() + height + 1 <= 256)
        {
            for (int j = pos.getY(); j <= pos.getY() + 1 + height; ++j)
            {
                int k = 1;

                if (j == pos.getY())
                {
                    k = 0;
                }

                if (j >= pos.getY() + 1 + height - 2)
                {
                    k = 2;
                }

                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                for (int l = pos.getX() - k; l <= pos.getX() + k && flag; ++l)
                {
                    for (int i1 = pos.getZ() - k; i1 <= pos.getZ() + k && flag; ++i1)
                    {
                        if (j >= 0 && j < 256)
                        {
                            if (!this.isReplaceable(world,blockpos$mutableblockpos.setPos(l, j, i1)))
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
                BlockPos down = pos.down();
                IBlockState state = world.getBlockState(down);
                boolean isSoil = state.getBlock()
                		.canSustainPlant(state, world, down, net.minecraft.util.EnumFacing.UP,
                				(BlockPVJSapling)PVJBlocks.SAPLINGS.get(EnumLeafType.MANGROVE.getID()))
                		|| state.getMaterial() == Material.WATER || state.getBlock() == Blocks.SAND;
                
                if (isSoil && pos.getY() < world.getHeight() - height - 1)
                {
                	int rootHeight = rand.nextInt(2) + 1;
        			BlockPos posRoot = pos.up(rootHeight - 1);
        			
        			BlockPos topBlock = posRoot;
                	for(int i = rootHeight; i <= height; i++)
                	{
                		BlockPos posA;
                		if(i == rootHeight)
                		{
                			BlockPos pos1 = posRoot.west(2);
                			for(; isWaterOrAir(world, pos1); pos1 = pos1.down())
                			{
                				this.setBlockAndNotifyAdequately(world, pos1, LOG);
                			}
                			BlockPos pos2 = posRoot.east(2);
                			for(; isWaterOrAir(world, pos2); pos2 = pos2.down())
                			{
                				this.setBlockAndNotifyAdequately(world, pos2, LOG);
                			}
                			BlockPos pos3 = posRoot.north(2);
                			for(; isWaterOrAir(world, pos3); pos3 = pos3.down())
                			{
                				this.setBlockAndNotifyAdequately(world, pos3, LOG);
                			}
                			BlockPos pos4 = posRoot.south(2);
                			for(; isWaterOrAir(world, pos4); pos4 = pos4.down())
                			{
                				this.setBlockAndNotifyAdequately(world, pos4, LOG);
                			}
                		}
                		if(i == rootHeight + 1)
                		{
                			BlockPos pos1 = posRoot.up();
                            
                            pos1 = posRoot.up().west();
                			state = world.getBlockState(pos1);
                            if (state.getBlock().isAir(state, world, pos1) || state.getBlock().isLeaves(state, world, pos1))
                            {
                            	this.setBlockAndNotifyAdequately(world, pos1, LOG);
                            	if(rand.nextInt(3) != 0)
                            	{
                                    pos1 = posRoot.up().west().down();
                        			state = world.getBlockState(pos1);
                                    if (state.getBlock().isAir(state, world, pos1) || state.getBlock().isLeaves(state, world, pos1))
                                    {
                                    	this.setBlockAndNotifyAdequately(world, pos1, LOG);
                                    }
                            	}
                            	if(rand.nextInt(3) != 0)
                            	{
                                    pos1 = posRoot.up().west().up();
                        			state = world.getBlockState(pos1);
                                    if (state.getBlock().isAir(state, world, pos1) || state.getBlock().isLeaves(state, world, pos1))
                                    {
                                    	this.setBlockAndNotifyAdequately(world, pos1, LOG);
                                    }
                            	}
                            }
                            pos1 = posRoot.up().east();
                			state = world.getBlockState(pos1);
                            if (state.getBlock().isAir(state, world, pos1) || state.getBlock().isLeaves(state, world, pos1))
                            {
                            	this.setBlockAndNotifyAdequately(world, pos1, LOG);
                            	if(rand.nextInt(3) != 0)
                            	{
                                    pos1 = posRoot.up().west().down();
                        			state = world.getBlockState(pos1);
                                    if (state.getBlock().isAir(state, world, pos1) || state.getBlock().isLeaves(state, world, pos1))
                                    {
                                    	this.setBlockAndNotifyAdequately(world, pos1, LOG);
                                    }
                            	}
                            	if(rand.nextInt(3) != 0)
                            	{
                                    pos1 = posRoot.up().west().up();
                        			state = world.getBlockState(pos1);
                                    if (state.getBlock().isAir(state, world, pos1) || state.getBlock().isLeaves(state, world, pos1))
                                    {
                                    	this.setBlockAndNotifyAdequately(world, pos1, LOG);
                                    }
                            	}
                            }
                            pos1 = posRoot.up().north();
                			state = world.getBlockState(pos1);
                            if (state.getBlock().isAir(state, world, pos1) || state.getBlock().isLeaves(state, world, pos1))
                            {
                            	this.setBlockAndNotifyAdequately(world, pos1, LOG);
                            	if(rand.nextInt(3) != 0)
                            	{
                                    pos1 = posRoot.up().west().down();
                        			state = world.getBlockState(pos1);
                                    if (state.getBlock().isAir(state, world, pos1) || state.getBlock().isLeaves(state, world, pos1))
                                    {
                                    	this.setBlockAndNotifyAdequately(world, pos1, LOG);
                                    }
                            	}
                            	if(rand.nextInt(3) != 0)
                            	{
                                    pos1 = posRoot.up().west().up();
                        			state = world.getBlockState(pos1);
                                    if (state.getBlock().isAir(state, world, pos1) || state.getBlock().isLeaves(state, world, pos1))
                                    {
                                    	this.setBlockAndNotifyAdequately(world, pos1, LOG);
                                    }
                            	}
                            }
                            pos1 = posRoot.up().south();
                			state = world.getBlockState(pos1);
                            if (state.getBlock().isAir(state, world, pos1) || state.getBlock().isLeaves(state, world, pos1))
                            {
                            	this.setBlockAndNotifyAdequately(world, pos1, LOG);
                            	if(rand.nextInt(3) != 0)
                            	{
                                    pos1 = posRoot.up().west().down();
                        			state = world.getBlockState(pos1);
                                    if (state.getBlock().isAir(state, world, pos1) || state.getBlock().isLeaves(state, world, pos1))
                                    {
                                    	this.setBlockAndNotifyAdequately(world, pos1, LOG);
                                    }
                            	}
                            	if(rand.nextInt(3) != 0)
                            	{
                                    pos1 = posRoot.up().west().up();
                        			state = world.getBlockState(pos1);
                                    if (state.getBlock().isAir(state, world, pos1) || state.getBlock().isLeaves(state, world, pos1))
                                    {
                                    	this.setBlockAndNotifyAdequately(world, pos1, LOG);
                                    }
                            	}
                            }
                            
                		}
                		
            			posA = pos.up(i);
            			state = world.getBlockState(posA);
                        if (state.getBlock().isAir(state, world, posA) || state.getBlock().isLeaves(state, world, posA))
                        {
                        	this.setBlockAndNotifyAdequately(world, posA, LOG);
                        }
                        topBlock = posA;
                	}
                	topBlock = topBlock.add(0, 1, 0);
        			state = world.getBlockState(topBlock);
                    if (state.getBlock().isAir(state, world, topBlock) || state.getBlock().isLeaves(state, world, topBlock))
                    {
                    	this.setBlockAndNotifyAdequately(world, topBlock, LEAVES);
                    }
                    
                	int leafHeight = 3 + rand.nextInt(2);
                	for(int i = 0; i < leafHeight; i++)
                	{
                		BlockPos leafPos = topBlock.down(i + 1);
                		
                		int xOffset = 2, zOffset = 2;
                		if(i == 0 || i == leafHeight - 1)
                		{
                			xOffset = 1;
                			zOffset = 1;
                		}
                		
                		for(int j = -xOffset; j <= xOffset; j++)
                		{
                    		for(int k = -zOffset; k <= zOffset; k++)
                    		{
                    			int x = leafPos.getX() + j;
                    			int z = leafPos.getZ() + k;
                    			BlockPos newpos = new BlockPos(x, leafPos.getY(), z);
                    			state = world.getBlockState(newpos);
                                if (state.getBlock().isAir(state, world, newpos) || state.getBlock().isLeaves(state, world, newpos))
                                {
                                	if(Math.abs(j) == Math.abs(k))
                                	{
                                		if(rand.nextInt(2) == 0)
                                			this.setBlockAndNotifyAdequately(world, newpos, LEAVES);
                                	}
                                	this.setBlockAndNotifyAdequately(world, newpos, LEAVES);
                                }
                    		}
                		}
                	}
                }
                return true;
            }
        }
		return false;
	}
	
	private boolean isWaterOrAir(World world, BlockPos pos)
	{
		if(world.getBlockState(pos).getMaterial() == Material.WATER)
			return true;
		else if(world.isAirBlock(pos))
			return true;
		
		return false;
	}
}
