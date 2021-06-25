package projectvibrantjourneys.common.items;

import java.util.List;
import java.util.function.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import projectvibrantjourneys.common.entities.items.PVJBoatEntity;

public class PVJBoatItem extends Item {
	
	private static final Predicate<Entity> ENTITY_PREDICATE = EntityPredicates.NO_SPECTATORS.and(Entity::isPickable);
	private final PVJBoatEntity.PVJBoatType type;

	public PVJBoatItem(PVJBoatEntity.PVJBoatType typeIn, Item.Properties properties) {
		super(properties);
		this.type = typeIn;
	}

	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		RayTraceResult raytraceresult = getPlayerPOVHitResult(world, player, RayTraceContext.FluidMode.ANY);
		if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
			return ActionResult.pass(itemstack);
		} else {
			Vector3d vector3d = player.getViewVector(1.0F);
			double d0 = 5.0D;
			List<Entity> list = world.getEntities(player,
					player.getBoundingBox().expandTowards(vector3d.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);
			if (!list.isEmpty()) {
				Vector3d vector3d1 = player.getEyePosition(1.0F);

				for (Entity entity : list) {
					AxisAlignedBB axisalignedbb = entity.getBoundingBox().inflate((double) entity.getPickRadius());
					if (axisalignedbb.contains(vector3d1)) {
						return ActionResult.pass(itemstack);
					}
				}
			}

			if (raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
				PVJBoatEntity boatentity = new PVJBoatEntity(world, raytraceresult.getLocation().x,
						raytraceresult.getLocation().y, raytraceresult.getLocation().z);
				boatentity.setBoatType(this.type);
				boatentity.yRot = player.yRot;
				if (!world.noCollision(boatentity, boatentity.getBoundingBox().inflate(-0.1D))) {
					return ActionResult.fail(itemstack);
				} else {
					if (!world.isClientSide) {
						world.addFreshEntity(boatentity);
						if (!player.abilities.instabuild) {
							itemstack.shrink(1);
						}
					}

					player.awardStat(Stats.ITEM_USED.get(this));
					return ActionResult.sidedSuccess(itemstack, world.isClientSide());
				}
			} else {
				return ActionResult.pass(itemstack);
			}
		}
	}
}