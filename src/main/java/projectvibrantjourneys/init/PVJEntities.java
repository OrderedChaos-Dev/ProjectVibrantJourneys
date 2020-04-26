package projectvibrantjourneys.init;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntitySpawnPlacementRegistry.PlacementType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.client.renderers.BansheeRenderer;
import projectvibrantjourneys.client.renderers.ClamRenderer;
import projectvibrantjourneys.client.renderers.FireflyRenderer;
import projectvibrantjourneys.client.renderers.FlyRenderer;
import projectvibrantjourneys.client.renderers.GhostRenderer;
import projectvibrantjourneys.client.renderers.HauntRenderer;
import projectvibrantjourneys.client.renderers.IceCubeRenderer;
import projectvibrantjourneys.client.renderers.MawRenderer;
import projectvibrantjourneys.client.renderers.NightmareRenderer;
import projectvibrantjourneys.client.renderers.PVJBoatRenderer;
import projectvibrantjourneys.client.renderers.PhantasmRenderer;
import projectvibrantjourneys.client.renderers.ScarecrowRenderer;
import projectvibrantjourneys.client.renderers.ShadeRenderer;
import projectvibrantjourneys.client.renderers.SkeletalKnightRenderer;
import projectvibrantjourneys.client.renderers.SlugRenderer;
import projectvibrantjourneys.client.renderers.SnailRenderer;
import projectvibrantjourneys.client.renderers.SpecterRenderer;
import projectvibrantjourneys.client.renderers.StarfishRenderer;
import projectvibrantjourneys.client.renderers.WraithRenderer;
import projectvibrantjourneys.common.entities.WeightedCropList.WeightedCropItem;
import projectvibrantjourneys.common.entities.item.PVJBoatEntity;
import projectvibrantjourneys.common.entities.monster.BansheeEntity;
import projectvibrantjourneys.common.entities.monster.GhostEntity;
import projectvibrantjourneys.common.entities.monster.HauntEntity;
import projectvibrantjourneys.common.entities.monster.IceCubeEntity;
import projectvibrantjourneys.common.entities.monster.MawEntity;
import projectvibrantjourneys.common.entities.monster.NightmareEntity;
import projectvibrantjourneys.common.entities.monster.PhantasmEntity;
import projectvibrantjourneys.common.entities.monster.ShadeEntity;
import projectvibrantjourneys.common.entities.monster.SkeletalKnightEntity;
import projectvibrantjourneys.common.entities.monster.SpecterEntity;
import projectvibrantjourneys.common.entities.monster.WraithEntity;
import projectvibrantjourneys.common.entities.passive.ClamEntity;
import projectvibrantjourneys.common.entities.passive.FireflyEntity;
import projectvibrantjourneys.common.entities.passive.FlyEntity;
import projectvibrantjourneys.common.entities.passive.ScarecrowEntity;
import projectvibrantjourneys.common.entities.passive.SlugEntity;
import projectvibrantjourneys.common.entities.passive.SnailEntity;
import projectvibrantjourneys.common.entities.passive.StarfishEntity;
import projectvibrantjourneys.common.entities.projectile.CropShotEntity;
import projectvibrantjourneys.core.PVJConfig;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@Mod.EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJEntities {
	public static EntityType<FlyEntity> fly;
	public static EntityType<FireflyEntity> firefly;
	public static EntityType<StarfishEntity> starfish;
	public static EntityType<StarfishEntity> starfish_ocean;
	public static EntityType<ClamEntity> clam;
	public static EntityType<SnailEntity> snail;
	public static EntityType<SlugEntity> slug;
	public static EntityType<ScarecrowEntity> scarecrow;
	
	public static EntityType<GhostEntity> ghost;
	
	public static EntityType<SkeletalKnightEntity> skeletal_knight;
	public static EntityType<ShadeEntity> shade;
	public static EntityType<BansheeEntity> banshee;
	public static EntityType<WraithEntity> wraith;
	public static EntityType<SpecterEntity> specter;
	public static EntityType<HauntEntity> haunt;
	public static EntityType<PhantasmEntity> phantasm;
	public static EntityType<NightmareEntity> nightmare;
	public static EntityType<IceCubeEntity> ice_cube;
	public static EntityType<MawEntity> maw;
	
	public static EntityType<CropShotEntity> crop_shot;
	public static EntityType<PVJBoatEntity> pvj_boat;
	
	public static final EntityClassification PVJ_AMBIENT = EntityClassification.create("pvj_ambient", "pvj_ambient", 40, true, false);
	public static final EntityClassification PVJ_WATER_AMBIENT = EntityClassification.create("pvj_water_ambient", "pvj_water_ambient", 15, true, false);
	
	@SubscribeEvent
	public static void initEntities(RegistryEvent.Register<EntityType<?>> event) {
		registerEntity(fly);
		registerEntity(firefly);
		registerEntity(starfish);
		registerEntity(starfish_ocean);
		registerEntity(clam);
		registerEntity(snail);
		registerEntity(slug);
		registerEntity(scarecrow);
		
		registerEntity(ghost);
		
		registerEntity(skeletal_knight);
		registerEntity(shade);
		registerEntity(banshee);
		registerEntity(wraith);
		registerEntity(specter);
		registerEntity(haunt);
		registerEntity(phantasm);
		registerEntity(nightmare);
		registerEntity(ice_cube);
		registerEntity(maw);
		
		registerEntity(crop_shot);
		registerEntity(pvj_boat);
		
		addSpawnPlacements();
		setupScarecrowCrops();
	}
	
	public static void preInitEntityTypes() {
		fly = setupEntity("fly", fly, FlyEntity::new, PVJ_AMBIENT, 64, 0.1F, 0.1F);
		firefly = setupEntity("firefly", firefly, FireflyEntity::new, PVJ_AMBIENT, 64, 0.1F, 0.1F);
		starfish = setupEntity("starfish", starfish, StarfishEntity::new, PVJ_AMBIENT, 64, 0.4F, 0.1F);
		starfish_ocean = setupEntity("starfish_ocean", starfish_ocean, StarfishEntity::new, PVJ_WATER_AMBIENT, 64, 0.4F, 0.1F);
		clam = setupEntity("clam", clam, ClamEntity::new, PVJ_WATER_AMBIENT, 64, 0.45F, 0.2F);
		snail = setupEntity("snail", snail, SnailEntity::new, PVJ_AMBIENT, 64, 0.25F, 0.15F);
		slug = setupEntity("slug", slug, SlugEntity::new, PVJ_AMBIENT, 64, 0.25F, 0.10F);
		scarecrow = setupEntity("scarecrow", scarecrow, ScarecrowEntity::new, EntityClassification.MISC, 64, 1.0F, 2.5F);
		
		ghost = setupEntity("ghost", ghost, GhostEntity::new, EntityClassification.MONSTER, 64, 0.6F, 1.95F);
		
		skeletal_knight = setupEntity("skeletal_knight", skeletal_knight, SkeletalKnightEntity::new, EntityClassification.MONSTER, 64, 0.6F, 1.99F);
		shade = setupEntity("shade", shade, ShadeEntity::new, EntityClassification.MONSTER, 64, 0.6F, 1.95F);
		banshee = setupEntity("banshee", banshee, BansheeEntity::new, EntityClassification.MONSTER, 64, 0.6F, 1.95F);
		wraith = setupEntity("wraith", wraith, WraithEntity::new, EntityClassification.MONSTER, 64, 0.6F, 1.95F);
		specter = setupEntity("specter", specter, SpecterEntity::new, EntityClassification.MONSTER, 64, 0.6F, 1.95F);
		haunt = setupEntity("haunt", haunt, HauntEntity::new, EntityClassification.MONSTER, 64, 0.6F, 1.95F);
		phantasm = setupEntity("phantasm", phantasm, PhantasmEntity::new, EntityClassification.MONSTER, 64, 0.6F, 1.95F);
		nightmare = setupEntity("nightmare", nightmare, NightmareEntity::new, EntityClassification.MONSTER, 64, 0.6F, 1.95F);
		ice_cube = setupEntity("ice_cube", ice_cube, IceCubeEntity::new, EntityClassification.MONSTER, 64, 2.0F, 2.0F);
		maw =  setupEntity("maw", maw, MawEntity::new, EntityClassification.MONSTER, 64, 1F, 4.5F);
		
		crop_shot = setupEntity("crop_shot", crop_shot, CropShotEntity::new, EntityClassification.MISC, 64, 0.25F, 0.25F);
		pvj_boat = setupEntity("pvj_boat", pvj_boat, PVJBoatEntity::new, EntityClassification.MISC, 64, 1.375F, 0.5625F);
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

	
	private static void addSpawnPlacements() {
		EntitySpawnPlacementRegistry.register(fly, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FlyEntity::canSpawn);
		EntitySpawnPlacementRegistry.register(firefly, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FireflyEntity::canSpawnFirefly);
		EntitySpawnPlacementRegistry.register(starfish, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, StarfishEntity::canSpawn);
		EntitySpawnPlacementRegistry.register(starfish_ocean, PlacementType.IN_WATER, Heightmap.Type.OCEAN_FLOOR, StarfishEntity::canSpawnOcean);
		EntitySpawnPlacementRegistry.register(clam, PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ClamEntity::canSpawn);
		EntitySpawnPlacementRegistry.register(snail, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SnailEntity::canSpawn);
		EntitySpawnPlacementRegistry.register(slug, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SlugEntity::canSpawn);
		
		EntitySpawnPlacementRegistry.register(ghost, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
		
		EntitySpawnPlacementRegistry.register(skeletal_knight, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
		EntitySpawnPlacementRegistry.register(shade, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
		EntitySpawnPlacementRegistry.register(banshee, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
		EntitySpawnPlacementRegistry.register(wraith, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
		EntitySpawnPlacementRegistry.register(specter, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
		EntitySpawnPlacementRegistry.register(haunt, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
		EntitySpawnPlacementRegistry.register(phantasm, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
		EntitySpawnPlacementRegistry.register(nightmare, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
		EntitySpawnPlacementRegistry.register(ice_cube, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, IceCubeEntity::canSpawn);
		EntitySpawnPlacementRegistry.register(maw, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MawEntity::canSpawn);
	}
	
	public static void addSpawns() {
		for(Biome biome : ForgeRegistries.BIOMES.getValues()) {
			addSpawn(biome, fly, PVJ_AMBIENT, 15, 1, 3, PVJConfig.flyBiomes.get());
			addSpawn(biome, firefly, PVJ_AMBIENT, 15, 1, 4, PVJConfig.fireflyBiomes.get());
			addSpawn(biome, starfish, PVJ_AMBIENT, 15, 1, 3, PVJConfig.starfishBiomes.get());
			addSpawn(biome, starfish_ocean, PVJ_WATER_AMBIENT, 5, 1, 3, PVJConfig.starfishBiomes.get());
			addSpawn(biome, clam, PVJ_WATER_AMBIENT, 3, 1, 3, PVJConfig.clamBiomes.get());
			addSpawn(biome, snail, PVJ_AMBIENT, 10, 1, 2, PVJConfig.snailBiomes.get());
			addSpawn(biome, slug, PVJ_AMBIENT, 10, 1, 2, PVJConfig.slugBiomes.get());
			
			addSpawn(biome, ghost, EntityClassification.MONSTER, 40, 1, 1, PVJConfig.ghostBiomes.get());
			
			addSpawn(biome, skeletal_knight, EntityClassification.MONSTER, 50, 1, 2, PVJConfig.skeletalKnightBiomes.get());
			addSpawn(biome, shade, EntityClassification.MONSTER, 70, 1, 1, PVJConfig.shadeBiomes.get());
			addSpawn(biome, banshee, EntityClassification.MONSTER, 70, 1, 1, PVJConfig.bansheeBiomes.get());
			addSpawn(biome, wraith, EntityClassification.MONSTER, 70, 1, 1, PVJConfig.wraithBiomes.get());
			addSpawn(biome, haunt, EntityClassification.MONSTER, 70, 1, 1, PVJConfig.hauntBiomes.get());
			addSpawn(biome, specter, EntityClassification.MONSTER, 70, 1, 1, PVJConfig.specterBiomes.get());
			addSpawn(biome, phantasm, EntityClassification.MONSTER, 70, 1, 1, PVJConfig.phantasmBiomes.get());
			addSpawn(biome, nightmare, EntityClassification.MONSTER, 70, 1, 1, PVJConfig.nightmareBiomes.get());
			addSpawn(biome, ice_cube, EntityClassification.MONSTER, 30, 1, 1, PVJConfig.iceCubeBiomes.get());
			addSpawn(biome, maw, EntityClassification.MONSTER, 30, 1, 1, PVJConfig.mawBiomes.get());
			
			addSpawn(biome, EntityType.TROPICAL_FISH, EntityClassification.WATER_CREATURE, 20, 8, 8, PVJConfig.tropicalFishBiomes.get());
		}
		
		if(PVJConfig.skeletalKnightDungeons.get()) {
			DungeonHooks.addDungeonMob(skeletal_knight, 100);
		}
	}
	
	private static <T extends Entity> void addSpawn(Biome biome, EntityType<T> entity, EntityClassification creatureType, int weight, int min, int max, List<String> spawnBiomes) {
		if(weight > 0 && min > 0 && max > 0 && !spawnBiomes.isEmpty()) {
			if(spawnBiomes.contains(biome.getRegistryName().toString())) {
				biome.getSpawns(creatureType).add(new Biome.SpawnListEntry(entity, weight, min, max));
			}
		}
	}
	
	@OnlyIn(Dist.CLIENT)
	public static void registerEntityRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(fly, FlyRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(firefly, FireflyRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(starfish, StarfishRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(starfish_ocean, StarfishRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(clam, ClamRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(snail, SnailRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(slug, SlugRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(scarecrow, ScarecrowRenderer::new);
	
		RenderingRegistry.registerEntityRenderingHandler(ghost, GhostRenderer::new);
	
		RenderingRegistry.registerEntityRenderingHandler(skeletal_knight, SkeletalKnightRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(shade, ShadeRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(banshee, BansheeRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(wraith, WraithRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(specter, SpecterRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(haunt, HauntRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(phantasm, PhantasmRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(nightmare, NightmareRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ice_cube, IceCubeRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(maw, MawRenderer::new);
		
		RenderingRegistry.registerEntityRenderingHandler(crop_shot, renderManager -> new SpriteRenderer<CropShotEntity>(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(pvj_boat, PVJBoatRenderer::new);
	}
	
	public static void setupScarecrowCrops() {
		ScarecrowEntity.crops.addEntry(
				WeightedCropItem.create(Items.WHEAT, 10),
				WeightedCropItem.create(Items.WHEAT_SEEDS, 10),
				WeightedCropItem.create(Items.CARROT, 10),
				WeightedCropItem.create(Items.POTATO, 10),
				WeightedCropItem.create(Items.BEETROOT, 10),
				WeightedCropItem.create(Items.BEETROOT_SEEDS, 10),
				WeightedCropItem.create(Items.SWEET_BERRIES, 10),
				WeightedCropItem.create(Items.PUMPKIN_SEEDS, 10),
				WeightedCropItem.create(Items.APPLE, 10),
				WeightedCropItem.create(Items.PUMPKIN, 5),
				WeightedCropItem.create(Items.MELON, 5),
				WeightedCropItem.create(Items.MELON_SLICE, 10),
				WeightedCropItem.create(Items.SUGAR_CANE, 10),
				WeightedCropItem.create(Items.CACTUS, 5),
				WeightedCropItem.create(Items.POISONOUS_POTATO, 5));
	}
}
