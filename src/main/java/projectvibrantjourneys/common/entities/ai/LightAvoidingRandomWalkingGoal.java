package projectvibrantjourneys.common.entities.ai;

import javax.annotation.Nullable;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.util.math.Vec3d;

public class LightAvoidingRandomWalkingGoal extends RandomWalkingGoal {
	protected final float probability;

	public LightAvoidingRandomWalkingGoal(CreatureEntity creature, double speedIn) {
		this(creature, speedIn, 0.001F);
	}

	public LightAvoidingRandomWalkingGoal(CreatureEntity creature, double speedIn, float probabilityIn) {
		super(creature, speedIn);
		this.probability = probabilityIn;
	}

	@Nullable
	@Override
	protected Vec3d getPosition() {
		int light = this.creature.getEntityWorld().getLight(this.creature.getPosition());
		if(light > 8) {
			Vec3d vec3d = RandomPositionGenerator.getLandPos(this.creature, 15, 7);
			return vec3d == null ? super.getPosition() : vec3d;
		}else if (this.creature.isInWaterOrBubbleColumn()) {
			Vec3d vec3d = RandomPositionGenerator.getLandPos(this.creature, 15, 7);
			return vec3d == null ? super.getPosition() : vec3d;
		} else {
			return this.creature.getRNG().nextFloat() >= this.probability
					? RandomPositionGenerator.getLandPos(this.creature, 10, 7)
					: super.getPosition();
		}
	}
	
	@Override
	public boolean shouldExecute() {
		int light = this.creature.getEntityWorld().getLight(this.creature.getPosition());
		return light > 8 || super.shouldExecute();
	}
}