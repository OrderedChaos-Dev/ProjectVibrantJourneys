package projectvibrantjourneys.common.entities;

import net.minecraft.item.ItemStack;

public interface IBucketCollectable {
	
	void setFromBucket(boolean value);
	void setBucketData(ItemStack bucket);
	ItemStack getFishBucket();
	boolean isFromBucket();
}
