package projectvibrantjourneys.common.entities;

import java.util.EnumSet;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FrogEntity extends PathfinderMob {

	private static final EntityDataAccessor<Integer> COLOR = SynchedEntityData.defineId(FrogEntity.class, EntityDataSerializers.INT);
	
	private static final int NUM_COLORS = 5;
	
	public FrogEntity(EntityType<? extends FrogEntity> type, Level world) {
		super(type, world);
		this.moveControl = new FrogEntity.MoveHelperController(this);
	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 5.0D).add(Attributes.MOVEMENT_SPEED, 0.2D);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new WaterAvoidingRandomStrollGoal(this, 0.5F));
		this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new FrogEntity.HopGoal(this));
	}
	
	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.getEntityData().define(COLOR, 0);
	}
	
	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("Color", this.getColor());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setColor(compound.getInt("Color"));
	}
	
	public int getColor() {
		return this.getEntityData().get(COLOR);
	}
	
	public void setColor(int color) {
		this.getEntityData().set(COLOR, color);
	}
	
	public int getRandomColor(Random rand) {
		return rand.nextInt(NUM_COLORS);
	}

	public static boolean canSpawn(EntityType<FrogEntity> entity, LevelAccessor world, MobSpawnType reason, BlockPos pos, Random rand) {
		return world.getBlockState(pos.below()).getBlock() instanceof GrassBlock
				|| world.getBlockState(pos.below()).getBlock() == Blocks.DIRT;
	}
	
	@Override
	public boolean causeFallDamage(float distance, float damageMultiplier, DamageSource source) {
		return false;
	}
	
	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
		this.setColor(getRandomColor(world.getRandom()));
		return super.finalizeSpawn(world, difficulty, reason, spawnData, dataTag);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public boolean shouldRenderAtSqrDistance(double distance) {
		return true;
	}

	@Override
	protected void pushEntities() {
	}
	
	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	protected int getExperienceReward(Player player) {
		return 0;
	}

	protected int getJumpDelay() {
		return this.random.nextInt(100) + 100;
	}

	static class HopGoal extends Goal {
		private final FrogEntity frog;

		public HopGoal(FrogEntity frog) {
			this.frog = frog;
			this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
		}

		public boolean canUse() {
			return !this.frog.isPassenger();
		}

		public void tick() {
			((FrogEntity.MoveHelperController) this.frog.getMoveControl()).setWantedMovement(1.0D);
		}
	}

	static class MoveHelperController extends MoveControl {
		private float yRot;
		private int jumpDelay;
		private final FrogEntity frog;

		public MoveHelperController(FrogEntity entity) {
			super(entity);
			this.frog = entity;
			this.yRot = 180.0F * entity.getYRot() / (float) Math.PI;
		}

		public void setDirection(float yRot, boolean p_179920_2_) {
			this.yRot = yRot;
		}

		public void setWantedMovement(double speedModifier) {
			this.speedModifier = speedModifier;
			this.operation = MoveControl.Operation.MOVE_TO;
		}

		public void tick() {
			this.mob.setYRot(this.rotlerp(this.mob.getYRot(), this.yRot, 90.0F));
			this.mob.yHeadRot = this.mob.getYRot();
			this.mob.yBodyRot = this.mob.getYRot();
			if (this.operation != MoveControl.Operation.MOVE_TO) {
				this.mob.setZza(0.0F);
			} else {
				this.operation =MoveControl.Operation.WAIT;
				if (this.mob.isOnGround()) {
					this.mob.setSpeed((float) (this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
					if(this.mob.isInWater()) {
						this.mob.setSpeed((float) (1.5 * this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
					}
					if (this.jumpDelay-- <= 0) {
						this.jumpDelay = this.frog.getJumpDelay();

						if(!this.frog.isInWater())
							this.frog.getJumpControl().jump();
						else {
							Vec3 vector3d = this.frog.getDeltaMovement();
							this.frog.setDeltaMovement(vector3d.x * 5, (double) this.frog.getJumpPower() * 0.5, vector3d.z * 5);
						}
					} else {
						this.frog.xxa = 0.0F;
						this.frog.zza = 0.0F;
						this.mob.setSpeed(0.0F);
					}
				} else {
					this.mob.setSpeed((float) (this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
				}

			}
		}
	}
}