package com.projectvibrantjourneys.init.object;

import com.projectvibrantjourneys.core.ProjectVibrantJourneys;
import com.projectvibrantjourneys.init.PVJCreativeModeTab;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PVJItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ProjectVibrantJourneys.MOD_ID);
	
	
	private static RegistryObject<Item> registerItem(String name, Item item) {

		return ITEMS.register(name, () -> item);
	}
    
    public static class Food {
    	public static final FoodProperties RAW_CLAM = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).effect(() -> new MobEffectInstance(MobEffects.POISON, 400, 0), 0.9F).build();
    	public static final FoodProperties COOKED_CLAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();
    	public static final FoodProperties CLAM_CHOWDER = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.7F).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 300, 0), 1.0F).build();
    }
}
