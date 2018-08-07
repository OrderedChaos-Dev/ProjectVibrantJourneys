package vibrantjourneys.init;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemDoor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import vibrantjourneys.ProjectVibrantJourneys;
import vibrantjourneys.entities.item.EntityPVJBoat;
import vibrantjourneys.items.ItemPVJBoat;
import vibrantjourneys.util.CreativeTabPVJ;
import vibrantjourneys.util.Reference;

public class PVJItems
{
	public static final ArrayList<Item> ITEMS = new ArrayList<Item>();
	public static Item slime_droplet;
	
	//These are registered with the door blocks in PVJBlocks
	public static ItemDoor willow_door;
	public static ItemDoor mangrove_door;
	public static ItemDoor palm_door;
	public static ItemDoor redwood_door;
	
	public static Item willow_boat;
	public static Item mangrove_boat;
	public static Item palm_boat;
	public static Item redwood_boat;
	
	public static void initItems()
	{
		slime_droplet = registerItem(new Item(), "slime_droplet");
		willow_boat = registerItem(new ItemPVJBoat(EntityPVJBoat.Type.WILLOW), "willow_boat");
		mangrove_boat = registerItem(new ItemPVJBoat(EntityPVJBoat.Type.MANGROVE), "mangrove_boat");
		palm_boat = registerItem(new ItemPVJBoat(EntityPVJBoat.Type.PALM), "palm_boat");
		redwood_boat = registerItem(new ItemPVJBoat(EntityPVJBoat.Type.REDWOOD), "redwood_boat");
	}
	
	public static Item registerItem(Item item, String name)
	{
		item.setUnlocalizedName(name);
		item.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		item.setCreativeTab(CreativeTabPVJ.instance);
		ITEMS.add(item);
		
		return item;
	}
}
