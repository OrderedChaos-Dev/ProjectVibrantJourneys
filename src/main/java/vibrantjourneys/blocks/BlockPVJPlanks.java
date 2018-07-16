package vibrantjourneys.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import vibrantjourneys.util.EnumWoodType;

public class BlockPVJPlanks extends Block
{
	private EnumWoodType woodType;
	
	public BlockPVJPlanks(EnumWoodType woodType)
	{
		super(Material.WOOD);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.WOOD);
		this.woodType = woodType;
	}
	@Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return woodType.getMapColor();
    }
}
