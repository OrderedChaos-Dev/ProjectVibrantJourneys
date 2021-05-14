package projectvibrantjourneys.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import projectvibrantjourneys.init.objectregistry.PVJBlocks;

public class PVJItemGroup extends ItemGroup {

	public static final PVJItemGroup PVJ_ITEMGROUP = new PVJItemGroup("projectvibrantjourneys");
	
	public PVJItemGroup(String label) {
		super(label);
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(PVJBlocks.twigs);
	}
}
