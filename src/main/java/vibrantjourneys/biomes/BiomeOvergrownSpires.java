package vibrantjourneys.biomes;

import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeOvergrownSpires extends Biome
{
    private static final IBlockState JUNGLE_LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
    private static final IBlockState JUNGLE_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
    private static final IBlockState OAK_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
    protected static final IBlockState GRASS = Blocks.GRASS.getDefaultState();
    protected static final WorldGenCanopyTree ROOF_TREE = new WorldGenCanopyTree(false);
    
    private long worldSeed;
    private NoiseGeneratorPerlin pillarNoise;
    private NoiseGeneratorPerlin pillarRoofNoise;

    public BiomeOvergrownSpires(Biome.BiomeProperties properties)
    {
        super(properties);
        this.decorator.treesPerChunk = 20;
        this.decorator.grassPerChunk = 35;
        this.decorator.reedsPerChunk = 9;
        this.decorator.flowersPerChunk = 3;
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityParrot.class, 40, 1, 2));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityOcelot.class, 2, 1, 1));
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand)
    {
    	int num = rand.nextInt(100);
    	if(num > 80)
    		return TREE_FEATURE;
    	else if(num > 60)
    		return new WorldGenShrub(JUNGLE_LOG, OAK_LEAF);
    	else if(num > 35)
    		return (WorldGenAbstractTree)(new WorldGenTrees(false, 4 + rand.nextInt(7), JUNGLE_LOG, JUNGLE_LEAF, true));
    	else if(num > 10)
    		return ROOF_TREE;
    	else
    		return BIG_TREE_FEATURE;
    }

    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {
        if (this.pillarNoise == null || this.pillarRoofNoise == null || this.worldSeed != worldIn.getSeed())
        {
            Random random = new Random(this.worldSeed);
            this.pillarNoise = new NoiseGeneratorPerlin(random, 4);
            this.pillarRoofNoise = new NoiseGeneratorPerlin(random, 1);
        }

        this.worldSeed = worldIn.getSeed();
        double d4 = 0.0D;
        int i = (x & -16) + (z & 15);
        int j = (z & -16) + (x & 15);
        double d0 = Math.min(Math.abs(noiseVal), this.pillarNoise.getValue((double)i * 0.25D, (double)j * 0.25D));

        if (d0 > 0.0D)
        {
            double d2 = Math.abs(this.pillarRoofNoise.getValue((double)i * 0.001953125D, (double)j * 0.001953125D));
            d4 = d0 * d0 * 2.5D;
            double d3 = Math.ceil(d2 * 50.0D) + 14.0D;

            if (d4 > d3)
            {
                d4 = d3;
            }

            d4 = d4 + 64.0D;
        }

        int k1 = x & 15;
        int l1 = z & 15;
        int i2 = worldIn.getSeaLevel();
        IBlockState iblockstate = this.fillerBlock;
        int k = (int)(noiseVal / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
        int l = -1;

        for (int j1 = 255; j1 >= 0; --j1)
        {
            if (chunkPrimerIn.getBlockState(l1, j1, k1).getMaterial() == Material.AIR && j1 < (int)d4)
            {
                chunkPrimerIn.setBlockState(l1, j1, k1, STONE);
            }

            if (j1 <= rand.nextInt(5))
            {
                chunkPrimerIn.setBlockState(l1, j1, k1, BEDROCK);
            }
            else
            {
                IBlockState iblockstate1 = chunkPrimerIn.getBlockState(l1, j1, k1);

                if (iblockstate1.getMaterial() == Material.AIR)
                {
                    l = -1;
                }
                else if (iblockstate1.getBlock() == Blocks.STONE)
                {
                    if (l == -1)
                    {
                        if (k <= 0)
                        {
                            iblockstate = AIR;
                        }
                        else if (j1 >= i2 - 4 && j1 <= i2 + 1)
                        {
                            iblockstate = this.fillerBlock;
                        }

                        if (j1 < i2 && (iblockstate == null || iblockstate.getMaterial() == Material.AIR))
                        {
                            iblockstate = WATER;
                        }

                        l = k + Math.max(0, j1 - i2);

                        if (j1 >= i2 - 1)
                        {
                            chunkPrimerIn.setBlockState(l1, j1, k1, this.topBlock);
                        }
                        else
                        {
                            chunkPrimerIn.setBlockState(l1, j1, k1, this.fillerBlock);
                        }
                    }
                    else if (l > 0)
                    {
                        --l;

                        chunkPrimerIn.setBlockState(l1, j1, k1, STONE);
                    }
                }
            }
        }
    }
    
    @Override
    public WorldGenerator getRandomWorldGenForGrass(Random rand)
    {
        return rand.nextInt(4) == 0 ? new WorldGenTallGrass(BlockTallGrass.EnumType.FERN) : new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }
}