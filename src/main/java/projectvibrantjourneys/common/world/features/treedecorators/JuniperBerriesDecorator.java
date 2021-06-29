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

public class JuniperBerriesDecorator extends TreeDecorator {
	
	public static final JuniperBerriesDecorator INSTANCE = new JuniperBerriesDecorator();
	public static final Codec<JuniperBerriesDecorator> CODEC = Codec.unit(() -> {
		return INSTANCE;
	});

	@Override
	protected TreeDecoratorType<?> type() {
		return PVJBlockPlacers.JUNIPER_BERRIES_DECORATOR;
	}

	@Override
	public void place(ISeedReader world, Random rand, List<BlockPos> logs, List<BlockPos> leaves, Set<BlockPos> s, MutableBoundingBox box) {
		leaves.forEach((pos) -> {
			if(rand.nextFloat() <= 0.2F)
				world.setBlock(pos, PVJBlocks.berried_juniper_leaves.defaultBlockState(), 19);
		});
	}
}
