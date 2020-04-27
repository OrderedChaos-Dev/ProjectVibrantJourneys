package projectvibrantjourneys.common.entities.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.DamageSource;
import projectvibrantjourneys.common.entities.monster.WatcherEntity;

public class WatcherAttackGoal extends Goal {
      private final WatcherEntity watcher;
      private int tickCounter;

      public WatcherAttackGoal(WatcherEntity watcher) {
         this.watcher = watcher;
      }

      @Override
      public boolean shouldExecute() {
         LivingEntity livingentity = this.watcher.getAttackTarget();
         return livingentity != null && livingentity.isAlive();
      }

      @Override
      public boolean shouldContinueExecuting() {
         return super.shouldContinueExecuting() && (this.watcher.getDistanceSq(this.watcher.getAttackTarget()) < 900.0D)
        		 && this.tickCounter < this.watcher.getAttackDuration() && this.watcher.canEntityBeSeen(this.watcher.getAttackTarget());
      }

      @Override
      public void startExecuting() {
         this.tickCounter = -10;
         this.watcher.getNavigator().clearPath();
         this.watcher.getLookController().setLookPositionWithEntity(this.watcher.getAttackTarget(), 90.0F, 90.0F);
      }

      @Override
      public void resetTask() {
         this.watcher.setTargetedEntity(0);
         this.watcher.setAttackTarget((LivingEntity)null);
      }

      @Override
      public void tick() {
         LivingEntity target = this.watcher.getAttackTarget();
         this.watcher.getLookController().setLookPositionWithEntity(target, 90.0F, 90.0F);
         if (!this.watcher.canEntityBeSeen(target)) {
            this.watcher.setAttackTarget((LivingEntity)null);
         } else {
            ++this.tickCounter;
            if (this.tickCounter == 0) {
               this.watcher.setTargetedEntity(this.watcher.getAttackTarget().getEntityId());
               this.watcher.setAttackTarget(this.watcher.getAttackTarget());
            } else if (this.tickCounter >= this.watcher.getAttackDuration()) {
               target.attackEntityFrom(DamageSource.causeMobDamage(this.watcher), (float)this.watcher.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue());
               this.tickCounter++;
            }

            super.tick();
         }
      }
   }