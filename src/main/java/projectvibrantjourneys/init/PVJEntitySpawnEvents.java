package projectvibrantjourneys.init;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData;
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
import projectvibrantjourneys.init.world.PVJBiomes;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID)
public class PVJEntitySpawnEvents {
	
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void setSpawns(BiomeLoadingEvent event) {
		ResourceKey<Biome> biome = ResourceKey.create(ForgeRegistries.Keys.BIOMES, event.getName());
		Set<BiomeDictionary.Type> biomeTypes = BiomeDictionary.getTypes(biome);
		List<SpawnerData> SpawnerData = event.getSpawns().getSpawner(PVJEntities.PVJ_AMBIENT);
		List<SpawnerData> water_SpawnerData = event.getSpawns().getSpawner(PVJEntities.PVJ_WATER_AMBIENT);
		List<SpawnerData> night_SpawnerData = event.getSpawns().getSpawner(PVJEntities.PVJ_NIGHT_AMBIENT);
		
		if(biomeTypes.contains(Type.OVERWORLD)) {
			if(doesNotHave(biomeTypes, Type.SNOWY, Type.WASTELAND, Type.MUSHROOM) && event.getCategory() != BiomeCategory.DESERT) {
				if(PVJConfig.enableFlies.get())
					SpawnerData.add(new MobSpawnSettings.SpawnerData(PVJEntities.FLY, 15, 1, 3));
				if(PVJConfig.enableFireflies.get())
					night_SpawnerData.add(new MobSpawnSettings.SpawnerData(PVJEntities.FIREFLY, 50, 1, 5));
				if(PVJConfig.nightBats.get())
					night_SpawnerData.add(new MobSpawnSettings.SpawnerData(PVJEntities.NIGHT_BAT, 10, 1, 3));
				if(PVJConfig.enableSnails.get())
					SpawnerData.add(new MobSpawnSettings.SpawnerData(PVJEntities.SNAIL, 30, 1, 3));
				if(PVJConfig.enableSlugs.get())
					SpawnerData.add(new MobSpawnSettings.SpawnerData(PVJEntities.SLUG, 25, 1, 3));
				if(PVJConfig.enableSmallSpiders.get())
					SpawnerData.add(new MobSpawnSettings.SpawnerData(PVJEntities.SMALL_SPIDER, 5, 1, 1));
			}
			
			if(biomeTypes.contains(Type.BEACH) && !biomeTypes.contains(Type.MUSHROOM)) {
				if(PVJConfig.enableStarfish.get())
					SpawnerData.add(new MobSpawnSettings.SpawnerData(PVJEntities.STARFISH, 30, 1, 3));
			}
			if(biomeTypes.contains(Type.OCEAN)) {
				if(PVJConfig.enableStarfish.get())
					water_SpawnerData.add(new MobSpawnSettings.SpawnerData(PVJEntities.OCEAN_STARFISH, 15, 1, 4));
			}
			
			if(!biomeTypes.contains(Type.WASTELAND) && event.getCategory() != BiomeCategory.DESERT) {
				if(PVJConfig.enableClams.get())
					water_SpawnerData.add(new MobSpawnSettings.SpawnerData(PVJEntities.CLAM, 10, 1, 3));
			}
			
			if(biome == Biomes.RIVER || hasType(biomeTypes, Type.JUNGLE, Type.SWAMP)) {
				if(PVJConfig.enableFrogs.get())
					SpawnerData.add(new MobSpawnSettings.SpawnerData(PVJEntities.FROG, 30, 1, 2));
			}
			
			if((event.getCategory() == Biome.BiomeCategory.JUNGLE || hasType(biomeTypes, Type.JUNGLE)) && PVJConfig.jungleTropicalFish.get()) {
				event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 20, 1, 8));
			}
			
			//MOD BIOMES
			if(biome == PVJBiomes.Keys.VERDANT_SANDS) {
				event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 20, 1, 8));
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
	
	public static boolean canBatSpawn(EntityType<Bat> entity, LevelAccessor world, MobSpawnType reason, BlockPos pos, Random rand) {
		if (pos.getY() < world.getSeaLevel()) {
			return false;
		} else if(world.getMaxLocalRawBrightness(pos) > 9) {
			return false;
		} else {
			return Mob.checkMobSpawnRules(entity, world, reason, pos, rand);
		}
	}
}
