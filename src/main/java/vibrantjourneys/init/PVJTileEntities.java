package vibrantjourneys.init;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import vibrantjourneys.tileentities.TileEntityCampfire;
import vibrantjourneys.tileentities.TileEntityChimneyTop;
import vibrantjourneys.tileentities.TileEntityCircuitBreaker;
import vibrantjourneys.tileentities.TileEntityMysticalGrill;
import vibrantjourneys.util.Reference;

public class PVJTileEntities
{
	public static void initTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityMysticalGrill.class, new ResourceLocation(Reference.MOD_ID, "mystical_grill"));
		GameRegistry.registerTileEntity(TileEntityChimneyTop.class, new ResourceLocation(Reference.MOD_ID, "chimney_top"));
		GameRegistry.registerTileEntity(TileEntityCampfire.class, new ResourceLocation(Reference.MOD_ID, "campfire"));
		GameRegistry.registerTileEntity(TileEntityCircuitBreaker.class, new ResourceLocation(Reference.MOD_ID, "circuit_breaker"));
	}
}
