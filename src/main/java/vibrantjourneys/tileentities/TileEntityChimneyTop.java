package vibrantjourneys.tileentities;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import vibrantjourneys.blocks.BlockChimney;

public class TileEntityChimneyTop extends TileEntity implements ITickable
{
	private boolean requiresSmokeSource;
	
	public TileEntityChimneyTop()
	{
		requiresSmokeSource = true;
	}
	
	@Override
	public void update()
	{
		BlockPos posDown = pos.down();
		Block block = world.getBlockState(posDown).getBlock();
		if(block instanceof BlockChimney)
		{
			if(((BlockChimney)block).canSmoke(world, posDown) || !requiresSmokeSource)
			{
        		if(world.isRemote)
        		{
    		        double x = (double)pos.getX() + 0.5D;
    		        double y = (double)pos.getY() + 1.3D;
    		        double z = (double)pos.getZ() + 0.5D;
    		        
    	        	double xPos = x + (0.2 * this.world.rand.nextDouble()) - (0.2 * this.world.rand.nextDouble());
    	        	double zPos = z + (0.2 * this.world.rand.nextDouble()) - (0.2 * this.world.rand.nextDouble());

		            world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, true, xPos, y, zPos, 0.0D, 0.0D, 0.0D);
		            world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, true, xPos, y, zPos, 0.0D, 0.0D, 0.0D);	
        		}
			}
		}
	}
	
	public boolean requiresSmokeSource()
	{
		return requiresSmokeSource;
	}
	
	public void setRequiresSmokeSource()
	{
		requiresSmokeSource = !requiresSmokeSource;
		IBlockState state = world.getBlockState(this.getPos());
		this.world.notifyBlockUpdate(this.getPos(), state, state, 3);
		this.world.markBlockRangeForRenderUpdate(pos, pos);
		this.world.scheduleBlockUpdate(pos, this.getBlockType(), 0, 0);
		this.markDirty();
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		requiresSmokeSource = compound.getBoolean("RequiresSmokeSource");
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setBoolean("RequiresSmokeSource", requiresSmokeSource);
		
		return compound;
	}
	
	@Override
    @Nullable
    public SPacketUpdateTileEntity getUpdatePacket()
    {
        return new SPacketUpdateTileEntity(this.pos, 7, this.writeToNBT(new NBTTagCompound()));
    }
	
	@Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt)
    {
		this.readFromNBT(pkt.getNbtCompound());
    }
	
	@Override
    public NBTTagCompound getUpdateTag()
    {
        return this.writeToNBT(new NBTTagCompound());
    }
}
