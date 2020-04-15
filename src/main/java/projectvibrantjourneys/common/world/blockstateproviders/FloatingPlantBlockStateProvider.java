package projectvibrantjourneys.common.world.blockstateproviders;

import java.util.Random;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.BlockStateProviderType;
import projectvibrantjourneys.common.blocks.FloatingPlantBlock;

public class FloatingPlantBlockStateProvider extends BlockStateProvider {
	private final BlockState blockstate;

	public FloatingPlantBlockStateProvider(BlockState state) {
		super(BlockStateProviderType.SIMPLE_STATE_PROVIDER);
		this.blockstate = state;
	}

	public <T> FloatingPlantBlockStateProvider(Dynamic<T> p_i225861_1_) {
		this(BlockState.deserialize(p_i225861_1_.get("state").orElseEmptyMap()));
	}

	public BlockState getBlockState(Random rand, BlockPos pos) {
		int model = rand.nextInt(4);
		return blockstate.with(FloatingPlantBlock.MODEL, model);
	}

	public <T> T serialize(DynamicOps<T> p_218175_1_) {
		Builder<T, T> builder = ImmutableMap.builder();
		builder.put(p_218175_1_.createString("type"),
				p_218175_1_.createString(Registry.BLOCK_STATE_PROVIDER_TYPE.getKey(this.blockStateProvider).toString()));
		return (new Dynamic<>(p_218175_1_, p_218175_1_.createMap(builder.build()))).getValue();
	}
}