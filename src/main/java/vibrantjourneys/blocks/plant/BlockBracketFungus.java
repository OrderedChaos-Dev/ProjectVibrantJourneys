package vibrantjourneys.blocks.plant;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.blocks.wood.BlockBark;
import vibrantjourneys.util.IPropertyHelper;

public class BlockBracketFungus extends BlockHorizontal implements IPropertyHelper
{
	public BlockBracketFungus()
	{
		super(Material.PLANTS);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}
	
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        pos = pos.offset((EnumFacing)state.getValue(FACING).getOpposite());
        IBlockState iblockstate = worldIn.getBlockState(pos);
        return iblockstate.getBlock() instanceof BlockLog || iblockstate.getBlock() instanceof BlockBark;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
    	EnumFacing facing = state.getValue(FACING);
        if(facing == EnumFacing.NORTH)
        {
        	return new AxisAlignedBB(0, 0, 0.7, 1, 1, 1);
        }
        if(facing == EnumFacing.SOUTH)
        {
        	return new AxisAlignedBB(0, 0, 0, 1, 1, 0.3);
        }
        if(facing == EnumFacing.WEST)
        {
        	return new AxisAlignedBB(0.7, 0, 0, 1, 1, 1);
        }
        if(facing == EnumFacing.EAST)
        {
        	return new AxisAlignedBB(0, 0, 0, 0.3, 1, 1);
        }
        return new AxisAlignedBB(0, 0, 0, 0.25, 1, 1);
    }
    
    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }
    
    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }
    
    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        if (!facing.getAxis().isHorizontal())
        {
            facing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, facing);
    }
    
    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (!this.canBlockStay(worldIn, pos, state))
        {
            this.dropBlock(worldIn, pos, state);
        }
    }

    private void dropBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
        this.dropBlockAsItem(worldIn, pos, state, 0);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
    	return state.getValue(FACING).getIndex();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }
    
	@Override
	public ImmutableList<IBlockState> getProperties()
	{
		return this.blockState.getValidStates();
	}
}
