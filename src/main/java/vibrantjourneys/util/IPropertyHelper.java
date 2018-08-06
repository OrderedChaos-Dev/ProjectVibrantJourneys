package vibrantjourneys.util;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.state.IBlockState;

/**
 * Used by PVJ blocks with properties for use in registering models
 *
 */
public interface IPropertyHelper
{
	public ImmutableList<IBlockState> getProperties();
}
