package projectvibrantjourneys.client.entity;

import net.minecraft.client.renderer.entity.BatRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import projectvibrantjourneys.client.entity.renderers.ClamRenderer;
import projectvibrantjourneys.client.entity.renderers.FireflyRenderer;
import projectvibrantjourneys.client.entity.renderers.FlyRenderer;
import projectvibrantjourneys.client.entity.renderers.FrogRenderer;
import projectvibrantjourneys.client.entity.renderers.SlugRenderer;
import projectvibrantjourneys.client.entity.renderers.SmallSpiderRenderer;
import projectvibrantjourneys.client.entity.renderers.SnailRenderer;
import projectvibrantjourneys.client.entity.renderers.StarfishRenderer;
import projectvibrantjourneys.init.object.PVJEntities;

public class EntityRendering {

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(PVJEntities.FLY, FlyRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PVJEntities.FIREFLY, FireflyRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PVJEntities.STARFISH, StarfishRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PVJEntities.OCEAN_STARFISH, StarfishRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PVJEntities.CLAM, ClamRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PVJEntities.SNAIL, SnailRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PVJEntities.SLUG, SlugRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PVJEntities.SMALL_SPIDER, SmallSpiderRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PVJEntities.FROG, FrogRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PVJEntities.NIGHT_BAT, BatRenderer::new);
	}
}
