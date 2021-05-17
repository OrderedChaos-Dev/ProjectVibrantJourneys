package projectvibrantjourneys.init;

import net.minecraft.block.ComposterBlock;
import net.minecraft.util.IItemProvider;
import projectvibrantjourneys.init.object.PVJBlocks;

/*
 * Used to integrate vanilla mechanics into mod objects e.g. composting, fire spread, etc
 */
public class PVJVanillaIntegration {
	
	public static void init() {
		setCompostInfo(PVJBlocks.fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.twigs, 0.1F);
		setCompostInfo(PVJBlocks.pinecones, 0.1F);
		setCompostInfo(PVJBlocks.sea_oats, 0.65F);
		setCompostInfo(PVJBlocks.cattail, 0.65F);
		setCompostInfo(PVJBlocks.bark_mushroom, 0.4F);
		setCompostInfo(PVJBlocks.fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.glowcap, 0.65F);
		setCompostInfo(PVJBlocks.crimson_nettle, 0.65F);
		setCompostInfo(PVJBlocks.warped_nettle, 0.65F);
		setCompostInfo(PVJBlocks.short_grass, 0.25F);
	}
	
	public static void setCompostInfo(IItemProvider item, float chance) {
		ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
	}
}
