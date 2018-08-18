package vibrantjourneys;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;

public class ServerProxy implements ICommonProxy
{	
	@Override
	public void registerItemRenderer(Item item) {}
	
	@Override
	public void registerItemVariantRenderer(Item item, int meta, ModelResourceLocation resource){}
	
	@Override
	public void registerBlockColor(IBlockColor iblockcolor, Block block){}
	
	@Override
	public void registerItemColor(IItemColor iitemcolor, Item item){}
	
	@Override
	public void setIgnoredPropertiesForModel(Item item, IProperty<?>... properties){}

	@Override
	public <T extends TileEntity> void registerTESRs() {}

	@Override
	public void registerEntityRenderers() {}

	@Override
	public void registerBlockColors() {}
}
