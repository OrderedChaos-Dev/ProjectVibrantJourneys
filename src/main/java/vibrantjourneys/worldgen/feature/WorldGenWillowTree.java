package vibrantjourneys.worldgen.feature;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
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

public class WorldGenWillowTree extends WorldGenAbstractTree
{
	private static final IBlockState LOG = PVJBlocks.LOGS.get(EnumWoodType.WILLOW.getID()).getDefaultState();
	private static final IBlockState LEAVES = PVJBlocks.LEAVES.get(EnumLeafType.WILLOW.getID()).getDefaultState();
	
	public WorldGenWillowTree()
	{
		super(false);
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
                            Block block = iblockstate.getBlock();

                            if (!iblockstate.getBlock().isAir(iblockstate, world, blockpos$mutableblockpos.setPos(l, j, i1)) && !iblockstate.getBlock().isLeaves(iblockstate, world, blockpos$mutableblockpos.setPos(l, j, i1)))
                            {
                                if (block != Blocks.WATER && block != Blocks.FLOWING_WATER)
                                {
                                    flag = false;
                                }
                                else if (j > pos.getY())
                                {
                                    flag = false;
                                }
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
            boolean isSoil = state.getBlock().canSustainPlant(state, world, down, EnumFacing.UP, (IPlantable)Blocks.SAPLING);
            
            int baseHeight = 3 + rand.nextInt(4);
            EnumFacing facing = EnumFacing.Plane.HORIZONTAL.random(rand);
            if (isSoil && pos.getY() < world.getHeight() - baseHeight - 1)
            {
            	state = world.getBlockState(pos);
                if (canGenerateLogAt(state, world, pos))
                {
                	BlockPos pos1 = pos.west();
                	BlockPos pos2 = pos.east();
                	BlockPos pos3 = pos.north();
                	BlockPos pos4 = pos.south();
                	
                	this.setBlockAndNotifyAdequately(world, pos, LOG);
                	if(rand.nextInt(5) < 4)
                	{
                		state = world.getBlockState(pos1);
                        if (canGenerateLogAt(state, world, pos1))
                        {
                        	this.setBlockAndNotifyAdequately(world, pos1, LOG);
                        }
                	}
                	if(rand.nextInt(5) < 4)
                	{
                		state = world.getBlockState(pos2);
                        if (canGenerateLogAt(state, world, pos2))
                        {
                        	this.setBlockAndNotifyAdequately(world, pos2, LOG);
                        }
                	}
                	if(rand.nextInt(5) < 4)
                	{
                		state = world.getBlockState(pos3);
                        if (canGenerateLogAt(state, world, pos3))
                        {
                        	this.setBlockAndNotifyAdequately(world, pos3, LOG);
                        }
                	}
                	if(rand.nextInt(5) < 4)
                	{
                		state = world.getBlockState(pos4);
                        if (canGenerateLogAt(state, world, pos4))
                        {
                        	this.setBlockAndNotifyAdequately(world, pos4, LOG);
                        }
                	}
                }
                state = world.getBlockState(pos.up());
                if (canGenerateLogAt(state, world, pos.up()))
                {
                	this.setBlockAndNotifyAdequately(world, pos.up(), LOG);
                }
            	
                int x = pos.getX();
                int y = pos.getY();
                int z = pos.getZ();
                
                BlockPos shamalamadingdong = new BlockPos(x, y, z);
                
                for(int h = 0; h <= baseHeight; h++)
                {
                	if(rand.nextInt(8) < 5)
                	{
                    	x += facing.getXOffset();
                    	z += facing.getZOffset();
                	}
                	
                	if(rand.nextInt(6) < 5)
                		y += 1;
                	
                	BlockPos logpos = new BlockPos(x, y, z);
                	state = world.getBlockState(logpos);
                    if (state.getBlock().isAir(state, world, logpos) || state.getBlock().isLeaves(state, world, logpos))
                    {
                    	this.setBlockAndNotifyAdequately(world, logpos, LOG);
                    	if(rand.nextInt(2) == 0)
                    	{
                    		state = world.getBlockState(logpos.down());
                            if (state.getBlock().isAir(state, world, logpos.down()) || state.getBlock().isLeaves(state, world, logpos.down()))
                            {
                            	this.setBlockAndNotifyAdequately(world, logpos.down(), LOG);
                            }
                    	}
                    }
                    
                    shamalamadingdong = logpos;
                }
                generateBranches(world, rand, shamalamadingdong);
            }
        	return true;
        }
	}
	
	private void generateBranches(World world, Random rand, BlockPos pos)
	{
		int numBranches = 2;
        EnumFacing facing = EnumFacing.Plane.HORIZONTAL.random(rand);
        int length;
        ArrayList<BlockPos> outerLeaves = new ArrayList<BlockPos>();
        
        
		for(int i = 0; i <= numBranches; i++)
		{
	        int x = pos.getX();
	        int y = pos.getY();
	        int z = pos.getZ();
            EnumFacing temp = EnumFacing.Plane.HORIZONTAL.random(rand);
            if(!facing.getAxisDirection().equals(temp.getAxisDirection()))
            {
            	facing = temp;
            }
            
            length = rand.nextInt(3) + 2;
            IBlockState state = world.getBlockState(pos);
            for(int h = 0; h <= length; h++)
            {
            	x += facing.getXOffset();
            	z += facing.getZOffset();
            	
            	if(rand.nextInt(4) < 2)
            		y += 1;
            	
            	BlockPos logpos = new BlockPos(x, y, z);
            	state = world.getBlockState(logpos);
                if (state.getBlock().isAir(state, world, logpos) || state.getBlock().isLeaves(state, world, logpos))
                {
                	this.setBlockAndNotifyAdequately(world, logpos, LOG);
                	if(rand.nextInt(2) == 0)
                	{
                		state = world.getBlockState(logpos.down());
                        if (state.getBlock().isAir(state, world, logpos.down()) || state.getBlock().isLeaves(state, world, logpos.down()))
                        {
                        	this.setBlockAndNotifyAdequately(world, logpos.down(), LOG);
                        }
                	}
                }
                
                for(int up = -rand.nextInt(3); up <= rand.nextInt(2) + 1; up++)
                {
                    for(int west = -rand.nextInt(3); west <= rand.nextInt(2) + 1; west++)
                    {
                        for(int north = -rand.nextInt(3); north <= rand.nextInt(2) + 1; north++)
                        {
                        	BlockPos leafpos = logpos.up(up).west(west).north(north);
                        	state = world.getBlockState(leafpos);
                            if (state.getBlock().isAir(state, world, leafpos) || state.getBlock().isLeaves(state, world, leafpos))
                            {
                            	if(Math.abs(up) != 1 && Math.abs(west) != 1 && Math.abs(north) != 1)
                            	{
                                	if(rand.nextInt(14) < 3)
                                	{
                                		this.setBlockAndNotifyAdequately(world, leafpos, LEAVES);
                                		outerLeaves.add(leafpos);
                                	}
                            	}
                            	else
                            	{
                            		this.setBlockAndNotifyAdequately(world, leafpos, LEAVES);
                            	}
                            }
                        }
                    }
                }
            }
		}
		generateVines(world, rand, outerLeaves);
	}
	
	public boolean canGenerateLogAt(IBlockState state, World world, BlockPos pos)
	{
		return state.getBlock().isAir(state, world, pos) || state.getBlock().isLeaves(state, world, pos) || state.getMaterial() == Material.WATER;
	}
	
	private void generateVines(World world, Random rand, ArrayList<BlockPos> outerLeaves)
	{
		for(BlockPos pos : outerLeaves)
		{
			BlockPos vinepos = pos;
			int length;
			if(world.isAirBlock(pos.north()))
			{
				IBlockState state = Blocks.VINE.getDefaultState().withProperty(BlockVine.SOUTH, Boolean.valueOf(true));
				length = 3 + rand.nextInt(5);
				for(int i = 0; i < length; i++)
				{
					vinepos = pos.north().down(i);
					if(world.isAirBlock(vinepos))
					{
						this.setBlockAndNotifyAdequately(world, vinepos, state);
					}
				}
			}
			if(world.isAirBlock(pos.south()))
			{
				length = 3 + rand.nextInt(5);
				IBlockState state = Blocks.VINE.getDefaultState().withProperty(BlockVine.NORTH, Boolean.valueOf(true));
				for(int i = 0; i < length; i++)
				{
					vinepos = pos.south().down(i);
					if(world.isAirBlock(vinepos))
					{
						this.setBlockAndNotifyAdequately(world, vinepos, state);
					}
				}
			}
			if(world.isAirBlock(pos.west()))
			{
				length = 3 + rand.nextInt(5);;
				IBlockState state = Blocks.VINE.getDefaultState().withProperty(BlockVine.EAST, Boolean.valueOf(true));
				for(int i = 0; i < length; i++)
				{
					vinepos = pos.west().down(i);
					if(world.isAirBlock(vinepos))
					{
						this.setBlockAndNotifyAdequately(world, vinepos, state);
					}
				}
			}
			if(world.isAirBlock(pos.east()))
			{
				length = 3 + rand.nextInt(5);
				IBlockState state = Blocks.VINE.getDefaultState().withProperty(BlockVine.WEST, Boolean.valueOf(true));
				for(int i = 0; i < length; i++)
				{
					vinepos = pos.east().down(i);
					if(world.isAirBlock(vinepos))
					{
						this.setBlockAndNotifyAdequately(world, vinepos, state);
					}
				}
			}
		}
	}
}
