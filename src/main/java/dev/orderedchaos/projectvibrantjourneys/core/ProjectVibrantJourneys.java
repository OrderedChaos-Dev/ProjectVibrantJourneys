package dev.orderedchaos.projectvibrantjourneys.core;

import com.mojang.logging.LogUtils;
import dev.orderedchaos.projectvibrantjourneys.common.PVJCompostables;
import dev.orderedchaos.projectvibrantjourneys.common.PVJGeneralEvents;
import dev.orderedchaos.projectvibrantjourneys.core.config.ChanceTreeFeatureConfig;
import dev.orderedchaos.projectvibrantjourneys.core.config.PVJConfig;
import dev.orderedchaos.projectvibrantjourneys.core.registry.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ProjectVibrantJourneys.MOD_ID)
public class ProjectVibrantJourneys {
  public static final String MOD_ID = "projectvibrantjourneys";
  public static final Logger LOGGER = LogUtils.getLogger();

  public ProjectVibrantJourneys() {
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

    ChanceTreeFeatureConfig.init();
    PVJCreativeModeTab.CREATIVE_MODE_TABS.register(bus);
    PVJBlocks.BLOCKS.register(bus);
    PVJItems.ITEMS.register(bus);
    PVJFeatures.FEATURES.register(bus);
    PVJFeatures.StateProviders.TYPES.register(bus);
    PVJBiomeModifiers.BIOME_MODIFIER_SERIALIZERS.register(bus);
    PVJConfiguredFeatures.CONFIGURED_FEATURES.register(bus);
    PVJPlacements.PLACED_FEATURES.register(bus);

    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PVJConfig.COMMON_CONFIG);

    bus.addListener(this::commonSetup);
    bus.addListener(this::clientSetup);
    MinecraftForge.EVENT_BUS.register(new PVJGeneralEvents());
    MinecraftForge.EVENT_BUS.register(this);
  }

  private void commonSetup(final FMLCommonSetupEvent event) {
    event.enqueueWork(PVJCompostables::init);
  }

  private void clientSetup(final FMLClientSetupEvent event) {

  }
}
