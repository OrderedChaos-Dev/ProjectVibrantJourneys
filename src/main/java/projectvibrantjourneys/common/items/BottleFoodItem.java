package projectvibrantjourneys.common.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class BottleFoodItem extends Item {

	public BottleFoodItem(Item.Properties props) {
		super(props);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
		ItemStack itemstack = super.finishUsingItem(stack, world, entity);
		return entity instanceof Player && ((Player) entity).getAbilities().instabuild ? itemstack : new ItemStack(Items.GLASS_BOTTLE);
	}
		   
}
