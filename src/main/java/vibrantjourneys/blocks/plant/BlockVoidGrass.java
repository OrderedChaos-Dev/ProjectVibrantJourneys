package vibrantjourneys.blocks.plant;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import vibrantjourneys.init.PVJBlocks;

public class BlockVoidGrass extends BlockPVJPlant implements IShearable
{
	@Override
    public void onEntityCollision(World world, BlockPos pos, IBlockState state, Entity entity)
    {
        if (!world.isRemote)
        {
        	if(!(entity instanceof EntityDragon) && !(entity instanceof EntityWither))
        	{
            	Random random = world.rand;
            	
                double d0 = entity.posX;
                double d1 = entity.posY;
                double d2 = entity.posZ;

                for (int i = 0; i < 16; ++i)
                {
                    double d3 = entity.posX + (random.nextDouble() - 0.5D) * 16.0D;
                    double d4 = MathHelper.clamp(entity.posY + (double)(random.nextInt(16) - 8), 0.0D, (double)(world.getActualHeight() - 1));
                    double d5 = entity.posZ + (random.nextDouble() - 0.5D) * 16.0D;

                    if (entity.isRiding())
                    {
                        entity.dismountRidingEntity();
                    }

                    if(entity instanceof EntityLiving || entity instanceof EntityPlayer)
                    {
                        if (((EntityLivingBase)entity).attemptTeleport(d3, d4, d5))
                        {
                        	entity.attackEntityFrom(DamageSource.OUT_OF_WORLD, 2.0F);
                            world.playSound((EntityPlayer)null, d0, d1, d2, SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.0F);
                            entity.playSound(SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, 1.0F, 1.0F);
                            break;
                        }	
                    }
                    else
                    {
                    	if(world.isAirBlock(new BlockPos(d3, d4, d5)) && world.isSideSolid(new BlockPos(d3, d4, d5).down(), EnumFacing.UP))
                    	{
                            world.playSound((EntityPlayer)null, d0, d1, d2, SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.0F);
                            entity.playSound(SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, 1.0F, 1.0F);
                    		entity.setPosition(d3, d4, d5);
                    	}
                    }
                }	
        	}
        }
    }
	
	@Override
    public boolean canBlockStay(World world, BlockPos pos, IBlockState state)
    {
		return this.canSustainBush(world.getBlockState(pos.down()));
    }
	
	@Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        IBlockState soil = worldIn.getBlockState(pos.down());
        
        if(soil.getBlock() == Blocks.END_STONE)
        	return true;
        
        return super.canPlaceBlockAt(worldIn, pos) && soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), net.minecraft.util.EnumFacing.UP, this);
    }
    
    @Override
    protected boolean canSustainBush(IBlockState state)
    {
        return state.getBlock() == Blocks.END_STONE;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.03D, 1.0D);
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
            	spawnAsEntity(worldIn, pos, new ItemStack(PVJBlocks.void_grass, 1, 0));
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
