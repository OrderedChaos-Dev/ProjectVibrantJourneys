package vibrantjourneys.worldgen.feature;

import java.util.Random;

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

public class WorldGenRedwoodSmall extends WorldGenAbstractTree
{
    private static final IBlockState LOG = PVJBlocks.LOGS.get(EnumWoodType.REDWOOD.getID()).getDefaultState();
    
    private static final IBlockState LEAF = PVJBlocks.LEAVES.get(EnumLeafType.REDWOOD.getID()).getDefaultState()
    		.withProperty(BlockPVJLeaves.CHECK_DECAY, Boolean.valueOf(false));
    
	public WorldGenRedwoodSmall()
	{
		super(false);
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos position)
	{
    	IBlockState BARK = PVJBlocks.redwood_bark.getDefaultState();
		int yGen = position.getY();
		int height = 9 + rand.nextInt(3); //height of tree
		int crown = height - 8 + rand.nextInt(3); //height of crown (where leaves are)
		int base = height - crown; //height of trunk
		
		if(yGen >= 1 && yGen + height + 1 <= 256)
		{
			boolean hasSpace = true; //used to test if tree can generate
			BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
			
			//check surroundings for space to generate tree
			for(int y = yGen; y <= yGen + height + 1 && hasSpace; y++)
			{
				int width = 2;
				if(y - yGen < base)
					width = 1;
				
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
			
			//generate tree if has space
			if(!hasSpace)
			{
				return false;
			}
			else
			{
				BlockPos down = position.down();
				IBlockState state = world.getBlockState(down);
				boolean isSoil = state.getBlock().canSustainPlant(state, world, down, EnumFacing.UP, (IPlantable)Blocks.SAPLING);
				
				if(isSoil && yGen + height + 1 <= 256)
				{
					state.getBlock().onPlantGrow(state, world, down, position);
					int tempwidth = 0;
					for(int h = 0; h <= height; h++)
					{
						BlockPos genPos = position.up(h);
						state = world.getBlockState(genPos);
						if(state.getBlock().isAir(state, world, genPos) || state.getBlock().isLeaves(state, world, genPos))
						{
							this.setBlockAndNotifyAdequately(world, genPos, LOG);
						}
						
						if(h == 0)
						{
							this.setBlockAndNotifyAdequately(world, genPos.east(), BARK);
							this.setBlockAndNotifyAdequately(world, genPos.west(), BARK);
							this.setBlockAndNotifyAdequately(world, genPos.north(), BARK);
							this.setBlockAndNotifyAdequately(world, genPos.south(), BARK);

						}
						if(h == 1)
						{
							if(rand.nextInt(10) < 7)
							{
								this.setBlockAndNotifyAdequately(world, genPos.east(), BARK);
								if(rand.nextInt(10) < 6)
								{
									this.setBlockAndNotifyAdequately(world, genPos.east().up(), BARK);
								}
							}
							if(rand.nextInt(10) < 7)
							{
								this.setBlockAndNotifyAdequately(world, genPos.west(), BARK);
								if(rand.nextInt(10) < 6)
								{
									this.setBlockAndNotifyAdequately(world, genPos.west().up(), BARK);
								}
							}
							if(rand.nextInt(10) < 7)
							{
								this.setBlockAndNotifyAdequately(world, genPos.north(), BARK);
								if(rand.nextInt(10) < 6)
								{
									this.setBlockAndNotifyAdequately(world, genPos.north().up(), BARK);
								}
							}
							if(rand.nextInt(10) < 7)
							{
								this.setBlockAndNotifyAdequately(world, genPos.north(), BARK);
								if(rand.nextInt(10) < 6)
								{
									this.setBlockAndNotifyAdequately(world, genPos.north().up(), BARK);
								}
							}
						}			
						if(h >= base)
						{
							//im a programmer not a mathematician...
							int mid = (crown / 2) + base;
							int width;
							if(h < mid)
								width = h - base + 1;
							else
								width = height - h + 1;
							
							if(width > 3)
								width = 3;
							
							if(Math.abs(width - tempwidth) > 1)
								width--;
							
							
							for(int x = -width; x <= width; x++)
							{
								for(int z = -width; z <= width; z++)
								{
									int xPos = genPos.getX() + x;
									int zPos = genPos.getZ() + z;
									int yPos = genPos.getY();
									BlockPos leafPos = new BlockPos(xPos, yPos, zPos);
									
									if(!leafPos.equals(genPos))
									{
										if(state.getBlock().isAir(state, world, leafPos) || state.getBlock().isLeaves(state, world, leafPos))
										{
											if(Math.abs(x) == Math.abs(z) && x == width)
											{
												if(rand.nextInt(9) < 5)
													this.setBlockAndNotifyAdequately(world, leafPos, LEAF);
											}
											else
											{
												this.setBlockAndNotifyAdequately(world, leafPos, LEAF);
											}
										}
									}
								}
							}
							
							tempwidth = width;
						}
						
					}
					this.setBlockAndNotifyAdequately(world, position.up(height + 1), LEAF);
					
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
