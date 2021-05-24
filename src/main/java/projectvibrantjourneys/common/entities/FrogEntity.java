package projectvibrantjourneys.common.entities;

import java.util.EnumSet;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FrogEntity extends CreatureEntity {

	private static final DataParameter<Integer> COLOR = EntityDataManager.defineId(FrogEntity.class, DataSerializers.INT);
	
	private static final int NUM_COLORS = 5;
	
	public FrogEntity(EntityType<? extends FrogEntity> type, World world) {
		super(type, world);
		this.moveControl = new FrogEntity.MoveHelperController(this);
	}
	
	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 5.0D).add(Attributes.MOVEMENT_SPEED, 0.2D);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new WaterAvoidingRandomWalkingGoal(this, 0.5F));
		this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(5, new FrogEntity.HopGoal(this));
	}
	
	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.getEntityData().define(COLOR, 0);
	}
	
	@Override
	public void addAdditionalSaveData(CompoundNBT compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("Color", this.getColor());
	}

	@Override
	public void readAdditionalSaveData(CompoundNBT compound) {
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

	public static boolean canSpawn(EntityType<FrogEntity> entity, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
		return world.getBlockState(pos.below()).getBlock() instanceof GrassBlock
				|| world.getBlockState(pos.below()).getBlock() == Blocks.DIRT;
	}
	
	@Override
	public boolean causeFallDamage(float distance, float damageMultiplier) {
		return false;
	}
	
	@Nullable
	@Override
	public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
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
	protected int getExperienceReward(PlayerEntity player) {
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

	static class MoveHelperController extends MovementController {
		private float yRot;
		private int jumpDelay;
		private final FrogEntity frog;

		public MoveHelperController(FrogEntity entity) {
			super(entity);
			this.frog = entity;
			this.yRot = 180.0F * entity.yRot / (float) Math.PI;
		}

		public void setDirection(float yRot, boolean p_179920_2_) {
			this.yRot = yRot;
		}

		public void setWantedMovement(double speedModifier) {
			this.speedModifier = speedModifier;
			this.operation = MovementController.Action.MOVE_TO;
		}

		public void tick() {
			this.mob.yRot = this.rotlerp(this.mob.yRot, this.yRot, 90.0F);
			this.mob.yHeadRot = this.mob.yRot;
			this.mob.yBodyRot = this.mob.yRot;
			if (this.operation != MovementController.Action.MOVE_TO) {
				this.mob.setZza(0.0F);
			} else {
				this.operation = MovementController.Action.WAIT;
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
							Vector3d vector3d = this.frog.getDeltaMovement();
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