package vibrantjourneys.blocks.plant;

import javax.annotation.Nullable;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class BlockWitherweed extends BlockPVJPlant
{
	@Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        IBlockState soil = worldIn.getBlockState(pos.down());
        
        if(soil.getBlock() == Blocks.NETHERRACK)
        	return true;
        
        return super.canPlaceBlockAt(worldIn, pos) && soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), net.minecraft.util.EnumFacing.UP, this);
    }
	
    @Override
    public EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
    	return EnumPlantType.Nether;
    }
    
    @Override
    protected boolean canSustainBush(IBlockState state)
    {
        return state.getBlock() == Blocks.NETHERRACK || state.getBlock() == Blocks.SOUL_SAND;
    }
    
	@Override
    public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack)
    {
		if(!world.isRemote)
		{
			player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("wither"), 100));
		}
    }
}
