package projectvibrantjourneys.init.object;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class PVJFoods {

	public static final FoodProperties RAW_CLAM = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).effect(() -> new MobEffectInstance(MobEffects.POISON, 400, 0), 0.9F).build();
	public static final FoodProperties COOKED_CLAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();
	public static final FoodProperties CLAM_CHOWDER = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.7F).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 300, 0), 1.0F).build();
	public static final FoodProperties CRACKED_COCONUT = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.35F).build();
	public static final FoodProperties COCONUT_MILK = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.25F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300, 0), 1.0F).alwaysEat().build();
	public static final FoodProperties JUNIPER_BERRIES = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F).alwaysEat().build();
}
