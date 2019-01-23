package vibrantjourneys.init;

import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import vibrantjourneys.util.EnumWoodType;

public class PVJRecipes
{
	public static void initRecipes()
	{
		for(EnumWoodType woodType: EnumWoodType.values())
		{
			GameRegistry.addSmelting(PVJBlocks.LOGS.get(woodType.getID()), new ItemStack(Items.COAL, 1, 1), 0.15F);
		}
		
		GameRegistry.addSmelting(PVJBlocks.small_cactus, new ItemStack(Items.DYE, 1, EnumDyeColor.GREEN.getDyeDamage()), 0.2F);
		GameRegistry.addSmelting(PVJItems.raw_squid, new ItemStack(PVJItems.cooked_squid, 1), 0.1F);
	}
}
