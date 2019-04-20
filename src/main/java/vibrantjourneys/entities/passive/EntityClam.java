package vibrantjourneys.entities.passive;

import javax.annotation.Nullable;

import net.minecraft.block.material.Material;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import vibrantjourneys.util.PVJLootTableList;

public class EntityClam extends EntityPVJWaterCreature
{
    public EntityClam(World worldIn)
    {
        super(worldIn);
        this.setSize(0.3F, 0.3F);
    }
    
    @Override
    protected void entityInit()
    {
    	super.entityInit();
    }
    
	@Override
    protected void initEntityAI()
    {
    }
	
	@Override
    protected boolean canDespawn()
    {
        return true;
    }
	
	@Override
    public void onEntityUpdate()
    {
		super.onEntityUpdate();
		if(this.getEntityWorld().getTotalWorldTime() % 80 == 0)
		{
			if(this.getEntityWorld().rand.nextInt(3) == 0)
			{
				for(int i = 0; i < 3; i++)
				{
					this.getEntityWorld().spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX, this.posY, this.posZ, 0, 0.1, 0);
				}
			}
		}
    }
	
    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
    }
    
	@Override
	protected ResourceLocation getLootTable()
	{
		return PVJLootTableList.CLAM;
	}
    
	@Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0D);
    }

    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
    {
        livingdata = super.onInitialSpawn(difficulty, livingdata);
        BlockPos pos = new BlockPos(this.getPosition());
        while(world.getBlockState(pos).getMaterial() == Material.WATER)
        {
        	pos = pos.down();
        }
        this.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
        
        this.rotationPitch = this.rand.nextFloat();
        
        return livingdata;
    }
	
	@Override
    public boolean getCanSpawnHere()
    {
		if(this.world.provider.getDimensionType() != DimensionType.OVERWORLD)
			return false;
		
		return true;
    }
}