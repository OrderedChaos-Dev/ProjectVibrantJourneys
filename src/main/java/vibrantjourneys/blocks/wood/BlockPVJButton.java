package vibrantjourneys.blocks.wood;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockButtonWood;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import vibrantjourneys.util.IPropertyHelper;

public class BlockPVJButton extends BlockButtonWood implements IPropertyHelper
{
	public BlockPVJButton()
	{
		super();
		this.setHardness(0.5F);
		this.setSoundType(SoundType.WOOD);
	}
	
	@Override
	public ImmutableList<IBlockState> getProperties()
	{
		return this.blockState.getValidStates();
	}
}
