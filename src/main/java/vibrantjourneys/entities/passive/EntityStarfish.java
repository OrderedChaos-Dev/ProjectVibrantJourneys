package vibrantjourneys.entities.passive;

import javax.annotation.Nullable;

import net.minecraft.block.material.Material;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import vibrantjourneys.entities.ai.EntityAIWaterCreatureWander;

public class EntityStarfish extends EntityPVJWaterCreature
{
    private static final DataParameter<Integer> COLOR = EntityDataManager.<Integer>createKey(EntityStarfish.class, DataSerializers.VARINT);
	
    public EntityStarfish(World worldIn)
    {
        super(worldIn);
        this.setSize(0.3F, 0.3F);
        this.setPathPriority(PathNodeType.WATER, 1.0F);
    }
    
    @Override
    protected void entityInit()
    {
    	super.entityInit();
    	this.dataManager.register(COLOR, 0);
    }
    
	@Override
    protected void initEntityAI()
    {
		this.tasks.addTask(1, new EntityAIWaterCreatureWander(this, 1.0D));
    }
	
	
	public int getColor()
	{
		return this.dataManager.get(COLOR).intValue();
	}
	
    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setInteger("Color", getColor());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.dataManager.set(COLOR, compound.getInteger("Color"));
    }
    
	@Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
    }
	
	/**
	 * Used in PVJEvents when starfish are spawned from a placeholder entity
	 */
	public void setRandomColor()
	{
		this.dataManager.set(COLOR, this.rand.nextInt(6) + 1);
	}
	
    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
    {
        livingdata = super.onInitialSpawn(difficulty, livingdata);
        this.setRandomColor();
        BlockPos pos = new BlockPos(this.getPosition());
        while(world.getBlockState(pos).getMaterial() == Material.WATER)
        {
        	pos = pos.down();
        }
        this.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
        
        return livingdata;
    }
	
    @Override
    protected PathNavigate createNavigator(World worldIn)
    {
        return new PathNavigateClimber(this, worldIn);
    }
    
    @Override
    public int getMaxSpawnedInChunk()
    {
        return 3;
    }
	
	@Override
    public boolean getCanSpawnHere()
    {
		if(this.world.provider.getDimensionType() != DimensionType.OVERWORLD)
			return false;
		
		int x = (int)this.posX;
		int y = (int)this.posY;
		int z = (int)this.posZ;
		
		Chunk chunk = this.world.getChunk(new BlockPos(x, 0, z));
		
		int count = world.getEntitiesWithinAABB(EntityStarfish.class, new AxisAlignedBB(x - 15, y - 10, z - 15, x + 15, y + 10, z + 15)).size();
		if(count <= 1 && this.rand.nextInt(5) == 0 && chunk.getRandomWithSeed(987234911L).nextInt(5) == 0)
			return true;
		
		return false;
    }
}