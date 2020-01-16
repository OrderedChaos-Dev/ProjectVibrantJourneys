package projectvibrantjourneys.common.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TallBlockItem;

public class PVJDoorItem extends TallBlockItem {

	public PVJDoorItem(Block blockIn, Properties builder) {
		super(blockIn, builder);
	}

	@Override
	public int getBurnTime(ItemStack stack) {
		return 200;
	}
}
