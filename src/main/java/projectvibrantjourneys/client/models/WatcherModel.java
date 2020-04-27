package projectvibrantjourneys.client.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WatcherModel<T extends Entity> extends SegmentedModel<T> {
   private final ModelRenderer body;

   public WatcherModel(int slimeBodyTexOffY) {
      this.body = new ModelRenderer(this, 0, slimeBodyTexOffY);
      if (slimeBodyTexOffY > 0) {
         this.body.addBox(-3.0F, 17.0F, -3.0F, 6.0F, 6.0F, 6.0F);
      } else {
         this.body.addBox(-4.0F, 16.0F, -4.0F, 8.0F, 8.0F, 8.0F);
      }

   }

   @Override
   public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.body.rotateAngleX = headPitch * ((float) Math.PI / 180F);
   }

   @Override
   public Iterable<ModelRenderer> getParts() {
      return ImmutableList.of(this.body);
   }
}