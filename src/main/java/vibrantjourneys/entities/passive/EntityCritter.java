package vibrantjourneys.entities.passive;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityCritter extends EntityAmbientCreature
{
	public EntityCritter(World world)
	{
		super(world);
	}
	
	@Override
    protected boolean canDespawn()
    {
        return true;
    }
	
	@Override
    public boolean getCanSpawnHere()
    {
		if(this.posY < 55)
			return false;
		
		return super.getCanSpawnHere();
    }
	
    @Override
    protected void collideWithEntity(Entity entityIn){}

    @Override
    protected void collideWithNearbyEntities(){}
    
    @Override
    public void fall(float distance, float damageMultiplier){}
    
	@Override
    protected boolean canTriggerWalking()
    {
        return false;
    }
	
	@Override
    protected int getExperiencePoints(EntityPlayer player)
    {
        return 0;
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
	
	@Override
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
		return false;
    }
}
