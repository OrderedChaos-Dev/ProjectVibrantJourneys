package dev.orderedchaos.projectvibrantjourneys.data.loottables;

import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.ConditionUserBuilder;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Collections;

public class PVJBlockLoot extends BlockLootSubProvider  {

  public PVJBlockLoot(HolderLookup.Provider lookupProvider) {
    super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags(), lookupProvider);
  }

  @Override
  protected Iterable<Block> getKnownBlocks() {
    return PVJBlocks.BLOCKS.getEntries().stream().map(Holder::value).toList();
  }

  @Override
  protected void generate() {
    HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
    this.dropSelf(PVJBlocks.TWIGS.get());
    this.dropSelf(PVJBlocks.BIRCH_TWIGS.get());
    this.dropSelf(PVJBlocks.ROCKS.get());
    this.dropSelf(PVJBlocks.MOSSY_ROCKS.get());
    this.dropSelf(PVJBlocks.SANDSTONE_ROCKS.get());
    this.dropSelf(PVJBlocks.RED_SANDSTONE_ROCKS.get());
    this.dropSelf(PVJBlocks.SEASHELLS.get());
    this.dropSelf(PVJBlocks.PINECONES.get());
    this.dropSelf(PVJBlocks.BONES.get());
    this.dropSelf(PVJBlocks.CHARRED_BONES.get());
    this.dropSelf(PVJBlocks.ICE_CHUNKS.get());
    this.dropSelf(PVJBlocks.SMALL_CACTUS.get());
    this.dropSelf(PVJBlocks.WARPED_NETTLE.get());
    this.dropSelf(PVJBlocks.CRIMSON_NETTLE.get());
    this.dropSelf(PVJBlocks.CINDERCANE.get());
    this.dropSelf(PVJBlocks.GLOWCAP.get());
    this.dropSelf(PVJBlocks.BARK_MUSHROOM.get());
    this.dropSelf(PVJBlocks.LIGHT_BROWN_BARK_MUSHROOM.get());
    this.dropSelf(PVJBlocks.ORANGE_BARK_MUSHROOM.get());
    this.dropSelf(PVJBlocks.GLOWING_BLUE_FUNGUS.get());
    this.dropSelf(PVJBlocks.OAK_HOLLOW_LOG.get());
    this.dropSelf(PVJBlocks.BIRCH_HOLLOW_LOG.get());
    this.dropSelf(PVJBlocks.SPRUCE_HOLLOW_LOG.get());
    this.dropSelf(PVJBlocks.JUNGLE_HOLLOW_LOG.get());
    this.dropSelf(PVJBlocks.ACACIA_HOLLOW_LOG.get());
    this.dropSelf(PVJBlocks.DARK_OAK_HOLLOW_LOG.get());
    this.dropSelf(PVJBlocks.CHERRY_HOLLOW_LOG.get());
    this.dropSelf(PVJBlocks.MANGROVE_HOLLOW_LOG.get());
    this.dropSelf(PVJBlocks.ICICLE.get());

    this.add(PVJBlocks.BEACH_GRASS.get(), BlockLootSubProvider::createShearsOnlyDrop);
    this.add(PVJBlocks.FALLEN_LEAVES.get(), BlockLootSubProvider::createShearsOnlyDrop);
    this.add(PVJBlocks.DEAD_FALLEN_LEAVES.get(), BlockLootSubProvider::createShearsOnlyDrop);
    this.add(PVJBlocks.SANDY_SPROUTS.get(), BlockLootSubProvider::createShearsOnlyDrop);

    this.add(PVJBlocks.SHORT_GRASS.get(), this::createGrassDrops);
    this.add(PVJBlocks.WATERGRASS.get(), block -> this.createDoublePlantWithSeedDrops(block, block));

    this.dropOther(PVJBlocks.BEACHED_KELP.get(), Items.KELP);
    this.dropOther(PVJBlocks.DRIED_BEACHED_KELP.get(), Items.DRIED_KELP);

    this.add(PVJBlocks.GLOWCAP_BLOCK.get(), block -> this.createMushroomBlockDrop(block, PVJBlocks.GLOWCAP.get()));

    this.add(PVJBlocks.CATTAIL.get(), block -> this.createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
    this.add(PVJBlocks.SEA_OATS.get(), block -> this.createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
    this.add(PVJBlocks.REEDS.get(), block -> this.createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));

    this.add(
      PVJBlocks.PRICKLY_BUSH.get(),
      block -> this.createShearsDispatchTable(
        block,
        this.applyExplosionDecay(
          block, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
        )
      )
    );
    this.add(
      PVJBlocks.NATURAL_COBWEB.get(),
      block -> this.createSilkTouchOrShearsDispatchTable(
        Blocks.COBWEB, this.applyExplosionCondition(Blocks.COBWEB, LootItem.lootTableItem(Items.STRING))
      )
    );
    this.add(
      PVJBlocks.FERROUS_GRAVEL.get(),
      block -> this.createSilkTouchDispatchTable(block,
        this.applyExplosionCondition(block, LootItem.lootTableItem(Items.FLINT)
          .when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), 0.1F, 0.14285715F, 0.25F, 1.0F))
          .otherwise(LootItem.lootTableItem(Blocks.GRAVEL)))
        ).withPool(
          LootPool.lootPool()
            .when(this.doesNotHaveSilkTouch())
            .add(
              this.applyExplosionCondition(block,
                LootItem.lootTableItem(Items.RAW_IRON).apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))))
      )
    );
    this.add(
      PVJBlocks.GILDED_GRAVEL.get(),
      block -> this.createSilkTouchDispatchTable(block,
        this.applyExplosionCondition(block, LootItem.lootTableItem(Items.FLINT)
          .when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), 0.1F, 0.14285715F, 0.25F, 1.0F))
          .otherwise(LootItem.lootTableItem(Blocks.GRAVEL)))
      ).withPool(
        LootPool.lootPool()
          .when(this.doesNotHaveSilkTouch())
          .add(
            this.applyExplosionCondition(block,
              LootItem.lootTableItem(Items.RAW_GOLD).apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))))
      )
    );
    this.add(
      PVJBlocks.GILDED_RED_SAND.get(),
      block -> this.createSilkTouchDispatchTable(block,
        this.applyExplosionCondition(block, LootItem.lootTableItem(Blocks.RED_SAND))
      ).withPool(
        LootPool.lootPool()
          .when(this.doesNotHaveSilkTouch())
          .add(
            this.applyExplosionCondition(block,
              LootItem.lootTableItem(Items.RAW_GOLD).apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))))
      )
    );

    this.dropPottedContents(PVJBlocks.POTTED_CINDERCANE.get());
    this.dropPottedContents(PVJBlocks.POTTED_SMALL_CACTUS.get());
    this.dropPottedContents(PVJBlocks.POTTED_PRICKLY_BUSH.get());
    this.dropPottedContents(PVJBlocks.POTTED_WARPED_NETTLE.get());
    this.dropPottedContents(PVJBlocks.POTTED_CRIMSON_NETTLE.get());
    this.dropPottedContents(PVJBlocks.POTTED_GLOWCAP.get());
  }
}
