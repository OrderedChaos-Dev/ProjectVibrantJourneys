package vibrantjourneys.init;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import vibrantjourneys.ProjectVibrantJourneys;
import vibrantjourneys.util.CreativeTabPVJ;
import vibrantjourneys.util.Reference;

public class ModItems
{
	public static Item slimeDroplet;
	
	public static void initItems()
	{
		slimeDroplet = registerItem(new Item(), "slime_droplet");
	}
	
	public static Item registerItem(Item item, String name)
	{
		item.setUnlocalizedName(name);
		item.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		item.setCreativeTab(CreativeTabPVJ.instance);
		ForgeRegistries.ITEMS.register(item);
		ProjectVibrantJourneys.proxy.registerItemRenderer(item);
		
		return item;
	}
}
