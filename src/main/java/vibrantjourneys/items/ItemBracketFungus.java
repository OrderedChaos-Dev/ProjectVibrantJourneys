package vibrantjourneys.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import vibrantjourneys.blocks.wood.BlockBark;
import vibrantjourneys.init.PVJBlocks;

public class ItemBracketFungus extends ItemPVJBlock
{
	private boolean isFlouropore;
	public ItemBracketFungus(Block block, boolean isFlouropore)
	{
		super(block);
		this.isFlouropore = isFlouropore;
	}
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack itemstack = player.getHeldItem(hand);

        if (!player.canPlayerEdit(pos.offset(facing), facing, itemstack))
        {
            return EnumActionResult.FAIL;
        }
        else
        {
            IBlockState iblockstate = world.getBlockState(pos);
            Block block = iblockstate.getBlock();

            if (block instanceof BlockLog || block instanceof BlockBark || isFlouropore)
            {
                if (facing == EnumFacing.DOWN || facing == EnumFacing.UP)
                {
                    return EnumActionResult.FAIL;
                }

                pos = pos.offset(facing);

                if (world.isAirBlock(pos))
                {
                	IBlockState iblockstate1;
                	if(!isFlouropore)
                    	iblockstate1 = PVJBlocks.bracket_fungus.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, 0, player, hand);
                	else
                		iblockstate1 = PVJBlocks.flouropore.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, 0, player, hand);
                    world.setBlockState(pos, iblockstate1, 10);

                    if (!player.capabilities.isCreativeMode)
                    {
                        itemstack.shrink(1);
                    }
                    world.playSound(player, pos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    return EnumActionResult.SUCCESS;
                }
                return EnumActionResult.FAIL;
            }
            return EnumActionResult.PASS;
    }
 }

}
