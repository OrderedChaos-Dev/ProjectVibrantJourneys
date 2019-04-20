package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockLilyPad;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.blocks.plant.BlockBracketFungus;
import vibrantjourneys.blocks.plant.BlockShortGrass;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.init.PVJWorldGen;
import vibrantjourneys.util.PVJConfig;

public class WorldGenFallenTree implements IWorldGenerator
{
	private IBlockState logBase;
	private int frequency;
	private Biome[] biomes;
	
	public WorldGenFallenTree(IBlockState log, int frequency, Biome... biomes)
	{
		this.logBase = log;
		this.frequency = (int)(frequency * (PVJConfig.global.fallenTreeDensity / 100.0));
		this.biomes = biomes;
	}
	
	public WorldGenFallenTree(Block log, int frequency, Biome... biomes)
	{
		this(log.getDefaultState(), frequency, biomes);
	}

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		for(int id : PVJWorldGen.dimensionBlacklist)
			if(world.provider == DimensionManager.getProvider(id))
				return;
		
		Random random = new Random();
		
		ChunkPos chunkPos = world.getChunk(chunkX, chunkZ).getPos();
		Biome biome = world.getBiomeForCoordsBody(chunkPos.getBlock(0, 0, 0));
		
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
			for(int i = 0; i < frequency; i++)
			{
		        int xPos = rand.nextInt(16) + 8;
		        int zPos = rand.nextInt(16) + 8;
		        int y = world.getHeight(chunkPos.getBlock(0, 0, 0).add(xPos, 0, zPos)).getY() + rand.nextInt(4) - rand.nextInt(4);
		        BlockPos pos = chunkPos.getBlock(0, 0, 0).add(xPos, y, zPos);
		        
		        if(!canReplace(world, pos) || !world.isSideSolid(pos.down(), EnumFacing.UP))
		        	return;
		        
		        if(world.getBlockState(pos.down()).getBlock() instanceof BlockLog)
		        	return;
				
				int length = 4 + random.nextInt(3);
				EnumFacing facing = EnumFacing.Plane.HORIZONTAL.random(random);
				
				BlockPos prev = null;
				for(int j = 0; j < length; j++)
				{
					prev = pos;
					pos = pos.offset(facing);
					while(canReplace(world, pos.down()))
						pos = pos.down();
					
					if(canReplace(world, pos))
						world.setBlockState(pos, logBase.withProperty(BlockLog.LOG_AXIS, EnumAxis.fromFacingAxis(facing.getAxis())));
					else
						continue;
					
					if(random.nextBoolean())
					{
						EnumFacing temp = random.nextBoolean() ? facing.getOpposite() : facing;
						temp = this.getHorizontalPerpendicular(temp.getHorizontalIndex());
						
						BlockPos tempPos = pos.offset(temp);
						if(canReplace(world, tempPos))
						{
							world.setBlockState(tempPos, PVJBlocks.bracket_fungus.getDefaultState().withProperty(BlockBracketFungus.FACING, temp));
						}
					}
					
				}
				
				if(random.nextBoolean())
				{
					EnumFacing branch = this.getHorizontalPerpendicular(facing.getHorizontalIndex());
					BlockPos branchPos = prev.offset(branch);
					if(canReplace(world, branchPos))
					{
						world.setBlockState(branchPos, logBase.withProperty(BlockLog.LOG_AXIS, EnumAxis.fromFacingAxis(branch.getAxis())));
					}
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
				|| state.getBlock() instanceof BlockTallGrass
				|| state.getBlock() instanceof BlockShortGrass
				|| state.getBlock() instanceof BlockLilyPad
				|| state.getBlock() instanceof BlockMushroom
				|| state.getBlock() instanceof BlockFlower
				|| state.getBlock() instanceof BlockBracketFungus;
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
