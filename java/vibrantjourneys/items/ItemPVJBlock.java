package vibrantjourneys.items;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.blocks.BlockPVJLog;
import vibrantjourneys.blocks.BlockPVJPlanks;
import vibrantjourneys.util.IPVJBlock;

public class ItemPVJBlock extends ItemBlock
{
	private IPVJBlock block;
	
	public ItemPVJBlock(Block block)
	{
		super(block);
		this.block = (IPVJBlock) block;
		this.setHasSubtypes(true);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (this.isInCreativeTab(tab))
        {
            ImmutableList<IBlockState> variants = block.getVariants();
            if(!variants.isEmpty())
            {
            	//each log rotation is a blockstate, this is my workaround for the creative tab holding every rotation
            	//because i'm lazy
            	if(block instanceof BlockPVJLog)
            	{
                    items.add(new ItemStack(this, 1, 0));
                    items.add(new ItemStack(this, 1, 4));
                    items.add(new ItemStack(this, 1, 8));
            	}
            	else
            	{
                	for(IBlockState state : variants)	
                	{
                		items.add(new ItemStack(this, 1, this.getBlock().getMetaFromState(state)));
                	}
            	}
            }
            else
            {
            	items.add(new ItemStack(this, 1));
            }
        }
    }
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
        ImmutableList<IBlockState> variants = block.getVariants();
        if(variants.isEmpty())
        	return super.getUnlocalizedName();
        else
        {
        	IBlockState state = this.getBlock().getStateFromMeta(stack.getMetadata());
        	return super.getUnlocalizedName() + "_" + block.getStateName(state);
        }
	}
}
