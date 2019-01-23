package vibrantjourneys.util;

import net.minecraft.block.material.MapColor;

public enum EnumStoneType
{
	COBBLESTONE_BRICK(0, "cobblestone_brick", 2.0F, 10.0F, MapColor.STONE),
	BASALT(1, "basalt", 2.0F, 10.0F, MapColor.BLACK),
	BASALT_BRICK(2, "basalt_brick", 2.0F, 10.0F, MapColor.BLACK),
	LIMESTONE(3, "limestone", 1.9F, 6.0F, MapColor.GRAY),
	MARBLE(4, "marble", 2.0F, 8.0F, MapColor.SNOW),
	MARBLE_BRICK(5, "marble_brick", 2.0F, 8.0F, MapColor.SNOW),
	SILTSTONE(6, "siltstone", 1.5F, 4.0F, MapColor.BROWN_STAINED_HARDENED_CLAY),
	ADOBE(7, "adobe", 2.0F, 5.0F, MapColor.ADOBE),
	ADOBE_BRICK(8, "adobe_brick", 2.0F, 5.0F, MapColor.ADOBE);
	//GNEISS(9, "gneiss", 2.0F, 8.0F, MapColor.GRAY),
	//GNEISS_BRICK(10, "gneiss_brick", 2.0F, 8.0F, MapColor.GRAY);
	
	private String name;
	private int id;
	private float hardness;
	private float resistance;
	private MapColor mapColor;
	
	private EnumStoneType(int id, String name, float hardness, float resistance, MapColor mapColor)
	{
		this.id = id;
		this.name = name;
		this.hardness = hardness;
		this.resistance = resistance;
		this.mapColor = mapColor;
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
