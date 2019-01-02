package vibrantjourneys.biomes;

import java.util.Random;

import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.util.PVJConfig;
import vibrantjourneys.worldgen.feature.WorldGenFirTree;
import vibrantjourneys.worldgen.feature.WorldGenPineTree;

public class BiomeBorealForest extends Biome
{
    private static final WorldGenPineTree PINE = new WorldGenPineTree(false);
    private static final WorldGenFirTree FIR = new WorldGenFirTree(false);
    private static final WorldGenTaiga1 TAIGA1 = new WorldGenTaiga1();
    private static final WorldGenTaiga2 TAIGA2 = new WorldGenTaiga2(false);
    
	public BiomeBorealForest(BiomeProperties properties)
	{
		super(properties);
		
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 8, 4, 4));
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
    	if(PVJConfig.worldgen.firDensity > 0 && num > 45 && rand.nextInt(PVJConfig.worldgen.firDensity) < PVJConfig.worldgen.firDensity - 2)
    	{
    		return FIR;
    	}
    	else if(PVJConfig.worldgen.pineDensity > 0 && (num > 10 && rand.nextInt(PVJConfig.worldgen.pineDensity) < PVJConfig.worldgen.pineDensity - 2))
    	{
    		return PINE;
    	}
    	else
    	{
    		return rand.nextBoolean() ? TAIGA2 : TAIGA1;
    	}
    }

    @Override
    public WorldGenerator getRandomWorldGenForGrass(Random rand)
    {
        return rand.nextInt(5) > 0 ? new WorldGenTallGrass(BlockTallGrass.EnumType.FERN) : new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }

    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos)
    {
        DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.FERN);

        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.FLOWERS))
        for (int i1 = 0; i1 < 7; ++i1)
        {
            int j1 = rand.nextInt(16) + 8;
            int k1 = rand.nextInt(16) + 8;
            int l1 = rand.nextInt(worldIn.getHeight(pos.add(j1, 0, k1)).getY() + 32);
            DOUBLE_PLANT_GENERATOR.generate(worldIn, rand, pos.add(j1, l1, k1));
        }

        super.decorate(worldIn, rand, pos);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
    	return 0x00994d;
    }
    @SideOnly(Side.CLIENT)
    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
    	return 0x00994d;
    }
}
