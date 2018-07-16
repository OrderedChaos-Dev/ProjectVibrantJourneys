package vibrantjourneys.util;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.state.IBlockState;

/**
 * Used by PVJ blocks with variants for use in registering models
 *
 */
public interface IVariantHelper
{
	public ImmutableList<IBlockState> getVariants();
}
