package projectvibrantjourneys.common.world.features.blockplacers;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.blockplacers.BlockPlacer;
import net.minecraft.world.level.levelgen.feature.blockplacers.BlockPlacerType;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.common.blocks.GroundcoverBlock;
import projectvibrantjourneys.core.PVJConfig;
import projectvibrantjourneys.init.object.PVJBlocks;
import projectvibrantjourneys.init.world.PVJBlockPlacers;

public class RocksBlockPlacer extends BlockPlacer {
	public static final Codec<RocksBlockPlacer> CODEC;
	public static final RocksBlockPlacer PLACER = new RocksBlockPlacer();

	protected BlockPlacerType<?> type() {
		return PVJBlockPlacers.ROCKS_BLOCK_PLACER;
	}

	public void place(LevelAccessor world, BlockPos pos, BlockState state, Random rand) {
		BlockState ground = world.getBlockState(pos.below());
		Block block = ground.getBlock();
		if(rand.nextInt(100) < PVJConfig.groundcoverChance.get()) {
			if (ground.isSolidRender(world, pos) && ground.isCollisionShapeFullBlock(world, pos) && block != Blocks.SNOW) {
				if(block == Blocks.SAND) {
					world.setBlock(pos, PVJBlocks.sandstone_rocks.defaultBlockState().setValue(GroundcoverBlock.MODEL,  rand.nextInt(5)), 2);
				} else if(block == Blocks.RED_SAND) {
					world.setBlock(pos, PVJBlocks.red_sandstone_rocks.defaultBlockState().setValue(GroundcoverBlock.MODEL, rand.nextInt(5)), 2);
				} else if(!BiomeDictionary.hasType(ResourceKey.create(ForgeRegistries.Keys.BIOMES, world.getBiome(pos).getRegistryName()), Type.DRY) && rand.nextDouble() < 0.2){
					world.setBlock(pos, PVJBlocks.mossy_rocks.defaultBlockState().setValue(GroundcoverBlock.MODEL, rand.nextInt(5)), 2);
				} else {
					world.setBlock(pos, state.setValue(GroundcoverBlock.MODEL, rand.nextInt(5)), 2);
				}
			}
		}
	}

	static {
		CODEC = Codec.unit(() -> {
			return PLACER;
		});
	}
}
