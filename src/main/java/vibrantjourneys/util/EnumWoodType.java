package vibrantjourneys.util;

import java.util.ArrayList;

import net.minecraft.world.biome.Biome;

public enum EnumWoodType
{
    WILLOW(0, "willow", PVJConfig.worldgen.fallenTreeWillowDensity, PVJConfig.worldgen.willowDensity, BiomeReference.WILLOW_TREES),
    MANGROVE(1, "mangrove", PVJConfig.worldgen.fallenTreeMangroveDensity, PVJConfig.worldgen.mangroveDensity, BiomeReference.MANGROVE_TREES),
    PALM(2, "palm", PVJConfig.worldgen.fallenTreePalmDensity, PVJConfig.worldgen.palmDensity, BiomeReference.PALM_TREES),
    REDWOOD(3, "redwood", PVJConfig.worldgen.fallenTreeRedwoodDensity, PVJConfig.worldgen.redwoodDensity, BiomeReference.REDWOOD_TREES),
    FIR(4, "fir", PVJConfig.worldgen.fallenTreeFirDensity, PVJConfig.worldgen.firDensity, BiomeReference.FIR_TREES),
    PINE(5, "pine", PVJConfig.worldgen.fallenTreePineDensity, PVJConfig.worldgen.pineDensity, BiomeReference.PINE_TREES),
    ASPEN(6, "aspen", PVJConfig.worldgen.fallenTreeAspenDensity, PVJConfig.worldgen.aspenDensity, BiomeReference.ASPEN_TREES),
    MAPLE(7, "maple", PVJConfig.worldgen.fallenTreeMapleDensity, Reference.FILLER, BiomeReference.RED_MAPLE_TREES),
    BAOBAB(8, "baobab", PVJConfig.worldgen.fallenTreeBaobabDensity, PVJConfig.worldgen.baobabDensity, BiomeReference.BAOBAB_TREES),
    COTTONWOOD(9, "cottonwood", PVJConfig.worldgen.fallenTreeCottonwoodDensity, PVJConfig.worldgen.cottonwoodDensity, BiomeReference.COTTONWOOD_TREES),
    JUNIPER(10, "juniper", PVJConfig.worldgen.fallenTreeJuniperDensity, PVJConfig.worldgen.juniperDensity, BiomeReference.JUNIPER_TREES),
    CHERRY_BLOSSOM(11, "cherry_blossom", PVJConfig.worldgen.fallenTreeCherryBlossomDensity, PVJConfig.worldgen.pinkCherryBlossomDensity, BiomeReference.PINK_CHERRY_BLOSSOM_TREES),
    JACARANDA(12, "jacaranda", PVJConfig.worldgen.fallenTreeJacarandaDensity, PVJConfig.worldgen.jacarandaDensity, BiomeReference.JACARANDA_TREES);

    private final String name;
    private final int id;
    private final int fallenTreeDensity;
    private final int treeDensity;
    private final ArrayList<Biome> homeBiomes;

    private EnumWoodType(int id, String name, int fallenTreeDensity, int treeDensity, ArrayList<Biome> homeBiomes)
    {
        this.name = name;
        this.id = id;
        this.fallenTreeDensity = fallenTreeDensity;
        this.treeDensity = treeDensity;
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
     * @return -1 for trees that have no associated fallen tree
     */
    public int getFallenTreeDensity()
    {
    	return this.fallenTreeDensity;
    }
    
    public int getTreeDensity()
    {
    	return this.treeDensity;
    }
    
    public Biome[] getTreeBiomes()
    {
    	return BiomeReference.getBiomes(this.homeBiomes);
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