package vibrantjourneys.blocks;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.items.ItemPVJBlock;
import vibrantjourneys.util.IPVJBlock;

public class BlockPVJLeaves extends BlockLeaves implements IPVJBlock
{
    public static final PropertyEnum<BlockPVJPlanks.EnumType> VARIANT = PropertyEnum.<BlockPVJPlanks.EnumType>create("variant", BlockPVJPlanks.EnumType.class, new Predicate<BlockPVJPlanks.EnumType>()
    {
        public boolean apply(@Nullable BlockPVJPlanks.EnumType p_apply_1_)
        {
            return p_apply_1_.getMeta() < 4;
        }
    });

    public BlockPVJLeaves()
    {
        this.setDefaultState(this.blockState.getBaseState()
        		.withProperty(VARIANT, BlockPVJPlanks.EnumType.WILLOW)
        		.withProperty(CHECK_DECAY, Boolean.valueOf(true))
        		.withProperty(DECAYABLE, Boolean.valueOf(true)));
    }

    @Override
    protected int getSaplingDropChance(IBlockState state)
    {
        return super.getSaplingDropChance(state);
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        items.add(new ItemStack(this, 1, BlockPVJPlanks.EnumType.WILLOW.getMeta()));
        items.add(new ItemStack(this, 1, BlockPVJPlanks.EnumType.MANGROVE.getMeta()));
        items.add(new ItemStack(this, 1, BlockPVJPlanks.EnumType.PALM.getMeta()));
    }

    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1, ((BlockPVJPlanks.EnumType)state.getValue(VARIANT)).getMeta());
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState()
        		.withProperty(VARIANT, BlockPVJPlanks.EnumType.byMetadata((meta & 3) % 4))
        		.withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0))
        		.withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((BlockPVJPlanks.EnumType)state.getValue(VARIANT)).getMeta();

        if (!((Boolean)state.getValue(DECAYABLE)).booleanValue())
        {
            i |= 4;
        }

        if (((Boolean)state.getValue(CHECK_DECAY)).booleanValue())
        {
            i |= 8;
        }

        return i;
    }

    //pointless abstract method, but required
    @Override
    public BlockPlanks.EnumType getWoodType(int meta)
    {
        return null;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT, CHECK_DECAY, DECAYABLE});
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return ((BlockPVJPlanks.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack)
    {
        if (!worldIn.isRemote && stack.getItem() == Items.SHEARS)
        {
            player.addStat(StatList.getBlockStats(this));
        }
        else
        {
            super.harvestBlock(worldIn, player, pos, state, te, stack);
        }
    }

    @Override
    public NonNullList<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        return NonNullList.withSize(1, new ItemStack(this, 1, world.getBlockState(pos).getValue(VARIANT).getMeta()));
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
	
	//Note: The following 3 methods are not inherited from BlockLeaves and must be manually written
	//--------------------------------------------------------------
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return Blocks.LEAVES.isOpaqueCube(state);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return Blocks.LEAVES.getBlockLayer();
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return Blocks.LEAVES.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }
	//---------------------------------------------------------------
}