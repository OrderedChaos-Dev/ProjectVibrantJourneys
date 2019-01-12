package vibrantjourneys.blocks;

import java.util.Random;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class BlockPVJOre extends BlockStoneBlock
{
	private Item droppedItem;
	
	public BlockPVJOre(float hardness, float resistance)
	{
		this(hardness, resistance, null);
	}
	
	public BlockPVJOre(float hardness, float resistance, Item droppedItem)
	{
		super(hardness, resistance, MapColor.STONE);
		this.droppedItem = droppedItem;
	}
	
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
    	return this.droppedItem == null ? super.getItemDropped(state, rand, fortune) : this.droppedItem;
    }
	
	@Override
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune))
        {
            int i = random.nextInt(fortune + 2) - 1;

            if (i < 0)
            {
                i = 0;
            }

            return this.quantityDropped(random) * (i + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }
	
    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
        	return MathHelper.getInt(rand, 3, 7);
        
        return 0;
    }
}
