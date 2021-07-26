package projectvibrantjourneys.common.world.features;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.material.Material;

public class FallenTreeFeature extends Feature<NoneFeatureConfiguration> {

	public FallenTreeFeature(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}
	
	public static final Set<Pair<String, Block>> LOGS = new HashSet<Pair<String, Block>>();

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		BlockPos pos = context.origin();
		Random rand = context.random();
		BlockState state = getLog(world, pos);
		if(state == null) {
			return false;
		}
		BlockState b = world.getBlockState(pos.below());
		if(b.getMaterial() == Material.ICE || b.getMaterial() == Material.ICE || b.getBlock() == Blocks.SNOW_BLOCK) return false;
		boolean branching = rand.nextBoolean();
		BlockPos temp = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
		List<BlockPos> positions = new ArrayList<BlockPos>();
		int length = rand.nextInt(3) + 4;

		Direction dir = Direction.Plane.HORIZONTAL.getRandomDirection(rand);

		while(length > 0) {
			if(world.getBlockState(pos).getMaterial().isReplaceable()) {
				positions.add(pos);	
				length--;
				pos = pos.offset(dir.getNormal());
				
				if(world.getBlockState(pos.below()).getMaterial().isReplaceable() || world.getBlockState(pos.below()).getBlock() == Blocks.WATER) {
					temp = temp.offset(dir.getOpposite().getNormal());
					if(world.getBlockState(temp).getMaterial().isReplaceable()) {
						positions.add(temp);
						length--;
					} else {
						return false;
					}
				}
				
			} else {
				return false;
			}
		}
		
		for(BlockPos p : positions) {
			world.setBlock(p, state.setValue(RotatedPillarBlock.AXIS, dir.getAxis()), 2);
			if(branching && rand.nextBoolean()) {
				Direction d = rand.nextBoolean() ? dir.getClockWise(): dir.getCounterClockWise();
				BlockPos branchPos = p.offset(d.getNormal());
				if(world.getBlockState(branchPos).getMaterial().isReplaceable() || world.isEmptyBlock(branchPos))
					world.setBlock(branchPos, state.setValue(RotatedPillarBlock.AXIS, d.getAxis()), 2);
				branching = false;
			}
		}
		return true;
	}
	
	private BlockState getLog(WorldGenLevel world, BlockPos pos) {
		Biome biome = world.getBiome(pos);
		List<Block> logs = LOGS.stream().filter((pair) -> pair.getFirst().equals(biome.getRegistryName().toString())).map((pair) -> pair.getSecond()).collect(Collectors.toList());
		if(logs.size() > 0)
			return logs.get(world.getRandom().nextInt(logs.size())).defaultBlockState();
		return null;
	}
}
