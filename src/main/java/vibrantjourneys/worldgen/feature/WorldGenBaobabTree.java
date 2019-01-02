package vibrantjourneys.worldgen.feature;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import vibrantjourneys.blocks.wood.BlockPVJLeaves;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.util.EnumLeafType;
import vibrantjourneys.util.EnumWoodType;

public class WorldGenBaobabTree extends WorldGenHugeTrees
{
    private static final IBlockState LOG = PVJBlocks.LOGS.get(EnumWoodType.BAOBAB.getID()).getDefaultState();
    
    private static final IBlockState LEAF = PVJBlocks.LEAVES.get(EnumLeafType.BAOBAB.getID()).getDefaultState()
    		.withProperty(BlockPVJLeaves.CHECK_DECAY, Boolean.valueOf(false));
    
    public WorldGenBaobabTree(boolean notify, int baseHeightIn, int extraRandomHeightIn)
    {
        super(notify, baseHeightIn, extraRandomHeightIn, LOG, LEAF);
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        int i = this.getHeight(rand);

        if (!this.ensureGrowable(worldIn, rand, position, i))
        {
            return false;
        }
        else
        {
            for (int i2 = 0; i2 < i; ++i2)
            {
                BlockPos blockpos = position.up(i2);

                if (this.isAirLeaves(worldIn,blockpos))
                {
                    this.setBlockAndNotifyAdequately(worldIn, blockpos, this.woodMetadata);
                }

                if (i2 < i - 1)
                {
                    BlockPos blockpos1 = blockpos.east();

                    if (this.isAirLeaves(worldIn,blockpos1))
                    {
                        this.setBlockAndNotifyAdequately(worldIn, blockpos1, this.woodMetadata);
                    }

                    BlockPos blockpos2 = blockpos.south().east();

                    if (this.isAirLeaves(worldIn,blockpos2))
                    {
                        this.setBlockAndNotifyAdequately(worldIn, blockpos2, this.woodMetadata);
                    }

                    BlockPos blockpos3 = blockpos.south();

                    if (this.isAirLeaves(worldIn,blockpos3))
                    {
                        this.setBlockAndNotifyAdequately(worldIn, blockpos3, this.woodMetadata);
                    }
                }
                if(i2 == i - 1)
                {
                	BlockPos branchPos = blockpos;
                	for(int length = 0; length <= 3 + rand.nextInt(4); length++)
                	{
                		branchPos = branchPos.north();
                		if(rand.nextBoolean())
                			branchPos = branchPos.west();
                		
                        if (this.isAirLeaves(worldIn, branchPos))
                        {
                            this.setBlockAndNotifyAdequately(worldIn, branchPos, this.woodMetadata);
                            if(rand.nextBoolean())
                            {
                                if (this.isAirLeaves(worldIn, branchPos.down()))
                                {
                                    this.setBlockAndNotifyAdequately(worldIn, branchPos.down(), this.woodMetadata);
                                }
                            }
                        }
                        
                        branchPos = branchPos.up();
                	}
                	int width = 4 + rand.nextInt(3);
                	for(int g = -1; g < 3; g++)
                	{
                    	this.growLeavesLayer(worldIn, branchPos.up(g), width);
                    	width -= 1 + rand.nextInt(2);
                	}

                	branchPos = blockpos;
                	for(int length = 0; length <= 3 + rand.nextInt(4); length++)
                	{
                		branchPos = branchPos.west();
                		if(rand.nextBoolean())
                			branchPos = branchPos.north();
                		
                        if (this.isAirLeaves(worldIn, branchPos))
                        {
                            this.setBlockAndNotifyAdequately(worldIn, branchPos, this.woodMetadata);
                            if(rand.nextBoolean())
                            {
                                if (this.isAirLeaves(worldIn, branchPos.down()))
                                {
                                    this.setBlockAndNotifyAdequately(worldIn, branchPos.down(), this.woodMetadata);
                                }
                            }
                        }
                        
                        branchPos = branchPos.up();
                	}
                	width = 4 + rand.nextInt(3);
                	for(int g = -1; g < 3; g++)
                	{
                    	this.growLeavesLayer(worldIn, branchPos.up(g), width);
                    	width -= 1 + rand.nextInt(2);
                	}
                	branchPos = blockpos.east();
                	for(int length = 0; length <= 3 + rand.nextInt(4); length++)
                	{
                		branchPos = branchPos.north();
                		if(rand.nextBoolean())
                			branchPos = branchPos.east();
                		
                        if (this.isAirLeaves(worldIn, branchPos))
                        {
                            this.setBlockAndNotifyAdequately(worldIn, branchPos, this.woodMetadata);
                            if(rand.nextBoolean())
                            {
                                if (this.isAirLeaves(worldIn, branchPos.down()))
                                {
                                    this.setBlockAndNotifyAdequately(worldIn, branchPos.down(), this.woodMetadata);
                                }
                            }
                        }
                        
                        branchPos = branchPos.up();
                	}
                	width = 4 + rand.nextInt(3);
                	for(int g = -1; g < 3; g++)
                	{
                    	this.growLeavesLayer(worldIn, branchPos.up(g), width);
                    	width -= 1 + rand.nextInt(2);
                	}
                	branchPos = blockpos.east();
                	for(int length = 0; length <= 3 + rand.nextInt(4); length++)
                	{
                		branchPos = branchPos.east();
                		if(rand.nextBoolean())
                			branchPos = branchPos.north();
                		
                        if (this.isAirLeaves(worldIn, branchPos))
                        {
                            this.setBlockAndNotifyAdequately(worldIn, branchPos, this.woodMetadata);
                            if(rand.nextBoolean())
                            {
                                if (this.isAirLeaves(worldIn, branchPos.down()))
                                {
                                    this.setBlockAndNotifyAdequately(worldIn, branchPos.down(), this.woodMetadata);
                                }
                            }
                        }
                        
                        branchPos = branchPos.up();
                	}
                	width = 4 + rand.nextInt(3);
                	for(int g = -1; g < 3; g++)
                	{
                    	this.growLeavesLayer(worldIn, branchPos.up(g), width);
                    	width -= 1 + rand.nextInt(2);
                	}
                	branchPos = blockpos.south();
                	for(int length = 0; length <= 3 + rand.nextInt(4); length++)
                	{
                		branchPos = branchPos.south();
                		if(rand.nextBoolean())
                			branchPos = branchPos.west();
                		
                        if (this.isAirLeaves(worldIn, branchPos))
                        {
                            this.setBlockAndNotifyAdequately(worldIn, branchPos, this.woodMetadata);
                            if(rand.nextBoolean())
                            {
                                if (this.isAirLeaves(worldIn, branchPos.down()))
                                {
                                    this.setBlockAndNotifyAdequately(worldIn, branchPos.down(), this.woodMetadata);
                                }
                            }
                        }
                        
                        branchPos = branchPos.up();
                	}
                	width = 4 + rand.nextInt(3);
                	for(int g = -1; g < 3; g++)
                	{
                    	this.growLeavesLayer(worldIn, branchPos.up(g), width);
                    	width -= 1 + rand.nextInt(2);
                	}
                	branchPos = blockpos.south();
                	for(int length = 0; length <= 3 + rand.nextInt(4); length++)
                	{
                		branchPos = branchPos.west();
                		if(rand.nextBoolean())
                			branchPos = branchPos.south();
                		
                        if (this.isAirLeaves(worldIn, branchPos))
                        {
                            this.setBlockAndNotifyAdequately(worldIn, branchPos, this.woodMetadata);
                            if(rand.nextBoolean())
                            {
                                if (this.isAirLeaves(worldIn, branchPos.down()))
                                {
                                    this.setBlockAndNotifyAdequately(worldIn, branchPos.down(), this.woodMetadata);
                                }
                            }
                        }
                        
                        branchPos = branchPos.up();
                	}
                	width = 4 + rand.nextInt(3);
                	for(int g = -1; g < 3; g++)
                	{
                    	this.growLeavesLayer(worldIn, branchPos.up(g), width);
                    	width -= 1 + rand.nextInt(2);
                	}
                	branchPos = blockpos.south().east();
                	for(int length = 0; length <= 3 + rand.nextInt(4); length++)
                	{
                		branchPos = branchPos.south();
                		if(rand.nextBoolean())
                			branchPos = branchPos.east();
                		
                        if (this.isAirLeaves(worldIn, branchPos))
                        {
                            this.setBlockAndNotifyAdequately(worldIn, branchPos, this.woodMetadata);
                            if(rand.nextBoolean())
                            {
                                if (this.isAirLeaves(worldIn, branchPos.down()))
                                {
                                    this.setBlockAndNotifyAdequately(worldIn, branchPos.down(), this.woodMetadata);
                                }
                            }
                        }
                        
                        branchPos = branchPos.up();
                	}
                	width = 4 + rand.nextInt(3);
                	for(int g = -1; g < 3; g++)
                	{
                    	this.growLeavesLayer(worldIn, branchPos.up(g), width);
                    	width -= 1 + rand.nextInt(2);
                	}
                	branchPos = blockpos.south().east();
                	for(int length = 0; length <= 3 + rand.nextInt(4); length++)
                	{
                		branchPos = branchPos.east();
                		if(rand.nextBoolean())
                			branchPos = branchPos.south();
                		
                        if (this.isAirLeaves(worldIn, branchPos))
                        {
                            this.setBlockAndNotifyAdequately(worldIn, branchPos, this.woodMetadata);
                            if(rand.nextBoolean())
                            {
                                if (this.isAirLeaves(worldIn, branchPos.down()))
                                {
                                    this.setBlockAndNotifyAdequately(worldIn, branchPos.down(), this.woodMetadata);
                                }
                            }
                        }
                        
                        branchPos = branchPos.up();
                	}
                	width = 4 + rand.nextInt(3);
                	for(int g = -1; g < 3; g++)
                	{
                    	this.growLeavesLayer(worldIn, branchPos.up(g), width);
                    	width -= 1 + rand.nextInt(2);
                	}
                }
                
                if(i2 == 0)
                {
            		int height = i - 1;
                	//inner layer
                	for(int ilike = -2; ilike < 2; ilike++)
                	{
                		if(ilike == -2 || ilike == 1)
                		{
                			height = 6 + rand.nextInt(6);
                		}
                		else
                		{
                			height = i - 1;
                		}
                		for(int tacos = 0; tacos < height; tacos++)
                		{
                            if (this.isAirLeaves(worldIn, blockpos.north().west(ilike).up(tacos)))
                            {
                                this.setBlockAndNotifyAdequately(worldIn, blockpos.north().west(ilike).up(tacos), this.woodMetadata);
                            }
                		}
                		if(ilike == -2 || ilike == 1)
                		{
                			height = 8 + rand.nextInt(6);
                		}
                		else
                		{
                			height = i - 1;
                		}
                		for(int sausages = 0; sausages < height; sausages++)
                		{
                            if (this.isAirLeaves(worldIn, blockpos.south(2).west(ilike).up(sausages)))
                            {
                                this.setBlockAndNotifyAdequately(worldIn, blockpos.south(2).west(ilike).up(sausages), this.woodMetadata);
                            }
                		}
                	}
                	for(int jugs = 0; jugs < 2; jugs++)
                	{
                		height = i - 1;
                		for(int and = 0; and < height; and++)
                		{
                            if (this.isAirLeaves(worldIn, blockpos.west().south(jugs).up(and)))
                            {
                                this.setBlockAndNotifyAdequately(worldIn, blockpos.west().south(jugs).up(and), this.woodMetadata);
                            }
                		}
                		for(int buns = 0; buns < height; buns++)
                		{
                            if (this.isAirLeaves(worldIn, blockpos.east(2).south(jugs).up(buns)))
                            {
                                this.setBlockAndNotifyAdequately(worldIn, blockpos.east(2).south(jugs).up(buns), this.woodMetadata);
                            }
                		}
                	}
                	
                	//outer layer
                	for(int l = 0; l < 2; l++)
                	{
                		height = 1 + rand.nextInt(4);
                		for(int g = 0; g < height; g++)
                		{
                            if (this.isAirLeaves(worldIn, blockpos.west(2).south(l).up(g)))
                            {
                                this.setBlockAndNotifyAdequately(worldIn, blockpos.west(2).south(l).up(g), this.woodMetadata);
                            }
                		}
                		
                		height = 1 + rand.nextInt(4);
                		for(int b = 0; b < height; b++)
                		{
                            if (this.isAirLeaves(worldIn, blockpos.east(3).south(l).up(b)))
                            {
                                this.setBlockAndNotifyAdequately(worldIn, blockpos.east(3).south(l).up(b), this.woodMetadata);
                            }
                		}
                		
                		height = 1 + rand.nextInt(4);
                		for(int t = 0; t < height; t++)
                		{
                            if (this.isAirLeaves(worldIn, blockpos.north(2).east(l).up(t)))
                            {
                                this.setBlockAndNotifyAdequately(worldIn, blockpos.north(2).east(l).up(t), this.woodMetadata);
                            }
                		}
                		
                		height = 1 + rand.nextInt(4);
                		for(int pride = 0; pride < height; pride++)
                		{
                            if (this.isAirLeaves(worldIn, blockpos.south(3).east(l).up(pride)))
                            {
                                this.setBlockAndNotifyAdequately(worldIn, blockpos.south(3).east(l).up(pride), this.woodMetadata);
                            }
                		}
                	}
                }
            }

            return true;
        }
    }

    private boolean isAirLeaves(World world, BlockPos pos)
    {
        IBlockState state = world.getBlockState(pos);
        return state.getBlock().isAir(state, world, pos) || state.getBlock().isLeaves(state, world, pos);
    }
}