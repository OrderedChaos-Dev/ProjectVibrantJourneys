package vibrantjourneys;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import vibrantjourneys.util.Reference;

public class ClientProxy extends CommonProxy
{
	@Override
	public <T extends Entity> void registerEntityRenderer(Class<T> entity, IRenderFactory<? super T> factory)
	{
		RenderingRegistry.registerEntityRenderingHandler(entity, factory);
	}
	
	@Override
	public void registerItemRenderer(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, 
				new ModelResourceLocation(Reference.MOD_ID + ":" + item.delegate.name()));
	}
	
	@Override
	public void registerItemVariantRenderer(Item item, String name, int meta)
	{
		ModelLoader.registerItemVariants(item, new ResourceLocation(Reference.MOD_ID, name));
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Reference.MOD_ID + ":" + name, "inventory"));
	}
}