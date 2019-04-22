package vibrantjourneys.blocks;

import java.util.Random;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockWeb;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPVJCobweb extends BlockWeb
{
	public BlockPVJCobweb()
	{
		setLightOpacity(1);
		setHardness(0.1F);
	}
	
	@Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
		Block block = world.getBlockState(pos.up()).getBlock();
		if(!(block instanceof BlockLeaves))
		{
			world.setBlockToAir(pos);
		}
    }
	
    @Override
    public java.util.List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune)
    {
        return Lists.newArrayList(new ItemStack(Item.getItemFromBlock(Blocks.WEB)));
    }
    
    @Override
    public boolean canHarvestBlock(IBlockAccess world, BlockPos pos, EntityPlayer player)
    {
        return player.getHeldItemMainhand().getItem() instanceof ItemSword;
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.STRING;
    }
}
