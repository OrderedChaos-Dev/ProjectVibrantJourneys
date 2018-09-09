package vibrantjourneys.blocks;

import java.util.Random;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.util.IPropertyHelper;

public class BlockCeilingLamp extends Block implements IPropertyHelper
{
    public static final PropertyBool POWERED = PropertyBool.create("powered");
    
	public BlockCeilingLamp()
	{
		super(Material.CIRCUITS);
		this.setSoundType(SoundType.STONE);
		this.setHardness(0.1F);
		this.setResistance(0.1F);
		this.setDefaultState(this.getBlockState().getBaseState().withProperty(POWERED, false));
	}
	
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
		return new AxisAlignedBB(0.1875D, 0.75D, 0.1875D, 0.8125D, 1.0D, 0.8125D);
    }
	
	@Override
    public int getLightValue(IBlockState state)
    {
		if(state.getValue(POWERED))
		{
			return 14;
		}
        return 0;
    }
	
	@Override
    public boolean canPlaceBlockAt(World world, BlockPos pos)
    {
		return world.isSideSolid(pos.up(), EnumFacing.DOWN);
    }
	
	@Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
		if(!canPlaceBlockAt(world, pos))
		{
			this.dropBlockAsItem(world, pos, state, 0);
			world.setBlockToAir(pos);
		}
    }
	
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        world.notifyNeighborsOfStateChange(pos, this, true);
        
        if(state.getValue(POWERED))
        {
        	world.setBlockState(pos, state.withProperty(POWERED, false), 3);
            world.playSound(player, pos, SoundEvents.BLOCK_WOOD_BUTTON_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.6F);
            return true;
        }
        else
        {
            world.setBlockState(pos, state.withProperty(POWERED, Boolean.valueOf(true)), 3);
            world.playSound(player, pos, SoundEvents.BLOCK_WOOD_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.3F, 0.6F);
            return true;
        }
    }
	
	@Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

	@Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
	
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {POWERED});
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }
    
	@Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(POWERED, meta == 0 ? false : true);
    }

	@Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(POWERED).booleanValue() ? 1 : 0;
    }
    
	@Override
	public ImmutableList<IBlockState> getProperties()
	{
		return this.blockState.getValidStates();
	}
}
