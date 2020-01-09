package projectvibrantjourneys.common.entities.passive;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.AmbientEntity;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.init.PVJSoundEvents;

public class FlyEntity extends AmbientEntity {
	private BlockPos spawnPosition;

	public FlyEntity(EntityType<? extends FlyEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public boolean canBePushed() {
		return false;
	}

	@Override
	protected void collideWithEntity(Entity entityIn) {
	}

	@Override
	protected void collideWithNearbyEntities() {
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
	}

	@Override
	public void tick() {
		super.tick();
		this.setMotion(this.getMotion().mul(1.0D, 0.6D, 1.0D));
		
		if(this.isInWater()) {
			this.setMotion(this.getMotion().mul(0, 0, 0));
		}
	}

	@Override
	protected void updateAITasks() {
		super.updateAITasks();
		if (this.spawnPosition != null
				&& (!this.world.isAirBlock(this.spawnPosition) || this.spawnPosition.getY() < 1)) {
			this.spawnPosition = null;
		}

		if (this.spawnPosition == null || this.rand.nextInt(30) == 0
				|| this.spawnPosition.withinDistance(this.getPositionVec(), 2.0D)) {
			this.spawnPosition = new BlockPos(
					this.func_226277_ct_() + (double) this.rand.nextInt(7) - (double) this.rand.nextInt(7),
					this.func_226278_cu_() + (double) this.rand.nextInt(6) - 2.0D,
					this.func_226281_cx_() + (double) this.rand.nextInt(7) - (double) this.rand.nextInt(7));
		}

		double d0 = (double) this.spawnPosition.getX() + 0.5D - this.func_226277_ct_();
		double d1 = (double) this.spawnPosition.getY() + 0.1D - this.func_226278_cu_();
		double d2 = (double) this.spawnPosition.getZ() + 0.5D - this.func_226281_cx_();
		Vec3d vec3d = this.getMotion();
		Vec3d vec3d1 = vec3d.add((Math.signum(d0) * 0.5D - vec3d.x) * (double) 0.1F,
				(Math.signum(d1) * (double) 0.7F - vec3d.y) * (double) 0.1F,
				(Math.signum(d2) * 0.5D - vec3d.z) * (double) 0.1F);
		this.setMotion(vec3d1);
		float f = (float) (MathHelper.atan2(vec3d1.z, vec3d1.x) * (double) (180F / (float) Math.PI)) - 90.0F;
		float f1 = MathHelper.wrapDegrees(f - this.rotationYaw);
		this.moveForward = 0.5F;
		this.rotationYaw += f1;

		if(this.isInWater()) {
			this.setMotion(this.getMotion().mul(0, 0, 0));
		}
	}
	
	@Override
	protected boolean func_225502_at_() {
		return false;
	}

	@Override
	public boolean func_225503_b_(float p_225503_1_, float p_225503_2_) {
		return false;
	}
	
	@Override
	protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	@Override
	public boolean doesEntityNotTriggerPressurePlate() {
		return true;
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return PVJSoundEvents.entity_fly_ambient;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return null;
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public boolean isInRangeToRenderDist(double distance) {
		return true;
	}
	
	public static boolean canSpawn(EntityType<FlyEntity> fly, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
		if (pos.getY() < world.getSeaLevel()) {
			return false;
		} else {
			return func_223315_a(fly, world, reason, pos, rand);
		}
	}
}
