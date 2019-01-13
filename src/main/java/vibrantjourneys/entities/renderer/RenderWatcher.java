package vibrantjourneys.entities.renderer;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import vibrantjourneys.entities.neutral.EntityWatcher;
import vibrantjourneys.entities.renderer.models.ModelWatcher;
import vibrantjourneys.util.Reference;

public class RenderWatcher extends RenderLiving<EntityWatcher>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/watcher.png");
    private static final ResourceLocation WATCHER_BEAM_TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/watcher_beam.png");

    public RenderWatcher(RenderManager manager)
    {
        super(manager, new ModelWatcher(16), 0.25F);
        this.addLayer(new LayerWatcher(this));
    }

    @Override
    public void doRender(EntityWatcher entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        EntityLivingBase entitylivingbase = entity.getTargetedEntity();

        if (entitylivingbase != null)
        {
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuffer();
            this.bindTexture(WATCHER_BEAM_TEXTURE);
            GlStateManager.glTexParameteri(3553, 10242, 10497);
            GlStateManager.glTexParameteri(3553, 10243, 10497);
            GlStateManager.disableLighting();
            GlStateManager.disableCull();
            GlStateManager.disableBlend();
            GlStateManager.depthMask(true);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            float f2 = (float)entity.world.getTotalWorldTime() + partialTicks;
            float f3 = f2 * 0.5F % 1.0F;
            float f4 = entity.getEyeHeight();
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)x, (float)y + f4, (float)z);
            Vec3d vec3d = this.getPosition(entitylivingbase, (double)entitylivingbase.height * 0.5D, partialTicks);
            Vec3d vec3d1 = this.getPosition(entity, (double)f4, partialTicks);
            Vec3d vec3d2 = vec3d.subtract(vec3d1);
            double d0 = vec3d2.length() + 1.0D;
            vec3d2 = vec3d2.normalize();
            float f5 = (float)Math.acos(vec3d2.y);
            float f6 = (float)Math.atan2(vec3d2.z, vec3d2.x);
            GlStateManager.rotate((((float)Math.PI / 2F) + -f6) * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(f5 * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
            double d1 = (double)f2 * 0.05D * -1.5D;
            bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            double d4 = 0.0D + Math.cos(d1 + 2.356194490192345D) * 0.282D;
            double d5 = 0.0D + Math.sin(d1 + 2.356194490192345D) * 0.282D;
            double d6 = 0.0D + Math.cos(d1 + (Math.PI / 4D)) * 0.282D;
            double d7 = 0.0D + Math.sin(d1 + (Math.PI / 4D)) * 0.282D;
            double d8 = 0.0D + Math.cos(d1 + 3.9269908169872414D) * 0.282D;
            double d9 = 0.0D + Math.sin(d1 + 3.9269908169872414D) * 0.282D;
            double d10 = 0.0D + Math.cos(d1 + 5.497787143782138D) * 0.282D;
            double d11 = 0.0D + Math.sin(d1 + 5.497787143782138D) * 0.282D;
            double d12 = 0.0D + Math.cos(d1 + Math.PI) * 0.2D;
            double d13 = 0.0D + Math.sin(d1 + Math.PI) * 0.2D;
            double d14 = 0.0D + Math.cos(d1 + 0.0D) * 0.2D;
            double d15 = 0.0D + Math.sin(d1 + 0.0D) * 0.2D;
            double d16 = 0.0D + Math.cos(d1 + (Math.PI / 2D)) * 0.2D;
            double d17 = 0.0D + Math.sin(d1 + (Math.PI / 2D)) * 0.2D;
            double d18 = 0.0D + Math.cos(d1 + (Math.PI * 3D / 2D)) * 0.2D;
            double d19 = 0.0D + Math.sin(d1 + (Math.PI * 3D / 2D)) * 0.2D;
            double d22 = (double)(-1.0F + f3);
            double d23 = d0 * 2.5D + d22;
            int a = (int) (entity.getAttackAnimationScale() * 255);
            int r = (int) (entity.getAttackAnimationScale() * 100) + 155;
            
            
            bufferbuilder.pos(d12, d0, d13).tex(0.4999D, d23).color(r, 15, 15, a).endVertex();
            bufferbuilder.pos(d12, 0.0D, d13).tex(0.4999D, d22).color(r, 15, 15, a).endVertex();
            bufferbuilder.pos(d14, 0.0D, d15).tex(0.0D, d22).color(r, 15, 15, a).endVertex();
            bufferbuilder.pos(d14, d0, d15).tex(0.0D, d23).color(r, 15, 15, a).endVertex();
            bufferbuilder.pos(d16, d0, d17).tex(0.4999D, d23).color(r, 15, 15, a).endVertex();
            bufferbuilder.pos(d16, 0.0D, d17).tex(0.4999D, d22).color(r, 15, 15, a).endVertex();
            bufferbuilder.pos(d18, 0.0D, d19).tex(0.0D, d22).color(r, 15, 15, a).endVertex();
            bufferbuilder.pos(d18, d0, d19).tex(0.0D, d23).color(r, 15, 15, a).endVertex();
            double d24 = 0.0D;

            if (entity.ticksExisted % 2 == 0)
            {
                d24 = 0.5D;
            }

            bufferbuilder.pos(d4, d0, d5).tex(0.5D, d24 + 0.5D).color(r, 15, 15, a).endVertex();
            bufferbuilder.pos(d6, d0, d7).tex(1.0D, d24 + 0.5D).color(r, 15, 15, a).endVertex();
            bufferbuilder.pos(d10, d0, d11).tex(1.0D, d24).color(r, 15, 15, a).endVertex();
            bufferbuilder.pos(d8, d0, d9).tex(0.5D, d24).color(r, 15, 15, a).endVertex();
            tessellator.draw();
            GlStateManager.popMatrix();
        }
    }
    
    private Vec3d getPosition(EntityLivingBase entityLivingBaseIn, double p_177110_2_, float p_177110_4_)
    {
        double d0 = entityLivingBaseIn.lastTickPosX + (entityLivingBaseIn.posX - entityLivingBaseIn.lastTickPosX) * (double)p_177110_4_;
        double d1 = p_177110_2_ + entityLivingBaseIn.lastTickPosY + (entityLivingBaseIn.posY - entityLivingBaseIn.lastTickPosY) * (double)p_177110_4_;
        double d2 = entityLivingBaseIn.lastTickPosZ + (entityLivingBaseIn.posZ - entityLivingBaseIn.lastTickPosZ) * (double)p_177110_4_;
        return new Vec3d(d0, d1, d2);
    }
    
    @Override
    protected void preRenderCallback(EntityWatcher entitylivingbaseIn, float partialTickTime)
    {
    	GlStateManager.scale(1.6F, 1.6F, 1.6F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWatcher entity)
    {
        return TEXTURE;
    }
    
    public static class Factory implements IRenderFactory<EntityWatcher>
    {
        @Override
        public Render<? super EntityWatcher> createRenderFor(RenderManager manager)
        {
            return new RenderWatcher(manager);
        }
    }
}
