package vibrantjourneys.blocks.wood;

import java.util.Random;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import vibrantjourneys.util.EnumLeafType;
import vibrantjourneys.util.EnumWoodType;
import vibrantjourneys.util.IPropertyHelper;
import vibrantjourneys.worldgen.feature.WorldGenAspenTree;
import vibrantjourneys.worldgen.feature.WorldGenBaobabTree;
import vibrantjourneys.worldgen.feature.WorldGenCherryBlossomTree;
import vibrantjourneys.worldgen.feature.WorldGenCottonwoodTree;
import vibrantjourneys.worldgen.feature.WorldGenFirTree;
import vibrantjourneys.worldgen.feature.WorldGenGenericTree;
import vibrantjourneys.worldgen.feature.WorldGenJacarandaTree;
import vibrantjourneys.worldgen.feature.WorldGenJuniperTree;
import vibrantjourneys.worldgen.feature.WorldGenMangroveTree;
import vibrantjourneys.worldgen.feature.WorldGenPalmTree;
import vibrantjourneys.worldgen.feature.WorldGenPineTree;
import vibrantjourneys.worldgen.feature.WorldGenRedwoodLarge;
import vibrantjourneys.worldgen.feature.WorldGenRedwoodSmall;
import vibrantjourneys.worldgen.feature.WorldGenWillowTree;

public class BlockPVJSapling extends BlockBush implements IGrowable, IPropertyHelper
{
    public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
    protected static final AxisAlignedBB SAPLING_AABB = 
    		new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
    
	private EnumLeafType leafType;

    public BlockPVJSapling(EnumLeafType leafType)
    {
    	this.setSoundType(SoundType.PLANT);
        this.setDefaultState(this.blockState.getBaseState().withProperty(STAGE, Integer.valueOf(0)));
        this.leafType = leafType;
        Blocks.FIRE.setFireInfo(this, 30, 60);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return SAPLING_AABB;
    }
    
    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            super.updateTick(worldIn, pos, state, rand);

            if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
            {
                this.grow(worldIn, pos, state, rand);
            }
        }
    }

    public void grow(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (((Integer)state.getValue(STAGE)).intValue() == 0)
        {
            worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
        }
        else
        {
            this.generateTree(worldIn, pos, state, rand);
        }
    }

    public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, pos)) return;
        WorldGenerator worldgenerator = new WorldGenRedwoodSmall();
        int i = 0;
        int j = 0;
        boolean flag = false;

        switch (this.leafType)
        {
            case REDWOOD:
            	check:
                for (i = 0; i >= -1; --i)
                {
                    for (j = 0; j >= -1; --j)
                    {
                        if (this.isTwoByTwoOfType(worldIn, pos, i, j, EnumWoodType.REDWOOD))
                        {
                            worldgenerator = new WorldGenRedwoodLarge(true, 30, 20);
                            flag = true;
                            break check;
                        }
                    }
                }
            
	            if(!flag)
	            {
	                i = 0;
	                j = 0;
	                worldgenerator = new WorldGenRedwoodSmall();
	            }
	            break;
            case BAOBAB:
            	check:
                for (i = 0; i >= -1; --i)
                {
                    for (j = 0; j >= -1; --j)
                    {
                        if (this.isTwoByTwoOfType(worldIn, pos, i, j, EnumWoodType.BAOBAB))
                        {
                            worldgenerator = new WorldGenBaobabTree(true, 15, 6);
                            flag = true;
                            break check;
                        }
                    }
                }
            	if(!flag)
            	{
            		return;
            	}
	            break;
            case PALM:
            	worldgenerator = new WorldGenPalmTree();
            	break;
            case WILLOW:
            	worldgenerator = new WorldGenWillowTree();
            	break;
            case MANGROVE:
            	worldgenerator = new WorldGenMangroveTree();
            	break;
            case FIR:
            	worldgenerator = new WorldGenFirTree(true);
            	break;
            case PINE:
            	worldgenerator = new WorldGenPineTree(true);
            	break;
            case ASPEN:
            	worldgenerator = new WorldGenAspenTree(true);
            	break;
            case RED_MAPLE:
            	worldgenerator = new WorldGenGenericTree(true, EnumWoodType.MAPLE, EnumLeafType.RED_MAPLE);
            	break;
            case ORANGE_MAPLE:
            	worldgenerator = new WorldGenGenericTree(true, EnumWoodType.MAPLE, EnumLeafType.ORANGE_MAPLE);
            	break;
            case COTTONWOOD:
            	worldgenerator = new WorldGenCottonwoodTree(true);
            	break;
            case JUNIPER:
            	worldgenerator = new WorldGenJuniperTree(true);
            	break;
            case WHITE_CHERRY_BLOSSOM:
            	worldgenerator = new WorldGenCherryBlossomTree(true, false);
            	break;
            case PINK_CHERRY_BLOSSOM:
            	worldgenerator = new WorldGenCherryBlossomTree(true, true);
            	break;
            case JACARANDA:
            	worldgenerator = new WorldGenJacarandaTree(true);
            	break;
            default:
            	break;
        }

        IBlockState iblockstate2 = Blocks.AIR.getDefaultState();

        if (flag)
        {
            worldIn.setBlockState(pos.add(i, 0, j), iblockstate2, 4);
            worldIn.setBlockState(pos.add(i + 1, 0, j), iblockstate2, 4);
            worldIn.setBlockState(pos.add(i, 0, j + 1), iblockstate2, 4);
            worldIn.setBlockState(pos.add(i + 1, 0, j + 1), iblockstate2, 4);
        }
        else
        {
            worldIn.setBlockState(pos, iblockstate2, 4);
        }

        if (!worldgenerator.generate(worldIn, rand, pos.add(i, 0, j)))
        {
            if (flag)
            {
                worldIn.setBlockState(pos.add(i, 0, j), state, 4);
                worldIn.setBlockState(pos.add(i + 1, 0, j), state, 4);
                worldIn.setBlockState(pos.add(i, 0, j + 1), state, 4);
                worldIn.setBlockState(pos.add(i + 1, 0, j + 1), state, 4);
            }
            else
            {
                worldIn.setBlockState(pos, state, 4);
            }
        }
    }
    
    /**
     * Used by PVJ saplings to generate large trees by comparing wood types
     * 
     */
    public EnumLeafType getLeafType()
    {
    	return leafType;
    }

    
    private boolean isTwoByTwoOfType(World worldIn, BlockPos pos, int xOffset, int zOffset, EnumWoodType type)
    {
        return this.isTypeAt(worldIn, pos.add(xOffset, 0, zOffset), type) && this.isTypeAt(worldIn, pos.add(xOffset + 1, 0, zOffset), type) && this.isTypeAt(worldIn, pos.add(xOffset, 0, zOffset + 1), type) && this.isTypeAt(worldIn, pos.add(xOffset + 1, 0, zOffset + 1), type);
    }

    public boolean isTypeAt(World worldIn, BlockPos pos, EnumWoodType type)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        if(iblockstate.getBlock() instanceof BlockPVJSapling)
        	return ((BlockPVJSapling)iblockstate.getBlock()).getLeafType() == leafType;
        else
        	return false;
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return 0;
    }
    
    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        IBlockState soil = worldIn.getBlockState(pos.down());
    	if(leafType == EnumLeafType.PALM || leafType == EnumLeafType.MANGROVE || leafType == EnumLeafType.JUNIPER)
    	{
    		return super.canPlaceBlockAt(worldIn, pos) || soil.getBlock() == Blocks.SAND;
    	}

        return super.canPlaceBlockAt(worldIn, pos) && soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), EnumFacing.UP, this);
    }
    
    @Override
    protected boolean canSustainBush(IBlockState state)
    {
    	if(leafType == EnumLeafType.PALM || leafType == EnumLeafType.MANGROVE)
    	{
            return state.getBlock() == Blocks.GRASS || 
            		state.getBlock() == Blocks.DIRT || 
            		state.getBlock() == Blocks.FARMLAND || 
            		state.getBlock() == Blocks.SAND;
    	}
    	
        return state.getBlock() == Blocks.GRASS || 
        		state.getBlock() == Blocks.DIRT || 
        		state.getBlock() == Blocks.FARMLAND;
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
    {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        return (double)worldIn.rand.nextFloat() < 0.45D;
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        this.grow(worldIn, pos, state, rand);
    }
    
	@Override
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
    	return Blocks.SAPLING.getFlammability(world, pos, face);
    }
	
	@Override
    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return Blocks.SAPLING.getFireSpreadSpeed(world, pos, face);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(STAGE, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
    	return state.getValue(STAGE).intValue();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {STAGE});
    }
    
	@Override
	public ImmutableList<IBlockState> getProperties()
	{
		return this.blockState.getValidStates();
	}
}