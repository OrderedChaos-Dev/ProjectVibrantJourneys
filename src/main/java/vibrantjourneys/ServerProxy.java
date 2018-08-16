package vibrantjourneys;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ServerProxy implements ICommonProxy
{
	@Override
	public <T extends Entity> void registerEntityRenderer(Class<T> entity, IRenderFactory<? super T> factory) {}
	
	@Override
	public void registerItemRenderer(Item item) {}
	
	@Override
	public void registerItemVariantRenderer(Item item, int meta, ModelResourceLocation resource){}
	
	@Override
	public void registerWorldGenerator(IWorldGenerator worldgen){}
	
	@Override
	public void registerBlockColor(IBlockColor iblockcolor, Block block){}
	
	@Override
	public void registerItemColor(IItemColor iitemcolor, Item item){}
	
	@Override
	public void setIgnoredPropertiesForModel(Item item, IProperty<?>... properties){}

	@Override
	public <T extends TileEntity> void registerTESR(Class<T> te, TileEntitySpecialRenderer<? super T> tesr) {}
}
