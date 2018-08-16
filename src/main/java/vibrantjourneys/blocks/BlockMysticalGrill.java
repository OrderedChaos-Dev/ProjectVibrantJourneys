package vibrantjourneys.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.init.PVJItems;
import vibrantjourneys.tileentities.TileEntityMysticalGrill;

public class BlockMysticalGrill extends Block
{
	public static final PropertyBool IS_COOKING = PropertyBool.create("is_cooking");
	
	public BlockMysticalGrill()
	{
		super(Material.IRON);
		this.setResistance(10.0F);
		this.setHardness(5.0F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(IS_COOKING, false));
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
	
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D);
    }
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {IS_COOKING});
	}
	
	@Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(IS_COOKING, meta == 0 ? false : true);
    }

	@Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(IS_COOKING).booleanValue() ? 1 : 0;
    }
	
	@Override
    public int damageDropped(IBlockState state)
    {
        return 0;
    }
	
	@Override
    public void breakBlock(World world, BlockPos pos, IBlockState state)
    {
		if(world.getTileEntity(pos) instanceof TileEntityMysticalGrill)
		{
			TileEntityMysticalGrill te = (TileEntityMysticalGrill)world.getTileEntity(pos);
			if(te.getFood() != ItemStack.EMPTY)
			{
				ItemStack food = te.getFood();
				InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), food);
			}
			if(te.getNetherWartCount() > 0)
			{
				ItemStack netherwart = new ItemStack(Items.NETHER_WART, te.getNetherWartCount());
				InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), netherwart);
			} 	
			if(te.hasEssence())
			{
				ItemStack essence = new ItemStack(PVJItems.unstable_essence, 1);
				InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), essence);
			}
			
			world.removeTileEntity(pos);
		}
		
		super.breakBlock(world, pos, state);
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
			
			if(world.getTileEntity(pos) instanceof TileEntityMysticalGrill)
			{
				TileEntityMysticalGrill te = (TileEntityMysticalGrill)world.getTileEntity(pos);
				ItemStack heldItem = player.getHeldItemMainhand();
				if(!heldItem.isEmpty())
				{
					if(te.getCookedFood(heldItem) != ItemStack.EMPTY && te.getFood() == ItemStack.EMPTY)
					{
						te.setFood(new ItemStack(heldItem.getItem(), 1, heldItem.getMetadata()));
						if(!player.isCreative())
							heldItem.shrink(1);
				        return true;
					}
					if(heldItem.getItem() == Items.NETHER_WART)
					{
						if(te.addNetherWart())
						{
							if(!player.isCreative())
								heldItem.shrink(1);
						}
					}
					if(heldItem.getItem() == PVJItems.unstable_essence)
					{
						if(te.addUnstableEssence())
							if(!player.isCreative())
								heldItem.shrink(1);
					}
				}
				if(te.getFood() != ItemStack.EMPTY)
				{
					if(heldItem.getItem() != PVJItems.unstable_essence && heldItem.getItem() != Items.NETHER_WART)
					{
						ItemStack food = te.getFood();
						InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), food);
						te.setFood(ItemStack.EMPTY);
						return true;
					}
				}
			}
		}
        return false;
    }
	
	@Override
	public boolean hasTileEntity(IBlockState state)
	{
		return true;
	}

	@Override
	public TileEntity createTileEntity(World worldIn, IBlockState state)
	{
		return new TileEntityMysticalGrill();
	}
	
    @SideOnly(Side.CLIENT)
    @Override
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand)
    {
    	if(state.getValue(IS_COOKING).booleanValue())
    	{
			for(int i = 0; i < rand.nextInt(5) + 5; i++)
			{
    			double x = pos.getX() + 0.5 + ((rand.nextDouble() - rand.nextDouble()) * 0.3);
    			double z = pos.getZ() + 0.5 + ((rand.nextDouble() - rand.nextDouble()) * 0.3);
    			world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x, pos.getY(), z, 0, 0, 0, new int[0]);
    			
    			x = pos.getX() + 0.5 + (rand.nextDouble() - rand.nextDouble()) * 0.3;
    			z = pos.getZ() + 0.5 + (rand.nextDouble() - rand.nextDouble()) * 0.3;
    			world.spawnParticle(EnumParticleTypes.CRIT, x, pos.getY(), z, 0, 0, 0, new int[0]);
    			
    			x = pos.getX() + 0.5 + (rand.nextDouble() - rand.nextDouble()) * 0.3;
    			z = pos.getZ() + 0.5 + (rand.nextDouble() - rand.nextDouble()) * 0.3;
    			world.spawnParticle(EnumParticleTypes.CRIT_MAGIC, x, pos.getY(), z, 0, 0, 0, new int[0]);
    			
    			x = pos.getX() + 0.5 + (rand.nextDouble() - rand.nextDouble()) * 0.3;
    			z = pos.getZ() + 0.5 + (rand.nextDouble() - rand.nextDouble()) * 0.3;
    			world.spawnParticle(EnumParticleTypes.REDSTONE, x, pos.getY(), z, 0, 0, 0, new int[0]);
    			
    			x = pos.getX() + 0.5 + (rand.nextDouble() - rand.nextDouble()) * 0.3;
    			z = pos.getZ() + 0.5 + (rand.nextDouble() - rand.nextDouble()) * 0.3;
    			world.spawnParticle(EnumParticleTypes.WATER_SPLASH, x, pos.getY(), z, 0, 0, 0, new int[0]);
    			
    			int r = rand.nextInt(256);
    			int g = rand.nextInt(256);
    			int b = rand.nextInt(256);
    			
    			x = pos.getX() + 0.5 + (rand.nextDouble() - rand.nextDouble()) * 0.3;
    			z = pos.getZ() + 0.5 + (rand.nextDouble() - rand.nextDouble()) * 0.3;
    			world.spawnParticle(EnumParticleTypes.SPELL_MOB, x, pos.getY(), z, r, g, b);
    			
    			x = pos.getX() + 0.5 + (rand.nextDouble() - rand.nextDouble()) * 0.3;
    			z = pos.getZ() + 0.5 + (rand.nextDouble() - rand.nextDouble()) * 0.3;
    			world.spawnParticle(EnumParticleTypes.PORTAL, x, pos.getY(), z, 0, 0, 0, new int[0]);
			}
    	}
    }
}
