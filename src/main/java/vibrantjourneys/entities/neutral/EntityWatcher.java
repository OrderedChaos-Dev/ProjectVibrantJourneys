package vibrantjourneys.entities.neutral;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import vibrantjourneys.entities.ai.EntityAIStareAt;
import vibrantjourneys.entities.ai.EntityWatcherAttack;
import vibrantjourneys.util.PVJLootTableList;

public class EntityWatcher extends EntityMob
{
    private static final DataParameter<Integer> TARGET_ENTITY = EntityDataManager.<Integer>createKey(EntityWatcher.class, DataSerializers.VARINT);
    private EntityLivingBase targetedEntity;
    private int clientSideAttackTime;
    
	public EntityWatcher(World world)
	{
		super(world);
		this.setSize(1.0F, 1.0F);
	}
	
	@Override
    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(TARGET_ENTITY, Integer.valueOf(0));
    }
	
	@Override
    protected void initEntityAI()
    {
		this.tasks.addTask(4, new EntityAIStareAt(this, EntityPlayer.class, 90.0F));
		this.tasks.addTask(1, new EntityWatcherAttack(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
    }
	
	@Override
    public float getEyeHeight()
    {
        return this.height * 0.5F;
    }

	@Override
    public void onUpdate()
    {
		super.onUpdate();
		//watchers don't move
		this.motionY = 0.0;
    }
	
	@Override
    public void onLivingUpdate()
    {
		super.onLivingUpdate();
		
        if (this.world.isRemote)
        {
            if (this.hasTargetedEntity())
            {
                if (this.clientSideAttackTime < this.getAttackDuration())
                {
                    ++this.clientSideAttackTime;
                }
                else
                {
                	this.clientSideAttackTime = 0;
                }
            }
        }
    }
	
    public float getAttackAnimationScale()
    {
        return ((float)this.clientSideAttackTime) / (float)this.getAttackDuration();
    }
	
	@Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(90.0D);
    }
	
    public void setTargetedEntity(int entityId)
    {
        this.dataManager.set(TARGET_ENTITY, Integer.valueOf(entityId));
    }

    public boolean hasTargetedEntity()
    {
        return ((Integer)this.dataManager.get(TARGET_ENTITY)).intValue() != 0;
    }
    
    @Nullable
    public EntityLivingBase getTargetedEntity()
    {
        if (!this.hasTargetedEntity())
        {
            return null;
        }
        else if (this.world.isRemote)
        {
            if (this.targetedEntity != null)
            {
                return this.targetedEntity;
            }
            else
            {
                Entity entity = this.world.getEntityByID(((Integer)this.dataManager.get(TARGET_ENTITY)).intValue());

                if (entity instanceof EntityLivingBase)
                {
                    this.targetedEntity = (EntityLivingBase)entity;
                    return this.targetedEntity;
                }
                else
                {
                    return null;
                }
            }
        }
        else
        {
            return this.getAttackTarget();
        }
    }
    
    public int getAttackDuration()
    {
        return 70;
    }
    
	@Override
	protected ResourceLocation getLootTable()
	{
		return PVJLootTableList.WATCHER;
	}
    
    @Override
    public void notifyDataManagerChange(DataParameter<?> key)
    {
        super.notifyDataManagerChange(key);

        if (TARGET_ENTITY.equals(key))
        {
            this.clientSideAttackTime = 0;
            this.targetedEntity = null;
        }
    }
	
	@Override
    public boolean getCanSpawnHere()
    {
		return world.isAirBlock(new BlockPos(this.posX, this.posY, this.posZ));
    }
}
