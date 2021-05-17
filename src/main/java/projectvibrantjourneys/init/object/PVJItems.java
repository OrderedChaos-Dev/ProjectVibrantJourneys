package projectvibrantjourneys.init.object;

import java.util.ArrayList;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import projectvibrantjourneys.common.items.PVJFishBucketItem;
import projectvibrantjourneys.core.ProjectVibrantJourneys;
import projectvibrantjourneys.init.PVJItemGroup;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJItems {
	public static final ArrayList<Item> ITEMS = new ArrayList<Item>();
	
	public static Item starfish_bucket = registerItem(new PVJFishBucketItem(PVJEntities.STARFISH, new Item.Properties().stacksTo(1).tab(PVJItemGroup.PVJ_ITEMGROUP)), "starfish_bucket");
	public static Item clam_bucket = registerItem(new PVJFishBucketItem(PVJEntities.CLAM, new Item.Properties().stacksTo(1).tab(PVJItemGroup.PVJ_ITEMGROUP)), "clam_bucket");
	public static Item pearl = registerItem(new Item(new Item.Properties().tab(PVJItemGroup.PVJ_ITEMGROUP)), "pearl");
	public static Item clam = registerItem(new Item(new Item.Properties().tab(PVJItemGroup.PVJ_ITEMGROUP)), "clam");
	public static Item cooked_clam = registerItem(new Item(new Item.Properties().tab(PVJItemGroup.PVJ_ITEMGROUP)), "cooked_clam");
	public static Item clam_chowder = registerItem(new Item(new Item.Properties().tab(PVJItemGroup.PVJ_ITEMGROUP)), "clam_chowder");
	
	@SubscribeEvent
	public static void initItems(RegistryEvent.Register<Item> event) {
		createSpawnEgg(PVJEntities.FLY, 0x7e7e7e, 0xb3b3b3);
		createSpawnEgg(PVJEntities.FIREFLY, 0xd4d360, 0xf5f371);
		createSpawnEgg(PVJEntities.STARFISH, 0xFE5F55, 0xFFCAD4);
		createSpawnEgg(PVJEntities.CLAM, 0x5b5943, 0xfbf0fb);
		createSpawnEgg(PVJEntities.SNAIL, 0x865d2c, 0x6f928d);
		createSpawnEgg(PVJEntities.SLUG, 0x865d2c, 0x241606);
		createSpawnEgg(PVJEntities.SMALL_SPIDER, 0x260300, 0xb31104);
		createSpawnEgg(PVJEntities.FROG, 0x238748, 0xfbf0fb);
		
		ITEMS.forEach((e) -> event.getRegistry().register(e));
	}
	
	public static Item registerItem(Item item, String name) {
		item.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
		ITEMS.add(item);
		
		return item;
	}
	
	public static Item createSpawnEgg(EntityType<?> entity, int color1, int color2) {
		return registerItem(new SpawnEggItem(entity, color1, color2, new Item.Properties().tab(PVJItemGroup.PVJ_ITEMGROUP)), entity.getRegistryName().getPath() + "_spawn_egg");
	}
}
