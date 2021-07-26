package projectvibrantjourneys.common.entities;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class FireflyEntity extends FlyEntity {
	
	public FireflyEntity(EntityType<? extends FireflyEntity> entityType, Level world) {
		super(entityType, world);
	}
	
	public static boolean canSpawnFirefly(EntityType<FireflyEntity> firefly, LevelAccessor world, MobSpawnType reason, BlockPos pos, Random rand) {
		if (pos.getY() < world.getSeaLevel()) {
			return false;
		} else if(world.getMaxLocalRawBrightness(pos) > 9) {
			return false;
		} else {
			return checkMobSpawnRules(firefly, world, reason, pos, rand);
		}
	}
	
	@Override
	public float getBrightness() {
		return 1.0F;
	}
}
