package projectvibrantjourneys.common.entities;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.init.object.PVJItems;

public class ClamEntity extends WaterAnimal implements Bucketable {
	
	private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(ClamEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> HAS_PEARL = SynchedEntityData.defineId(ClamEntity.class, EntityDataSerializers.BOOLEAN);
	
	public ClamEntity(EntityType<? extends ClamEntity> type, Level world) {
		super(type, world);
		this.yHeadRot = Mth.wrapDegrees(world.getRandom().nextFloat() * 360.0F);
	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 5.0D);
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new RandomStrollGoal(this, 0.001F));
	}
	
	public static boolean canSpawn(EntityType<ClamEntity> entity, LevelAccessor world, MobSpawnType reason, BlockPos pos, Random rand) {
		return true;
	}
	
	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
		BlockPos pos = this.blockPosition();
		while(world.getBlockState(pos.below(2)).getBlock() == Blocks.WATER) {
			this.setPos(pos.getX(), pos.getY() - 1, pos.getZ());
			pos = this.blockPosition();
		}
		
		if(world.getRandom().nextInt(5) == 0) 
			this.setHasPearl(true);
		return super.finalizeSpawn(world, difficulty, reason, spawnData, dataTag);
	}
	
	@Override
	protected void dropCustomDeathLoot(DamageSource source, int p_213333_2_, boolean p_213333_3_) {
		if(this.hasPearl()) {
			this.spawnAtLocation(PVJItems.pearl);
		}
	}
	
	@Override
	public void tick() {
		super.tick();
		if(this.level.isClientSide()) {
			if(this.getRandom().nextFloat() < 0.1F) {
				this.level.addParticle(ParticleTypes.BUBBLE, this.getX(), this.getY(), this.getZ(), 0, 0, 0);
			}
		}
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public boolean shouldRenderAtSqrDistance(double distance) {
		return true;
	}
	
	@Override
	protected int getExperienceReward(Player player) {
		if(this.hasPearl())
			return 1;
		return 0;
	}
	
	@Override
	public boolean shouldDespawnInPeaceful() {
		return this.fromBucket();
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return !this.fromBucket() && !this.hasCustomName();
	}
	   
	@Override
	public void defineSynchedData() {
		super.defineSynchedData();
		this.getEntityData().define(FROM_BUCKET, false);
		this.getEntityData().define(HAS_PEARL, false);
	}

	@Override
	public boolean fromBucket() {
		return this.getEntityData().get(FROM_BUCKET);
	}

	@Override
	public void setFromBucket(boolean value) {
		this.getEntityData().set(FROM_BUCKET, value);
	}
	

	public boolean hasPearl() {
		return this.getEntityData().get(HAS_PEARL);
	}
	
	public void setHasPearl(boolean value) {
		this.getEntityData().set(HAS_PEARL, value);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("FromBucket", this.fromBucket());
		compound.putBoolean("HasPearl", this.hasPearl());
		
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setFromBucket(compound.getBoolean("FromBucket"));
		this.setHasPearl(compound.getBoolean("HasPearl"));
	}

	@Override
	protected InteractionResult mobInteract(Player p_27477_, InteractionHand p_27478_) {
		return Bucketable.bucketMobPickup(p_27477_, p_27478_, this).orElse(super.mobInteract(p_27477_, p_27478_));
	}

	@Override
	public void saveToBucketTag(ItemStack p_27494_) {
		Bucketable.saveDefaultDataToBucketTag(this, p_27494_);
	}

	@Override
	public void loadFromBucketTag(CompoundTag p_148708_) {
		Bucketable.loadDefaultDataFromBucketTag(this, p_148708_);
	}

	@Override
	public ItemStack getBucketItemStack() {
		return new ItemStack(PVJItems.clam_bucket);
	}

	@Override
	public SoundEvent getPickupSound() {
		return SoundEvents.BUCKET_FILL_FISH;
	}
}