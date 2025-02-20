package dev.orderedchaos.projectvibrantjourneys.common.mixin;

import dev.orderedchaos.projectvibrantjourneys.common.world.features.ruinednetherportals.RuinedPortalDecoratorBase;
import dev.orderedchaos.projectvibrantjourneys.core.config.PVJConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.TemplateStructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.structures.RuinedPortalPiece;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.function.Function;

@Mixin(RuinedPortalPiece.class)
public abstract class RuinedPortalPieceMixin extends TemplateStructurePiece {

  private final float MODIFY_PORTAL_CHANCE = 1f;

  public RuinedPortalPieceMixin(StructurePieceType type, CompoundTag tag, StructureTemplateManager manager, Function<ResourceLocation, StructurePlaceSettings> settings) {
    super(type, tag, manager, settings);
  }

  @Inject(method = "postProcess",
    at = @At(
      value = "INVOKE",
      target = "Lnet/minecraft/world/level/levelgen/structure/structures/RuinedPortalPiece;addNetherrackDripColumnsBelowPortal(Lnet/minecraft/util/RandomSource;Lnet/minecraft/world/level/LevelAccessor;)V",
      shift = At.Shift.AFTER),
    locals = LocalCapture.CAPTURE_FAILEXCEPTION)
  public void postProcess(WorldGenLevel level, StructureManager manager, ChunkGenerator generator, RandomSource random, BoundingBox box, ChunkPos chunkPos, BlockPos blockPos, CallbackInfo info, BoundingBox boundingbox) {
    if (PVJConfig.configOptions.get("enableBetterRuinedNetherPortals").get()) {
      boolean isInOverworld = level.getLevel().dimension() == Level.OVERWORLD;
      boolean shouldGenerate = (1.0F - random.nextFloat() < MODIFY_PORTAL_CHANCE);
      if (isInOverworld && shouldGenerate) {
        RuinedPortalDecoratorBase decorator = RuinedPortalDecoratorBase.getRandomPortalDecorator(random);
        BlockPos.betweenClosedStream(this.getBoundingBox().inflatedBy(5)).forEach((pos) -> {
          if (level.getBlockState(pos).is(Blocks.NETHERRACK) || level.getBlockState(pos).is(Blocks.MAGMA_BLOCK)) {
            boolean isAboveEmpty = level.isEmptyBlock(pos.above());
            if (isAboveEmpty) {
              BlockState topSoil = decorator.getTopSoil(level, random);
              if (topSoil != null) {
                level.setBlock(pos, topSoil, 2);
              }
              decorator.decorate(level, generator, random, pos);
            } else {
              BlockState fillerSoil = decorator.getFillerSoil(level, random);
              if (fillerSoil != null) {
                level.setBlock(pos, fillerSoil, 2);
              }
            }
          }
        });
      }
    }
  }


}