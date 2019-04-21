package vibrantjourneys.worldgen.feature;

import java.util.Random;

import net.minecraft.block.BlockHardenedClay;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.util.EnumLeafType;
import vibrantjourneys.util.EnumWoodType;

public class WorldGenCottonwoodTree extends WorldGenAbstractTree
{
	private static final IBlockState LOG = PVJBlocks.LOGS.get(EnumWoodType.COTTONWOOD.getID()).getDefaultState();
	private static final IBlockState LEAVES = PVJBlocks.LEAVES.get(EnumLeafType.COTTONWOOD.getID()).getDefaultState();
	
	public WorldGenCottonwoodTree(boolean notify)
	{
		super(notify);
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos)
	{
        int i;

        for (i = rand.nextInt(4) + 5; world.getBlockState(pos.down()).getMaterial() == Material.WATER; pos = pos.down())
        {
            ;
        }

        boolean flag = true;

        if (pos.getY() >= 1 && pos.getY() + i + 1 <= 256)
        {
            for (int j = pos.getY(); j <= pos.getY() + 1 + i; ++j)
            {
                int k = 1;

                if (j == pos.getY())
                {
                    k = 0;
                }

                if (j >= pos.getY() + 1 + i - 2)
                {
                    k = 3;
                }

                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                for (int l = pos.getX() - k; l <= pos.getX() + k && flag; ++l)
                {
                    for (int i1 = pos.getZ() - k; i1 <= pos.getZ() + k && flag; ++i1)
                    {
                        if (j >= 0 && j < 256)
                        {
                            IBlockState iblockstate = world.getBlockState(blockpos$mutableblockpos.setPos(l, j, i1));

                            if (!iblockstate.getBlock().isAir(iblockstate, world, blockpos$mutableblockpos.setPos(l, j, i1)) && !iblockstate.getBlock().isLeaves(iblockstate, world, blockpos$mutableblockpos.setPos(l, j, i1)))
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
        }
        
        if(!flag)
        {
        	return false;
        }
        else
        {
            BlockPos down = pos.down();
            IBlockState state = world.getBlockState(down);
            boolean isSoil = state.getBlock().canSustainPlant(state, world, down, EnumFacing.UP, (IPlantable)Blocks.SAPLING) || state.getBlock() instanceof BlockSand
            					|| state.getBlock() instanceof BlockHardenedClay;
            
            int height = 9 + rand.nextInt(5);
            int branchHeight1 = 4 + rand.nextInt(3);
            int branchHeight2 = Math.min(branchHeight1 + 3 + rand.nextInt(3), height);
            if(branchHeight1 + branchHeight2 > height)
            {
            	height = branchHeight1 + branchHeight2;
            }

            if (isSoil && pos.getY() < world.getHeight() - height - 1)
            {
            	BlockPos logPos = pos;
            	
            	//generate trunk
            	for(int x = 0; x < height; x++)
            	{
            		if(canPlaceLog(world.getBlockState(logPos), world, logPos))
            		{
            			world.setBlockState(logPos, LOG);
            		}
            		logPos = logPos.up();
            		if(x > branchHeight2)
            		{
            			genLeaves(world, logPos, rand);
            		}
            	}
            	
            	genBranches(world, pos.up(branchHeight1), rand, 6 + rand.nextInt(4));
            	genBranches(world, pos.up(branchHeight2), rand, 3 + rand.nextInt(3));

            }
        	return true;
        }
	}
	
	public void genBranches(World world, BlockPos pos, Random rand, int length)
	{
    	//generate branches
    	int branchCount = rand.nextBoolean() ? 3 : 4;
    	boolean skipBranch = true;
    	
    	for(EnumFacing facing : EnumFacing.HORIZONTALS)
    	{
    		//if this tree has only 3 branches, skip a random one out of the four horizontal directions
    		if(skipBranch && rand.nextBoolean() && branchCount == 3)
    		{
    			skipBranch = false;
    			continue;
    		}
    		//if none have been skipped, then skip the last one to guarantee 3 branches
    		if(skipBranch && branchCount == 3 && facing == EnumFacing.HORIZONTALS[3])
    		{
    			break;
    		}
    		int branchLength = length;
    		BlockPos branchPos = pos;
    		
    		for(int b = 0; b < branchLength; b++)
    		{
    			branchPos = branchPos.offset(facing);
    			
    			EnumFacing facingB = EnumFacing.Plane.HORIZONTAL.random(rand);
    			//if facing == facingB, it would leave it gap
    			if(facingB != facing && rand.nextBoolean())
    			{
    				branchPos = branchPos.offset(facingB);
    			}
    			//branches grow upwards sometimes
    			if(rand.nextInt(3) < 1)
    			{
    				//sometimes places a log before it goes up
        			if(canPlaceLog(world.getBlockState(branchPos), world, branchPos) && rand.nextBoolean())
        			{
        				world.setBlockState(branchPos, LOG);
        			}
        			branchPos = branchPos.up();
    			}
    			
    			if(canPlaceLog(world.getBlockState(branchPos), world, branchPos))
    			{
    				world.setBlockState(branchPos, LOG);
    				genLeaves(world, branchPos, rand);
    			}
    		}
    	}
	}
	
	public void genLeaves(World world, BlockPos pos, Random rand)
	{
		for(int x = -2; x <= 2; x++)
		{
			for(int y = -1; y <= 2; y++)
			{
				for(int z = -2; z <= 2; z++)
				{
					BlockPos leafPos = pos.add(x, y, z);
					if(world.isAirBlock(leafPos))
					{
						if(Math.abs(x) == 2 || Math.abs(y) == 2 || Math.abs(z) == 2)
						{
							if(rand.nextInt(16) <= 5)
							{
								boolean shouldGenLeaves = false;
								for(EnumFacing facing : EnumFacing.VALUES)
								{
									IBlockState state = world.getBlockState(leafPos.offset(facing));
									if(state.getBlock().isLeaves(state, world, leafPos.offset(facing)))
									{
										shouldGenLeaves = true;
										break;
									}
								}
								
								if(shouldGenLeaves)
								{
									if(Math.abs(x) == Math.abs(z))
									{
										if(rand.nextInt(4) == 0)
											world.setBlockState(leafPos, LEAVES);
									}
									else
									{
										world.setBlockState(leafPos, LEAVES);
									}
								}
							}
						}
						else
						{
							world.setBlockState(leafPos, LEAVES);
						}
						if(rand.nextInt(8) < 2)
						{
							for(int i = 1; i < 2 + rand.nextInt(1); i++)
							{
								BlockPos tempPos = leafPos.down(i);
								if(world.isAirBlock(tempPos))
								{
									world.setBlockState(tempPos, LEAVES);
								}
							}
						}
					}
				}
			}
		}
	}
	
	public boolean canPlaceLog(IBlockState state, World world, BlockPos pos)
	{
		return state.getBlock().isAir(state, world, pos) || state.getBlock().isLeaves(state, world, pos);
	}
}
