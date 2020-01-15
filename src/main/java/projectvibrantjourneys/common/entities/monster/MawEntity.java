package projectvibrantjourneys.common.entities.monster;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombiePigmanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class MawEntity extends MonsterEntity {

	public static final DataParameter<Direction> ATTACHED_FACE = EntityDataManager.createKey(MawEntity.class,
			DataSerializers.DIRECTION);
	public static final DataParameter<Boolean> FRIENDLY = EntityDataManager.createKey(MawEntity.class,
			DataSerializers.BOOLEAN);

	public MawEntity(EntityType<? extends MawEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(6, new LookAtGoal(this, LivingEntity.class, 5.0F));
		
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, MobEntity.class, 4, true, true, (entity) -> {
			return !(entity instanceof ZombiePigmanEntity) && !(entity instanceof CreeperEntity);
		}));
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(1.5D);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(2.0D);
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(ATTACHED_FACE, Direction.DOWN);
		this.dataManager.register(FRIENDLY, false);
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.dataManager.set(ATTACHED_FACE, Direction.byIndex(compound.getByte("AttachFace")));
		this.dataManager.set(FRIENDLY, compound.getBoolean("Friendly"));
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putByte("AttachFace", (byte) this.dataManager.get(ATTACHED_FACE).getIndex());
		compound.putBoolean("Friendly", this.dataManager.get(FRIENDLY));
	}
	
	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		if(this.getAttachmentFace() == Direction.DOWN)
			return 0.1F;
		else
			return this.getHeight() - 0.1F;
	}

	@Nullable
	public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason,
			@Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
		
		if(reason == SpawnReason.NATURAL) {
			setAttachmentFace(world.getRandom().nextBoolean() ? Direction.UP : Direction.DOWN);

			if (getAttachmentFace() == Direction.UP) {
				BlockPos pos = this.getPosition();
				while (pos.up(5).getY() < 255 && world.isAirBlock(pos.up(5))) {
					pos = pos.up();
				}
				this.setPosition(pos.getX(), pos.getY(), pos.getZ());
			}
		}
		if(reason != SpawnReason.BREEDING) {
			this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		}
		return super.onInitialSpawn(world, difficulty, reason, spawnData, dataTag);
	}

	public Direction getAttachmentFace() {
		return this.dataManager.get(ATTACHED_FACE);
	}

	public void setAttachmentFace(Direction d) {
		this.dataManager.set(ATTACHED_FACE, d);
	}
	
	@Override
	public boolean canDespawn(double distanceToClosestPlayer) {
		return !this.dataManager.get(FRIENDLY);
	}

	@Override
	public boolean preventDespawn() {
		return this.dataManager.get(FRIENDLY);
	}
	
	//should despawn if peaceful difficulty
	@Override
	protected boolean func_225511_J_() {
		return !this.dataManager.get(FRIENDLY);
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		float f = (float) this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue();

		boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), f);
		if (flag) {
			if (entity instanceof LivingEntity) {
		          Vec3d vec3d = new Vec3d(this.func_226277_ct_() - entity.func_226277_ct_(), 0.1, this.func_226281_cx_() - entity.func_226281_cx_());
		          entity.setMotion(vec3d.normalize().scale(0.5));
		          ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 40, 5));
		          if(this.getAttachmentFace() == Direction.UP) {
		        	  ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LEVITATION, 40, 1));
		          }
			}

			if (entity instanceof PlayerEntity) {
				PlayerEntity playerentity = (PlayerEntity) entity;
				ItemStack itemstack = this.getHeldItemMainhand();
				ItemStack itemstack1 = playerentity.isHandActive() ? playerentity.getActiveItemStack()
						: ItemStack.EMPTY;
				if (!itemstack.isEmpty() && !itemstack1.isEmpty()
						&& itemstack.canDisableShield(itemstack1, playerentity, this)
						&& itemstack1.isShield(playerentity)) {
					float f2 = 0.25F + (float) EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;
					if (this.rand.nextFloat() < f2) {
						playerentity.getCooldownTracker().setCooldown(itemstack.getItem(), 100);
						this.world.setEntityState(playerentity, (byte) 30);
					}
				}
			}

			this.applyEnchantments(this, entity);
			this.setLastAttackedEntity(entity);
		}

		return flag;
	}
	
	@Override
	public void onKillEntity(LivingEntity entityLivingIn) {
		this.addPotionEffect(new EffectInstance(Effects.REGENERATION, 200, 2));
	}

	@Override
	public void livingTick() {
		super.livingTick();
		this.setMotion(Vec3d.ZERO);

		Direction direction = getAttachmentFace();
		BlockPos pos = this.getPosition().offset(direction.getOpposite());
		if (world.isAirBlock(pos)) {
			if (direction == Direction.DOWN)
				this.setMotion(0, -0.1F, 0);
			else
				this.setMotion(0, 0.1F, 0);
		}
		
		if(this.getDataManager().get(FRIENDLY)) {
			if(this.rand.nextFloat() < 0.2F) {
				if(this.rand.nextFloat() < 0.1F) {
					this.world.addParticle(ParticleTypes.HEART, this.func_226282_d_(0.5D), this.func_226279_cv_(), this.func_226287_g_(0.5D), 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}

	public static boolean canSpawn(EntityType<MawEntity> entity, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
		return world.getDifficulty() != Difficulty.PEACEFUL;
	}

	@Override
	public boolean canBePushed() {
		return false;
	}

	@Override
	public void applyEntityCollision(Entity entity) {}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {}

	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.UNDEFINED;
	}

	@Override
	public SoundCategory getSoundCategory() {
		return SoundCategory.HOSTILE;
	}
}
