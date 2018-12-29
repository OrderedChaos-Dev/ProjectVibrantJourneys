package vibrantjourneys.biomes;

import java.util.Random;

import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockSand;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.util.PVJConfig;
import vibrantjourneys.worldgen.feature.WorldGenJuniperTree;

public class BiomeRedRockBadlands extends Biome
{
    protected static final IBlockState COARSE_DIRT = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);
    protected static final IBlockState GRASS = Blocks.GRASS.getDefaultState();
    protected static final IBlockState RED_SAND = Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND);
    private static final WorldGenJuniperTree JUNIPER = new WorldGenJuniperTree();

    public BiomeRedRockBadlands(BiomeProperties properties)
    {
        super(properties);
        this.spawnableCreatureList.clear();
        this.decorator.treesPerChunk = 0;
        this.decorator.deadBushPerChunk = 20;
        this.decorator.cactiPerChunk = 15;
        this.decorator.flowersPerChunk = 0;
        this.decorator.grassPerChunk = 3;
        this.decorator.extraTreeChance = (float)(PVJConfig.worldgen.juniperTwigsDensity / 100.0);
        this.spawnableCreatureList.clear();
    }

    public WorldGenAbstractTree getRandomTreeFeature(Random rand)
    {
        return JUNIPER;
    }

	@Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimer, int x, int z, double noiseVal)
    {
		int n = rand.nextInt(7);
		
		if(n == 0)
			this.topBlock = GRASS;
		else if(n <= 2)
			this.topBlock = COARSE_DIRT;
		else
			this.topBlock = RED_SAND;

        this.generateBiomeTerrain(worldIn, rand, chunkPrimer, x, z, noiseVal);
    }
	
    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos)
    {
        return 0xb3b300;
    }

    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos)
    {
        return 0xb3b300;
    }
}