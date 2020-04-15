package projectvibrantjourneys.common.entities.passive;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
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
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.init.PVJItems;

public class ClamEntity extends WaterMobEntity implements IBucketCollectable  {
	
	private static final DataParameter<Boolean> FROM_BUCKET = EntityDataManager.createKey(ClamEntity.class, DataSerializers.BOOLEAN);
	
	public ClamEntity(EntityType<? extends ClamEntity> type, World world) {
		super(type, world);
		this.rotationYaw = MathHelper.wrapDegrees(world.getRandom().nextFloat() * 360.0F);
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();
		
		//i think it'd be funny for clams to look around
		this.goalSelector.addGoal(0, new RandomWalkingGoal(this, 0.001F));
		this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
	}
	
	public static boolean canSpawn(EntityType<ClamEntity> entity, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
		return pos.getY() > 60;
	}
	
	@Nullable
	@Override
	public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
		BlockPos pos = this.getPosition();
		while(world.getBlockState(pos.down(2)).getBlock() == Blocks.WATER) {
			this.setPosition(pos.getX(), pos.getY() - 1, pos.getZ());
			pos = this.getPosition();
		}
		return super.onInitialSpawn(world, difficulty, reason, spawnData, dataTag);
	}
	
	@Override
	public void tick() {
		super.tick();
		if(this.world.isRemote) {
			if(this.rand.nextFloat() < 0.1F) {
				this.world.addParticle(ParticleTypes.BUBBLE, this.getPosX(), this.getPosY(), this.getPosZ(), 0, 0, 0);
			}
		}
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public boolean isInRangeToRenderDist(double distance) {
		return true;
	}
	
	@Override
	protected int getExperiencePoints(PlayerEntity player) {
		return 1;
	}
	
	@Override
	public boolean preventDespawn() {
		return this.isFromBucket();
	}

	@Override
	public boolean canDespawn(double distanceToClosestPlayer) {
		return !this.isFromBucket() && !this.hasCustomName();
	}
	   
	@Override
	public void registerData() {
		super.registerData();
		this.dataManager.register(FROM_BUCKET, false);
	}

	private boolean isFromBucket() {
		return this.dataManager.get(FROM_BUCKET);
	}

	@Override
	public void setFromBucket(boolean value) {
		this.dataManager.set(FROM_BUCKET, value);
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("FromBucket", this.isFromBucket());
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setFromBucket(compound.getBoolean("FromBucket"));
	}

	@Override
	public boolean processInteract(PlayerEntity player, Hand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
		if (itemstack.getItem() == Items.WATER_BUCKET && this.isAlive()) {
			this.playSound(SoundEvents.ITEM_BUCKET_FILL_FISH, 1.0F, 1.0F);
			itemstack.shrink(1);
			ItemStack itemstack1 = this.getFishBucket();
			this.setBucketData(itemstack1);
			if (!this.world.isRemote) {
				CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayerEntity) player, itemstack1);
			}

			if (itemstack.isEmpty()) {
				player.setHeldItem(hand, itemstack1);
			} else if (!player.inventory.addItemStackToInventory(itemstack1)) {
				player.dropItem(itemstack1, false);
			}

			this.remove();
			return true;
		} else {
			return super.processInteract(player, hand);
		}
	}

	public void setBucketData(ItemStack bucket) {
		if (this.hasCustomName()) {
			bucket.setDisplayName(this.getCustomName());
		}
	}

	public ItemStack getFishBucket() {
		return new ItemStack(PVJItems.clam_bucket);
	}
}
