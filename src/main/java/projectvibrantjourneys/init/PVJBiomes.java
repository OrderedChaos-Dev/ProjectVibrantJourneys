package projectvibrantjourneys.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
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
import projectvibrantjourneys.common.biome.OvergrownSpiresBiome;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@Mod.EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJBiomes {

	public static Biome overgrown_spires;
	
	@SubscribeEvent
	public static void initBiomes(RegistryEvent.Register<Biome> event) {
		overgrown_spires = registerBiome(new OvergrownSpiresBiome(), "overgrown_spires", 10);
	}
	
	public static Biome registerBiome(Biome biome, String name, int weight) {
		biome.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
		ForgeRegistries.BIOMES.register(biome);
		BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(biome, weight));
		BiomeManager.addSpawnBiome(biome);
		
		return biome;
	}
	
	public static void initBiomeTypes() {
		addBiomeTypes(overgrown_spires, Type.OVERWORLD, Type.JUNGLE, Type.HOT, Type.DENSE, Type.WET, Type.MOUNTAIN);
	}
	
	public static void addBiomeTypes(Biome biome, BiomeDictionary.Type...types) {
		BiomeDictionary.addTypes(biome, types);
	}
}
