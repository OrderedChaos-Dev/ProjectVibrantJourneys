package projectvibrantjourneys.init;

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
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJItems {
	public static final Item.Properties SPAWN_EGG_PROPERTY = new Item.Properties().group(ItemGroup.MISC);
	
	@SubscribeEvent
	public static void initItems(RegistryEvent.Register<Item> event) {
		registerSpawnEgg("skeletal_knight", PVJEntities.skeletal_knight, 0xa6a6a6, 0x808080);
		registerSpawnEgg("ghost", PVJEntities.ghost, 0xa6a6a6, 0x808080);
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
