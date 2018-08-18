package vibrantjourneys.entities.monster;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import vibrantjourneys.util.PVJLootTableList;

public class EntityIceCube extends EntitySlime
{
	public EntityIceCube(World world)
	{
		super(world);
	}
	
	@Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023D);
    }
	
	@Override
    public boolean isNotColliding()
    {
        return this.world.checkNoEntityCollision(this.getEntityBoundingBox(), this) && this.world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.world.containsAnyLiquid(this.getEntityBoundingBox());
    }

	@Override
    protected void setSlimeSize(int size, boolean resetHealth)
    {
        super.setSlimeSize(size, resetHealth);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue((double)(size * 3));
    }
	
	@Override
    protected EnumParticleTypes getParticleType()
    {
        return EnumParticleTypes.WATER_SPLASH;
    }
	
	@Override
    protected EntitySlime createInstance()
    {
        return new EntityIceCube(this.world);
    }
	
	@Override
    protected int getJumpDelay()
    {
        return this.rand.nextInt(15) + 20;
    }

	@Override
    protected void alterSquishAmount()
    {
        this.squishAmount *= 0.9F;
    }
	
	@Override
    protected void jump()
    {
        this.motionY = 0.4199999D + (this.getSlimeSize() * 0.05);
        this.isAirBorne = true;
    }
	
	@Override
    public void fall(float distance, float damageMultiplier){}
	
	@Override
    protected boolean canDamagePlayer()
    {
        return true;
    }
	
	@Override
    protected int getAttackStrength()
    {
        return super.getAttackStrength() + 1;
    }
	
	@Override
	protected ResourceLocation getLootTable()
	{
		return PVJLootTableList.ICE_CUBE;
	}
	
    protected boolean isValidLightLevel()
    {
        BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);

        if (this.world.getLightFor(EnumSkyBlock.SKY, blockpos) > this.rand.nextInt(32))
        {
            return false;
        }
        else
        {
            int i = this.world.getLightFromNeighbors(blockpos);

            if (this.world.isThundering())
            {
                int j = this.world.getSkylightSubtracted();
                this.world.setSkylightSubtracted(10);
                i = this.world.getLightFromNeighbors(blockpos);
                this.world.setSkylightSubtracted(j);
            }

            return i <= this.rand.nextInt(8);
        }
    }

	@Override
    public boolean getCanSpawnHere()
    {
		if(this.world.provider.getDimensionType() != DimensionType.OVERWORLD)
			return false;
        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL && this.isValidLightLevel() && super.getCanSpawnHere();
    }
}
