package projectvibrantjourneys.init;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biomes;
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
import projectvibrantjourneys.init.world.PVJBiomes;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID)
public class PVJEntitySpawnEvents {
	
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void setSpawns(BiomeLoadingEvent event) {
		RegistryKey<Biome> biome = RegistryKey.create(ForgeRegistries.Keys.BIOMES, event.getName());
		Set<BiomeDictionary.Type> biomeTypes = BiomeDictionary.getTypes(biome);
		List<Spawners> spawners = event.getSpawns().getSpawner(PVJEntities.PVJ_AMBIENT);
		List<Spawners> water_spawners = event.getSpawns().getSpawner(PVJEntities.PVJ_WATER_AMBIENT);
		List<Spawners> night_spawners = event.getSpawns().getSpawner(PVJEntities.PVJ_NIGHT_AMBIENT);
		
		if(biomeTypes.contains(Type.OVERWORLD)) {
			if(doesNotHave(biomeTypes, Type.SNOWY, Type.WASTELAND, Type.MUSHROOM) && event.getCategory() != Category.DESERT) {
				if(PVJConfig.enableFlies.get())
					spawners.add(new MobSpawnInfo.Spawners(PVJEntities.FLY, PVJConfig.flySpawnWeight.get(), 1, 3));
				if(PVJConfig.enableFireflies.get())
					night_spawners.add(new MobSpawnInfo.Spawners(PVJEntities.FIREFLY, PVJConfig.fireflySpawnWeight.get(), 1, 5));
				if(PVJConfig.nightBats.get())
					night_spawners.add(new MobSpawnInfo.Spawners(PVJEntities.NIGHT_BAT, 10, 1, 3));
				if(PVJConfig.enableSnails.get())
					spawners.add(new MobSpawnInfo.Spawners(PVJEntities.SNAIL, PVJConfig.snailSpawnWeight.get(), 1, 3));
				if(PVJConfig.enableSlugs.get())
					spawners.add(new MobSpawnInfo.Spawners(PVJEntities.SLUG, PVJConfig.slugSpawnWeight.get(), 1, 3));
				if(PVJConfig.enableSmallSpiders.get())
					spawners.add(new MobSpawnInfo.Spawners(PVJEntities.SMALL_SPIDER, PVJConfig.smallSpiderSpawnWeight.get(), 1, 1));
			}
			
			if(biomeTypes.contains(Type.BEACH) && !biomeTypes.contains(Type.MUSHROOM)) {
				if(PVJConfig.enableStarfish.get())
					spawners.add(new MobSpawnInfo.Spawners(PVJEntities.STARFISH, PVJConfig.starfishSpawnWeight.get(), 1, 3));
			}
			if(biomeTypes.contains(Type.OCEAN)) {
				if(PVJConfig.enableStarfish.get())
					water_spawners.add(new MobSpawnInfo.Spawners(PVJEntities.OCEAN_STARFISH, 15, 1, 4));
			}
			
			if(!biomeTypes.contains(Type.WASTELAND) && event.getCategory() != Category.DESERT) {
				if(PVJConfig.enableClams.get())
					water_spawners.add(new MobSpawnInfo.Spawners(PVJEntities.CLAM, PVJConfig.clamSpawnWeight.get(), 1, 3));
			}
			
			if(biome == Biomes.RIVER || hasType(biomeTypes, Type.JUNGLE, Type.SWAMP)) {
				if(PVJConfig.enableFrogs.get())
					spawners.add(new MobSpawnInfo.Spawners(PVJEntities.FROG, PVJConfig.frogSpawnWeight.get(), 1, 2));
			}
			
			if((event.getCategory() == Biome.Category.JUNGLE || hasType(biomeTypes, Type.JUNGLE)) && PVJConfig.jungleTropicalFish.get()) {
				event.getSpawns().getSpawner(EntityClassification.WATER_AMBIENT).add(new MobSpawnInfo.Spawners(EntityType.TROPICAL_FISH, 20, 1, 8));
			}
			
			//MOD BIOMES
			if(biome == PVJBiomes.Keys.VERDANT_SANDS) {
				event.getSpawns().getSpawner(EntityClassification.WATER_AMBIENT).add(new MobSpawnInfo.Spawners(EntityType.TROPICAL_FISH, 20, 1, 8));
			} else if(biome == PVJBiomes.Keys.CRYSTAL_LAKES) {
				event.getSpawns().getSpawner(EntityClassification.WATER_AMBIENT).add(new MobSpawnInfo.Spawners(EntityType.SALMON, 15, 1, 5));
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
	
	public static boolean canBatSpawn(EntityType<BatEntity> entity, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
		if (pos.getY() < world.getSeaLevel()) {
			return false;
		} else if(world.getMaxLocalRawBrightness(pos) > 9) {
			return false;
		} else {
			return CreatureEntity.checkMobSpawnRules(entity, world, reason, pos, rand);
		}
	}
}
