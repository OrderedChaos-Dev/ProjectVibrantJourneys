package projectvibrantjourneys.common.world.features.trees;

import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LilyPadBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractSmallTreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class MangroveTreeFeature extends AbstractSmallTreeFeature<TreeFeatureConfig> {

	public MangroveTreeFeature(Function<Dynamic<?>, ? extends TreeFeatureConfig> function) {
		super(function);
	}

	@Override
	protected boolean func_225557_a_(IWorldGenerationReader world, Random rand, BlockPos pos, Set<BlockPos> logs, Set<BlockPos> leaves, MutableBoundingBox box, TreeFeatureConfig config) {
		int height = 5 + rand.nextInt(3) + rand.nextInt(4);
		
		//Optional<BlockPos> optional = this.func_227212_a_(world, height, 3, 3, pos, config);
		Optional<BlockPos> optional = Optional.of(pos);
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
		int height = 6 + rand.nextInt(3);
		
		BlockPos down = pos.down();
        boolean isSoil = world.hasBlockState(down, (s) -> (s.getBlock() == Blocks.WATER || isSoil(s.getBlock())));
        
        if (isSoil && pos.getY() < world.getMaxHeight() - height - 1)
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
        			for(; isReplaceable(world, pos1); pos1 = pos1.down())
        			{
        				this.func_227216_a_(world, rand, pos1, logs, box, config);
        			}
        			BlockPos pos2 = posRoot.east(2);
        			for(; isReplaceable(world, pos2); pos2 = pos2.down())
        			{
        				this.func_227216_a_(world, rand, pos2, logs, box, config);
        			}
        			BlockPos pos3 = posRoot.north(2);
        			for(; isReplaceable(world, pos3); pos3 = pos3.down())
        			{
        				this.func_227216_a_(world, rand, pos3, logs, box, config);
        			}
        			BlockPos pos4 = posRoot.south(2);
        			for(; isReplaceable(world, pos4); pos4 = pos4.down())
        			{
        				this.func_227216_a_(world, rand, pos4, logs, box, config);
        			}
        		}
        		if(i == rootHeight + 1)
        		{
        			BlockPos pos1 = posRoot.up();
                    
                    pos1 = posRoot.up().west();
                	this.func_227216_a_(world, rand, pos1, logs, box, config);
                	if(rand.nextInt(3) != 0)
                	{
                        pos1 = posRoot.up().west().down();
                        this.func_227216_a_(world, rand, pos1, logs, box, config);
                	}
                	if(rand.nextInt(3) != 0)
                	{
                        pos1 = posRoot.up().west().up();
                        this.func_227216_a_(world, rand, pos1, logs, box, config);
                	}
                    pos1 = posRoot.up().east();
                	this.func_227216_a_(world, rand, pos1, logs, box, config);
                	if(rand.nextInt(3) != 0)
                	{
                        pos1 = posRoot.up().west().down();
                        this.func_227216_a_(world, rand, pos1, logs, box, config);
                	}
                	if(rand.nextInt(3) != 0)
                	{
                        pos1 = posRoot.up().west().up();
                        this.func_227216_a_(world, rand, pos1, logs, box, config);
                	}
                    pos1 = posRoot.up().north();
                	this.func_227216_a_(world, rand, pos1, logs, box, config);
                	if(rand.nextInt(3) != 0)
                	{
                        pos1 = posRoot.up().west().down();
                        this.func_227216_a_(world, rand, pos1, logs, box, config);
                	}
                	if(rand.nextInt(3) != 0)
                	{
                        pos1 = posRoot.up().west().up();
                        this.func_227216_a_(world, rand, pos1, logs, box, config);
                	}
                    pos1 = posRoot.up().south();
                	this.func_227216_a_(world, rand, pos1, logs, box, config);
                	if(rand.nextInt(3) != 0)
                	{
                        pos1 = posRoot.up().west().down();
                        this.func_227216_a_(world, rand, pos1, logs, box, config);
                	}
                	if(rand.nextInt(3) != 0)
                	{
                        pos1 = posRoot.up().west().up();
                        this.func_227216_a_(world, rand, pos1, logs, box, config);
                	}
                    
        		}
        		
    			posA = pos.up(i);
    			this.func_227216_a_(world, rand, posA, logs, box, config);
                topBlock = posA;
        	}
        	BlockState leaf = config.leavesProvider.getBlockState(rand, pos);
        	topBlock = topBlock.add(0, 1, 0);
        	world.setBlockState(topBlock, leaf, 2);
            
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
                    	if(Math.abs(j) == Math.abs(k))
                    	{
                    		if(rand.nextInt(2) == 0)
                    			world.setBlockState(newpos, leaf, 2);
                    	}
                    	world.setBlockState(newpos, leaf, 2);
            		}
        		}
        	}
        }
	}
	
	@Override
	public Optional<BlockPos> func_227212_a_(IWorldGenerationReader world, int p_227212_2_, int p_227212_3_,
			int p_227212_4_, BlockPos pos, TreeFeatureConfig config) {
		BlockPos blockpos;
		if (!config.forcePlacement) {
			int i = world.getHeight(Heightmap.Type.OCEAN_FLOOR, pos).getY();
			int j = world.getHeight(Heightmap.Type.WORLD_SURFACE, pos).getY();
			blockpos = new BlockPos(pos.getX(), i, pos.getZ());
			if (j - i > config.maxWaterDepth) {
				return Optional.empty();
			}
		} else {
			blockpos = pos;
		}

		if (blockpos.getY() >= 1 && blockpos.getY() + p_227212_2_ + 1 <= world.getMaxHeight()) {
			for (int i1 = 0; i1 <= p_227212_2_ + 1; ++i1) {
				int j1 = config.foliagePlacer.func_225570_a_(p_227212_3_, p_227212_2_, p_227212_4_, i1);
				BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

				for (int k = -j1; k <= j1; ++k) {
					int l = -j1;

					while (l <= j1) {
						if (i1 + blockpos.getY() >= 0 && i1 + blockpos.getY() < world.getMaxHeight()) {
							blockpos$mutable.setPos(k + blockpos.getX(), i1 + blockpos.getY(), l + blockpos.getZ());
							if ((func_214587_a(world, blockpos$mutable) || isWater(world, blockpos$mutable) )&& (config.ignoreVines
									|| !func_227222_d_(world, blockpos$mutable))) {
								++l;
								continue;
							}

							return Optional.empty();
						}

						return Optional.empty();
					}
				}
			}

			return isSoilOrFarm(world, blockpos.down(), config.getSapling())
					&& blockpos.getY() < world.getMaxHeight() - p_227212_2_ - 1 ? Optional.of(blockpos)
							: (isWater(world, blockpos.down()) ? Optional.of(blockpos) : Optional.empty());
		} else {
			return Optional.empty();
		}
	}
	
	public boolean isWater(IWorldGenerationReader world, BlockPos pos) {
		return world.hasBlockState(pos, (state) -> state.getBlock() == Blocks.WATER);
	}
	
	public boolean isSoil(Block block) {
		return block == Blocks.GRASS || block == Blocks.SAND || block == Blocks.DIRT;
	}
	
	public boolean isReplaceable(IWorldGenerationReader world, BlockPos pos) {
		return world.hasBlockState(pos, (s) -> s.getBlock() == Blocks.WATER || s.getBlock() == Blocks.AIR || s.getMaterial().isReplaceable()
					|| s.getMaterial() == Material.OCEAN_PLANT || s.getBlock() instanceof LilyPadBlock);
	}
}
