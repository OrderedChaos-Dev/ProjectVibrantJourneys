package vibrantjourneys.tileentities;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import vibrantjourneys.blocks.BlockCeilingLamp;
import vibrantjourneys.blocks.BlockLightbulb;

public class TileEntityCircuitBreaker extends TileEntity
{
	private boolean isPowering;
	
	public TileEntityCircuitBreaker()
	{
		isPowering = false;
	}
	
	public void flipSwitch(boolean theBestBooleanToEverExist)
	{
		isPowering = theBestBooleanToEverExist;
		int x = this.getPos().getX();
		int y = this.getPos().getY();
		int z = this.getPos().getZ();
		
		for(BlockPos pos : BlockPos.getAllInBoxMutable(new BlockPos(x - 10, y - 10, z - 10), new BlockPos(x + 10, y + 10, z + 10)))
		{
			IBlockState state = world.getBlockState(pos);
			if(state.getBlock() instanceof BlockLightbulb)
			{
				world.setBlockState(pos, state.withProperty(BlockLightbulb.POWERED, isPowering()), 3);
			}
			else if(state.getBlock() instanceof BlockCeilingLamp)
			{
				world.setBlockState(pos, state.withProperty(BlockCeilingLamp.POWERED, isPowering()), 3);
			}
		}
	}
	
	public boolean isPowering()
	{
		return isPowering;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		isPowering = compound.getBoolean("Powering");
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		compound.setBoolean("Powering", isPowering);
		return compound;
	}
}
