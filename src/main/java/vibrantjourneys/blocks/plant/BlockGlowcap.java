package vibrantjourneys.blocks.plant;

import java.util.Random;

import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockGlowcap extends BlockPVJMushroom
{
	public BlockGlowcap()
	{
		this.setLightLevel(0.75F);
	}
	
	@Override
    public boolean canBlockStay(World world, BlockPos pos, IBlockState state)
    {
        IBlockState iblockstate = world.getBlockState(pos.down());
        return iblockstate.getBlockFaceShape(world, pos.down(), EnumFacing.UP) == BlockFaceShape.SOLID;
    }
	
    @Override
    public boolean generateBigMushroom(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
    	return false;
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
    {
        return false;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        return false;
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state){}
}
