package vibrantjourneys.init;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import vibrantjourneys.ProjectVibrantJourneys;
import vibrantjourneys.entities.monster.EntityIceCube;
import vibrantjourneys.entities.monster.EntityShade;
import vibrantjourneys.entities.neutral.EntityGhost;
import vibrantjourneys.entities.passive.EntityFirefly;
import vibrantjourneys.entities.passive.EntityFly;
import vibrantjourneys.entities.passive.EntitySnail;
import vibrantjourneys.entities.renderer.RenderFirefly;
import vibrantjourneys.entities.renderer.RenderFly;
import vibrantjourneys.entities.renderer.RenderGhost;
import vibrantjourneys.entities.renderer.RenderIceCube;
import vibrantjourneys.entities.renderer.RenderShade;
import vibrantjourneys.entities.renderer.RenderSnail;
import vibrantjourneys.util.BiomeReference;
import vibrantjourneys.util.Reference;

public class PVJEntities
{
	public static int id = 1;
	
	public static void initEntities()
	{
		registerEntity("snail", EntitySnail.class, 64, 0x6D453D, 0x677B5C, RenderSnail::new);
		registerEntity("fly", EntityFly.class, 64, 0x3F000D, 0xE8E93D, RenderFly::new);
		registerEntity("firefly", EntityFirefly.class, 64, 0x3F453D, 0xE8E03D, RenderFirefly::new);
		
		registerEntity("ghost", EntityGhost.class, 64, 0x000000, 0x000000, RenderGhost::new);
		registerEntity("shade", EntityShade.class, 64, 0x0000F0, 0x000F00, RenderShade::new);
		registerEntity("icecube", EntityIceCube.class, 64, 0x66e0ff, 0xb3f0ff, RenderIceCube::new);
		addSpawns();
	}

	private static <T extends Entity> void registerEntity(String name, Class<T> entityClass, int trackingRange, 
			int eggPrimary, int eggSecondary, IRenderFactory<? super T> renderer)
	{
		ResourceLocation entityResource = new ResourceLocation(Reference.MOD_ID, name);
		EntityRegistry.registerModEntity(entityResource, entityClass, name, id++,
				ProjectVibrantJourneys.instance, trackingRange, 3, true, eggPrimary, eggSecondary);
		
		ProjectVibrantJourneys.proxy.registerEntityRenderer(entityClass, renderer);
	}
	
	private static void addSpawns()
	{
		EntityRegistry.addSpawn(EntitySnail.class, 50, 1, 3, EnumCreatureType.CREATURE, BiomeReference.FRESHWATER_BIOMES.toArray(new Biome[0]));
		EntityRegistry.addSpawn(EntityFly.class, 30, 3, 4, EnumCreatureType.AMBIENT, BiomeReference.ALL_BIOMES);
		EntityRegistry.addSpawn(EntityFirefly.class, 350, 4, 9, EnumCreatureType.AMBIENT, BiomeReference.ALL_BIOMES);
		
		EntityRegistry.addSpawn(EntityGhost.class, 75, 3, 4, EnumCreatureType.MONSTER, BiomeReference.ALL_BIOMES);
		EntityRegistry.addSpawn(EntityShade.class, 95, 2, 3, EnumCreatureType.MONSTER, BiomeReference.ALL_BIOMES);
		EntityRegistry.addSpawn(EntityIceCube.class, 35, 2, 3, EnumCreatureType.MONSTER, BiomeReference.SNOW_BIOMES);
	}
}
