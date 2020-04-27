package projectvibrantjourneys.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.common.biomes.AspenGroveBiome;
import projectvibrantjourneys.common.biomes.BaobabFieldsBiome;
import projectvibrantjourneys.common.biomes.BorealForestBiome;
import projectvibrantjourneys.common.biomes.BorealPlateauBiome;
import projectvibrantjourneys.common.biomes.CrimsonThicketBiome;
import projectvibrantjourneys.common.biomes.OvergrownSpiresBiome;
import projectvibrantjourneys.common.biomes.PrairieBiome;
import projectvibrantjourneys.common.biomes.RedwoodPeaksBiome;
import projectvibrantjourneys.common.biomes.RedwoodsBiome;
import projectvibrantjourneys.common.biomes.SnowyBorealForestBiome;
import projectvibrantjourneys.common.biomes.VerdantSandsBiome;
import projectvibrantjourneys.common.biomes.WillowWetlandsBiomes;
import projectvibrantjourneys.common.world.surfacebuilders.BorealPlateauSurfaceBuilder;
import projectvibrantjourneys.common.world.surfacebuilders.RedwoodsSurfaceBuilder;
import projectvibrantjourneys.common.world.surfacebuilders.VerdantSandsSurfaceBuilder;
import projectvibrantjourneys.core.PVJConfig;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@Mod.EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJBiomes {

	public static Biome overgrown_spires;
	public static Biome verdant_sands;
	public static Biome boreal_forest;
	public static Biome snowy_boreal_forest;
	public static Biome boreal_plateau;
	public static Biome prairie;
	public static Biome willow_wetlands;
	public static Biome redwoods;
	public static Biome redwood_peaks;
	public static Biome baobab_fields;
	public static Biome aspen_grove;
	public static Biome crimson_thicket;
	
	public static final SurfaceBuilder<SurfaceBuilderConfig> VERDANT_SANDS_SB = new VerdantSandsSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> BOREAL_PLATEAU_SB = new BorealPlateauSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> REDWOODS_SB = new RedwoodsSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	
	@SubscribeEvent
	public static void initBiomes(RegistryEvent.Register<Biome> event) {
		overgrown_spires = registerBiome(new OvergrownSpiresBiome(), BiomeType.WARM, "overgrown_spires", PVJConfig.overgrownSpiresWeight.get());
		verdant_sands = registerBiome(new VerdantSandsBiome(), BiomeType.DESERT, "verdant_sands", PVJConfig.verdantSandsWeight.get());
		boreal_forest = registerBiome(new BorealForestBiome(), BiomeType.COOL, "boreal_forest", PVJConfig.borealForestWeight.get());
		snowy_boreal_forest = registerBiome(new SnowyBorealForestBiome(), BiomeType.ICY, "snowy_boreal_forest", PVJConfig.snowyBorealForestWeight.get());
		boreal_plateau = registerBiome(new BorealPlateauBiome(), BiomeType.ICY, "boreal_plateau", PVJConfig.borealPlateauWeight.get());
		willow_wetlands = registerBiome(new WillowWetlandsBiomes(), BiomeType.WARM, "willow_wetlands", PVJConfig.willowWetlandsWeight.get());
		redwoods = registerBiome(new RedwoodsBiome(), BiomeType.COOL, "redwoods", PVJConfig.redwoodsWeight.get());
		redwood_peaks = registerBiome(new RedwoodPeaksBiome(), BiomeType.COOL, "redwood_peaks", PVJConfig.redwoodPeaksWeight.get());
		baobab_fields = registerBiome(new BaobabFieldsBiome(), BiomeType.WARM, "baobab_fields", PVJConfig.baobabFieldsWeight.get());
		aspen_grove = registerBiome(new AspenGroveBiome(), BiomeType.COOL, "aspen_grove", PVJConfig.aspenGroveWeight.get());
		crimson_thicket = registerBiome(new CrimsonThicketBiome(), BiomeType.COOL, "crimson_thicket", PVJConfig.crimsonThicketWeight.get());
		prairie = registerBiome(new PrairieBiome(), BiomeType.WARM, "prairie", PVJConfig.prairieWeight.get());
	}

	public static Biome registerBiome(Biome biome, BiomeType type, String name, int weight) {
		biome.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
		ForgeRegistries.BIOMES.register(biome);
		
		if(weight > 0) {
			BiomeManager.addBiome(type, new BiomeEntry(biome, weight));
			BiomeManager.addSpawnBiome(biome);
		}

		return biome;
	}
	
	public static void initBiomeTypes() {
		addBiomeTypes(overgrown_spires, Type.OVERWORLD, Type.JUNGLE, Type.HOT, Type.DENSE, Type.WET, Type.MOUNTAIN, Type.RARE);
		addBiomeTypes(verdant_sands, Type.OVERWORLD, Type.SANDY, Type.HOT, Type.DRY);
		addBiomeTypes(boreal_forest, Type.OVERWORLD, Type.CONIFEROUS, Type.FOREST, Type.COLD);
		addBiomeTypes(snowy_boreal_forest, Type.OVERWORLD, Type.CONIFEROUS, Type.FOREST, Type.COLD, Type.SNOWY);
		addBiomeTypes(boreal_plateau, Type.OVERWORLD, Type.CONIFEROUS, Type.FOREST, Type.COLD, Type.SNOWY, Type.MOUNTAIN, Type.PLATEAU);
		addBiomeTypes(willow_wetlands, Type.OVERWORLD, Type.SWAMP, Type.WET);
		addBiomeTypes(redwoods, Type.OVERWORLD, Type.CONIFEROUS, Type.FOREST, Type.COLD);
		addBiomeTypes(redwood_peaks, Type.OVERWORLD, Type.CONIFEROUS, Type.FOREST, Type.COLD, Type.MOUNTAIN);
		addBiomeTypes(baobab_fields, Type.OVERWORLD, Type.HOT, Type.SAVANNA, Type.PLAINS, Type.SPARSE);
		addBiomeTypes(aspen_grove, Type.OVERWORLD, Type.COLD, Type.FOREST);
		addBiomeTypes(crimson_thicket, Type.OVERWORLD, Type.COLD, Type.FOREST, Type.CONIFEROUS);
		addBiomeTypes(prairie, Type.OVERWORLD, Type.PLAINS);
	}
	
	public static void addBiomeTypes(Biome biome, BiomeDictionary.Type...types) {
		BiomeDictionary.addTypes(biome, types);
	}
}
