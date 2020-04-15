package projectvibrantjourneys.common.entities.passive;

import java.util.Random;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class FireflyEntity extends FlyEntity {

	public FireflyEntity(EntityType<? extends FireflyEntity> entityType, World world) {
		super(entityType, world);
	}
	
	public static boolean canSpawnFirefly(EntityType<FireflyEntity> firefly, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
		if (pos.getY() < world.getSeaLevel()) {
			return false;
		} else if(world.getLight(pos) > 9) {
			return false;
		} else {
			return canSpawnOn(firefly, world, reason, pos, rand);
		}
	}
	
	@Override
	public float getBrightness() {
		return 1.0F;
	}
}
