package vibrantjourneys.blocks.plant;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;

public class BlockPVJCactus extends BlockPVJPlant
{
    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos)
    {
    	return EnumPlantType.Desert;
    }
}
