package projectvibrantjourneys.common.world.features.treedecorators;

import java.util.List;
import java.util.Random;
import java.util.Set;

import com.mojang.serialization.Codec;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import projectvibrantjourneys.init.object.PVJBlocks;
import projectvibrantjourneys.init.world.PVJBlockPlacers;

public class CoconutDecorator extends TreeDecorator {
	
	public static final CoconutDecorator INSTANCE = new CoconutDecorator();
	public static final Codec<CoconutDecorator> CODEC = Codec.unit(() -> {
		return INSTANCE;
	});

	@Override
	protected TreeDecoratorType<?> type() {
		return PVJBlockPlacers.COCONUT_DECORATOR;
	}

	@Override
	public void place(ISeedReader world, Random rand, List<BlockPos> logs, List<BlockPos> leaves, Set<BlockPos> s, MutableBoundingBox box) {
		leaves.forEach((pos) -> {
			if(world.isStateAtPosition(pos.below(), (state) -> state.getMaterial().isReplaceable()) && rand.nextFloat() <= 0.15F)
				world.setBlock(pos.below(), PVJBlocks.coconut.defaultBlockState(), 19);
		});
	}
}
