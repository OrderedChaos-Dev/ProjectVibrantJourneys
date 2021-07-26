package projectvibrantjourneys.common.world.features.blockplacers;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.blockplacers.BlockPlacer;
import net.minecraft.world.level.levelgen.feature.blockplacers.BlockPlacerType;
import projectvibrantjourneys.common.blocks.FallenLeavesBlock;
import projectvibrantjourneys.common.blocks.GroundcoverBlock;
import projectvibrantjourneys.core.PVJConfig;
import projectvibrantjourneys.init.world.PVJBlockPlacers;

public class GroundcoverPlacer extends BlockPlacer {
	
	public static final Codec<GroundcoverPlacer> CODEC = Codec.unit(GroundcoverPlacer::new);

	@Override
	public void place(LevelAccessor world, BlockPos pos, BlockState state, Random rand) {
		if(rand.nextInt(100) < PVJConfig.groundcoverChance.get()) {
			if (world.getBlockState(pos.below()).isCollisionShapeFullBlock(world, pos) && world.getBlockState(pos.below()).getBlock() != Blocks.SNOW) {
				if (state.getBlock() instanceof FallenLeavesBlock) {
					world.setBlock(pos, state, 2);
				} else {
					int model = world.getRandom().nextInt(5);
					Direction facing = Direction.Plane.HORIZONTAL.getRandomDirection(world.getRandom());
					world.setBlock(pos, state.setValue(GroundcoverBlock.MODEL, model).setValue(GroundcoverBlock.FACING, facing), 2);
				}
			}
		}
	}

	@Override
	protected BlockPlacerType<?> type() {
		return PVJBlockPlacers.GROUNDCOVER_PLACER;
	}
}