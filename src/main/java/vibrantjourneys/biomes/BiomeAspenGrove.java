package vibrantjourneys.biomes;

import java.util.Random;

import net.minecraft.block.BlockTallGrass;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.util.EnumLeafType;
import vibrantjourneys.util.EnumWoodType;
import vibrantjourneys.util.PVJConfig;
import vibrantjourneys.worldgen.feature.WorldGenAspenTree;
import vibrantjourneys.worldgen.feature.WorldGenGenericTree;

public class BiomeAspenGrove extends Biome
{
    private static final WorldGenAspenTree ASPEN = new WorldGenAspenTree(false);
    private static final WorldGenGenericTree RED_MAPLE = new WorldGenGenericTree(true, EnumWoodType.MAPLE, EnumLeafType.RED_MAPLE);
    private static final WorldGenGenericTree ORANGE_MAPLE = new WorldGenGenericTree(true, EnumWoodType.MAPLE, EnumLeafType.ORANGE_MAPLE);
    
	public BiomeAspenGrove(BiomeProperties properties)
	{
		super(properties);
		
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityRabbit.class, 4, 2, 3));
		
        this.decorator.treesPerChunk = 9;
        this.decorator.grassPerChunk = 11;
        this.decorator.flowersPerChunk = 2;
        this.decorator.mushroomsPerChunk = 5;
	}
	
    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand)
    {
    	int num = rand.nextInt(100);
    	if(PVJConfig.worldgen.aspenDensity > 0 && num > 60 && rand.nextInt(PVJConfig.worldgen.aspenDensity) < PVJConfig.worldgen.aspenDensity - 2)
    	{
    		return ASPEN;
    	}
    	else if(PVJConfig.worldgen.redMapleDensity > 0 && num > 40 && rand.nextInt(PVJConfig.worldgen.redMapleDensity) < PVJConfig.worldgen.redMapleDensity - 2)
    	{
    		return RED_MAPLE;
    	}
    	else if(PVJConfig.worldgen.orangeMapleDensity > 0 && num > 20 && rand.nextInt(PVJConfig.worldgen.orangeMapleDensity) < PVJConfig.worldgen.orangeMapleDensity - 2)
    	{	
    		return ORANGE_MAPLE;
    	}
    	else
    	{
    		return TREE_FEATURE;
    	}
    }

    @Override
    public WorldGenerator getRandomWorldGenForGrass(Random rand)
    {
        return new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
    	return 0xF4D342;
    }
    @SideOnly(Side.CLIENT)
    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
        double d0 = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
    	return d0 < -0.1 ? 0xB8E83E : 0x996600;
    }
}
