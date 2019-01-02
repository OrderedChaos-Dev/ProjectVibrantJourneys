package vibrantjourneys.blocks.wood;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockPVJPlanks extends Block
{
	public BlockPVJPlanks()
	{
		super(Material.WOOD);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.WOOD);
	}
	
	@Override
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
    	return Blocks.PLANKS.getFlammability(world, pos, face);
    }
	
	@Override
    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return Blocks.PLANKS.getFireSpreadSpeed(world, pos, face);
    }
	
	@Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return MapColor.WOOD;
    }
}
