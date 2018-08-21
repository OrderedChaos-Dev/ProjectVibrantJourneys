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
import vibrantjourneys.util.EnumWoodType;
import vibrantjourneys.worldgen.WorldGenAspenTree;
import vibrantjourneys.worldgen.WorldGenMapleTree;

public class BiomeAspenGrove extends Biome
{
    private static final WorldGenAspenTree ASPEN = new WorldGenAspenTree(false);
    private static final WorldGenMapleTree RED_MAPLE = new WorldGenMapleTree(false, EnumWoodType.RED_MAPLE);
    private static final WorldGenMapleTree ORANGE_MAPLE = new WorldGenMapleTree(false, EnumWoodType.ORANGE_MAPLE);
    
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
    	if(num > 70)
    	{
    		return ASPEN;
    	}
    	else if(num > 40)
    	{
    		return RED_MAPLE;
    	}
    	else if(num > 10)
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
    	return 0xB8E83E;
    }
}
