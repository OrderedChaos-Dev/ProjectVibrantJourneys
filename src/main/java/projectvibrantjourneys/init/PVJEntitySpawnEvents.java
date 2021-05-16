package projectvibrantjourneys.init;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MobSpawnInfo.Spawners;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.core.PVJConfig;
import projectvibrantjourneys.core.ProjectVibrantJourneys;
import projectvibrantjourneys.init.object.PVJEntities;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID)
public class PVJEntitySpawnEvents {
	
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void setSpawns(BiomeLoadingEvent event) {
		RegistryKey<Biome> biome = RegistryKey.create(ForgeRegistries.Keys.BIOMES, event.getName());
		Set<BiomeDictionary.Type> biomeTypes = BiomeDictionary.getTypes(biome);
		List<Spawners> spawners = event.getSpawns().getSpawner(PVJEntities.PVJ_AMBIENT);
		List<Spawners> water_spawners = event.getSpawns().getSpawner(PVJEntities.PVJ_WATER_AMBIENT);
		
		if(biomeTypes.contains(Type.OVERWORLD)) {
			if(doesNotHave(biomeTypes, Type.SNOWY, Type.WASTELAND, Type.MUSHROOM) && event.getCategory() != Category.DESERT) {
				if(PVJConfig.enableFlies.get())
					spawners.add(new MobSpawnInfo.Spawners(PVJEntities.FLY, 15, 1, 3));
				if(PVJConfig.enableFireflies.get())
					spawners.add(new MobSpawnInfo.Spawners(PVJEntities.FIREFLY, 50, 1, 4));
				if(PVJConfig.enableSnails.get())
					spawners.add(new MobSpawnInfo.Spawners(PVJEntities.SNAIL, 30, 1, 3));
				if(PVJConfig.enableSlugs.get())
					spawners.add(new MobSpawnInfo.Spawners(PVJEntities.SLUG, 25, 1, 3));
				if(PVJConfig.enableSmallSpiders.get())
					spawners.add(new MobSpawnInfo.Spawners(PVJEntities.SMALL_SPIDER, 5, 1, 1));
			}
			
			if(biomeTypes.contains(Type.BEACH) && !biomeTypes.contains(Type.MUSHROOM)) {
				if(PVJConfig.enableStarfish.get())
					spawners.add(new MobSpawnInfo.Spawners(PVJEntities.STARFISH, 30, 1, 3));
			}
			if(biomeTypes.contains(Type.OCEAN)) {
				if(PVJConfig.enableStarfish.get())
					water_spawners.add(new MobSpawnInfo.Spawners(PVJEntities.OCEAN_STARFISH, 15, 1, 4));
			}
			
			if(!biomeTypes.contains(Type.WASTELAND) && event.getCategory() != Category.DESERT) {
				if(PVJConfig.enableClams.get())
					water_spawners.add(new MobSpawnInfo.Spawners(PVJEntities.CLAM, 10, 1, 3));
			}
		}
	}
	
	private static boolean hasType(Set<BiomeDictionary.Type> list, BiomeDictionary.Type... types) {
		for(BiomeDictionary.Type t : types) {
			if(list.contains(t)) return true;
		}
		return false;
	}
	
	private static boolean doesNotHave(Set<BiomeDictionary.Type> list, BiomeDictionary.Type... types) {
		List<Type> typeList = Arrays.asList(types);
		return list.stream().noneMatch((type) -> typeList.contains(type));
	}
}
