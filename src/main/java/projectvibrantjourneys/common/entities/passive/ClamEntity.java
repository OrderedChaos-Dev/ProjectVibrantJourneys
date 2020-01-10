package projectvibrantjourneys.common.entities.passive;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ClamEntity extends WaterMobEntity {
	
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
		while(world.getBlockState(pos.down()).getBlock() == Blocks.WATER) {
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
				this.world.addParticle(ParticleTypes.BUBBLE, this.func_226277_ct_(), this.func_226279_cv_(), this.func_226281_cx_(), 0, 0, 0);
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
}
