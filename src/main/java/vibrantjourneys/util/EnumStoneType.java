package vibrantjourneys.util;

import net.minecraft.block.material.MapColor;

public enum EnumStoneType
{
	COBBLESTONE_BRICK(0, "cobblestone_brick", 2.0F, 10.0F, MapColor.STONE),
	BASALT(1, "basalt", 2.0F, 10.0F, MapColor.BLACK),
	BASALT_BRICK(2, "basalt_brick", 2.0F, 10.0F, MapColor.BLACK),
	LIMESTONE(3, "limestone", 1.9F, 6.0F, MapColor.GRAY),
	MARBLE(4, "marble", 2.0F, 8.0F, MapColor.WHITE_STAINED_HARDENED_CLAY),
	MARBLE_BRICK(5, "marble_brick", 2.0F, 8.0F, MapColor.WHITE_STAINED_HARDENED_CLAY),
	SILTSTONE(6, "siltstone", 1.5F, 4.0F, MapColor.BROWN_STAINED_HARDENED_CLAY),
	ADOBE(7, "adobe", 2.0F, 5.0F, MapColor.ADOBE),
	ADOBE_BRICK(8, "adobe_brick", 2.0F, 5.0F, MapColor.ADOBE);
	
	private String name;
	private int id;
	private int hardness;
	private int resistance;
	private MapColor mapColor;
	
	private EnumStoneType(int id, String name, float hardness, float resistance, MapColor mapColor)
	{
		this.id = id;
		this.name = name;
	}
	
    public String getName()
    {
    	return name;
    }
    
    public int getID()
    {
    	return id;
    }
    
    public float getHardness()
    {
    	return hardness;
    }
    
    public float getResistance()
    {
    	return resistance;
    }
    
    public MapColor getMapColor()
    {
    	return mapColor;
    }
}
