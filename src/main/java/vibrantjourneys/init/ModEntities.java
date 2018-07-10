package vibrantjourneys.init;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import vibrantjourneys.ProjectVibrantJourneys;
import vibrantjourneys.entities.passive.EntityFirefly;
import vibrantjourneys.entities.passive.EntitySnail;
import vibrantjourneys.entities.renderer.RenderFirefly;
import vibrantjourneys.entities.renderer.RenderSnail;
import vibrantjourneys.util.Reference;

public class ModEntities
{
	public static int id = 1;
	
	public static void initEntities()
	{
		registerEntity("snail", EntitySnail.class, 64, 0x6D453D, 0x677B5C, RenderSnail::new);
		registerEntity("firefly", EntityFirefly.class, 64, 0x3F453D, 0xE8E03D, RenderFirefly::new);
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
		EntityRegistry.addSpawn(EntitySnail.class, 25, 1, 3, EnumCreatureType.CREATURE, Biomes.FOREST, Biomes.PLAINS);
		EntityRegistry.addSpawn(EntityFirefly.class, 300, 6, 9, EnumCreatureType.AMBIENT, Biomes.FOREST, Biomes.PLAINS, ModBiomes.prairie);
	}
}
