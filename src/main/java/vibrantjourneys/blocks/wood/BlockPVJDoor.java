package vibrantjourneys.blocks.wood;

import java.util.Random;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import vibrantjourneys.util.IPropertyHelper;

public class BlockPVJDoor extends BlockDoor implements IPropertyHelper
{
	private Item doorItem;
	
	public BlockPVJDoor()
	{
		super(Material.WOOD);
		this.setHardness(3.0F);
		this.setSoundType(SoundType.WOOD);
		this.disableStats();
	}
	
	public void setDoorItem(Item item)
	{
		doorItem = item;
	}
	
	@Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(doorItem);
    }
	
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER ? Items.AIR : doorItem;
    }
	
	@Override
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
    	return Blocks.OAK_DOOR.getFlammability(world, pos, face);
    }
	
	@Override
    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return Blocks.OAK_DOOR.getFireSpreadSpeed(world, pos, face);
    }
	
	@Override
	public ImmutableList<IBlockState> getProperties()
	{
		return this.blockState.getValidStates();
	}
}
