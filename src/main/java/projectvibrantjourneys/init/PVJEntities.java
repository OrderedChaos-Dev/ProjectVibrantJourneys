package projectvibrantjourneys.init;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntitySpawnPlacementRegistry.PlacementType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.client.renderers.SkeletalKnightRenderer;
import projectvibrantjourneys.common.entities.SkeletalKnightEntity;
import projectvibrantjourneys.core.PVJConfig;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@Mod.EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJEntities {
	public static EntityType<SkeletalKnightEntity> skeletal_knight;

	@SubscribeEvent
	public static void initEntities(RegistryEvent.Register<EntityType<?>> event) {
//		skeletal_knight = registerEntityWithEgg("skeletal_knight", skeletal_knight, SkeletalKnightEntity::new, 64, 0.6F, 1.99F, 0xa6a6a6, 0x808080);
		
		registerEntity(skeletal_knight);
		
		addSpawnPlacements();
		registerEntityRenderers();
	}
	
	public static void preInitEntityTypes() {
		skeletal_knight = setupEntity("skeletal_knight", skeletal_knight, SkeletalKnightEntity::new, 64, 0.6F, 1.99F);
	}
	
	public static <T extends Entity> EntityType<T> setupEntity(String name, EntityType<T> entityType, EntityType.IFactory<T> entityTypeFactory,
			int range, float width, float height) {
		entityType = EntityType.Builder.create(entityTypeFactory, EntityClassification.MONSTER)
				.setTrackingRange(range)
				.size(width, height)
				.build(name);
		entityType.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
		
		return entityType;
	}
	
	public static <T extends Entity> void registerEntity(EntityType<T> entityType) {
		ForgeRegistries.ENTITIES.register(entityType);

	}
	
//	public static <T extends Entity> EntityType<T> registerEntityWithEgg(String name, EntityType<T> entityType, EntityType.IFactory<T> entityTypeFactory,
//			int range, float width, float height, int colorPrimary, int colorSecondary) {
//		entityType = registerEntity(name, entityType, entityTypeFactory, range, width, height);
//	
//		Item spawnEgg = new SpawnEggItem(entityType, colorPrimary, colorSecondary, SPAWN_EGG_PROPERTY);
//		PVJItems.registerItem(spawnEgg, name + "_spawn_egg");
//		
//		return entityType;
//	}
//	
//	public static <T extends Entity> EntityType<T> registerEntity(String name, EntityType<T> entityType, EntityType.IFactory<T> entityTypeFactory,
//			int range, float width, float height) {
//		entityType = EntityType.Builder.create(entityTypeFactory, EntityClassification.MONSTER)
//				.setTrackingRange(range)
//				.size(width, height)
//				.build(name);
//		entityType.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
//		
//		ForgeRegistries.ENTITIES.register(entityType);
//		
//		return entityType;
//	}
	
	private static void addSpawnPlacements() {
		EntitySpawnPlacementRegistry.register(skeletal_knight, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::func_223325_c);
	}
	
	public static void addSpawns() {
		for(Biome biome : ForgeRegistries.BIOMES.getValues()) {
			addSpawn(biome, skeletal_knight, EntityClassification.MONSTER, 100, 1, 2, PVJConfig.skeletalKnightBiomes.get());
		}
	}
	
	private static <T extends Entity> void addSpawn(Biome biome, EntityType<T> entity, EntityClassification creatureType, int weight, int min, int max, List<String> spawnBiomes) {
		if(spawnBiomes.contains(biome.getRegistryName().toString())) {
			biome.getSpawns(creatureType).add(new Biome.SpawnListEntry(entity, weight, min, max));
		}
	}
	
	@OnlyIn(Dist.CLIENT)
	public static void registerEntityRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(skeletal_knight, SkeletalKnightRenderer::new);
	}
}
