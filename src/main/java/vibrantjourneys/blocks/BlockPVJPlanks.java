package vibrantjourneys.blocks;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import vibrantjourneys.items.ItemPVJBlock;
import vibrantjourneys.util.IPVJBlock;

public class BlockPVJPlanks extends Block implements IPVJBlock
{
    public static final PropertyEnum<BlockPVJPlanks.EnumType> VARIANT = PropertyEnum.<BlockPVJPlanks.EnumType>create("variant", BlockPVJPlanks.EnumType.class);
    
	public BlockPVJPlanks()
	{
		super(Material.WOOD);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.WOOD);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT,  BlockPVJPlanks.EnumType.WILLOW));
	}
	
	@Override
    public int damageDropped(IBlockState state)
    {
        return ((BlockPVJPlanks.EnumType)state.getValue(VARIANT)).getMeta();
    }

	@Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        for (BlockPVJPlanks.EnumType blockplanks$enumtype : BlockPVJPlanks.EnumType.values())
        {
            items.add(new ItemStack(this, 1, blockplanks$enumtype.getMeta()));
        }
    }

	@Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, BlockPVJPlanks.EnumType.byMetadata(meta));
    }

	@Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return ((BlockPVJPlanks.EnumType)state.getValue(VARIANT)).getMapColor();
    }

	@Override
    public int getMetaFromState(IBlockState state)
    {
        return ((BlockPVJPlanks.EnumType)state.getValue(VARIANT)).getMeta();
    }

	@Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
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
		return state.getValue(this.VARIANT).getName();
	}
	
    public static enum EnumType implements IStringSerializable
    {
        WILLOW(0, "willow", MapColor.GRAY),
        MANGROVE(1, "mangrove", MapColor.DIRT),
        PALM(2, "palm", MapColor.BROWN),
        REDWOOD(3, "redwood", MapColor.BROWN);

        private static final BlockPVJPlanks.EnumType[] META_LOOKUP = new BlockPVJPlanks.EnumType[values().length];
        private final int meta;
        private final String name, unlocalizedName;
        private final MapColor mapColor;

        private EnumType(int metaIn, String nameIn, MapColor mapColorIn)
        {
            this(metaIn, nameIn, nameIn, mapColorIn);
        }

        private EnumType(int metaIn, String nameIn, String unlocalizedNameIn, MapColor mapColorIn)
        {
            this.meta = metaIn;
            this.name = nameIn;
            this.unlocalizedName = unlocalizedNameIn;
            this.mapColor = mapColorIn;
        }

        public int getMeta()
        {
            return this.meta;
        }

        /**
         * The color which represents this entry on a map.
         */
        public MapColor getMapColor()
        {
            return this.mapColor;
        }

        public String toString()
        {
            return this.name;
        }

        public static BlockPVJPlanks.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName()
        {
            return this.name;
        }

        public String getUnlocalizedName()
        {
            return this.unlocalizedName;
        }

        static
        {
            for (BlockPVJPlanks.EnumType blockplanks$enumtype : values())
            {
                META_LOOKUP[blockplanks$enumtype.getMeta()] = blockplanks$enumtype;
            }
        }
    }
}
