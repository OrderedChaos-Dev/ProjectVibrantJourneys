package vibrantjourneys.blocks.wood;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

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
	
	@Override
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
    	return Blocks.LOG.getFlammability(world, pos, face);
    }
	
	@Override
    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return Blocks.LOG.getFireSpreadSpeed(world, pos, face);
    }
}
