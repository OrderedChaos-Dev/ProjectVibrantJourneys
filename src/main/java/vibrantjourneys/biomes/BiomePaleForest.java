package vibrantjourneys.biomes;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.worldgen.WorldGenCottonwoodTree;

public class BiomePaleForest extends BiomeForest
{
	private static final WorldGenCottonwoodTree COTTONWOOD_TREE = new WorldGenCottonwoodTree(false);
	
	public BiomePaleForest(BiomeProperties properties)
	{
		super(Type.NORMAL, properties);
	}
	
	@Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand)
    {
		int random = rand.nextInt(10);
		if(random > 5)
			return TREE_FEATURE;
		else if(random > 1)
			return COTTONWOOD_TREE;
		else
			return (WorldGenAbstractTree)BIG_TREE_FEATURE;
    }
	
    @SideOnly(Side.CLIENT)
    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
    	return 13499089;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
        return 14022104;
    }
    
    @Override
    public Class <? extends Biome > getBiomeClass()
    {
        return BiomePaleForest.class;
    }
}
