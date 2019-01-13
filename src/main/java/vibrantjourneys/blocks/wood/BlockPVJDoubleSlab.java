package vibrantjourneys.blocks.wood;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockPVJDoubleSlab extends BlockPVJSlab
{
	private Block half;
	
	public BlockPVJDoubleSlab(IBlockState state, Block half)
	{
		super(state);
        this.half = half;
	}
	
	@Override
	public boolean isDouble()
	{
		return true;
	}
	
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(half);
    }

	@Override
	public String getTranslationKey(int meta) {
		return this.getTranslationKey();
	}
}
