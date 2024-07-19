package dev.orderedchaos.projectvibrantjourneys.common;

import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;

import java.util.function.Supplier;

public class PVJFlammables {

  public static void bootstrap() {
    FireBlock fireblock = (FireBlock) Blocks.FIRE;
    fireblock.setFlammable(PVJBlocks.SHORT_GRASS.get(), 60, 100);
    fireblock.setFlammable(PVJBlocks.FALLEN_LEAVES.get(), 30, 60);
    fireblock.setFlammable(PVJBlocks.DEAD_FALLEN_LEAVES.get(), 30, 60);
    fireblock.setFlammable(PVJBlocks.TWIGS.get(), 30, 60);
    fireblock.setFlammable(PVJBlocks.BIRCH_TWIGS.get(), 30, 60);
    fireblock.setFlammable(PVJBlocks.PINECONES.get(), 30, 60);
    fireblock.setFlammable(PVJBlocks.BARK_MUSHROOM.get(), 30, 60);
    fireblock.setFlammable(PVJBlocks.LIGHT_BROWN_BARK_MUSHROOM.get(), 30, 60);
    fireblock.setFlammable(PVJBlocks.ORANGE_BARK_MUSHROOM.get(), 30, 60);
    fireblock.setFlammable(PVJBlocks.SEA_OATS.get(), 60, 100);
    fireblock.setFlammable(PVJBlocks.BEACH_GRASS.get(), 60, 100);
    fireblock.setFlammable(PVJBlocks.CATTAIL.get(), 20, 60);
    fireblock.setFlammable(PVJBlocks.REEDS.get(), 20, 60);
    fireblock.setFlammable(PVJBlocks.WATERGRASS.get(), 20, 60);
    fireblock.setFlammable(PVJBlocks.SANDY_SPROUTS.get(), 30, 60);
    fireblock.setFlammable(PVJBlocks.PRICKLY_BUSH.get(), 60, 100);
    fireblock.setFlammable(PVJBlocks.YELLOW_WILDFLOWERS.get(), 60, 100);
    fireblock.setFlammable(PVJBlocks.ORANGE_WILDFLOWERS.get(), 60, 100);
    fireblock.setFlammable(PVJBlocks.BLUE_WILDFLOWERS.get(), 60, 100);
    fireblock.setFlammable(PVJBlocks.PURPLE_WILDFLOWERS.get(), 60, 100);
    fireblock.setFlammable(PVJBlocks.WHITE_WILDFLOWERS.get(), 60, 100);
    fireblock.setFlammable(PVJBlocks.MIXED_WILDFLOWERS.get(), 60, 100);
    fireblock.setFlammable(PVJBlocks.PINK_VINES.get(), 60, 100);
    fireblock.setFlammable(PVJBlocks.PINK_VINES_PLANT.get(), 60, 100);


    fireblock.setFlammable(PVJBlocks.OAK_HOLLOW_LOG.get(), 5, 5);
    fireblock.setFlammable(PVJBlocks.BIRCH_HOLLOW_LOG.get(), 5, 5);
    fireblock.setFlammable(PVJBlocks.SPRUCE_HOLLOW_LOG.get(), 5, 5);
    fireblock.setFlammable(PVJBlocks.JUNGLE_HOLLOW_LOG.get(), 5, 5);
    fireblock.setFlammable(PVJBlocks.ACACIA_HOLLOW_LOG.get(), 5, 5);
    fireblock.setFlammable(PVJBlocks.DARK_OAK_HOLLOW_LOG.get(), 5, 5);
    fireblock.setFlammable(PVJBlocks.MANGROVE_HOLLOW_LOG.get(), 5, 5);
    fireblock.setFlammable(PVJBlocks.CHERRY_HOLLOW_LOG.get(), 5, 5);

  }

}
