package vibrantjourneys.blocks;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockLog;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import vibrantjourneys.util.EnumWoodType;
import vibrantjourneys.util.IVariantHelper;

public class BlockPVJLog extends BlockLog implements IVariantHelper
{
	private EnumWoodType woodType;
    public static final PropertyEnum<BlockLog.EnumAxis> LOG_AXIS = PropertyEnum.<BlockLog.EnumAxis>create("axis", BlockLog.EnumAxis.class);

    public BlockPVJLog(EnumWoodType woodType)
    {
        this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
        this.woodType = woodType;
    }

    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
    	return woodType.getMapColor();
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState();

        switch (meta)
        {
            case 0:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
                break;
            case 1:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
                break;
            case 2:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
                break;
            default:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
        }

        return iblockstate;
    }
    
    @Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;

        switch ((BlockLog.EnumAxis)state.getValue(LOG_AXIS))
        {
            case Y:
                i = 0;
                break;
            case X:
                i = 1;
                break;
            case Z:
                i = 2;
            default:
			i = 0;
				break;
        }

        return i;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {LOG_AXIS});
    }
    
	@Override
	public ImmutableList<IBlockState> getVariants()
	{
		return this.blockState.getValidStates();
	}
}