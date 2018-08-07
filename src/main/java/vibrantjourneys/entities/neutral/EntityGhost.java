package vibrantjourneys.entities.neutral;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.entities.ai.EntityAIAvoidLight;
import vibrantjourneys.util.PVJLootTableList;

public class EntityGhost extends EntityMob
{
    protected static final DataParameter<Boolean> IS_FADING = EntityDataManager.<Boolean>createKey(EntityGhost.class, DataSerializers.BOOLEAN);
	
	public EntityGhost(World world)
	{
		super(world);
	}
	
	@Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(IS_FADING, Boolean.valueOf(false));
    }
	
	@Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAvoidLight(this, 1.0D));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 16.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
    }
    
	@Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
    }
	
	@SideOnly(Side.CLIENT)
	public boolean getIsFading()
	{
		return this.getDataManager().get(IS_FADING).booleanValue();
	}
	
	//poof!
	public void poof()
	{
		this.spawnExplosionParticle();
		this.world.removeEntity(this);
	}

	@Override
    public void onUpdate()
    {
        super.onUpdate();
        
        if (!this.world.isRemote)
        {
            BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);
            int i = this.world.getLightFromNeighbors(blockpos);
            
            if(!this.getIsFading())
            {
                if(i > 7)
                {
                	if(this.getRNG().nextInt(300) == 0)
                		this.dataManager.set(IS_FADING, Boolean.valueOf(true));
                }
            }
            if(getIsFading())
            {
            	//stop fading process when ghost returns to the dark
            	if(i <= 7)
            		this.dataManager.set(IS_FADING, Boolean.valueOf(false));
            	else
            	{
                	this.tasks.removeTask(new EntityAIHurtByTarget(this, false, new Class[0]));
                	if(this.getRNG().nextInt(300) == 0)
                		poof();
            	}
            }
        }
    }
	
	@Override
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }
	
	@Override
	protected ResourceLocation getLootTable()
	{
		return PVJLootTableList.GHOST;
	}
	
    @Override
    public void fall(float distance, float damageMultiplier){}
}
