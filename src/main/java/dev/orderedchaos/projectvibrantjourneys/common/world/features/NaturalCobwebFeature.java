package dev.orderedchaos.projectvibrantjourneys.common.world.features;

import com.mojang.serialization.Codec;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import dev.orderedchaos.projectvibrantjourneys.util.LevelUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;

public class NaturalCobwebFeature extends Feature<ProbabilityFeatureConfiguration> {
    public NaturalCobwebFeature(Codec<ProbabilityFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<ProbabilityFeatureConfiguration> context) {
        WorldGenLevel world = context.level();
        BlockPos origin = context.origin();
        RandomSource randomSource = context.random();
        BlockPos.MutableBlockPos blockpos = new BlockPos.MutableBlockPos(origin.getX(), origin.getY(), origin.getZ());

        for (int i = 64; i < origin.getY() + 50; i++) {
            blockpos.set(origin);
            blockpos.move(randomSource.nextInt(4) - randomSource.nextInt(4), 0, randomSource.nextInt(4) - randomSource.nextInt(4));
            blockpos.setY(i);

            if (world.getBlockState(blockpos).getBlock() instanceof LeavesBlock) {
                if(world.isEmptyBlock(blockpos.below())) {
                    if(randomSource.nextFloat() < context.config().probability) {
                        return LevelUtils.setBlock(world, blockpos.below(), PVJBlocks.NATURAL_COBWEB.get().defaultBlockState(), 2);
                    }
                }
            }
        }

        return true;
    }
}