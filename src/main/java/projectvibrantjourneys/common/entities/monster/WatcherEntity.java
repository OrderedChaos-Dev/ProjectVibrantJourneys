package projectvibrantjourneys.common.entities.monster;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.common.entities.ai.StareAtGoal;
import projectvibrantjourneys.common.entities.ai.WatcherAttackGoal;

public class WatcherEntity extends MonsterEntity {
	
	private static final DataParameter<Integer> TARGET_ENTITY = EntityDataManager.createKey(WatcherEntity.class, DataSerializers.VARINT);
	private LivingEntity targetedEntity;
	private int clientSideAttackTime;

	public WatcherEntity(EntityType<? extends WatcherEntity> entityType, World world) {
		super(entityType, world);
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(2, new StareAtGoal(this, PlayerEntity.class, 100.0F));
		this.goalSelector.addGoal(1, new WatcherAttackGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(1.0D);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100.0D);
	}
	
	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(TARGET_ENTITY, 0);
	}
	
	public int getAttackDuration() {
		return 30;
	}

	public void setTargetedEntity(int entityId) {
		this.dataManager.set(TARGET_ENTITY, entityId);
		this.clientSideAttackTime = 0;
	}

	public boolean hasTargetedEntity() {
		return this.dataManager.get(TARGET_ENTITY) != 0;
	}
	
	@Nullable
	public LivingEntity getTargetedEntity() {
		if (!this.hasTargetedEntity()) {
			return null;
		} else if (this.world.isRemote) {
			if (this.targetedEntity != null) {
				return this.targetedEntity;
			} else {
				Entity entity = this.world.getEntityByID(this.dataManager.get(TARGET_ENTITY));
				if (entity instanceof LivingEntity) {
					this.targetedEntity = (LivingEntity) entity;
					return this.targetedEntity;
				} else {
					return null;
				}
			}
		} else {
			return this.getAttackTarget();
		}
	}
	
	@Override
	public void notifyDataManagerChange(DataParameter<?> key) {
		super.notifyDataManagerChange(key);
		if (TARGET_ENTITY.equals(key)) {
			this.clientSideAttackTime = 0;
			this.targetedEntity = null;
		}
	}
	
	@Override
	public void livingTick() {
		super.livingTick();
		this.setMotion(this.getMotion().mul(1, 0, 1));
		
        if (this.hasTargetedEntity()) {
            if (this.clientSideAttackTime < this.getAttackDuration()) {
               ++this.clientSideAttackTime;
            }
         }
	}
	
	public float getAttackAnimationScale(float f) {
		return ((float) this.clientSideAttackTime + f) / (float) this.getAttackDuration();
	}
	
	@Override
	protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}
	
	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntitySize size) {
		return size.height * 0.4F;
	}
	
	@OnlyIn(Dist.CLIENT)
	public boolean isInRangeToRenderDist(double distance) {
		return true;
	}
	
	@Override
	@Nullable
	public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason,
			@Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
		if(reason == SpawnReason.NATURAL) {
			BlockPos spawnPos = findSpawnPos(this.getPosition());
			this.setPosition(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ());
		}
		
		return super.onInitialSpawn(world, difficulty, reason, spawnData, dataTag);
	}
	
	private BlockPos findSpawnPos(BlockPos initialPos) {
		int randHeight = 5 + this.rand.nextInt(20);
		for(int i = 0; i < randHeight; i++) {
			if(!this.getEntityWorld().isAirBlock(initialPos.up(i)))
				return initialPos.up(i - 1);
		}
		
		return initialPos.up(randHeight);
	}
	
	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.UNDEFINED;
	}
}
