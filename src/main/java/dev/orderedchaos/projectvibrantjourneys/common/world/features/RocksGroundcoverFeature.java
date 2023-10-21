package dev.orderedchaos.projectvibrantjourneys.common.world.features;

import com.mojang.serialization.Codec;
import dev.orderedchaos.projectvibrantjourneys.common.blocks.GroundcoverBlock;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import dev.orderedchaos.projectvibrantjourneys.util.LevelUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.material.Fluids;

public class RocksGroundcoverFeature extends Feature<RandomPatchConfiguration> {

    public RocksGroundcoverFeature(Codec<RandomPatchConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<RandomPatchConfiguration> context) {
        RandomSource randomSource = context.random();
        BlockPos origin = context.origin();
        WorldGenLevel level = context.level();
        BlockState originState = level.getBlockState(origin);

        if(!originState.canBeReplaced()) {
            return false;
        }

        Block ground = level.getBlockState(origin.below()).getBlock();
        BlockState rocks = getRocksToPlace(randomSource, originState, origin, ground);
        if(!rocks.canSurvive(level, origin)) {
            return false;
        } else {
            return LevelUtils.setBlock(level, origin, rocks, 2);
        }
    }

    private BlockState getRocksToPlace(RandomSource randomSource, BlockState originState, BlockPos origin, Block ground) {
        Direction dir = Direction.Plane.HORIZONTAL.getRandomDirection(randomSource);
        int model = randomSource.nextInt(5);

        BlockState rocks = PVJBlocks.ROCKS.get().defaultBlockState();

        if(ground == Blocks.RED_SAND || ground == Blocks.RED_SANDSTONE) {
            rocks = PVJBlocks.RED_SANDSTONE_ROCKS.get().defaultBlockState();
        } else if(ground == Blocks.SAND || ground == Blocks.SANDSTONE) {
            rocks = PVJBlocks.SANDSTONE_ROCKS.get().defaultBlockState();
        } else if (randomSource.nextFloat() < 0.2F && origin.getY() > 8) {
            rocks = PVJBlocks.MOSSY_ROCKS.get().defaultBlockState();
        }
        rocks = rocks.setValue(GroundcoverBlock.FACING, dir).setValue(GroundcoverBlock.MODEL, model);

        if(originState.getFluidState().getType() == Fluids.WATER) {
            rocks = rocks.setValue(BlockStateProperties.WATERLOGGED, true);
        }

        return rocks;
    }
}
