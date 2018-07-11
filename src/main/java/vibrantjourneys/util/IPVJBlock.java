package vibrantjourneys.util;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;

public interface IPVJBlock
{
	public Class<? extends ItemBlock> getItem();
	public ImmutableList<IBlockState> getVariants();
	public String getStateName(IBlockState state);
}
