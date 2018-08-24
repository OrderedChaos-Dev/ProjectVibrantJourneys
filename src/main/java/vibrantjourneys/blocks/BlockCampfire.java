package vibrantjourneys.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.ProjectVibrantJourneys;
import vibrantjourneys.tileentities.TileEntityCampfire;

public class BlockCampfire extends Block
{
	public BlockCampfire()
	{
		super(Material.ROCK);
		this.setHarvestLevel("pickaxe", 0);
		this.setHardness(0.0F);
		this.setLightLevel(0.8F);
	}
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		if(!world.isRemote)
		{
			TileEntity te = world.getTileEntity(pos);
			if(te instanceof TileEntityCampfire)
			{
				player.openGui(ProjectVibrantJourneys.instance, 0, world, pos.getX(), pos.getY(), pos.getZ());
			}
		}
		return true;
    }
	
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0.250D, 0.0D, 0.250D, 0.750D, 0.250D, 0.750D);
    }
	
    @SideOnly(Side.CLIENT)
    @Override
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        double x = (double)pos.getX() + 0.5D;
        double y = (double)pos.getY() + 0.2D;
        double z = (double)pos.getZ() + 0.5D;

        worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x, y, z, 0.0D, 0.0D, 0.0D);
        worldIn.spawnParticle(EnumParticleTypes.FLAME, x, y, z, 0.0D, 0.0D, 0.0D);
    }
	
	@Override
    public boolean canPlaceBlockAt(World world, BlockPos pos)
    {
        return world.isSideSolid(pos.down(), EnumFacing.UP);
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
	
	@Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return true;
    }
	
	@Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }
	
	@Override
	public boolean hasTileEntity(IBlockState state)
	{
		return true;
	}

	@Override
	public TileEntity createTileEntity(World worldIn, IBlockState state)
	{
		return new TileEntityCampfire();
	}
}
