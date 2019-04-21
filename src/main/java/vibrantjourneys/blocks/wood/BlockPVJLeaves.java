package vibrantjourneys.blocks.wood;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.init.PVJItems;
import vibrantjourneys.util.EnumLeafType;
import vibrantjourneys.util.IPropertyHelper;

public class BlockPVJLeaves extends BlockLeaves implements IPropertyHelper
{
	private EnumLeafType leafType;

    public BlockPVJLeaves(EnumLeafType leafType)
    {
        this.setDefaultState(this.blockState.getBaseState()
        		.withProperty(CHECK_DECAY, Boolean.valueOf(true))
        		.withProperty(DECAYABLE, Boolean.valueOf(true)));
        
        this.leafType = leafType;
    }

    @Override
    protected int getSaplingDropChance(IBlockState state)
    {
    	if(leafType == EnumLeafType.BAOBAB)
    	{
    		return 80;
    	}
    	else if(leafType == EnumLeafType.REDWOOD)
    	{
    		return 50;
    	}
    	else if(leafType == EnumLeafType.PINE)
    	{
    		return 15;
    	}
    	else if(leafType == EnumLeafType.PINK_CHERRY_BLOSSOM || leafType == EnumLeafType.WHITE_CHERRY_BLOSSOM)
    	{
    		return 80;
    	}
    	else if(leafType == EnumLeafType.JACARANDA)
    	{
    		return 70;
    	}
    	else if(leafType == EnumLeafType.COTTONWOOD)
    	{
    		return 70;
    	}
    	else if(leafType == EnumLeafType.FIR)
    	{
    		return 40;
    	}
    	
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
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
    	Block block = PVJBlocks.SAPLINGS.get(leafType.getID());
    	if(leafType.getID() == EnumLeafType.JUNIPER_BERRIED.getID())
    		block = PVJBlocks.SAPLINGS.get(EnumLeafType.JUNIPER.getID());
    	
        return Item.getItemFromBlock(block);
    }
    
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		if(!world.isRemote)
		{
			if(leafType.getID() == EnumLeafType.JUNIPER_BERRIED.getID())
			{
				int amount = world.rand.nextInt(2) + 1;
				ItemStack berries = new ItemStack(PVJItems.juniper_berries, amount);
				InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), berries);
				world.setBlockState(pos, PVJBlocks.LEAVES.get(EnumLeafType.JUNIPER.getID()).getDefaultState()
						.withProperty(CHECK_DECAY, state.getValue(CHECK_DECAY)).withProperty(DECAYABLE, state.getValue(DECAYABLE)));
				return true;
			}
		}
		
		return false;
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
	
	//Note: The following 3 methods are not inherited from BlockLeaves and must be manually written
	//--------------------------------------------------------------
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return Blocks.LEAVES.isOpaqueCube(state);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer()
    {
        return Blocks.LEAVES.getRenderLayer();
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return Blocks.LEAVES.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }
	//---------------------------------------------------------------
	
	@Override
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
    	return Blocks.LEAVES.getFlammability(world, pos, face);
    }
	
	@Override
    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return Blocks.LEAVES.getFireSpreadSpeed(world, pos, face);
    }
	
	@Override
	public ImmutableList<IBlockState> getProperties()
	{
		return this.blockState.getValidStates();
	}
	
    @Override
    public NonNullList<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune)
    {
        return NonNullList.withSize(1, new ItemStack(this, 1, 3));
    }
}