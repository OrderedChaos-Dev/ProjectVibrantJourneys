package vibrantjourneys.entities.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.DamageSource;
import vibrantjourneys.entities.neutral.EntityWatcher;

public class EntityWatcherAttack extends EntityAIBase
{
    private final EntityWatcher watcher;
    private int tickCounter;

    public EntityWatcherAttack(EntityWatcher watcher)
    {
        this.watcher = watcher;
    }

    @Override
    public boolean shouldExecute()
    {
        EntityLivingBase entitylivingbase = this.watcher.getAttackTarget();
        return entitylivingbase != null && entitylivingbase.isEntityAlive();
    }

    @Override
    public void startExecuting()
    {
        this.tickCounter = -10;
        this.watcher.getNavigator().clearPath();
        this.watcher.getLookHelper().setLookPositionWithEntity(this.watcher.getAttackTarget(), 90.0F, 90.0F);
        this.watcher.isAirBorne = true;
    }

    @Override
    public void resetTask()
    {
        this.watcher.setTargetedEntity(0);
        this.watcher.setAttackTarget((EntityLivingBase)null);
    }

    @Override
    public void updateTask()
    {
        EntityLivingBase entitylivingbase = this.watcher.getAttackTarget();
        this.watcher.getNavigator().clearPath();
        this.watcher.getLookHelper().setLookPositionWithEntity(entitylivingbase, 90.0F, 90.0F);

        if (!this.watcher.canEntityBeSeen(entitylivingbase))
        {
            this.watcher.setAttackTarget((EntityLivingBase)null);
        }
        else
        {
            ++this.tickCounter;

            if (this.tickCounter == 0)
            {
                this.watcher.setTargetedEntity(this.watcher.getAttackTarget().getEntityId());
            }
            else if (this.tickCounter >= this.watcher.getAttackDuration())
            {

                entitylivingbase.attackEntityFrom(DamageSource.causeMobDamage(this.watcher),
                		(float)this.watcher.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue());
                tickCounter = 0;
            }

            super.updateTask();
        }
    }
}