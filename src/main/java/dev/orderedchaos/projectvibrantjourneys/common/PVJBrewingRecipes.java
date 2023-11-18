package dev.orderedchaos.projectvibrantjourneys.common;

import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJItems;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJPotions;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

public class PVJBrewingRecipes {

  private static final Ingredient AWKWARD_POTION = Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD));
  private static final Ingredient GLOWING_POTION = Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), PVJPotions.GLOWING.get()));
  private static final Ingredient GLOWING_SPLASH_POTION = Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), PVJPotions.GLOWING.get()));
  private static final Ingredient GLOWING_LINGERING_POTION = Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), PVJPotions.GLOWING.get()));


  public static void init() {
    recipe(AWKWARD_POTION, PVJItems.GLOWCAP.get(), customPotion(PVJPotions.GLOWING.get()));
    recipe(GLOWING_POTION, Items.REDSTONE, customPotion(PVJPotions.LONG_GLOWING.get()));
    recipe(GLOWING_SPLASH_POTION, Items.REDSTONE, customSplashPotion(PVJPotions.LONG_GLOWING.get()));
    recipe(GLOWING_LINGERING_POTION, Items.REDSTONE, customLingeringPotion(PVJPotions.LONG_GLOWING.get()));
  }

  private static void recipe(Ingredient input, ItemLike ingredient, ItemStack output) {
    BrewingRecipeRegistry.addRecipe(input, Ingredient.of(ingredient), output);
  }

  private static ItemStack customPotion(Potion potion) {
    return PotionUtils.setPotion(new ItemStack(Items.POTION), potion);
  }

  private static ItemStack customSplashPotion(Potion potion) {
    return PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), potion);
  }

  private static ItemStack customLingeringPotion(Potion potion) {
    return PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), potion);
  }
}
