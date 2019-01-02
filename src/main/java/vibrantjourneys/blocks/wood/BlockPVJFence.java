package vibrantjourneys.blocks.wood;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import vibrantjourneys.util.IPropertyHelper;

public class BlockPVJFence extends BlockFence implements IPropertyHelper
{
	public BlockPVJFence()
	{
		super(Material.WOOD, MapColor.WOOD);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.WOOD);
	}
	
	@Override
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
    	return Blocks.OAK_FENCE.getFlammability(world, pos, face);
    }
	
	@Override
    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return Blocks.OAK_FENCE.getFireSpreadSpeed(world, pos, face);
    }
	
	@Override
	public ImmutableList<IBlockState> getProperties()
	{
		return this.blockState.getValidStates();
	}
}
