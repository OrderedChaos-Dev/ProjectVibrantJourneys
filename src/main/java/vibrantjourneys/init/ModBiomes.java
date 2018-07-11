package vibrantjourneys.init;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import vibrantjourneys.biomes.BiomePrairie;

public class ModBiomes 
{
	public static Biome prairie = new BiomePrairie();
	public static void initBiomes()
	{
		registerBiome(prairie, "prairie", true, BiomeType.WARM, Type.PLAINS);
	}
	
	public static void registerBiome(Biome biome, String name, boolean hasVillages, BiomeType biomeType, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
		BiomeManager.addSpawnBiome(biome);
		if(hasVillages)
			BiomeManager.addVillageBiome(prairie, true);
		System.out.println("registered biome");
	}
}
