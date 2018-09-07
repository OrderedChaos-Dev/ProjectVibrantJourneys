package vibrantjourneys.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockBark extends Block
{
	private Block baseWood;
	
	public BlockBark(Block base)
	{
		super(Material.WOOD);
		
        this.setHardness(2.0F);
        this.setSoundType(SoundType.WOOD);
		this.baseWood = base;
	}
	
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(baseWood);
    }
}
