package vibrantjourneys.blocks.plant;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockLilyPad;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import vibrantjourneys.util.IPropertyHelper;

public class BlockFloatingPlant extends BlockLilyPad implements IPropertyHelper
{
	public static final PropertyInteger MODEL = PropertyInteger.create("model", 0, 3);
	
	public BlockFloatingPlant()
	{
		this.setSoundType(SoundType.PLANT);
	}
	
    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos)
    {
    	return EnumPlantType.Water;
    }
    
    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state)
    {
    	int i = world.rand.nextInt(4);
    	world.setBlockState(pos, getStateFromMeta(i));
    }
    
	@Override
    public int damageDropped(IBlockState state)
    {
        return 0;
    }
    
    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState)
    {
    }
    
    @Override
    public void onEntityCollision(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
    }
    
	@Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(MODEL, meta);
    }

	@Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(MODEL);
    }
    
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {MODEL});
    }
    
	@Override
	public ImmutableList<IBlockState> getProperties()
	{
		return this.blockState.getValidStates();
	}
}
