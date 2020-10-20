package projectvibrantjourneys.common.world.features.trees;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.VineBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractSmallTreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class WillowTreeFeature extends AbstractSmallTreeFeature<TreeFeatureConfig> {

	public WillowTreeFeature(Function<Dynamic<?>, ? extends TreeFeatureConfig> function) {
		super(function);
	}

	@Override
	protected boolean place(IWorldGenerationReader world, Random rand, BlockPos pos, Set<BlockPos> logs, Set<BlockPos> leaves, MutableBoundingBox box, TreeFeatureConfig config) {
		int height = 5 + rand.nextInt(3) + rand.nextInt(4);
		
		Optional<BlockPos> optional = this.func_227212_a_(world, height, 3, 3, pos, config);
		if (!optional.isPresent()) {
			return false;
		} else {
			BlockPos blockpos = optional.get();
			this.setDirtAt(world, blockpos.down(), blockpos);
			this.func_227213_a_(world, rand, height, pos, 0, logs, box, config);
			
			return true;
		}
	}

	//this is a dumpster fire and I will fix it later
	@Override
	protected void func_227213_a_(IWorldGenerationReader world, Random rand, int a, BlockPos pos, int c, Set<BlockPos> logs, MutableBoundingBox box, TreeFeatureConfig config) {
		 int baseHeight = 3 + rand.nextInt(4);
         Direction facing = Direction.Plane.HORIZONTAL.random(rand);
         if (pos.getY() < world.getMaxHeight() - baseHeight - 1){
             	BlockPos pos1 = pos.west();
             	BlockPos pos2 = pos.east();
             	BlockPos pos3 = pos.north();
             	BlockPos pos4 = pos.south();
             	
             	this.setLog(world, rand, pos, logs, box, config);
             	if(rand.nextInt(5) < 4)
             		this.setLog(world, rand, pos1, logs, box, config);
             	if(rand.nextInt(5) < 4)
             		this.setLog(world, rand, pos2, logs, box, config);
             	if(rand.nextInt(5) < 4)
             		this.setLog(world, rand, pos3, logs, box, config);
             	if(rand.nextInt(5) < 4)
             		this.setLog(world, rand, pos4, logs, box, config);
             }
         	this.setLog(world, rand, pos.up(), logs, box, config);
         	
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
           	 this.setLog(world, rand, logpos, logs, box, config);
            	if(rand.nextInt(2) == 0)
            	{
            		 this.setLog(world, rand, logpos.down(), logs, box, config);
            	}
                 
                 shamalamadingdong = logpos;
             }
             generateBranches(world, rand, shamalamadingdong, logs, box, config);
	}
	
	private void generateBranches(IWorldGenerationReader world, Random rand, BlockPos pos, Set<BlockPos> logs, MutableBoundingBox box, TreeFeatureConfig config)
	{
		int numBranches = 2;
        Direction facing = Direction.Plane.HORIZONTAL.random(rand);
        int length;
        ArrayList<BlockPos> outerLeaves = new ArrayList<BlockPos>();
		BlockState leaf = config.leavesProvider.getBlockState(rand, pos);
        
		for(int i = 0; i <= numBranches; i++)
		{
	        int x = pos.getX();
	        int y = pos.getY();
	        int z = pos.getZ();
	        Direction temp = Direction.Plane.HORIZONTAL.random(rand);
            if(!facing.getAxisDirection().equals(temp.getAxisDirection()))
            {
            	facing = temp;
            }
            
            length = rand.nextInt(3) + 2;
            for(int h = 0; h <= length; h++)
            {
            	x += facing.getXOffset();
            	z += facing.getZOffset();
            	
            	if(rand.nextInt(4) < 2)
            		y += 1;
            	
            	BlockPos logpos = new BlockPos(x, y, z);
            	this.setLog(world, rand, logpos, logs, box, config);
            	if(rand.nextInt(2) == 0)
            	{
            		this.setLog(world, rand, logpos.down(), logs, box, config);
            	}
                
                for(int up = -rand.nextInt(3); up <= rand.nextInt(2) + 1; up++)
                {
                    for(int west = -rand.nextInt(3); west <= rand.nextInt(2) + 1; west++)
                    {
                        for(int north = -rand.nextInt(3); north <= rand.nextInt(2) + 1; north++)
                        {
                        	BlockPos leafpos = logpos.up(up).west(west).north(north);
                        	if(Math.abs(up) != 1 && Math.abs(west) != 1 && Math.abs(north) != 1)
                        	{
                            	if(rand.nextInt(14) < 3)
                            	{
                            		if(world.hasBlockState(leafpos, p -> p.getBlock() == Blocks.AIR)) {
                            			world.setBlockState(leafpos, leaf, 2);
                                		outerLeaves.add(leafpos);
                            		}
                            	}
                        	}
                        	else
                        	{
                        		if(world.hasBlockState(leafpos, p -> p.getBlock() == Blocks.AIR))
                        			world.setBlockState(leafpos, leaf, 2);
                        	}
                        }
                    }
                }
            }
		}
		generateVines(world, rand, outerLeaves);
	}
	
	private void generateVines(IWorldGenerationReader world, Random rand, ArrayList<BlockPos> outerLeaves)
	{
		for(BlockPos pos : outerLeaves)
		{
			BlockPos vinepos = pos;
			int length;
			BlockState state = Blocks.VINE.getDefaultState().with(VineBlock.SOUTH, Boolean.valueOf(true));
			length = 3 + rand.nextInt(5);
			for(int i = 0; i < length; i++)
			{
				vinepos = pos.north().down(i);
				if(world.hasBlockState(vinepos, p -> p.getBlock() == Blocks.AIR))
				{
					world.setBlockState(vinepos, state, 2);
				}
			}
			length = 3 + rand.nextInt(5);
			state = Blocks.VINE.getDefaultState().with(VineBlock.NORTH, Boolean.valueOf(true));
			for(int i = 0; i < length; i++)
			{
				vinepos = pos.south().down(i);
				if(world.hasBlockState(vinepos, p -> p.getBlock() == Blocks.AIR))
				{
					world.setBlockState(vinepos, state, 2);
				}
			}
			length = 3 + rand.nextInt(5);;
			state = Blocks.VINE.getDefaultState().with(VineBlock.EAST, Boolean.valueOf(true));
			for(int i = 0; i < length; i++)
			{
				vinepos = pos.west().down(i);
				if(world.hasBlockState(vinepos, p -> p.getBlock() == Blocks.AIR))
				{
					world.setBlockState(vinepos, state, 2);
				}
			}
			length = 3 + rand.nextInt(5);
			state = Blocks.VINE.getDefaultState().with(VineBlock.WEST, Boolean.valueOf(true));
			for(int i = 0; i < length; i++)
			{
				vinepos = pos.east().down(i);
				if(world.hasBlockState(vinepos, p -> p.getBlock() == Blocks.AIR))
				{
					world.setBlockState(vinepos, state, 2);
				}
			}
		}
	}
}
