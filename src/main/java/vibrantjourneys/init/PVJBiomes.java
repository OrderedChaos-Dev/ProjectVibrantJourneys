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
import vibrantjourneys.biomes.BiomePrairie;
import vibrantjourneys.biomes.BiomeRedwoods;
import vibrantjourneys.biomes.BiomeWillowSwamp;
import vibrantjourneys.util.PVJConfig;

public class PVJBiomes 
{
	public static final ArrayList<Biome> BIOMES = new ArrayList<Biome>();
	public static Biome prairie = new BiomePrairie(new BiomeProperties("Prairie").setBaseHeight(0.02F).setHeightVariation(0.005F).setTemperature(0.8F).setRainfall(0.25F));
	public static Biome redwoods = new BiomeRedwoods(new BiomeProperties("Redwoods").setBaseHeight(0.2F).setHeightVariation(0.3F).setTemperature(0.23F).setRainfall(0.7F));
	public static Biome redwood_peaks = new BiomeRedwoods(new BiomeProperties("Redwood Peaks").setBaseHeight(1.2F).setHeightVariation(0.35F).setTemperature(0.21F).setRainfall(0.65F));
	public static Biome willow_swamp = new BiomeWillowSwamp(new BiomeProperties("Willow Swamp").setBaseHeight(-0.2F).setHeightVariation(0.05F).setTemperature(0.8F).setRainfall(0.9F).setWaterColor(14745518));
	
	public static void initBiomes()
	{
		registerBiome(prairie, "prairie", PVJConfig.biomes.prarieWeight, true, BiomeType.WARM, Type.PLAINS);
		registerBiome(redwoods, "redwoods", PVJConfig.biomes.redwoodsWeight, false, BiomeType.COOL, Type.CONIFEROUS, Type.FOREST);
		registerBiome(redwood_peaks, "redwood_peaks", PVJConfig.biomes.redwoodsWeight, false, BiomeType.COOL, Type.CONIFEROUS, Type.FOREST, Type.MOUNTAIN);
		registerBiome(willow_swamp, "willow_swamp", PVJConfig.biomes.willowSwampWeight, false, BiomeType.WARM, Type.SWAMP, Type.WET, Type.LUSH);
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
