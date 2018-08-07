package vibrantjourneys.init;

import java.util.ArrayList;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import vibrantjourneys.PVJConfig;
import vibrantjourneys.biomes.BiomePrairie;
import vibrantjourneys.biomes.BiomeRedwoods;
import vibrantjourneys.util.BiomeReference;

public class PVJBiomes 
{
	public static final ArrayList<Biome> BIOMES = new ArrayList<Biome>();
	public static Biome prairie = new BiomePrairie();
	public static Biome redwoods = new BiomeRedwoods();
	
	public static void initBiomes()
	{
		registerBiome(prairie, "prairie", PVJConfig.biomes.prarieWeight, true, BiomeType.WARM, Type.PLAINS);
		registerBiome(redwoods, "redwoods", PVJConfig.biomes.redwoodsWeight, false, BiomeType.COOL, Type.CONIFEROUS, Type.FOREST);
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
		
		BiomeReference.ALL_BIOMES.add(biome);
		BiomeReference.FRESHWATER_BIOMES.add(biome);
	}
}
