package projectvibrantjourneys.common.world.placers;

import java.util.Random;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.blockplacer.BlockPlacer;
import net.minecraft.world.gen.blockplacer.BlockPlacerType;
import projectvibrantjourneys.common.blocks.FallenLeavesBlock;
import projectvibrantjourneys.common.blocks.GroundcoverBlock;

public class GroundcoverPlacer extends BlockPlacer {
	public GroundcoverPlacer() {
		super(BlockPlacerType.field_227259_a_);
	}

	public <T> GroundcoverPlacer(Dynamic<T> d) {
		this();
	}

	public void func_225567_a_(IWorld world, BlockPos pos, BlockState state, Random rand) {
		if (world.getBlockState(pos.down()).isOpaqueCube(world, pos)) {
			if (state.getBlock() instanceof FallenLeavesBlock) {
				world.setBlockState(pos, state, 2);
			} else {
				world.setBlockState(pos, state.with(GroundcoverBlock.MODEL, rand.nextInt(5)), 2);
			}
		}
	}

	public <T> T serialize(DynamicOps<T> dyn) {
		return (new Dynamic<>(dyn,
				dyn.createMap(ImmutableMap.of(dyn.createString("type"),
						dyn.createString(Registry.field_229388_u_.getKey(this.field_227258_a_).toString())))))
								.getValue();
	}
}