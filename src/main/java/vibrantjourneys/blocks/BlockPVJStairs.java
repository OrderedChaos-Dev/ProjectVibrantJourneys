package vibrantjourneys.blocks;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import vibrantjourneys.util.IPropertyHelper;

public class BlockPVJStairs extends BlockStairs implements IPropertyHelper
{
	public BlockPVJStairs(IBlockState modelState)
	{
		super(modelState);
	}

	@Override
	public ImmutableList<IBlockState> getProperties()
	{
		return this.blockState.getValidStates();
	}
}
