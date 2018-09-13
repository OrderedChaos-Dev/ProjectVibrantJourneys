package vibrantjourneys.init;

import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class PVJRecipes
{
	public static void initRecipes()
	{
		GameRegistry.addSmelting(PVJBlocks.willow_log, new ItemStack(Items.COAL, 1, 1), 0.15F);
		GameRegistry.addSmelting(PVJBlocks.mangrove_log, new ItemStack(Items.COAL, 1, 1), 0.15F);
		GameRegistry.addSmelting(PVJBlocks.palm_log, new ItemStack(Items.COAL, 1, 1), 0.15F);
		GameRegistry.addSmelting(PVJBlocks.redwood_log, new ItemStack(Items.COAL, 1, 1), 0.15F);
		GameRegistry.addSmelting(PVJBlocks.fir_log, new ItemStack(Items.COAL, 1, 1), 0.15F);
		GameRegistry.addSmelting(PVJBlocks.pine_log, new ItemStack(Items.COAL, 1, 1), 0.15F);
		GameRegistry.addSmelting(PVJBlocks.aspen_log, new ItemStack(Items.COAL, 1, 1), 0.15F);
		GameRegistry.addSmelting(PVJBlocks.maple_log, new ItemStack(Items.COAL, 1, 1), 0.15F);
		GameRegistry.addSmelting(PVJBlocks.baobab_log, new ItemStack(Items.COAL, 1, 1), 0.15F);
		
		GameRegistry.addSmelting(PVJBlocks.small_cactus, new ItemStack(Items.DYE, 1, EnumDyeColor.GREEN.getDyeDamage()), 0.2F);
	}
}
