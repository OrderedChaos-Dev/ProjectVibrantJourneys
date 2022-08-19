package com.projectvibrantjourneys.client;

import com.projectvibrantjourneys.core.registry.PVJBlocks;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockColorsInit {

    @SubscribeEvent
    public static void onColorHandlerEvent(ColorHandlerEvent.Block event) {
    	BlockColors blockColors = event.getBlockColors();
		registerFoliageColorBlock(blockColors, PVJBlocks.TWIGS.get());
		registerFoliageColorBlock(blockColors, PVJBlocks.FALLEN_LEAVES.get());
		registerGrassColorBlock(blockColors, PVJBlocks.SHORT_GRASS.get());
    }
    
    @SubscribeEvent
    public static void onColorHandlerEvent(ColorHandlerEvent.Item event) {
    	ItemColors itemColors = event.getItemColors();
    	BlockColors blockColors = event.getBlockColors();
    	
    	itemColors.register((itemstack, tintIndex) -> {
			BlockState state = Blocks.OAK_LEAVES.defaultBlockState();
			int color = blockColors.getColor(state, null, null, tintIndex); // get color
			return color;
		}, PVJBlocks.FALLEN_LEAVES.get());
		
    	itemColors.register((itemstack, tintIndex) -> {
			BlockState state = Blocks.OAK_LEAVES.defaultBlockState();
			int color = blockColors.getColor(state, null, null, tintIndex); // get color
			return color;
		}, PVJBlocks.SHORT_GRASS.get());
    }
    
	private static void registerFoliageColorBlock(BlockColors bc, Block block) {
		bc.register((state, world, pos, tintIndex) -> (world != null && pos != null)
				? BiomeColors.getAverageFoliageColor(world, pos)
				: FoliageColor.getDefaultColor(), block);
	}
	
	private static void registerWaterColorBlock(BlockColors bc, Block block) {
		bc.register((state, world, pos, tintIndex) -> (world != null && pos != null)
				? BiomeColors.getAverageWaterColor(world, pos)
				: -1, block);
	}

	private static void registerFoliageColorBlock(BlockColors bc, Block block, int color) {
		bc.register((state, world, pos, tintIndex) -> color, block);
	}

	private static void registerFoliageColorItem(ItemColors ic, BlockColors bc, Block block) {
		ic.register((itemstack, tintIndex) -> {
			BlockState state = Blocks.OAK_LEAVES.defaultBlockState();
			int color = bc.getColor(state, null, null, tintIndex); // get color
			return color;
		}, block);
	}

	private static void registerFoliageColorItem(ItemColors ic, BlockColors bc, Block block, int color) {
		ic.register((itemstack, tintIndex) -> color, block);
	}

	private static void registerGrassColorBlock(BlockColors bc, Block block) {
		bc.register((state, world, pos, tintIndex) -> (world != null && pos != null)
				? BiomeColors.getAverageGrassColor(world, pos)
				: GrassColor.get(0.5D, 1.0D), block);
	}
}
