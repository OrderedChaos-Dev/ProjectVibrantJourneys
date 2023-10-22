package dev.orderedchaos.projectvibrantjourneys.data;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBiomeModifiers;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJConfiguredFeatures;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJPlacements;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PVJDataGenerators {

  private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
    .add(Registries.CONFIGURED_FEATURE, PVJConfiguredFeatures::bootstrap)
    .add(Registries.PLACED_FEATURE, PVJPlacements::bootstrap)
    .add(ForgeRegistries.Keys.BIOME_MODIFIERS, PVJBiomeModifiers::bootstrap);

  @SubscribeEvent
  public static void gatherData(GatherDataEvent event) {
    DataGenerator generator = event.getGenerator();
    PackOutput packOutput = generator.getPackOutput();
    ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
    CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

    PVJBlockTags blockTags = new PVJBlockTags(packOutput, lookupProvider, existingFileHelper);
    generator.addProvider(event.includeServer(), blockTags);
    generator.addProvider(event.includeServer(), new PVJItemTags(packOutput, lookupProvider, blockTags.contentsGetter(), existingFileHelper));
    generator.addProvider(event.includeServer(), new PVJRecipes(packOutput));
    generator.addProvider(event.includeServer(), new PVJBiomeTagsProvider(packOutput, lookupProvider, existingFileHelper));

    generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(packOutput, lookupProvider, BUILDER, Set.of(ProjectVibrantJourneys.MOD_ID)));
    generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Set.of(), List.of(new LootTableProvider.SubProviderEntry(PVJBlockLootProvider::new, LootContextParamSets.BLOCK))));
  }
}
