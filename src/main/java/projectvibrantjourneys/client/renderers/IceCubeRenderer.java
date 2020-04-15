package projectvibrantjourneys.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SlimeGelLayer;
import net.minecraft.client.renderer.entity.model.SlimeModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.common.entities.monster.IceCubeEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class IceCubeRenderer extends MobRenderer<IceCubeEntity, SlimeModel<IceCubeEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/ice_cube.png");
	
	public IceCubeRenderer(EntityRendererManager manager) {
		super(manager, new SlimeModel<>(16), 0.25F);
		this.addLayer(new SlimeGelLayer<>(this));
	}
	
	@Override
	public void render(IceCubeEntity entity, float entityYaw, float partialTicks, MatrixStack matrixstack, IRenderTypeBuffer bufferIn, int packedLightIn) {
		this.shadowSize = 0.25F * (float) entity.getSlimeSize();
		super.render(entity, entityYaw, partialTicks, matrixstack, bufferIn, packedLightIn);
	}

	@Override
	protected void preRenderCallback(IceCubeEntity entity, MatrixStack matrixstack, float p_225620_3_) {
		matrixstack.scale(0.999F, 0.999F, 0.999F);
		matrixstack.translate(0.0D, (double) 0.001F, 0.0D);
		float f1 = (float) entity.getSlimeSize();
		float f2 = MathHelper.lerp(p_225620_3_, entity.prevSquishFactor, entity.squishFactor)
				/ (f1 * 0.5F + 1.0F);
		float f3 = 1.0F / (f2 + 1.0F);
		matrixstack.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
	}
	
	@Override
	public ResourceLocation getEntityTexture(IceCubeEntity entity) {
		return TEXTURE;
	}
}
