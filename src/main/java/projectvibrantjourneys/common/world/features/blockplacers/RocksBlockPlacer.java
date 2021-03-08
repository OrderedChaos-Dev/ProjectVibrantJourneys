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
import projectvibrantjourneys.init.PVJBlocks;

public class RocksBlockPlacer extends BlockPlacer {
	public static final Codec<RocksBlockPlacer> CODEC;
	public static final RocksBlockPlacer PLACER = new RocksBlockPlacer();

	protected BlockPlacerType<?> getBlockPlacerType() {
		return BlockPlacerType.SIMPLE_BLOCK;
	}

	public void place(IWorld world, BlockPos pos, BlockState state, Random random) {
		BlockState ground = world.getBlockState(pos.down());
		Block block = ground.getBlock();
		if (ground.isOpaqueCube(world, pos) && ground.isSolid() && block != Blocks.SNOW) {
			if(block == Blocks.SAND) {
				world.setBlockState(pos, PVJBlocks.sandstone_rocks.getDefaultState().with(GroundcoverBlock.MODEL,  random.nextInt(5)), 2);
			} else if(block == Blocks.RED_SAND) {
				world.setBlockState(pos, PVJBlocks.red_sandstone_rocks.getDefaultState().with(GroundcoverBlock.MODEL, random.nextInt(5)), 2);
			} else if(!BiomeDictionary.hasType(RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, world.getBiome(pos).getRegistryName()), Type.DRY) && random.nextDouble() < 0.2){
				world.setBlockState(pos, PVJBlocks.mossy_rocks.getDefaultState().with(GroundcoverBlock.MODEL, random.nextInt(5)), 2);
			} else {
				world.setBlockState(pos, state.with(GroundcoverBlock.MODEL, random.nextInt(5)), 2);
			}
		}

	}

	static {
		CODEC = Codec.unit(() -> {
			return PLACER;
		});
	}
}
