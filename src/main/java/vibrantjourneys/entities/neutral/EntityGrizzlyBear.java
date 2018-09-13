package vibrantjourneys.entities.neutral;

import javax.annotation.Nullable;

import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import vibrantjourneys.util.PVJLootTableList;

public class EntityGrizzlyBear extends EntityPolarBear
{
	public EntityGrizzlyBear(World worldIn)
	{
		super(worldIn);
	}
	
    @Nullable
    @Override
    protected ResourceLocation getLootTable()
    {
        return PVJLootTableList.GRIZZLY_BEAR;
    }
}
