package vibrantjourneys.blocks.wood;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import vibrantjourneys.util.IPropertyHelper;

public class BlockPVJPressurePlate extends BlockPressurePlate implements IPropertyHelper
{
    public BlockPVJPressurePlate()
    {
        super(Material.WOOD, BlockPressurePlate.Sensitivity.EVERYTHING);
        this.setHardness(0.5F);
        this.setSoundType(SoundType.WOOD);
    }
    
	@Override
	public ImmutableList<IBlockState> getProperties()
	{
		return this.blockState.getValidStates();
	}
}
