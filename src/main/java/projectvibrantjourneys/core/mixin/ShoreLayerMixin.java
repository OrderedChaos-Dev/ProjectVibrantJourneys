package projectvibrantjourneys.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.ShoreLayer;
import projectvibrantjourneys.core.MixinBiomeUtil;
import projectvibrantjourneys.init.world.PVJBiomes;

@Mixin(ShoreLayer.class)
public class ShoreLayerMixin {

	@Inject(method = "apply", at = @At("RETURN"), cancellable = true)
	private void apply(INoiseRandom noise, int biomeID1, int biomeID2, int biomeID3, int biomeID4, int biome, CallbackInfoReturnable<Integer> info) {
		if(biome == WorldGenRegistries.BIOME.getId(PVJBiomes.boreal_plateau)) {
			if(MixinBiomeUtil.isOcean(biomeID1) || MixinBiomeUtil.isOcean(biomeID2) || MixinBiomeUtil.isOcean(biomeID3) || MixinBiomeUtil.isOcean(biomeID4))
				info.setReturnValue(25);
		}
	}
}
