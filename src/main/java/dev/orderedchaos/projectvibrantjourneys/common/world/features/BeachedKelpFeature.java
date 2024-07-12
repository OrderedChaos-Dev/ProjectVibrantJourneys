package dev.orderedchaos.projectvibrantjourneys.common.world.features;

import com.mojang.serialization.Codec;
import dev.orderedchaos.projectvibrantjourneys.common.blocks.BeachedKelpBlock;
import dev.orderedchaos.projectvibrantjourneys.common.blocks.properties.BeachedKelpShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;

public class BeachedKelpFeature extends Feature<BlockStateConfiguration> {

    public BeachedKelpFeature(Codec<BlockStateConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<BlockStateConfiguration> context) {
        BlockStateConfiguration config = context.config();
        RandomSource random = context.random();
        BlockPos origin = context.origin();
        WorldGenLevel level = context.level();
        BlockState state = config.state;
        if (!(config.state.getBlock() instanceof BeachedKelpBlock)) {
            // silently fail if not beached kelp block
            return false;
        }

        Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
        int length = random.nextInt(3);

        boolean hasSpace = checkHasSpace(level, origin, direction, length);
        if (!hasSpace) {
            return false;
        }

        state = state.setValue(BeachedKelpBlock.FACING, direction);
        BlockPos.MutableBlockPos pos = origin.mutable();
        level.setBlock(pos, state.setValue(BeachedKelpBlock.KELP_SHAPE, BeachedKelpShape.TOP), 2);
        for (int i = 0; i < length; i++) {
            pos.move(direction.getOpposite());
            level.setBlock(pos, state.setValue(BeachedKelpBlock.KELP_SHAPE, BeachedKelpShape.STRAIGHT), 2);
        }
        pos.move(direction.getOpposite());
        level.setBlock(pos, state.setValue(BeachedKelpBlock.KELP_SHAPE, BeachedKelpShape.CURVED), 2);
        pos.move(direction.getCounterClockWise());
        level.setBlock(pos, state.setValue(BeachedKelpBlock.KELP_SHAPE, BeachedKelpShape.END), 2);

        return true;
    }

    private boolean checkHasSpace(WorldGenLevel level, BlockPos origin, Direction direction, int length) {
        int totalLength = length + 2;
        BlockPos.MutableBlockPos pos = origin.mutable();
        for (int i = 0; i < totalLength; i++) {
            pos = pos.move(direction.getOpposite());
            if (!level.isEmptyBlock(pos) || !Block.canSupportRigidBlock(level, pos.below())) {
                return false;
            }
        }
        pos.move(direction.getCounterClockWise());
        if (!level.isEmptyBlock(pos) || !Block.canSupportRigidBlock(level, pos.below())) {
            return false;
        }
        return true;
    }
}
