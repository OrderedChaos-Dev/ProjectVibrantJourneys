package dev.orderedchaos.projectvibrantjourneys.util;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

public class LevelUtils {
    public static boolean setBlock(final LevelAccessor level, final BlockPos position, final BlockState blockState, int parameter) {
        if (!isValid(level, position, blockState)) {
            return false;
        }

        return level.setBlock(position, blockState, parameter);
    }

    public static boolean setBlockAndUpdate(final LevelAccessor level, final BlockPos position, final BlockState blockState) {
        if (level instanceof ServerLevel serverLevel) {
            return serverLevel.setBlockAndUpdate(position, blockState);
        }

        return false;
    }

    private static boolean isValid(final LevelAccessor level, final BlockPos position, final BlockState blockState) {
        boolean respectsCutoff = respectsCutoff(level, position, blockState);

        if (!respectsCutoff) {
            ProjectVibrantJourneys.LOGGER.debug("Skipped placing feature (" +  blockState.getBlock().getDescriptionId() + ") [respectsCutoff: " + respectsCutoff + "]");
        }

        return respectsCutoff;
    }

    private static boolean respectsCutoff(final LevelAccessor level, final BlockPos position, BlockState blockState) {
        if (level instanceof WorldGenRegion region) {
            int x = SectionPos.blockToSectionCoord(position.getX());
            int z = SectionPos.blockToSectionCoord(position.getZ());

            ChunkPos chunkpos = region.getCenter();
            int xResult = Math.abs(chunkpos.x - x);
            int zResult = Math.abs(chunkpos.z - z);

//            ProjectVibrantJourneys.LOGGER.debug("Feature: " + blockState.getBlock().getDescriptionId() + " x: " + x + " | z: " + z + " | xResult: " + xResult + " | zResult: " + zResult + " | chunkPos: " + chunkpos + " | writeRadiusCutoff: " + region.writeRadiusCutoff);

            return xResult <= region.writeRadiusCutoff && zResult <= region.writeRadiusCutoff;
        } else {
            return false;
            // Has not reached this point yet
//            ProjectVibrantJourneys.LOGGER.warn("WorldGenRegion is not being used to place features, instead it is: " + level.getClass());
        }
    }
}
