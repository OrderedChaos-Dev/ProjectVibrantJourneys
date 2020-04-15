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
import projectvibrantjourneys.common.biomes.BorealForestBiome;
import projectvibrantjourneys.common.biomes.OvergrownSpiresBiome;
import projectvibrantjourneys.common.biomes.SnowyBorealForestBiome;
import projectvibrantjourneys.common.biomes.VerdantSandsBiome;
import projectvibrantjourneys.common.biomes.WillowWetlandsBiomes;
import projectvibrantjourneys.common.world.surfacebuilders.VerdantSandsSurfaceBuilder;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@Mod.EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJBiomes {

	public static Biome overgrown_spires;
	public static Biome verdant_sands;
	public static Biome boreal_forest;
	public static Biome snowy_boreal_forest;
	public static Biome prairie;
	public static Biome willow_wetlands;
	
	public static final SurfaceBuilder<SurfaceBuilderConfig> verdant_sands_surface_builder = new VerdantSandsSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	
	@SubscribeEvent
	public static void initBiomes(RegistryEvent.Register<Biome> event) {
		overgrown_spires = registerBiome(new OvergrownSpiresBiome(), BiomeType.WARM, "overgrown_spires", 3);
		verdant_sands = registerBiome(new VerdantSandsBiome(), BiomeType.DESERT, "verdant_sands", 5);
		boreal_forest = registerBiome(new BorealForestBiome(), BiomeType.COOL, "boreal_forest", 7);
		snowy_boreal_forest = registerBiome(new SnowyBorealForestBiome(), BiomeType.ICY, "snowy_boreal_forest", 6);
		willow_wetlands = registerBiome(new WillowWetlandsBiomes(), BiomeType.WARM, "willow_wetlands", 7);
	}

	public static Biome registerBiome(Biome biome, BiomeType type, String name, int weight) {
		biome.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
		ForgeRegistries.BIOMES.register(biome);
		BiomeManager.addBiome(type, new BiomeEntry(biome, weight));
		BiomeManager.addSpawnBiome(biome);
		
		return biome;
	}
	
	public static void initBiomeTypes() {
		addBiomeTypes(overgrown_spires, Type.OVERWORLD, Type.JUNGLE, Type.HOT, Type.DENSE, Type.WET, Type.MOUNTAIN, Type.RARE);
		addBiomeTypes(verdant_sands, Type.OVERWORLD, Type.SANDY, Type.HOT, Type.DRY);
		addBiomeTypes(boreal_forest, Type.OVERWORLD, Type.CONIFEROUS, Type.FOREST, Type.COLD);
		addBiomeTypes(snowy_boreal_forest, Type.OVERWORLD, Type.CONIFEROUS, Type.FOREST, Type.COLD, Type.SNOWY);
		addBiomeTypes(willow_wetlands, Type.OVERWORLD, Type.SWAMP, Type.WET);
	}
	
	public static void addBiomeTypes(Biome biome, BiomeDictionary.Type...types) {
		BiomeDictionary.addTypes(biome, types);
	}
}
