package vibrantjourneys.blocks;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
import vibrantjourneys.util.EnumWoodType;
import vibrantjourneys.util.IPVJBlock;

public class BlockPVJLeaves extends BlockLeaves implements IPVJBlock
{
	private EnumWoodType woodType;

    public BlockPVJLeaves(EnumWoodType woodType)
    {
        this.setDefaultState(this.blockState.getBaseState()
        		.withProperty(CHECK_DECAY, Boolean.valueOf(true))
        		.withProperty(DECAYABLE, Boolean.valueOf(true)));
        
        this.woodType = woodType;
    }

    @Override
    protected int getSaplingDropChance(IBlockState state)
    {
        return super.getSaplingDropChance(state);
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
        return new BlockStateContainer(this, new IProperty[] {CHECK_DECAY, DECAYABLE});
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
        return NonNullList.withSize(1, new ItemStack(this, 1));
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
    	boolean decayable = false;
    	if(meta < 2)
    		decayable = true;
    	
    	boolean check_decay = false;
    	if(meta == 1 || meta == 2)
    		check_decay = true;
    	
        return this.getDefaultState()
        		.withProperty(DECAYABLE, Boolean.valueOf(decayable))
        		.withProperty(CHECK_DECAY, Boolean.valueOf(check_decay));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        if(state.getValue(DECAYABLE).booleanValue() && state.getValue(CHECK_DECAY).booleanValue())
        {
            return 1;
        }
        else if(!state.getValue(DECAYABLE).booleanValue() && state.getValue(CHECK_DECAY).booleanValue())
        {
        	return 2;
        }
        else if(!state.getValue(DECAYABLE).booleanValue() && !state.getValue(CHECK_DECAY).booleanValue())
        {
        	return 3;
        }
        else
        {
        	return 0;
        }
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
		return "";
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