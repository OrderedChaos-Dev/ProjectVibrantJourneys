package dev.orderedchaos.projectvibrantjourneys.core.registry;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashSet;

public class PVJCreativeModeTab {

  public static HashSet<RegistryObject<Item>> TAB_ITEMS = new HashSet<>();

  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ProjectVibrantJourneys.MOD_ID);
  public static final RegistryObject<CreativeModeTab> PVJ_CREATIVE_MODE_TAB = CREATIVE_MODE_TABS.register(ProjectVibrantJourneys.MOD_ID, () -> CreativeModeTab.builder()
    .title(Component.translatable("itemGroup.projectvibrantjourneys"))
    .icon(PVJItems.TWIGS.get()::getDefaultInstance)
    .displayItems((parameters, output) -> {
      TAB_ITEMS.forEach((item) -> {
        output.accept(item.get());
      });
    }).build());
}
