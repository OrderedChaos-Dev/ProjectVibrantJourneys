package vibrantjourneys.util;

import net.minecraft.block.material.MapColor;
import net.minecraft.util.IStringSerializable;

public enum EnumWoodType implements IStringSerializable
{
    WILLOW("willow", MapColor.GRAY),
    MANGROVE("mangrove", MapColor.DIRT),
    PALM("palm", MapColor.BROWN),
    REDWOOD("redwood", MapColor.BROWN),
    FIR("willow", MapColor.DIRT),
    PINE("mangrove", MapColor.DIRT),
    ASPEN("palm", MapColor.BROWN_STAINED_HARDENED_CLAY),
    MAPLE("maple", MapColor.BROWN),
    BAOBAB("baobab", MapColor.SAND);

    private final String name;
    private final MapColor mapColor;

    private EnumWoodType(String name, MapColor mapColor)
    {
        this.name = name;
        this.mapColor = mapColor;
    }

    public MapColor getMapColor()
    {
        return this.mapColor;
    }

    public String toString()
    {
        return this.name;
    }

    public String getName()
    {
        return this.name;
    }
}