package vibrantjourneys.blocks.plant;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWildCrop extends BlockPVJPlant
{
	private Item cropItem;
	
	public BlockWildCrop(Item cropItem)
	{
		this.cropItem = cropItem;
	}
	
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return cropItem;
    }
    
	//BlockBush AABB is not a full block
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    }
	
    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
		Random rand = world instanceof World ? ((World) world).rand : new Random();
		if(cropItem == Items.WHEAT)
		{
			super.getDrops(drops, world, pos, state, 0);
			for (int i = 0; i < 2 + fortune; i++)
			{
				if (rand.nextInt(20) <= 7)
				{
					drops.add(new ItemStack(Items.WHEAT_SEEDS, 1, 0));
				}
			}
		}
		else if(cropItem == Items.BEETROOT)
		{
			super.getDrops(drops, world, pos, state, 0);
			for (int i = 0; i < 2 + fortune; i++)
			{
				if (rand.nextInt(20) <= 7)
				{
					drops.add(new ItemStack(Items.BEETROOT_SEEDS, 1, 0));
				}
			}
		}
		else
		{
			for (int i = 0; i < 2 + fortune; ++i)
			{
				if (rand.nextInt(20) <= 7)
				{
					drops.add(new ItemStack(cropItem, 1, 0));
				}
			}
		}
	}
}
