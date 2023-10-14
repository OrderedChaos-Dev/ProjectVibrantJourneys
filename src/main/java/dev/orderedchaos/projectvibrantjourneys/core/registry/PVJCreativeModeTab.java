package dev.orderedchaos.projectvibrantjourneys.core.registry;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PVJCreativeModeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ProjectVibrantJourneys.MOD_ID);
    public static final RegistryObject<CreativeModeTab> PVJ_CREATIVE_MODE_TAB = CREATIVE_MODE_TABS.register("project_vibrant_journeys_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(Items.OAK_SAPLING::getDefaultInstance)
            .displayItems((parameters, output) -> {
                output.accept(Items.OAK_SAPLING);
            }).build());
}
