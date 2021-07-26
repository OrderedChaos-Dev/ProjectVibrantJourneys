package projectvibrantjourneys.common.items;

import java.util.List;
import java.util.function.Predicate;

import net.minecraft.world.entity.EntitySelector;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import projectvibrantjourneys.common.entities.items.PVJBoatEntity;

public class PVJBoatItem extends Item {
	
	private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);
	private final PVJBoatEntity.PVJBoatType type;

	public PVJBoatItem(PVJBoatEntity.PVJBoatType typeIn, Item.Properties properties) {
		super(properties);
		this.type = typeIn;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		HitResult raytraceresult = getPlayerPOVHitResult(world, player, ClipContext.Fluid.ANY);
		if (raytraceresult.getType() == HitResult.Type.MISS) {
			return InteractionResultHolder.pass(itemstack);
		} else {
			Vec3 vector3d = player.getViewVector(1.0F);
			double d0 = 5.0D;
			List<Entity> list = world.getEntities(player,
					player.getBoundingBox().expandTowards(vector3d.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);
			if (!list.isEmpty()) {
				Vec3 vector3d1 = player.getEyePosition(1.0F);

				for (Entity entity : list) {
					AABB axisalignedbb = entity.getBoundingBox().inflate((double) entity.getPickRadius());
					if (axisalignedbb.contains(vector3d1)) {
						return InteractionResultHolder.pass(itemstack);
					}
				}
			}

			if (raytraceresult.getType() == HitResult.Type.BLOCK) {
				PVJBoatEntity boatentity = new PVJBoatEntity(world, raytraceresult.getLocation().x,
						raytraceresult.getLocation().y, raytraceresult.getLocation().z);
				boatentity.setBoatType(this.type);
				boatentity.setYRot(player.getYRot());
				if (!world.noCollision(boatentity, boatentity.getBoundingBox().inflate(-0.1D))) {
					return InteractionResultHolder.fail(itemstack);
				} else {
					if (!world.isClientSide) {
						world.addFreshEntity(boatentity);
						if (!player.getAbilities().instabuild) {
							itemstack.shrink(1);
						}
					}

					player.awardStat(Stats.ITEM_USED.get(this));
					return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
				}
			} else {
				return InteractionResultHolder.pass(itemstack);
			}
		}
	}
}