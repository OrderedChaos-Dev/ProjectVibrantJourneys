package vibrantjourneys.biomes;

import java.util.Random;

import net.minecraft.block.BlockFlower.EnumFlowerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.util.EnumLeafType;
import vibrantjourneys.util.EnumWoodType;
import vibrantjourneys.util.PVJConfig;
import vibrantjourneys.worldgen.feature.WorldGenCherryBlossomTree;
import vibrantjourneys.worldgen.feature.WorldGenGenericBigTree;

public class BiomeBlossomingFields extends Biome
{
    private static final WorldGenCherryBlossomTree PINK_CHERRY = new WorldGenCherryBlossomTree(true, true);
    private static final WorldGenCherryBlossomTree WHITE_CHERRY = new WorldGenCherryBlossomTree(true, false);
    private static final WorldGenGenericBigTree JACARANDA = new WorldGenGenericBigTree(false, EnumWoodType.JACARANDA, EnumLeafType.JACARANDA);
    
	public BiomeBlossomingFields(BiomeProperties properties)
	{
		super(properties);
		
        this.decorator.treesPerChunk = 1;
        this.decorator.grassPerChunk = 11;
        this.decorator.flowersPerChunk = 15;
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

    public EnumFlowerType pickRandomFlower(Random rand, BlockPos pos)
    {
        double d0 = MathHelper.clamp((1.0D + GRASS_COLOR_NOISE.getValue((double)pos.getX() / 48.0D, (double)pos.getZ() / 48.0D)) / 2.0D, 0.0D, 0.9999D);
        EnumFlowerType flower = EnumFlowerType.values()[(int)(d0 * (double)EnumFlowerType.values().length)];
        return flower;
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
