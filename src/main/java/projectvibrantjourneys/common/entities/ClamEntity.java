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
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.init.object.PVJItems;

public class ClamEntity extends WaterMobEntity implements IBucketCollectable {
	
	private static final DataParameter<Boolean> FROM_BUCKET = EntityDataManager.defineId(ClamEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> HAS_PEARL = EntityDataManager.defineId(ClamEntity.class, DataSerializers.BOOLEAN);
	
	public ClamEntity(EntityType<? extends ClamEntity> type, World world) {
		super(type, world);
		this.yHeadRot = MathHelper.wrapDegrees(world.getRandom().nextFloat() * 360.0F);
	}
	
	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 5.0D);
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new RandomWalkingGoal(this, 0.001F));
	}
	
	public static boolean canSpawn(EntityType<ClamEntity> entity, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
		return true;
	}
	
	@Nullable
	@Override
	public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
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
	protected int getExperienceReward(PlayerEntity player) {
		if(this.hasPearl())
			return 1;
		return 0;
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
	public void defineSynchedData() {
		super.defineSynchedData();
		this.getEntityData().define(FROM_BUCKET, false);
		this.getEntityData().define(HAS_PEARL, false);
	}

	@Override
	public boolean isFromBucket() {
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
	public void addAdditionalSaveData(CompoundNBT compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("FromBucket", this.isFromBucket());
		compound.putBoolean("HasPearl", this.hasPearl());
		
	}

	@Override
	public void readAdditionalSaveData(CompoundNBT compound) {
		super.readAdditionalSaveData(compound);
		this.setFromBucket(compound.getBoolean("FromBucket"));
		this.setHasPearl(compound.getBoolean("HasPearl"));
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
	}

	@Override
	public ItemStack getFishBucket() {
		return new ItemStack(PVJItems.clam_bucket);
	}
}