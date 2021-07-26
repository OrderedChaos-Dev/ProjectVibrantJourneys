package projectvibrantjourneys.init.world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.biome.VanillaBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
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
import projectvibrantjourneys.common.biomes.CrystalLakesBiome;
import projectvibrantjourneys.common.biomes.DesertShrublandBiome;
import projectvibrantjourneys.common.biomes.GravelShoreBiome;
import projectvibrantjourneys.common.biomes.MangroveMarshBiome;
import projectvibrantjourneys.common.biomes.OvergrownSpiresBiome;
import projectvibrantjourneys.common.biomes.PineMeadowsBiome;
import projectvibrantjourneys.common.biomes.PrairieBiome;
import projectvibrantjourneys.common.biomes.RedRockValleyBiome;
import projectvibrantjourneys.common.biomes.RedwoodsBiome;
import projectvibrantjourneys.common.biomes.VerdantSandsBiome;
import projectvibrantjourneys.common.biomes.WillowWetlandsBiome;
import projectvibrantjourneys.common.biomes.WindsweptCliffsBiome;
import projectvibrantjourneys.core.PVJConfig;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJBiomes {
	
	public static final List<Biome> BIOMES = new ArrayList<Biome>();
	public static final Map<ResourceKey<Biome>, ResourceKey<Biome>> SHORE_MAP = new HashMap<ResourceKey<Biome>, ResourceKey<Biome>>();
	public static final Map<ResourceKey<Biome>, ResourceKey<Biome>> HILLS_MAP = new HashMap<ResourceKey<Biome>, ResourceKey<Biome>>();
	public static final Map<ResourceKey<Biome>, ResourceKey<Biome>> RIVER_MAP = new HashMap<ResourceKey<Biome>, ResourceKey<Biome>>();
	
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
	public static Biome aspen_grove = register(AspenGroveBiome.makeAspenGroveBiome(0.2F, 0.2F), "aspen_grove");
	public static Biome aspen_grove_hills = register(AspenGroveBiome.makeAspenGroveBiome(0.45F, 0.25F), "aspen_grove_hills");
	public static Biome mangrove_marsh = register(MangroveMarshBiome.makeMangroveMarshBiome(), "mangrove_marsh");
	public static Biome willow_wetlands = register(WillowWetlandsBiome.makeWillowWetlandsBiome(), "willow_wetlands");
	public static Biome baobab_fields = register(BaobabFieldsBiome.makeBaobabFieldsBiome(), "baobab_fields");
	public static Biome prairie = register(PrairieBiome.makePrairieBiome(), "prairie");
	public static Biome blossoming_fields = register(BlossomingFieldsBiome.makeBlossomingFieldsBiome(), "blossoming_fields");
	public static Biome autumnal_coniferous_forest = register(AutumnalConiferousForestBiome.makeAutumnalConiferousForestBiome(), "autumnal_coniferous_forest");
	public static Biome gravel_shore = register(GravelShoreBiome.makeGravelShoreBiome(), "gravel_shore");
	public static Biome crimson_thicket = register(CrimsonThicketBiome.makeCrimsonThicketBiome(), "crimson_thicket");
	public static Biome desert_shrubland = register(DesertShrublandBiome.makeDesertShrublandBiome(0.2F), "desert_shrubland");
	public static Biome red_rock_valley = register(RedRockValleyBiome.makeRedRockValleyBiome(), "red_rock_valley");
	public static Biome tropical_beach = register(VanillaBiomes.beachBiome(0.0F, 0.025F, 1.4F, 0.8F, 4159204, false, false), "tropical_beach");
	public static Biome crystal_lakes = register(CrystalLakesBiome.makeCrystalLakesBiome(), "crystal_lakes");
	public static Biome windswept_cliffs = register(WindsweptCliffsBiome.makeWindsweptCliffsBiome(), "windswept_cliffs");
	
	public static class Keys {
		public static final ResourceKey<Biome> OVERGROWN_SPIRES = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "overgrown_spires"));
		public static final ResourceKey<Biome> VERDANT_SANDS = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "verdant_sands"));
		public static final ResourceKey<Biome> REDWOODS = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "redwoods"));
		public static final ResourceKey<Biome> REDWOOD_PEAKS = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "redwood_peaks"));
		public static final ResourceKey<Biome> SNOWY_REDWOODS = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "snowy_redwoods"));
		public static final ResourceKey<Biome> BOREAL_FOREST = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "boreal_forest"));
		public static final ResourceKey<Biome> SNOWY_BOREAL_FOREST = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "snowy_boreal_forest"));
		public static final ResourceKey<Biome> ALPINE_HEIGHTS = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "alpine_heights"));
		public static final ResourceKey<Biome> PINE_MEADOWS = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "pine_meadows"));
		public static final ResourceKey<Biome> BOREAL_PLATEAU = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "boreal_plateau"));
		public static final ResourceKey<Biome> WILLOW_WETLANDS = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "willow_wetlands"));
		public static final ResourceKey<Biome> MANGROVE_MARSH = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "mangrove_marsh"));
		public static final ResourceKey<Biome> BAOBAB_FIELDS = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "baobab_fields"));
		public static final ResourceKey<Biome> ASPEN_GROVE = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "aspen_grove"));
		public static final ResourceKey<Biome> ASPEN_GROVE_HILLS = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "aspen_grove_hills"));
		public static final ResourceKey<Biome> PRAIRIE = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "prairie"));
		public static final ResourceKey<Biome> BLOSSOMING_FIELDS = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "blossoming_fields"));
		public static final ResourceKey<Biome> AUTUMNAL_CONIFEROUS_FOREST = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "autumnal_coniferous_forest"));
		public static final ResourceKey<Biome> GRAVEL_SHORE = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "gravel_shore"));
		public static final ResourceKey<Biome> CRIMSON_THICKET = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "crimson_thicket"));
		public static final ResourceKey<Biome> DESERT_SHRUBLAND = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "desert_shrubland"));
		public static final ResourceKey<Biome> RED_ROCK_VALLEY_BIOME = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "red_rock_valley"));
		public static final ResourceKey<Biome> TROPICAL_BEACH = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "tropical_beach"));
		public static final ResourceKey<Biome> CRYSTAL_LAKES = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "crystal_lakes"));
		public static final ResourceKey<Biome> WINDSWEPT_CLIFFS = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "windswept_cliffs"));
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
		if(PVJConfig.overgrown_spires.get())
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Keys.OVERGROWN_SPIRES, PVJConfig.overgrown_spires_weight.get()));
		if(PVJConfig.verdant_sands.get())
			BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(Keys.VERDANT_SANDS, PVJConfig.verdant_sands_weight.get()));
		if(PVJConfig.redwoods.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.REDWOODS, PVJConfig.redwoods_weight.get()));
		if(PVJConfig.redwood_peaks.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.REDWOOD_PEAKS, PVJConfig.redwood_peaks_weight.get()));
		if(PVJConfig.snowy_redwoods.get())
			BiomeManager.addBiome(BiomeType.ICY, new BiomeEntry(Keys.SNOWY_REDWOODS, PVJConfig.snowy_redwoods_weight.get()));
		if(PVJConfig.boreal_forest.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.BOREAL_FOREST, PVJConfig.boreal_forest_weight.get()));
		if(PVJConfig.snowy_boreal_forest.get())
			BiomeManager.addBiome(BiomeType.ICY, new BiomeEntry(Keys.SNOWY_BOREAL_FOREST, PVJConfig.snowy_boreal_forest_weight.get()));
		if(PVJConfig.alpine_heights.get())
			BiomeManager.addBiome(BiomeType.ICY, new BiomeEntry(Keys.ALPINE_HEIGHTS, PVJConfig.alpine_heights_weight.get()));
		if(PVJConfig.pine_meadows.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.PINE_MEADOWS, PVJConfig.pine_meadows_weight.get()));
		if(PVJConfig.boreal_plateau.get())
			BiomeManager.addBiome(BiomeType.ICY, new BiomeEntry(Keys.BOREAL_PLATEAU, PVJConfig.boreal_plateau_weight.get()));
		if(PVJConfig.aspen_grove.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.ASPEN_GROVE, PVJConfig.aspen_grove_weight.get()));
		if(PVJConfig.mangrove_marsh.get())
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Keys.MANGROVE_MARSH, PVJConfig.mangrove_marsh_weight.get()));
		if(PVJConfig.willow_wetlands.get())
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Keys.WILLOW_WETLANDS, PVJConfig.willow_wetlands_weight.get()));
		if(PVJConfig.baobab_fields.get())
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Keys.BAOBAB_FIELDS, PVJConfig.baobab_fields_weight.get()));
		if(PVJConfig.prairie.get())
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Keys.PRAIRIE, PVJConfig.prairie_weight.get()));
		if(PVJConfig.blossoming_fields.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.BLOSSOMING_FIELDS, PVJConfig.blossoming_fields_weight.get()));
		if(PVJConfig.autumnal_coniferous_forest.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.AUTUMNAL_CONIFEROUS_FOREST, PVJConfig.autumnal_coniferous_forest_weight.get()));
		if(PVJConfig.crimson_thicket.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.CRIMSON_THICKET, PVJConfig.crimson_thicket_weight.get()));
		if(PVJConfig.desert_shrubland.get())
			BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(Keys.DESERT_SHRUBLAND, PVJConfig.desert_shrubland_weight.get()));
		if(PVJConfig.red_rock_valley.get())
			BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(Keys.RED_ROCK_VALLEY_BIOME, PVJConfig.red_rock_valley_weight.get()));
		if(PVJConfig.crystal_lakes.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.CRYSTAL_LAKES, PVJConfig.crystal_lakes_weight.get()));
		if(PVJConfig.windswept_cliffs.get())
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.WINDSWEPT_CLIFFS, PVJConfig.windswept_cliffs_weight.get()));
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
		BiomeDictionary.addTypes(Keys.DESERT_SHRUBLAND, Type.HOT, Type.SANDY, Type.DRY, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.RED_ROCK_VALLEY_BIOME, Type.LUSH, Type.HOT, Type.SANDY, Type.DRY, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.TROPICAL_BEACH, Type.BEACH, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.CRYSTAL_LAKES, Type.FOREST, Type.CONIFEROUS, Type.COLD, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.WINDSWEPT_CLIFFS, Type.MOUNTAIN, Type.COLD, Type.OVERWORLD);
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
		mapShoreBiome(Keys.RED_ROCK_VALLEY_BIOME, Biomes.BADLANDS);
		mapShoreBiome(Keys.OVERGROWN_SPIRES, Keys.TROPICAL_BEACH);
		mapShoreBiome(Keys.WINDSWEPT_CLIFFS, Biomes.STONE_SHORE);
		
		//HILLS
		mapHillsBiome(Keys.ASPEN_GROVE, Keys.ASPEN_GROVE_HILLS);
//		mapHillsBiome(Keys.CRYSTAL_LAKES, Keys.BOREAL_PLATEAU);
	}
	
	public static void mapShoreBiome(ResourceKey<Biome> biome, ResourceKey<Biome> shore) {
		SHORE_MAP.put(biome, shore);
	}
	
	public static void mapHillsBiome(ResourceKey<Biome> biome, ResourceKey<Biome> hills) {
		HILLS_MAP.put(biome, hills);
	}
}
