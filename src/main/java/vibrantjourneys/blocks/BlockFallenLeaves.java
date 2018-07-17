package vibrantjourneys.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFallenLeaves extends Block
{
	public BlockFallenLeaves()
	{
			super(Material.PLANTS);
	        this.setHardness(0.2F);
	        this.setLightOpacity(1);
	        this.setSoundType(SoundType.PLANT);
	}

	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D);
    }
	
	@Override
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
		return null;
    }

	@Override
    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return true;
    }
	
	@Override
    public boolean causesSuffocation(IBlockState state)
    {
        return false;
    }
	
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
	
	@Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
	
	@Override
    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos)
    {
        return true;
    }
}
