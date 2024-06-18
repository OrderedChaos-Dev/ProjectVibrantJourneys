package dev.orderedchaos.projectvibrantjourneys.common.mixin;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import dev.orderedchaos.projectvibrantjourneys.common.world.features.ruinednetherportal.RuinedPortalDecoratorBase;
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

  public RuinedPortalPieceMixin(StructurePieceType pType, CompoundTag pTag, StructureTemplateManager pStructureTemplateManager, Function<ResourceLocation, StructurePlaceSettings> pPlaceSettingsFactory) {
    super(pType, pTag, pStructureTemplateManager, pPlaceSettingsFactory);
  }

  @Inject(
    method = "postProcess",
    locals = LocalCapture.CAPTURE_FAILEXCEPTION,
    at = @At(
      value = "INVOKE",
      target = "Lnet/minecraft/world/level/levelgen/structure/structures/RuinedPortalPiece;addNetherrackDripColumnsBelowPortal(Lnet/minecraft/util/RandomSource;Lnet/minecraft/world/level/LevelAccessor;)V",
      shift = At.Shift.AFTER
    )
  )
  public void postProcess(WorldGenLevel pLevel, StructureManager pStructureManager, ChunkGenerator pGenerator, RandomSource pRandom, BoundingBox pBox, ChunkPos pChunkPos, BlockPos pPos, CallbackInfo info, BoundingBox boundingbox) {
    boolean isInOverworld = pLevel.getLevel().dimension() == Level.OVERWORLD;
    boolean shouldGenerate = (1.0F - pRandom.nextFloat() < MODIFY_PORTAL_CHANCE);
    if (isInOverworld && shouldGenerate) {
      RuinedPortalDecoratorBase ruinedPortalDecorator = RuinedPortalDecoratorBase.getRandomPortalDecorator(pRandom);
      ProjectVibrantJourneys.LOGGER.debug(String.format("Modifying ruined nether portal at %s with %s", pPos, ruinedPortalDecorator));
      BlockPos.betweenClosedStream(this.getBoundingBox().inflatedBy(5)).forEach((pos) -> {
        if (pLevel.getBlockState(pos).is(Blocks.NETHERRACK) || pLevel.getBlockState(pos).is(Blocks.MAGMA_BLOCK)) {
          boolean isAboveEmpty = pLevel.isEmptyBlock(pos.above());
          if (isAboveEmpty) {
            BlockState topSoil = ruinedPortalDecorator.getTopSoil(pLevel, pRandom);
            if (topSoil != null) {
              pLevel.setBlock(pos, topSoil, 2);
            }
            ruinedPortalDecorator.decorate(pLevel, pGenerator, pRandom, pos);
          } else {
            BlockState fillerSoil = ruinedPortalDecorator.getFillerSoil(pLevel, pRandom);
            if (fillerSoil != null) {
              pLevel.setBlock(pos, fillerSoil, 2);
            }
          }
        }
      });
    }
  }
}
