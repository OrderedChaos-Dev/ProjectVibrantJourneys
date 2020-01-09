package projectvibrantjourneys.common.entities.monster;

import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.FleeSunGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RestrictSunGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import projectvibrantjourneys.common.entities.ai.LightAvoidingRandomWalkingGoal;
import projectvibrantjourneys.init.PVJSoundEvents;

public class GhostEntity extends MonsterEntity {
	
	private static final DataParameter<Integer> VANISHING = EntityDataManager.createKey(GhostEntity.class, DataSerializers.VARINT);
	private int vanishTime;

	public GhostEntity(EntityType<? extends GhostEntity> entityType, World world) {
		super(entityType, world);
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(2, new RestrictSunGoal(this));
		this.goalSelector.addGoal(3, new FleeSunGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(9, new LightAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.23F);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(1.0D);
	}
	
	@Override
	public void livingTick() {
		if (this.isAlive()) {
			if (this.isInDaylight()) {
				this.setFire(8);
			}
		}
		
		Vec3d vec3d = this.getMotion();
		if (!this.onGround && vec3d.y < 0.0D) {
			this.setMotion(vec3d.mul(1.0D, 0.6D, 1.0D));
		}
		
		int light = this.getEntityWorld().getLight(this.getPosition());
		if(light > 9) {
			vanishTime++;
		} else {
			vanishTime = 0;
		}
		
		if(vanishTime > 400) {
			for(int i = 0; i < 20; i++) {
				this.world.addParticle(ParticleTypes.SMOKE, this.func_226282_d_(0.5D), this.func_226279_cv_(), this.func_226287_g_(0.5D), 0.0D, 0.0D, 0.0D);
			}
			this.remove();
		}
		
		if(this.world.isRemote) {
			if(vanishTime > 0) {
				if(this.rand.nextFloat() < vanishTime / 400.0F) {
					this.world.addParticle(ParticleTypes.SMOKE, this.func_226282_d_(0.5D), this.func_226279_cv_(), this.func_226287_g_(0.5D), 0.0D, 0.0D, 0.0D);
				}
			}
		}

		super.livingTick();
	}
	
	@Override
	protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		boolean flag = super.attackEntityAsMob(entityIn);
		if (flag) {
			float f = this.world.getDifficultyForLocation(new BlockPos(this)).getAdditionalDifficulty();
			if (this.getHeldItemMainhand().isEmpty() && this.isBurning() && this.rand.nextFloat() < f * 0.3F) {
				entityIn.setFire(2 * (int) f);
			}
		}

		return flag;
	}
	
	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.UNDEAD;
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return PVJSoundEvents.entity_ghost_ambient;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PVJSoundEvents.entity_ghost_hurt;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return PVJSoundEvents.entity_ghost_death;
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(VANISHING, 0);
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putInt("vanishing", this.getVanishTime());
	}
	
	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setVanishTime(compound.getInt("vanishing"));
	}
	
	public int getVanishTime() {
		return vanishTime;
	}
	
	public void setVanishTime(int i) {
		vanishTime = i;
	}
}
