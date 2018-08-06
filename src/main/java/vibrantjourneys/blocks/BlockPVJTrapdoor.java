package vibrantjourneys.blocks;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import vibrantjourneys.util.IPropertyHelper;

public class BlockPVJTrapdoor extends BlockTrapDoor implements IPropertyHelper
{	
	public BlockPVJTrapdoor()
	{
		super(Material.WOOD);
		this.setHardness(3.0F);
		this.setSoundType(SoundType.WOOD);
		this.disableStats();
	}
	
	@Override
	public ImmutableList<IBlockState> getProperties()
	{
		return this.blockState.getValidStates();
	}
}
