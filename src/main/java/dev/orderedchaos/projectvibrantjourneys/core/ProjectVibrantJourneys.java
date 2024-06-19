package dev.orderedchaos.projectvibrantjourneys.core;

import dev.orderedchaos.projectvibrantjourneys.common.world.features.ruinednetherportal.RuinedPortalDecoratorBase;
import dev.orderedchaos.projectvibrantjourneys.core.registry.*;
import dev.orderedchaos.projectvibrantjourneys.data.client.PVJLanguageProvider;
import dev.orderedchaos.projectvibrantjourneys.data.datamaps.PVJDataMapsProvider;
import dev.orderedchaos.projectvibrantjourneys.data.loottables.PVJBlockLoot;
import dev.orderedchaos.projectvibrantjourneys.data.recipes.PVJRecipes;
import dev.orderedchaos.projectvibrantjourneys.data.tags.PVJBiomeTagsProvider;
import dev.orderedchaos.projectvibrantjourneys.data.tags.PVJBlockTagsProvider;
import dev.orderedchaos.projectvibrantjourneys.data.tags.PVJItemTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

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

        // TODO: mixin in short grass from bonemeal
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        RuinedPortalDecoratorBase.registerPortalDecorators();
    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD)
    public static class Data {
        private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
          .add(Registries.CONFIGURED_FEATURE, PVJConfiguredFeatures::bootstrap)
          .add(Registries.PLACED_FEATURE, PVJPlacements::bootstrap)
          .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, PVJBiomeModifiers::bootstrap);

        @SubscribeEvent
        public static void gatherData(GatherDataEvent event) {
            DataGenerator generator = event.getGenerator();
            PackOutput packOutput = event.getGenerator().getPackOutput();
            CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
            ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

            PVJBlockTagsProvider blockTagsProvider = new PVJBlockTagsProvider(packOutput, lookupProvider, existingFileHelper);
            generator.addProvider(event.includeServer(), blockTagsProvider);
            generator.addProvider(event.includeServer(), new PVJItemTagsProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
            generator.addProvider(event.includeServer(), new PVJBiomeTagsProvider(packOutput, lookupProvider, existingFileHelper));
            generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(PVJBlockLoot::new, LootContextParamSets.BLOCK)), lookupProvider));
            generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(packOutput, lookupProvider, BUILDER, Set.of(ProjectVibrantJourneys.MOD_ID)));
            generator.addProvider(event.includeServer(), new PVJRecipes(packOutput, lookupProvider));
            generator.addProvider(event.includeServer(), new PVJDataMapsProvider(packOutput, lookupProvider));

            generator.addProvider(event.includeClient(), new PVJLanguageProvider(packOutput));
        }
    }
}
