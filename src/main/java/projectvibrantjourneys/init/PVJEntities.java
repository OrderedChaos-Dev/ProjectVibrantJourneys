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
import projectvibrantjourneys.client.renderers.BansheeRenderer;
import projectvibrantjourneys.client.renderers.FireflyRenderer;
import projectvibrantjourneys.client.renderers.FlyRenderer;
import projectvibrantjourneys.client.renderers.GhostRenderer;
import projectvibrantjourneys.client.renderers.HauntRenderer;
import projectvibrantjourneys.client.renderers.NightmareRenderer;
import projectvibrantjourneys.client.renderers.PhantasmRenderer;
import projectvibrantjourneys.client.renderers.ShadeRenderer;
import projectvibrantjourneys.client.renderers.SkeletalKnightRenderer;
import projectvibrantjourneys.client.renderers.SpecterRenderer;
import projectvibrantjourneys.client.renderers.WraithRenderer;
import projectvibrantjourneys.common.entities.BansheeEntity;
import projectvibrantjourneys.common.entities.FireflyEntity;
import projectvibrantjourneys.common.entities.FlyEntity;
import projectvibrantjourneys.common.entities.GhostEntity;
import projectvibrantjourneys.common.entities.HauntEntity;
import projectvibrantjourneys.common.entities.NightmareEntity;
import projectvibrantjourneys.common.entities.PhantasmEntity;
import projectvibrantjourneys.common.entities.ShadeEntity;
import projectvibrantjourneys.common.entities.SkeletalKnightEntity;
import projectvibrantjourneys.common.entities.SpecterEntity;
import projectvibrantjourneys.common.entities.WraithEntity;
import projectvibrantjourneys.core.PVJConfig;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@Mod.EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJEntities {
	public static EntityType<FlyEntity> fly;
	public static EntityType<FireflyEntity> firefly;
	
	public static EntityType<GhostEntity> ghost;
	
	public static EntityType<SkeletalKnightEntity> skeletal_knight;
	public static EntityType<ShadeEntity> shade;
	public static EntityType<BansheeEntity> banshee;
	public static EntityType<WraithEntity> wraith;
	public static EntityType<SpecterEntity> specter;
	public static EntityType<HauntEntity> haunt;
	public static EntityType<PhantasmEntity> phantasm;
	public static EntityType<NightmareEntity> nightmare;
	
	public static final EntityClassification PVJ_AMBIENT = EntityClassification.create("pvj_ambient", "pvj_ambient", 25, true, false);
	
	@SubscribeEvent
	public static void initEntities(RegistryEvent.Register<EntityType<?>> event) {
		registerEntity(fly);
		registerEntity(firefly);
		
		registerEntity(ghost);
		
		registerEntity(skeletal_knight);
		registerEntity(shade);
		registerEntity(banshee);
		registerEntity(wraith);
		registerEntity(specter);
		registerEntity(haunt);
		registerEntity(phantasm);
		registerEntity(nightmare);
		
		addSpawnPlacements();
	}
	
	public static void preInitEntityTypes() {
		fly = setupEntity("fly", fly, FlyEntity::new, PVJ_AMBIENT, 64, 0.1F, 0.1F);
		firefly = setupEntity("firefly", firefly, FireflyEntity::new, PVJ_AMBIENT, 64, 0.1F, 0.1F);
		
		ghost = setupEntity("ghost", ghost, GhostEntity::new, EntityClassification.MONSTER, 64, 0.6F, 1.95F);
		
		skeletal_knight = setupEntity("skeletal_knight", skeletal_knight, SkeletalKnightEntity::new, EntityClassification.MONSTER, 64, 0.6F, 1.99F);
		shade = setupEntity("shade", shade, ShadeEntity::new, EntityClassification.MONSTER, 64, 0.6F, 1.95F);
		banshee = setupEntity("banshee", banshee, BansheeEntity::new, EntityClassification.MONSTER, 64, 0.6F, 1.95F);
		wraith = setupEntity("wraith", wraith, WraithEntity::new, EntityClassification.MONSTER, 64, 0.6F, 1.95F);
		specter = setupEntity("specter", specter, SpecterEntity::new, EntityClassification.MONSTER, 64, 0.6F, 1.95F);
		haunt = setupEntity("haunt", haunt, HauntEntity::new, EntityClassification.MONSTER, 64, 0.6F, 1.95F);
		phantasm = setupEntity("phantasm", phantasm, PhantasmEntity::new, EntityClassification.MONSTER, 64, 0.6F, 1.95F);
		nightmare = setupEntity("nightmare", nightmare, NightmareEntity::new, EntityClassification.MONSTER, 64, 0.6F, 1.95F);
	}
	
	public static <T extends Entity> EntityType<T> setupEntity(String name, EntityType<T> entityType, EntityType.IFactory<T> entityTypeFactory,
			EntityClassification classification, int range, float width, float height) {
		entityType = EntityType.Builder.create(entityTypeFactory, classification)
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
		EntitySpawnPlacementRegistry.register(fly, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FlyEntity::canSpawn);
		EntitySpawnPlacementRegistry.register(firefly, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FireflyEntity::canSpawnFirefly);
		
		EntitySpawnPlacementRegistry.register(ghost, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::func_223325_c);
		
		EntitySpawnPlacementRegistry.register(skeletal_knight, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::func_223325_c);
		EntitySpawnPlacementRegistry.register(shade, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::func_223325_c);
		EntitySpawnPlacementRegistry.register(banshee, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::func_223325_c);
		EntitySpawnPlacementRegistry.register(wraith, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::func_223325_c);
		EntitySpawnPlacementRegistry.register(specter, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::func_223325_c);
		EntitySpawnPlacementRegistry.register(haunt, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::func_223325_c);
		EntitySpawnPlacementRegistry.register(phantasm, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::func_223325_c);
		EntitySpawnPlacementRegistry.register(nightmare, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::func_223325_c);
	}
	
	public static void addSpawns() {
		for(Biome biome : ForgeRegistries.BIOMES.getValues()) {
			addSpawn(biome, fly, PVJ_AMBIENT, 10, 1, 3, PVJConfig.flyBiomes.get());
			addSpawn(biome, firefly, PVJ_AMBIENT, 10, 1, 4, PVJConfig.fireflyBiomes.get());
			
			addSpawn(biome, ghost, EntityClassification.MONSTER, 40, 1, 1, PVJConfig.ghostBiomes.get());
			
			addSpawn(biome, skeletal_knight, EntityClassification.MONSTER, 50, 1, 2, PVJConfig.skeletalKnightBiomes.get());
			addSpawn(biome, shade, EntityClassification.MONSTER, 70, 1, 1, PVJConfig.shadeBiomes.get());
			addSpawn(biome, banshee, EntityClassification.MONSTER, 70, 1, 1, PVJConfig.bansheeBiomes.get());
			addSpawn(biome, wraith, EntityClassification.MONSTER, 70, 1, 1, PVJConfig.wraithBiomes.get());
			addSpawn(biome, haunt, EntityClassification.MONSTER, 70, 1, 1, PVJConfig.hauntBiomes.get());
			addSpawn(biome, specter, EntityClassification.MONSTER, 70, 1, 1, PVJConfig.specterBiomes.get());
			addSpawn(biome, phantasm, EntityClassification.MONSTER, 70, 1, 1, PVJConfig.phantasmBiomes.get());
			addSpawn(biome, nightmare, EntityClassification.MONSTER, 70, 1, 1, PVJConfig.nightmareBiomes.get());
		}
	}
	
	private static <T extends Entity> void addSpawn(Biome biome, EntityType<T> entity, EntityClassification creatureType, int weight, int min, int max, List<String> spawnBiomes) {
		if(spawnBiomes.contains(biome.getRegistryName().toString())) {
			biome.getSpawns(creatureType).add(new Biome.SpawnListEntry(entity, weight, min, max));
		}
	}
	
	@OnlyIn(Dist.CLIENT)
	public static void registerEntityRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(fly, FlyRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(firefly, FireflyRenderer::new);
	
		RenderingRegistry.registerEntityRenderingHandler(ghost, GhostRenderer::new);
	
		RenderingRegistry.registerEntityRenderingHandler(skeletal_knight, SkeletalKnightRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(shade, ShadeRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(banshee, BansheeRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(wraith, WraithRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(specter, SpecterRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(haunt, HauntRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(phantasm, PhantasmRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(nightmare, NightmareRenderer::new);
	}
}
