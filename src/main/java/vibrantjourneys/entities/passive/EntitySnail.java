package vibrantjourneys.entities.passive;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import vibrantjourneys.util.PVJLootTableList;

public class EntitySnail extends EntityPVJAnimal
{
    public EntitySnail(World worldIn)
    {
        super(worldIn);
        this.setSize(0.25F, 0.2F);
        this.setPathPriority(PathNodeType.WATER, -1.0F);
    }
    
	@Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAIWanderAvoidWater(this, 1.0D));
    }
    
	@Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
    }

	@Override
	protected ResourceLocation getLootTable()
	{
		return PVJLootTableList.SNAIL;
	}
	
	@Override
    public boolean getCanSpawnHere()
    {
		if(this.world.provider.getDimensionType() != DimensionType.OVERWORLD)
			return false;
		return super.getCanSpawnHere();
    }
}