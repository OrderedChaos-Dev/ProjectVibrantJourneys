package vibrantjourneys.entities.passive;

import net.minecraft.util.EnumFacing;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

public class EntityBeachStarfish extends EntityStarfish
{
    public EntityBeachStarfish(World world)
    {
		super(world);
	}
	
	@Override
    public boolean getCanSpawnHere()
    {
		if(this.world.provider.getDimensionType() != DimensionType.OVERWORLD)
			return false;
		
		return this.getEntityWorld().isSideSolid(this.getPosition().down(), EnumFacing.UP);
    }
}