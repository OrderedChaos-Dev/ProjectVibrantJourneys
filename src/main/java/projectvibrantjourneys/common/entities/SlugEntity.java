package projectvibrantjourneys.common.entities;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SlugEntity extends PathfinderMob {
	
	private static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(SlugEntity.class, EntityDataSerializers.BYTE);
	
	public SlugEntity(EntityType<? extends SlugEntity> type, Level world) {
		super(type, world);
	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 2.0D).add(Attributes.MOVEMENT_SPEED, 0.1D);
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new WaterAvoidingRandomStrollGoal(this, 0.5F));
		this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
	}
	
	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.getEntityData().define(CLIMBING, (byte)0);
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
	
	@Override
	protected PathNavigation createNavigation(Level worldIn) {
		return new WallClimberNavigation(this, worldIn);
	}
	
	public static boolean canSpawn(EntityType<SlugEntity> entity, LevelAccessor world, MobSpawnType reason, BlockPos pos, Random rand) {
		return world.getBlockState(pos.below()).getBlock() instanceof GrassBlock || world.getBlockState(pos.below()).getBlock() == Blocks.DIRT;
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
	protected int getExperienceReward(Player player) {
		return 0;
	}
}