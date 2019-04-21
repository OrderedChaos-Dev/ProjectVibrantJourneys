package vibrantjourneys.worldgen.feature;

import java.util.ArrayList;
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

public class WorldGenCherryBlossomTree extends WorldGenAbstractTree
{
	private IBlockState LOG = PVJBlocks.LOGS.get(EnumWoodType.CHERRY_BLOSSOM.getID()).getDefaultState();
	private IBlockState LEAVES = PVJBlocks.LEAVES.get(EnumLeafType.WHITE_CHERRY_BLOSSOM.getID()).getDefaultState();
	
	public WorldGenCherryBlossomTree(boolean notify, boolean isPink)
	{
		super(notify);
		if(isPink)
			LEAVES = PVJBlocks.LEAVES.get(EnumLeafType.PINK_CHERRY_BLOSSOM.getID()).getDefaultState();
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
            
            ArrayList<EnumFacing> facings = new ArrayList<EnumFacing>();
            
            int baseHeight = 10 + rand.nextInt(6);

            if (isSoil && pos.getY() < world.getHeight() - baseHeight - 1)
            {
            	int branchStart = 5 + rand.nextInt(3);
            	for(int height = 0; height < baseHeight; height++)
            	{
            		facings.clear();
            		BlockPos logPos = pos.up(height);
            		if(canPlaceLog(world.getBlockState(logPos), world, logPos))
            			world.setBlockState(logPos, LOG);
            		
            		//branch time!
            		if(height > branchStart)
            		{
            			if(height % 2 == 0)
            			{
                			int branchCount = rand.nextInt(3) + 1;
                			
                			for(int b = 0; b < branchCount; b++)
                			{
                				int length = 2 + rand.nextInt(6);
                				if(height >= 10)
                					length -= (int)(0.3 * height - 1);
                				
                				EnumFacing facing = EnumFacing.Plane.HORIZONTAL.random(rand);
                				while(facings.contains(facing))
                				{
                					facing = EnumFacing.Plane.HORIZONTAL.random(rand);
                				}
                				facings.add(facing);
                				
                				BlockPos branchPos = new BlockPos(logPos);
                				for(int q = 1; q <= length; q++)
                				{
                    				branchPos = branchPos.offset(facing);
                    				if(q > 1)
                    				{
                    					if(rand.nextBoolean())
                    					{
                    						branchPos = branchPos.offset(EnumFacing.Plane.HORIZONTAL.random(rand));
                    					}
                    					if(rand.nextBoolean())
                    					{
                    						branchPos = branchPos.up();
                    					}
                    				}
                    				
                					if(canPlaceLog(world.getBlockState(branchPos), world, branchPos))
                					{
                						world.setBlockState(branchPos, LOG);
                						genLeaves(world, branchPos, rand);
                						if(rand.nextInt(3) == 0)
                						{
                							EnumFacing temp = EnumFacing.Plane.HORIZONTAL.random(rand);
                							BlockPos tempPos = branchPos.offset(temp);
                        					if(canPlaceLog(world.getBlockState(tempPos), world, tempPos))
                        					{
                        						world.setBlockState(tempPos, LOG);
                        						genLeaves(world, tempPos, rand);
                        					}
                						}
                					}
                				}
                			}
            			}
            		}
        			//if(height > 7)
        				//WgenLeaves(world, logPos, rand);
            	}
            }
        	return true;
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
							BlockPos tempPos = leafPos.down();
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
	
	public boolean canPlaceLog(IBlockState state, World world, BlockPos pos)
	{
		return state.getBlock().isAir(state, world, pos) || state.getBlock().isLeaves(state, world, pos);
	}
}
