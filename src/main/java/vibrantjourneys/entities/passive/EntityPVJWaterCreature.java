package vibrantjourneys.entities.passive;

import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityPVJWaterCreature extends EntityWaterMob
{
	public EntityPVJWaterCreature(World world)
	{
		super(world);
	}

	@Override
    protected int getExperiencePoints(EntityPlayer player)
    {
        return 0;
    }
	
	@Override
    public void onEntityUpdate()
    {
		super.onEntityUpdate();
		if(this.getAir() < 0)
			this.setAir(0);	
    }
	
    @SideOnly(Side.CLIENT)
    @Override
    public boolean isInRangeToRenderDist(double distance)
    {
    	return true;
    }
	
	@Override
    public float getEyeHeight()
    {
        return this.height;
    }
}
