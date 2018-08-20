package vibrantjourneys.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.tileentities.TileEntityChimneyTop;

public class BlockChimneyTop extends Block
{
	public BlockChimneyTop()
	{
		super(Material.ROCK);
		this.setResistance(10.0F);
		this.setHardness(2.3F);
		this.setSoundType(SoundType.STONE);
	}
	
	@Override
    public boolean canPlaceBlockAt(World world, BlockPos pos)
    {
        return world.getBlockState(pos.down()).getBlock() instanceof BlockChimney;
    }
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		if(world.isRemote)
		{
			return true;
		}
		else
		{
			if(player.isSneaking())
			{
				TileEntity te = world.getTileEntity(pos);
				if(te instanceof TileEntityChimneyTop)
				{
					((TileEntityChimneyTop)te).setRequiresSmokeSource();
					player.sendMessage(new TextComponentString("Requires Smoke Source: " + ((TileEntityChimneyTop)te).requiresSmokeSource()));
					return true;
				}
			}
		}
		return false;
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
		return new TileEntityChimneyTop();
	}
}
