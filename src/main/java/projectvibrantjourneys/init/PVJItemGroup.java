package projectvibrantjourneys.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import projectvibrantjourneys.init.object.PVJBlocks;

public class PVJItemGroup extends CreativeModeTab {

	public static final PVJItemGroup PVJ_ITEMGROUP = new PVJItemGroup("projectvibrantjourneys");
	
	public PVJItemGroup(String label) {
		super(label);
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(PVJBlocks.twigs);
	}
}
