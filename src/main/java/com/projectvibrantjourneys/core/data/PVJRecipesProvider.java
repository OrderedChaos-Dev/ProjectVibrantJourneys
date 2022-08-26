package com.projectvibrantjourneys.core.data;

import java.util.function.Consumer;

import com.projectvibrantjourneys.core.ProjectVibrantJourneys;
import com.projectvibrantjourneys.core.registry.PVJBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class PVJRecipesProvider extends RecipeProvider {
	
	public PVJRecipesProvider(DataGenerator generator) {
		super(generator);
	}
	
    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
    	planksFromHollowLog(Blocks.OAK_PLANKS, PVJBlocks.OAK_HOLLOW_LOG.get(), consumer);
    	planksFromHollowLog(Blocks.BIRCH_PLANKS, PVJBlocks.BIRCH_HOLLOW_LOG.get(), consumer);
    	planksFromHollowLog(Blocks.SPRUCE_PLANKS, PVJBlocks.SPRUCE_HOLLOW_LOG.get(), consumer);
    	planksFromHollowLog(Blocks.JUNGLE_PLANKS, PVJBlocks.JUNGLE_HOLLOW_LOG.get(), consumer);
    	planksFromHollowLog(Blocks.ACACIA_PLANKS, PVJBlocks.ACACIA_HOLLOW_LOG.get(), consumer);
    	planksFromHollowLog(Blocks.DARK_OAK_PLANKS, PVJBlocks.DARK_OAK_HOLLOW_LOG.get(), consumer);
    }
    
    private void planksFromHollowLog(Block planks, Block log, Consumer<FinishedRecipe> consumer) {
    	ShapelessRecipeBuilder.shapeless(planks, 2).requires(log).group("planks").unlockedBy("has_logs", has(log)).save(consumer, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, planks.getRegistryName().getPath()));
    }
}