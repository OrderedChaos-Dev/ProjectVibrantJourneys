package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLilyPad;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Loader;
import vibrantjourneys.blocks.BlockBracketFungus;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.util.PVJConfig;

public class WorldGenFallenTree implements IWorldGenerator
{
	private IBlockState logBase;
	private int frequency;
	private Biome[] biomes;
	
	public WorldGenFallenTree(IBlockState log, int frequency, Biome... biomes)
	{
		this.logBase = log;
		this.frequency = frequency;
		this.biomes = biomes;
	}
	
	public WorldGenFallenTree(Block log, int frequency, Biome... biomes)
	{
		this(log.getDefaultState(), frequency, biomes);
	}

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		Random random = new Random();
		int x = chunkX * 16 + 8;
		int z = chunkZ * 16 + 8;
		int y = 0;
		
		Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 0, z));
		
		boolean isValidBiome = false;
		for(int i = 0; i < biomes.length; i++)
		{
			if(biome == biomes[i])
			{
				isValidBiome = true;
				break;
			}
		}
		
		if(isValidBiome)
		{
			int length = 3 + random.nextInt(4);
			boolean hasBranch = random.nextBoolean();
			EnumFacing facing = EnumFacing.Plane.HORIZONTAL.random(random);
			
			int xPos = x;
			int zPos = z;
			
			for(int i = 0; i < frequency; i++)
			{
				xPos = x + random.nextInt(3);
				zPos = z + random.nextInt(3);
				
				y = 60 + random.nextInt(30);
				BlockPos testpos = new BlockPos(xPos, y, zPos);
				
				if(world.isAirBlock(testpos) && world.isSideSolid(testpos.down(), EnumFacing.UP))
					if(!(world.getBlockState(testpos.down()).getBlock() instanceof BlockLog))
						break;
			}
			
			//checks if lostcities is installed and disables fallen trees in city buildings by adding world.canSeeSky() check
			if(Loader.isModLoaded("lostcities"))
			{
				if(!world.canSeeSky(new BlockPos(xPos, y, zPos)))
				{
					for(int i = 0; i < 255 - y; i++)
					{
						BlockPos pos = new BlockPos(xPos, y + i, zPos);
						if(!(world.getBlockState(pos).getBlock() instanceof BlockLeaves))
							return;
					}
				}
			}
			
			if(!world.isSideSolid(new BlockPos(xPos, y - 1, zPos), EnumFacing.UP)) return;
			
			IBlockState log = logBase.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.fromFacingAxis(facing.getAxis()));
			
			for(int i = 0; i < length; i++)
			{
				xPos += facing.getFrontOffsetX();
				zPos += facing.getFrontOffsetZ();
				BlockPos pos = new BlockPos(xPos, y , zPos);
				IBlockState state = world.getBlockState(pos);
				
				//so it doesn't float in the air
				while(canReplace(world, pos.down()))
				{
					pos = pos.down();
					state = world.getBlockState(pos);
				}
				
				if(canReplace(world, pos))
				{
					world.setBlockState(pos, log);
					EnumFacing facing2 = getHorizontalPerpendicular(facing.getHorizontalIndex());
					if(world.isAirBlock(pos.offset(facing2)));
					{
						if(random.nextBoolean())
						{
							if(PVJConfig.worldgen.bracketFungusDensity > 0)
								world.setBlockState(pos.offset(facing2), PVJBlocks.bracket_fungus.getDefaultState().withProperty(BlockBracketFungus.FACING, facing2));
						}
					}
					if(hasBranch)
					{
						if(random.nextInt(length) < i)
						{
							EnumFacing branchfacing = getHorizontalPerpendicular(facing.getHorizontalIndex());
							
							int xbranch = xPos + branchfacing.getFrontOffsetX();
							int zbranch = zPos + branchfacing.getFrontOffsetZ();
							
							pos = new BlockPos(xbranch, y, zbranch);
							state = world.getBlockState(pos);
							
							if(canReplace(world, pos))
							{
								while(canReplace(world, pos.down()))
								{
									pos = pos.down();
									state = world.getBlockState(pos);
								}
								
								state = logBase.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.fromFacingAxis(branchfacing.getAxis()));
								world.setBlockState(pos, state);
								facing2 = getHorizontalPerpendicular(branchfacing.getHorizontalIndex());
								if(world.isAirBlock(pos.offset(facing2)));
								{
									if(random.nextBoolean())
									{
										if(PVJConfig.worldgen.bracketFungusDensity > 0)
											world.setBlockState(pos.offset(facing2), PVJBlocks.bracket_fungus.getDefaultState().withProperty(BlockBracketFungus.FACING, facing2));
									}
								}
								hasBranch = false;
							}
						}
					}
				}
				else
				{
					break;
				}
			}
		}
	}
	
	public boolean canReplace(World world, BlockPos pos)
	{
		IBlockState state = world.getBlockState(pos);
		return world.isAirBlock(pos)
				|| state.getBlock().isReplaceable(world, pos)
				|| state.getBlock().isLeaves(state, world, pos)
				|| state.getBlock() instanceof BlockLilyPad
				|| state.getBlock() instanceof BlockMushroom
				|| state.getBlock() instanceof BlockFlower;
	}
	
	private EnumFacing getHorizontalPerpendicular(int facingIndex)
	{
		if(facingIndex == 0)
			return EnumFacing.WEST;
		else if(facingIndex == 2)
			return EnumFacing.EAST;
		else if(facingIndex == 1)
			return EnumFacing.SOUTH;
		else
			return EnumFacing.NORTH;
	}
}
