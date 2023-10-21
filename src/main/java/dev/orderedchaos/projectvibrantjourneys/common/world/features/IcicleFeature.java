package dev.orderedchaos.projectvibrantjourneys.common.world.features;

import com.mojang.serialization.Codec;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import dev.orderedchaos.projectvibrantjourneys.util.LevelUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.function.Consumer;

public class IcicleFeature extends Feature<NoneFeatureConfiguration> {

    private static final int MAX_LENGTH = 4;

    public IcicleFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        LevelAccessor level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        int height = checkVerticalSpace(level, origin, random.nextInt(4) + 1);
        if(height == 0)
            return false;

        growIcicle(level, origin, Direction.DOWN, height);


        return true;
    }

    private int checkVerticalSpace(LevelAccessor level, BlockPos pos, int height) {
        Direction dir = Direction.DOWN;
        BlockPos.MutableBlockPos mutable = pos.mutable();
        int temp = 0;
        while(temp < height && level.isEmptyBlock(mutable)) {
            temp++;
            mutable.move(dir);
        }

        return Math.min(temp, MAX_LENGTH);
    }

    private void buildBaseToTipColumn(Direction dir, int height, Consumer<BlockState> consumer) {
        if (height >= 3) {
            consumer.accept(createIcicle(dir, DripstoneThickness.BASE));

            for(int i = 0; i < height - 3; ++i) {
                consumer.accept(createIcicle(dir, DripstoneThickness.MIDDLE));
            }
        }

        if (height >= 2) {
            consumer.accept(createIcicle(dir, DripstoneThickness.FRUSTUM));
        }

        if (height >= 1) {
            consumer.accept(createIcicle(dir,  DripstoneThickness.TIP));
        }

    }

    private void growIcicle(LevelAccessor level, BlockPos pos, Direction dir, int height) {
        if (level.getBlockState(pos.relative(dir.getOpposite())).isCollisionShapeFullBlock(level, pos.relative(dir.getOpposite()))) {
            BlockPos.MutableBlockPos blockpos$mutableblockpos = pos.mutable();
            buildBaseToTipColumn(dir, height, (state) -> {
                LevelUtils.setBlock(level, blockpos$mutableblockpos, state, 2);
                blockpos$mutableblockpos.move(dir);
            });
        }
    }

    private BlockState createIcicle(Direction dir, DripstoneThickness thickness) {
        return PVJBlocks.ICICLE.get().defaultBlockState().setValue(PointedDripstoneBlock.TIP_DIRECTION, dir)
                .setValue(PointedDripstoneBlock.THICKNESS, thickness);
    }
}