package dev.orderedchaos.projectvibrantjourneys.data.recipes;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class PVJRecipes extends RecipeProvider  {

  public PVJRecipes(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
    super(pOutput, pRegistries);
  }

  @Override
  protected void buildRecipes(RecipeOutput recipeOutput) {
    this.buildCraftingRecipes(recipeOutput);
    this.buildSmeltingRecipes(recipeOutput);
  }

  private void buildCraftingRecipes(RecipeOutput recipeOutput) {
    oneToOneShapelessRecipe(recipeOutput, Items.BROWN_DYE, PVJBlocks.BARK_MUSHROOM.get(), "brown_dye");
    oneToOneShapelessRecipe(recipeOutput, Items.BROWN_DYE, PVJBlocks.LIGHT_BROWN_BARK_MUSHROOM.get(), "brown_dye");
    oneToOneShapelessRecipe(recipeOutput, Items.ORANGE_DYE, PVJBlocks.ORANGE_BARK_MUSHROOM.get(), "orange_dye");
    oneToOneShapelessRecipe(recipeOutput, Items.CYAN_DYE, PVJBlocks.WARPED_NETTLE.get(), "brown_dye");
    oneToOneShapelessRecipe(recipeOutput, Items.RED_DYE, PVJBlocks.CRIMSON_NETTLE.get(), "red_dye");

    oneToOneShapelessRecipe(recipeOutput, Items.BONE, PVJBlocks.BONES.get(), "bone");
    oneToOneShapelessRecipe(recipeOutput, Items.BONE, PVJBlocks.CHARRED_BONES.get(), "bone");
    oneToOneShapelessRecipe(recipeOutput, Items.STICK, PVJBlocks.TWIGS.get(), "stick");
    oneToOneShapelessRecipe(recipeOutput, Items.PRISMARINE_SHARD, PVJBlocks.SEASHELLS.get(), "prismarine_shard");

    oneToOneShapelessRecipe(recipeOutput, Items.OAK_PLANKS, PVJBlocks.OAK_HOLLOW_LOG.get(), 2);
    oneToOneShapelessRecipe(recipeOutput, Items.BIRCH_PLANKS, PVJBlocks.BIRCH_HOLLOW_LOG.get(), 2);
    oneToOneShapelessRecipe(recipeOutput, Items.SPRUCE_PLANKS, PVJBlocks.SPRUCE_HOLLOW_LOG.get(), 2);
    oneToOneShapelessRecipe(recipeOutput, Items.JUNGLE_PLANKS, PVJBlocks.JUNGLE_HOLLOW_LOG.get(), 2);
    oneToOneShapelessRecipe(recipeOutput, Items.DARK_OAK_PLANKS, PVJBlocks.DARK_OAK_HOLLOW_LOG.get(), 2);
    oneToOneShapelessRecipe(recipeOutput, Items.ACACIA_PLANKS, PVJBlocks.ACACIA_HOLLOW_LOG.get(), 2);
    oneToOneShapelessRecipe(recipeOutput, Items.CHERRY_PLANKS, PVJBlocks.CHERRY_HOLLOW_LOG.get(), 2);
    oneToOneShapelessRecipe(recipeOutput, Items.MANGROVE_PLANKS, PVJBlocks.MANGROVE_HOLLOW_LOG.get(), 2);

    simpleTwoByTwo(recipeOutput, Items.COBBLESTONE, PVJBlocks.ROCKS.get(), 1);
    simpleTwoByTwo(recipeOutput, Items.MOSSY_COBBLESTONE, PVJBlocks.MOSSY_ROCKS.get(), 1);
    simpleTwoByTwo(recipeOutput, Items.ICE, PVJBlocks.ICE_CHUNKS.get(), 1);
    simpleTwoByTwo(recipeOutput, Items.SANDSTONE, PVJBlocks.SANDSTONE_ROCKS.get(), 1);
    simpleTwoByTwo(recipeOutput, Items.RED_SANDSTONE, PVJBlocks.RED_SANDSTONE_ROCKS.get(), 1);

    ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Items.SHROOMLIGHT)
      .pattern(" # ")
      .pattern("#N#")
      .pattern(" # ")
      .define('#', Items.GLOWSTONE)
      .define('N', PVJBlocks.GLOWCAP.get())
      .unlockedBy(getHasName(PVJBlocks.GLOWCAP.get()), has(PVJBlocks.GLOWCAP.get()))
      .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ProjectVibrantJourneys.MOD_ID, getConversionRecipeName(Items.SHROOMLIGHT, PVJBlocks.GLOWCAP.get())));

    ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, PVJItems.NETTLE_SOUP)
      .requires(PVJBlocks.WARPED_NETTLE)
      .requires(PVJBlocks.CRIMSON_NETTLE)
      .requires(Items.BOWL)
      .unlockedBy("has_nettle_soup", has(PVJItems.NETTLE_SOUP))
      .unlockedBy("has_bowl", has(Items.BOWL))
      .unlockedBy("has_warped_nettle", has(PVJBlocks.WARPED_NETTLE))
      .unlockedBy("has_crimson_nettle", has(PVJBlocks.CRIMSON_NETTLE))
      .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ProjectVibrantJourneys.MOD_ID, "nettle_soup"));
  }

  private void buildSmeltingRecipes(RecipeOutput recipeOutput) {
    smoking(recipeOutput, Items.BLAZE_POWDER, PVJBlocks.CINDERCANE.get(), 0.3F, 800);
    smelting(recipeOutput, Items.GREEN_DYE, PVJBlocks.SMALL_CACTUS.get(), 0.1F, 200);
    smelting(recipeOutput, Items.GLOWSTONE_DUST, PVJBlocks.GLOWCAP.get(), 0.1F, 200);
  }

  private void smelting(RecipeOutput recipeOutput, ItemLike result, ItemLike ingredient, float experience, int time) {
    ResourceLocation location = ResourceLocation.fromNamespaceAndPath(ProjectVibrantJourneys.MOD_ID, getConversionRecipeName(result, ingredient));
    SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), RecipeCategory.MISC, result, experience, time)
      .unlockedBy(getHasName(ingredient), has(ingredient))
      .save(recipeOutput, location);
  }

  private void smoking(RecipeOutput recipeOutput, ItemLike result, ItemLike ingredient, float experience, int time) {
    ResourceLocation location = ResourceLocation.fromNamespaceAndPath(ProjectVibrantJourneys.MOD_ID, getConversionRecipeName(result, ingredient));
    SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), RecipeCategory.MISC, result, experience, time)
      .unlockedBy(getHasName(ingredient), has(ingredient))
      .save(recipeOutput, location);
  }

  private void oneToOneShapelessRecipe(RecipeOutput recipeOutput, ItemLike result, ItemLike ingredient) {
    oneToOneShapelessRecipe(recipeOutput, result, ingredient, null);
  }

  private void oneToOneShapelessRecipe(RecipeOutput recipeOutput, ItemLike result, ItemLike ingredient, int resultCount) {
    oneToOneShapelessRecipe(recipeOutput, result, ingredient, null, resultCount);
  }

  private void oneToOneShapelessRecipe(RecipeOutput recipeOutput, ItemLike result, ItemLike ingredient, @Nullable String group) {
    oneToOneShapelessRecipe(recipeOutput, result, ingredient, group, 1);
  }

  private void oneToOneShapelessRecipe(RecipeOutput recipeOutput, ItemLike result, ItemLike ingredient, @Nullable String group, int resultCount) {
    ResourceLocation location = ResourceLocation.fromNamespaceAndPath(ProjectVibrantJourneys.MOD_ID, getConversionRecipeName(result, ingredient));
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result, resultCount)
      .requires(ingredient)
      .group(group)
      .unlockedBy(getHasName(ingredient), has(ingredient))
      .save(recipeOutput, location);
  }

  private void soup(RecipeOutput recipeOutput, ItemLike result, ItemLike ingredient, @Nullable String group, int resultCount) {
    ResourceLocation location = ResourceLocation.fromNamespaceAndPath(ProjectVibrantJourneys.MOD_ID, getConversionRecipeName(result, ingredient));
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result, resultCount)
      .requires(ingredient)
      .group(group)
      .unlockedBy(getHasName(ingredient), has(ingredient))
      .save(recipeOutput, location);
  }

  private void simpleTwoByTwo(RecipeOutput recipeOutput, ItemLike result, ItemLike ingredient, int resultCount) {
    ResourceLocation location = ResourceLocation.fromNamespaceAndPath(ProjectVibrantJourneys.MOD_ID, getConversionRecipeName(result, ingredient));
    ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, resultCount)
      .pattern("##")
      .pattern("##")
      .define('#', ingredient)
      .unlockedBy(getHasName(ingredient), has(ingredient))
      .save(recipeOutput, location);
  }
}
