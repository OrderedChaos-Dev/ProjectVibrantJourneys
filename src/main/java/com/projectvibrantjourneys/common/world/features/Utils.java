package com.projectvibrantjourneys.common.world.features;

import com.projectvibrantjourneys.core.ProjectVibrantJourneys;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

public class Utils {
    public static boolean setBlock(final LevelAccessor level, final BlockPos position, final BlockState blockState, int parameter) {
        if (!isValid(level, position, blockState)) {
            return false;
        }

        return level.setBlock(position, blockState, parameter);
    }

    public static boolean setBlockAndUpdate(final LevelAccessor level, final BlockPos position, final BlockState blockState) {
        if (!isValid(level, position, blockState)) {
            return false;
        }

        if (level instanceof ServerLevel serverLevel) {
            return serverLevel.setBlockAndUpdate(position, blockState);
        }

        return false;
    }

    private static boolean isValid(final LevelAccessor level, final BlockPos position, final BlockState blockState) {
        // TODO :: Add `canSurvive`?
        boolean respectsCutoff = respectsCutoff(level, position, blockState);
        boolean placedInLava = level.isFluidAtPosition(position, (fluidState -> fluidState.getType() == Fluids.LAVA));

        if (!respectsCutoff || placedInLava) {
            ProjectVibrantJourneys.LOGGER.debug("Skipped placing feature (" +  blockState.getBlock().getDescriptionId() + ") [respectsCutoff: " + respectsCutoff + " | placedInLava: " + placedInLava + "]");
        }

        return respectsCutoff && !placedInLava;
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
            // Has not reached this point yet
            ProjectVibrantJourneys.LOGGER.warn("WorldGenRegion is not being used to place features, instead it is: " + level.getClass());
        }

        return true;
    }
}
