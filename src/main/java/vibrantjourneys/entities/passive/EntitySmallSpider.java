package vibrantjourneys.entities.passive;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

public class EntitySmallSpider extends EntityCritter
{
    public EntitySmallSpider(World world)
    {
        super(world);
        this.setSize(0.28F, 0.18F);
    }

    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 0.8D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.06D);
    }
    
    @Override
    public void setInWeb()
    {
    }

    //is this really necessary? not really
    @Override
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.ARTHROPOD;
    }
    
	@Override
    public boolean getCanSpawnHere()
    {
		if(this.world.provider.getDimensionType() != DimensionType.OVERWORLD)
			return false;
		return super.getCanSpawnHere();
    }
}