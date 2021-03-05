package projectvibrantjourneys.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class PVJItemGroup extends ItemGroup {

	public static final PVJItemGroup PVJ_ITEMGROUP = new PVJItemGroup("projectvibrantjourneys");
	public PVJItemGroup(String label) {
		super(label);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(PVJBlocks.twigs);
	}
}
