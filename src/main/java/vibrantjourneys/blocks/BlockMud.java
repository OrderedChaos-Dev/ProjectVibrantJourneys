package vibrantjourneys.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class BlockMud extends BlockFalling
{
	public BlockMud()
	{
		super(Material.GROUND);
		this.setHardness(0.6F);
		this.setSoundType(SoundType.GROUND);
	}
	
	@Override
    public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable)
    {
        if(plantable instanceof BlockSapling || plantable.getPlantType(world, pos.offset(direction)) == EnumPlantType.Plains)
        	return true;
        
        return false;
    }
	
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.875D, 1.0D);
    }
	

	@Override
    public void onEntityCollision(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
		if(!(entityIn instanceof EntityPig))
		{
	        entityIn.motionX *= 0.4D;
	        entityIn.motionZ *= 0.4D;	
		}
    }
}
