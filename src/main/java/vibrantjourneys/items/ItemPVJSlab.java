package vibrantjourneys.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemSlab;

public class ItemPVJSlab extends ItemSlab
{
    private final BlockSlab doubleSlab;
    
	public ItemPVJSlab(Block block, BlockSlab singleSlab, BlockSlab doubleSlab)
	{
		super(block, singleSlab, doubleSlab);
        this.doubleSlab = doubleSlab;
	}

	@Override
    protected <T extends Comparable<T>> IBlockState makeState(IProperty<T> p_185055_1_, Comparable<?> p_185055_2_)
    {
        return this.doubleSlab.getDefaultState();
    }
}
