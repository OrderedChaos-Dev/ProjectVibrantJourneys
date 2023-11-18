package dev.orderedchaos.projectvibrantjourneys.client;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
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

@Mod.EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PVJBlockColorRegistry {

  @SubscribeEvent
  public static void onColorHandlerEventBlock(RegisterColorHandlersEvent.Block event) {
    event.register(getFoliageColor(), PVJBlocks.TWIGS.get());
    event.register(getFoliageColor(), PVJBlocks.FALLEN_LEAVES.get());
    event.register(getGrassColor(), PVJBlocks.SHORT_GRASS.get());
    event.register(getGrassColor(), PVJBlocks.SANDY_SPROUTS.get());
  }

  @SubscribeEvent
  public static void onColorHandlerEventItem(RegisterColorHandlersEvent.Item event) {
    BlockColors blockColors = event.getBlockColors();

    event.register((itemstack, tintIndex) -> {
      BlockState state = Blocks.OAK_LEAVES.defaultBlockState();
      return blockColors.getColor(state, null, null, tintIndex);
    }, PVJBlocks.FALLEN_LEAVES.get());

    event.register((itemstack, tintIndex) -> {
      BlockState state = Blocks.OAK_LEAVES.defaultBlockState();
      return blockColors.getColor(state, null, null, tintIndex);
    }, PVJBlocks.SHORT_GRASS.get());
  }

  private static BlockColor getGrassColor() {
    return (state, world, pos, tintIndex) -> (world != null && pos != null)
      ? BiomeColors.getAverageGrassColor(world, pos)
      : GrassColor.get(0.5D, 1.0D);
  }

  private static BlockColor getFoliageColor() {
    return (state, world, pos, tintIndex) -> (world != null && pos != null)
      ? BiomeColors.getAverageFoliageColor(world, pos)
      : FoliageColor.getDefaultColor();
  }
}
