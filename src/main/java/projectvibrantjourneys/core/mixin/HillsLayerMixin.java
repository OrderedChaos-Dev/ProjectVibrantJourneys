package projectvibrantjourneys.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.HillsLayer;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.traits.IAreaTransformer2;
import net.minecraft.world.gen.layer.traits.IDimOffset1Transformer;
import projectvibrantjourneys.core.MixinBiomeUtil;
import projectvibrantjourneys.init.world.PVJBiomes;

@Mixin(HillsLayer.class)
public abstract class HillsLayerMixin implements IAreaTransformer2, IDimOffset1Transformer {

	@Inject(method = "applyPixel", at = @At("RETURN"), cancellable = true)
	private void applyPixel(INoiseRandom noise, IArea area1, IArea area2, int a, int b, CallbackInfoReturnable<Integer> info) {
		int i = area1.get(this.getParentX(a + 1), this.getParentY(b + 1));
		RegistryKey<Biome> biomeKey = MixinBiomeUtil.keyFromID(i);
		if(PVJBiomes.HILLS_MAP.containsKey(biomeKey)) {
            int i1 = 0;
            if (LayerUtil.isSame(area1.get(this.getParentX(a + 1), this.getParentY(b + 0)), i)) {
               ++i1;
            }

            if (LayerUtil.isSame(area1.get(this.getParentX(a + 2), this.getParentY(b + 1)), i)) {
               ++i1;
            }

            if (LayerUtil.isSame(area1.get(this.getParentX(a + 0), this.getParentY(b + 1)), i)) {
               ++i1;
            }

            if (LayerUtil.isSame(area1.get(this.getParentX(a + 1), this.getParentY(b + 2)), i)) {
               ++i1;
            }
            
            if(i1 >= 3)
            	info.setReturnValue(MixinBiomeUtil.getID(PVJBiomes.HILLS_MAP.get(biomeKey)));
		}
	}
}
