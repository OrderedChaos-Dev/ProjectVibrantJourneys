package vibrantjourneys.blocks.wood;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockLog;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import vibrantjourneys.util.IPropertyHelper;

public class BlockPVJLog extends BlockLog implements IPropertyHelper
{
    public static final PropertyEnum<BlockLog.EnumAxis> LOG_AXIS = PropertyEnum.<BlockLog.EnumAxis>create("axis", BlockLog.EnumAxis.class);

    public BlockPVJLog()
    {
        this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
    }

    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
    	return MapColor.WOOD;
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
                break;
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
	public ImmutableList<IBlockState> getProperties()
	{
		return this.blockState.getValidStates();
	}
}