package projectvibrantjourneys.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.PolarBearModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.common.entities.passive.GrizzlyBearEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class GrizzlyBearRenderer extends MobRenderer<GrizzlyBearEntity, PolarBearModel<GrizzlyBearEntity>> {
   private static final ResourceLocation TEXTURE = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/grizzly_bear.png");

   public GrizzlyBearRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new PolarBearModel<>(), 0.9F);
   }

   @Override
   public ResourceLocation getEntityTexture(GrizzlyBearEntity entity) {
      return TEXTURE;
   }

   @Override
   protected void preRenderCallback(GrizzlyBearEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
      matrixStackIn.scale(1.2F, 1.2F, 1.2F);
      super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
   }
}