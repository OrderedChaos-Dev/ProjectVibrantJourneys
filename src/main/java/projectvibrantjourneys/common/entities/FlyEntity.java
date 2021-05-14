package projectvibrantjourneys.common.entities;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.AmbientEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.core.PVJConfig;
import projectvibrantjourneys.init.object.PVJSoundEvents;

public class FlyEntity extends AmbientEntity {
	
	private BlockPos targetPosition;

	public FlyEntity(EntityType<? extends FlyEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	protected void doPush(Entity entity) {
	}

	@Override
	protected void pushEntities() {
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 1.0D);
	}

	@Override
	public void tick() {
		super.tick();
		this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.6D, 1.0D));

		if (this.isInWater()) {
			this.setDeltaMovement(this.getDeltaMovement().multiply(0, 0, 0));
			if(this.getRandom().nextInt(1000) == 0) {
				this.hurt(DamageSource.DROWN, 1.0F);
			}
		}
	}

	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();
		if (this.targetPosition != null
				&& (!this.level.isEmptyBlock(this.targetPosition) || this.targetPosition.getY() < 1)) {
			this.targetPosition = null;
		}

		if (this.targetPosition == null || this.random.nextInt(30) == 0
				|| this.targetPosition.closerThan(this.position(), 2.0D)) {
			this.targetPosition = new BlockPos(
					this.getX() + (double) this.random.nextInt(7) - (double) this.random.nextInt(7),
					this.getY() + (double) this.random.nextInt(6) - 2.0D,
					this.getZ() + (double) this.random.nextInt(7) - (double) this.random.nextInt(7));
		}

		double d2 = (double) this.targetPosition.getX() + 0.5D - this.getX();
		double d0 = (double) this.targetPosition.getY() + 0.1D - this.getY();
		double d1 = (double) this.targetPosition.getZ() + 0.5D - this.getZ();
		Vector3d vector3d = this.getDeltaMovement();
		Vector3d vector3d1 = vector3d.add((Math.signum(d2) * 0.5D - vector3d.x) * (double) 0.1F,
				(Math.signum(d0) * (double) 0.7F - vector3d.y) * (double) 0.1F,
				(Math.signum(d1) * 0.5D - vector3d.z) * (double) 0.1F);
		this.setDeltaMovement(vector3d1);
		float f = (float) (MathHelper.atan2(vector3d1.z, vector3d1.x) * (double) (180F / (float) Math.PI)) - 90.0F;
		float f1 = MathHelper.wrapDegrees(f - this.yRot);
		this.zza = 0.5F;
		this.yRot += f1;

		if (this.isInWater()) {
			this.setDeltaMovement(this.getDeltaMovement().multiply(0, 0, 0));
		}
	}

	@Override
	protected boolean isMovementNoisy() {
		return false;
	}

	@Override
	public boolean causeFallDamage(float distance, float damageMultiplier) {
		return false;
	}

	@Override
	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	@Override
	public boolean isIgnoringBlockTriggers() {
		return true;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		if (PVJConfig.muteFlies.get())
			return null;
		return PVJSoundEvents.FLY_AMBIENT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return null;
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public boolean shouldRenderAtSqrDistance(double distance) {
		return true;
	}

	public static boolean canSpawn(EntityType<FlyEntity> fly, IWorld world, SpawnReason reason, BlockPos pos,
			Random rand) {
		if (pos.getY() < world.getSeaLevel()) {
			return false;
		} else {
			return checkMobSpawnRules(fly, world, reason, pos, rand);
		}
	}
}
