package vibrantjourneys.entities.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.util.DamageSource;

public class EntityAISilverfishDeathTimer extends EntityAIBase
{
	private final EntitySilverfish entity;
	private int damageTime = 35;
	
	public EntityAISilverfishDeathTimer(EntitySilverfish entity)
	{
		this.entity = entity;
	}
	
	@Override
	public boolean shouldExecute()
	{
		return true;
	}

    @Override
    public boolean shouldContinueExecuting()
    {
        return true;
    }
    
    @Override
    public void updateTask()
    {
    	damageTime--;
    	if(damageTime <= 0)
    	{
        	this.entity.attackEntityFrom(DamageSource.WITHER, 1.0F);
        	damageTime = 35;
    	}
    }
}
