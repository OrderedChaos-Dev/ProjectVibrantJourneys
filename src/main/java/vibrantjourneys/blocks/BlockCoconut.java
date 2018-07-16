package vibrantjourneys.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import vibrantjourneys.init.PVJBlocks;

public class BlockCoconut extends Block
{
	public BlockCoconut()
	{
		super(Material.PLANTS);
		this.setHardness(0.4F);
		this.setResistance(7.0F);
		this.setSoundType(SoundType.WOOD);
	}

    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos.up());
        return iblockstate.getBlock() == PVJBlocks.palm_leaves;
    }

	@Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
	
	@Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
	
	@Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (!this.canBlockStay(worldIn, pos, state))
        {
            this.dropBlock(worldIn, pos, state);
        }
    }
	
    private void dropBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
        this.dropBlockAsItem(worldIn, pos, state, 0);
    }
}
