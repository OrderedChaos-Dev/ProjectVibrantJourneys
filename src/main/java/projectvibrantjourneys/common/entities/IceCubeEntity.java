package projectvibrantjourneys.common.entities;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.MagmaCubeEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTables;

public class IceCubeEntity extends SlimeEntity {

	public IceCubeEntity(EntityType<? extends SlimeEntity> type, World world) {
		super(type, world);
	}

	public static boolean canSpawn(EntityType<IceCubeEntity> type, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
		if (world.func_226658_a_(LightType.SKY, pos) > rand.nextInt(32)) {
			return false;
		} else {
			int i = world.getWorld().isThundering() ? world.getNeighborAwareLightSubtracted(pos, 10) : world.getLight(pos);
			return i <= rand.nextInt(8) && world.getDifficulty() != Difficulty.PEACEFUL;
		}
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.targetSelector.addGoal(1,
				new NearestAttackableTargetGoal<>(this, MagmaCubeEntity.class, 10, true, false, (entity) -> {
					return Math.abs(entity.func_226278_cu_() - this.func_226278_cu_()) <= 4.0D;
				}));
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.2F);
	}
	
	@Override
	protected void setSlimeSize(int size, boolean resetHealth) {
		super.setSlimeSize(size, resetHealth);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue((double) (size * 3));
	}
	
	@Override
	public void applyEntityCollision(Entity entityIn) {
		super.applyEntityCollision(entityIn);
		if (entityIn instanceof MagmaCubeEntity && this.canDamagePlayer()) {
			this.dealDamage((LivingEntity) entityIn);
		}

	}
	
	@Override
	protected ResourceLocation getLootTable() {
		return this.isSmallSlime() ? LootTables.EMPTY : this.getType().getLootTable();
	}
	
	@Override
	protected IParticleData getSquishParticle() {
		return ParticleTypes.ITEM_SNOWBALL;
	}
	
	@Override
	protected int getJumpDelay() {
		return super.getJumpDelay() * 2;
	}
	
	@Override
	protected void alterSquishAmount() {
		this.squishAmount *= 0.4F;
	}
	
	@Override
	public void livingTick() {
		super.livingTick();
		if (!this.world.isRemote) {
			int i = MathHelper.floor(this.func_226277_ct_());
			int j = MathHelper.floor(this.func_226278_cu_());
			int k = MathHelper.floor(this.func_226281_cx_());

			//temperature damage
			if (this.world.func_226691_t_(new BlockPos(i, 0, k)).func_225486_c(new BlockPos(i, j, k)) > 1.0F) {
				if(world.getRandom().nextFloat() < 0.2F) {
					if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this)) {
						BlockState blockstate = Blocks.WATER.getDefaultState().with(FlowingFluidBlock.LEVEL, 1);

						for (int l = 0; l < 4; ++l) {
							i = MathHelper.floor(this.func_226277_ct_() + (double) ((float) (l % 2 * 2 - 1) * 0.25F));
							j = MathHelper.floor(this.func_226278_cu_());
							k = MathHelper.floor(this.func_226281_cx_() + (double) ((float) (l / 2 % 2 * 2 - 1) * 0.25F));
							BlockPos blockpos = new BlockPos(i, j, k);
							if (this.world.isAirBlock(blockpos)
									&& this.world.func_226691_t_(blockpos).func_225486_c(blockpos) < 0.8F
									&& blockstate.isValidPosition(this.world, blockpos)) {
								this.world.setBlockState(blockpos, blockstate);
							}
						}
					}

					this.attackEntityFrom(DamageSource.ON_FIRE, 1.0F);
					
				}

			}
			
		}

	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.BLOCK_GLASS_HIT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.BLOCK_GLASS_BREAK;
	}

	@Override
	protected SoundEvent getSquishSound() {
		return SoundEvents.BLOCK_GLASS_STEP;
	}
	
	@Nullable
	@Override
	public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			@Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}
}
