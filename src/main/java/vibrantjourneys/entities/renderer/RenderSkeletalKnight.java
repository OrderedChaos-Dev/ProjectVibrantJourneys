package vibrantjourneys.entities.renderer;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.entities.monster.EntitySkeletalKnight;

@SideOnly(Side.CLIENT)
public class RenderSkeletalKnight extends RenderSkeleton
{
    private static final ResourceLocation SKELETON_TEXTURES = new ResourceLocation("textures/entity/skeleton/skeleton.png");

    public RenderSkeletalKnight(RenderManager manager)
    {
        super(manager);
    }

    @Override
    protected ResourceLocation getEntityTexture(AbstractSkeleton entity)
    {
        return SKELETON_TEXTURES;
    }
    
    public static class Factory implements IRenderFactory<EntitySkeletalKnight>
    {
        @Override
        public Render<? super EntitySkeletalKnight> createRenderFor(RenderManager manager)
        {
            return new RenderSkeletalKnight(manager);
        }
    }
}