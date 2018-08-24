package vibrantjourneys.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import vibrantjourneys.tileentities.TileEntityCircuitBreaker;

public class BlockCircuitBreaker extends Block
{
	public BlockCircuitBreaker()
	{
		super(Material.IRON);
	}
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		if(!world.isRemote)
		{
			TileEntity te = world.getTileEntity(pos);
			if(te instanceof TileEntityCircuitBreaker)
			{
				((TileEntityCircuitBreaker)te).flipSwitch(!((TileEntityCircuitBreaker)te).isPowering());
			}
		}
		return true;
    }

	@Override
	public boolean hasTileEntity(IBlockState state)
	{
		return true;
	}

	@Override
	public TileEntity createTileEntity(World worldIn, IBlockState state)
	{
		return new TileEntityCircuitBreaker();
	}
}
