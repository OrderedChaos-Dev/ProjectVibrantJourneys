package vibrantjourneys.biomes;

import java.util.Random;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeSavanna;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import vibrantjourneys.worldgen.feature.WorldGenBaobabTree;

public class BiomeBaobabFields extends BiomeSavanna
{
    private static final WorldGenBaobabTree BAOBAB_TREE = new WorldGenBaobabTree(false, 15, 6);
    private static final WorldGenSavannaTree SAVANNA_TREE = new WorldGenSavannaTree(false);

	public BiomeBaobabFields(BiomeProperties properties)
	{
		super(properties);
	}

	@Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand)
    {
        return (WorldGenAbstractTree)(rand.nextInt(5) > 1 ? BAOBAB_TREE : SAVANNA_TREE);
    }

    @Override
    public Class <? extends Biome > getBiomeClass()
    {
        return BiomeBaobabFields.class;
    }
}