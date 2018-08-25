package vibrantjourneys.blocks;

import net.minecraft.block.BlockLever;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCircuitBreaker extends BlockLever
{
	public BlockCircuitBreaker()
	{
		this.setHardness(0.3F);
		this.setResistance(10.0F);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, BlockLever.EnumOrientation.NORTH).withProperty(POWERED, Boolean.valueOf(false)));
	}
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
		if(!world.isRemote)
		{
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			
			for(BlockPos position : BlockPos.getAllInBoxMutable(new BlockPos(x - 10, y - 10, z - 10), new BlockPos(x + 10, y + 10, z + 10)))
			{
				IBlockState blockstate = world.getBlockState(position);
				if(blockstate.getBlock() instanceof BlockLightbulb)
				{
					world.setBlockState(position, blockstate.withProperty(BlockLightbulb.POWERED, !state.getValue(POWERED)), 3);
				}
				else if(blockstate.getBlock() instanceof BlockCeilingLamp)
				{
					world.setBlockState(position, blockstate.withProperty(BlockCeilingLamp.POWERED, !state.getValue(POWERED)), 3);
				}
			}
		}
		return true;
    }
}
