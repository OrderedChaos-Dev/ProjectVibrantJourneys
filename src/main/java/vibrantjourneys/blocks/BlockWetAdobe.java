package vibrantjourneys.blocks;

import java.util.Random;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.util.EnumStoneType;

public class BlockWetAdobe extends BlockFalling
{
	public BlockWetAdobe()
	{
		super(Material.CLAY);
        this.setTickRandomly(true);
		this.setHardness(1.0F);
        this.setSoundType(SoundType.GROUND);
	}
	
	@Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
		super.updateTick(world, pos, state, rand);
		
    	if(this.canBlockSeeSky(world, pos))
    	{
    		if(!world.isRaining())
    		{
    			if(world.isDaytime())
    			{
    				if(rand.nextInt(3) == 0)
    				{
    					world.setBlockState(pos, PVJBlocks.STONES.get(EnumStoneType.ADOBE.getID()).getDefaultState());
    				}
    			}
    		}
    	}
    }
	
	/**
	 * Mojang's version of this is trash, so here's a better one.
	 *
	 */
	public boolean canBlockSeeSky(World world, BlockPos pos)
	{
		for(int i = pos.getY() + 1; i < 256; i++)
		{
			if(!world.isAirBlock(new BlockPos(pos.getX(), i, pos.getZ())))
					return false;
		}
		return true;
	}
}
