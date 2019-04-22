package vibrantjourneys.entities.passive;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
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
		
		Block block = this.getEntityWorld().getBlockState(this.getPosition().down()).getBlock();
		if(block != Blocks.SAND && block != Blocks.STONE) //sometimes i forget that stone beaches are a biome
			return false;
		
		return this.getEntityWorld().isSideSolid(this.getPosition().down(), EnumFacing.UP);
    }
}