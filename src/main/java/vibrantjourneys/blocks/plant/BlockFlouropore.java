package vibrantjourneys.blocks.plant;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import vibrantjourneys.util.IPropertyHelper;

public class BlockFlouropore extends BlockBracketFungus implements IPropertyHelper
{
	public BlockFlouropore()
	{
		this.setLightLevel(0.3F);
	}
	
	@Override
    public boolean canBlockStay(World world, BlockPos pos, IBlockState state)
    {
        pos = pos.offset((EnumFacing)state.getValue(FACING).getOpposite());
        return world.isSideSolid(pos, state.getValue(FACING));
    }
}
