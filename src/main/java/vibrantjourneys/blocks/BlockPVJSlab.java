package vibrantjourneys.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public abstract class BlockPVJSlab extends BlockSlab
{
	private IBlockState state;

	
    public BlockPVJSlab(IBlockState state, Block half)
    {
        super(state.getMaterial());
        this.state = state;
        IBlockState iblockstate = this.blockState.getBaseState();

        this.setResistance(state.getMaterial() == Material.ROCK ? 10.0F : 5.0F);
        this.setHardness(2.0F);
        this.setSoundType(state.getMaterial() == Material.ROCK ? SoundType.STONE : SoundType.WOOD);

        if (!this.isDouble())
        {
            iblockstate = iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
        }
    }
    
    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return this.state.getMapColor(worldIn, pos);
    }
    
    @Override
    public String getUnlocalizedName(int meta)
    {
    	return this.getUnlocalizedName();
    }
    
    @Override
    public int damageDropped(IBlockState state)
    {
    	return 0;
    }

    @Override
    public IProperty<?> getVariantProperty()
    {
        return HALF;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack)
    {
        return EnumBlockHalf.BOTTOM;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        if (!this.isDouble())
        {
            return this.getDefaultState().withProperty(HALF, EnumBlockHalf.values()[meta % EnumBlockHalf.values().length]);
        }

        return this.getDefaultState();
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
    	if(this.isDouble())
    		return 0;
    	
    	return ((EnumBlockHalf)state.getValue(HALF)).ordinal() + 1;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return this.isDouble() ? new BlockStateContainer(this, new IProperty[] {}) : new BlockStateContainer(this, new IProperty[] {HALF});
    }
}