package vibrantjourneys.blocks;

import java.util.Random;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockWall;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.util.IPropertyHelper;

public class BlockLantern extends Block implements IPropertyHelper
{
	public Type type;
	public static final PropertyBool HANGING = PropertyBool.create("hanging");
	
	public BlockLantern(Type type)
	{
		super(Material.ROCK);
		this.setSoundType(SoundType.STONE);
		this.setLightLevel(0.7F + (type == Type.LAVA ? 0.07F : 0.0F));
		this.type = type;
		this.setHardness(0.1F);
		this.setResistance(0.1F);
		this.setDefaultState(this.getBlockState().getBaseState().withProperty(HANGING, false));
	}
	
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
		if(type != Type.PAPER)
		{
			if(state.getValue(HANGING))
				return new AxisAlignedBB(0.3125D, 0.3125D, 0.3125D, 0.6875D, 1.0D, 0.6875D);
			
	        return new AxisAlignedBB(0.3125D, 0.0D, 0.3125D, 0.6875D, 0.6875D, 0.6875D);
		}
		else
		{
			if(state.getValue(HANGING))
				return new AxisAlignedBB(0.1875D, 0.125D, 0.1875D, 0.8125D, 1.0D, 0.8125D);
			
	        return new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 0.8125D, 0.625D, 0.8125D);
		}
    }
	
    @SideOnly(Side.CLIENT)
    @Override
    public void randomDisplayTick(IBlockState state, World worldIn, BlockPos pos, Random rand)
    {
        double x = (double)pos.getX() + 0.5D;
        double y;
        double z = (double)pos.getZ() + 0.5D;
        
        switch(type)
        {
        	case NORMAL:
    		default:
        		y = (double)pos.getY() + 0.16D;
        		break;
        	case CANDLE:
        		y = (double)pos.getY() + 0.55D;
        		break;
        	case LAVA:
        	case PAPER:
        		y = 0;
        		break;
        }
        
        if(state.getValue(HANGING))
        	y += 0.33D;

        if(type != Type.LAVA && type != Type.PAPER)
        {
            worldIn.spawnParticle(EnumParticleTypes.FLAME, x, y, z, 0.0D, 0.0D, 0.0D);
        }
    }
	
	@Override
    public boolean canPlaceBlockAt(World world, BlockPos pos)
    {
		return canPlaceLantern(world, pos);
    }
	
	private boolean canPlaceLantern(World world, BlockPos pos)
	{
		if(world.isSideSolid(pos.up(), EnumFacing.DOWN) || world.isSideSolid(pos.down(), EnumFacing.UP))
			return true;
		if(world.getBlockState(pos.up()).getBlock() instanceof BlockFence || world.getBlockState(pos.down()).getBlock() instanceof BlockFence)
			return true;
		if(world.getBlockState(pos.up()).getBlock() instanceof BlockWall || world.getBlockState(pos.down()).getBlock() instanceof BlockWall)
			return true;

		return false;
	}
	
	@Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
		if(canBlockStay(world, pos))
		{
			if(world.isSideSolid(pos.up(), EnumFacing.DOWN) || world.getBlockState(pos.up()).getBlock() instanceof BlockFence || world.getBlockState(pos.down()).getBlock() instanceof BlockWall)
			{
				world.setBlockState(pos, this.getDefaultState().withProperty(HANGING, true));
			}
			else
			{
				world.setBlockState(pos, this.getDefaultState().withProperty(HANGING, false));
			}
		}
		else
		{
			this.dropBlockAsItem(world, pos, state, 0);
			world.setBlockToAir(pos);
		}
    }
	
    private boolean canBlockStay(World world, BlockPos pos)
    {
        return canPlaceLantern(world, pos);
    }
    
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		if(world.isRemote)
		{
			return true;
		}
		else
		{
			if(player.isSneaking())
			{
				if(state.getValue(HANGING) && (world.isSideSolid(pos.down(), EnumFacing.UP) || world.getBlockState(pos.down()).getBlock() instanceof BlockFence || world.getBlockState(pos.down()).getBlock() instanceof BlockWall))
				{
					world.setBlockState(pos, this.getDefaultState().withProperty(HANGING, false));
				}
				else if(!state.getValue(HANGING) && (world.isSideSolid(pos.up(), EnumFacing.DOWN) || world.getBlockState(pos.up()).getBlock() instanceof BlockFence || world.getBlockState(pos.up()).getBlock() instanceof BlockWall))
				{
					world.setBlockState(pos, this.getDefaultState().withProperty(HANGING, true));
				}
			}
		}
		return true;
    }
	
	@Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand)
    {
		if(world.getBlockState(pos.up()).getBlock() instanceof BlockFence || world.getBlockState(pos.up()).getBlock() instanceof BlockWall)
		{
			return this.getDefaultState().withProperty(HANGING, true);
		}
		else
		{
			return this.getDefaultState();
		}
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
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return true;
    }
	
	@Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }
	
    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {HANGING});
    }
	
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(HANGING, meta == 0 ? false : true);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
    	return state.getValue(HANGING) ? 1 : 0;
    }
    
	@Override
    public int damageDropped(IBlockState state)
    {
        return 0;
    }
    
	public static enum Type
	{
		NORMAL,
		CANDLE,
		LAVA,
		PAPER;
	}

	@Override
	public ImmutableList<IBlockState> getProperties()
	{
		return this.getBlockState().getValidStates();
	}
}
