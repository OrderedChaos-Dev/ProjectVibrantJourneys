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
import projectvibrantjourneys.common.biomes.OvergrownSpiresBiome;
import projectvibrantjourneys.common.biomes.VerdantSandsBiome;
import projectvibrantjourneys.core.PVJConfig;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJBiomes {
	
	public static final List<Biome> BIOMES = new ArrayList<Biome>();
	
	public static Biome overgrown_spires = register(OvergrownSpiresBiome.makeShatteredJungleBiome(), "overgrown_spires");
	public static Biome verdant_sands = register(VerdantSandsBiome.makeVerdantSandsBiome(), "verdant_sands");
	
	
	public static class Keys {
		public static final RegistryKey<Biome> OVERGROWN_SPIRES = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "overgrown_spires"));
		public static final RegistryKey<Biome> VERDANT_SANDS = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "verdant_sands"));
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
	}
	
	public static void addTypes() {
		BiomeDictionary.addTypes(Keys.OVERGROWN_SPIRES, Type.HOT, Type.WET, Type.LUSH, Type.DENSE, Type.JUNGLE, Type.MOUNTAIN, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.VERDANT_SANDS, Type.HOT, Type.LUSH, Type.DENSE, Type.SAVANNA, Type.SANDY, Type.OVERWORLD);
	}
}
