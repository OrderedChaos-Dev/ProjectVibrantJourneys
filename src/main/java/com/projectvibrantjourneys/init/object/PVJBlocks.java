package com.projectvibrantjourneys.init.object;

import java.util.List;
import java.util.function.Supplier;

import com.projectvibrantjourneys.blocks.BarkMushroomBlock;
import com.projectvibrantjourneys.blocks.BeachGrassBlock;
import com.projectvibrantjourneys.blocks.BerriedJuniperLeavesBlock;
import com.projectvibrantjourneys.blocks.CattailBlock;
import com.projectvibrantjourneys.blocks.CindercaneBlock;
import com.projectvibrantjourneys.blocks.CoconutBlock;
import com.projectvibrantjourneys.blocks.CustomSubstrateSaplingBlock;
import com.projectvibrantjourneys.blocks.DryGrassBlock;
import com.projectvibrantjourneys.blocks.FallenLeavesBlock;
import com.projectvibrantjourneys.blocks.GlowcapBlock;
import com.projectvibrantjourneys.blocks.GroundcoverBlock;
import com.projectvibrantjourneys.blocks.MangroveSaplingBlock;
import com.projectvibrantjourneys.blocks.NaturalCobwebBlock;
import com.projectvibrantjourneys.blocks.NetherPlantBlock;
import com.projectvibrantjourneys.blocks.PrairieGrassBlock;
import com.projectvibrantjourneys.blocks.SeaOatsBlock;
import com.projectvibrantjourneys.blocks.ShortGrassBlock;
import com.projectvibrantjourneys.blocks.SmallCactusBlock;
import com.projectvibrantjourneys.blocks.grower.AspenTreeGrower;
import com.projectvibrantjourneys.blocks.grower.BaobabTreeGrower;
import com.projectvibrantjourneys.blocks.grower.CottonwoodTreeGrower;
import com.projectvibrantjourneys.blocks.grower.FirTreeGrower;
import com.projectvibrantjourneys.blocks.grower.JoshuaTreeGrower;
import com.projectvibrantjourneys.blocks.grower.JuniperTreeGrower;
import com.projectvibrantjourneys.blocks.grower.MangroveTreeGrower;
import com.projectvibrantjourneys.blocks.grower.OrangeMapleTreeGrower;
import com.projectvibrantjourneys.blocks.grower.PalmTreeGrower;
import com.projectvibrantjourneys.blocks.grower.PineTreeGrower;
import com.projectvibrantjourneys.blocks.grower.PinkSakuraTreeGrower;
import com.projectvibrantjourneys.blocks.grower.PurpleMapleTreeGrower;
import com.projectvibrantjourneys.blocks.grower.RedMapleTreeGrower;
import com.projectvibrantjourneys.blocks.grower.RedwoodTreeGrower;
import com.projectvibrantjourneys.blocks.grower.TamarackTreeGrower;
import com.projectvibrantjourneys.blocks.grower.WhiteSakuraTreeGrower;
import com.projectvibrantjourneys.blocks.grower.WillowTreeGrower;
import com.projectvibrantjourneys.core.ProjectVibrantJourneys;
import com.projectvibrantjourneys.init.PVJCreativeModeTab;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PVJBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ProjectVibrantJourneys.MOD_ID);
	
	public static final Block[] TERRACOTTA_BLOCKS = {
			Blocks.TERRACOTTA, Blocks.WHITE_TERRACOTTA, Blocks.ORANGE_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA,
			Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.YELLOW_TERRACOTTA, Blocks.LIME_TERRACOTTA, Blocks.PINK_TERRACOTTA,
			Blocks.GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.CYAN_TERRACOTTA, Blocks.PURPLE_TERRACOTTA,
			Blocks.BLUE_TERRACOTTA, Blocks.BROWN_TERRACOTTA, Blocks.GREEN_TERRACOTTA, Blocks.RED_TERRACOTTA,
			Blocks.BLACK_TERRACOTTA
	};
	
	public static final RegistryObject<Block> beach_grass = registerBlock("beach_grass", () -> new BeachGrassBlock());
	public static final RegistryObject<Block> sea_oats = registerBlock("sea_oats", () -> new SeaOatsBlock());
	public static final RegistryObject<Block> cattail = registerBlock("cattail", () -> new CattailBlock());
	public static final RegistryObject<Block> crimson_nettle = registerBlock("crimson_nettle", () -> new NetherPlantBlock(MaterialColor.CRIMSON_NYLIUM));
	public static final RegistryObject<Block> warped_nettle = registerBlock("warped_nettle", () -> new NetherPlantBlock(MaterialColor.WARPED_NYLIUM));
	public static final RegistryObject<Block> cindercane = registerBlockWithFuel("cindercane", 800, () -> new CindercaneBlock());
	public static final RegistryObject<Block> glowcap = registerBlock("glowcap", () -> new GlowcapBlock());
	public static final RegistryObject<Block> bark_mushroom = registerBlockWithFuel("bark_mushroom", 100, () -> new BarkMushroomBlock());
	public static final RegistryObject<Block> short_grass = registerBlock("short_grass", () -> new ShortGrassBlock());
	public static final RegistryObject<Block> natural_cobweb = registerBlockWithoutItem("natural_cobweb", () -> new NaturalCobwebBlock());
	public static final RegistryObject<Block> small_cactus = registerBlock("small_cactus", () -> new SmallCactusBlock());
	public static final RegistryObject<Block> desert_sage = registerBlock("desert_sage", () -> new BeachGrassBlock());
	public static final RegistryObject<Block> desert_agave = registerBlock("desert_agave", () -> new BeachGrassBlock());
	public static final RegistryObject<Block> blooming_desert_agave = registerBlock("blooming_desert_agave", () -> new SeaOatsBlock());
	public static final RegistryObject<Block> prairie_grass = registerBlock("prairie_grass", () -> new PrairieGrassBlock());
	public static final RegistryObject<Block> dry_grass = registerBlock("dry_grass", () -> new DryGrassBlock());
	
	public static final RegistryObject<Block> twigs = registerBlockWithFuel("twigs", 100, () -> new GroundcoverBlock());
	public static final RegistryObject<Block> fallen_leaves = registerBlock("fallen_leaves", () -> new FallenLeavesBlock());
	public static final RegistryObject<Block> rocks = registerBlock("rocks", () -> new GroundcoverBlock());
	public static final RegistryObject<Block> mossy_rocks = registerBlock("mossy_rocks", () -> new GroundcoverBlock());
	public static final RegistryObject<Block> sandstone_rocks = registerBlock("sandstone_rocks", () -> new GroundcoverBlock());
	public static final RegistryObject<Block> red_sandstone_rocks = registerBlock("red_sandstone_rocks", () -> new GroundcoverBlock());
	public static final RegistryObject<Block> ice_chunks = registerBlock("ice_chunks", () -> new GroundcoverBlock());
	public static final RegistryObject<Block> bones = registerBlock("bones", () -> new GroundcoverBlock());
	public static final RegistryObject<Block> charred_bones = registerBlock("charred_bones", () -> new GroundcoverBlock());
	public static final RegistryObject<Block> pinecones = registerBlockWithFuel("pinecones", 100, () -> new GroundcoverBlock());
	public static final RegistryObject<Block> seashells = registerBlock("seashells", () -> new GroundcoverBlock());
	
	public static final RegistryObject<Block> aspen_fallen_leaves = registerBlock("aspen_fallen_leaves", () -> new FallenLeavesBlock());
	public static final RegistryObject<Block> red_maple_fallen_leaves = registerBlock("red_maple_fallen_leaves", () -> new FallenLeavesBlock());
	public static final RegistryObject<Block> orange_maple_fallen_leaves = registerBlock("orange_maple_fallen_leaves", () -> new FallenLeavesBlock());
	public static final RegistryObject<Block> purple_maple_fallen_leaves = registerBlock("purple_maple_fallen_leaves", () -> new FallenLeavesBlock());
	public static final RegistryObject<Block> pink_sakura_fallen_leaves = registerBlock("pink_sakura_fallen_leaves", () -> new FallenLeavesBlock());
	public static final RegistryObject<Block> white_sakura_fallen_leaves = registerBlock("white_sakura_fallen_leaves", () -> new FallenLeavesBlock());
	
	public static final RegistryObject<Block> coconut = registerBlock("coconut", () -> new CoconutBlock());
	
	public static final RegistryObject<Block> stripped_fir_log = registerBlockWithFuel("stripped_fir_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> stripped_fir_wood = registerBlockWithFuel("stripped_fir_wood", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> fir_sapling = registerBlockWithFuel("fir_sapling", 100, () -> new SaplingBlock(new FirTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> fir_log = registerBlockWithFuel("fir_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_fir_log.get()));
	public static final RegistryObject<Block> fir_leaves = registerBlock("fir_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> fir_wood = registerBlockWithFuel("fir_wood", 300, () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_fir_wood.get()));
	public static final RegistryObject<Block> fir_planks = registerBlockWithFuel("fir_planks", 300, () -> createPlanksBlock());
	public static final RegistryObject<Block> fir_pressure_plate = registerBlockWithFuel("fir_pressure_plate", 300, () -> createPressurePlate(fir_planks.get().defaultMaterialColor()));
	public static final RegistryObject<Block> fir_trapdoor = registerBlockWithFuel("fir_trapdoor", 300, () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> fir_button = registerBlockWithFuel("fir_button", 100, () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)));
	public static final RegistryObject<Block> fir_slab = registerBlockWithFuel("fir_slab", 150, () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> fir_fence_gate = registerBlockWithFuel("fir_fence_gate", 300, () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)));
	public static final RegistryObject<Block> fir_fence = registerBlockWithFuel("fir_fence", 300, () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)));
	public static final RegistryObject<Block> fir_door = registerBlockWithFuel("fir_door", 200, () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)));
	public static final RegistryObject<Block> fir_stairs = registerBlockWithFuel("fir_stairs", 300, () -> new StairBlock(fir_planks.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)));
	
	public static final RegistryObject<Block> stripped_pine_log = registerBlockWithFuel("stripped_pine_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> stripped_pine_wood = registerBlockWithFuel("stripped_pine_wood", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> pine_sapling = registerBlockWithFuel("pine_sapling", 100, () -> new SaplingBlock(new PineTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> pine_log = registerBlockWithFuel("pine_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_pine_log.get()));
	public static final RegistryObject<Block> pine_leaves = registerBlock("pine_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> pine_wood = registerBlockWithFuel("pine_wood", 300, () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_pine_wood.get()));
	public static final RegistryObject<Block> pine_planks = registerBlockWithFuel("pine_planks", 300, () -> createPlanksBlock());
	public static final RegistryObject<Block> pine_pressure_plate = registerBlockWithFuel("pine_pressure_plate", 300, () -> createPressurePlate(pine_planks.get().defaultMaterialColor()));
	public static final RegistryObject<Block> pine_trapdoor = registerBlockWithFuel("pine_trapdoor", 300, () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> pine_button = registerBlockWithFuel("pine_button", 100, () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)));
	public static final RegistryObject<Block> pine_slab = registerBlockWithFuel("pine_slab", 150, () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> pine_fence_gate = registerBlockWithFuel("pine_fence_gate", 300, () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)));
	public static final RegistryObject<Block> pine_fence = registerBlockWithFuel("pine_fence", 300, () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)));
	public static final RegistryObject<Block> pine_door = registerBlockWithFuel("pine_door", 200, () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)));
	public static final RegistryObject<Block> pine_stairs = registerBlockWithFuel("pine_stairs", 300, () -> new StairBlock(pine_planks.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)));
	
	public static final RegistryObject<Block> stripped_redwood_log = registerBlockWithFuel("stripped_redwood_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> stripped_redwood_wood = registerBlockWithFuel("stripped_redwood_wood", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> redwood_sapling = registerBlockWithFuel("redwood_sapling", 100, () -> new SaplingBlock(new RedwoodTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> redwood_log = registerBlockWithFuel("redwood_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_redwood_log.get()));
	public static final RegistryObject<Block> redwood_leaves = registerBlock("redwood_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> redwood_wood = registerBlockWithFuel("redwood_wood", 300, () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_redwood_wood.get()));
	public static final RegistryObject<Block> redwood_planks = registerBlockWithFuel("redwood_planks", 300, () -> createPlanksBlock());
	public static final RegistryObject<Block> redwood_pressure_plate = registerBlockWithFuel("redwood_pressure_plate", 300, () -> createPressurePlate(redwood_planks.get().defaultMaterialColor()));
	public static final RegistryObject<Block> redwood_trapdoor = registerBlockWithFuel("redwood_trapdoor", 300, () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> redwood_button = registerBlockWithFuel("redwood_button", 100, () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)));
	public static final RegistryObject<Block> redwood_slab = registerBlockWithFuel("redwood_slab", 150, () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> redwood_fence_gate = registerBlockWithFuel("redwood_fence_gate", 300, () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)));
	public static final RegistryObject<Block> redwood_fence = registerBlockWithFuel("redwood_fence", 300, () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)));
	public static final RegistryObject<Block> redwood_door = registerBlockWithFuel("redwood_door", 200, () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)));
	public static final RegistryObject<Block> redwood_stairs = registerBlockWithFuel("redwood_stairs", 300, () -> new StairBlock(redwood_planks.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)));
	
	public static final RegistryObject<Block> stripped_willow_log = registerBlockWithFuel("stripped_willow_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> stripped_willow_wood = registerBlockWithFuel("stripped_willow_wood", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> willow_sapling = registerBlockWithFuel("willow_sapling", 100, () -> new CustomSubstrateSaplingBlock(new WillowTreeGrower(), List.of(Tags.Blocks.SAND)));
	public static final RegistryObject<Block> willow_log = registerBlockWithFuel("willow_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_willow_log.get()));
	public static final RegistryObject<Block> willow_leaves = registerBlock("willow_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> willow_wood = registerBlockWithFuel("willow_wood", 300, () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_willow_wood.get()));
	public static final RegistryObject<Block> willow_planks = registerBlockWithFuel("willow_planks", 300, () -> createPlanksBlock());
	public static final RegistryObject<Block> willow_pressure_plate = registerBlockWithFuel("willow_pressure_plate", 300, () -> createPressurePlate(willow_planks.get().defaultMaterialColor()));
	public static final RegistryObject<Block> willow_trapdoor = registerBlockWithFuel("willow_trapdoor", 300, () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> willow_button = registerBlockWithFuel("willow_button", 100, () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)));
	public static final RegistryObject<Block> willow_slab = registerBlockWithFuel("willow_slab", 150, () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> willow_fence_gate = registerBlockWithFuel("willow_fence_gate", 300, () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)));
	public static final RegistryObject<Block> willow_fence = registerBlockWithFuel("willow_fence", 300, () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)));
	public static final RegistryObject<Block> willow_door = registerBlockWithFuel("willow_door", 200, () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)));
	public static final RegistryObject<Block> willow_stairs = registerBlockWithFuel("willow_stairs", 300, () -> new StairBlock(willow_planks.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)));
	
	public static final RegistryObject<Block> stripped_mangrove_log = registerBlockWithFuel("stripped_mangrove_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> stripped_mangrove_wood = registerBlockWithFuel("stripped_mangrove_wood", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> mangrove_sapling = registerBlockWithFuel("mangrove_sapling", 100, () -> new MangroveSaplingBlock(new MangroveTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> mangrove_log = registerBlockWithFuel("mangrove_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_mangrove_log.get()));
	public static final RegistryObject<Block> mangrove_leaves = registerBlock("mangrove_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> mangrove_wood = registerBlockWithFuel("mangrove_wood", 300, () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_mangrove_wood.get()));
	public static final RegistryObject<Block> mangrove_planks = registerBlockWithFuel("mangrove_planks", 300, () -> createPlanksBlock());
	public static final RegistryObject<Block> mangrove_pressure_plate = registerBlockWithFuel("mangrove_pressure_plate", 300, () -> createPressurePlate(mangrove_planks.get().defaultMaterialColor()));
	public static final RegistryObject<Block> mangrove_trapdoor = registerBlockWithFuel("mangrove_trapdoor", 300, () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> mangrove_button = registerBlockWithFuel("mangrove_button", 100, () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)));
	public static final RegistryObject<Block> mangrove_slab = registerBlockWithFuel("mangrove_slab", 150, () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> mangrove_fence_gate = registerBlockWithFuel("mangrove_fence_gate", 300, () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)));
	public static final RegistryObject<Block> mangrove_fence = registerBlockWithFuel("mangrove_fence", 300, () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)));
	public static final RegistryObject<Block> mangrove_door = registerBlockWithFuel("mangrove_door", 200, () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)));
	public static final RegistryObject<Block> mangrove_stairs = registerBlockWithFuel("mangrove_stairs", 300, () -> new StairBlock(mangrove_planks.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)));
	
	public static final RegistryObject<Block> stripped_palm_log = registerBlockWithFuel("stripped_palm_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> stripped_palm_wood = registerBlockWithFuel("stripped_palm_wood", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> palm_sapling = registerBlockWithFuel("palm_sapling", 100, () -> new CustomSubstrateSaplingBlock(new PalmTreeGrower(), List.of(Tags.Blocks.SAND)));
	public static final RegistryObject<Block> palm_log = registerBlockWithFuel("palm_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_palm_log.get()));
	public static final RegistryObject<Block> palm_leaves = registerBlock("palm_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> palm_wood = registerBlockWithFuel("palm_wood", 300, () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_palm_wood.get()));
	public static final RegistryObject<Block> palm_planks = registerBlockWithFuel("palm_planks", 300, () -> createPlanksBlock());
	public static final RegistryObject<Block> palm_pressure_plate = registerBlockWithFuel("palm_pressure_plate", 300, () -> createPressurePlate(palm_planks.get().defaultMaterialColor()));
	public static final RegistryObject<Block> palm_trapdoor = registerBlockWithFuel("palm_trapdoor", 300, () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> palm_button = registerBlockWithFuel("palm_button", 100, () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)));
	public static final RegistryObject<Block> palm_slab = registerBlockWithFuel("palm_slab", 150, () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> palm_fence_gate = registerBlockWithFuel("palm_fence_gate", 300, () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)));
	public static final RegistryObject<Block> palm_fence = registerBlockWithFuel("palm_fence", 300, () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)));
	public static final RegistryObject<Block> palm_door = registerBlockWithFuel("palm_door", 200,  () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)));
	public static final RegistryObject<Block> palm_stairs = registerBlockWithFuel("palm_stairs", 300, () -> new StairBlock(palm_planks.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)));
	
	public static final RegistryObject<Block> stripped_cottonwood_log = registerBlockWithFuel("stripped_cottonwood_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> stripped_cottonwood_wood = registerBlockWithFuel("stripped_cottonwood_wood", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> cottonwood_sapling = registerBlockWithFuel("cottonwood_sapling", 100, () -> new SaplingBlock(new CottonwoodTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> cottonwood_log = registerBlockWithFuel("cottonwood_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_cottonwood_log.get()));
	public static final RegistryObject<Block> cottonwood_leaves = registerBlock("cottonwood_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> cottonwood_wood = registerBlockWithFuel("cottonwood_wood", 300, () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_cottonwood_wood.get()));
	public static final RegistryObject<Block> cottonwood_planks = registerBlockWithFuel("cottonwood_planks", 300, () -> createPlanksBlock());
	public static final RegistryObject<Block> cottonwood_pressure_plate = registerBlockWithFuel("cottonwood_pressure_plate", 300, () -> createPressurePlate(cottonwood_planks.get().defaultMaterialColor()));
	public static final RegistryObject<Block> cottonwood_trapdoor = registerBlockWithFuel("cottonwood_trapdoor", 300, () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> cottonwood_button = registerBlockWithFuel("cottonwood_button", 100, () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)));
	public static final RegistryObject<Block> cottonwood_slab = registerBlockWithFuel("cottonwood_slab", 150, () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> cottonwood_fence_gate = registerBlockWithFuel("cottonwood_fence_gate", 300, () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)));
	public static final RegistryObject<Block> cottonwood_fence = registerBlockWithFuel("cottonwood_fence", 300, () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)));
	public static final RegistryObject<Block> cottonwood_door = registerBlockWithFuel("cottonwood_door", 200, () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)));
	public static final RegistryObject<Block> cottonwood_stairs = registerBlockWithFuel("cottonwood_stairs", 300, () -> new StairBlock(cottonwood_planks.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)));
	
	public static final RegistryObject<Block> stripped_aspen_log = registerBlockWithFuel("stripped_aspen_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> stripped_aspen_wood = registerBlockWithFuel("stripped_aspen_wood", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> aspen_sapling = registerBlockWithFuel("aspen_sapling", 100, () -> new SaplingBlock(new AspenTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> aspen_log = registerBlockWithFuel("aspen_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_aspen_log.get()));
	public static final RegistryObject<Block> aspen_leaves = registerBlock("aspen_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> aspen_wood = registerBlockWithFuel("aspen_wood", 300, () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_aspen_wood.get()));
	public static final RegistryObject<Block> aspen_planks = registerBlockWithFuel("aspen_planks", 300, () -> createPlanksBlock());
	public static final RegistryObject<Block> aspen_pressure_plate = registerBlockWithFuel("aspen_pressure_plate", 300, () -> createPressurePlate(aspen_planks.get().defaultMaterialColor()));
	public static final RegistryObject<Block> aspen_trapdoor = registerBlockWithFuel("aspen_trapdoor", 300, () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> aspen_button = registerBlockWithFuel("aspen_button", 100, () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)));
	public static final RegistryObject<Block> aspen_slab = registerBlockWithFuel("aspen_slab", 150, () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> aspen_fence_gate = registerBlockWithFuel("aspen_fence_gate", 300, () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)));
	public static final RegistryObject<Block> aspen_fence = registerBlockWithFuel("aspen_fence", 300, () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)));
	public static final RegistryObject<Block> aspen_door = registerBlockWithFuel("aspen_door", 200, () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)));
	public static final RegistryObject<Block> aspen_stairs = registerBlockWithFuel("aspen_stairs", 300, () -> new StairBlock(aspen_planks.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)));
	
	public static final RegistryObject<Block> stripped_juniper_log = registerBlockWithFuel("stripped_juniper_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> stripped_juniper_wood = registerBlockWithFuel("stripped_juniper_wood", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> juniper_sapling = registerBlockWithFuel("juniper_sapling", 100, () -> new CustomSubstrateSaplingBlock(new JuniperTreeGrower(), List.of(Tags.Blocks.SAND), TERRACOTTA_BLOCKS));
	public static final RegistryObject<Block> juniper_log = registerBlockWithFuel("juniper_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_juniper_log.get()));
	public static final RegistryObject<Block> berried_juniper_leaves = registerBlock("berried_juniper_leaves", () -> new BerriedJuniperLeavesBlock(Properties.copy(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> juniper_leaves = registerBlock("juniper_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> juniper_wood = registerBlockWithFuel("juniper_wood", 300, () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_juniper_wood.get()));
	public static final RegistryObject<Block> juniper_planks = registerBlockWithFuel("juniper_planks", 300, () -> createPlanksBlock());
	public static final RegistryObject<Block> juniper_pressure_plate = registerBlockWithFuel("juniper_pressure_plate", 300, () -> createPressurePlate(juniper_planks.get().defaultMaterialColor()));
	public static final RegistryObject<Block> juniper_trapdoor = registerBlockWithFuel("juniper_trapdoor", 300, () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> juniper_button = registerBlockWithFuel("juniper_button", 100, () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)));
	public static final RegistryObject<Block> juniper_slab = registerBlockWithFuel("juniper_slab", 150, () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> juniper_fence_gate = registerBlockWithFuel("juniper_fence_gate", 300, () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)));
	public static final RegistryObject<Block> juniper_fence = registerBlockWithFuel("juniper_fence", 300, () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)));
	public static final RegistryObject<Block> juniper_door = registerBlockWithFuel("juniper_door", 200, () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)));
	public static final RegistryObject<Block> juniper_stairs = registerBlockWithFuel("juniper_stairs", 300, () -> new StairBlock(juniper_planks.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)));
	
	public static final RegistryObject<Block> stripped_baobab_log = registerBlockWithFuel("stripped_baobab_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> stripped_baobab_wood = registerBlockWithFuel("stripped_baobab_wood", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> baobab_sapling = registerBlockWithFuel("baobab_sapling", 100, () -> new SaplingBlock(new BaobabTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> baobab_log = registerBlockWithFuel("baobab_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_baobab_log.get()));
	public static final RegistryObject<Block> baobab_leaves = registerBlock("baobab_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> baobab_wood = registerBlockWithFuel("baobab_wood", 300, () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_baobab_wood.get()));
	public static final RegistryObject<Block> baobab_planks = registerBlockWithFuel("baobab_planks", 300, () -> createPlanksBlock());
	public static final RegistryObject<Block> baobab_pressure_plate = registerBlockWithFuel("baobab_pressure_plate", 300, () -> createPressurePlate(baobab_planks.get().defaultMaterialColor()));
	public static final RegistryObject<Block> baobab_trapdoor = registerBlockWithFuel("baobab_trapdoor", 300, () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> baobab_button = registerBlockWithFuel("baobab_button", 100, () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)));
	public static final RegistryObject<Block> baobab_slab = registerBlockWithFuel("baobab_slab", 150, () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> baobab_fence_gate = registerBlockWithFuel("baobab_fence_gate", 300, () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)));
	public static final RegistryObject<Block> baobab_fence = registerBlockWithFuel("baobab_fence", 300, () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)));
	public static final RegistryObject<Block> baobab_door = registerBlockWithFuel("baobab_door", 200, () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)));
	public static final RegistryObject<Block> baobab_stairs = registerBlockWithFuel("baobab_stairs", 300, () -> new StairBlock(baobab_planks.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)));
	
	public static final RegistryObject<Block> stripped_maple_log = registerBlockWithFuel("stripped_maple_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> stripped_maple_wood = registerBlockWithFuel("stripped_maple_wood", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> red_maple_sapling = registerBlockWithFuel("red_maple_sapling", 100, () -> new SaplingBlock(new RedMapleTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> orange_maple_sapling = registerBlockWithFuel("orange_maple_sapling", 100, () -> new SaplingBlock(new OrangeMapleTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> purple_maple_sapling = registerBlockWithFuel("purple_maple_sapling", 100, () -> new SaplingBlock(new PurpleMapleTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> maple_log = registerBlockWithFuel("maple_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_maple_log.get()));
	public static final RegistryObject<Block> red_maple_leaves = registerBlock("red_maple_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)) { public MaterialColor defaultMaterialColor() { return MaterialColor.COLOR_RED; } });
	public static final RegistryObject<Block> orange_maple_leaves = registerBlock("orange_maple_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)) { public MaterialColor defaultMaterialColor() { return MaterialColor.COLOR_ORANGE; } });
	public static final RegistryObject<Block> purple_maple_leaves = registerBlock("purple_maple_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)) { public MaterialColor defaultMaterialColor() { return MaterialColor.COLOR_PURPLE; } });
	public static final RegistryObject<Block> maple_wood = registerBlockWithFuel("maple_wood", 300, () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_maple_wood.get()));
	public static final RegistryObject<Block> maple_planks = registerBlockWithFuel("maple_planks", 300, () -> createPlanksBlock());
	public static final RegistryObject<Block> maple_pressure_plate = registerBlockWithFuel("maple_pressure_plate", 300, () -> createPressurePlate(maple_planks.get().defaultMaterialColor()));
	public static final RegistryObject<Block> maple_trapdoor = registerBlockWithFuel("maple_trapdoor", 300, () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> maple_button = registerBlockWithFuel("maple_button", 100, () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)));
	public static final RegistryObject<Block> maple_slab = registerBlockWithFuel("maple_slab", 150, () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> maple_fence_gate = registerBlockWithFuel("maple_fence_gate", 300, () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)));
	public static final RegistryObject<Block> maple_fence = registerBlockWithFuel("maple_fence", 300, () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)));
	public static final RegistryObject<Block> maple_door = registerBlockWithFuel("maple_door", 200, () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)));
	public static final RegistryObject<Block> maple_stairs = registerBlockWithFuel("maple_stairs", 300, () -> new StairBlock(maple_planks.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)));
	
	public static final RegistryObject<Block> stripped_sakura_log = registerBlockWithFuel("stripped_sakura_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_RED, null));
	public static final RegistryObject<Block> stripped_sakura_wood = registerBlockWithFuel("stripped_sakura_wood", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_RED, null));
	public static final RegistryObject<Block> pink_sakura_sapling = registerBlockWithFuel("pink_sakura_sapling", 100, () -> new SaplingBlock(new PinkSakuraTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> white_sakura_sapling = registerBlockWithFuel("white_sakura_sapling", 100, () -> new SaplingBlock(new WhiteSakuraTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> sakura_log = registerBlockWithFuel("sakura_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_RED, () -> stripped_sakura_log.get()));
	public static final RegistryObject<Block> pink_sakura_leaves = registerBlock("pink_sakura_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> white_sakura_leaves = registerBlock("white_sakura_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> sakura_wood = registerBlockWithFuel("sakura_wood", 300, () -> createLogBlock(MaterialColor.COLOR_RED, MaterialColor.COLOR_RED, () -> stripped_sakura_wood.get()));
	public static final RegistryObject<Block> sakura_planks = registerBlockWithFuel("sakura_planks", 300, () -> createPlanksBlock());
	public static final RegistryObject<Block> sakura_pressure_plate = registerBlockWithFuel("sakura_pressure_plate", 300, () -> createPressurePlate(sakura_planks.get().defaultMaterialColor()));
	public static final RegistryObject<Block> sakura_trapdoor = registerBlockWithFuel("sakura_trapdoor", 300, () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> sakura_button = registerBlockWithFuel("sakura_button", 100, () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)));
	public static final RegistryObject<Block> sakura_slab = registerBlockWithFuel("sakura_slab", 150, () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> sakura_fence_gate = registerBlockWithFuel("sakura_fence_gate", 300, () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)));
	public static final RegistryObject<Block> sakura_fence = registerBlockWithFuel("sakura_fence", 300, () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)));
	public static final RegistryObject<Block> sakura_door = registerBlockWithFuel("sakura_door", 200, () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)));
	public static final RegistryObject<Block> sakura_stairs = registerBlockWithFuel("sakura_stairs", 300, () -> new StairBlock(sakura_planks.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)));
	
	public static final RegistryObject<Block> stripped_tamarack_log = registerBlockWithFuel("stripped_tamarack_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> stripped_tamarack_wood = registerBlockWithFuel("stripped_tamarack_wood", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> tamarack_sapling = registerBlockWithFuel("tamarack_sapling", 100, () -> new SaplingBlock(new TamarackTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> tamarack_log = registerBlockWithFuel("tamarack_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_tamarack_log.get()));
	public static final RegistryObject<Block> tamarack_leaves = registerBlock("tamarack_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> tamarack_wood = registerBlockWithFuel("tamarack_wood", 300, () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_tamarack_wood.get()));
	public static final RegistryObject<Block> tamarack_planks = registerBlockWithFuel("tamarack_planks", 300, () -> createPlanksBlock());
	public static final RegistryObject<Block> tamarack_pressure_plate = registerBlockWithFuel("tamarack_pressure_plate", 300, () -> createPressurePlate(tamarack_planks.get().defaultMaterialColor()));
	public static final RegistryObject<Block> tamarack_trapdoor = registerBlockWithFuel("tamarack_trapdoor", 300, () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> tamarack_button = registerBlockWithFuel("tamarack_button", 100, () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)));
	public static final RegistryObject<Block> tamarack_slab = registerBlockWithFuel("tamarack_slab", 150, () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> tamarack_fence_gate = registerBlockWithFuel("tamarack_fence_gate", 300, () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)));
	public static final RegistryObject<Block> tamarack_fence = registerBlockWithFuel( "tamarack_fence", 300, () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)));
	public static final RegistryObject<Block> tamarack_door = registerBlockWithFuel("tamarack_door", 200, () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)));
	public static final RegistryObject<Block> tamarack_stairs = registerBlockWithFuel("tamarack_stairs", 300, () -> new StairBlock(tamarack_planks.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)));
	
	public static final RegistryObject<Block> stripped_joshua_log = registerBlockWithFuel("stripped_joshua_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> stripped_joshua_wood = registerBlockWithFuel("stripped_joshua_wood", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null));
	public static final RegistryObject<Block> joshua_sapling = registerBlockWithFuel("joshua_sapling", 100, () -> new CustomSubstrateSaplingBlock(new JoshuaTreeGrower(), List.of(Tags.Blocks.SAND)));
	public static final RegistryObject<Block> joshua_log = registerBlockWithFuel("joshua_log", 300, () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_joshua_log.get()));
	public static final RegistryObject<Block> joshua_leaves = registerBlock("joshua_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> joshua_wood = registerBlockWithFuel("joshua_wood", 300, () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_joshua_wood.get()));
	public static final RegistryObject<Block> joshua_planks = registerBlockWithFuel("joshua_planks", 300, () -> createPlanksBlock());
	public static final RegistryObject<Block> joshua_pressure_plate = registerBlockWithFuel("joshua_pressure_plate", 300, () -> createPressurePlate(joshua_planks.get().defaultMaterialColor()));
	public static final RegistryObject<Block> joshua_trapdoor = registerBlockWithFuel("joshua_trapdoor", 300, () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> joshua_button = registerBlockWithFuel("joshua_button", 100, () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)));
	public static final RegistryObject<Block> joshua_slab = registerBlockWithFuel("joshua_slab", 150, () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> joshua_fence_gate = registerBlockWithFuel("joshua_fence_gate", 300, () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)));
	public static final RegistryObject<Block> joshua_fence = registerBlockWithFuel("joshua_fence", 300, () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)));
	public static final RegistryObject<Block> joshua_door = registerBlockWithFuel("joshua_door", 200, () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)));
	public static final RegistryObject<Block> joshua_stairs = registerBlockWithFuel("joshua_stairs", 300, () -> new StairBlock(joshua_planks.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)));
	
	public static final RegistryObject<Block> potted_glowcap = registerBlockWithoutItem("potted_glowcap", () -> createFlowerPot(glowcap.get()));
	public static final RegistryObject<Block> potted_crimson_nettle = registerBlockWithoutItem("potted_crimson_nettle", () -> createFlowerPot(crimson_nettle.get()));
	public static final RegistryObject<Block> potted_warped_nettle = registerBlockWithoutItem("potted_warped_nettle", () -> createFlowerPot(warped_nettle.get()));
	public static final RegistryObject<Block> potted_cindercane = registerBlockWithoutItem("potted_cindercane", () -> createFlowerPot(cindercane.get()));
	public static final RegistryObject<Block> potted_small_cactus = registerBlockWithoutItem("potted_small_cactus", () -> createFlowerPot(small_cactus.get()));
	
	public static final RegistryObject<Block> potted_palm_sapling = registerBlockWithoutItem("potted_palm_sapling", () -> createFlowerPot(palm_sapling.get()));
	public static final RegistryObject<Block> potted_redwood_sapling = registerBlockWithoutItem("potted_redwood_sapling", () -> createFlowerPot(redwood_sapling.get()));
	public static final RegistryObject<Block> potted_fir_sapling = registerBlockWithoutItem("potted_fir_sapling", () -> createFlowerPot(fir_sapling.get()));
	public static final RegistryObject<Block> potted_pine_sapling = registerBlockWithoutItem("potted_pine_sapling", () -> createFlowerPot(pine_sapling.get()));
	public static final RegistryObject<Block> potted_willow_sapling = registerBlockWithoutItem("potted_willow_sapling", () -> createFlowerPot(willow_sapling.get()));
	public static final RegistryObject<Block> potted_mangrove_sapling = registerBlockWithoutItem("potted_mangrove_sapling", () -> createFlowerPot(mangrove_sapling.get()));
	public static final RegistryObject<Block> potted_baobab_sapling = registerBlockWithoutItem("potted_baobab_sapling", () -> createFlowerPot(baobab_sapling.get()));
	public static final RegistryObject<Block> potted_juniper_sapling = registerBlockWithoutItem("potted_juniper_sapling", () -> createFlowerPot(juniper_sapling.get()));
	public static final RegistryObject<Block> potted_cottonwood_sapling = registerBlockWithoutItem("potted_cottonwood_sapling", () -> createFlowerPot(cottonwood_sapling.get()));
	public static final RegistryObject<Block> potted_aspen_sapling = registerBlockWithoutItem("potted_aspen_sapling", () -> createFlowerPot(aspen_sapling.get()));
	public static final RegistryObject<Block> potted_red_maple_sapling = registerBlockWithoutItem("potted_red_maple_sapling", () -> createFlowerPot(red_maple_sapling.get()));
	public static final RegistryObject<Block> potted_orange_maple_sapling = registerBlockWithoutItem("potted_orange_maple_sapling", () -> createFlowerPot(orange_maple_sapling.get()));
	public static final RegistryObject<Block> potted_purple_maple_sapling = registerBlockWithoutItem("potted_purple_maple_sapling", () -> createFlowerPot(purple_maple_sapling.get()));
	public static final RegistryObject<Block> potted_pink_sakura_sapling = registerBlockWithoutItem("potted_pink_sakura_sapling", () -> createFlowerPot(pink_sakura_sapling.get()));
	public static final RegistryObject<Block> potted_white_sakura_sapling = registerBlockWithoutItem("potted_white_sakura_sapling", () -> createFlowerPot(white_sakura_sapling.get()));
	public static final RegistryObject<Block> potted_tamarack_sapling = registerBlockWithoutItem("potted_tamarack_sapling", () -> createFlowerPot(tamarack_sapling.get()));
	public static final RegistryObject<Block> potted_joshua_sapling = registerBlockWithoutItem("potted_joshua_sapling", () -> createFlowerPot(joshua_sapling.get()));
	
	private static RegistryObject<Block> registerBlock(String name, Supplier<Block> block) {
		RegistryObject<Block> temp = BLOCKS.register(name, block);
		
		PVJItems.ITEMS.register(name, () -> new ItemNameBlockItem(temp.get(), new Item.Properties().tab(PVJCreativeModeTab.INSTANCE)));
		return temp;
	}
	
	private static RegistryObject<Block> registerBlockWithoutItem(String name, Supplier<Block> block) {
		ResourceLocation res = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name);

		return BLOCKS.register(name, block);
	}
	
	private static RegistryObject<Block> registerBlockWithFuel(String name, int burnTime, Supplier<Block> block) {
		return registerBlock(name, block);
//		ResourceLocation res = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name);
//		
//		ItemNameBlockItem item = new ItemNameBlockItem(block.get(), new Item.Properties().tab(PVJCreativeModeTab.INSTANCE)) {
//			@Override
//			public int getBurnTime(ItemStack stack, RecipeType type) {
//				return burnTime;
//			}
//		};
//		
//		PVJItems.ITEMS.register(name, () -> item);
//		return BLOCKS.register(name, block);
	}
	
	public static RotatedPillarBlock createLogBlock(MaterialColor topColor, MaterialColor barkColor, Supplier<Block> stripped) {
		return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (state) -> {
			return state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor;
		}).strength(2.0F).sound(SoundType.WOOD)) {
			@Override
			public BlockState getToolModifiedState(BlockState state, Level world, BlockPos pos, Player player, ItemStack stack, ToolAction toolType) {
				if(toolType == ToolActions.AXE_STRIP && stripped != null)
					return stripped.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));
				return super.getToolModifiedState(state, world, pos, player, stack, toolType);
			}
		};
	}
	
	public static PressurePlateBlock createPressurePlate(MaterialColor color) {
		return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
				BlockBehaviour.Properties.of(Material.WOOD, color).noCollission()
				.strength(0.5F).sound(SoundType.WOOD));
	}

	public static Block createPlanksBlock() {
		return new Block(Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F)
				.sound(SoundType.WOOD));
	}
	
	public static Block createFlowerPot(Block plant) {
		Block block = new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, ()-> plant, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT).lightLevel((state) -> plant == glowcap.get() ? 12 : 0));
		((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(plant.getRegistryName(), () -> block);
		return block;
	}
}
