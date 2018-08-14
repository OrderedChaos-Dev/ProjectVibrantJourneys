package vibrantjourneys.entities.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntityMob;
import vibrantjourneys.entities.monster.EntityGoon;

public class EntityAIGoonPukeSilverfish<T extends EntityMob> extends EntityAIBase
{
    private final T entity;
    private final double moveSpeedAmp;
    private int attackCooldown;
    private final float maxAttackDistance;
    private int attackTime;
    private int seeTime;
    private boolean strafingClockwise;
    private boolean strafingBackwards;
    private int strafingTime = -1;

    public EntityAIGoonPukeSilverfish(T entity, double moveSpeed, int cooldown, float maxAttackDistance)
    {
        this.entity = entity;
        this.moveSpeedAmp = moveSpeed;
        this.attackCooldown = cooldown;
        this.attackTime = attackCooldown;
        this.maxAttackDistance = maxAttackDistance * maxAttackDistance;
        this.setMutexBits(3);
    }
    
    @Override
    public boolean shouldExecute()
    {
        return this.entity.getAttackTarget() == null ? false : true;
    }

    @Override
    public boolean shouldContinueExecuting()
    {
        return (this.shouldExecute() || !this.entity.getNavigator().noPath());
    }

    @Override
    public void resetTask()
    {
        super.resetTask();

        this.seeTime = 0;
        this.attackTime = attackCooldown;
    }

    @Override
    public void updateTask()
    {
        EntityLivingBase target = this.entity.getAttackTarget();

        if (target != null)
        {
            double d0 = this.entity.getDistanceSq(target.posX, target.getEntityBoundingBox().minY, target.posZ);
            boolean flag = this.entity.getEntitySenses().canSee(target);
            boolean flag1 = this.seeTime > 0;

            if (flag != flag1)
            {
                this.seeTime = 0;
            }

            if (flag)
            {
                ++this.seeTime;
            }
            else
            {
                --this.seeTime;
            }
            
            this.attackTime--;
            if(attackTime <= 0)
            {
            	((EntityGoon)entity).pukeSilverfish(target);
            	attackTime = attackCooldown;
            }
            

            if (d0 <= (double)this.maxAttackDistance && this.seeTime >= 20)
            {
                this.entity.getNavigator().clearPath();
                ++this.strafingTime;
            }
            else
            {
                this.entity.getNavigator().tryMoveToEntityLiving(target, this.moveSpeedAmp);
                this.strafingTime = -1;
            }

            if (this.strafingTime >= 20)
            {
                if ((double)this.entity.getRNG().nextFloat() < 0.3D)
                {
                    this.strafingClockwise = !this.strafingClockwise;
                }

                if ((double)this.entity.getRNG().nextFloat() < 0.3D)
                {
                    this.strafingBackwards = !this.strafingBackwards;
                }

                this.strafingTime = 0;
            }

            if (this.strafingTime > -1)
            {
                if (d0 > (double)(this.maxAttackDistance * 0.75F))
                {
                    this.strafingBackwards = false;
                }
                else if (d0 < (double)(this.maxAttackDistance * 0.25F))
                {
                    this.strafingBackwards = true;
                }

                this.entity.getMoveHelper().strafe(this.strafingBackwards ? -0.5F : 0.5F, this.strafingClockwise ? 0.5F : -0.5F);
                this.entity.faceEntity(target, 30.0F, 30.0F);
            }
            else
            {
                this.entity.getLookHelper().setLookPositionWithEntity(target, 30.0F, 30.0F);
            }
        }
    }
}