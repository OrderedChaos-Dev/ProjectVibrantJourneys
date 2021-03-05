package projectvibrantjourneys.init;

import net.minecraft.block.ComposterBlock;
import net.minecraft.util.IItemProvider;

/*
 * Used to integrate vanilla mechanics into mod objects e.g. composting, fire spread, etc
 */
public class PVJVanillaIntegration {
	
	public static void init() {
		setCompostInfo(PVJBlocks.fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.pinecones, 0.1F);
		setCompostInfo(PVJBlocks.sea_oats, 0.65F);
		setCompostInfo(PVJBlocks.cattail, 0.65F);
		setCompostInfo(PVJBlocks.bark_mushroom, 0.4F);
		
	}
	
	public static void setCompostInfo(IItemProvider item, float chance) {
		ComposterBlock.CHANCES.put(item.asItem(), chance);
	}
}
