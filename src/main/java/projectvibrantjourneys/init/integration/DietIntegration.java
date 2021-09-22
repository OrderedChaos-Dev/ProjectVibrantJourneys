package projectvibrantjourneys.init.integration;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Tuple;
import net.minecraftforge.fml.InterModComms;
import projectvibrantjourneys.init.object.PVJItems;

public class DietIntegration {

	public static void init() {
		PVJItems.ITEMS.forEach((item) -> {
			if(item.isEdible()) {
				Food food = item.getFoodProperties();
				if(food != null) {
					int amount = food.getNutrition();
					float saturation = food.getSaturationModifier();
					InterModComms.sendTo("diet", "item", () -> new Tuple<Item, BiFunction<PlayerEntity, ItemStack, Triple<List<ItemStack>, Integer, Float>>>(item, (player, stack) -> {
						return new ImmutableTriple<>(Collections.singletonList(stack), amount, saturation);
					}));
				}
			}
		});
	}
}
