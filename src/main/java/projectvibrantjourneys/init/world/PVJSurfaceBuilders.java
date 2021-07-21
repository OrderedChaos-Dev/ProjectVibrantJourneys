package projectvibrantjourneys.init.world;

import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.common.world.surfacebuilders.AlpineHeightsSurfaceBuilder;
import projectvibrantjourneys.common.world.surfacebuilders.PineMeadowsSurfaceBuilder;
import projectvibrantjourneys.common.world.surfacebuilders.RedRockValleySurfaceBuilder;
import projectvibrantjourneys.common.world.surfacebuilders.RedwoodsSurfaceBuilder;
import projectvibrantjourneys.common.world.surfacebuilders.VerdantSandsSurfaceBuilder;
import projectvibrantjourneys.common.world.surfacebuilders.WindsweptCliffsSurfaceBuilder;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

public class PVJSurfaceBuilders {

	public static final SurfaceBuilderConfig CONFIG_DIORITE = new SurfaceBuilderConfig(Blocks.DIORITE.defaultBlockState(), Blocks.STONE.defaultBlockState(), Blocks.GRAVEL.defaultBlockState());
	public static final SurfaceBuilderConfig CONFIG_COBBLESTONE = new SurfaceBuilderConfig(Blocks.COBBLESTONE.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState(), Blocks.GRAVEL.defaultBlockState());
	public static final SurfaceBuilderConfig CONFIG_MOSS = new SurfaceBuilderConfig(Blocks.MOSSY_COBBLESTONE.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState(), Blocks.GRAVEL.defaultBlockState());
	public static final SurfaceBuilderConfig CONFIG_ANDESITE = new SurfaceBuilderConfig(Blocks.ANDESITE.defaultBlockState(), Blocks.STONE.defaultBlockState(), Blocks.GRAVEL.defaultBlockState());
	public static final SurfaceBuilderConfig CONFIG_WATER = new SurfaceBuilderConfig(Blocks.WATER.defaultBlockState(), Blocks.STONE.defaultBlockState(), Blocks.GRAVEL.defaultBlockState());
	
	public static final SurfaceBuilder<SurfaceBuilderConfig> VERDANT_SANDS = register("verdant_sands", new VerdantSandsSurfaceBuilder(SurfaceBuilderConfig.CODEC));
	public static final SurfaceBuilder<SurfaceBuilderConfig> REDWOODS = register("redwoods", new RedwoodsSurfaceBuilder(SurfaceBuilderConfig.CODEC));
	public static final SurfaceBuilder<SurfaceBuilderConfig> ALPINE_HEIGHTS = register("alpine_heights", new AlpineHeightsSurfaceBuilder(SurfaceBuilderConfig.CODEC));
	public static final SurfaceBuilder<SurfaceBuilderConfig> RED_ROCK_VALLEY = register("red_rock_valley", new RedRockValleySurfaceBuilder(SurfaceBuilderConfig.CODEC));
	public static final SurfaceBuilder<SurfaceBuilderConfig> PINE_MEADOWS = register("pine_meadows", new PineMeadowsSurfaceBuilder(SurfaceBuilderConfig.CODEC));
	public static final SurfaceBuilder<SurfaceBuilderConfig> WINDSWEPT_CLIFFS = register("windswept_cliffs", new WindsweptCliffsSurfaceBuilder(SurfaceBuilderConfig.CODEC));
	
	public static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String name, F builder) {
		builder.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
		ForgeRegistries.SURFACE_BUILDERS.register(builder);
		return builder;
	}
}
