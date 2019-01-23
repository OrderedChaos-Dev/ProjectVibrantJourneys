package vibrantjourneys.worldgen.feature;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import vibrantjourneys.blocks.wood.BlockPVJLeaves;
import vibrantjourneys.blocks.wood.BlockPVJSapling;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.util.EnumLeafType;
import vibrantjourneys.util.EnumWoodType;

public class WorldGenPalmTree extends WorldGenAbstractTree
{
    private static final IBlockState LOG = PVJBlocks.LOGS.get(EnumWoodType.PALM.getID()).getDefaultState();
    
    private static final IBlockState LEAF = PVJBlocks.LEAVES.get(EnumLeafType.PALM.getID()).getDefaultState()
    		.withProperty(BlockPVJLeaves.CHECK_DECAY, Boolean.valueOf(false));
    
    private static final IBlockState COCONUT = PVJBlocks.coconut.getDefaultState();
    
	public WorldGenPalmTree()
	{
		super(true);
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position)
	{
        int height = rand.nextInt(4) + rand.nextInt(4) + 3;
        boolean flag = true;

        if (position.getY() >= 1 && position.getY() + height + 1 <= 256)
        {
            for (int j = position.getY(); j <= position.getY() + 1 + height; ++j)
            {
                int k = 1;

                if (j == position.getY())
                {
                    k = 0;
                }

                if (j >= position.getY() + 1 + height - 2)
                {
                    k = 2;
                }

                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                for (int l = position.getX() - k; l <= position.getX() + k && flag; ++l)
                {
                    for (int i1 = position.getZ() - k; i1 <= position.getZ() + k && flag; ++i1)
                    {
                        if (j >= 0 && j < 256)
                        {
                            if (!this.isReplaceable(worldIn,blockpos$mutableblockpos.setPos(l, j, i1)))
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
                IBlockState state = worldIn.getBlockState(down);
                boolean isSoil = state.getBlock()
                		.canSustainPlant(state, worldIn, down, net.minecraft.util.EnumFacing.UP,
                				(BlockPVJSapling)PVJBlocks.SAPLINGS.get(EnumLeafType.PALM.getID()))
                		|| state.getBlock() == Blocks.SAND;

                if (isSoil && position.getY() < worldIn.getHeight() - height - 1)
                {
                    state.getBlock().onPlantGrow(state, worldIn, down, position);
                    EnumFacing enumfacing = EnumFacing.Plane.HORIZONTAL.random(rand);
                    
                    int x = position.getX();
                    int y = position.getY();
                    int z = position.getZ();
                    
                    int trunk = height - rand.nextInt(4) - 2;
                    BlockPos pos1 = null;
                    for(int i = 0; i < height; i++)
                    {
                    	int y1 = y + i;

                    	if(i > trunk)
                    	{
                    		x += enumfacing.getXOffset();
                    		z += enumfacing.getZOffset();
                    	}

                    	BlockPos blockpos = new BlockPos(x, y1, z);
                    	state = worldIn.getBlockState(blockpos);
                    	
                        if (state.getBlock().isAir(state, worldIn, blockpos) || state.getBlock().isLeaves(state, worldIn, blockpos))
                        {
                        	this.setBlockAndNotifyAdequately(worldIn, blockpos, LOG);
                        	if(i > trunk)
                        	{
                        		if(rand.nextInt(2) == 0)
                        		{
                                    if (state.getBlock().isAir(state, worldIn, blockpos.up()) || state.getBlock().isLeaves(state, worldIn, blockpos.up()))
                                    {
                                    	this.setBlockAndNotifyAdequately(worldIn, blockpos.up(), LOG);
                                    }
                        		}
                        	}
                        }
                        if(i == height - 1)
                        	pos1 = new BlockPos(x, y1 + 1, z);
                    }
                    if (state.getBlock().isAir(state, worldIn, pos1) || state.getBlock().isLeaves(state, worldIn, pos1))
                    {
                    	this.setBlockAndNotifyAdequately(worldIn, pos1, LOG);
                    }
                    if (state.getBlock().isAir(state, worldIn, pos1.up()) || state.getBlock().isLeaves(state, worldIn, pos1.up()))
                    {
                    	this.setBlockAndNotifyAdequately(worldIn, pos1.up(), LOG);
                    }
                    if (state.getBlock().isAir(state, worldIn, pos1.up(2)) || state.getBlock().isLeaves(state, worldIn, pos1.up(2)))
                    {
                    	this.setBlockAndNotifyAdequately(worldIn, pos1.up(2), LEAF);
                    }
                    for(int xOffset = -2; xOffset <= 2; xOffset++)
                    {
                    	for(int zOffset = -2; zOffset <= 2; zOffset++)
                    	{
                			BlockPos leafpos = new BlockPos(pos1.getX() + xOffset, pos1.getY() + 1, pos1.getZ() + zOffset);
                			if(!leafpos.equals(pos1))
                			{
                    			state = worldIn.getBlockState(leafpos);
                    			if(Math.abs(xOffset) == 2 || Math.abs(zOffset) == 2)
                    			{
                                    if (state.getBlock().isAir(state, worldIn, leafpos) || state.getBlock().isLeaves(state, worldIn, leafpos))
                                    {
                                    	if(rand.nextInt(3) == 0 && (Math.abs(xOffset) != Math.abs(zOffset)))
                                    	{
                                    		this.setBlockAndNotifyAdequately(worldIn, leafpos, LEAF);
                                            if (state.getBlock().isAir(state, worldIn, leafpos.down()) || state.getBlock().isLeaves(state, worldIn, leafpos.down()))
                                            {
                                            	if(rand.nextInt(7) == 0)
                                            	{
                                            		this.setBlockAndNotifyAdequately(worldIn, leafpos.down(), COCONUT);
                                            	}
                                            }
                                    	}
                                    }
                    			}
                    			else
                    			{
                                    if (state.getBlock().isAir(state, worldIn, leafpos) || state.getBlock().isLeaves(state, worldIn, leafpos))
                                    {
                                    	this.setBlockAndNotifyAdequately(worldIn, leafpos, LEAF);
                                        if (state.getBlock().isAir(state, worldIn, leafpos.down()) || state.getBlock().isLeaves(state, worldIn, leafpos.down()))
                                        {
                                        	if(rand.nextInt(7) == 0)
                                        	{
                                        		this.setBlockAndNotifyAdequately(worldIn, leafpos.down(), COCONUT);
                                        	}
                                        }
                                    }
                    			}
                			}
                    	}
                    }
                    
                    for(int i = 0; i < rand.nextInt(2) + 1; i++)
                    {
            			BlockPos leafpos = new BlockPos(pos1.getX(), pos1.getY() + 1- i, pos1.getZ()).west(2 + i);
            			state = worldIn.getBlockState(leafpos);
            			
                        if (state.getBlock().isAir(state, worldIn, leafpos) || state.getBlock().isLeaves(state, worldIn, leafpos))
                        {
                        	this.setBlockAndNotifyAdequately(worldIn, leafpos, LEAF);
                        }
                        if (state.getBlock().isAir(state, worldIn, leafpos.down()) || state.getBlock().isLeaves(state, worldIn, leafpos.down()))
                        {
                        	this.setBlockAndNotifyAdequately(worldIn, leafpos.down(), LEAF);
                        }
                    }
                    for(int i = 0; i < rand.nextInt(2) + 1; i++)
                    {
            			BlockPos leafpos = new BlockPos(pos1.getX(), pos1.getY() + 1 - i, pos1.getZ()).east(2 + i);
            			state = worldIn.getBlockState(leafpos);
            			
                        if (state.getBlock().isAir(state, worldIn, leafpos) || state.getBlock().isLeaves(state, worldIn, leafpos))
                        {
                        	this.setBlockAndNotifyAdequately(worldIn, leafpos, LEAF);
                        }
                        if (state.getBlock().isAir(state, worldIn, leafpos.down()) || state.getBlock().isLeaves(state, worldIn, leafpos.down()))
                        {
                        	this.setBlockAndNotifyAdequately(worldIn, leafpos.down(), LEAF);
                        }
                    }
                    for(int i = 0; i < rand.nextInt(2) + 1; i++)
                    {
            			BlockPos leafpos = new BlockPos(pos1.getX(), pos1.getY() + 1 - i, pos1.getZ()).north(2 + i);
            			state = worldIn.getBlockState(leafpos);
            			
                        if (state.getBlock().isAir(state, worldIn, leafpos) || state.getBlock().isLeaves(state, worldIn, leafpos))
                        {
                        	this.setBlockAndNotifyAdequately(worldIn, leafpos, LEAF);
                        }
                        if (state.getBlock().isAir(state, worldIn, leafpos.down()) || state.getBlock().isLeaves(state, worldIn, leafpos.down()))
                        {
                        	this.setBlockAndNotifyAdequately(worldIn, leafpos.down(), LEAF);
                        }
                    }
                    for(int i = 0; i < rand.nextInt(2) + 1; i++)
                    {
            			BlockPos leafpos = new BlockPos(pos1.getX(), pos1.getY() + 1 - i, pos1.getZ()).south(2 + i);
            			state = worldIn.getBlockState(leafpos);
            			
                        if (state.getBlock().isAir(state, worldIn, leafpos) || state.getBlock().isLeaves(state, worldIn, leafpos))
                        {
                        	this.setBlockAndNotifyAdequately(worldIn, leafpos, LEAF);
                        }
                        if (state.getBlock().isAir(state, worldIn, leafpos.down()) || state.getBlock().isLeaves(state, worldIn, leafpos.down()))
                        {
                        	this.setBlockAndNotifyAdequately(worldIn, leafpos.down(), LEAF);
                        }
                    }
                    
                    return true;
                }
            }
        }
		return false;
	}
}
