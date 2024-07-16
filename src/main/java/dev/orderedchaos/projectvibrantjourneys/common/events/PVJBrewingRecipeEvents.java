package dev.orderedchaos.projectvibrantjourneys.common.events;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJPotions;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class PVJBrewingRecipeEvents {

  @SubscribeEvent
  public static void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
    PotionBrewing.Builder builder = event.getBuilder();
    builder.addMix(Potions.AWKWARD, PVJBlocks.GLOWCAP.asItem(), PVJPotions.GLOWING);
    builder.addMix(PVJPotions.GLOWING, Items.REDSTONE, PVJPotions.LONG_GLOWING);

    builder.addMix(Potions.AWKWARD, PVJBlocks.GLOWING_BLUE_FUNGUS.asItem(), PVJPotions.SPORADIC_SILENCE);
    builder.addMix(PVJPotions.SPORADIC_SILENCE, Items.REDSTONE, PVJPotions.LONG_SPORADIC_SILENCE);
    builder.addMix(PVJPotions.SPORADIC_SILENCE, Items.GLOWSTONE_DUST, PVJPotions.STRONG_SPORADIC_SILENCE);
  }
}
