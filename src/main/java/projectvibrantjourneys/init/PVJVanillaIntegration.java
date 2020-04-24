package projectvibrantjourneys.init;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.util.IItemProvider;

/*
 * Used to integrate vanilla mechanics into mod objects e.g. composting, fire spread, etc
 */
public class PVJVanillaIntegration {
	
	public static void init() {
		setFlameInfo(PVJBlocks.fir_log, 5, 20);
		setFlameInfo(PVJBlocks.fir_leaves, 30, 60);
		setFlameInfo(PVJBlocks.fir_planks, 5, 20);
		setFlameInfo(PVJBlocks.fir_slab, 5, 20);
		setFlameInfo(PVJBlocks.fir_fence_gate, 5, 20);
		setFlameInfo(PVJBlocks.fir_fence, 5, 20);
		setFlameInfo(PVJBlocks.fir_wood, 5, 20);
		setFlameInfo(PVJBlocks.fir_stairs, 5, 20);
		setFlameInfo(PVJBlocks.stripped_fir_log, 5, 20);
		setFlameInfo(PVJBlocks.stripped_fir_wood, 5, 20);
		
		setFlameInfo(PVJBlocks.pine_log, 5, 20);
		setFlameInfo(PVJBlocks.pine_leaves, 30, 60);
		setFlameInfo(PVJBlocks.pine_planks, 5, 20);
		setFlameInfo(PVJBlocks.pine_slab, 5, 20);
		setFlameInfo(PVJBlocks.pine_fence_gate, 5, 20);
		setFlameInfo(PVJBlocks.pine_fence, 5, 20);
		setFlameInfo(PVJBlocks.pine_wood, 5, 20);
		setFlameInfo(PVJBlocks.pine_stairs, 5, 20);
		setFlameInfo(PVJBlocks.stripped_pine_log, 5, 20);
		setFlameInfo(PVJBlocks.stripped_pine_wood, 5, 20);
		
		setFlameInfo(PVJBlocks.palm_log, 5, 20);
		setFlameInfo(PVJBlocks.palm_leaves, 30, 60);
		setFlameInfo(PVJBlocks.palm_planks, 5, 20);
		setFlameInfo(PVJBlocks.palm_slab, 5, 20);
		setFlameInfo(PVJBlocks.palm_fence_gate, 5, 20);
		setFlameInfo(PVJBlocks.palm_fence, 5, 20);
		setFlameInfo(PVJBlocks.palm_wood, 5, 20);
		setFlameInfo(PVJBlocks.palm_stairs, 5, 20);
		setFlameInfo(PVJBlocks.stripped_palm_log, 5, 20);
		
		setFlameInfo(PVJBlocks.willow_log, 5, 20);
		setFlameInfo(PVJBlocks.willow_leaves, 30, 60);
		setFlameInfo(PVJBlocks.willow_planks, 5, 20);
		setFlameInfo(PVJBlocks.willow_slab, 5, 20);
		setFlameInfo(PVJBlocks.willow_fence_gate, 5, 20);
		setFlameInfo(PVJBlocks.willow_fence, 5, 20);
		setFlameInfo(PVJBlocks.willow_wood, 5, 20);
		setFlameInfo(PVJBlocks.willow_stairs, 5, 20);
		setFlameInfo(PVJBlocks.stripped_willow_log, 5, 20);
		setFlameInfo(PVJBlocks.stripped_willow_wood, 5, 20);
		
		setFlameInfo(PVJBlocks.mangrove_log, 5, 20);
		setFlameInfo(PVJBlocks.mangrove_leaves, 30, 60);
		setFlameInfo(PVJBlocks.mangrove_planks, 5, 20);
		setFlameInfo(PVJBlocks.mangrove_slab, 5, 20);
		setFlameInfo(PVJBlocks.mangrove_fence_gate, 5, 20);
		setFlameInfo(PVJBlocks.mangrove_fence, 5, 20);
		setFlameInfo(PVJBlocks.mangrove_wood, 5, 20);
		setFlameInfo(PVJBlocks.mangrove_stairs, 5, 20);
		setFlameInfo(PVJBlocks.stripped_mangrove_log, 5, 20);
		setFlameInfo(PVJBlocks.stripped_mangrove_wood, 5, 20);
		
		setFlameInfo(PVJBlocks.redwood_log, 5, 20);
		setFlameInfo(PVJBlocks.redwood_leaves, 30, 60);
		setFlameInfo(PVJBlocks.redwood_planks, 5, 20);
		setFlameInfo(PVJBlocks.redwood_slab, 5, 20);
		setFlameInfo(PVJBlocks.redwood_fence_gate, 5, 20);
		setFlameInfo(PVJBlocks.redwood_fence, 5, 20);
		setFlameInfo(PVJBlocks.redwood_wood, 5, 20);
		setFlameInfo(PVJBlocks.redwood_stairs, 5, 20);
		setFlameInfo(PVJBlocks.stripped_redwood_log, 5, 20);
		setFlameInfo(PVJBlocks.stripped_redwood_wood, 5, 20);
		
		setFlameInfo(PVJBlocks.baobab_log, 5, 20);
		setFlameInfo(PVJBlocks.baobab_leaves, 30, 60);
		setFlameInfo(PVJBlocks.baobab_planks, 5, 20);
		setFlameInfo(PVJBlocks.baobab_slab, 5, 20);
		setFlameInfo(PVJBlocks.baobab_fence_gate, 5, 20);
		setFlameInfo(PVJBlocks.baobab_fence, 5, 20);
		setFlameInfo(PVJBlocks.baobab_wood, 5, 20);
		setFlameInfo(PVJBlocks.baobab_stairs, 5, 20);
		setFlameInfo(PVJBlocks.stripped_baobab_log, 5, 20);
		setFlameInfo(PVJBlocks.stripped_baobab_wood, 5, 20);
		
		setFlameInfo(PVJBlocks.maple_log, 5, 20);
		setFlameInfo(PVJBlocks.red_maple_leaves, 30, 60);
		setFlameInfo(PVJBlocks.orange_maple_leaves, 30, 60);
		setFlameInfo(PVJBlocks.purple_maple_leaves, 30, 60);
		setFlameInfo(PVJBlocks.maple_planks, 5, 20);
		setFlameInfo(PVJBlocks.maple_slab, 5, 20);
		setFlameInfo(PVJBlocks.maple_fence_gate, 5, 20);
		setFlameInfo(PVJBlocks.maple_fence, 5, 20);
		setFlameInfo(PVJBlocks.maple_wood, 5, 20);
		setFlameInfo(PVJBlocks.maple_stairs, 5, 20);
		setFlameInfo(PVJBlocks.stripped_maple_log, 5, 20);
		setFlameInfo(PVJBlocks.stripped_maple_wood, 5, 20);
		
		setFlameInfo(PVJBlocks.cottonwood_log, 5, 20);
		setFlameInfo(PVJBlocks.cottonwood_leaves, 30, 60);
		setFlameInfo(PVJBlocks.cottonwood_planks, 5, 20);
		setFlameInfo(PVJBlocks.cottonwood_slab, 5, 20);
		setFlameInfo(PVJBlocks.cottonwood_fence_gate, 5, 20);
		setFlameInfo(PVJBlocks.cottonwood_fence, 5, 20);
		setFlameInfo(PVJBlocks.cottonwood_wood, 5, 20);
		setFlameInfo(PVJBlocks.cottonwood_stairs, 5, 20);
		setFlameInfo(PVJBlocks.stripped_cottonwood_log, 5, 20);
		setFlameInfo(PVJBlocks.stripped_cottonwood_wood, 5, 20);
		
		setFlameInfo(PVJBlocks.oak_twigs, 5, 15);
		setFlameInfo(PVJBlocks.birch_twigs, 5, 15);
		setFlameInfo(PVJBlocks.spruce_twigs, 5, 15);
		setFlameInfo(PVJBlocks.jungle_twigs, 5, 15);
		setFlameInfo(PVJBlocks.dark_oak_twigs, 5, 15);
		setFlameInfo(PVJBlocks.acacia_twigs, 5, 15);
		setFlameInfo(PVJBlocks.fir_twigs, 5, 15);
		setFlameInfo(PVJBlocks.pine_twigs, 5, 15);
		setFlameInfo(PVJBlocks.palm_twigs, 5, 15);
		setFlameInfo(PVJBlocks.willow_twigs, 5, 15);
		setFlameInfo(PVJBlocks.mangrove_twigs, 5, 15);
		setFlameInfo(PVJBlocks.redwood_twigs, 5, 15);
		setFlameInfo(PVJBlocks.baobab_twigs, 5, 15);
		setFlameInfo(PVJBlocks.red_maple_twigs, 5, 15);
		setFlameInfo(PVJBlocks.orange_maple_twigs, 5, 15);
		setFlameInfo(PVJBlocks.purple_maple_twigs, 5, 15);
		setFlameInfo(PVJBlocks.cottonwood_twigs, 5, 15);
		
		setFlameInfo(PVJBlocks.oak_fallen_leaves, 30, 60);
		setFlameInfo(PVJBlocks.birch_fallen_leaves, 30, 60);
		setFlameInfo(PVJBlocks.spruce_fallen_leaves, 30, 60);
		setFlameInfo(PVJBlocks.jungle_fallen_leaves, 30, 60);
		setFlameInfo(PVJBlocks.dark_oak_fallen_leaves, 30, 60);
		setFlameInfo(PVJBlocks.acacia_fallen_leaves, 30, 60);
		setFlameInfo(PVJBlocks.fir_fallen_leaves, 30, 60);
		setFlameInfo(PVJBlocks.pine_fallen_leaves, 30, 60);
		setFlameInfo(PVJBlocks.palm_fallen_leaves, 30, 60);
		setFlameInfo(PVJBlocks.willow_fallen_leaves, 30, 60);
		setFlameInfo(PVJBlocks.mangrove_fallen_leaves, 30, 60);
		setFlameInfo(PVJBlocks.redwood_fallen_leaves, 30, 60);
		setFlameInfo(PVJBlocks.baobab_fallen_leaves, 30, 60);
		setFlameInfo(PVJBlocks.red_maple_fallen_leaves, 30, 60);
		setFlameInfo(PVJBlocks.orange_maple_fallen_leaves, 30, 60);
		setFlameInfo(PVJBlocks.purple_maple_fallen_leaves, 30, 60);
		setFlameInfo(PVJBlocks.cottonwood_fallen_leaves, 30, 60);
		
		setFlameInfo(PVJBlocks.pinecones, 5, 20);
		setFlameInfo(PVJBlocks.sea_oats, 60, 100);
		setFlameInfo(PVJBlocks.cattail, 60, 100);
		setFlameInfo(PVJBlocks.beach_grass, 60, 100);
		
		setCompostInfo(PVJBlocks.fir_leaves, 0.3F);
		setCompostInfo(PVJBlocks.pine_leaves, 0.3F);
		setCompostInfo(PVJBlocks.palm_leaves, 0.3F);
		setCompostInfo(PVJBlocks.willow_leaves, 0.3F);
		setCompostInfo(PVJBlocks.mangrove_leaves, 0.3F);
		setCompostInfo(PVJBlocks.redwood_leaves, 0.3F);
		setCompostInfo(PVJBlocks.baobab_leaves, 0.3F);
		setCompostInfo(PVJBlocks.red_maple_leaves, 0.3F);
		setCompostInfo(PVJBlocks.orange_maple_leaves, 0.3F);
		setCompostInfo(PVJBlocks.purple_maple_leaves, 0.3F);
		setCompostInfo(PVJBlocks.cottonwood_leaves, 0.3F);
		
		setCompostInfo(PVJBlocks.fir_sapling, 0.3F);
		setCompostInfo(PVJBlocks.pine_sapling, 0.3F);
		setCompostInfo(PVJBlocks.palm_sapling, 0.3F);
		setCompostInfo(PVJBlocks.willow_sapling, 0.3F);
		setCompostInfo(PVJBlocks.mangrove_sapling, 0.3F);
		setCompostInfo(PVJBlocks.redwood_sapling, 0.3F);
		setCompostInfo(PVJBlocks.baobab_sapling, 0.3F);
		setCompostInfo(PVJBlocks.red_maple_sapling, 0.3F);
		setCompostInfo(PVJBlocks.orange_maple_sapling, 0.3F);
		setCompostInfo(PVJBlocks.purple_maple_sapling, 0.3F);
		setCompostInfo(PVJBlocks.cottonwood_sapling, 0.3F);
		
		setCompostInfo(PVJBlocks.oak_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.birch_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.spruce_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.jungle_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.dark_oak_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.acacia_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.fir_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.pine_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.palm_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.willow_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.mangrove_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.redwood_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.baobab_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.red_maple_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.orange_maple_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.purple_maple_fallen_leaves, 0.1F);
		setCompostInfo(PVJBlocks.cottonwood_fallen_leaves, 0.1F);
		
		setCompostInfo(PVJBlocks.pinecones, 0.1F);
		setCompostInfo(PVJBlocks.dung, 1.0F);
		setCompostInfo(PVJBlocks.sea_oats, 0.65F);
		setCompostInfo(PVJBlocks.cattail, 0.65F);
		setCompostInfo(PVJBlocks.beach_grass, 0.5F);
		setCompostInfo(PVJBlocks.small_cactus, 0.3F);
		setCompostInfo(PVJBlocks.bark_mushroom, 0.4F);
		setCompostInfo(PVJBlocks.frogbit, 0.4F);
		setCompostInfo(PVJBlocks.duckweed, 0.15F);
		setCompostInfo(PVJBlocks.glowcap, 0.65F);
		
		PVJEvents.stripping_map.put(PVJBlocks.fir_log, PVJBlocks.stripped_fir_log);
		PVJEvents.stripping_map.put(PVJBlocks.fir_wood, PVJBlocks.stripped_fir_wood);
		PVJEvents.stripping_map.put(PVJBlocks.pine_log, PVJBlocks.stripped_pine_log);
		PVJEvents.stripping_map.put(PVJBlocks.pine_wood, PVJBlocks.stripped_pine_wood);
		PVJEvents.stripping_map.put(PVJBlocks.palm_log, PVJBlocks.stripped_palm_log);
		PVJEvents.stripping_map.put(PVJBlocks.palm_wood, PVJBlocks.stripped_palm_wood);
		PVJEvents.stripping_map.put(PVJBlocks.willow_log, PVJBlocks.stripped_willow_log);
		PVJEvents.stripping_map.put(PVJBlocks.willow_wood, PVJBlocks.stripped_willow_wood);
		PVJEvents.stripping_map.put(PVJBlocks.mangrove_log, PVJBlocks.stripped_mangrove_log);
		PVJEvents.stripping_map.put(PVJBlocks.mangrove_wood, PVJBlocks.stripped_mangrove_wood);
		PVJEvents.stripping_map.put(PVJBlocks.redwood_log, PVJBlocks.stripped_redwood_log);
		PVJEvents.stripping_map.put(PVJBlocks.redwood_wood, PVJBlocks.stripped_redwood_wood);
		PVJEvents.stripping_map.put(PVJBlocks.baobab_log, PVJBlocks.stripped_baobab_log);
		PVJEvents.stripping_map.put(PVJBlocks.baobab_wood, PVJBlocks.stripped_baobab_wood);
		PVJEvents.stripping_map.put(PVJBlocks.maple_log, PVJBlocks.stripped_maple_log);
		PVJEvents.stripping_map.put(PVJBlocks.maple_wood, PVJBlocks.stripped_maple_wood);
		PVJEvents.stripping_map.put(PVJBlocks.cottonwood_log, PVJBlocks.stripped_cottonwood_log);
		PVJEvents.stripping_map.put(PVJBlocks.cottonwood_wood, PVJBlocks.stripped_cottonwood_wood);
		
		addFlowerPot(PVJBlocks.fir_sapling, PVJBlocks.potted_fir_sapling);
		addFlowerPot(PVJBlocks.pine_sapling, PVJBlocks.potted_pine_sapling);
		addFlowerPot(PVJBlocks.palm_sapling, PVJBlocks.potted_palm_sapling);
		addFlowerPot(PVJBlocks.willow_sapling, PVJBlocks.potted_willow_sapling);
		addFlowerPot(PVJBlocks.mangrove_sapling, PVJBlocks.potted_mangrove_sapling);
		addFlowerPot(PVJBlocks.redwood_sapling, PVJBlocks.potted_redwood_sapling);
		addFlowerPot(PVJBlocks.baobab_sapling, PVJBlocks.potted_baobab_sapling);
		addFlowerPot(PVJBlocks.red_maple_sapling, PVJBlocks.potted_red_maple_sapling);
		addFlowerPot(PVJBlocks.orange_maple_sapling, PVJBlocks.potted_orange_maple_sapling);
		addFlowerPot(PVJBlocks.purple_maple_sapling, PVJBlocks.potted_purple_maple_sapling);
		addFlowerPot(PVJBlocks.cottonwood_sapling, PVJBlocks.potted_cottonwood_sapling);
		addFlowerPot(PVJBlocks.glowcap, PVJBlocks.potted_glowcap);
		addFlowerPot(PVJBlocks.small_cactus, PVJBlocks.potted_small_cactus);
		
	}

	public static void setFlameInfo(Block block, int encouragement, int flammability) {
		((FireBlock)Blocks.FIRE).setFireInfo(block, encouragement, flammability);
	}
	
	public static void setCompostInfo(IItemProvider item, float chance) {
		ComposterBlock.CHANCES.put(item.asItem(), chance);
	}
	
	public static void addFlowerPot(Block plant, Block plantPot) {
		((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(plant.getRegistryName(), () -> plantPot);
	}
}
