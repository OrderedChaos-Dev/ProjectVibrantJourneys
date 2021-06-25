package projectvibrantjourneys.init.world;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import projectvibrantjourneys.common.biomes.AlpineHeightsBiome;
import projectvibrantjourneys.common.biomes.BorealForestBiome;
import projectvibrantjourneys.common.biomes.OvergrownSpiresBiome;
import projectvibrantjourneys.common.biomes.PineMeadowsBiome;
import projectvibrantjourneys.common.biomes.RedwoodsBiome;
import projectvibrantjourneys.common.biomes.VerdantSandsBiome;
import projectvibrantjourneys.core.PVJConfig;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJBiomes {
	
	public static final List<Biome> BIOMES = new ArrayList<Biome>();
	
	public static Biome overgrown_spires = register(OvergrownSpiresBiome.makeShatteredJungleBiome(), "overgrown_spires");
	public static Biome verdant_sands = register(VerdantSandsBiome.makeVerdantSandsBiome(), "verdant_sands");
	public static Biome redwoods = register(RedwoodsBiome.makeRedwoodsBiome(0.19F, 0.31F, 0.45F, 0.6F, false), "redwoods");
	public static Biome redwood_peaks = register(RedwoodsBiome.makeRedwoodsBiome(3F, 1F, 0.4F, 0.55F, false), "redwood_peaks");
	public static Biome snowy_redwoods = register(RedwoodsBiome.makeRedwoodsBiome(0.19F, 0.31F, 0.3F, 0.4F, true), "snowy_redwoods");
	public static Biome boreal_forest = register(BorealForestBiome.makeBorealForestBiome(false), "boreal_forest");
	public static Biome snowy_boreal_forest = register(BorealForestBiome.makeBorealForestBiome(true), "snowy_boreal_forest");
	public static Biome alpine_heights = register(AlpineHeightsBiome.makeAlpineHeightsBiome(5F, 1.1F), "alpine_heights");
	public static Biome pine_meadows = register(PineMeadowsBiome.makePineMeadowsBiome(), "pine_meadows");
	
	
	public static class Keys {
		public static final RegistryKey<Biome> OVERGROWN_SPIRES = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "overgrown_spires"));
		public static final RegistryKey<Biome> VERDANT_SANDS = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "verdant_sands"));
		public static final RegistryKey<Biome> REDWOODS = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "redwoods"));
		public static final RegistryKey<Biome> REDWOOD_PEAKS = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "redwood_peaks"));
		public static final RegistryKey<Biome> SNOWY_REDWOODS = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "snowy_redwoods"));
		public static final RegistryKey<Biome> BOREAL_FOREST = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "boreal_forest"));
		public static final RegistryKey<Biome> SNOWY_BOREAL_FOREST = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "snowy_boreal_forest"));
		public static final RegistryKey<Biome> ALPINE_HEIGHTS = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "alpine_heights"));
		public static final RegistryKey<Biome> PINE_MEADOWS = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "pine_meadows"));
	}
	
	@SubscribeEvent
	public static void registerBiomes(RegistryEvent.Register<Biome> event) {
		BIOMES.forEach((biome) -> event.getRegistry().register(biome));
		
		addBiomes();
		addTypes();
	}
	
	public static Biome register(Biome biome, String name) {
		biome.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
		BIOMES.add(biome);
		return biome;
	}
	
	public static void addBiomes() {
		if(PVJConfig.overgrownSpires.get())
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Keys.OVERGROWN_SPIRES, 10));
		if(PVJConfig.verdantSands.get())
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Keys.VERDANT_SANDS, 10));
		if(PVJConfig.redwoods.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.REDWOODS, 1));
		if(PVJConfig.redwood_peaks.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.REDWOOD_PEAKS, 1));
		if(PVJConfig.snowy_redwoods.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.SNOWY_REDWOODS, 1));
		if(PVJConfig.boreal_forest.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.BOREAL_FOREST, 1));
		if(PVJConfig.snowy_boreal_forest.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.SNOWY_BOREAL_FOREST, 1));
		if(PVJConfig.alpine_heights.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.ALPINE_HEIGHTS, 1));
		if(PVJConfig.pine_meadows.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.PINE_MEADOWS, 1));
	}
	
	public static void addTypes() {
		BiomeDictionary.addTypes(Keys.OVERGROWN_SPIRES, Type.HOT, Type.WET, Type.LUSH, Type.DENSE, Type.JUNGLE, Type.MOUNTAIN, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.VERDANT_SANDS, Type.HOT, Type.LUSH, Type.DENSE, Type.SAVANNA, Type.SANDY, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.REDWOODS, Type.FOREST, Type.CONIFEROUS, Type.COLD, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.REDWOOD_PEAKS, Type.FOREST, Type.CONIFEROUS, Type.COLD, Type.MOUNTAIN, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.SNOWY_REDWOODS, Type.FOREST, Type.CONIFEROUS, Type.COLD, Type.SNOWY, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.BOREAL_FOREST, Type.FOREST, Type.CONIFEROUS, Type.COLD, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.SNOWY_BOREAL_FOREST, Type.FOREST, Type.CONIFEROUS, Type.COLD, Type.SNOWY, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.ALPINE_HEIGHTS, Type.FOREST, Type.CONIFEROUS, Type.COLD, Type.SNOWY, Type.MOUNTAIN, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.PINE_MEADOWS, Type.CONIFEROUS, Type.PLAINS, Type.OVERWORLD);
	}
}
