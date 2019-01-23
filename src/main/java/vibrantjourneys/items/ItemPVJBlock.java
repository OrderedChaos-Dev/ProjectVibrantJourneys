package vibrantjourneys.items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.blocks.wood.BlockPVJLeaves;

public class ItemPVJBlock extends ItemBlock
{
	private Block block;
	public ItemPVJBlock(Block block)
	{
		super(block);
		this.setHasSubtypes(true);
		this.block = block;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (this.isInCreativeTab(tab))
        {
            items.add(new ItemStack(this, 1, block instanceof BlockPVJLeaves ? 3 : 0));
        }
    }
	
	@Override
	public String getTranslationKey(ItemStack stack)
	{
        return super.getTranslationKey();
	}
	
	@Override
	public int getMetadata(int damage)
	{
		return damage;
	}
}
