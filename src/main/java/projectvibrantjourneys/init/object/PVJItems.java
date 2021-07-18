package projectvibrantjourneys.init.object;

import java.util.ArrayList;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import projectvibrantjourneys.common.entities.items.PVJBoatEntity;
import projectvibrantjourneys.common.items.BottleFoodItem;
import projectvibrantjourneys.common.items.PVJBoatItem;
import projectvibrantjourneys.common.items.PVJFishBucketItem;
import projectvibrantjourneys.core.ProjectVibrantJourneys;
import projectvibrantjourneys.init.PVJItemGroup;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJItems {
	public static final ArrayList<Item> ITEMS = new ArrayList<Item>();
	
	public static Item starfish_bucket = registerItem(new PVJFishBucketItem(PVJEntities.STARFISH, new Item.Properties().stacksTo(1).tab(PVJItemGroup.PVJ_ITEMGROUP)), "starfish_bucket");
	public static Item clam_bucket = registerItem(new PVJFishBucketItem(PVJEntities.CLAM, new Item.Properties().stacksTo(1).tab(PVJItemGroup.PVJ_ITEMGROUP)), "clam_bucket");
	public static Item pearl = registerItem(new Item(new Item.Properties().tab(PVJItemGroup.PVJ_ITEMGROUP)), "pearl");
	public static Item clam = registerItem(new Item(new Item.Properties().tab(PVJItemGroup.PVJ_ITEMGROUP).food(PVJFoods.RAW_CLAM)), "clam");
	public static Item cooked_clam = registerItem(new Item(new Item.Properties().tab(PVJItemGroup.PVJ_ITEMGROUP).food(PVJFoods.COOKED_CLAM)), "cooked_clam");
	public static Item clam_chowder = registerItem(new Item(new Item.Properties().tab(PVJItemGroup.PVJ_ITEMGROUP).food(PVJFoods.CLAM_CHOWDER)), "clam_chowder");
	public static Item juniper_berries = registerItem(new Item(new Item.Properties().tab(PVJItemGroup.PVJ_ITEMGROUP).food(PVJFoods.JUNIPER_BERRIES)), "juniper_berries");
	public static Item cracked_coconut = registerItem(new Item(new Item.Properties().tab(PVJItemGroup.PVJ_ITEMGROUP).food(PVJFoods.CRACKED_COCONUT)), "cracked_coconut");
	public static Item coconut_milk = registerItem(new BottleFoodItem(new Item.Properties().tab(PVJItemGroup.PVJ_ITEMGROUP).food(PVJFoods.COCONUT_MILK)), "coconut_milk");
	
	public static Item fir_boat = registerItem(new PVJBoatItem(PVJBoatEntity.PVJBoatType.FIR, new Item.Properties().stacksTo(1).tab(PVJItemGroup.PVJ_ITEMGROUP)), "fir_boat");
	public static Item pine_boat = registerItem(new PVJBoatItem(PVJBoatEntity.PVJBoatType.PINE, new Item.Properties().stacksTo(1).tab(PVJItemGroup.PVJ_ITEMGROUP)), "pine_boat");
	public static Item redwood_boat = registerItem(new PVJBoatItem(PVJBoatEntity.PVJBoatType.REDWOOD, new Item.Properties().stacksTo(1).tab(PVJItemGroup.PVJ_ITEMGROUP)), "redwood_boat");
	public static Item willow_boat = registerItem(new PVJBoatItem(PVJBoatEntity.PVJBoatType.WILLOW, new Item.Properties().stacksTo(1).tab(PVJItemGroup.PVJ_ITEMGROUP)), "willow_boat");
	public static Item mangrove_boat = registerItem(new PVJBoatItem(PVJBoatEntity.PVJBoatType.MANGROVE, new Item.Properties().stacksTo(1).tab(PVJItemGroup.PVJ_ITEMGROUP)), "mangrove_boat");
	public static Item palm_boat = registerItem(new PVJBoatItem(PVJBoatEntity.PVJBoatType.PALM, new Item.Properties().stacksTo(1).tab(PVJItemGroup.PVJ_ITEMGROUP)), "palm_boat");
	public static Item aspen_boat = registerItem(new PVJBoatItem(PVJBoatEntity.PVJBoatType.ASPEN, new Item.Properties().stacksTo(1).tab(PVJItemGroup.PVJ_ITEMGROUP)), "aspen_boat");
	public static Item juniper_boat = registerItem(new PVJBoatItem(PVJBoatEntity.PVJBoatType.JUNIPER, new Item.Properties().stacksTo(1).tab(PVJItemGroup.PVJ_ITEMGROUP)), "juniper_boat");
	public static Item cottonwood_boat = registerItem(new PVJBoatItem(PVJBoatEntity.PVJBoatType.COTTONWOOD, new Item.Properties().stacksTo(1).tab(PVJItemGroup.PVJ_ITEMGROUP)), "cottonwood_boat");
	public static Item baobab_boat = registerItem(new PVJBoatItem(PVJBoatEntity.PVJBoatType.BAOBAB, new Item.Properties().stacksTo(1).tab(PVJItemGroup.PVJ_ITEMGROUP)), "baobab_boat");
	public static Item maple_boat = registerItem(new PVJBoatItem(PVJBoatEntity.PVJBoatType.MAPLE, new Item.Properties().stacksTo(1).tab(PVJItemGroup.PVJ_ITEMGROUP)), "maple_boat");
	public static Item sakura_boat = registerItem(new PVJBoatItem(PVJBoatEntity.PVJBoatType.SAKURA, new Item.Properties().stacksTo(1).tab(PVJItemGroup.PVJ_ITEMGROUP)), "sakura_boat");
	public static Item tamarack_boat = registerItem(new PVJBoatItem(PVJBoatEntity.PVJBoatType.TAMARACK, new Item.Properties().stacksTo(1).tab(PVJItemGroup.PVJ_ITEMGROUP)), "tamarack_boat");
	public static Item joshua_boat = registerItem(new PVJBoatItem(PVJBoatEntity.PVJBoatType.JOSHUA, new Item.Properties().stacksTo(1).tab(PVJItemGroup.PVJ_ITEMGROUP)), "joshua_boat");
	
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
