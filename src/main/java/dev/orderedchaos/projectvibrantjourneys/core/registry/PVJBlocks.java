package dev.orderedchaos.projectvibrantjourneys.core.registry;

import dev.orderedchaos.projectvibrantjourneys.common.blocks.*;
import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class PVJBlocks {
  public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ProjectVibrantJourneys.MOD_ID);

  /* OVERWORLD FLORA */
  public static final DeferredBlock<Block> BEACH_GRASS = registerBlock("beach_grass",
    () -> new BeachGrassBlock(BlockBehaviorTemplates.REPLACEABLE_PLANT));
  public static final DeferredBlock<Block> SEA_OATS = registerBlock("sea_oats",
    () -> new SeaOatsBlock(BlockBehaviorTemplates.REPLACEABLE_PLANT));
  public static final DeferredBlock<Block> CATTAIL = registerBlock("cattail",
    () -> new DoubleHighWaterPlantBlock(BlockBehaviorTemplates.REPLACEABLE_PLANT, true));
  public static final DeferredBlock<Block> BARK_MUSHROOM = registerBlock("bark_mushroom",
    () -> new BarkMushroomBlock(BlockBehaviorTemplates.BARK_MUSHROOM));
  public static final DeferredBlock<Block> LIGHT_BROWN_BARK_MUSHROOM = registerBlock("light_brown_bark_mushroom",
    () -> new BarkMushroomBlock(BlockBehaviorTemplates.BARK_MUSHROOM));
  public static final DeferredBlock<Block> ORANGE_BARK_MUSHROOM = registerBlock("orange_bark_mushroom",
    () -> new BarkMushroomBlock(BlockBehaviorTemplates.BARK_MUSHROOM));
  public static final DeferredBlock<Block> GLOWING_BLUE_FUNGUS = registerBlock("glowing_blue_fungus",
    () -> new GlowingFungusBlock(BlockBehaviorTemplates.BARK_MUSHROOM.lightLevel((state) -> 6).sound(SoundType.SMALL_DRIPLEAF).emissiveRendering((state, level, pos) -> true)));
  public static final DeferredBlock<Block> SHORT_GRASS = registerBlock("short_grass",
    () -> new ShortGrassBlock(BlockBehaviorTemplates.REPLACEABLE_PLANT));
  public static final DeferredBlock<Block> SMALL_CACTUS = registerBlock("small_cactus",
    () -> new SmallCactusBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).noCollission().instabreak().ignitedByLava().pushReaction(PushReaction.DESTROY).sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
  public static final DeferredBlock<Block> PRICKLY_BUSH = registerBlock("prickly_bush",
    () -> new ThornsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH).mapColor(MapColor.COLOR_BROWN)));
  public static final DeferredBlock<Block> REEDS = registerBlock("reeds",
    () -> new DoubleHighWaterPlantBlock(BlockBehaviorTemplates.REPLACEABLE_PLANT, true));
  public static final DeferredBlock<Block> ICICLE = registerBlock("icicle",
    () -> new IcicleBlock(BlockBehaviour.Properties.of().mapColor(MapColor.ICE).noOcclusion().sound(SoundType.GLASS).randomTicks().strength(1.5F, 3.0F).dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ)));
  public static final DeferredBlock<Block> SANDY_SPROUTS = registerBlock("sandy_sprouts",
    () -> new SandySproutsBlock(BlockBehaviorTemplates.REPLACEABLE_PLANT));
  public static final DeferredBlock<Block> WATERGRASS = registerBlock("watergrass",
          () -> new DoubleHighWaterPlantBlock(BlockBehaviorTemplates.REPLACEABLE_PLANT, false));

  /* NETHER FLORA */
  public static final DeferredBlock<Block> CRIMSON_NETTLE = registerBlock("crimson_nettle",
    () -> new NetherPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_NYLIUM).noCollission().instabreak().sound(SoundType.NETHER_SPROUTS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
  public static final DeferredBlock<Block> WARPED_NETTLE = registerBlock("warped_nettle",
    () -> new NetherPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_NYLIUM).noCollission().instabreak().sound(SoundType.NETHER_SPROUTS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
  public static final DeferredBlock<Block> CINDERCANE = registerBlock("cindercane",
    () -> new CindercaneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_STEM).noCollission().randomTicks().instabreak().sound(SoundType.TWISTING_VINES).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
  public static final DeferredBlock<Block> GLOWCAP = registerBlock("glowcap",
    () -> new GlowcapBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).lightLevel((state) -> 12).pushReaction(PushReaction.DESTROY)));

  /* GROUNDCOVER */
  public static final DeferredBlock<Block> FALLEN_LEAVES = registerBlock("oak_fallen_leaves",
    () -> new FallenLeavesBlock(Block.Properties.of().mapColor(MapColor.GRASS).noCollission().strength(0.1F, 0.0F).ignitedByLava().sound(SoundType.GRASS).noOcclusion().pushReaction(PushReaction.DESTROY)));
  public static final DeferredBlock<Block> DEAD_FALLEN_LEAVES = registerBlock("dead_fallen_leaves",
    () -> new FallenLeavesBlock(Block.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().strength(0.1F, 0.0F).ignitedByLava().sound(SoundType.GRASS).noOcclusion().pushReaction(PushReaction.DESTROY)));
  public static final DeferredBlock<Block> TWIGS = registerBlock("twigs",
    () -> new GroundcoverBlock(BlockBehaviorTemplates.groundcover(SoundType.CROP, true)));
  public static final DeferredBlock<Block> BIRCH_TWIGS = registerBlock("birch_twigs",
    () -> new GroundcoverBlock(BlockBehaviorTemplates.groundcover(SoundType.CROP, true)));
  public static final DeferredBlock<Block> ROCKS = registerBlock("rocks",
    () -> new GroundcoverBlock(BlockBehaviorTemplates.groundcover(SoundType.STONE, false)));
  public static final DeferredBlock<Block> MOSSY_ROCKS = registerBlock("mossy_rocks",
    () -> new GroundcoverBlock(BlockBehaviorTemplates.groundcover(SoundType.STONE, false)));
  public static final DeferredBlock<Block> SANDSTONE_ROCKS = registerBlock("sandstone_rocks",
    () -> new GroundcoverBlock(BlockBehaviorTemplates.groundcover(SoundType.STONE, false)));
  public static final DeferredBlock<Block> RED_SANDSTONE_ROCKS = registerBlock("red_sandstone_rocks",
    () -> new GroundcoverBlock(BlockBehaviorTemplates.groundcover(SoundType.STONE, false)));
  public static final DeferredBlock<Block> ICE_CHUNKS = registerBlock("ice_chunks",
    () -> new GroundcoverBlock(BlockBehaviorTemplates.groundcover(SoundType.GLASS, false)));
  public static final DeferredBlock<Block> BONES = registerBlock("bones",
    () -> new GroundcoverBlock(BlockBehaviorTemplates.groundcover(SoundType.BONE_BLOCK, false)));
  public static final DeferredBlock<Block> CHARRED_BONES = registerBlock("charred_bones",
    () -> new GroundcoverBlock(BlockBehaviorTemplates.groundcover(SoundType.BONE_BLOCK, false)));
  public static final DeferredBlock<Block> PINECONES = registerBlock("pinecones",
    () -> new GroundcoverBlock(BlockBehaviorTemplates.groundcover(SoundType.CROP, true)));
  public static final DeferredBlock<Block> SEASHELLS = registerBlock("seashells",
    () -> new GroundcoverBlock(BlockBehaviorTemplates.groundcover(SoundType.STONE, false)));

  public static final DeferredBlock<Block> BEACHED_KELP = registerBlockWithoutItem("beached_kelp",
          () -> new BeachedKelpBlock(BlockBehaviorTemplates.REPLACEABLE_PLANT.sound(SoundType.WET_GRASS).offsetType(BlockBehaviour.OffsetType.NONE)));
  public static final DeferredBlock<Block> DRIED_BEACHED_KELP = registerBlockWithoutItem("dried_beached_kelp",
          () -> new BeachedKelpBlock(BlockBehaviorTemplates.REPLACEABLE_PLANT.sound(SoundType.WET_GRASS).offsetType(BlockBehaviour.OffsetType.NONE)));

  public static final DeferredBlock<Block> FERROUS_GRAVEL = registerBlock("ferrous_gravel",
          () -> new ColoredFallingBlock(
                  new ColorRGBA(-8356741),
                  BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.SNARE).strength(0.6F).sound(SoundType.GRAVEL)
          )
  );

  public static final DeferredBlock<Block> GILDED_GRAVEL = registerBlock("gilded_gravel",
          () -> new ColoredFallingBlock(
                  new ColorRGBA(-8356741),
                  BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.SNARE).strength(0.6F).sound(SoundType.GRAVEL)
          )
  );

  /* MISC */
  public static final DeferredBlock<Block> NATURAL_COBWEB = registerBlockWithoutItem("natural_cobweb",
    NaturalCobwebBlock::new);

  public static final DeferredBlock<Block> OAK_HOLLOW_LOG = registerBlock("oak_hollow_log",
    () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
  public static final DeferredBlock<Block> BIRCH_HOLLOW_LOG = registerBlock("birch_hollow_log",
    () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LOG)));
  public static final DeferredBlock<Block> SPRUCE_HOLLOW_LOG = registerBlock("spruce_hollow_log",
    () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LOG)));
  public static final DeferredBlock<Block> JUNGLE_HOLLOW_LOG = registerBlock("jungle_hollow_log",
    () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LOG)));
  public static final DeferredBlock<Block> ACACIA_HOLLOW_LOG = registerBlock("acacia_hollow_log",
    () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LOG)));
  public static final DeferredBlock<Block> DARK_OAK_HOLLOW_LOG = registerBlock("dark_oak_hollow_log",
    () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LOG)));
  public static final DeferredBlock<Block> CHERRY_HOLLOW_LOG = registerBlock("cherry_hollow_log",
    () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_LOG)));
  public static final DeferredBlock<Block> MANGROVE_HOLLOW_LOG = registerBlock("mangrove_hollow_log",
    () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_LOG)));

  public static final DeferredBlock<Block> POTTED_GLOWCAP = registerBlockWithoutItem("potted_glowcap",
    () -> createFlowerPot(GLOWCAP.get()));
  public static final DeferredBlock<Block> POTTED_CRIMSON_NETTLE = registerBlockWithoutItem("potted_crimson_nettle",
    () -> createFlowerPot(CRIMSON_NETTLE.get()));
  public static final DeferredBlock<Block> POTTED_WARPED_NETTLE = registerBlockWithoutItem("potted_warped_nettle",
    () -> createFlowerPot(WARPED_NETTLE.get()));
  public static final DeferredBlock<Block> POTTED_CINDERCANE = registerBlockWithoutItem("potted_cindercane",
    () -> createFlowerPot(CINDERCANE.get()));
  public static final DeferredBlock<Block> POTTED_SMALL_CACTUS = registerBlockWithoutItem("potted_small_cactus",
    () -> createFlowerPot(SMALL_CACTUS.get()));
  public static final DeferredBlock<Block> POTTED_PRICKLY_BUSH = registerBlockWithoutItem("potted_prickly_bush",
    () -> createFlowerPot(PRICKLY_BUSH.get()));

  public static DeferredBlock<Block> registerBlock(String name, Supplier<Block> supplier, boolean addToCreativeTab) {
    DeferredBlock<Block> block = BLOCKS.register(name, supplier);
    DeferredItem<BlockItem> blockItem = PVJItems.ITEMS.registerSimpleBlockItem(name, block);
    if (addToCreativeTab) {
      PVJItems.ITEMS_FOR_CREATIVE_TAB.add(blockItem);
    }
    return block;
  }

  public static DeferredBlock<Block> registerBlock(String name, Supplier<Block> supplier) {
    return registerBlock(name, supplier, true);
  }

  public static DeferredBlock<Block> registerBlockWithoutItem(String name, Supplier<Block> supplier) {
    return BLOCKS.register(name, supplier);
  }

  public static Block createFlowerPot(Block plant) {
    Block block = new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, () -> plant, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).lightLevel((state) -> plant == GLOWCAP.get() ? 12 : 0));
    ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BuiltInRegistries.BLOCK.getKey(plant), () -> block);
    return block;
  }

  public static class BlockBehaviorTemplates {

    public static final BlockBehaviour.Properties REPLACEABLE_PLANT = replaceablePlant(null);
    public static final BlockBehaviour.Properties BARK_MUSHROOM = Block.Properties.of()
      .noCollission()
      .instabreak()
      .sound(SoundType.WOOD)
      .destroyTime(0.2F);

    public static BlockBehaviour.Properties replaceablePlant(@Nullable MapColor mapColorOverride) {
      return BlockBehaviour.Properties.of()
        .replaceable()
        .noCollission()
        .instabreak()
        .mapColor(mapColorOverride != null ? mapColorOverride : MapColor.PLANT)
        .sound(SoundType.GRASS)
        .offsetType(BlockBehaviour.OffsetType.XYZ)
        .ignitedByLava()
        .pushReaction(PushReaction.DESTROY);
    }

    private static BlockBehaviour.Properties groundcover(SoundType soundType, boolean isFlammable) {
      BlockBehaviour.Properties groundcover = Block.Properties.of()
        .strength(0.05F, 0.0F)
        .noOcclusion()
        .offsetType(BlockBehaviour.OffsetType.XZ)
        .pushReaction(PushReaction.DESTROY)
        .sound(soundType);

      if (isFlammable) {
        groundcover = groundcover.ignitedByLava();
      }

      return groundcover;
    }
  }
}
