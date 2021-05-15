package projectvibrantjourneys.init.object;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntitySpawnPlacementRegistry.PlacementType;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.Heightmap.Type;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import projectvibrantjourneys.common.entities.ClamEntity;
import projectvibrantjourneys.common.entities.FireflyEntity;
import projectvibrantjourneys.common.entities.FlyEntity;
import projectvibrantjourneys.common.entities.StarfishEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJEntities {
	
	public static final EntityClassification PVJ_AMBIENT = EntityClassification.create("pvj_ambient", "pvj_ambient", 15, true, false, 128);
	public static final EntityClassification PVJ_WATER_AMBIENT = EntityClassification.create("pvj_water_ambient", "pvj_water_ambient", 15, true, false, 128);
	
	public static final List<EntityType<?>> ENTITIES = new ArrayList<EntityType<?>>();
	public static final EntityType<FlyEntity> FLY = registerEntity(EntityType.Builder.of(FlyEntity::new, PVJ_AMBIENT).sized(0.1F, 0.1F), "fly");
	public static final EntityType<FireflyEntity> FIREFLY = registerEntity(EntityType.Builder.of(FireflyEntity::new, PVJ_AMBIENT).sized(0.1F, 0.1F), "firefly");
	public static final EntityType<StarfishEntity> STARFISH = registerEntity(EntityType.Builder.of(StarfishEntity::new, PVJ_AMBIENT).sized(0.4F, 0.1F), "starfish");
	public static final EntityType<StarfishEntity> OCEAN_STARFISH = registerEntity(EntityType.Builder.of(StarfishEntity::new, PVJ_WATER_AMBIENT).sized(0.4F, 0.1F), "ocean_starfish");
	public static final EntityType<ClamEntity> CLAM = registerEntity(EntityType.Builder.of(ClamEntity::new, PVJ_WATER_AMBIENT).sized(0.45F, 0.25F), "clam");
	
	public static <T extends Entity> EntityType<T> registerEntity(EntityType.Builder<?> builder, String name) {
		EntityType<T> entity = (EntityType<T>) builder.build(name).setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
		ENTITIES.add(entity);

		return entity;
	}
	
	@SubscribeEvent
	public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
		ENTITIES.forEach((e) -> event.getRegistry().register(e));
		registerSpawnPlacements();
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(FLY, FlyEntity.createAttributes().build());
		event.put(FIREFLY, FlyEntity.createAttributes().build());
		event.put(STARFISH, StarfishEntity.createAttributes().build());
		event.put(OCEAN_STARFISH, StarfishEntity.createAttributes().build());
		event.put(CLAM, ClamEntity.createAttributes().build());
	}
	
	public static void registerSpawnPlacements() {
		EntitySpawnPlacementRegistry.register(FLY, PlacementType.ON_GROUND, Type.MOTION_BLOCKING_NO_LEAVES, FlyEntity::canSpawn);
		EntitySpawnPlacementRegistry.register(FIREFLY, PlacementType.ON_GROUND, Type.MOTION_BLOCKING_NO_LEAVES, FireflyEntity::canSpawnFirefly);
		EntitySpawnPlacementRegistry.register(STARFISH, PlacementType.ON_GROUND, Type.MOTION_BLOCKING_NO_LEAVES, StarfishEntity::canSpawn);
		EntitySpawnPlacementRegistry.register(OCEAN_STARFISH, PlacementType.IN_WATER, Type.OCEAN_FLOOR, StarfishEntity::canSpawnOcean);
		EntitySpawnPlacementRegistry.register(CLAM, PlacementType.IN_WATER, Type.OCEAN_FLOOR, ClamEntity::canSpawn);
	}
}
