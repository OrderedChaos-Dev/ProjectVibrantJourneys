package vibrantjourneys.blocks.plant;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import vibrantjourneys.util.IPropertyHelper;

public class BlockCattail extends BlockBush implements IPropertyHelper
{
    public static final PropertyEnum<BlockCattail.EnumBlockHalf> HALF = PropertyEnum.<BlockCattail.EnumBlockHalf>create("half", BlockCattail.EnumBlockHalf.class);

    public BlockCattail()
    {
        super(Material.VINE);
        this.setDefaultState(this.blockState.getBaseState().withProperty(HALF, BlockCattail.EnumBlockHalf.LOWER));
        this.setHardness(0.0F);
        this.setSoundType(SoundType.PLANT);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return FULL_BLOCK_AABB;
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
    	if(!worldIn.isAirBlock(pos.up()))
    	{
    		return false;	
    	}
    	
        IBlockState state = worldIn.getBlockState(pos.down());
        Block block = state.getBlock();

        if (block != Blocks.GRASS && block != Blocks.DIRT && block != Blocks.SAND && block != Blocks.GRAVEL)
        {
            return false;
        }
        else
        {
            BlockPos blockpos = pos.down();

            for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
            {
                IBlockState iblockstate = worldIn.getBlockState(blockpos.offset(enumfacing));

                if (iblockstate.getMaterial() == Material.WATER || iblockstate.getBlock() == Blocks.FROSTED_ICE)
                {
                    return true;
                }
            }

            return false;
        }
    }

    @Override
    protected void checkAndDropBlock(World world, BlockPos pos, IBlockState state)
    {
        if (!this.canBlockStay(world, pos, state))
        {
            boolean flag = state.getValue(HALF) == BlockCattail.EnumBlockHalf.UPPER;
            BlockPos blockpos = flag ? pos : pos.up();
            BlockPos blockpos1 = flag ? pos.down() : pos;
            Block block = (Block)(flag ? this : world.getBlockState(blockpos).getBlock());
            Block block1 = (Block)(flag ? world.getBlockState(blockpos1).getBlock() : this);

            if (!flag) this.dropBlockAsItem(world, pos, state, 0); //Forge move above the setting to air.

            if (block == this)
            {
                world.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 2);
            }

            if (block1 == this)
            {
                world.setBlockState(blockpos1, Blocks.AIR.getDefaultState(), 3);
            }
        }
    }

    @Override
    public boolean canBlockStay(World world, BlockPos pos, IBlockState state)
    {
        if (state.getBlock() != this) return super.canBlockStay(world, pos, state); //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
        if (state.getValue(HALF) == BlockCattail.EnumBlockHalf.UPPER)
        {
            return world.getBlockState(pos.down()).getBlock() == this;
        }
        else
        {
        	boolean isSoil = false;
        	Block block = world.getBlockState(pos.down()).getBlock();
	        if (block == Blocks.GRASS || block == Blocks.DIRT || block == Blocks.SAND || block == Blocks.GRAVEL)
	        {
	        	isSoil = true;
	        }
	        
	        boolean flag = false;
	        
	        if(isSoil)
	        {
	            BlockPos blockpos = pos.down();
	
	            for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
	            {
	                IBlockState iblockstate = world.getBlockState(blockpos.offset(enumfacing));
	
	                if (iblockstate.getMaterial() == Material.WATER || iblockstate.getBlock() == Blocks.FROSTED_ICE)
	                {
	                    flag = true;
	                    break;
	                }
	            }
	        }

            IBlockState iblockstate = world.getBlockState(pos.up());
            return iblockstate.getBlock() == this && flag;
        }
    }
    
    @Override
    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos)
    {
    	return false;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        if (state.getValue(HALF) == BlockCattail.EnumBlockHalf.UPPER)
        {
            return Items.AIR;
        }
        else
        {
            return super.getItemDropped(state, rand, fortune);
        }
    }

    public void placeAt(World worldIn, BlockPos lowerPos, int flags)
    {
        worldIn.setBlockState(lowerPos, this.getDefaultState().withProperty(HALF, BlockCattail.EnumBlockHalf.LOWER), flags);
        worldIn.setBlockState(lowerPos.up(), this.getDefaultState().withProperty(HALF, BlockCattail.EnumBlockHalf.UPPER), flags);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        //worldIn.setBlockState(pos.up(), this.getDefaultState().withProperty(HALF, BlockCattail.EnumBlockHalf.UPPER), 2);
    	this.placeAt(worldIn, pos, 2);
    }

    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack)
    {
    	super.harvestBlock(worldIn, player, pos, state, te, stack);
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        if (state.getValue(HALF) == BlockCattail.EnumBlockHalf.UPPER)
        {
            if (world.getBlockState(pos.down()).getBlock() == this)
            {
                if (player.capabilities.isCreativeMode)
                {
                    world.setBlockToAir(pos.down());
                }
                else
                {
                    world.destroyBlock(pos.down(), true);
                    if (world.isRemote)
                    {
                        world.setBlockToAir(pos.down());
                    }
                    else
                    {
                        world.destroyBlock(pos.down(), true);
                    }
                }
            }
        }
        else if (world.getBlockState(pos.up()).getBlock() == this)
        {
            world.setBlockState(pos.up(), Blocks.AIR.getDefaultState(), 2);
        }

        super.onBlockHarvested(world, pos, state, player);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return meta == 0 ? this.getDefaultState().withProperty(HALF, BlockCattail.EnumBlockHalf.UPPER) : this.getDefaultState().withProperty(HALF, BlockCattail.EnumBlockHalf.LOWER);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(HALF) == BlockCattail.EnumBlockHalf.UPPER ? 0 : 1;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {HALF});
    }

    @Override
    public Block.EnumOffsetType getOffsetType()
    {
        return Block.EnumOffsetType.XZ;
    }

    public static enum EnumBlockHalf implements IStringSerializable
    {
        UPPER,
        LOWER;

        public String toString()
        {
            return this.getName();
        }

        public String getName()
        {
            return this == UPPER ? "upper" : "lower";
        }
    }

	@Override
	public ImmutableList<IBlockState> getProperties()
	{
		return this.blockState.getValidStates();
	}
}