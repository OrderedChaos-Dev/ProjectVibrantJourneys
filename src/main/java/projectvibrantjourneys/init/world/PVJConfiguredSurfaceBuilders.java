package projectvibrantjourneys.init.world;

import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderConfiguration;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

public class PVJConfiguredSurfaceBuilders {

	public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> VERDANT_SANDS = register("verdant_sands", PVJSurfaceBuilders.VERDANT_SANDS.configured(SurfaceBuilder.CONFIG_OCEAN_SAND));
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> REDWOODS = register("redwoods", PVJSurfaceBuilders.REDWOODS.configured(SurfaceBuilder.CONFIG_GRASS));
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> ALPINE_HEIGHTS = register("alpine_heights", PVJSurfaceBuilders.ALPINE_HEIGHTS.configured(SurfaceBuilder.CONFIG_GRASS));
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> GRAVEL_SHORE = register("gravel_shore", SurfaceBuilder.DEFAULT.configured(SurfaceBuilder.CONFIG_GRAVEL));
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> RED_ROCK_VALLEY = register("red_rock_valley", PVJSurfaceBuilders.RED_ROCK_VALLEY.configured(SurfaceBuilder.CONFIG_BADLANDS));
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> PINE_MEADOWS = register("pine_meadows", PVJSurfaceBuilders.PINE_MEADOWS.configured(SurfaceBuilder.CONFIG_GRASS));
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> WINDSWEPT_CLIFFS = register("windswept_cliffs", PVJSurfaceBuilders.WINDSWEPT_CLIFFS.configured(SurfaceBuilder.CONFIG_GRASS));

	private static <SC extends SurfaceBuilderConfiguration> ConfiguredSurfaceBuilder<SC> register(String name,
			ConfiguredSurfaceBuilder<SC> builder) {
		return BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER,
				new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name), builder);
	}
}
