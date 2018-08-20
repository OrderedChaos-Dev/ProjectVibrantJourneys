package vibrantjourneys.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockChimney extends Block
{
	public BlockChimney()
	{
		super(Material.ROCK);
		this.setResistance(10.0F);
		this.setHardness(2.3F);
		this.setSoundType(SoundType.STONE);
	}
	
    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
    	if(face == EnumFacing.UP || face == EnumFacing.DOWN)
    		return BlockFaceShape.UNDEFINED;
    	
        return BlockFaceShape.SOLID;
    }
	
	public boolean isSmokeSource(World world, BlockPos pos)
	{
		Block block = world.getBlockState(pos.down()).getBlock();
		if(block instanceof BlockFire || block == Blocks.LIT_FURNACE) return true;
		
		block = world.getBlockState(pos.north()).getBlock();
		if(block instanceof BlockFire || block == Blocks.LIT_FURNACE) return true;
		
		block = world.getBlockState(pos.west()).getBlock();
		if(block instanceof BlockFire || block == Blocks.LIT_FURNACE) return true;
		
		block = world.getBlockState(pos.south()).getBlock();
		if(block instanceof BlockFire || block == Blocks.LIT_FURNACE) return true;
		
		block = world.getBlockState(pos.east()).getBlock();
		if(block instanceof BlockFire || block == Blocks.LIT_FURNACE) return true;
		
		return false;
	}
	
	public boolean canSmoke(World world, BlockPos pos)
	{
		IBlockState state = world.getBlockState(pos.up());
		if(state.getBlockFaceShape(world, pos, EnumFacing.DOWN) == BlockFaceShape.SOLID || state.getBlock() instanceof BlockChimney)
		{
			return false;
		}
		else
		{
			if(isSmokeSource(world, pos)) return true;
			else
			{
				while(world.getBlockState(pos.down()).getBlock() instanceof BlockChimney)
				{
					pos = pos.down();
					
					if(((BlockChimney)world.getBlockState(pos).getBlock()).isSmokeSource(world, pos))
						return true;
				}
			}
		}
		
		return false;
	}
	
    @SideOnly(Side.CLIENT)
    @Override
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand)
    {
        double x = (double)pos.getX() + 0.5D;
        double y = (double)pos.getY() + 0.95D;
        double z = (double)pos.getZ() + 0.5D;
        
        if(canSmoke(world, pos) && !(world.getBlockState(pos.up()).getBlock() instanceof BlockChimneyTop))
        {
        	double xPos = x + (0.2 * rand.nextDouble()) - (0.2 * rand.nextDouble());
        	double zPos = z + (0.2 * rand.nextDouble()) - (0.2 * rand.nextDouble());
        	
        	for(int i = 0; i < 10; i++)
        	{
                world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, true, xPos, y, zPos, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, true, xPos, y, zPos, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, true, xPos, y, zPos, 0.0D, 0.0D, 0.0D);
        	}
        }
    }
    
	@Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return true;
    }
}
