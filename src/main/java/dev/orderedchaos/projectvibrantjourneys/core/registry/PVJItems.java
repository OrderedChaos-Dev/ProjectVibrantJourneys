package dev.orderedchaos.projectvibrantjourneys.core.registry;

import dev.orderedchaos.projectvibrantjourneys.common.items.FuelBlockItem;
import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class PVJItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ProjectVibrantJourneys.MOD_ID);

  public static final RegistryObject<Item> BEACH_GRASS = registerItem("beach_grass",
    () -> new BlockItem(PVJBlocks.BEACH_GRASS.get(), basicItem()));
  public static final RegistryObject<Item> SEA_OATS = registerItem("sea_oats",
    () -> new BlockItem(PVJBlocks.SEA_OATS.get(), basicItem()));
  public static final RegistryObject<Item> CATTAIL = registerItem("cattail",
    () -> new BlockItem(PVJBlocks.CATTAIL.get(), basicItem()));
  public static final RegistryObject<Item> BARK_MUSHROOM = registerItem("bark_mushroom",
    () -> new FuelBlockItem(PVJBlocks.BARK_MUSHROOM.get(), basicItem(), 100));
  public static final RegistryObject<Item> LIGHT_BROWN_BARK_MUSHROOM = registerItem("light_brown_bark_mushroom",
    () -> new FuelBlockItem(PVJBlocks.LIGHT_BROWN_BARK_MUSHROOM.get(), basicItem(), 100));
  public static final RegistryObject<Item> ORANGE_BARK_MUSHROOM = registerItem("orange_bark_mushroom",
    () -> new FuelBlockItem(PVJBlocks.ORANGE_BARK_MUSHROOM.get(), basicItem(), 100));
  public static final RegistryObject<Item> GLOWING_BLUE_FUNGUS = registerItem("glowing_blue_fungus",
    () -> new BlockItem(PVJBlocks.GLOWING_BLUE_FUNGUS.get(), basicItem()));
  public static final RegistryObject<Item> SHORT_GRASS = registerItem("short_grass",
    () -> new BlockItem(PVJBlocks.SHORT_GRASS.get(), basicItem()));
  public static final RegistryObject<Item> SMALL_CACTUS = registerItem("small_cactus",
    () -> new BlockItem(PVJBlocks.SMALL_CACTUS.get(), basicItem()));
  public static final RegistryObject<Item> PRICKLY_BUSH = registerItem("prickly_bush",
    () -> new BlockItem(PVJBlocks.PRICKLY_BUSH.get(), basicItem()));
  public static final RegistryObject<Item> REEDS = registerItem("reeds",
    () -> new BlockItem(PVJBlocks.REEDS.get(), basicItem()));
  public static final RegistryObject<Item> ICICLE = registerItem("icicle",
    () -> new BlockItem(PVJBlocks.ICICLE.get(), basicItem()));

  public static final RegistryObject<Item> CRIMSON_NETTLE = registerItem("crimson_nettle",
    () -> new BlockItem(PVJBlocks.CRIMSON_NETTLE.get(), basicItem()));
  public static final RegistryObject<Item> WARPED_NETTLE = registerItem("warped_nettle",
    () -> new BlockItem(PVJBlocks.WARPED_NETTLE.get(), basicItem()));
  public static final RegistryObject<Item> CINDERCANE = registerItem("cindercane",
    () -> new FuelBlockItem(PVJBlocks.CINDERCANE.get(), basicItem(), 800));
  public static final RegistryObject<Item> GLOWCAP = registerItem("glowcap",
    () -> new BlockItem(PVJBlocks.GLOWCAP.get(), basicItem()));

  public static final RegistryObject<Item> FALLEN_LEAVES = registerItem("fallen_leaves",
    () -> new BlockItem(PVJBlocks.FALLEN_LEAVES.get(), basicItem()));
  public static final RegistryObject<Item> DEAD_FALLEN_LEAVES = registerItem("dead_fallen_leaves",
    () -> new BlockItem(PVJBlocks.DEAD_FALLEN_LEAVES.get(), basicItem()));
  public static final RegistryObject<Item> TWIGS = registerItem("twigs",
    () -> new FuelBlockItem(PVJBlocks.TWIGS.get(), basicItem(), 100));
  public static final RegistryObject<Item> ROCKS = registerItem("rocks",
    () -> new BlockItem(PVJBlocks.ROCKS.get(), basicItem()));
  public static final RegistryObject<Item> MOSSY_ROCKS = registerItem("mossy_rocks",
    () -> new BlockItem(PVJBlocks.MOSSY_ROCKS.get(), basicItem()));
  public static final RegistryObject<Item> SANDSTONE_ROCKS = registerItem("sandstone_rocks",
    () -> new BlockItem(PVJBlocks.SANDSTONE_ROCKS.get(), basicItem()));
  public static final RegistryObject<Item> RED_SANDSTONE_ROCKS = registerItem("red_sandstone_rocks",
    () -> new BlockItem(PVJBlocks.RED_SANDSTONE_ROCKS.get(), basicItem()));
  public static final RegistryObject<Item> ICE_CHUNKS = registerItem("ice_chunks",
    () -> new BlockItem(PVJBlocks.ICE_CHUNKS.get(), basicItem()));
  public static final RegistryObject<Item> BONES = registerItem("bones",
    () -> new BlockItem(PVJBlocks.BONES.get(), basicItem()));
  public static final RegistryObject<Item> CHARRED_BONES = registerItem("charred_bones",
    () -> new BlockItem(PVJBlocks.CHARRED_BONES.get(), basicItem()));
  public static final RegistryObject<Item> PINECONES = registerItem("pinecones",
    () -> new FuelBlockItem(PVJBlocks.PINECONES.get(), basicItem(), 100));
  public static final RegistryObject<Item> SEASHELLS = registerItem("seashells",
    () -> new BlockItem(PVJBlocks.SEASHELLS.get(), basicItem()));

  public static final RegistryObject<Item> OAK_HOLLOW_LOG = registerItem("oak_hollow_log",
    () -> new FuelBlockItem(PVJBlocks.OAK_HOLLOW_LOG.get(), basicItem(), 300));
  public static final RegistryObject<Item> BIRCH_HOLLOW_LOG = registerItem("birch_hollow_log",
    () -> new FuelBlockItem(PVJBlocks.BIRCH_HOLLOW_LOG.get(), basicItem(), 300));
  public static final RegistryObject<Item> SPRUCE_HOLLOW_LOG = registerItem("spruce_hollow_log",
    () -> new FuelBlockItem(PVJBlocks.SPRUCE_HOLLOW_LOG.get(), basicItem(), 300));
  public static final RegistryObject<Item> JUNGLE_HOLLOW_LOG = registerItem("jungle_hollow_log",
    () -> new FuelBlockItem(PVJBlocks.JUNGLE_HOLLOW_LOG.get(), basicItem(), 300));
  public static final RegistryObject<Item> ACACIA_HOLLOW_LOG = registerItem("acacia_hollow_log",
    () -> new FuelBlockItem(PVJBlocks.ACACIA_HOLLOW_LOG.get(), basicItem(), 300));
  public static final RegistryObject<Item> DARK_OAK_HOLLOW_LOG = registerItem("dark_oak_hollow_log",
    () -> new FuelBlockItem(PVJBlocks.DARK_OAK_HOLLOW_LOG.get(), basicItem(), 300));
  public static final RegistryObject<Item> CHERRY_HOLLOW_LOG = registerItem("cherry_hollow_log",
    () -> new FuelBlockItem(PVJBlocks.CHERRY_HOLLOW_LOG.get(), basicItem(), 300));
  public static final RegistryObject<Item> MANGROVE_HOLLOW_LOG = registerItem("mangrove_hollow_log",
    () -> new FuelBlockItem(PVJBlocks.MANGROVE_HOLLOW_LOG.get(), basicItem(), 300));


  private static Item.Properties basicItem() {
    return new Item.Properties();
  }

  private static RegistryObject<Item> registerItem(String name, Supplier<Item> item) {
    RegistryObject<Item> registryItem = ITEMS.register(name, item);
    PVJCreativeModeTab.TAB_ITEMS.add(registryItem);
    return registryItem;
  }
}
