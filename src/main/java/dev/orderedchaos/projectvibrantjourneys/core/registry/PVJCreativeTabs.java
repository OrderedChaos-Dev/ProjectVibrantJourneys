package dev.orderedchaos.projectvibrantjourneys.core.registry;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PVJCreativeTabs {
  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ProjectVibrantJourneys.MOD_ID);

  public static final DeferredHolder<CreativeModeTab, CreativeModeTab> PVJ_TAB = CREATIVE_MODE_TABS.register("pvj_tab", () -> CreativeModeTab.builder()
    .title(Component.translatable("itemGroup.projectvibrantjourneys"))
    .icon(PVJBlocks.TWIGS::toStack)
    .displayItems((parameters, output) -> {
      PVJItems.ITEMS_FOR_CREATIVE_TAB.forEach(output::accept);
    })
    .build());
}
