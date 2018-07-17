package vibrantjourneys.util;

import java.util.List;
import java.util.stream.Collectors;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeBeach;
import net.minecraft.world.biome.BiomeOcean;
import net.minecraft.world.biome.BiomeStoneBeach;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import vibrantjourneys.init.PVJBiomes;

/**
 * Used by PVJWorldGen.class to generate fallen leaves based on where their tree type generates
 * BiomeDictionary.Type is not used for reasons (oak trees do not spawn in all Type.FOREST)
 */
public class BiomeReference
{
	public static final Biome[] OAK_TREE_BIOMES = {Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.SWAMPLAND, Biomes.JUNGLE, Biomes.MUTATED_FOREST,
			Biomes.MUTATED_JUNGLE, Biomes.MUTATED_SWAMPLAND};
	
	public static final Biome[] OAK_TREE_SPARSE_BIOMES = {Biomes.PLAINS, Biomes.MUTATED_PLAINS, PVJBiomes.prairie,
			Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST};
	
	public static final Biome[] BIRCH_TREE_BIOMES = {Biomes.BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.MUTATED_BIRCH_FOREST,
			Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST};
	
	public static final Biome[] BIRCH_TREE_SPARSE_BIOMES = {Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST};
	
	public static final Biome[] SPRUCE_TREE_BIOMES = {Biomes.COLD_TAIGA, Biomes.COLD_TAIGA_HILLS, Biomes.EXTREME_HILLS_WITH_TREES,
			Biomes.MUTATED_REDWOOD_TAIGA, Biomes.MUTATED_REDWOOD_TAIGA_HILLS, Biomes.TAIGA, Biomes.TAIGA_HILLS};
	
	public static final Biome[] SPRUCE_TREE_SPARSE_BIOMES = {Biomes.EXTREME_HILLS_WITH_TREES, Biomes.MUTATED_EXTREME_HILLS_WITH_TREES,
			Biomes.EXTREME_HILLS_EDGE};
	
	public static final Biome[] JUNGLE_TREE_BIOMES = {Biomes.JUNGLE, Biomes.JUNGLE_EDGE, Biomes.JUNGLE_HILLS, Biomes.MUTATED_JUNGLE,
			Biomes.MUTATED_JUNGLE_EDGE};
	
	public static final Biome[] DARK_OAK_TREE_BIOMES = {Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST};
	
	public static final Biome[] ACACIA_TREE_BIOMES = {Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU, Biomes.MUTATED_SAVANNA, Biomes.MUTATED_SAVANNA_ROCK};
	
	public static final Biome[] WILLOW_TREE_BIOMES = {Biomes.SWAMPLAND, Biomes.MUTATED_SWAMPLAND};
	
	public static final Biome[] MANGROVE_TREE_BIOMES = {Biomes.SWAMPLAND, Biomes.MUTATED_SWAMPLAND, Biomes.JUNGLE, Biomes.JUNGLE_EDGE,
			Biomes.JUNGLE_HILLS, Biomes.MUTATED_JUNGLE, Biomes.MUTATED_JUNGLE_EDGE};
	
	//heh
	public static final Biome[] PALM_TREE_BIOMES = {Biomes.BEACH};
	
	public static final Biome[] REDWOOD_TREE_BIOMES = {PVJBiomes.redwoods};
	
	public static final Biome[] DEAD_TREE_BIOMES = {Biomes.MESA, Biomes.MESA_CLEAR_ROCK, Biomes.MESA_ROCK, Biomes.MUTATED_MESA,
		Biomes.MUTATED_MESA_CLEAR_ROCK, Biomes.MUTATED_MESA_ROCK};
	
	public static final List<Biome> FRESHWATER_BIOMES = ForgeRegistries.BIOMES.getValuesCollection().stream()
			.filter(biome -> !(biome instanceof BiomeOcean || biome instanceof BiomeBeach || biome instanceof BiomeStoneBeach))
			.collect(Collectors.toList());
	
	public static final Biome[] SNOW_BIOMES = BiomeDictionary.getBiomes(Type.SNOWY).toArray(new Biome[0]);
	
    public static final Biome[] ALL_BIOMES = ForgeRegistries.BIOMES.getValuesCollection().toArray(new Biome[0]);

}
