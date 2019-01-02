package vibrantjourneys.blocks.plant;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.util.IPropertyHelper;

public class BlockWeed extends BlockPVJPlant implements IShearable, IPropertyHelper
{
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D);
    }
	
	@Override
    protected boolean canSustainBush(IBlockState state)
    {
		return super.canSustainBush(state);
    }
	
	@Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
    	return MapColor.GRASS;
    }
	
	@Override
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        return super.canBlockStay(worldIn, pos, state);
    }

	@Override
    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos)
    {
        return true;
    }

	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return null;
    }

	@Override
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return 1 + random.nextInt(fortune * 2 + 1);
    }
	
	@Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack)
    {
        if (!worldIn.isRemote && stack.getItem() == Items.SHEARS)
        {
            player.addStat(StatList.getBlockStats(this));
            spawnAsEntity(worldIn, pos, new ItemStack(PVJBlocks.chickweed, 1, 0));
        }
        else
        {
            super.harvestBlock(worldIn, player, pos, state, te, stack);
        }
    }

	@Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(this, 1, 0);
    }
	
    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos)
    { 
    	return true;
    }
    
    @Override
    public NonNullList<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune)
    {
        return NonNullList.withSize(1, new ItemStack(this, 1, 0));
    }
	
	@Override
    public Block.EnumOffsetType getOffsetType()
    {
        return Block.EnumOffsetType.XZ;
    }

	@Override
	public ImmutableList<IBlockState> getProperties()
	{
		return this.blockState.getValidStates();
	}
}
