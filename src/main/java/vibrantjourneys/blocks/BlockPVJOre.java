package vibrantjourneys.blocks;

import java.util.Random;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockPVJOre extends BlockStoneBlock
{
	private Item droppedItem;
	
	public BlockPVJOre(Item droppedItem)
	{
		super(3.0F, 5.0F, MapColor.STONE);
		this.droppedItem = droppedItem;
	}
	
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
    	return this.droppedItem;
    }
}
