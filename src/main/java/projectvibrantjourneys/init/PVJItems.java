package projectvibrantjourneys.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.common.items.FloatingPlantItem;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJItems {
	public static final Item.Properties SPAWN_EGG_PROPERTY = new Item.Properties().group(ItemGroup.MISC);
	
	public static final List<Item> ITEMS_TO_REGISTER = new ArrayList<Item>();
	
	@SubscribeEvent
	public static void initItems(RegistryEvent.Register<Item> event) {
		registerSpawnEgg("fly", PVJEntities.fly, 0x7e7e7e, 0xb3b3b3);
		registerSpawnEgg("firefly", PVJEntities.firefly, 0xd4d360, 0xf5f371);
		
		registerSpawnEgg("ghost", PVJEntities.ghost, 0x959595, 0xffffff);
		
		registerSpawnEgg("skeletal_knight", PVJEntities.skeletal_knight, 0xa6a6a6, 0x808080);
		registerSpawnEgg("shade", PVJEntities.shade, 0x1f1f1f, 0x060606);
		registerSpawnEgg("banshee", PVJEntities.banshee, 0x5a6969, 0x157d7d);
		registerSpawnEgg("wraith", PVJEntities.wraith, 0xa29f85, 0x232323);
		registerSpawnEgg("haunt", PVJEntities.haunt, 0x748477, 0x121212);
		registerSpawnEgg("specter", PVJEntities.specter, 0x7c808e, 0x232323);
		registerSpawnEgg("phantasm", PVJEntities.phantasm, 0x7e7e7e, 0x1d1d1d);
		registerSpawnEgg("nightmare", PVJEntities.nightmare, 0x6b6b6b, 0x9f4343);
		registerSpawnEgg("ice_cube", PVJEntities.ice_cube, 0x9eb8e8, 0xbad0f9);
		
		registerItem(new FloatingPlantItem(PVJBlocks.frogbit), "frogbit");
		registerItem(new FloatingPlantItem(PVJBlocks.duckweed), "duckweed");
	}
	
	public static Item registerItem(Item item, String name) {
		item.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
		ForgeRegistries.ITEMS.register(item);
		
		return item;
	}
	
	public static <T extends Entity> void registerSpawnEgg(String name, EntityType<T> entityType, int colorPrimary, int colorSecondary) {
		Item spawnEgg = new SpawnEggItem(entityType, colorPrimary, colorSecondary, SPAWN_EGG_PROPERTY);
		registerItem(spawnEgg, name + "_spawn_egg");
	}
}
