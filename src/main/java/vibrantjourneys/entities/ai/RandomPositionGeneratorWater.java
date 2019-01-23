package vibrantjourneys.entities.ai;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.material.Material;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import vibrantjourneys.entities.passive.EntityPVJWaterCreature;

public class RandomPositionGeneratorWater
{
    private static Vec3d staticVector = Vec3d.ZERO;

    /**
     * finds a random target within par1(x,z) and par2 (y) blocks
     */
    @Nullable
    public static Vec3d findRandomTarget(EntityPVJWaterCreature EntityPVJWaterCreatureIn, int xz, int y)
    {
        return findRandomTargetBlock(EntityPVJWaterCreatureIn, xz, y, (Vec3d)null);
    }

    @Nullable
    public static Vec3d getLandPos(EntityPVJWaterCreature p_191377_0_, int p_191377_1_, int p_191377_2_)
    {
        return generateRandomPos(p_191377_0_, p_191377_1_, p_191377_2_, (Vec3d)null, false);
    }

    /**
     * finds a random target within par1(x,z) and par2 (y) blocks in the direction of the point par3
     */
    @Nullable
    public static Vec3d findRandomTargetBlockTowards(EntityPVJWaterCreature EntityPVJWaterCreatureIn, int xz, int y, Vec3d targetVec3)
    {
        staticVector = targetVec3.subtract(EntityPVJWaterCreatureIn.posX, EntityPVJWaterCreatureIn.posY, EntityPVJWaterCreatureIn.posZ);
        return findRandomTargetBlock(EntityPVJWaterCreatureIn, xz, y, staticVector);
    }

    /**
     * finds a random target within par1(x,z) and par2 (y) blocks in the reverse direction of the point par3
     */
    @Nullable
    public static Vec3d findRandomTargetBlockAwayFrom(EntityPVJWaterCreature EntityPVJWaterCreatureIn, int xz, int y, Vec3d targetVec3)
    {
        staticVector = (new Vec3d(EntityPVJWaterCreatureIn.posX, EntityPVJWaterCreatureIn.posY, EntityPVJWaterCreatureIn.posZ)).subtract(targetVec3);
        return findRandomTargetBlock(EntityPVJWaterCreatureIn, xz, y, staticVector);
    }

    /**
     * searches 10 blocks at random in a within par1(x,z) and par2 (y) distance, ignores those not in the direction of
     * par3Vec3, then points to the tile for which creature.getBlockPathWeight returns the highest number
     */
    @Nullable
    private static Vec3d findRandomTargetBlock(EntityPVJWaterCreature EntityPVJWaterCreatureIn, int xz, int y, @Nullable Vec3d targetVec3)
    {
        return generateRandomPos(EntityPVJWaterCreatureIn, xz, y, targetVec3, true);
    }

    @Nullable
    private static Vec3d generateRandomPos(EntityPVJWaterCreature entity, int xy, int y, @Nullable Vec3d p_191379_3_, boolean p_191379_4_)
    {
        PathNavigate pathnavigate = entity.getNavigator();
        Random random = entity.getRNG();
        boolean flag;

        flag = false;

        boolean flag1 = false;
        float f = -99999.0F;
        int k1 = 0;
        int i = 0;
        int j = 0;

        for (int k = 0; k < 10; ++k)
        {
            int l = random.nextInt(2 * xy + 1) - xy;
            int i1 = random.nextInt(2 * y + 1) - y;
            int j1 = random.nextInt(2 * xy + 1) - xy;

            if (p_191379_3_ == null || (double)l * p_191379_3_.x + (double)j1 * p_191379_3_.z >= 0.0D)
            {

                BlockPos blockpos1 = new BlockPos((double)l + entity.posX, (double)i1 + entity.posY, (double)j1 + entity.posZ);

                if (!flag && pathnavigate.canEntityStandOnPos(blockpos1))
                {
                    if (!p_191379_4_)
                    {
                        blockpos1 = moveAboveSolid(blockpos1, entity);

                        if (isWaterDestination(blockpos1, entity))
                        {
                            continue;
                        }
                    }

                    float f1 = 1.0F;

                    if (f1 > f)
                    {
                        f = f1;
                        k1 = l;
                        i = i1;
                        j = j1;
                        flag1 = true;
                    }
                }
            }
        }

        if (flag1)
        {
            return new Vec3d((double)k1 + entity.posX, (double)i + entity.posY, (double)j + entity.posZ);
        }
        else
        {
            return null;
        }
    }

    private static BlockPos moveAboveSolid(BlockPos p_191378_0_, EntityPVJWaterCreature p_191378_1_)
    {
        if (!p_191378_1_.world.getBlockState(p_191378_0_).getMaterial().isSolid())
        {
            return p_191378_0_;
        }
        else
        {
            BlockPos blockpos;

            for (blockpos = p_191378_0_.up(); blockpos.getY() < p_191378_1_.world.getHeight() && p_191378_1_.world.getBlockState(blockpos).getMaterial().isSolid(); blockpos = blockpos.up())
            {
                ;
            }

            return blockpos;
        }
    }

    private static boolean isWaterDestination(BlockPos p_191380_0_, EntityPVJWaterCreature p_191380_1_)
    {
        return p_191380_1_.world.getBlockState(p_191380_0_).getMaterial() == Material.WATER;
    }
}