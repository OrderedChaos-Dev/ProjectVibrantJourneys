package vibrantjourneys.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCrystalThorn extends BlockPVJPlant
{
	public BlockCrystalThorn()
	{
		this.setLightLevel(0.65F);
	}
	
	@Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
    	entityIn.attackEntityFrom(DamageSource.CACTUS, 1);
    }
}
