package vibrantjourneys.entities.passive;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityFirefly extends EntityFly
{
    public EntityFirefly(World worldIn)
    {
        super(worldIn);
        this.setSize(0.1F, 0.1F);
    }
    
    //Make entity always bright
    @SideOnly(Side.CLIENT)
	@Override
    public int getBrightnessForRender()
    {
        return 15728880;
    }

	@Override
    public float getBrightness()
    {
        return 1.0F;
    }
    
	@Override
    public boolean getCanSpawnHere()
    {
		if(this.world.provider.getDimensionType() != DimensionType.OVERWORLD)
			return false;
        BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);

		Block block = this.getEntityWorld().getBlockState(this.getPosition().down()).getBlock();
		if(block != Blocks.GRASS)
			return false;
        
        if (blockpos.getY() <= this.world.getSeaLevel())
        {
            return false;
        }
        else
        {
            int i = this.world.getLightFromNeighbors(blockpos);
            int j = 5;

            return i > this.rand.nextInt(j) ? false : super.getCanSpawnHere();
        }
    }	
}
