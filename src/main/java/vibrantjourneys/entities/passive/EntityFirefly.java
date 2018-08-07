package vibrantjourneys.entities.passive;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityFirefly extends EntityFly
{
    public EntityFirefly(World worldIn)
    {
        super(worldIn);
        this.setSize(0.1F, 0.1F);
    }
    
    //Make entity always bright
    @SideOnly(Side.CLIENT)
	@Override
    public int getBrightnessForRender()
    {
        return 15728880;
    }

	@Override
    public float getBrightness()
    {
        return 1.0F;
    }
	
	@Override
    protected int getExperiencePoints(EntityPlayer player)
    {
        return 0;
    }
    
	@Override
    public boolean getCanSpawnHere()
    {
        BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);

        if (blockpos.getY() <= this.world.getSeaLevel())
        {
            return false;
        }
        else
        {
            int i = this.world.getLightFromNeighbors(blockpos);
            int j = 5;

            return i > this.rand.nextInt(j) ? false : super.getCanSpawnHere();
        }
    }
}
