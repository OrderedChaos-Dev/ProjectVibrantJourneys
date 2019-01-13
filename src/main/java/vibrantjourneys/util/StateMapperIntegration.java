package vibrantjourneys.util;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.util.ResourceLocation;

public class StateMapperIntegration extends StateMapperBase
{
	private String modid;
	
	public StateMapperIntegration(String modid)
	{
		this.modid = modid;
	}
	
	@Override
	protected ModelResourceLocation getModelResourceLocation(IBlockState state)
	{
		ResourceLocation rl = Block.REGISTRY.getNameForObject(state.getBlock());
		ModelResourceLocation mrl = new ModelResourceLocation(Reference.MOD_ID + ":" + modid + "/" + rl.getPath());
		return mrl;
	}

}
