package projectvibrantjourneys.common.entities;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
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
import projectvibrantjourneys.init.object.PVJSoundEvents;

public class StarfishEntity extends WaterAnimal implements Bucketable {
	
	private static final EntityDataAccessor<Integer> COLOR = SynchedEntityData.defineId(StarfishEntity.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(StarfishEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(StarfishEntity.class, EntityDataSerializers.BYTE);
	private static final int NUM_COLORS = 5;
	
	public StarfishEntity(EntityType<? extends StarfishEntity> type, Level world) {
		super(type, world);
	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 2.0D).add(Attributes.MOVEMENT_SPEED, 0.05D);
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new RandomStrollGoal(this, 0.5F));
	}
	
	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.getEntityData().define(COLOR, 0);
		this.getEntityData().define(FROM_BUCKET, false);
		this.getEntityData().define(CLIMBING, (byte)0);
	}
	
	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("Color", this.getColor());
		compound.putBoolean("FromBucket", this.fromBucket());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setColor(compound.getInt("Color"));
		this.setFromBucket(compound.getBoolean("FromBucket"));
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
	
	@Override
	public void tick() {
		super.tick();
		if (!this.level.isClientSide()) {
			this.setBesideClimbableBlock(this.horizontalCollision);
		}
	}

	@Override
	public boolean onClimbable() {
		return this.isBesideClimbableBlock();
	}
	
	//i stole all this from SpiderEntity
	public boolean isBesideClimbableBlock() {
		return (this.getEntityData().get(CLIMBING) & 1) != 0;
	}

	public void setBesideClimbableBlock(boolean climbing) {
		byte b0 = this.getEntityData().get(CLIMBING);
		if (climbing) {
			b0 = (byte) (b0 | 1);
		} else {
			b0 = (byte) (b0 & -2);
		}

		this.getEntityData().set(CLIMBING, b0);
	}
	
	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
		if (dataTag != null && dataTag.contains("BucketVariantTag", 3))
			this.setColor(dataTag.getInt("BucketVariantTag"));
		else
			this.setColor(getRandomColor(world.getRandom()));
		
		BlockPos pos = this.blockPosition();
		while(world.getBlockState(pos.below(2)).getBlock() == Blocks.WATER) {
			this.setPos(pos.getX(), pos.getY() - 1, pos.getZ());
			pos = this.blockPosition();
		}
		return super.finalizeSpawn(world, difficulty, reason, spawnData, dataTag);
	}
	
	@Override
	protected PathNavigation createNavigation(Level worldIn) {
		return new WallClimberNavigation(this, worldIn);
	}
	
	@Override
	protected void handleAirSupply(int air) {}
	
	public static boolean canSpawn(EntityType<StarfishEntity> entity, LevelAccessor world, MobSpawnType reason, BlockPos pos, Random rand) {
		return pos.getY() > 60;
	}
	
	public static boolean canSpawnOcean(EntityType<StarfishEntity> entity, LevelAccessor world, MobSpawnType reason, BlockPos pos, Random rand) {
		return pos.getY() < world.getSeaLevel();
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public boolean shouldRenderAtSqrDistance(double distance) {
		return true;
	}
	
	@Override
	protected int getExperienceReward(Player player) {
		return 0;
	}
	
	@Override
	protected void pushEntities() {
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
	public boolean fromBucket() {
		return this.getEntityData().get(FROM_BUCKET);
	}

	@Override
	public void setFromBucket(boolean value) {
		this.getEntityData().set(FROM_BUCKET, value);
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
		return new ItemStack(PVJItems.starfish_bucket);
	}

	@Override
	public SoundEvent getPickupSound() {
		return SoundEvents.BUCKET_FILL_FISH;
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		if(this.hasCustomName()) {
			String name = this.getCustomName().getString().toLowerCase();
			if(name.equals("patrick") || name.equals("patrick star") || name.equals("patrickstar")) {
				return PVJSoundEvents.PATRICK_STAR;
			}
		}
		return null;
	}
}