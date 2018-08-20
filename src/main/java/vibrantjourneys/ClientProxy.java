package vibrantjourneys;

import net.minecraft.block.Block;
import net.minecraft.block.BlockNewLeaf;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import vibrantjourneys.entities.item.EntityPVJBoat;
import vibrantjourneys.entities.monster.EntityGoon;
import vibrantjourneys.entities.monster.EntityIceCube;
import vibrantjourneys.entities.monster.EntityShade;
import vibrantjourneys.entities.monster.EntitySkeletalKnight;
import vibrantjourneys.entities.neutral.EntityGhost;
import vibrantjourneys.entities.passive.EntityFirefly;
import vibrantjourneys.entities.passive.EntityFly;
import vibrantjourneys.entities.passive.EntitySnail;
import vibrantjourneys.entities.renderer.RenderFirefly;
import vibrantjourneys.entities.renderer.RenderFly;
import vibrantjourneys.entities.renderer.RenderGhost;
import vibrantjourneys.entities.renderer.RenderGoon;
import vibrantjourneys.entities.renderer.RenderIceCube;
import vibrantjourneys.entities.renderer.RenderPVJBoat;
import vibrantjourneys.entities.renderer.RenderShade;
import vibrantjourneys.entities.renderer.RenderSkeletalKnight;
import vibrantjourneys.entities.renderer.RenderSnail;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.integration.biomesoplenty.PVJRenderingHandlerBOP;
import vibrantjourneys.tileentities.TileEntityMysticalGrill;
import vibrantjourneys.tileentities.renderer.TileEntityMysticalGrillRenderer;
import vibrantjourneys.util.Reference;

public class ClientProxy implements ICommonProxy
{	
	@Override
	public void registerItemRenderer(Item item)
	{
		//Item.getItemFromBlock() gives the air block for blocks that do not have an item form
		if(item != Item.getItemFromBlock(Blocks.AIR))
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	@Override
	public void registerItemVariantRenderer(Item item, int meta, ModelResourceLocation resource)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, resource);
	}
	
	@Override
	public void setIgnoredPropertiesForModel(Item item, IProperty<?>... properties)
	{
		IStateMapper mapper = (new StateMap.Builder()).ignore(properties).build();
		ModelLoader.setCustomStateMapper(Block.getBlockFromItem(item), mapper);
	}
	
	@Override
	public void registerBlockColor(IBlockColor iblockcolor, Block block)
	{
		Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(iblockcolor, block);
	}
	
	@Override
	public void registerItemColor(IItemColor iitemcolor, Item item)
	{
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(iitemcolor, item);
	}
	
	@Override
	public <T extends TileEntity> void registerTESRs()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMysticalGrill.class, new TileEntityMysticalGrillRenderer());
	}
	
	@Override
	public void registerEntityRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntitySnail.class, RenderSnail::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityFly.class, RenderFly::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityFirefly.class, RenderFirefly::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityGhost.class, RenderGhost::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityShade.class, RenderShade::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityIceCube.class, RenderIceCube::new);
		RenderingRegistry.registerEntityRenderingHandler(EntitySkeletalKnight.class, RenderSkeletalKnight::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityGoon.class, RenderGoon::new);
		
		RenderingRegistry.registerEntityRenderingHandler(EntityPVJBoat.class, RenderPVJBoat::new);
	}

	@Override
	public void registerBlockColors()
	{
    	registerFallenLeavesColors(PVJBlocks.fallenleaves_oak, BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK, Blocks.LEAVES, -1);
    	registerFallenLeavesColors(PVJBlocks.fallenleaves_birch, BlockOldLeaf.VARIANT, BlockPlanks.EnumType.BIRCH, Blocks.LEAVES, ColorizerFoliage.getFoliageColorBirch());
    	registerFallenLeavesColors(PVJBlocks.fallenleaves_spruce, BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE, Blocks.LEAVES, ColorizerFoliage.getFoliageColorPine());
    	registerFallenLeavesColors(PVJBlocks.fallenleaves_jungle, BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE, Blocks.LEAVES, -1);
    	registerFallenLeavesColors(PVJBlocks.fallenleaves_darkoak, BlockNewLeaf.VARIANT, BlockPlanks.EnumType.DARK_OAK, Blocks.LEAVES2, -1);
    	registerFallenLeavesColors(PVJBlocks.fallenleaves_acacia, BlockNewLeaf.VARIANT, BlockPlanks.EnumType.ACACIA, Blocks.LEAVES2, -1);
    	
    	registerFallenLeavesColors(PVJBlocks.oak_twigs, BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK, Blocks.LEAVES, -1);
    	registerFallenLeavesColors(PVJBlocks.birch_twigs, BlockOldLeaf.VARIANT, BlockPlanks.EnumType.BIRCH, Blocks.LEAVES, ColorizerFoliage.getFoliageColorBirch());
    	registerFallenLeavesColors(PVJBlocks.spruce_twigs, BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE, Blocks.LEAVES, ColorizerFoliage.getFoliageColorPine());
    	registerFallenLeavesColors(PVJBlocks.jungle_twigs, BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE, Blocks.LEAVES, -1);
    	registerFallenLeavesColors(PVJBlocks.dark_oak_twigs, BlockNewLeaf.VARIANT, BlockPlanks.EnumType.DARK_OAK, Blocks.LEAVES2, -1);
    	registerFallenLeavesColors(PVJBlocks.acacia_twigs, BlockNewLeaf.VARIANT, BlockPlanks.EnumType.ACACIA, Blocks.LEAVES2, -1);
    	
    	if(Reference.isBOPLoaded)
    		PVJRenderingHandlerBOP.registerBOPColors();
	}
	
    public void registerFallenLeavesColors(Block leafBlock, PropertyEnum<EnumType> property, BlockPlanks.EnumType type, Block leaf, int color)
    {
    	BlockColors blockColors = Minecraft.getMinecraft().getBlockColors();
    	IBlockState leafState = leaf.getDefaultState();

    	IBlockColor blockColor = new IBlockColor(){

			@Override
			public int colorMultiplier(IBlockState state, IBlockAccess world, BlockPos pos, int tintIndex)
			{
				if(world != null && pos != null)
					return BiomeColorHelper.getFoliageColorAtPos(world, pos);
				else
					return ColorizerFoliage.getFoliageColorBasic();
			}
    	};
    	
    	//set color to -1 to use the biome foliage color
    	if(color == -1)
    		ProjectVibrantJourneys.proxy.registerBlockColor(blockColor, leafBlock);
    	else
    		ProjectVibrantJourneys.proxy.registerBlockColor((state, world, pos, tintindex) -> color, leafBlock);
    	
    	ProjectVibrantJourneys.proxy.registerItemColor((stack, tintindex) -> 
    		blockColors.colorMultiplier(leafState.withProperty(property, type), null, null, tintindex), 
    		Item.getItemFromBlock(leafBlock));
    }
}