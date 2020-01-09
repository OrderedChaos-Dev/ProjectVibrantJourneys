package projectvibrantjourneys.client.renderers;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.client.models.ClamModel;
import projectvibrantjourneys.common.entities.passive.ClamEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class ClamRenderer extends MobRenderer<ClamEntity, ClamModel<ClamEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/clam.png");
	
	public ClamRenderer(EntityRendererManager manager) {
		super(manager, new ClamModel<>(), 0.05F);
	}
	
	@Override
	public ResourceLocation getEntityTexture(ClamEntity entity) {
		return TEXTURE;
	}
}
