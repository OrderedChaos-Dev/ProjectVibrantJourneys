package projectvibrantjourneys.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

public class PVJConfiguredSurfaceBuilders {

	public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> VERDANT_SANDS = register("verdant_sands",
			PVJSurfaceBuilders.VERDANT_SANDS.func_242929_a(SurfaceBuilder.GRASS_DIRT_SAND_CONFIG));

	private static <SC extends ISurfaceBuilderConfig> ConfiguredSurfaceBuilder<SC> register(String name,
			ConfiguredSurfaceBuilder<SC> builder) {
		return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER,
				new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name), builder);
	}
}
