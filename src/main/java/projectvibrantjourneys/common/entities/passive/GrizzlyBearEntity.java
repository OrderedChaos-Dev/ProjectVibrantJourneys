package projectvibrantjourneys.common.entities.passive;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class GrizzlyBearEntity extends PolarBearEntity {

	public GrizzlyBearEntity(EntityType<? extends PolarBearEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	public static boolean canSpawn(EntityType<GrizzlyBearEntity> entity, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
		Block block = world.getBlockState(pos.down()).getBlock();
		if(block != Blocks.GRASS_BLOCK && block != Blocks.DIRT && block != Blocks.COARSE_DIRT && block != Blocks.PODZOL)
			return false;
		return world.getLightSubtracted(pos, 0) > 8;
	}
}
