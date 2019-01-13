package vibrantjourneys.worldgen.feature;

import java.util.Random;

import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;
import vibrantjourneys.blocks.wood.BlockPVJLeaves;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.util.EnumLeafType;
import vibrantjourneys.util.EnumWoodType;

public class WorldGenAspenTree extends WorldGenAbstractTree
{
    private static final IBlockState LOG = PVJBlocks.LOGS.get(EnumWoodType.ASPEN.getID()).getDefaultState();
    
    private static final IBlockState LEAF = PVJBlocks.LEAVES.get(EnumLeafType.ASPEN.getID()).getDefaultState()
    		.withProperty(BlockPVJLeaves.CHECK_DECAY, Boolean.valueOf(false));
    
	public WorldGenAspenTree(boolean notify)
	{
		super(notify);
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos position)
	{
		int yGen = position.getY();
		int height = 10 + rand.nextInt(4);
		int base = 5 + rand.nextInt(2);
		
		if(yGen >= 1 && yGen + height + 1 <= 256)
		{
			boolean hasSpace = true;
			BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
			
			for(int y = yGen; y <= yGen + height + 1 && hasSpace; y++)
			{
				int width = 2;
				
				for(int x = -width; x <= width && hasSpace; x++)
				{
					for(int z = -width; z <= width && hasSpace; z++)
					{
						if(y >= 0 && y < 256)
						{
							int xPos = position.getX() + x;
							int zPos = position.getZ() + z;
							if(!this.isReplaceable(world, pos.setPos(xPos, y, zPos)) && 
									!(world.getBlockState(pos.setPos(xPos, y, zPos)).getBlock() instanceof BlockTallGrass))
							{
								hasSpace = false;
							}
						}
						else
						{
							hasSpace = false;
						}
					}
				}
			}
			if(!hasSpace)
			{
				return false;
			}
			else
			{
				BlockPos down = position.down();
				IBlockState state = world.getBlockState(down);
				boolean isSoil = state.getBlock().canSustainPlant(state, world, down, EnumFacing.UP, (IPlantable) Blocks.SAPLING);
				
				if(isSoil && yGen + height + 1 <= 256)
				{
                	EnumFacing[] facings = new EnumFacing[] {EnumFacing.NORTH, EnumFacing.SOUTH, EnumFacing.EAST, EnumFacing.WEST};
                	
					state.getBlock().onPlantGrow(state, world, down, position);
					int lowerBranch = 4 + rand.nextInt(2);
					
					for(int i = 0; i <= height; i++)
					{
						int y = position.getY() + height - i;
						BlockPos logPos = new BlockPos(position.getX(), y, position.getZ());
						state = world.getBlockState(logPos);
                        if (state.getBlock().isAir(state, world, logPos) || state.getBlock().isLeaves(state, world, logPos))
                        {
                        	this.setBlockAndNotifyAdequately(world, logPos, LOG);
                        	if(height - i > height - base - 1)
                        	{
                        		this.genLeaves(world, logPos, rand, 1);
                        	}
                        }
                        if(i == 2)
                        {
                        	for(EnumFacing facing : facings)
                        	{
                        		int x = position.getX() + facing.getXOffset();
                        		int z = position.getZ() + facing.getZOffset();
                        		BlockPos branchPos = new BlockPos(x, y, z);
        						state = world.getBlockState(branchPos);
                                if (state.getBlock().isAir(state, world, branchPos) || state.getBlock().isLeaves(state, world, branchPos))
                                {
                                	this.setBlockAndNotifyAdequately(world, branchPos, LOG.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.fromFacingAxis(facing.getAxis())));
                                	this.genLeaves(world, branchPos, rand, 1);
                                }
                        	}
                        }
                        if(i == lowerBranch)
                        {
                        	for(EnumFacing facing : facings)
                        	{
                        		int x = position.getX();
                        		int z = position.getZ();
                        		int yPos = y;
                        		boolean shortBranch = false;
                        		
                        		for(int j = 0; j < 3; j++)
                        		{
                        			x += facing.getXOffset();
                        			z += facing.getZOffset();
                        			
                        			if(j == 2)
                        			{
                        				if(rand.nextBoolean())
                        				{
                        					shortBranch = true;
                        					yPos++;
                        				}
                        			}
                        			if(j == 3)
                        			{
                        				if(shortBranch)
                        					break;
                        				
                        				yPos++;
                        			}
                        			
                            		BlockPos branchPos = new BlockPos(x, yPos, z);
            						state = world.getBlockState(branchPos);
                                    if (state.getBlock().isAir(state, world, branchPos) || state.getBlock().isLeaves(state, world, branchPos))
                                    {
                                    	this.setBlockAndNotifyAdequately(world, branchPos, LOG.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.fromFacingAxis(facing.getAxis())));
                                    	this.genLeaves(world, branchPos, rand, 1);
                                    }
                        		}

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

	public void genLeaves(World world, BlockPos pos, Random rand, int radius)
	{
		for(int i = -radius; i <= radius; i++)
		{
			for(int j = -radius; j <= radius; j++)
			{
				for(int k = -radius; k <= radius; k++)
				{
					int x = pos.getX() + i;
					int y = pos.getY() + j;
					int z = pos.getZ() + k;
					BlockPos leafPos = new BlockPos(x, y, z);
					IBlockState state = world.getBlockState(leafPos);
					if(Math.abs(i) != Math.abs(k))
					{
	                    if(state.getBlock().canBeReplacedByLeaves(state, world, leafPos))
	                    {
	                    	this.setBlockAndNotifyAdequately(world, leafPos, LEAF);
	                    }
					}
					else
					{
						if(rand.nextInt(5) == 0)
						{
		                    if(state.getBlock().canBeReplacedByLeaves(state, world, leafPos))
		                    {
		                    	this.setBlockAndNotifyAdequately(world, leafPos, LEAF);
		                    }
						}
					}
				}
			}
		}
		
		int x = pos.getX();
		int z = pos.getZ();
		BlockPos leafPos = new BlockPos(x, pos.getY() + 1, z);
		IBlockState state = world.getBlockState(leafPos);
        if (state.getBlock().canBeReplacedByLeaves(state, world, leafPos))
        {
        	this.setBlockAndNotifyAdequately(world, leafPos, LEAF);
        }
	}
}
