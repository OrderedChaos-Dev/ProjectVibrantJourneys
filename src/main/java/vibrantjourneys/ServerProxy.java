package vibrantjourneys;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ServerProxy implements ICommonProxy
{
	@Override
	public <T extends Entity> void registerEntityRenderer(Class<T> entity, IRenderFactory<? super T> factory) {}
	
	@Override
	public void registerItemRenderer(Item item, String name) {}
	
	@Override
	public void registerItemVariantRenderer(Item item, int meta, ModelResourceLocation resource){}
	
	@Override
	public void registerWorldGenerator(IWorldGenerator worldgen)
	{
		GameRegistry.registerWorldGenerator(worldgen, 0);
	}
}
