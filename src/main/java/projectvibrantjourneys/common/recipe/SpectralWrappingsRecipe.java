package projectvibrantjourneys.common.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import projectvibrantjourneys.init.PVJItems;

public class SpectralWrappingsRecipe implements IBrewingRecipe {

	@Override
	public boolean isInput(ItemStack input) {
		return PotionUtils.getPotionFromItem(input) == Potions.AWKWARD;
	}

	@Override
	public boolean isIngredient(ItemStack ingredient) {
		return ingredient.getItem() == PVJItems.spectral_wrappings;
	}

	@Override
	public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
		if(input != null && ingredient != null) {
			if(isInput(input) && isIngredient(ingredient)) {
				ItemStack potion = new ItemStack(Items.POTION, 1);
				PotionUtils.addPotionToItemStack(potion, Potions.INVISIBILITY);
				return potion;
			}
		}
		return ItemStack.EMPTY;
	}

}
