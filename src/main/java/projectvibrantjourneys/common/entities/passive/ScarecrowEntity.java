package projectvibrantjourneys.common.entities.passive;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.common.entities.WeightedCropList;
import projectvibrantjourneys.common.entities.projectile.CropShotEntity;
import projectvibrantjourneys.init.PVJSoundEvents;

public class ScarecrowEntity extends CreatureEntity implements IRangedAttackMob {
		
	public static final WeightedCropList crops = new WeightedCropList();

	public ScarecrowEntity(EntityType<? extends ScarecrowEntity> type, World world) {
		super(type, world);
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.01D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).setBaseValue(2.0D);
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();
		
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.0D, true));
		this.goalSelector.addGoal(1, new RangedAttackGoal(this, 0.0D, 25, 20.0F));
		this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(5, new LookRandomlyGoal(this));

		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MobEntity.class, 5, false, false, (target) -> {
					return target instanceof IMob && !(target instanceof CreeperEntity);
		}));
	}
	
	@Override
	public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
	      CropShotEntity cropshotentity = new CropShotEntity(this.world, this, crops.getRandom(this.getRNG()));
	      double d0 = target.getPosYHeight(0.3D) - cropshotentity.getPosY();
	      double d1 = target.getPosX() - this.getPosX();
	      double d3 = target.getPosZ() - this.getPosZ();
	      float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
	      cropshotentity.shoot(d1, d0 + (double)f, d3, 1.6F, 10.0F);
	      this.playSound(SoundEvents.ENTITY_SNOW_GOLEM_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
	      this.world.addEntity(cropshotentity);
	}
	
	@Override
	public void livingTick() {
		super.livingTick();

		this.setMotion(this.getMotion().mul(0, 1, 0));
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public boolean isInRangeToRenderDist(double distance) {
		return true;
	}

	@Override
	public boolean preventDespawn() {
		return true;
	}

	@Override
	public boolean canDespawn(double distanceToClosestPlayer) {
		return false;
	}
	
	@Override
	public boolean canBePushed() {
		return false;
	}

	@Override
	public void applyEntityCollision(Entity entity) {}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {}

	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.UNDEFINED;
	}
	
	@Override
	public SoundCategory getSoundCategory() {
		return SoundCategory.NEUTRAL;
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return PVJSoundEvents.entity_scarecrow_ambient;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PVJSoundEvents.entity_scarecrow_ambient;
	}
	
	@Override
	public boolean processInteract(PlayerEntity player, Hand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
		if(itemstack.getItem() == Items.WHEAT) {
			if(this.getHealth() < this.getMaxHealth()) {
				this.heal(5.0F);
				itemstack.shrink(1);
				return true;
			}
		}
		
		return false;
	}
}
