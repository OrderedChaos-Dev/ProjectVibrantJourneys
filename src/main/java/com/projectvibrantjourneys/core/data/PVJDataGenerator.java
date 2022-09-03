package com.projectvibrantjourneys.core.data;

import java.util.Map;

import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import com.projectvibrantjourneys.core.ProjectVibrantJourneys;

import net.minecraft.core.RegistryAccess;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PVJDataGenerator {

	@SubscribeEvent
    public static void data(GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();
		PVJBlockTagsProvider blockTags = new PVJBlockTagsProvider(gen, helper);
		gen.addProvider(event.includeServer(), blockTags);
		gen.addProvider(event.includeServer(), new PVJItemTagsProvider(gen, blockTags, helper));
		gen.addProvider(event.includeServer(), new PVJRecipesProvider(gen));
		
		RegistryOps<JsonElement> registryOps = RegistryOps.create(JsonOps.INSTANCE, RegistryAccess.builtinCopy());
		Map<ResourceLocation, BiomeModifier> featureGenMap = PVJBiomeModifierDataGen.createFeatureGenMap(registryOps);
		JsonCodecProvider<BiomeModifier> jsonCodecProvider = JsonCodecProvider.forDatapackRegistry(gen, helper, ProjectVibrantJourneys.MOD_ID, registryOps, ForgeRegistries.Keys.BIOME_MODIFIERS, featureGenMap);
		gen.addProvider(event.includeServer(), jsonCodecProvider);
    }
}
