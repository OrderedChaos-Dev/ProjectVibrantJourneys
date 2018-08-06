package vibrantjourneys.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

public class BlockPVJHalfSlab extends BlockPVJSlab
{
	public BlockPVJHalfSlab(IBlockState state, Block half)
	{
		super(state, half);
	}
	
	@Override
	public boolean isDouble()
	{
		return false;
	}
}
