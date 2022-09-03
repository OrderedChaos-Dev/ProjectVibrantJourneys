package com.projectvibrantjourneys.client;

import com.projectvibrantjourneys.core.registry.PVJBlocks;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockColorsInit {

    @SubscribeEvent
    public static void onColorHandlerEvent(RegisterColorHandlersEvent.Block event) {
    	event.register(getFoliageColor(), PVJBlocks.TWIGS.get());
    	event.register(getFoliageColor(), PVJBlocks.FALLEN_LEAVES.get());
    	event.register(getFoliageColor(), PVJBlocks.FALLEN_LEAVES.get());
    	event.register(getGrassColor(), PVJBlocks.SHORT_GRASS.get());
    }
    
    @SubscribeEvent
    public static void onColorHandlerEvent(RegisterColorHandlersEvent.Item event) {
    	BlockColors blockColors = event.getBlockColors();
    	
    	event.register((itemstack, tintIndex) -> {
			BlockState state = Blocks.OAK_LEAVES.defaultBlockState();
			int color = blockColors.getColor(state, null, null, tintIndex); 
			return color;
		}, PVJBlocks.FALLEN_LEAVES.get());
		
    	event.register((itemstack, tintIndex) -> {
			BlockState state = Blocks.OAK_LEAVES.defaultBlockState();
			int color = blockColors.getColor(state, null, null, tintIndex);
			return color;
		}, PVJBlocks.SHORT_GRASS.get());
    }
    
	private static BlockColor getFoliageColor() {
		return (state, world, pos, tintIndex) -> (world != null && pos != null)
				? BiomeColors.getAverageFoliageColor(world, pos)
				: FoliageColor.getDefaultColor();
	}

//	private static void registerFoliageColorBlock(BlockColors bc, Block block, int color) {
//		bc.register((state, world, pos, tintIndex) -> color, block);
//	}
//
//	private static void registerFoliageColorItem(ItemColors ic, BlockColors bc, Block block) {
//		ic.register((itemstack, tintIndex) -> {
//			BlockState state = Blocks.OAK_LEAVES.defaultBlockState();
//			int color = bc.getColor(state, null, null, tintIndex); // get color
//			return color;
//		}, block);
//	}
//
//	private static void registerFoliageColorItem(ItemColors ic, BlockColors bc, Block block, int color) {
//		ic.register((itemstack, tintIndex) -> color, block);
//	}

	private static BlockColor getGrassColor() {
		return (state, world, pos, tintIndex) -> (world != null && pos != null)
				? BiomeColors.getAverageGrassColor(world, pos)
				: GrassColor.get(0.5D, 1.0D);
	}
}
