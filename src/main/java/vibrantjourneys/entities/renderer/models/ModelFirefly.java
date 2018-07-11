package vibrantjourneys.entities.renderer.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFirefly extends ModelBase
{
    public ModelRenderer body;

    public ModelFirefly()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 32.5F, 0F);
        this.body.addBox(0.0F, -10.0F, 0.0F, 1, 1, 1, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    { 
        this.body.render(f5);
    }
}