package dev.orderedchaos.projectvibrantjourneys.common;

import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
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
import net.minecraftforge.common.crafting.StrictNBTIngredient;

public class PVJBrewingRecipes {

  private static final Ingredient AWKWARD_POTION = StrictNBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD));
  private static final Ingredient GLOWING_POTION = StrictNBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), PVJPotions.GLOWING.get()));
  private static final Ingredient GLOWING_SPLASH_POTION = StrictNBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), PVJPotions.GLOWING.get()));
  private static final Ingredient GLOWING_LINGERING_POTION = StrictNBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), PVJPotions.GLOWING.get()));

  private static final Ingredient SPORADIC_SILENCE_POTION = StrictNBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), PVJPotions.GLOWING.get()));
  private static final Ingredient SPORADIC_SILENCE_SPLASH_POTION = StrictNBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), PVJPotions.GLOWING.get()));
  private static final Ingredient SPORADIC_SILENCE_LINGERING_POTION = StrictNBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), PVJPotions.GLOWING.get()));


  public static void init() {
    recipe(AWKWARD_POTION, PVJItems.GLOWCAP.get(), customPotion(PVJPotions.GLOWING.get()));
    recipe(GLOWING_POTION, Items.REDSTONE, customPotion(PVJPotions.LONG_GLOWING.get()));
    recipe(GLOWING_SPLASH_POTION, Items.REDSTONE, customSplashPotion(PVJPotions.LONG_GLOWING.get()));
    recipe(GLOWING_LINGERING_POTION, Items.REDSTONE, customLingeringPotion(PVJPotions.LONG_GLOWING.get()));

    recipe(AWKWARD_POTION, PVJBlocks.GLOWING_BLUE_FUNGUS.get(), customPotion(PVJPotions.SPORADIC_SILENCE.get()));
    recipe(SPORADIC_SILENCE_POTION, Items.REDSTONE, customPotion(PVJPotions.LONG_SPORADIC_SILENCE.get()));
    recipe(SPORADIC_SILENCE_SPLASH_POTION, Items.REDSTONE, customSplashPotion(PVJPotions.LONG_SPORADIC_SILENCE.get()));
    recipe(SPORADIC_SILENCE_LINGERING_POTION, Items.REDSTONE, customLingeringPotion(PVJPotions.LONG_SPORADIC_SILENCE.get()));
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
