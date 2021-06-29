package projectvibrantjourneys.common.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class BottleFoodItem extends Item {

	public BottleFoodItem(Item.Properties props) {
		super(props);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity entity) {
		ItemStack itemstack = super.finishUsingItem(stack, world, entity);
		return entity instanceof PlayerEntity && ((PlayerEntity) entity).abilities.instabuild ? itemstack : new ItemStack(Items.GLASS_BOTTLE);
	}
		   
}
