package vibrantjourneys.entities.monster;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import vibrantjourneys.entities.ai.EntityAIStareAt;

public class EntityWatcher extends EntityMob
{
	public EntityWatcher(World world)
	{
		super(world);
		this.setSize(1.0F, 1.0F);
	}

	@Override
    public void onUpdate()
    {
		super.onUpdate();
		//watchers don't move
		this.motionY = 0.0;
    }
	
	@Override
    protected void initEntityAI()
    {
		this.tasks.addTask(1, new EntityAIStareAt(this, EntityPlayer.class, 90.0F));
    }
	
	@Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
    }
	
	@Override
    public boolean getCanSpawnHere()
    {
		return world.isAirBlock(new BlockPos(this.posX, this.posY, this.posZ));
    }
}
