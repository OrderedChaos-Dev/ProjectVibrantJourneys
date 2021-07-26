package projectvibrantjourneys.init.world;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderConfiguration;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.common.world.surfacebuilders.AlpineHeightsSurfaceBuilder;
import projectvibrantjourneys.common.world.surfacebuilders.PineMeadowsSurfaceBuilder;
import projectvibrantjourneys.common.world.surfacebuilders.RedRockValleySurfaceBuilder;
import projectvibrantjourneys.common.world.surfacebuilders.RedwoodsSurfaceBuilder;
import projectvibrantjourneys.common.world.surfacebuilders.VerdantSandsSurfaceBuilder;
import projectvibrantjourneys.common.world.surfacebuilders.WindsweptCliffsSurfaceBuilder;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

public class PVJSurfaceBuilders {

	public static final SurfaceBuilderBaseConfiguration CONFIG_DIORITE = new SurfaceBuilderBaseConfiguration(Blocks.DIORITE.defaultBlockState(), Blocks.STONE.defaultBlockState(), Blocks.GRAVEL.defaultBlockState());
	public static final SurfaceBuilderBaseConfiguration CONFIG_COBBLESTONE = new SurfaceBuilderBaseConfiguration(Blocks.COBBLESTONE.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState(), Blocks.GRAVEL.defaultBlockState());
	public static final SurfaceBuilderBaseConfiguration CONFIG_MOSS = new SurfaceBuilderBaseConfiguration(Blocks.MOSSY_COBBLESTONE.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState(), Blocks.GRAVEL.defaultBlockState());
	public static final SurfaceBuilderBaseConfiguration CONFIG_ANDESITE = new SurfaceBuilderBaseConfiguration(Blocks.ANDESITE.defaultBlockState(), Blocks.STONE.defaultBlockState(), Blocks.GRAVEL.defaultBlockState());
	public static final SurfaceBuilderBaseConfiguration CONFIG_WATER = new SurfaceBuilderBaseConfiguration(Blocks.WATER.defaultBlockState(), Blocks.STONE.defaultBlockState(), Blocks.GRAVEL.defaultBlockState());
	
	public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> VERDANT_SANDS = register("verdant_sands", new VerdantSandsSurfaceBuilder(SurfaceBuilderBaseConfiguration.CODEC));
	public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> REDWOODS = register("redwoods", new RedwoodsSurfaceBuilder(SurfaceBuilderBaseConfiguration.CODEC));
	public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> ALPINE_HEIGHTS = register("alpine_heights", new AlpineHeightsSurfaceBuilder(SurfaceBuilderBaseConfiguration.CODEC));
	public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> RED_ROCK_VALLEY = register("red_rock_valley", new RedRockValleySurfaceBuilder(SurfaceBuilderBaseConfiguration.CODEC));
	public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> PINE_MEADOWS = register("pine_meadows", new PineMeadowsSurfaceBuilder(SurfaceBuilderBaseConfiguration.CODEC));
	public static final SurfaceBuilder<SurfaceBuilderBaseConfiguration> WINDSWEPT_CLIFFS = register("windswept_cliffs", new WindsweptCliffsSurfaceBuilder(SurfaceBuilderBaseConfiguration.CODEC));
	
	public static <C extends SurfaceBuilderConfiguration, F extends SurfaceBuilder<C>> F register(String name, F builder) {
		builder.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
		ForgeRegistries.SURFACE_BUILDERS.register(builder);
		return builder;
	}
}
