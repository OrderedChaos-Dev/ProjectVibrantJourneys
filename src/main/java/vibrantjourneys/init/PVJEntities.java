package vibrantjourneys.init;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import vibrantjourneys.PVJConfig;
import vibrantjourneys.ProjectVibrantJourneys;
import vibrantjourneys.entities.item.EntityPVJBoat;
import vibrantjourneys.entities.monster.EntityIceCube;
import vibrantjourneys.entities.monster.EntityShade;
import vibrantjourneys.entities.monster.EntitySkeletalKnight;
import vibrantjourneys.entities.neutral.EntityGhost;
import vibrantjourneys.entities.passive.EntityFirefly;
import vibrantjourneys.entities.passive.EntityFly;
import vibrantjourneys.entities.passive.EntitySnail;
import vibrantjourneys.entities.renderer.RenderFirefly;
import vibrantjourneys.entities.renderer.RenderFly;
import vibrantjourneys.entities.renderer.RenderGhost;
import vibrantjourneys.entities.renderer.RenderIceCube;
import vibrantjourneys.entities.renderer.RenderPVJBoat;
import vibrantjourneys.entities.renderer.RenderShade;
import vibrantjourneys.entities.renderer.RenderSkeletalKnight;
import vibrantjourneys.entities.renderer.RenderSnail;
import vibrantjourneys.util.BiomeReference;
import vibrantjourneys.util.Reference;

public class PVJEntities
{
	public static int id = 1;
	
	public static void initEntities()
	{
		registerEntityWithEgg("snail", EntitySnail.class, 64, 0x6D453D, 0x677B5C, RenderSnail::new);
		registerEntityWithEgg("fly", EntityFly.class, 64, 0x3F000D, 0xE8E93D, RenderFly::new);
		registerEntityWithEgg("firefly", EntityFirefly.class, 64, 0x3F453D, 0xE8E03D, RenderFirefly::new);
		
		registerEntityWithEgg("ghost", EntityGhost.class, 64, 0x000000, 0x000000, RenderGhost::new);
		registerEntityWithEgg("shade", EntityShade.class, 64, 0x0000F0, 0x000F00, RenderShade::new);
		registerEntityWithEgg("icecube", EntityIceCube.class, 64, 0x66e0ff, 0xb3f0ff, RenderIceCube::new);
		registerEntityWithEgg("skeletal_knight", EntitySkeletalKnight.class, 64, 0x66e0ff, 0xbcf3ff, RenderSkeletalKnight::new);
		
		registerEntity("pvj_boat", EntityPVJBoat.class, 64, RenderPVJBoat::new);
		
		addSpawns();
	}

	private static <T extends Entity> void registerEntity(String name, Class<T> entityClass, int trackingRange, IRenderFactory<? super T> renderer)
	{
		ResourceLocation entityResource = new ResourceLocation(Reference.MOD_ID, name);
		EntityRegistry.registerModEntity(entityResource, entityClass, name, id++,
				ProjectVibrantJourneys.instance, trackingRange, 3, true);
		
		ProjectVibrantJourneys.proxy.registerEntityRenderer(entityClass, renderer);
	}
	
	private static <T extends Entity> void registerEntityWithEgg(String name, Class<T> entityClass, int trackingRange, int eggPrimary, int eggSecondary, IRenderFactory<? super T> renderer)
	{
		registerEntity(name, entityClass, trackingRange, renderer);
		ResourceLocation entityResource = new ResourceLocation(Reference.MOD_ID, name);
		EntityRegistry.registerEgg(entityResource, eggPrimary, eggSecondary);
	}
	
	private static void addSpawns()
	{
		EntityRegistry.addSpawn(EntitySnail.class, PVJConfig.entities.snailSpawnWeight, 1, 3, EnumCreatureType.CREATURE, BiomeReference.FRESHWATER_BIOMES.toArray(new Biome[0]));
		EntityRegistry.addSpawn(EntityFly.class, PVJConfig.entities.flySpawnWeight, 3, 4, EnumCreatureType.AMBIENT, BiomeReference.OVERWORLD_BIOMES_ARRAY);
		EntityRegistry.addSpawn(EntityFirefly.class, PVJConfig.entities.fireflySpawnWeight, 4, 9, EnumCreatureType.AMBIENT, BiomeReference.OVERWORLD_BIOMES_ARRAY);
		
		EntityRegistry.addSpawn(EntityGhost.class, PVJConfig.entities.ghostSpawnWeight, 1, 4, EnumCreatureType.MONSTER, BiomeReference.OVERWORLD_BIOMES_ARRAY);
		EntityRegistry.addSpawn(EntityShade.class, PVJConfig.entities.shadeSpawnWeight, 1, 3, EnumCreatureType.MONSTER, BiomeReference.OVERWORLD_BIOMES_ARRAY);
		EntityRegistry.addSpawn(EntitySkeletalKnight.class, PVJConfig.entities.skeletalKnightWeight, 1, 3, EnumCreatureType.MONSTER, BiomeReference.OVERWORLD_BIOMES_ARRAY);
		EntityRegistry.addSpawn(EntityIceCube.class, PVJConfig.entities.icecubeSpawnWeight, 2, 3, EnumCreatureType.MONSTER, BiomeReference.SNOW_BIOMES);
	}
}
