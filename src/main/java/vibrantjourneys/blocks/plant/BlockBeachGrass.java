package vibrantjourneys.blocks.plant;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import vibrantjourneys.init.PVJBlocks;

public class BlockBeachGrass extends BlockPVJPlant implements IShearable
{	
	@Override
    public boolean canBlockStay(World world, BlockPos pos, IBlockState state)
    {
		return this.canSustainBush(world.getBlockState(pos.down()));
    }
	
	@Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        IBlockState soil = worldIn.getBlockState(pos.down());
        
        if(soil.getBlock() instanceof BlockSand)
        	return true;
        
        return super.canPlaceBlockAt(worldIn, pos) && soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), net.minecraft.util.EnumFacing.UP, this);
    }
    
    @Override
    protected boolean canSustainBush(IBlockState state)
    {
        return state.getBlock() instanceof BlockSand;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
    }

	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.AIR;
    }
	
	@Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack)
    {
        if (!worldIn.isRemote && stack.getItem() == Items.SHEARS)
        {
            player.addStat(StatList.getBlockStats(this));
            if(worldIn.rand.nextBoolean())
            	spawnAsEntity(worldIn, pos, new ItemStack(PVJBlocks.beach_grass, 1, 0));
        }
        else
        {
            super.harvestBlock(worldIn, player, pos, state, te, stack);
        }
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
    public Block.EnumOffsetType getOffsetType()
    {
        return Block.EnumOffsetType.XZ;
    }
}
