package projectvibrantjourneys.init.object;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class PVJFoods {

	public static final Food RAW_CLAM = (new Food.Builder()).nutrition(1).saturationMod(0.2F).effect(() -> new EffectInstance(Effects.POISON, 400, 0), 0.9F).build();
	public static final Food COOKED_CLAM = (new Food.Builder()).nutrition(6).saturationMod(0.6F).build();
	public static final Food CLAM_CHOWDER = (new Food.Builder()).nutrition(9).saturationMod(0.7F).effect(() -> new EffectInstance(Effects.WATER_BREATHING, 300, 0), 1.0F).build();
	public static final Food CRACKED_COCONUT = (new Food.Builder()).nutrition(3).saturationMod(0.35F).build();
	public static final Food COCONUT_MILK = (new Food.Builder()).nutrition(5).saturationMod(0.25F).effect(() -> new EffectInstance(Effects.REGENERATION, 300, 0), 1.0F).alwaysEat().build();
	public static final Food JUNIPER_BERRIES = (new Food.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new EffectInstance(Effects.REGENERATION, 100, 0), 1.0F).alwaysEat().build();
}
