package projectvibrantjourneys.common.world.features.blockstateproviders;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.blockstateprovider.BlockStateProviderType;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import projectvibrantjourneys.common.blocks.ShortGrassBlock;
import projectvibrantjourneys.init.object.PVJBlocks;

public class ShortGrassBlockStateProvider extends SimpleBlockStateProvider {

	public ShortGrassBlockStateProvider() {
		super(PVJBlocks.short_grass.defaultBlockState());
	}

	@Override
	protected BlockStateProviderType<?> type() {
		return BlockStateProviderType.SIMPLE_STATE_PROVIDER;
	}

	@Override
	public BlockState getState(Random random, BlockPos pos) {
		return PVJBlocks.short_grass.defaultBlockState().setValue(ShortGrassBlock.MODEL, random.nextInt(7));
	}

}
