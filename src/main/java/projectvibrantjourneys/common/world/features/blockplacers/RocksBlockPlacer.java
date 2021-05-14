package projectvibrantjourneys.common.world.features.blockplacers;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.blockplacer.BlockPlacer;
import net.minecraft.world.gen.blockplacer.BlockPlacerType;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.common.blocks.GroundcoverBlock;
import projectvibrantjourneys.core.PVJConfig;
import projectvibrantjourneys.init.objectregistry.PVJBlocks;

public class RocksBlockPlacer extends BlockPlacer {
	public static final Codec<RocksBlockPlacer> CODEC;
	public static final RocksBlockPlacer PLACER = new RocksBlockPlacer();

	protected BlockPlacerType<?> type() {
		return BlockPlacerType.SIMPLE_BLOCK_PLACER;
	}

	public void place(IWorld world, BlockPos pos, BlockState state, Random rand) {
		BlockState ground = world.getBlockState(pos.below());
		Block block = ground.getBlock();
		if(rand.nextInt(100) < PVJConfig.groundcoverChance.get()) {
			if (ground.isSolidRender(world, pos) && ground.isCollisionShapeFullBlock(world, pos) && block != Blocks.SNOW) {
				if(block == Blocks.SAND) {
					world.setBlock(pos, PVJBlocks.sandstone_rocks.defaultBlockState().setValue(GroundcoverBlock.MODEL,  rand.nextInt(5)), 2);
				} else if(block == Blocks.RED_SAND) {
					world.setBlock(pos, PVJBlocks.red_sandstone_rocks.defaultBlockState().setValue(GroundcoverBlock.MODEL, rand.nextInt(5)), 2);
				} else if(!BiomeDictionary.hasType(RegistryKey.create(ForgeRegistries.Keys.BIOMES, world.getBiome(pos).getRegistryName()), Type.DRY) && rand.nextDouble() < 0.2){
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
