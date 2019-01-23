package vibrantjourneys.entities.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import vibrantjourneys.entities.item.EntityCoconut;
import vibrantjourneys.init.PVJBlocks;

public class RenderCoconut implements IRenderFactory<EntityCoconut>
{
    @Override
    public Render<? super EntityCoconut> createRenderFor(RenderManager manager)
    {
        return new RenderSnowball<EntityCoconut>(manager, Item.getItemFromBlock(PVJBlocks.coconut), Minecraft.getMinecraft().getRenderItem());
    }
}
