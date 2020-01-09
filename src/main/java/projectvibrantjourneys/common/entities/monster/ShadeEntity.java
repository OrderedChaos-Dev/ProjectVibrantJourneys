package projectvibrantjourneys.common.entities.monster;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class ShadeEntity extends AngryGhostEntity {

	public ShadeEntity(EntityType<? extends ShadeEntity> entityType, World world) {
		super(entityType, world);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		boolean flag = super.attackEntityAsMob(entity);
		if (flag) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, 200));
			}
		}

		return flag;
	}
}
