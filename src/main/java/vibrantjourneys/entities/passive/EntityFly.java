package vibrantjourneys.entities.passive;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.init.PVJSounds;
import vibrantjourneys.integration.sereneseasons.PVJSereneSeasons;
import vibrantjourneys.util.Reference;

public class EntityFly extends EntityAmbientCreature
{
    private BlockPos spawnPosition;
    
    public EntityFly(World worldIn)
    {
        super(worldIn);
        this.setSize(0.1F, 0.1F);
    }
    
	@Override
    public boolean canBePushed()
    {
        return false;
    }
    
	@Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
    }
    
	@Override
    public void onUpdate()
    {
        super.onUpdate();
        this.motionY *= 0.6000000238418579D;
        this.fallDistance = 0;

        if(!this.world.isRemote)
        {
	        if(this.world.isDaytime() && this instanceof EntityFirefly)
	        {
	        	if(this.getRNG().nextInt(500) == 0)
	        	{
	        		this.world.removeEntity(this);
	        	}
	        }
        }

    }
    
    //Taken from EntityBat
	@Override
    protected void updateAITasks()
    {
        super.updateAITasks();

		if (this.spawnPosition != null && (!this.world.isAirBlock(this.spawnPosition) || this.spawnPosition.getY() < 1))
		{
			this.spawnPosition = null;
		}

		if (this.spawnPosition == null || this.rand.nextInt(30) == 0
				|| this.spawnPosition.distanceSq((double) ((int) this.posX), (double) ((int) this.posY),
						(double) ((int) this.posZ)) < 4.0D)
		{
			this.spawnPosition = new BlockPos((int) this.posX + this.rand.nextInt(7) - this.rand.nextInt(7),
					(int) this.posY + this.rand.nextInt(6) - 2,
					(int) this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
		}
		
		if(!this.isInWater())
		{
			double d0 = (double) this.spawnPosition.getX() + 0.5D - this.posX;
			double d1 = (double) this.spawnPosition.getY() + 0.1D - this.posY;
			double d2 = (double) this.spawnPosition.getZ() + 0.5D - this.posZ;
			this.motionX += (Math.signum(d0) * 0.5D - this.motionX) * 0.10000000149011612D;
			this.motionY += (Math.signum(d1) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
			this.motionZ += (Math.signum(d2) * 0.5D - this.motionZ) * 0.10000000149011612D;
			float f = (float) (MathHelper.atan2(this.motionZ, this.motionX) * (180D / Math.PI)) - 90.0F;
			float f1 = MathHelper.wrapDegrees(f - this.rotationYaw);
			this.moveForward = 0.5F;
			this.rotationYaw += f1;
			
	        if(world.getBlockState(this.getPosition()).getBlock() == PVJBlocks.sundew)
	        {
	        	this.motionX = 0;
	        	this.motionY = 0;
	        	this.motionZ = 0;
	        	
	        	if(this.getRNG().nextInt(1000) == 0)
	        	{
	        		this.attackEntityFrom(DamageSource.CACTUS, 5.0F);
	        	}
	        }
		}
		else
		{
        	this.motionX = (this.rand.nextDouble() - this.rand.nextDouble()) / 100.0;
        	this.motionY = 0;
        	this.motionZ = (this.rand.nextDouble() - this.rand.nextDouble()) / 100.0;
        	
        	if(this.getRNG().nextInt(2000) == 0)
        	{
        		world.removeEntity(this);
        	}
		}
    }
    
	@Override
    public boolean doesEntityNotTriggerPressurePlate()
    {
        return true;
    }
	
	@Override
    protected SoundEvent getAmbientSound()
    {
        return PVJSounds.FLY_AMBIENT;
    }
	
	@Override
    protected void playStepSound(BlockPos pos, Block blockIn)
    {
		
    }
	
	@Override
    protected SoundEvent getDeathSound()
    {
        return null;
    }
	
    //Forces client to render the firefly over large distances
    @SideOnly(Side.CLIENT)
    @Override
    public boolean isInRangeToRenderDist(double distance)
    {
    	return true;
    }
    
	@Override
    public boolean getCanSpawnHere()
    {
		if(this.world.provider.getDimensionType() != DimensionType.OVERWORLD)
			return false;
		
        BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);

        if (blockpos.getY() <= this.world.getSeaLevel())
        {
            return false;
        }
        
        Biome biome = world.getBiomeForCoordsBody(this.getPosition());
        if(BiomeDictionary.hasType(biome, Type.SNOWY))
        	return false;
        
        if(Reference.isSereneSeasonsLoaded)
        	if(PVJSereneSeasons.canSnowHere(getEntityWorld(), getPosition()))
        		return false;
        
		Block block = this.getEntityWorld().getBlockState(this.getPosition().down()).getBlock();
		if(block != Blocks.GRASS)
			return false;
        
		return super.getCanSpawnHere();
    }
}
