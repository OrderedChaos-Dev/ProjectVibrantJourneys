package projectvibrantjourneys.client.entity.renderers;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.client.entity.models.ClamModel;
import projectvibrantjourneys.common.entities.ClamEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class ClamRenderer extends MobRenderer<ClamEntity, ClamModel<ClamEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/clam.png");
	
	public ClamRenderer(EntityRendererProvider.Context manager) {
		super(manager, new ClamModel<>(), 0.05F);
	}
	
	
	@Override
	public ResourceLocation getTextureLocation(ClamEntity entity) {
		return TEXTURE;
	}
}