package vibrantjourneys.entities.ai;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 * 
 * Used by spooky ghosts as a way to move out of lit areas
 *
 */
public class EntityAIAvoidLight extends EntityAIBase
{
    private final EntityCreature creature;
    private double shelterX;
    private double shelterY;
    private double shelterZ;
    private final double movementSpeed;
    private final World world;

    public EntityAIAvoidLight(EntityCreature theCreatureIn, double movementSpeedIn)
    {
        this.creature = theCreatureIn;
        this.movementSpeed = movementSpeedIn;
        this.world = theCreatureIn.world;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute()
    {
        BlockPos blockpos = new BlockPos(creature.posX, creature.getEntityBoundingBox().minY, creature.posZ);
        int i = this.world.getLightFromNeighbors(blockpos);
        
        if (i <= 7)
        {
            return false;
        }
        else
        {
            Vec3d vec3d = this.findDark();

            if (vec3d == null)
            {
                return false;
            }
            else
            {
                this.shelterX = vec3d.x;
                this.shelterY = vec3d.y;
                this.shelterZ = vec3d.z;
                return true;
            }
        }
    }

    @Override
    public boolean shouldContinueExecuting()
    {
        return !this.creature.getNavigator().noPath();
    }

    @Override
    public void startExecuting()
    {
        this.creature.getNavigator().tryMoveToXYZ(this.shelterX, this.shelterY, this.shelterZ, this.movementSpeed);
    }

    @Nullable
    private Vec3d findDark()
    {
        Random random = this.creature.getRNG();
        BlockPos blockpos = new BlockPos(this.creature.posX, this.creature.getEntityBoundingBox().minY, this.creature.posZ);

        for (int i = 0; i < 10; ++i)
        {
        	//search 20x6x20 area
            BlockPos blockpos1 = blockpos.add(random.nextInt(20) - 10, random.nextInt(6) - 3, random.nextInt(20) - 10);
            int brightness = this.world.getLightFromNeighbors(blockpos1);

            if (brightness < 7 && this.creature.getBlockPathWeight(blockpos1) < 0.0F)
            {
                return new Vec3d((double)blockpos1.getX(), (double)blockpos1.getY(), (double)blockpos1.getZ());
            }
        }

        return null;
    }
}