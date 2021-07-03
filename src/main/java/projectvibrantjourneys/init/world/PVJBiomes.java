package projectvibrantjourneys.init.world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import projectvibrantjourneys.common.biomes.AlpineHeightsBiome;
import projectvibrantjourneys.common.biomes.AspenGroveBiome;
import projectvibrantjourneys.common.biomes.AutumnalConiferousForestBiome;
import projectvibrantjourneys.common.biomes.BaobabFieldsBiome;
import projectvibrantjourneys.common.biomes.BlossomingFieldsBiome;
import projectvibrantjourneys.common.biomes.BorealForestBiome;
import projectvibrantjourneys.common.biomes.BorealPlateauBiome;
import projectvibrantjourneys.common.biomes.CrimsonThicketBiome;
import projectvibrantjourneys.common.biomes.GravelShoreBiome;
import projectvibrantjourneys.common.biomes.MangroveMarshBiome;
import projectvibrantjourneys.common.biomes.OvergrownSpiresBiome;
import projectvibrantjourneys.common.biomes.PineMeadowsBiome;
import projectvibrantjourneys.common.biomes.PrairieBiome;
import projectvibrantjourneys.common.biomes.RedwoodsBiome;
import projectvibrantjourneys.common.biomes.VerdantSandsBiome;
import projectvibrantjourneys.common.biomes.WillowWetlandsBiome;
import projectvibrantjourneys.core.PVJConfig;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJBiomes {
	
	public static final List<Biome> BIOMES = new ArrayList<Biome>();
	public static final Map<RegistryKey<Biome>, RegistryKey<Biome>> SHORE_MAP = new HashMap<RegistryKey<Biome>, RegistryKey<Biome>>();
	public static final Map<RegistryKey<Biome>, RegistryKey<Biome>> HILLS_MAP = new HashMap<RegistryKey<Biome>, RegistryKey<Biome>>();
	public static final Map<RegistryKey<Biome>, RegistryKey<Biome>> RIVER_MAP = new HashMap<RegistryKey<Biome>, RegistryKey<Biome>>();
	
	public static Biome overgrown_spires = register(OvergrownSpiresBiome.makeShatteredJungleBiome(), "overgrown_spires");
	public static Biome verdant_sands = register(VerdantSandsBiome.makeVerdantSandsBiome(), "verdant_sands");
	public static Biome redwoods = register(RedwoodsBiome.makeRedwoodsBiome(0.19F, 0.31F, 0.45F, 0.6F, false), "redwoods");
	public static Biome redwood_peaks = register(RedwoodsBiome.makeRedwoodsBiome(3F, 1F, 0.4F, 0.55F, false), "redwood_peaks");
	public static Biome snowy_redwoods = register(RedwoodsBiome.makeRedwoodsBiome(0.19F, 0.31F, 0.3F, 0.4F, true), "snowy_redwoods");
	public static Biome boreal_forest = register(BorealForestBiome.makeBorealForestBiome(false), "boreal_forest");
	public static Biome snowy_boreal_forest = register(BorealForestBiome.makeBorealForestBiome(true), "snowy_boreal_forest");
	public static Biome alpine_heights = register(AlpineHeightsBiome.makeAlpineHeightsBiome(5F, 1.1F), "alpine_heights");
	public static Biome pine_meadows = register(PineMeadowsBiome.makePineMeadowsBiome(), "pine_meadows");
	public static Biome boreal_plateau = register(BorealPlateauBiome.makeBorealPlateauBiome(), "boreal_plateau");
	public static Biome aspen_grove = register(AspenGroveBiome.makeBorealPlateauBiome(0.2F, 0.2F), "aspen_grove");
	public static Biome aspen_grove_hills = register(AspenGroveBiome.makeBorealPlateauBiome(0.45F, 0.25F), "aspen_grove_hills");
	public static Biome mangrove_marsh = register(MangroveMarshBiome.makeMangroveMarshBiome(), "mangrove_marsh");
	public static Biome willow_wetlands = register(WillowWetlandsBiome.makeWillowWetlandsBiome(), "willow_wetlands");
	public static Biome baobab_fields = register(BaobabFieldsBiome.makeBaobabFieldsBiome(), "baobab_fields");
	public static Biome prairie = register(PrairieBiome.makePrairieBiome(), "prairie");
	public static Biome blossoming_fields = register(BlossomingFieldsBiome.makeBlossomingFieldsBiome(), "blossoming_fields");
	public static Biome autumnal_coniferous_forest = register(AutumnalConiferousForestBiome.makeAutumnalConiferousForestBiome(), "autumnal_coniferous_forest");
	public static Biome gravel_shore = register(GravelShoreBiome.makeGravelShoreBiome(), "gravel_shore");
	public static Biome crimson_thicket = register(CrimsonThicketBiome.makeCrimsonThicketBiome(), "crimson_thicket");
	
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
		public static final RegistryKey<Biome> BOREAL_PLATEAU = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "boreal_plateau"));
		public static final RegistryKey<Biome> WILLOW_WETLANDS = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "willow_wetlands"));
		public static final RegistryKey<Biome> MANGROVE_MARSH = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "mangrove_marsh"));
		public static final RegistryKey<Biome> BAOBAB_FIELDS = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "baobab_fields"));
		public static final RegistryKey<Biome> ASPEN_GROVE = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "aspen_grove"));
		public static final RegistryKey<Biome> ASPEN_GROVE_HILLS = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "aspen_grove_hills"));
		public static final RegistryKey<Biome> PRAIRIE = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "prairie"));
		public static final RegistryKey<Biome> BLOSSOMING_FIELDS = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "blossoming_fields"));
		public static final RegistryKey<Biome> AUTUMNAL_CONIFEROUS_FOREST = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "autumnal_coniferous_forest"));
		public static final RegistryKey<Biome> GRAVEL_SHORE = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "gravel_shore"));
		public static final RegistryKey<Biome> CRIMSON_THICKET = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "crimson_thicket"));
	}
	
	@SubscribeEvent
	public static void registerBiomes(RegistryEvent.Register<Biome> event) {
		BIOMES.forEach((biome) -> event.getRegistry().register(biome));
		
		addBiomes();
		addTypes();
		mapBiomesForMixins();
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
			BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(Keys.VERDANT_SANDS, 10));
		if(PVJConfig.redwoods.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.REDWOODS, 1));
		if(PVJConfig.redwood_peaks.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.REDWOOD_PEAKS, 1));
		if(PVJConfig.snowy_redwoods.get())
			BiomeManager.addBiome(BiomeType.ICY, new BiomeEntry(Keys.SNOWY_REDWOODS, 1));
		if(PVJConfig.boreal_forest.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.BOREAL_FOREST, 1));
		if(PVJConfig.snowy_boreal_forest.get())
			BiomeManager.addBiome(BiomeType.ICY, new BiomeEntry(Keys.SNOWY_BOREAL_FOREST, 1));
		if(PVJConfig.alpine_heights.get())
			BiomeManager.addBiome(BiomeType.ICY, new BiomeEntry(Keys.ALPINE_HEIGHTS, 1));
		if(PVJConfig.pine_meadows.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.PINE_MEADOWS, 1));
		if(PVJConfig.boreal_plateau.get())
			BiomeManager.addBiome(BiomeType.ICY, new BiomeEntry(Keys.BOREAL_PLATEAU, 1));
		if(PVJConfig.aspen_grove.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.ASPEN_GROVE, 1));
		if(PVJConfig.mangrove_marsh.get())
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Keys.MANGROVE_MARSH, 1));
		if(PVJConfig.willow_wetlands.get())
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Keys.WILLOW_WETLANDS, 1));
		if(PVJConfig.baobab_fields.get())
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Keys.BAOBAB_FIELDS, 1));
		if(PVJConfig.prairie.get())
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Keys.PRAIRIE, 1));
		if(PVJConfig.blossoming_fields.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.BLOSSOMING_FIELDS, 1));
		if(PVJConfig.autumnal_coniferous_forest.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.AUTUMNAL_CONIFEROUS_FOREST, 1));
		if(PVJConfig.crimson_thicket.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.CRIMSON_THICKET, 1));
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
		BiomeDictionary.addTypes(Keys.BOREAL_PLATEAU, Type.FOREST, Type.CONIFEROUS, Type.COLD, Type.SNOWY, Type.MOUNTAIN, Type.PLATEAU, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.ASPEN_GROVE, Type.FOREST, Type.COLD, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.ASPEN_GROVE_HILLS, Type.FOREST, Type.COLD, Type.HILLS, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.MANGROVE_MARSH, Type.SWAMP, Type.WATER, Type.WET, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.WILLOW_WETLANDS, Type.SWAMP, Type.WATER, Type.WET, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.BAOBAB_FIELDS, Type.SAVANNA, Type.DRY, Type.HOT, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.PRAIRIE, Type.PLAINS, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.BLOSSOMING_FIELDS, Type.PLAINS, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.AUTUMNAL_CONIFEROUS_FOREST, Type.FOREST, Type.CONIFEROUS, Type.COLD, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.GRAVEL_SHORE, Type.BEACH, Type.OVERWORLD);
	}
	
	public static void mapBiomesForMixins() {
		//BEACHES
		mapShoreBiome(Keys.ALPINE_HEIGHTS, Biomes.STONE_SHORE);
		mapShoreBiome(Keys.BOREAL_PLATEAU, Biomes.STONE_SHORE);
		mapShoreBiome(Keys.REDWOOD_PEAKS, Keys.GRAVEL_SHORE);
		mapShoreBiome(Keys.SNOWY_BOREAL_FOREST, Biomes.SNOWY_BEACH);
		mapShoreBiome(Keys.SNOWY_REDWOODS, Biomes.SNOWY_BEACH);
		mapShoreBiome(Keys.MANGROVE_MARSH, Keys.MANGROVE_MARSH);
		mapShoreBiome(Keys.WILLOW_WETLANDS, Keys.WILLOW_WETLANDS);
		mapShoreBiome(Keys.AUTUMNAL_CONIFEROUS_FOREST, Keys.GRAVEL_SHORE);
		
		//HILLS
		mapHillsBiome(Keys.ASPEN_GROVE, Keys.ASPEN_GROVE_HILLS);
	}
	
	public static void mapShoreBiome(RegistryKey<Biome> biome, RegistryKey<Biome> shore) {
		SHORE_MAP.put(biome, shore);
	}
	
	public static void mapHillsBiome(RegistryKey<Biome> biome, RegistryKey<Biome> hills) {
		HILLS_MAP.put(biome, hills);
	}
}
