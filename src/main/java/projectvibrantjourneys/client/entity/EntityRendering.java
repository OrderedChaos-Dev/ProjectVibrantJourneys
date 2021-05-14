package projectvibrantjourneys.client.entity;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import projectvibrantjourneys.client.entity.renderers.FireflyRenderer;
import projectvibrantjourneys.client.entity.renderers.FlyRenderer;
import projectvibrantjourneys.init.objectregistry.PVJEntities;

public class EntityRendering {

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(PVJEntities.FLY, FlyRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PVJEntities.FIREFLY, FireflyRenderer::new);
	}
}
