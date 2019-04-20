package vibrantjourneys.entities.ai;

import com.google.common.base.Predicates;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EntitySelectors;

public class EntityAIStareAt extends EntityAIBase
{
    protected EntityLiving entity;
    /** The closest entity which is being watched by this one. */
    protected Entity closestEntity;
    /** This is the Maximum distance that the AI will look for the Entity */
    protected float maxDistanceForPlayer;
    protected Class <? extends Entity > watchedClass;

    public EntityAIStareAt(EntityLiving entityIn, Class <? extends Entity > watchTargetClass, float maxDistance)
    {
        this.entity = entityIn;
        this.watchedClass = watchTargetClass;
        this.maxDistanceForPlayer = maxDistance;
    }

    @Override
    public boolean shouldExecute()
    {
        if (this.entity.getAttackTarget() != null)
        {
            this.closestEntity = this.entity.getAttackTarget();
        }

        if (this.watchedClass == EntityPlayer.class)
        {
            this.closestEntity = this.entity.world.getClosestPlayer(this.entity.posX, this.entity.posY, this.entity.posZ, (double)this.maxDistanceForPlayer, Predicates.and(EntitySelectors.NOT_SPECTATING, EntitySelectors.notRiding(this.entity)));
        }
        else
        {
            this.closestEntity = this.entity.world.findNearestEntityWithinAABB(this.watchedClass, this.entity.getEntityBoundingBox().grow((double)this.maxDistanceForPlayer, 3.0D, (double)this.maxDistanceForPlayer), this.entity);
        }

        return this.closestEntity != null;
    }

    @Override
    public boolean shouldContinueExecuting()
    {
        if (!this.closestEntity.isEntityAlive())
        {
            return false;
        }
        else if (this.entity.getDistanceSq(this.closestEntity) > (double)(this.maxDistanceForPlayer * this.maxDistanceForPlayer))
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    @Override
    public void resetTask()
    {
        this.closestEntity = null;
    }

    @Override
    public void updateTask()
    {
        this.entity.getLookHelper().setLookPosition(this.closestEntity.posX, this.closestEntity.posY + (double)this.closestEntity.getEyeHeight(), this.closestEntity.posZ, (float)this.entity.getHorizontalFaceSpeed(), (float)this.entity.getVerticalFaceSpeed());
    }
}