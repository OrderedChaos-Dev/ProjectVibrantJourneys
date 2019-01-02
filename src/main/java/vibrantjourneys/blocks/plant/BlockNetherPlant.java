package vibrantjourneys.blocks.plant;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class BlockNetherPlant extends BlockPVJPlant
{
	@Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        IBlockState soil = worldIn.getBlockState(pos.down());
        
        if(soil.getBlock() == Blocks.NETHERRACK)
        	return true;
        
        return super.canPlaceBlockAt(worldIn, pos) && soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), net.minecraft.util.EnumFacing.UP, this);
    }
	
    @Override
    public EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
    	return EnumPlantType.Nether;
    }
    
    @Override
    protected boolean canSustainBush(IBlockState state)
    {
        return state.getBlock() == Blocks.NETHERRACK || state.getBlock() == Blocks.SOUL_SAND;
    }
}
