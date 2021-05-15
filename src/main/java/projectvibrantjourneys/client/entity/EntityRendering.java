package projectvibrantjourneys.client.entity;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import projectvibrantjourneys.client.entity.renderers.ClamRenderer;
import projectvibrantjourneys.client.entity.renderers.FireflyRenderer;
import projectvibrantjourneys.client.entity.renderers.FlyRenderer;
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
	}
}
