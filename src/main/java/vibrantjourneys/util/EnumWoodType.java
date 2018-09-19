package vibrantjourneys.util;

import net.minecraft.world.biome.Biome;

public enum EnumWoodType
{
    WILLOW(0, "willow", PVJConfig.worldgen.fallenTreeWillowDensity),
    MANGROVE(1, "mangrove", PVJConfig.worldgen.fallenTreeMangroveDensity),
    PALM(2, "palm", PVJConfig.worldgen.fallenTreePalmDensity),
    REDWOOD(3, "redwood", PVJConfig.worldgen.fallenTreeRedwoodDensity),
    FIR(4, "fir", PVJConfig.worldgen.fallenTreeFirDensity),
    PINE(5, "pine", PVJConfig.worldgen.fallenTreePineDensity),
    ASPEN(6, "aspen", PVJConfig.worldgen.fallenTreeAspenDensity),
    MAPLE(7, "maple", PVJConfig.worldgen.fallenTreeMapleDensity),
    BAOBAB(8, "baobab", PVJConfig.worldgen.fallenTreeBaobabDensity);

    private final String name;
    private final int id;
    private final int fallenTreeDensity;

    private EnumWoodType(int id, String name, int fallenTreeDensity)
    {
        this.name = name;
        this.id = id;
        this.fallenTreeDensity = fallenTreeDensity;
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
    	switch(id)
    	{
    		case 0:
    		default:
    			return BiomeReference.getValidBiomes(BiomeReference.WILLOW_TREES);
    		case 1:
    			return BiomeReference.getValidBiomes(BiomeReference.MANGROVE_TREES);
    		case 2:
    			return BiomeReference.getValidBiomes(BiomeReference.PALM_TREES);
    		case 3:
    			return BiomeReference.getValidBiomes(BiomeReference.REDWOOD_TREES);
    		case 4:
    			return BiomeReference.getValidBiomes(BiomeReference.FIR_TREES);
    		case 5:
    			return BiomeReference.getValidBiomes(BiomeReference.PINE_TREES);
    		case 6:
    			return BiomeReference.getValidBiomes(BiomeReference.ASPEN_TREES);
    		case 7:
    			return BiomeReference.getValidBiomes(BiomeReference.RED_MAPLE_TREES);
    		case 8:
    			return BiomeReference.getValidBiomes(BiomeReference.BAOBAB_TREES);
    	}
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