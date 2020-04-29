package projectvibrantjourneys.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SpiderEyesLayer;
import net.minecraft.client.renderer.entity.model.SpiderModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.common.entities.passive.SmallSpiderEntity;

@OnlyIn(Dist.CLIENT)
public class SmallSpiderRenderer<T extends SmallSpiderEntity> extends MobRenderer<T, SpiderModel<T>> {
   private static final ResourceLocation SPIDER_TEXTURES = new ResourceLocation("textures/entity/spider/spider.png");

   public SmallSpiderRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new SpiderModel<>(), 0.16F);
      this.addLayer(new SpiderEyesLayer<>(this));
   }

   @Override
   protected float getDeathMaxRotation(T entityLivingBaseIn) {
      return 180.0F;
   }
   
	@Override
	protected void preRenderCallback(SmallSpiderEntity entity, MatrixStack matrixstack, float p_225620_3_) {
		matrixstack.scale(0.2F, 0.2F, 0.2F);
	}

   @Override
   public ResourceLocation getEntityTexture(T entity) {
      return SPIDER_TEXTURES;
   }
}