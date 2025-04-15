package dev.orderedchaos.projectvibrantjourneys.core.registry;

import dev.orderedchaos.projectvibrantjourneys.common.items.FuelBlockItem;
import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class PVJItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ProjectVibrantJourneys.MOD_ID);

  public static final RegistryObject<Item> NETTLE_SOUP = registerItem("nettle_soup", () -> new BowlFoodItem(new Item.Properties().stacksTo(1).food(Foods.NETTLE_SOUP)));

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
  public static final RegistryObject<Item> SANDY_SPROUTS = registerItem("sandy_sprouts",
    () -> new BlockItem(PVJBlocks.SANDY_SPROUTS.get(), basicItem()));
  public static final RegistryObject<Item> WATERGRASS = registerItem("watergrass",
    () -> new BlockItem(PVJBlocks.WATERGRASS.get(), basicItem()));
  public static final RegistryObject<Item> PINK_LOTUS = registerItem("pink_lotus",
    () -> new PlaceOnWaterBlockItem(PVJBlocks.PINK_LOTUS.get(), basicItem()));

  public static final RegistryObject<Item> SLIME_NODULE = registerItem("slime_nodule",
    () -> new BlockItem(PVJBlocks.SLIME_NODULE.get(), basicItem()));
  public static final RegistryObject<Item> PINK_VINES = registerItem("pink_vines",
    () -> new BlockItem(PVJBlocks.PINK_VINES.get(), basicItem()));
  public static final RegistryObject<Item> YELLOW_WILDFLOWERS = registerItem("yellow_wildflowers",
    () -> new BlockItem(PVJBlocks.YELLOW_WILDFLOWERS.get(), basicItem()));
  public static final RegistryObject<Item> ORANGE_WILDFLOWERS = registerItem("orange_wildflowers",
    () -> new BlockItem(PVJBlocks.ORANGE_WILDFLOWERS.get(), basicItem()));
  public static final RegistryObject<Item> BLUE_WILDFLOWERS = registerItem("blue_wildflowers",
    () -> new BlockItem(PVJBlocks.BLUE_WILDFLOWERS.get(), basicItem()));
  public static final RegistryObject<Item> PURPLE_WILDFLOWERS = registerItem("purple_wildflowers",
    () -> new BlockItem(PVJBlocks.PURPLE_WILDFLOWERS.get(), basicItem()));
  public static final RegistryObject<Item> WHITE_WILDFLOWERS = registerItem("white_wildflowers",
    () -> new BlockItem(PVJBlocks.WHITE_WILDFLOWERS.get(), basicItem()));
  public static final RegistryObject<Item> MIXED_WILDFLOWERS = registerItem("mixed_wildflowers",
    () -> new BlockItem(PVJBlocks.MIXED_WILDFLOWERS.get(), basicItem()));

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

  public static final RegistryObject<Item> FERROUS_GRAVEL = registerItem("ferrous_gravel",
    () -> new BlockItem(PVJBlocks.FERROUS_GRAVEL.get(), basicItem()));
  public static final RegistryObject<Item> GILDED_GRAVEL = registerItem("gilded_gravel",
    () -> new BlockItem(PVJBlocks.GILDED_GRAVEL.get(), basicItem()));
  public static final RegistryObject<Item> GILDED_RED_SAND = registerItem("gilded_red_sand",
    () -> new BlockItem(PVJBlocks.GILDED_RED_SAND.get(), basicItem()));

  public static final RegistryObject<Item> MUDDY_BONES = registerItem("muddy_bones",
    () -> new BlockItem(PVJBlocks.MUDDY_BONES.get(), basicItem()));

  private static Item.Properties basicItem() {
    return new Item.Properties();
  }

  private static RegistryObject<Item> registerItem(String name, Supplier<Item> item) {
    RegistryObject<Item> registryItem = ITEMS.register(name, item);
    PVJCreativeModeTab.TAB_ITEMS.add(registryItem);
    return registryItem;
  }

  public static class Foods {
    public static final FoodProperties NETTLE_SOUP = new FoodProperties.Builder()
      .nutrition(3)
      .saturationMod(0.3F)
      .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200), 1.0F)
      .alwaysEat()
      .build();
  }
}
