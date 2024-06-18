package dev.orderedchaos.projectvibrantjourneys.core;

import dev.orderedchaos.projectvibrantjourneys.common.world.features.ruinednetherportal.RuinedPortalDecoratorBase;
import dev.orderedchaos.projectvibrantjourneys.core.registry.*;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(ProjectVibrantJourneys.MOD_ID)
public class ProjectVibrantJourneys {
    public static final String MOD_ID = "projectvibrantjourneys";
    public static final Logger LOGGER = LogUtils.getLogger();



    public ProjectVibrantJourneys(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        PVJItems.ITEMS.register(modEventBus);
        PVJBlocks.BLOCKS.register(modEventBus);
        PVJFeatures.FEATURES.register(modEventBus);
        PVJFeatures.StateProviders.TYPES.register(modEventBus);
        PVJBiomeModifiers.BIOME_MODIFIER_SERIALIZERS.register(modEventBus);
        PVJConfiguredFeatures.CONFIGURED_FEATURES.register(modEventBus);
        PVJPlacements.PLACED_FEATURES.register(modEventBus);
        PVJPotions.POTIONS.register(modEventBus);
        PVJCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, PVJConfig.COMMON_CONFIG);

        // TODO: data gen
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        RuinedPortalDecoratorBase.registerPortalDecorators();
    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
