package projectvibrantjourneys.init;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.common.entities.item.PVJBoatEntity;
import projectvibrantjourneys.common.items.BeverageItem;
import projectvibrantjourneys.common.items.FloatingPlantItem;
import projectvibrantjourneys.common.items.PVJBoatItem;
import projectvibrantjourneys.common.items.PVJDoorItem;
import projectvibrantjourneys.common.items.PVJFishBucketItem;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJItems {
	public static final Item.Properties SPAWN_EGG_PROPERTY = new Item.Properties().group(ItemGroup.MISC);
	
	public static final List<Item> ITEMS_TO_REGISTER = new ArrayList<Item>();
	
	public static Item starfish_bucket, clam_bucket;
	public static Item raw_clam, cooked_clam, clam_chowder, pearl;
	public static Item spectral_wrappings, maw_tongue;
	public static Item fir_sign, fir_door, pine_door, palm_door, willow_door, mangrove_door, redwood_door, 
						baobab_door, aspen_door, maple_door, cottonwood_door, juniper_door;
	public static Item fir_boat, pine_boat, palm_boat, willow_boat, mangrove_boat, redwood_boat, 
						baobab_boat, aspen_boat, maple_boat, cottonwood_boat, juniper_boat;
	public static Item cracked_coconut, coconut_milk;
	public static Item juniper_berries;
	
	@SubscribeEvent
	public static void initItems(RegistryEvent.Register<Item> event) {
		registerSpawnEgg("fly", PVJEntities.fly, 0x7e7e7e, 0xb3b3b3);
		registerSpawnEgg("firefly", PVJEntities.firefly, 0xd4d360, 0xf5f371);
		registerSpawnEgg("starfish", PVJEntities.starfish, 0xFE5F55, 0xFFCAD4);
		registerSpawnEgg("clam", PVJEntities.clam, 0x5b5943, 0xfbf0fb);
		registerSpawnEgg("snail", PVJEntities.snail, 0x865d2c, 0x6f928d);
		registerSpawnEgg("slug", PVJEntities.slug, 0x865d2c, 0x241606);
		registerSpawnEgg("scarecrow", PVJEntities.scarecrow, 0xe38a1d, 0xcbb630);
		
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
		registerSpawnEgg("maw", PVJEntities.maw, 0x909090, 0xFF0000);
	
		registerItem(new FloatingPlantItem(PVJBlocks.frogbit), "frogbit");
		registerItem(new FloatingPlantItem(PVJBlocks.duckweed), "duckweed");
//		fir_sign = registerItem(new SignItem((new Item.Properties()).maxStackSize(16).group(PVJItemGroup.PVJ_ITEMGROUP), PVJBlocks.fir_sign, PVJBlocks.fir_wall_sign), "fir_sign");
		starfish_bucket = registerItem(new PVJFishBucketItem(PVJEntities.starfish, Fluids.WATER, (new Item.Properties()).maxStackSize(1).group(PVJItemGroup.PVJ_ITEMGROUP)), "starfish_bucket");
		clam_bucket = registerItem(new PVJFishBucketItem(PVJEntities.clam, Fluids.WATER, (new Item.Properties()).maxStackSize(1).group(PVJItemGroup.PVJ_ITEMGROUP)), "clam_bucket");
		raw_clam = registerItem(new Item(new Item.Properties().group(PVJItemGroup.PVJ_ITEMGROUP).food(PVJFoods.RAW_CLAM)), "raw_clam");
		cooked_clam = registerItem(new Item(new Item.Properties().group(PVJItemGroup.PVJ_ITEMGROUP).food(PVJFoods.COOKED_CLAM)), "cooked_clam");
		clam_chowder = registerItem(new Item(new Item.Properties().group(PVJItemGroup.PVJ_ITEMGROUP).food(PVJFoods.CLAM_CHOWDER)), "clam_chowder");
		pearl = registerItem(new Item(new Item.Properties().group(PVJItemGroup.PVJ_ITEMGROUP)), "pearl");
		cracked_coconut = registerItem(new Item(new Item.Properties().food(PVJFoods.CRACKED_COCONUT).group(PVJItemGroup.PVJ_ITEMGROUP)), "cracked_coconut");
		coconut_milk = registerItem(new BeverageItem(new Item.Properties().maxStackSize(1).food(PVJFoods.COCONUT_MILK).group(PVJItemGroup.PVJ_ITEMGROUP)), "coconut_milk");
		spectral_wrappings = registerItem(new Item(new Item.Properties().group(PVJItemGroup.PVJ_ITEMGROUP)), "spectral_wrappings");
		maw_tongue = registerItem(new Item(new Item.Properties().group(PVJItemGroup.PVJ_ITEMGROUP)) {
			   @OnlyIn(Dist.CLIENT)
			   public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
				   tooltip.add(new TranslationTextComponent("item.projectvibrantjourneys.maw_tongue.description"));
			   }
		}, "maw_tongue");
		juniper_berries = registerItem(new Item(new Item.Properties().food(PVJFoods.JUNIPER_BERRIES).group(PVJItemGroup.PVJ_ITEMGROUP)), "juniper_berries");
		
		//lazy door fuel handling - will clean up later
		fir_door = registerItem(new PVJDoorItem(PVJBlocks.fir_door, (new Item.Properties()).group(PVJItemGroup.PVJ_ITEMGROUP)), "fir_door");
		pine_door = registerItem(new PVJDoorItem(PVJBlocks.pine_door, (new Item.Properties()).group(PVJItemGroup.PVJ_ITEMGROUP)), "pine_door");
		palm_door = registerItem(new PVJDoorItem(PVJBlocks.palm_door, (new Item.Properties()).group(PVJItemGroup.PVJ_ITEMGROUP)), "palm_door");
		willow_door = registerItem(new PVJDoorItem(PVJBlocks.willow_door, (new Item.Properties()).group(PVJItemGroup.PVJ_ITEMGROUP)), "willow_door");
		mangrove_door = registerItem(new PVJDoorItem(PVJBlocks.mangrove_door, (new Item.Properties()).group(PVJItemGroup.PVJ_ITEMGROUP)), "mangrove_door");
		redwood_door = registerItem(new PVJDoorItem(PVJBlocks.redwood_door, (new Item.Properties()).group(PVJItemGroup.PVJ_ITEMGROUP)), "redwood_door");
		baobab_door = registerItem(new PVJDoorItem(PVJBlocks.baobab_door, (new Item.Properties()).group(PVJItemGroup.PVJ_ITEMGROUP)), "baobab_door");
		aspen_door = registerItem(new PVJDoorItem(PVJBlocks.aspen_door, (new Item.Properties()).group(PVJItemGroup.PVJ_ITEMGROUP)), "aspen_door");
		maple_door = registerItem(new PVJDoorItem(PVJBlocks.maple_door, (new Item.Properties()).group(PVJItemGroup.PVJ_ITEMGROUP)), "maple_door");
		cottonwood_door = registerItem(new PVJDoorItem(PVJBlocks.cottonwood_door, (new Item.Properties()).group(PVJItemGroup.PVJ_ITEMGROUP)), "cottonwood_door");
		juniper_door = registerItem(new PVJDoorItem(PVJBlocks.juniper_door, (new Item.Properties()).group(PVJItemGroup.PVJ_ITEMGROUP)), "juniper_door");
		
		fir_boat = registerItem(new PVJBoatItem(PVJBoatEntity.Type.FIR, (new Item.Properties()).group(PVJItemGroup.PVJ_ITEMGROUP)), "fir_boat");
		pine_boat = registerItem(new PVJBoatItem(PVJBoatEntity.Type.PINE, (new Item.Properties()).group(PVJItemGroup.PVJ_ITEMGROUP)), "pine_boat");
		palm_boat = registerItem(new PVJBoatItem(PVJBoatEntity.Type.PALM, (new Item.Properties()).group(PVJItemGroup.PVJ_ITEMGROUP)), "palm_boat");
		willow_boat = registerItem(new PVJBoatItem(PVJBoatEntity.Type.WILLOW, (new Item.Properties()).group(PVJItemGroup.PVJ_ITEMGROUP)), "willow_boat");
		mangrove_boat = registerItem(new PVJBoatItem(PVJBoatEntity.Type.MANGROVE, (new Item.Properties()).group(PVJItemGroup.PVJ_ITEMGROUP)), "mangrove_boat");
		redwood_boat = registerItem(new PVJBoatItem(PVJBoatEntity.Type.REDWOOD, (new Item.Properties()).group(PVJItemGroup.PVJ_ITEMGROUP)), "redwood_boat");
		baobab_boat = registerItem(new PVJBoatItem(PVJBoatEntity.Type.BAOBAB, (new Item.Properties()).group(PVJItemGroup.PVJ_ITEMGROUP)), "baobab_boat");
		aspen_boat = registerItem(new PVJBoatItem(PVJBoatEntity.Type.ASPEN, (new Item.Properties()).group(PVJItemGroup.PVJ_ITEMGROUP)), "aspen_boat");
		maple_boat = registerItem(new PVJBoatItem(PVJBoatEntity.Type.MAPLE, (new Item.Properties()).group(PVJItemGroup.PVJ_ITEMGROUP)), "maple_boat");
		cottonwood_boat = registerItem(new PVJBoatItem(PVJBoatEntity.Type.COTTONWOOD, (new Item.Properties()).group(PVJItemGroup.PVJ_ITEMGROUP)), "cottonwood_boat");
		juniper_boat = registerItem(new PVJBoatItem(PVJBoatEntity.Type.JUNIPER, (new Item.Properties()).group(PVJItemGroup.PVJ_ITEMGROUP)), "juniper_boat");
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
