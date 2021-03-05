package projectvibrantjourneys.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJItems {
	public static final List<Item> ITEMS_TO_REGISTER = new ArrayList<Item>();
	
	@SubscribeEvent
	public static void initItems(RegistryEvent.Register<Item> event) {

	}
	
	public static Item registerItem(Item item, String name) {
		item.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
		ForgeRegistries.ITEMS.register(item);
		
		return item;
	}
}
