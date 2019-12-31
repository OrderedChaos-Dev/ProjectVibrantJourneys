package projectvibrantjourneys.common.world.placers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.blockplacer.BlockPlacer;
import net.minecraft.world.gen.blockplacer.BlockPlacerType;
import projectvibrantjourneys.common.blocks.GroundcoverBlock;
import projectvibrantjourneys.init.PVJBlocks;

public class RocksPlacer extends BlockPlacer {
	
	private List<Block> rocks;
	
	public RocksPlacer() {
		super(BlockPlacerType.field_227259_a_);
		rocks = new ArrayList<Block>();
		rocks.add(PVJBlocks.rocks);
		rocks.add(PVJBlocks.andesite_rocks);
		rocks.add(PVJBlocks.granite_rocks);
		rocks.add(PVJBlocks.diorite_rocks);
	}

	public <T> RocksPlacer(Dynamic<T> d) {
		this();
	}

	public void func_225567_a_(IWorld world, BlockPos pos, BlockState state, Random rand) {
		if (world.getBlockState(pos.down()).isSolid()) {
			BlockState block = rocks.get(rand.nextInt(rocks.size())).getDefaultState();
			world.setBlockState(pos, block.with(GroundcoverBlock.MODEL, rand.nextInt(5)), 2);
		}
	}

	public <T> T serialize(DynamicOps<T> dyn) {
		return (new Dynamic<>(dyn,
				dyn.createMap(ImmutableMap.of(dyn.createString("type"),
						dyn.createString(Registry.field_229388_u_.getKey(this.field_227258_a_).toString())))))
								.getValue();
	}
}