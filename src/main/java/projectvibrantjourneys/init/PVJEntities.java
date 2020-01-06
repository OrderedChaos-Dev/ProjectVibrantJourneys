package projectvibrantjourneys.init;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntitySpawnPlacementRegistry.PlacementType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
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
import projectvibrantjourneys.client.renderers.GhostRenderer;
import projectvibrantjourneys.client.renderers.SkeletalKnightRenderer;
import projectvibrantjourneys.common.entities.GhostEntity;
import projectvibrantjourneys.common.entities.SkeletalKnightEntity;
import projectvibrantjourneys.core.PVJConfig;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@Mod.EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJEntities {
	public static EntityType<SkeletalKnightEntity> skeletal_knight;
	public static EntityType<GhostEntity> ghost;

	@SubscribeEvent
	public static void initEntities(RegistryEvent.Register<EntityType<?>> event) {		
		registerEntity(skeletal_knight);
		registerEntity(ghost);
		
		addSpawnPlacements();
		registerEntityRenderers();
	}
	
	public static void preInitEntityTypes() {
		skeletal_knight = setupEntity("skeletal_knight", skeletal_knight, SkeletalKnightEntity::new, 64, 0.6F, 1.99F);
		ghost = setupEntity("ghost", ghost, GhostEntity::new, 64, 0.6F, 1.95F);
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
	
	public static <T extends Entity> EntityType<T> registerEntity(String name, EntityType<T> entityType, EntityType.IFactory<T> entityTypeFactory,
			int range, float width, float height) {
		entityType = EntityType.Builder.create(entityTypeFactory, EntityClassification.MONSTER)
				.setTrackingRange(range)
				.size(width, height)
				.build(name);
		entityType.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
		
		ForgeRegistries.ENTITIES.register(entityType);
		
		return entityType;
	}
	
	private static void addSpawnPlacements() {
		EntitySpawnPlacementRegistry.register(skeletal_knight, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::func_223325_c);
	}
	
	public static void addSpawns() {
		for(Biome biome : ForgeRegistries.BIOMES.getValues()) {
			addSpawn(biome, skeletal_knight, EntityClassification.MONSTER, 50, 1, 2, PVJConfig.skeletalKnightBiomes.get());
			addSpawn(biome, ghost, EntityClassification.MONSTER, 70, 1, 1, PVJConfig.ghostBiomes.get());
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
		RenderingRegistry.registerEntityRenderingHandler(ghost, GhostRenderer::new);
	}
}
