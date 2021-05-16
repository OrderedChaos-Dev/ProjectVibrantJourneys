package projectvibrantjourneys.common.entities;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.ClimberPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.init.object.PVJItems;
import projectvibrantjourneys.init.object.PVJSoundEvents;

public class StarfishEntity extends WaterMobEntity implements IBucketCollectable {
	
	private static final DataParameter<Integer> COLOR = EntityDataManager.defineId(StarfishEntity.class, DataSerializers.INT);
	private static final DataParameter<Boolean> FROM_BUCKET = EntityDataManager.defineId(StarfishEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Byte> CLIMBING = EntityDataManager.defineId(StarfishEntity.class, DataSerializers.BYTE);
	private static final int NUM_COLORS = 5;
	
	public StarfishEntity(EntityType<? extends StarfishEntity> type, World world) {
		super(type, world);
	}
	
	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 2.0D).add(Attributes.MOVEMENT_SPEED, 0.05D);
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new RandomWalkingGoal(this, 0.5F));
	}
	
	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.getEntityData().define(COLOR, 0);
		this.getEntityData().define(FROM_BUCKET, false);
		this.getEntityData().define(CLIMBING, (byte)0);
	}
	
	@Override
	public void addAdditionalSaveData(CompoundNBT compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("Color", this.getColor());
		compound.putBoolean("FromBucket", this.isFromBucket());
	}

	@Override
	public void readAdditionalSaveData(CompoundNBT compound) {
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
	public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
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
	protected PathNavigator createNavigation(World worldIn) {
		return new ClimberPathNavigator(this, worldIn);
	}
	
	@Override
	protected void handleAirSupply(int air) {}
	
	public static boolean canSpawn(EntityType<StarfishEntity> entity, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
		return pos.getY() > 60;
	}
	
	public static boolean canSpawnOcean(EntityType<StarfishEntity> entity, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
		return pos.getY() < world.getSeaLevel();
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public boolean shouldRenderAtSqrDistance(double distance) {
		return true;
	}
	
	@Override
	protected int getExperienceReward(PlayerEntity player) {
		return 0;
	}
	
	@Override
	protected void pushEntities() {
	}
	
	@Override
	public boolean shouldDespawnInPeaceful() {
		return this.isFromBucket();
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return !this.isFromBucket() && !this.hasCustomName();
	}

	@Override
	public boolean isFromBucket() {
		return this.getEntityData().get(FROM_BUCKET);
	}

	@Override
	public void setFromBucket(boolean value) {
		this.getEntityData().set(FROM_BUCKET, value);
	}

	@Override
	public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		if (itemstack.getItem() == Items.WATER_BUCKET && this.isAlive()) {
			this.playSound(SoundEvents.BUCKET_FILL_FISH, 1.0F, 1.0F);
			itemstack.shrink(1);
			ItemStack itemstack1 = this.getFishBucket();
			this.setBucketData(itemstack1);
			if (!this.level.isClientSide()) {
				CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayerEntity) player, itemstack1);
			}

			if (itemstack.isEmpty()) {
				player.setItemInHand(hand, itemstack1);
			} else if (!player.inventory.add(itemstack1)) {
				player.drop(itemstack1, false);
			}

			this.remove();
			return ActionResultType.SUCCESS;
		} else {
			return super.mobInteract(player, hand);
		}
	}

	@Override
	public void setBucketData(ItemStack bucket) {
		if (this.hasCustomName()) {
			bucket.setHoverName(this.getCustomName());
		}
		CompoundNBT compoundnbt = bucket.getOrCreateTag();
		compoundnbt.putInt("BucketVariantTag", this.getColor());
	}

	@Override
	public ItemStack getFishBucket() {
		return new ItemStack(PVJItems.starfish_bucket);
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