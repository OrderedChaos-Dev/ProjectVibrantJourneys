package vibrantjourneys.blocks;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import vibrantjourneys.util.EnumWoodType;
import vibrantjourneys.util.IPropertyHelper;

public class BlockPVJFence extends BlockFence implements IPropertyHelper
{
	public BlockPVJFence(EnumWoodType woodType)
	{
		super(Material.WOOD, woodType.getMapColor());
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.WOOD);
	}
	
	@Override
	public ImmutableList<IBlockState> getProperties()
	{
		return this.blockState.getValidStates();
	}
}
