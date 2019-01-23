package vibrantjourneys.biomes;

import java.util.Random;

import net.minecraft.block.BlockDoublePlant;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.worldgen.feature.WorldGenCottonwoodTree;

public class BiomePrairie extends Biome
{
	public static final WorldGenCottonwoodTree COTTONWOOD = new WorldGenCottonwoodTree(false);
	
	public BiomePrairie(BiomeProperties properties)
	{
		super(properties);
		
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityHorse.class, 2, 2, 6));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDonkey.class, 1, 1, 3));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityRabbit.class, 3, 2, 3));
		
        this.decorator.treesPerChunk = 0;
        this.decorator.extraTreeChance = 0.01F;
        this.decorator.flowersPerChunk = 1;
	}
	
	@Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand)
    {
        return (WorldGenAbstractTree)(rand.nextInt(7) > 3 ? COTTONWOOD : TREE_FEATURE);
    }
	
	@Override
    public void decorate(World worldIn, Random rand, BlockPos pos)
    {
        double d0 = GRASS_COLOR_NOISE.getValue((double)(pos.getX() + 8) / 200.0D, (double)(pos.getZ() + 8) / 200.0D);

        if (d0 < -0.8D)
        {
            this.decorator.flowersPerChunk = 5;
            this.decorator.grassPerChunk = 90;
        }
        else
        {
            this.decorator.flowersPerChunk = 2;
            this.decorator.grassPerChunk = 40;
            DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.GRASS);

            if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
            for (int i = 0; i < 7; ++i)
            {
                int j = rand.nextInt(16) + 8;
                int k = rand.nextInt(16) + 8;
                int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
                DOUBLE_PLANT_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
            }
        }

        super.decorate(worldIn, rand, pos);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
    	//return 14938765;
    	//return 16646026;
    	//return 16580431;
    	return 16580467;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
    	return 12451687;
    }
    
}
