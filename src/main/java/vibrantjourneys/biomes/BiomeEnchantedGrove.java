package vibrantjourneys.biomes;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.util.EnumLeafType;
import vibrantjourneys.util.EnumWoodType;
import vibrantjourneys.worldgen.WorldGenArcwoodTree;

public class BiomeEnchantedGrove extends BiomeForest
{
	private static final WorldGenArcwoodTree BLUE_ARCWOOD_TREE = new WorldGenArcwoodTree(false, PVJBlocks.LOGS.get(EnumWoodType.ARCWOOD.getID()).getDefaultState(),
			PVJBlocks.LEAVES.get(EnumLeafType.BLUE_ARCWOOD.getID()).getDefaultState());
	
	private static final WorldGenArcwoodTree PURPLE_ARCWOOD_TREE = new WorldGenArcwoodTree(false, PVJBlocks.LOGS.get(EnumWoodType.ARCWOOD.getID()).getDefaultState(),
			PVJBlocks.LEAVES.get(EnumLeafType.PURPLE_ARCWOOD.getID()).getDefaultState());
	
	public BiomeEnchantedGrove(BiomeProperties properties)
	{
		super(Type.NORMAL, properties);
		
        this.decorator.bigMushroomsPerChunk = 1;
        this.decorator.treesPerChunk = 7;
        this.decorator.grassPerChunk = 4;
	}
	
	@Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand)
    {
		int random = rand.nextInt(10);
		if(random < 4)
			return BLUE_ARCWOOD_TREE;
		else if(random < 8)
			return PURPLE_ARCWOOD_TREE;
		else
			return SWAMP_FEATURE;
    }
	
    @SideOnly(Side.CLIENT)
    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
    	return 0x00b386;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
        return 0x00b359;
    }
}
