package vibrantjourneys.entities.passive;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import vibrantjourneys.util.LootTableHandler;

public class EntitySnail extends EntityAnimal
{
    public EntitySnail(World worldIn)
    {
        super(worldIn);
        this.setSize(0.25F, 0.2F);
        this.setPathPriority(PathNodeType.WATER, -1.0F);
    }
    
	@Override
    public float getEyeHeight()
    {
        return this.height;
    }
    
	@Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAIWanderAvoidWater(this, 1.0D));
    }
    
	@Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
    }
    
	@Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();

    }
	
	@Override
    protected boolean canDespawn()
    {
        return true;
    }
	
	@Override
    protected int getExperiencePoints(EntityPlayer player)
    {
        return 1;
    }
    
    //Override parent for no collision/no fall damage
    //----------------------------------------
    @Override
    protected void collideWithEntity(Entity entityIn){}

    @Override
    protected void collideWithNearbyEntities(){}
    
    @Override
    public void fall(float distance, float damageMultiplier){}
    //----------------------------------------

	@Override
    protected boolean canTriggerWalking()
    {
        return false;
    }
	
	@Override
	protected ResourceLocation getLootTable()
	{
		return LootTableHandler.SNAIL;
	}
    
	@Override
	public EntityAgeable createChild(EntityAgeable ageable)
	{
		return null;
	}
}