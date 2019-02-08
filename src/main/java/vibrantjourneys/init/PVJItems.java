package vibrantjourneys.init;

import java.util.ArrayList;

import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.ResourceLocation;
import vibrantjourneys.items.ItemBeverage;
import vibrantjourneys.items.ItemClamChowder;
import vibrantjourneys.items.ItemMysticalFood;
import vibrantjourneys.items.ItemPVJBoat;
import vibrantjourneys.util.CreativeTabPVJ;
import vibrantjourneys.util.EnumWoodType;
import vibrantjourneys.util.PVJConfig;
import vibrantjourneys.util.Reference;

public class PVJItems
{
	public static final ArrayList<Item> ITEMS = new ArrayList<Item>();
	public static final ArrayList<Item> BOATS = new ArrayList<Item>();
	public static Item slime_droplet;
	
	public static Item cracked_coconut;
	public static Item coconut_milk;
	public static Item juniper_berries;
	public static Item raw_squid;
	public static Item cooked_squid;
	public static Item sugarcane_juice;
	public static Item cactus_salad;
	public static Item raw_duck;
	public static Item cooked_duck;
	public static Item clam;
	public static Item steamed_clam;
	public static Item clam_chowder;
	
	public static Item aquamarine;
	
	public static Item spectral_wrappings;
	
	public static Item goon_bile;
	public static Item unstable_essence;
	public static Item mystical_porkchop;
	public static Item mystical_beef;
	public static Item mystical_chicken;
	public static Item mystical_mutton;
	public static Item mystical_cod;
	public static Item mystical_salmon;
	public static Item mystical_potato;
	public static Item mystical_rabbit;
	
	public static void initItems()
	{
		slime_droplet = registerItem(new Item(), "slime_droplet");
		
		cracked_coconut = registerItem(new ItemFood(3, 0.35F, false), "cracked_coconut");
		coconut_milk = registerItem(new ItemBeverage(1, 0.05F, "regeneration", 400), "coconut_milk");
		juniper_berries = registerItem(new ItemFood(3, 0.2F, false).setPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("regeneration"), 60), 1.0F), "juniper_berries");
		raw_squid = registerItem(new ItemFood(2, 0.3F, false), "raw_squid");
		cooked_squid = registerItem(new ItemFood(7, 0.7F, false), "cooked_squid");
		sugarcane_juice = registerItem(new ItemBeverage(2, 0.1F, "speed", 100), "sugarcane_juice");
		cactus_salad = registerItem(new ItemFood(4, 0.3F, false).setContainerItem(Items.BOWL), "cactus_salad");
		raw_duck = registerItem(new ItemFood(2, 0.3F, true).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 0), 0.3F), "raw_duck");
		cooked_duck = registerItem(new ItemFood(6, 0.6F, true), "cooked_duck");
		clam = registerItem(new ItemFood(1, 0.2F, false).setPotionEffect(new PotionEffect(MobEffects.POISON, 500, 0), 0.8F), "clam");
		steamed_clam = registerItem(new ItemFood(6, 0.4F, false), "steamed_clam_meat");
		clam_chowder = registerItem(new ItemClamChowder(10, 0.9F), "clam_chowder");
		
		spectral_wrappings = registerItem(new Item(), "spectral_wrappings");
		goon_bile = registerItem(new Item(), "goon_bile");
		unstable_essence = registerItem(new Item(), "unstable_essence");
		
		for(EnumWoodType woodType : EnumWoodType.values())
		{
			BOATS.add(registerItem(new ItemPVJBoat(woodType), woodType.getName() + "_boat"));
		}	
		
		if(PVJConfig.master.enableMysticalGrill)
		{
			mystical_porkchop = registerItem(new ItemMysticalFood((ItemFood) Items.COOKED_PORKCHOP), "mystical_porkchop");
			mystical_beef = registerItem(new ItemMysticalFood((ItemFood) Items.COOKED_BEEF), "mystical_beef");
			mystical_chicken = registerItem(new ItemMysticalFood((ItemFood) Items.COOKED_CHICKEN), "mystical_chicken");
			mystical_mutton = registerItem(new ItemMysticalFood((ItemFood) Items.COOKED_MUTTON), "mystical_mutton");
			mystical_cod = registerItem(new ItemMysticalFood((ItemFood) Items.COOKED_FISH), "mystical_cod");
			mystical_salmon = registerItem(new ItemMysticalFood((ItemFood) Items.COOKED_FISH), "mystical_salmon");
			mystical_potato = registerItem(new ItemMysticalFood((ItemFood) Items.BAKED_POTATO), "mystical_potato");
			mystical_rabbit = registerItem(new ItemMysticalFood((ItemFood) Items.COOKED_RABBIT), "mystical_rabbit");	
		}
		
		PotionHelper.addMix(PotionTypes.AWKWARD, spectral_wrappings, PotionTypes.INVISIBILITY);
		PotionHelper.addMix(PotionTypes.AWKWARD, goon_bile, PotionTypes.POISON);
	}
	
	public static Item registerItem(Item item, String name)
	{
		item.setTranslationKey(name);
		item.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		item.setCreativeTab(CreativeTabPVJ.instance);
		ITEMS.add(item);
		
		return item;
	}
}
