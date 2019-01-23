package vibrantjourneys.biomes;

import java.util.Random;

import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFlower.EnumFlowerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.util.PVJConfig;
import vibrantjourneys.worldgen.feature.WorldGenCherryBlossomTree;
import vibrantjourneys.worldgen.feature.WorldGenJacarandaTree;

public class BiomeBlossomingFields extends Biome
{
    private static final WorldGenCherryBlossomTree PINK_CHERRY = new WorldGenCherryBlossomTree(false, true);
    private static final WorldGenCherryBlossomTree WHITE_CHERRY = new WorldGenCherryBlossomTree(false, false);
    private static final WorldGenJacarandaTree JACARANDA = new WorldGenJacarandaTree(false);
    
	public BiomeBlossomingFields(BiomeProperties properties)
	{
		super(properties);
		
        this.decorator.treesPerChunk = 1;
        this.decorator.grassPerChunk = 13;
        this.decorator.flowersPerChunk = 18;
        this.decorator.mushroomsPerChunk = -999;
	}
	
    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand)
    {
    	int num = rand.nextInt(100);
    	if(PVJConfig.worldgen.pinkCherryBlossomDensity > 0 && num > 66)
    	{
    		return PINK_CHERRY;
    	}
    	else if(PVJConfig.worldgen.whiteCherryBlossomDensity > 0 && num > 33)
    	{
    		return WHITE_CHERRY;
    	}
    	else
    	{
    		return JACARANDA;
    	}
    }

    @Override
    public EnumFlowerType pickRandomFlower(Random rand, BlockPos pos)
    {
        double d0 = MathHelper.clamp((1.0D + GRASS_COLOR_NOISE.getValue((double)pos.getX() / 48.0D, (double)pos.getZ() / 48.0D)) / 2.0D, 0.0D, 0.9999D);
        EnumFlowerType flower = EnumFlowerType.values()[(int)(d0 * (double)EnumFlowerType.values().length)];
        return flower;
    }
    
    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos)
    {
        int i = rand.nextInt(5) - 1;
        this.addDoublePlants(worldIn, rand, pos, i);
        
        super.decorate(worldIn, rand, pos);
    }
    
    public void addDoublePlants(World world, Random rand, BlockPos pos, int frequency)
    {
        for (int i = 0; i < frequency; ++i)
        {
            int j = rand.nextInt(3);

            if (j == 0)
            {
                DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.SYRINGA);
            }
            else if (j == 1)
            {
                DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.ROSE);
            }
            else if (j == 2)
            {
                DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.PAEONIA);
            }

            for (int k = 0; k < 5; ++k)
            {
                int l = rand.nextInt(16) + 8;
                int i1 = rand.nextInt(16) + 8;
                int j1 = rand.nextInt(world.getHeight(pos.add(l, 0, i1)).getY() + 32);

                if (DOUBLE_PLANT_GENERATOR.generate(world, rand, new BlockPos(pos.getX() + l, j1, pos.getZ() + i1)))
                {
                    break;
                }
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
    	return 0xaeed5c;
    }
    @SideOnly(Side.CLIENT)
    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
    	return 0xaeed5c;
    }
}
