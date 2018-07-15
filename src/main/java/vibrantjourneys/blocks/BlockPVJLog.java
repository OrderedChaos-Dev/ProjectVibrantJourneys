package vibrantjourneys.blocks;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockLog;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.items.ItemPVJBlock;
import vibrantjourneys.util.IPVJBlock;

public class BlockPVJLog extends BlockLog implements IPVJBlock
{
    public static final PropertyEnum<BlockPVJPlanks.EnumType> VARIANT = PropertyEnum.<BlockPVJPlanks.EnumType>create("variant", BlockPVJPlanks.EnumType.class, new Predicate<BlockPVJPlanks.EnumType>()
    {
        public boolean apply(@Nullable BlockPVJPlanks.EnumType type)
        {
            return type.getMeta() < 4;
        }
    });

    public BlockPVJLog()
    {
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockPVJPlanks.EnumType.WILLOW).withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
    }

    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        BlockPVJPlanks.EnumType BlockPVJPlanks$enumtype = (BlockPVJPlanks.EnumType)state.getValue(VARIANT);

        switch ((BlockLog.EnumAxis)state.getValue(LOG_AXIS))
        {
            case X:
            case Z:
            case NONE:
            default:

                switch (BlockPVJPlanks$enumtype)
                {
                    case WILLOW:
                    default:
                        return BlockPVJPlanks.EnumType.WILLOW.getMapColor();
                    case MANGROVE:
                        return BlockPVJPlanks.EnumType.MANGROVE.getMapColor();
                    case PALM:
                        return BlockPVJPlanks.EnumType.PALM.getMapColor();
                    case REDWOOD:
                    	return BlockPVJPlanks.EnumType.REDWOOD.getMapColor();
                }

            case Y:
                return BlockPVJPlanks$enumtype.getMapColor();
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        items.add(new ItemStack(this, 1, BlockPVJPlanks.EnumType.WILLOW.getMeta()));
        items.add(new ItemStack(this, 1, BlockPVJPlanks.EnumType.MANGROVE.getMeta()));
        items.add(new ItemStack(this, 1, BlockPVJPlanks.EnumType.PALM.getMeta()));
        items.add(new ItemStack(this, 1, BlockPVJPlanks.EnumType.REDWOOD.getMeta()));
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, BlockPVJPlanks.EnumType.byMetadata((meta & 3) % 4));

        switch (meta & 12)
        {
            case 0:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
                break;
            case 4:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
                break;
            case 8:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
                break;
            default:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
        }

        return iblockstate;
    }

    @SuppressWarnings("incomplete-switch")
    @Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((BlockPVJPlanks.EnumType)state.getValue(VARIANT)).getMeta();

        switch ((BlockLog.EnumAxis)state.getValue(LOG_AXIS))
        {
            case X:
                i |= 4;
                break;
            case Z:
                i |= 8;
                break;
            case NONE:
                i |= 12;
        }

        return i;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT, LOG_AXIS});
    }

    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1, ((BlockPVJPlanks.EnumType)state.getValue(VARIANT)).getMeta());
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return ((BlockPVJPlanks.EnumType)state.getValue(VARIANT)).getMeta();
    }

	@Override
	public Class<? extends ItemBlock> getItem()
	{
		return ItemPVJBlock.class;
	}

	@Override
	public ImmutableList<IBlockState> getVariants()
	{
		return this.blockState.getValidStates();
	}

	@Override
	public String getStateName(IBlockState state)
	{
		return ((BlockPVJPlanks.EnumType)state.getValue(VARIANT)).getName();
	}
}