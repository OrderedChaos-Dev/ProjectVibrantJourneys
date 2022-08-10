package com.projectvibrantjourneys.world.gen.features.treedecorators;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

import com.mojang.serialization.Codec;
import com.projectvibrantjourneys.init.object.PVJBlocks;
import com.projectvibrantjourneys.init.world.features.PVJTreePlacers;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class JuniperBerriesDecorator extends TreeDecorator {
	
	public static final JuniperBerriesDecorator INSTANCE = new JuniperBerriesDecorator();
	public static final Codec<JuniperBerriesDecorator> CODEC = Codec.unit(() -> {
		return INSTANCE;
	});

	@Override
	protected TreeDecoratorType<?> type() {
		return PVJTreePlacers.Decorator.JUNIPER_BERRIES_DECORATOR.get();
	}

	@Override
	public void place(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> placer, Random rand, List<BlockPos> logs, List<BlockPos> leaves) {
		leaves.forEach((pos) -> {
			if(rand.nextFloat() <= 0.2F)
				placer.accept(pos, PVJBlocks.berried_juniper_leaves.get().defaultBlockState());
		});
	}
}
