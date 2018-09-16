package vibrantjourneys.util;

import net.minecraft.world.biome.Biome;

public enum EnumLeafType
{
    WILLOW(0, "willow", EnumWoodType.WILLOW, PVJConfig.worldgen.fallenLeavesWillowDensity, PVJConfig.worldgen.willowTwigsDensity),
    MANGROVE(1, "mangrove", EnumWoodType.MANGROVE, PVJConfig.worldgen.fallenLeavesMangroveDensity, PVJConfig.worldgen.mangroveTwigsDensity),
    PALM(2, "palm", EnumWoodType.PALM, PVJConfig.worldgen.fallenLeavesPalmDensity, PVJConfig.worldgen.palmTwigsDensity),
    REDWOOD(3, "redwood", EnumWoodType.REDWOOD, PVJConfig.worldgen.fallenLeavesRedwoodDensity, PVJConfig.worldgen.redwoodTwigsDensity),
    FIR(4, "fir", EnumWoodType.FIR, PVJConfig.worldgen.fallenLeavesFirDensity, PVJConfig.worldgen.firTwigsDensity),
    PINE(5, "pine", EnumWoodType.PINE, PVJConfig.worldgen.fallenLeavesPineDensity, PVJConfig.worldgen.pineTwigsDensity),
    ASPEN(6, "aspen", EnumWoodType.ASPEN, PVJConfig.worldgen.fallenLeavesAspenDensity, PVJConfig.worldgen.aspenTwigsDensity),
    RED_MAPLE(7, "red_maple", EnumWoodType.MAPLE, PVJConfig.worldgen.fallenLeavesRedMapleDensity, PVJConfig.worldgen.redMapleTwigsDensity),
    ORANGE_MAPLE(8, "orange_maple", EnumWoodType.MAPLE, PVJConfig.worldgen.fallenLeavesOrangeMapleDensity, PVJConfig.worldgen.orangeMapleTwigsDensity),
    BAOBAB(9, "baobab", EnumWoodType.BAOBAB, PVJConfig.worldgen.fallenLeavesBaobabDensity, PVJConfig.worldgen.baobabTwigsDensity);
    
    private String name;
    private int id;
    private EnumWoodType woodType;
    private int fallenLeavesDensity;
    private int twigsDensity;
    
    private EnumLeafType(int id, String name, EnumWoodType woodType, int fallenLeavesDensity, int twigsDensity)
    {
    	this.name = name;
    	this.id = id;
    	this.woodType = woodType;
    	this.fallenLeavesDensity = fallenLeavesDensity;
    	this.twigsDensity = twigsDensity;
    }
    
    public String getName()
    {
    	return name;
    }
    
    public int getID()
    {
    	return id;
    }
    
    public EnumWoodType getWoodType()
    {
    	return woodType;
    }
    
    public int getFallenLeavesDensity()
    {
    	return fallenLeavesDensity;
    }
    
    public int getTwigsDensity()
    {
    	return twigsDensity;
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
    			return BiomeReference.getValidBiomes(BiomeReference.ORANGE_MAPLE_TREES);
    		case 9:
    			return BiomeReference.getValidBiomes(BiomeReference.BAOBAB_TREES);
    	}
    }
}
