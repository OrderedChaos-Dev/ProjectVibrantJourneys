package projectvibrantjourneys.core;

public class MixinBiomeUtil {
	
	public static boolean isOcean(int biomeID) {
		return biomeID == 44 || biomeID == 45 || biomeID == 0 || biomeID == 46 || biomeID == 10
				|| biomeID == 47 || biomeID == 48 || biomeID == 24 || biomeID == 49
				|| biomeID == 50;
	}
}
