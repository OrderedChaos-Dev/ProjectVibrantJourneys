package com.projectvibrantjourneys.init.world;

import com.projectvibrantjourneys.core.ProjectVibrantJourneys;
import com.projectvibrantjourneys.world.gen.biomes.AspenGroveBiome;
import com.projectvibrantjourneys.world.gen.biomes.AutumnalConiferousForestBiome;
import com.projectvibrantjourneys.world.gen.biomes.BaobabFieldsBiome;
import com.projectvibrantjourneys.world.gen.biomes.BlossomingFieldsBiome;
import com.projectvibrantjourneys.world.gen.biomes.BorealForestBiome;
import com.projectvibrantjourneys.world.gen.biomes.CrystalLakesBiome;
import com.projectvibrantjourneys.world.gen.biomes.DesertShrublandBiome;
import com.projectvibrantjourneys.world.gen.biomes.OvergrownSpiresBiome;
import com.projectvibrantjourneys.world.gen.biomes.PineMeadowsBiome;
import com.projectvibrantjourneys.world.gen.biomes.PrairieBiome;
import com.projectvibrantjourneys.world.gen.biomes.RedwoodsBiome;
import com.projectvibrantjourneys.world.gen.biomes.VerdantSandsBiome;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PVJBiomes {
	
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, ProjectVibrantJourneys.MOD_ID);
	
	public static final RegistryObject<Biome> VERDANT_SANDS = register(VerdantSandsBiome.verdantSands(), "verdant_sands");
	public static final RegistryObject<Biome> PINE_MEADOWS = register(PineMeadowsBiome.pineMeadows(), "pine_meadows");
	public static final RegistryObject<Biome> AUTUMNAL_CONIFEROUS_FOREST = register(AutumnalConiferousForestBiome.autumnalConiferousForest(), "autumnal_coniferous_forest");
	public static final RegistryObject<Biome> BOREAL_FOREST = register(BorealForestBiome.borealForest(false), "boreal_forest");
	public static final RegistryObject<Biome> SNOWY_BOREAL_FOREST = register(BorealForestBiome.borealForest(true), "snowy_boreal_forest");
	public static final RegistryObject<Biome> DESERT_SHRUBLAND = register(DesertShrublandBiome.desertShrubland(), "desert_shrubland");
	public static final RegistryObject<Biome> OVERGROWN_SPIRES = register(OvergrownSpiresBiome.overgrownSpires(), "overgrown_spires");
	public static final RegistryObject<Biome> REDWOODS = register(RedwoodsBiome.redwoods(false), "redwoods");
	public static final RegistryObject<Biome> SNOWY_REDWOODS = register(RedwoodsBiome.redwoods(true), "snowy_redwoods");
	public static final RegistryObject<Biome> ASPEN_GROVE = register(AspenGroveBiome.aspenGrove(), "aspen_grove");
//	public static final Biome MANGROVE_MARSH = register(DesertShrublandBiome.desertShrubland(), "mangrove_marsh");
//	public static final Biome WILLOW_WETLANDS = register(DesertShrublandBiome.desertShrubland(), "willow_wetlands");
	public static final RegistryObject<Biome> BAOBAB_FIELDS = register(BaobabFieldsBiome.baobabFields(), "baobab_fields");
	public static final RegistryObject<Biome> PRAIRIE = register(PrairieBiome.prairie(), "prairie");
	public static final RegistryObject<Biome> BLOSSOMING_FIELDS = register(BlossomingFieldsBiome.blossomingFields(), "blossoming_fields");
//	public static final Biome RED_ROCK_VALLEY = register(DesertShrublandBiome.desertShrubland(), "red_rock_valley");
	public static final RegistryObject<Biome> CRYSTAL_LAKES = register(CrystalLakesBiome.crystalLakes(), "crystal_lakes");
//	public static final Biome WINDSWEPT_CLIFFS = register(DesertShrublandBiome.desertShrubland(), "windswept_cliffs");
	
	public static class Keys {
		public static final ResourceKey<Biome> VERDANT_SANDS = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "verdant_sands"));
		public static final ResourceKey<Biome> PINE_MEADOWS = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "pine_meadows"));
		public static final ResourceKey<Biome> AUTUMNAL_CONIFEROUS_FOREST = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "autumnal_coniferous_forest"));
		public static final ResourceKey<Biome> BOREAL_FOREST = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "boreal_forest"));
		public static final ResourceKey<Biome> SNOWY_BOREAL_FOREST = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "snowy_boreal_forest"));
		public static final ResourceKey<Biome> DESERT_SHRUBLAND = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "desert_shrubland"));
		public static final ResourceKey<Biome> OVERGROWN_SPIRES = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "overgrown_spires"));
		public static final ResourceKey<Biome> REDWOODS = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "redwoods"));
		public static final ResourceKey<Biome> SNOWY_REDWOODS = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "snowy_redwoods"));
		public static final ResourceKey<Biome> ASPEN_GROVE = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "aspen_grove"));
//		public static final ResourceKey<Biome> MANGROVE_MARSH = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "mangrove_marsh"));
//		public static final ResourceKey<Biome> WILLOW_WETLANDS = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "willow_wetlands"));
		public static final ResourceKey<Biome> BAOBAB_FIELDS = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "baobab_fields"));
		public static final ResourceKey<Biome> PRAIRIE = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "prairie"));
		public static final ResourceKey<Biome> BLOSSOMING_FIELDS = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "blossoming_fields"));
//		public static final ResourceKey<Biome> RED_ROCK_VALLEY = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "red_rock_valley"));
		public static final ResourceKey<Biome> CRYSTAL_LAKES = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "crystal_lakes"));
//		public static final ResourceKey<Biome> WINDSWEPT_CLIFFS = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "windswept_cliffs"));
		
	}

	static {
		applyBiomeData();
	}
	
	public static RegistryObject<Biome> register(Biome biome, String name) {
		return BIOMES.register(name, () -> biome);
	}
	
	public static void applyBiomeData() {
		BiomeDictionary.addTypes(Keys.VERDANT_SANDS, Type.SAVANNA, Type.SANDY, Type.LUSH, Type.HOT, Type.DENSE, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.PINE_MEADOWS, Type.PLAINS, Type.CONIFEROUS, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.AUTUMNAL_CONIFEROUS_FOREST, Type.FOREST, Type.COLD, Type.CONIFEROUS, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.BOREAL_FOREST, Type.FOREST, Type.COLD, Type.CONIFEROUS, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.SNOWY_BOREAL_FOREST, Type.FOREST, Type.COLD, Type.CONIFEROUS, Type.SNOWY, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.DESERT_SHRUBLAND, Type.DRY, Type.HOT, Type.SANDY, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.OVERGROWN_SPIRES, Type.JUNGLE, Type.WET, Type.LUSH, Type.HOT, Type.DENSE, Type.MOUNTAIN, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.PRAIRIE, Type.PLAINS, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.REDWOODS, Type.FOREST, Type.COLD, Type.CONIFEROUS, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.SNOWY_BOREAL_FOREST, Type.SNOWY, Type.FOREST, Type.COLD, Type.CONIFEROUS, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.BAOBAB_FIELDS, Type.SAVANNA, Type.HOT, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.CRYSTAL_LAKES, Type.FOREST, Type.WET, Type.COLD, Type.CONIFEROUS, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.BLOSSOMING_FIELDS, Type.PLAINS, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.ASPEN_GROVE, Type.FOREST, Type.COLD, Type.OVERWORLD);
	}
}
