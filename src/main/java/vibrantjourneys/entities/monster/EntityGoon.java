package vibrantjourneys.entities.monster;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import vibrantjourneys.entities.ai.EntityAIGoonPukeSilverfish;
import vibrantjourneys.entities.ai.EntityAISilverfishDeathTimer;
import vibrantjourneys.init.PVJSounds;
import vibrantjourneys.util.PVJConfig;
import vibrantjourneys.util.PVJLootTableList;

public class EntityGoon extends EntityMob
{
	private int maxSilverfishSpawned;
	private int silverfishSpawned;
	
	public EntityGoon(World world)
	{
		super(world);
        this.setSize(0.52F, 1.6575F);
        maxSilverfishSpawned = world.rand.nextInt(2) + 4 + (world.rand.nextInt(5) < 2 ? 1 : 0);
        silverfishSpawned = 0;
	}

	@Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
    	this.tasks.addTask(4, new EntityAIGoonPukeSilverfish<EntityGoon>(this, 1.1, 60, 15));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(3, new EntityAIAvoidEntity<EntityChicken>(this, EntityChicken.class, 6.0F, 1.0D, 1.2D));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.applyEntityAI();
    }

    protected void applyEntityAI()
    {
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<EntityIronGolem>(this, EntityIronGolem.class, true));
    }

	@Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
    }
	
	@Override
    public void onLivingUpdate()
    {
        if (this.world.isDaytime() && !this.world.isRemote)
        {
            float f = this.getBrightness();

            if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.world.canSeeSky(new BlockPos(this.posX, this.posY + (double)this.getEyeHeight(), this.posZ)))
            {
                boolean flag = true;

                if (flag)
                {
                    this.setFire(8);
                }
            }
        }

        super.onLivingUpdate();
    }
	
	@Override
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }

    @Nullable
    @Override
    protected ResourceLocation getLootTable()
    {
        return PVJLootTableList.GOON;
    }
    
	@Override
    protected SoundEvent getAmbientSound()
    {
        return PVJConfig.entities.replaceGoonSounds ? SoundEvents.ENTITY_ZOMBIE_AMBIENT : PVJSounds.GOON_AMBIENT;
    }

	@Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return PVJConfig.entities.replaceGoonSounds ? SoundEvents.ENTITY_ZOMBIE_HURT : PVJSounds.GOON_HURT;
    }

	@Override
    protected SoundEvent getDeathSound()
    {
        return PVJConfig.entities.replaceGoonSounds ? SoundEvents.ENTITY_ZOMBIE_DEATH : PVJSounds.GOON_DEATH;
    }
    
    //yeah no one wants to deal with many goons at once
    @Override
    public int getMaxSpawnedInChunk()
    {
        return 1;
    }
    
    public void incrementSilverfish()
    {
    	silverfishSpawned++;
    	if(silverfishSpawned >= maxSilverfishSpawned)
    	{
    		this.tasks.removeTask(new EntityAIGoonPukeSilverfish<EntityGoon>(this, 1.1, 60, 15));
            this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
    	}
    }
    
    public void pukeSilverfish(EntityLivingBase target)
    {
    	if(!this.world.isRemote)
    	{
        	EntitySilverfish silverfish = new EntitySilverfish(this.world);
        	silverfish.tasks.taskEntries.clear();
        	silverfish.tasks.addTask(4, new EntityAIAttackMelee(silverfish, 1.0D, false));
        	silverfish.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
        	silverfish.tasks.addTask(10, new EntityAISilverfishDeathTimer(silverfish));
        	silverfish.setPosition(this.posX, this.posY, this.posZ);
        	this.world.spawnEntity(silverfish);
        	this.playSound(PVJConfig.entities.replaceGoonSounds ? SoundEvents.ENTITY_ZOMBIE_HURT : PVJSounds.GOON_PUKE, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        	silverfish.setAttackTarget(target);
        	
        	incrementSilverfish();
    	}
    }
    
    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setInteger("SilverfishSpawned", silverfishSpawned);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        silverfishSpawned = compound.getInteger("SilverfishSpawned");
    }
    
	@Override
    public boolean getCanSpawnHere()
    {
		if(this.world.provider.getDimensionType() != DimensionType.OVERWORLD)
			return false;
        return super.getCanSpawnHere();
    }
}
