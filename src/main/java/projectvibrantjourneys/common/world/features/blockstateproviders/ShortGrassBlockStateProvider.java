package projectvibrantjourneys.common.world.features.blockstateproviders;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import projectvibrantjourneys.common.blocks.ShortGrassBlock;
import projectvibrantjourneys.init.object.PVJBlocks;
import projectvibrantjourneys.init.world.PVJBlockPlacers;

public class ShortGrassBlockStateProvider extends SimpleStateProvider {
	
	public static final Codec<ShortGrassBlockStateProvider> CODEC = Codec.unit(ShortGrassBlockStateProvider::new);

	public ShortGrassBlockStateProvider() {
		super(PVJBlocks.short_grass.defaultBlockState());
	}

	@Override
	protected BlockStateProviderType<?> type() {
		return PVJBlockPlacers.SHORT_GRASS_BLOCK_STATE_PROVIDER;
	}

	@Override
	public BlockState getState(Random random, BlockPos pos) {
		return PVJBlocks.short_grass.defaultBlockState().setValue(ShortGrassBlock.MODEL, random.nextInt(7));
	}

}
