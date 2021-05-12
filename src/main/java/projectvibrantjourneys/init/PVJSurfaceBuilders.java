package projectvibrantjourneys.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.common.world.surfacebuilders.VerdantSandsSurfaceBuilder;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

public class PVJSurfaceBuilders {

	public static final SurfaceBuilder<SurfaceBuilderConfig> VERDANT_SANDS = register("verdant_sands", new VerdantSandsSurfaceBuilder(SurfaceBuilderConfig.CODEC));
	
	public static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String name, F builder) {
		builder.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
		ForgeRegistries.SURFACE_BUILDERS.register(builder);
		return builder;
	}
}
