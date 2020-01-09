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
import projectvibrantjourneys.common.entities.IceCubeEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class IceCubeRenderer extends MobRenderer<IceCubeEntity, SlimeModel<IceCubeEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/ice_cube.png");
	
	public IceCubeRenderer(EntityRendererManager manager) {
		super(manager, new SlimeModel<>(16), 0.25F);
		this.addLayer(new SlimeGelLayer<>(this));
	}
	
	@Override
	public void func_225623_a_(IceCubeEntity entity, float p_225623_2_, float p_225623_3_, MatrixStack matrixstack,
			IRenderTypeBuffer p_225623_5_, int p_225623_6_) {
		this.shadowSize = 0.25F * (float) entity.getSlimeSize();
		super.func_225623_a_(entity, p_225623_2_, p_225623_3_, matrixstack, p_225623_5_, p_225623_6_);
	}

	@Override
	protected void func_225620_a_(IceCubeEntity entity, MatrixStack matrixstack, float p_225620_3_) {
		matrixstack.func_227862_a_(0.999F, 0.999F, 0.999F);
		matrixstack.func_227861_a_(0.0D, (double) 0.001F, 0.0D);
		float f1 = (float) entity.getSlimeSize();
		float f2 = MathHelper.lerp(p_225620_3_, entity.prevSquishFactor, entity.squishFactor)
				/ (f1 * 0.5F + 1.0F);
		float f3 = 1.0F / (f2 + 1.0F);
		matrixstack.func_227862_a_(f3 * f1, 1.0F / f3 * f1, f3 * f1);
	}
	
	@Override
	public ResourceLocation getEntityTexture(IceCubeEntity entity) {
		return TEXTURE;
	}
}
