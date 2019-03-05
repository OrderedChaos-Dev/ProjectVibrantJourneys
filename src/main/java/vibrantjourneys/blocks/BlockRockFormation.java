package vibrantjourneys.blocks;

import java.util.ArrayList;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.util.IPropertyHelper;

public class BlockRockFormation extends Block implements IPropertyHelper
{
	public static final PropertyInteger SIZE = PropertyInteger.create("size", 0, 2);
	public static final ArrayList<Block> VALID_SPAWN_BLOCKS = new ArrayList<Block>();
	
	static
	{
		VALID_SPAWN_BLOCKS.add(Blocks.STONE);
		VALID_SPAWN_BLOCKS.add(Blocks.ICE);
		VALID_SPAWN_BLOCKS.add(Blocks.PACKED_ICE);
		VALID_SPAWN_BLOCKS.add(Blocks.BEDROCK);
	}
	
	public BlockRockFormation()
	{
		super(Material.ROCK);
		this.setHardness(0.85F);
		this.setResistance(0.1F);
		this.setSoundType(SoundType.STONE);
		this.setDefaultState(this.blockState.getBaseState().withProperty(SIZE, 0));
	}
	
	@Override
    public boolean canPlaceBlockAt(World world, BlockPos pos)
    {
		if(world.isSideSolid(pos.up(), EnumFacing.DOWN))
			return true;
		if(world.isSideSolid(pos.down(), EnumFacing.UP))
			return true;
		if(world.getBlockState(pos.up()).getBlock() instanceof BlockRockFormation || world.getBlockState(pos.down()).getBlock() instanceof BlockRockFormation)
			return true;
		
		return false;
    }
	
	@Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
		if(!canPlaceBlockAt(world, pos))
		{
			world.setBlockToAir(pos);
		}
    }
	
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand)
    {
    	if(state.getValue(SIZE) == 2)
    	{
    		if(world.isAirBlock(pos.down()))
    		{
    			if(rand.nextInt(5) == 0)
    			{
    				double x = pos.getX() + 0.5;
    				double z = pos.getZ() + 0.5;
    				world.spawnParticle(EnumParticleTypes.DRIP_WATER, x, pos.getY(), z, 0, 0, 0, new int[0]);
    			}
    		}
    	}
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
    	int meta = state.getValue(SIZE);
    	if(meta == 0)
    		return new AxisAlignedBB(0.1875, 0, 0.1875, 0.8125, 1, 0.8125);
    	else if(meta == 1)
    		return new AxisAlignedBB(0.3125, 0, 0.3125, 0.6875, 1, 0.6875);
    	else
    		return new AxisAlignedBB(0.4375, 0, 0.4375, 0.5625, 1, 0.5625);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
    	int meta = state.getValue(SIZE);
    	if(meta == 0)
    		return new AxisAlignedBB(0.1875, 0, 0.1875, 0.8125, 1, 0.8125);
    	else if(meta == 1)
    		return new AxisAlignedBB(0.3125, 0, 0.3125, 0.6875, 1, 0.6875);
    	else
    		return new AxisAlignedBB(0.4375, 0, 0.4375, 0.5625, 1, 0.5625);
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
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.AIR;
    }
	
	@Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(SIZE, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
    	return state.getValue(SIZE);
    }
	
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {SIZE});
    }
    
	@Override
	public ImmutableList<IBlockState> getProperties()
	{
		return this.blockState.getValidStates();
	}
}
