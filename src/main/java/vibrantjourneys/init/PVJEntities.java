package vibrantjourneys.init;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import vibrantjourneys.ProjectVibrantJourneys;
import vibrantjourneys.entities.item.EntityCoconut;
import vibrantjourneys.entities.item.EntityPVJBoat;
import vibrantjourneys.entities.monster.EntityBanshee;
import vibrantjourneys.entities.monster.EntityGoon;
import vibrantjourneys.entities.monster.EntityIceCube;
import vibrantjourneys.entities.monster.EntityShade;
import vibrantjourneys.entities.monster.EntitySkeletalKnight;
import vibrantjourneys.entities.neutral.EntityCoyote;
import vibrantjourneys.entities.neutral.EntityGhost;
import vibrantjourneys.entities.neutral.EntityGrizzlyBear;
import vibrantjourneys.entities.neutral.EntityWatcher;
import vibrantjourneys.entities.passive.EntityBeachStarfish;
import vibrantjourneys.entities.passive.EntityClam;
import vibrantjourneys.entities.passive.EntityDuck;
import vibrantjourneys.entities.passive.EntityFirefly;
import vibrantjourneys.entities.passive.EntityFly;
import vibrantjourneys.entities.passive.EntitySmallSpider;
import vibrantjourneys.entities.passive.EntitySnail;
import vibrantjourneys.entities.passive.EntityStarfish;
import vibrantjourneys.util.BiomeReference;
import vibrantjourneys.util.PVJConfig;
import vibrantjourneys.util.Reference;

public class PVJEntities
{
	public static int id = 1;
	public static final ArrayList<EntityEntry> ENTITIES = new ArrayList<EntityEntry>();
	
	public static void initEntities()
	{
		registerEntityWithEgg("pvj_snail", EntitySnail.class, 64, 0x6D453D, 0x677B5C);
		registerEntityWithEgg("pvj_fly", EntityFly.class, 64, 0x669999, 0x737373);
		registerEntityWithEgg("pvj_firefly", EntityFirefly.class, 64, 0x3F453D, 0xE8E03D);
		registerEntityWithEgg("pvj_small_spider", EntitySmallSpider.class, 64, 0x001a00, 0x4d0000);
		registerEntityWithEgg("pvj_starfish", EntityStarfish.class, 64, 0x6D453D, 0x677B5C);
		registerEntityWithEgg("pvj_clam", EntityClam.class, 64, 0x67644c, 0x4a4836);
		registerEntityWithEgg("pvj_duck", EntityDuck.class, 64, 0x41241c, 0x095326);
		
		registerEntityWithEgg("pvj_grizzly_bear", EntityGrizzlyBear.class, 64, 0x7A452B, 0x3C2113);
		registerEntityWithEgg("pvj_coyote", EntityCoyote.class, 64, 0xc2aa8d, 0x957550);
		
		registerEntityWithEgg("pvj_ghost", EntityGhost.class, 64, 0xb3b3b3, 0x404040);
		registerEntityWithEgg("pvj_shade", EntityShade.class, 64, 0x333333, 0x595959);
		registerEntityWithEgg("pvj_banshee", EntityBanshee.class, 64, 0x333333, 0x536D73);
		registerEntityWithEgg("pvj_icecube", EntityIceCube.class, 64, 0x66e0ff, 0xccf5ff);
		registerEntityWithEgg("pvj_skeletal_knight", EntitySkeletalKnight.class, 64, 0xa6a6a6, 0x808080);
		registerEntityWithEgg("pvj_goon", EntityGoon.class, 64, 0xa6a6a6, 0x808080);
		registerEntityWithEgg("pvj_watcher", EntityWatcher.class, 64, 0xb5b3b3, 0x404044);
		
		//needed to spawn starfish on beaches
		registerEntity("pvj_beach_starfish", EntityBeachStarfish.class, 64);
		registerEntity("pvj_boat", EntityPVJBoat.class, 64);
		registerEntity("pvj_coconut", EntityCoconut.class, 64);
	}

	private static <T extends Entity> void registerEntity(String name, Class<T> entityClass, int trackingRange)
	{
		ResourceLocation entityResource = new ResourceLocation(Reference.MOD_ID, name);
		EntityEntry entity = EntityEntryBuilder.create()
			.entity(entityClass)
			.id(entityResource, id++)
			.name(name)
			.tracker(trackingRange, 3, true)
			.build();
		ENTITIES.add(entity);
	}
	
	private static <T extends Entity> void registerEntityWithEgg(String name, Class<T> entityClass, int trackingRange, int eggPrimary, int eggSecondary)
	{
		ResourceLocation entityResource = new ResourceLocation(Reference.MOD_ID, name);
		
		EntityEntry entity = EntityEntryBuilder.create()
			.entity(entityClass)
			.id(entityResource, id++)
			.name(name)
			.tracker(trackingRange, 3, true)
			.egg(eggPrimary, eggSecondary)
			.build();
		ENTITIES.add(entity);
	}
	
	public static void addSpawns()
	{
		if(PVJConfig.master.enablePassiveMobs)
		{
			addSpawn(EntitySnail.class, PVJConfig.entities.snailSpawnWeight, 2, 4, EnumCreatureType.AMBIENT, BiomeReference.getBiomes(BiomeReference.FRESHWATER_BIOMES));
			addSpawn(EntityFly.class, PVJConfig.entities.flySpawnWeight, 3, 4, EnumCreatureType.AMBIENT, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES));
			addSpawn(EntityFly.class, PVJConfig.entities.flySwampSpawnWeight, 4, 5, EnumCreatureType.AMBIENT, BiomeDictionary.getBiomes(Type.SWAMP).toArray(new Biome[0]));
			addSpawn(EntityFirefly.class, PVJConfig.entities.fireflySpawnWeight, 4, 9, EnumCreatureType.AMBIENT, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES));
			addSpawn(EntitySmallSpider.class, PVJConfig.entities.spiderSpawnWeight, 1, 6, EnumCreatureType.AMBIENT, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES));
			addSpawn(EntityStarfish.class, PVJConfig.entities.starfishWeight, 1, 4, EnumCreatureType.AMBIENT, BiomeReference.getBiomes(BiomeReference.MARINE_BIOMES));
			addSpawn(EntityBeachStarfish.class, PVJConfig.entities.starfishWeight, 1, 4, EnumCreatureType.AMBIENT, BiomeReference.getBiomes(BiomeReference.BEACH_BIOMES));
			addSpawn(EntityDuck.class, PVJConfig.entities.duckWeight, 2, 4, EnumCreatureType.CREATURE, BiomeReference.getBiomes(BiomeReference.DUCK_BIOMES));
			addSpawn(EntityClam.class, PVJConfig.entities.clamWeight, 1, 3, EnumCreatureType.WATER_CREATURE, BiomeReference.getBiomes(BiomeReference.FRESHWATER_BIOMES));
			
			EntitySpawnPlacementRegistry.setPlacementType(EntityStarfish.class, SpawnPlacementType.IN_WATER);
			EntitySpawnPlacementRegistry.setPlacementType(EntityClam.class, SpawnPlacementType.IN_WATER);
		}
		else
			ProjectVibrantJourneys.logger.info("Passive mobs disabled");

		if(PVJConfig.master.enableNeutralMobs)
		{
			addSpawn(EntityGhost.class, PVJConfig.entities.ghostSpawnWeight, 1, 4, EnumCreatureType.MONSTER, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES));
			addSpawn(EntityGrizzlyBear.class, PVJConfig.entities.grizzlyBearSpawnWeight, 1, 2, EnumCreatureType.CREATURE, BiomeDictionary.getBiomes(Type.CONIFEROUS).toArray(new Biome[0]));
			addSpawn(EntityWatcher.class, PVJConfig.entities.watcherSpawnWeight, 2, 4, EnumCreatureType.MONSTER, BiomeDictionary.getBiomes(Type.END).toArray(new Biome[0]));
			addSpawn(EntityCoyote.class, PVJConfig.entities.coyoteSpawnWeight, 1, 1, EnumCreatureType.CREATURE, BiomeReference.getBiomes(BiomeReference.COYOTE_BIOMES));
		}
		else
			ProjectVibrantJourneys.logger.info("Neutral mobs disabled");
		
		if(PVJConfig.master.enableAggressiveMobs)
		{
			addSpawn(EntityShade.class, PVJConfig.entities.shadeSpawnWeight, 1, 3, EnumCreatureType.MONSTER, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES));
			addSpawn(EntityBanshee.class, PVJConfig.entities.bansheeSpawnWeight, 1, 3, EnumCreatureType.MONSTER, BiomeReference.getBiomes(BiomeReference.SNOWY_BIOMES));
			addSpawn(EntityShade.class, PVJConfig.entities.shadeRoofedForestSpawnWeight, 1, 3, EnumCreatureType.MONSTER, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
			addSpawn(EntitySkeletalKnight.class, PVJConfig.entities.skeletalKnightWeight, 1, 3, EnumCreatureType.MONSTER, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES));
			addSpawn(EntityIceCube.class, PVJConfig.entities.icecubeSpawnWeight, 2, 3, EnumCreatureType.MONSTER, BiomeReference.getBiomes(BiomeReference.SNOWY_BIOMES));
			addSpawn(EntityGoon.class, PVJConfig.entities.goonSpawnWeight, 1, 1, EnumCreatureType.MONSTER, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES));
		}
		else
			ProjectVibrantJourneys.logger.info("Aggressive mobs disabled");
		
		if(PVJConfig.entities.junglesSpawnCaveSpiders)
		{
			addSpawn(EntityCaveSpider.class, 50, 1, 3, EnumCreatureType.MONSTER, BiomeReference.getBiomes(BiomeReference.JUNGLE_TREES));
		}
		else
			ProjectVibrantJourneys.logger.info("Cave spiders in jungles disabled");
		
		DungeonHooks.addDungeonMob(new ResourceLocation(Reference.MOD_ID, "pvj_shade"), 100);
		DungeonHooks.addDungeonMob(new ResourceLocation(Reference.MOD_ID, "pvj_skeletal_knight"), 100);
	}
	
	public static void addSpawn(Class <? extends EntityLiving > entityClass, int weightedProb,
			int min, int max, EnumCreatureType typeOfCreature, Biome... biomes)
	{
		if(weightedProb > 0)
		{
			double multiplier = 1.0;
			if(typeOfCreature == EnumCreatureType.AMBIENT || typeOfCreature == EnumCreatureType.CREATURE)
				multiplier = PVJConfig.global.animalsDensity / 100.0;
			if(typeOfCreature == EnumCreatureType.MONSTER)
				multiplier = PVJConfig.global.mobsDensity / 100.0;
			
			EntityRegistry.addSpawn(entityClass, (int)(weightedProb * multiplier), min, max, typeOfCreature, biomes);
			/*if(typeOfCreature == EnumCreatureType.WATER_CREATURE)
			{
				EntitySpawnPlacementRegistry.setPlacementType(entityClass, SpawnPlacementType.IN_WATER);
			}*/
		}
	}
}
