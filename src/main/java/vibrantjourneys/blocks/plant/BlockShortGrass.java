package vibrantjourneys.blocks.plant;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.util.IPropertyHelper;
import vibrantjourneys.util.PVJConfig;

public class BlockShortGrass extends BlockBush implements IGrowable, IShearable, IPropertyHelper
{
	public static final PropertyInteger MODEL = PropertyInteger.create("model", 0, 6);
	
	public BlockShortGrass()
	{
        super(Material.VINE);
		this.setDefaultState(this.blockState.getBaseState().withProperty(MODEL, 0));
		this.setSoundType(SoundType.PLANT);
	}
	
	@Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state)
    {
		int random = world.rand.nextInt(7);
		IBlockState newState = this.getDefaultState().withProperty(MODEL, random);
		world.setBlockState(pos, newState);
    }
	
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
    }
	
	@Override
    protected boolean canSustainBush(IBlockState state)
    {
		return super.canSustainBush(state);
    }
	
	@Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
    	return MapColor.GRASS;
    }
	
	@Override
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        return super.canBlockStay(worldIn, pos, state);
    }

	@Override
    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos)
    {
        return true;
    }

	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.AIR;
    }

	@Override
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return 1 + random.nextInt(fortune * 2 + 1);
    }
	
	@Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack)
    {
        if (!worldIn.isRemote && stack.getItem() == Items.SHEARS)
        {
            player.addStat(StatList.getBlockStats(this));
            spawnAsEntity(worldIn, pos, new ItemStack(PVJBlocks.short_grass, 1, 0));
        }
        else
        {
            super.harvestBlock(worldIn, player, pos, state, te, stack);
        }
    }
	
	@Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        return true;
    }

	@Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        BlockDoublePlant.EnumPlantType blockdoubleplant$enumplanttype = BlockDoublePlant.EnumPlantType.GRASS;

        if (Blocks.DOUBLE_PLANT.canPlaceBlockAt(worldIn, pos))
        {
            Blocks.DOUBLE_PLANT.placeAt(worldIn, pos, blockdoubleplant$enumplanttype, 2);
        }
    }

	@Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(this, 1, 0);
    }
	
    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos)
    { 
    	return true;
    }
    
    @Override
    public NonNullList<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune)
    {
        return NonNullList.withSize(1, new ItemStack(this, 1, 0));
    }
    
    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
    	if(PVJConfig.misc.doGrassDropSeeds)
    	{
            if (RANDOM.nextInt(8) != 0) return;
            ItemStack seed = net.minecraftforge.common.ForgeHooks.getGrassSeed(RANDOM, fortune);
            if (!seed.isEmpty())
                drops.add(seed);
    	}
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
    public Block.EnumOffsetType getOffsetType()
    {
        return Block.EnumOffsetType.XZ;
    }
	
	@Override
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
    	return Blocks.TALLGRASS.getFlammability(world, pos, face);
    }
	
	@Override
    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return Blocks.TALLGRASS.getFireSpreadSpeed(world, pos, face);
    }

	@Override
	public ImmutableList<IBlockState> getProperties()
	{
		return this.blockState.getValidStates();
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
	{
		return true;
	}
}
