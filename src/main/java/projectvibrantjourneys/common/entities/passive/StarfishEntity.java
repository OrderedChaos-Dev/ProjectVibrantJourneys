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
import net.minecraft.pathfinding.ClimberPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.init.PVJItems;
import projectvibrantjourneys.init.PVJSoundEvents;

public class StarfishEntity extends WaterMobEntity implements IBucketCollectable {
	
	private static final DataParameter<Integer> COLOR = EntityDataManager.<Integer>createKey(StarfishEntity.class, DataSerializers.VARINT);
	private static final DataParameter<Boolean> FROM_BUCKET = EntityDataManager.createKey(StarfishEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Byte> CLIMBING = EntityDataManager.createKey(StarfishEntity.class, DataSerializers.BYTE);
	private static final int NUM_COLORS = 5;
	
	public StarfishEntity(EntityType<? extends StarfishEntity> type, World world) {
		super(type, world);
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(2.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new RandomWalkingGoal(this, 0.05F));
		this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
	}
	
	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(COLOR, 0);
		this.dataManager.register(FROM_BUCKET, false);
		this.dataManager.register(CLIMBING, (byte)0);
	}
	
	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putInt("Color", this.getColor());
		compound.putBoolean("FromBucket", this.isFromBucket());
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setColor(compound.getInt("Color"));
		this.setFromBucket(compound.getBoolean("FromBucket"));
	}
		   
	public int getColor() {
		return this.getDataManager().get(COLOR);
	}
	
	public void setColor(int color) {
		this.getDataManager().set(COLOR, color);
	}
	
	public int getRandomColor(Random rand) {
		return rand.nextInt(NUM_COLORS);
	}
	
	@Override
	public void tick() {
		super.tick();
		if (!this.world.isRemote) {
			this.setBesideClimbableBlock(this.collidedHorizontally);
		}
	}

	@Override
	public boolean isOnLadder() {
		return this.isBesideClimbableBlock();
	}
	
	//i stole all this from SpiderEntity
	public boolean isBesideClimbableBlock() {
		return (this.dataManager.get(CLIMBING) & 1) != 0;
	}

	public void setBesideClimbableBlock(boolean climbing) {
		byte b0 = this.dataManager.get(CLIMBING);
		if (climbing) {
			b0 = (byte) (b0 | 1);
		} else {
			b0 = (byte) (b0 & -2);
		}

		this.dataManager.set(CLIMBING, b0);
	}
	
	@Nullable
	@Override
	public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
		if (dataTag != null && dataTag.contains("BucketVariantTag", 3))
			this.setColor(dataTag.getInt("BucketVariantTag"));
		else
			this.setColor(getRandomColor(world.getRandom()));
		
		BlockPos pos = this.getPosition();
		while(world.getBlockState(pos.down(2)).getBlock() == Blocks.WATER) {
			this.setPosition(pos.getX(), pos.getY() - 1, pos.getZ());
			pos = this.getPosition();
		}
		return super.onInitialSpawn(world, difficulty, reason, spawnData, dataTag);
	}
	
	@Override
	protected PathNavigator createNavigator(World worldIn) {
		return new ClimberPathNavigator(this, worldIn);
	}
	
	@Override
	protected void updateAir(int air) {}
	
	public static boolean canSpawn(EntityType<StarfishEntity> entity, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
		return pos.getY() > 60;
	}
	
	public static boolean canSpawnOcean(EntityType<StarfishEntity> entity, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
		return pos.getY() < world.getSeaLevel();
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public boolean isInRangeToRenderDist(double distance) {
		return true;
	}
	
	@Override
	protected int getExperiencePoints(PlayerEntity player) {
		return 0;
	}
	
	@Override
	public boolean preventDespawn() {
		return this.isFromBucket();
	}

	@Override
	public boolean canDespawn(double distanceToClosestPlayer) {
		return !this.isFromBucket() && !this.hasCustomName();
	}

	private boolean isFromBucket() {
		return this.dataManager.get(FROM_BUCKET);
	}

	@Override
	public void setFromBucket(boolean value) {
		this.dataManager.set(FROM_BUCKET, value);
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
		CompoundNBT compoundnbt = bucket.getOrCreateTag();
		compoundnbt.putInt("BucketVariantTag", this.getColor());
	}

	public ItemStack getFishBucket() {
		return new ItemStack(PVJItems.starfish_bucket);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		if(this.hasCustomName()) {
			String name = this.getCustomName().getString().toLowerCase();
			if(name.equals("patrick") || name.equals("patrick star") || name.equals("patrickstar")) {
				return PVJSoundEvents.patrick_star;
			}
		}
		return null;
	}
}
