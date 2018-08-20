package vibrantjourneys.blocks;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockWall;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.util.IPropertyHelper;

public class BlockCobblestoneBrickWall extends BlockWall implements IPropertyHelper
{
	public BlockCobblestoneBrickWall()
	{
		super(PVJBlocks.cobblestone_brick);
	}
	
	@Override
	public ImmutableList<IBlockState> getProperties()
	{
		return this.blockState.getValidStates();
	}
	
	@Override
    public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos)
    {
		return true;
    }
}
