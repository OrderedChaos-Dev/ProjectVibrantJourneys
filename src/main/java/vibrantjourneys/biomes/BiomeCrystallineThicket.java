package vibrantjourneys.biomes;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.worldgen.WorldGenCrystalbarkTree;

public class BiomeCrystallineThicket extends BiomeForest
{
	private static final WorldGenCrystalbarkTree CRYSTALBARK_TREE = new WorldGenCrystalbarkTree(false);
	
	public BiomeCrystallineThicket(BiomeProperties properties)
	{
		super(Type.NORMAL, properties);
	}
	
	@Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand)
    {
		return CRYSTALBARK_TREE;
    }
	
    @SideOnly(Side.CLIENT)
    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
    	return 0x49e5be;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
        return 0x49e5be;
    }
}
