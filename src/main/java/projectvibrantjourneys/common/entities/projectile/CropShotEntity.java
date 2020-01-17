package projectvibrantjourneys.common.entities.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;
import projectvibrantjourneys.init.PVJEntities;

public class CropShotEntity extends ProjectileItemEntity {
	
	public static final DataParameter<ItemStack> CROP = EntityDataManager.createKey(CropShotEntity.class, DataSerializers.ITEMSTACK);

	public CropShotEntity(EntityType<? extends CropShotEntity> type, World world) {
		super(type, world);
	}

	public CropShotEntity(World worldIn, LivingEntity throwerIn, Item crop) {
		super(PVJEntities.crop_shot, throwerIn, worldIn);
		this.dataManager.set(CROP, new ItemStack(crop));
	}

	public CropShotEntity(World worldIn, double x, double y, double z) {
		super(PVJEntities.crop_shot, x, y, z, worldIn);
	}
	
	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(CROP, new ItemStack(Items.WHEAT));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 3) {
			for (int i = 0; i < 8; ++i) {
				this.world.addParticle(new ItemParticleData(ParticleTypes.ITEM, this.getItem()), this.func_226277_ct_(),
						this.func_226278_cu_(), this.func_226281_cx_(), ((double) this.rand.nextFloat() - 0.5D) * 0.08D,
						((double) this.rand.nextFloat() - 0.5D) * 0.08D,
						((double) this.rand.nextFloat() - 0.5D) * 0.08D);
			}
		}
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		Item item = this.dataManager.get(CROP).getItem();
		if (result.getType() == RayTraceResult.Type.ENTITY) {
			float damage = 0.5F;
			if(item == Items.WHEAT || item == Items.POTATO || item == Items.CARROT || item == Items.APPLE || item == Items.BEETROOT)
				damage = 1.0F;
			if(item == Items.CACTUS)
				damage = 1.5F;
			if(item == Items.PUMPKIN || item == Items.MELON)
				damage = 2.0F;
			
			Entity target = ((EntityRayTraceResult) result).getEntity();
			
			target.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), damage);
			
			if(item == Items.POISONOUS_POTATO) {
				if(this.rand.nextBoolean()) {
					if(target instanceof LivingEntity) {
						((LivingEntity) target).addPotionEffect(new EffectInstance(Effects.POISON, 100, 0));
					}
				}
			}
		} else if(result.getType() == RayTraceResult.Type.BLOCK) {
			if(item == Items.STONE_HOE) {
				this.world.destroyBlock(this.getPosition(), false);
			}
		}

		if (!this.world.isRemote) {
			this.remove();
		}
	}

	@Override
	protected Item func_213885_i() {
		return this.getDataManager().get(CROP).getItem();
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}