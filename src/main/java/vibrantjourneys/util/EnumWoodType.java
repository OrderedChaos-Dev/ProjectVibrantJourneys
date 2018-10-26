package vibrantjourneys.util;

import java.util.ArrayList;

import net.minecraft.world.biome.Biome;

public enum EnumWoodType
{
    WILLOW(0, "willow", PVJConfig.worldgen.fallenTreeWillowDensity, BiomeReference.WILLOW_TREES),
    MANGROVE(1, "mangrove", PVJConfig.worldgen.fallenTreeMangroveDensity, BiomeReference.MANGROVE_TREES),
    PALM(2, "palm", PVJConfig.worldgen.fallenTreePalmDensity, BiomeReference.PALM_TREES),
    REDWOOD(3, "redwood", PVJConfig.worldgen.fallenTreeRedwoodDensity, BiomeReference.REDWOOD_TREES),
    FIR(4, "fir", PVJConfig.worldgen.fallenTreeFirDensity, BiomeReference.FIR_TREES),
    PINE(5, "pine", PVJConfig.worldgen.fallenTreePineDensity, BiomeReference.PINE_TREES),
    ASPEN(6, "aspen", PVJConfig.worldgen.fallenTreeAspenDensity, BiomeReference.ASPEN_TREES),
    MAPLE(7, "maple", PVJConfig.worldgen.fallenTreeMapleDensity, BiomeReference.RED_MAPLE_TREES),
    BAOBAB(8, "baobab", PVJConfig.worldgen.fallenTreeBaobabDensity, BiomeReference.BAOBAB_TREES),
    COTTONWOOD(9, "cottonwood", PVJConfig.worldgen.fallenTreeCottonwoodDensity, BiomeReference.COTTONWOOD_TREES),
    CRYSTALBARK(10, "crystalbark", PVJConfig.worldgen.fallenTreeCottonwoodDensity, BiomeReference.CRYSTALBARK_TREES),
    ARCWOOD(11, "arcwood", PVJConfig.worldgen.fallenTreeArcwoodDensity, BiomeReference.ARCWOOD_TREES),
    JUNIPER(12, "juniper", PVJConfig.worldgen.fallenTreeJuniperDensity, BiomeReference.JUNIPER_TREES);

    private final String name;
    private final int id;
    private final int fallenTreeDensity;
    private final ArrayList<Biome> homeBiomes;

    private EnumWoodType(int id, String name, int fallenTreeDensity, ArrayList<Biome> homeBiomes)
    {
        this.name = name;
        this.id = id;
        this.fallenTreeDensity = fallenTreeDensity;
        this.homeBiomes = homeBiomes;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getID()
    {
    	return id;
    }
    
    /**
     * Returns -1 for trees that have no associated fallen tree
     */
    public int getFallenTreeDensity()
    {
    	return this.fallenTreeDensity;
    }
    
    public Biome[] getTreeBiomes()
    {
    	return BiomeReference.getValidBiomes(this.homeBiomes);
    }
    
    public static EnumWoodType byId(int id)
    {
    	for(EnumWoodType woodType : EnumWoodType.values())
    	{
    		if(woodType.id == id)
    		{
    			return woodType;
    		}
    	}
		return EnumWoodType.WILLOW;
    }
}