package vibrantjourneys.init;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import vibrantjourneys.entities.item.EntityPVJBoat;
import vibrantjourneys.entities.monster.EntityGoon;
import vibrantjourneys.entities.monster.EntityIceCube;
import vibrantjourneys.entities.monster.EntityShade;
import vibrantjourneys.entities.monster.EntitySkeletalKnight;
import vibrantjourneys.entities.neutral.EntityGhost;
import vibrantjourneys.entities.passive.EntityFirefly;
import vibrantjourneys.entities.passive.EntityFly;
import vibrantjourneys.entities.passive.EntitySnail;
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
		
		registerEntityWithEgg("pvj_ghost", EntityGhost.class, 64, 0xb3b3b3, 0x404040);
		registerEntityWithEgg("pvj_shade", EntityShade.class, 64, 0x333333, 0x595959);
		registerEntityWithEgg("pvj_icecube", EntityIceCube.class, 64, 0x66e0ff, 0xccf5ff);
		registerEntityWithEgg("pvj_skeletal_knight", EntitySkeletalKnight.class, 64, 0xa6a6a6, 0x808080);
		registerEntityWithEgg("pvj_goon", EntityGoon.class, 64, 0xa6a6a6, 0x808080);
		
		registerEntity("pvj_boat", EntityPVJBoat.class, 64);
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
			if(PVJConfig.entities.snailSpawnWeight > 0)
				EntityRegistry.addSpawn(EntitySnail.class, PVJConfig.entities.snailSpawnWeight, 2, 4, EnumCreatureType.CREATURE, BiomeReference.getValidBiomes(BiomeReference.FRESHWATER_BIOMES));
			if(PVJConfig.entities.flySpawnWeight > 0)
				EntityRegistry.addSpawn(EntityFly.class, PVJConfig.entities.flySpawnWeight, 3, 4, EnumCreatureType.AMBIENT, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES));
			if(PVJConfig.entities.flySwampSpawnWeight > 0)
				EntityRegistry.addSpawn(EntityFly.class, PVJConfig.entities.flySwampSpawnWeight, 4, 5, EnumCreatureType.AMBIENT, BiomeDictionary.getBiomes(Type.SWAMP).toArray(new Biome[0]));
			if(PVJConfig.entities.fireflySpawnWeight > 0)
				EntityRegistry.addSpawn(EntityFirefly.class, PVJConfig.entities.fireflySpawnWeight, 4, 9, EnumCreatureType.AMBIENT, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES));
		}

		if(PVJConfig.master.enableNeutralMobs)
		{
			if(PVJConfig.entities.ghostSpawnWeight > 0)
				EntityRegistry.addSpawn(EntityGhost.class, PVJConfig.entities.ghostSpawnWeight, 1, 4, EnumCreatureType.MONSTER, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES));
		}
		
		if(PVJConfig.master.enableAggressiveMobs)
		{
			if(PVJConfig.entities.shadeSpawnWeight > 0)
				EntityRegistry.addSpawn(EntityShade.class, PVJConfig.entities.shadeSpawnWeight, 1, 3, EnumCreatureType.MONSTER, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES));
			if(PVJConfig.entities.skeletalKnightWeight > 0)
				EntityRegistry.addSpawn(EntitySkeletalKnight.class, PVJConfig.entities.skeletalKnightWeight, 1, 3, EnumCreatureType.MONSTER, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES));
			if(PVJConfig.entities.icecubeSpawnWeight > 0)
				EntityRegistry.addSpawn(EntityIceCube.class, PVJConfig.entities.icecubeSpawnWeight, 2, 3, EnumCreatureType.MONSTER, BiomeReference.getValidBiomes(BiomeReference.SNOWY_BIOMES));
			if(PVJConfig.entities.goonSpawnWeight > 0)
				EntityRegistry.addSpawn(EntityGoon.class, PVJConfig.entities.goonSpawnWeight, 1, 1, EnumCreatureType.MONSTER, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES));
		}
		
		DungeonHooks.addDungeonMob(new ResourceLocation(Reference.MOD_ID, "pvj_shade"), 100);
		DungeonHooks.addDungeonMob(new ResourceLocation(Reference.MOD_ID, "pvj_skeletal_knight"), 100);
	}
}
