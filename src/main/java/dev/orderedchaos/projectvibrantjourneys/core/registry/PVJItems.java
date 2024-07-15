package dev.orderedchaos.projectvibrantjourneys.core.registry;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.function.Supplier;

public class PVJItems {
  public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ProjectVibrantJourneys.MOD_ID);
  public static final ArrayList<DeferredItem<?>> ITEMS_FOR_CREATIVE_TAB = new ArrayList<>();

  public static final DeferredItem<Item> NETTLE_SOUP = register("nettle_soup", () -> new Item(new Item.Properties().stacksTo(1).food(Foods.NETTLE_SOUP)));

  public static DeferredItem<Item> register(String name, Supplier<Item> itemSupplier) {
    DeferredItem<Item> item = ITEMS.register(name, itemSupplier);
    ITEMS_FOR_CREATIVE_TAB.add(item);
    return item;
  }

  public static class Foods {
    public static final FoodProperties NETTLE_SOUP = new FoodProperties.Builder()
      .nutrition(3)
      .saturationModifier(0.3F)
      .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200), 1.0F)
      .alwaysEdible()
      .usingConvertsTo(Items.BOWL)
      .build();
  }
}
