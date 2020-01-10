package projectvibrantjourneys.common.items;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import projectvibrantjourneys.common.entities.passive.IBucketCollectable;

public class PVJFishBucketItem extends BucketItem {
   private final EntityType<?> fishType;

   public PVJFishBucketItem(EntityType<?> fishTypeIn, Fluid fluid, Item.Properties builder) {
      super(fluid, builder);
      this.fishType = fishTypeIn;
   }

   @Override
   public void onLiquidPlaced(World worldIn, ItemStack stack, BlockPos pos) {
      if (!worldIn.isRemote) {
         this.placeFish(worldIn, stack, pos);
      }
   }

   @Override
   protected void playEmptySound(@Nullable PlayerEntity player, IWorld worldIn, BlockPos pos) {
      worldIn.playSound(player, pos, SoundEvents.ITEM_BUCKET_EMPTY_FISH, SoundCategory.NEUTRAL, 1.0F, 1.0F);
   }

   private void placeFish(World worldIn, ItemStack stack, BlockPos pos) {
      Entity entity = this.fishType.spawn(worldIn, stack, (PlayerEntity)null, pos, SpawnReason.BUCKET, true, false);
      if (entity != null) {
         ((IBucketCollectable)entity).setFromBucket(true);
      }

   }
}