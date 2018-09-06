package vibrantjourneys.init;

import java.util.ArrayList;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import vibrantjourneys.biomes.BiomeAspenGrove;
import vibrantjourneys.biomes.BiomeBorealForest;
import vibrantjourneys.biomes.BiomePrairie;
import vibrantjourneys.biomes.BiomeRedwoods;
import vibrantjourneys.biomes.BiomeWillowSwamp;
import vibrantjourneys.util.PVJConfig;

public class PVJBiomes 
{
	public static final ArrayList<Biome> BIOMES = new ArrayList<Biome>();
	public static Biome prairie = new BiomePrairie(new BiomeProperties("Prairie").setBaseHeight(0.02F).setHeightVariation(0.005F).setTemperature(0.8F).setRainfall(0.25F));
	public static Biome redwoods = new BiomeRedwoods(new BiomeProperties("Redwoods").setBaseHeight(0.2F).setHeightVariation(0.3F).setTemperature(0.45F).setRainfall(0.6F));
	public static Biome redwood_peaks = new BiomeRedwoods(new BiomeProperties("Redwood Peaks").setBaseHeight(1.4F).setHeightVariation(0.4F).setTemperature(0.45F).setRainfall(0.55F));
	public static Biome willow_swamp = new BiomeWillowSwamp(new BiomeProperties("Willow Swamp").setBaseHeight(-0.2F).setHeightVariation(0.05F).setTemperature(0.8F).setRainfall(0.9F).setWaterColor(14745518));
	public static Biome boreal_forest = new BiomeBorealForest(new BiomeProperties("Boreal Forest").setBaseHeight(0.2F).setHeightVariation(0.1F).setTemperature(0.25F).setRainfall(0.8F));
	public static Biome snowy_boreal_forest = new BiomeBorealForest(new BiomeProperties("Snowy Boreal Forest").setBaseHeight(0.2F).setHeightVariation(0.1F).setTemperature(-0.5F).setRainfall(0.4F).setSnowEnabled());
	public static Biome aspen_grove = new BiomeAspenGrove(new BiomeProperties("Aspen Grove").setTemperature(0.7F).setRainfall(0.8F));
	
	public static void initBiomes()
	{
		if(!PVJConfig.master.disableBiomes)
		{
			registerBiome(prairie, "prairie", PVJConfig.biomes.prairieWeight, true, BiomeType.WARM, Type.PLAINS);
			registerBiome(redwoods, "redwoods", PVJConfig.biomes.redwoodsWeight, false, BiomeType.COOL, Type.CONIFEROUS, Type.FOREST);
			registerBiome(redwood_peaks, "redwood_peaks", PVJConfig.biomes.redwoodsWeight, false, BiomeType.COOL, Type.CONIFEROUS, Type.FOREST, Type.MOUNTAIN);
			registerBiome(willow_swamp, "willow_swamp", PVJConfig.biomes.willowSwampWeight, false, BiomeType.WARM, Type.SWAMP, Type.WET, Type.LUSH);
			registerBiome(boreal_forest, "boreal_forest", PVJConfig.biomes.borealForestWeight, false, BiomeType.COOL, Type.CONIFEROUS, Type.COLD, Type.FOREST);
			registerBiome(snowy_boreal_forest, "snowy_boreal_forest", PVJConfig.biomes.snowyBorealForestWeight, false, BiomeType.ICY, Type.CONIFEROUS, Type.COLD, Type.FOREST, Type.SNOWY);
			registerBiome(aspen_grove, "aspen_grove", PVJConfig.biomes.aspenGroveWeight, false, BiomeType.COOL, Type.FOREST);
		}
	}
	
	public static void registerBiome(Biome biome, String name, int weight, boolean hasVillages, BiomeType biomeType, Type... types)
	{
		biome.setRegistryName(name);

		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, weight));
		BiomeManager.addSpawnBiome(biome);
		if(hasVillages)
			BiomeManager.addVillageBiome(biome, true);
	}
}
