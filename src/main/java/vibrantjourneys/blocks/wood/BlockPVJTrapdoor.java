package vibrantjourneys.blocks.wood;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import vibrantjourneys.util.IPropertyHelper;

public class BlockPVJTrapdoor extends BlockTrapDoor implements IPropertyHelper
{	
	public BlockPVJTrapdoor()
	{
		super(Material.WOOD);
		this.setHardness(3.0F);
		this.setSoundType(SoundType.WOOD);
		this.disableStats();
	}
	
	@Override
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
    	return Blocks.TRAPDOOR.getFlammability(world, pos, face);
    }
	
	@Override
    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return Blocks.TRAPDOOR.getFireSpreadSpeed(world, pos, face);
    }
	
	@Override
	public ImmutableList<IBlockState> getProperties()
	{
		return this.blockState.getValidStates();
	}
}
