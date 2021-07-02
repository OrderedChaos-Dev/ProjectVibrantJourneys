package projectvibrantjourneys.init;

import net.minecraft.block.ComposterBlock;
import net.minecraft.util.IItemProvider;
import projectvibrantjourneys.init.object.PVJBlocks;
import projectvibrantjourneys.init.object.PVJItems;

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
		setCompostInfo(PVJBlocks.cindercane, 0.8F);
		setCompostInfo(PVJBlocks.short_grass, 0.25F);
		setCompostInfo(PVJBlocks.beach_grass, 0.25F);
		setCompostInfo(PVJBlocks.prairie_grass, 0.25F);
		setCompostInfo(PVJBlocks.aspen_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.red_maple_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.orange_maple_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.purple_maple_fallen_leaves, 0.1F);
		
		setCompostInfo(PVJBlocks.coconut, 0.2F);
		setCompostInfo(PVJItems.juniper_berries, 0.1F);
		
		setCompostInfo(PVJBlocks.fir_leaves, 0.3F);
		setCompostInfo(PVJBlocks.pine_leaves, 0.3F);
		setCompostInfo(PVJBlocks.redwood_leaves, 0.3F);
		setCompostInfo(PVJBlocks.willow_leaves, 0.3F);
		setCompostInfo(PVJBlocks.mangrove_leaves, 0.3F);
		setCompostInfo(PVJBlocks.palm_leaves, 0.3F);
		setCompostInfo(PVJBlocks.aspen_leaves, 0.3F);
		setCompostInfo(PVJBlocks.juniper_leaves, 0.3F);
		setCompostInfo(PVJBlocks.berried_juniper_leaves, 0.4F);
		setCompostInfo(PVJBlocks.cottonwood_leaves, 0.3F);
		setCompostInfo(PVJBlocks.baobab_leaves, 0.3F);
		setCompostInfo(PVJBlocks.red_maple_leaves, 0.3F);
		setCompostInfo(PVJBlocks.orange_maple_leaves, 0.3F);
		setCompostInfo(PVJBlocks.purple_maple_leaves, 0.3F);
		
		setCompostInfo(PVJBlocks.fir_sapling, 0.3F);
		setCompostInfo(PVJBlocks.pine_sapling, 0.3F);
		setCompostInfo(PVJBlocks.redwood_sapling, 0.3F);
		setCompostInfo(PVJBlocks.willow_sapling, 0.3F);
		setCompostInfo(PVJBlocks.mangrove_sapling, 0.3F);
		setCompostInfo(PVJBlocks.palm_sapling, 0.3F);
		setCompostInfo(PVJBlocks.aspen_sapling, 0.3F);
		setCompostInfo(PVJBlocks.juniper_sapling, 0.3F);
		setCompostInfo(PVJBlocks.cottonwood_sapling, 0.3F);
		setCompostInfo(PVJBlocks.baobab_sapling, 0.3F);
		setCompostInfo(PVJBlocks.red_maple_sapling, 0.3F);
		setCompostInfo(PVJBlocks.orange_maple_sapling, 0.3F);
		setCompostInfo(PVJBlocks.purple_maple_sapling, 0.3F);
	}
	
	public static void setCompostInfo(IItemProvider item, float chance) {
		ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
	}
}
