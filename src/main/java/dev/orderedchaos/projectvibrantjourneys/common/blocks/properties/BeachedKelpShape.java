package dev.orderedchaos.projectvibrantjourneys.common.blocks.properties;

import net.minecraft.util.StringRepresentable;

public enum BeachedKelpShape implements StringRepresentable {
    TOP("top"),
    STRAIGHT("straight"),
    CURVED("curved"),
    END("end");

    private final String name;

    private BeachedKelpShape(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
