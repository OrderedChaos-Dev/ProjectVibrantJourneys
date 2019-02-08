package vibrantjourneys.init;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.registries.IForgeRegistry;
import vibrantjourneys.ProjectVibrantJourneys;
import vibrantjourneys.blocks.BlockMysticalGrill;
import vibrantjourneys.blocks.wood.BlockPVJDoor;
import vibrantjourneys.blocks.wood.BlockPVJFenceGate;
import vibrantjourneys.util.IPropertyHelper;

public class PVJRegistryEvents
{
	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event)
	{
		IForgeRegistry<Block> registry = event.getRegistry();
		for(Block block : PVJBlocks.BLOCKS)
		{
			registry.register(block);
		}
	}
	
	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event)
	{
		IForgeRegistry<Item> registry = event.getRegistry();
		for(Item item : PVJItems.ITEMS)
		{
			registry.register(item);
		}
	}
	
	@SubscribeEvent
	public void registerItemModels(ModelRegistryEvent event)
	{
		for(Block block : PVJBlocks.BLOCKS)
		{
			ProjectVibrantJourneys.proxy.registerItemRenderer(Item.getItemFromBlock(block));
			
			if(block instanceof IPropertyHelper)
			{
				IPropertyHelper PVJBlock = (IPropertyHelper)block;
				ImmutableList<IBlockState> properties = PVJBlock.getProperties();
				for(IBlockState state : properties)
				{
					int meta = block.getMetaFromState(state);
					ModelResourceLocation resource = new ModelResourceLocation(block.getRegistryName(), "inventory");
					ProjectVibrantJourneys.proxy.registerItemVariantRenderer(Item.getItemFromBlock(block), meta, resource);
				}
			}
			if(block instanceof BlockPVJDoor)
				ProjectVibrantJourneys.proxy.setIgnoredPropertiesForModel(Item.getItemFromBlock(block), BlockPVJDoor.POWERED);
			if(block instanceof BlockPVJFenceGate)
				ProjectVibrantJourneys.proxy.setIgnoredPropertiesForModel(Item.getItemFromBlock(block), BlockPVJFenceGate.POWERED);
		}
		
		for(Item item : PVJItems.ITEMS)
		{
			ProjectVibrantJourneys.proxy.registerItemRenderer(item);
		}
		
		ProjectVibrantJourneys.proxy.setIgnoredPropertiesForModel(Item.getItemFromBlock(PVJBlocks.mystical_grill), BlockMysticalGrill.IS_COOKING);
	}
	
	/*
	@SubscribeEvent
	public void registerBiomes(RegistryEvent.Register<Biome> event)
	{
		IForgeRegistry<Biome> registry = event.getRegistry();
		for(Biome biome : PVJBiomes.BIOMES)
		{
			registry.register(biome);
		}
	}*/
	
	@SubscribeEvent
	public void registerEntities(RegistryEvent.Register<EntityEntry> event)
	{
		IForgeRegistry<EntityEntry> registry = event.getRegistry();
		for(EntityEntry entity : PVJEntities.ENTITIES)
		{
			registry.register(entity);
		}
		
		ProjectVibrantJourneys.proxy.registerEntityRenderers();
	}
	
	@SubscribeEvent
	public void registerSounds(RegistryEvent.Register<SoundEvent> event)
	{
		IForgeRegistry<SoundEvent> registry = event.getRegistry();
		for(SoundEvent sound : PVJSounds.SOUND_EVENTS)
		{
			registry.register(sound);
		}
	}
}
