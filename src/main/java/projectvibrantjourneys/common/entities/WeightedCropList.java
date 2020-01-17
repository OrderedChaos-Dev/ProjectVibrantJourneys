package projectvibrantjourneys.common.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.item.Item;

public class WeightedCropList {

	private List<WeightedCropItem> crops = new ArrayList<WeightedCropItem>();
	private int totalWeight;
	
	public WeightedCropList() {
		totalWeight = 0;
	}
	
	public void addEntry(WeightedCropItem... items) {
		for(WeightedCropItem item : items) {
			totalWeight += item.getWeight();
			item.setTotalWeight(totalWeight);
			crops.add(item);
		}
	}
	
	public Item getRandom(Random random) {
		int rand = random.nextInt(totalWeight);
		for(WeightedCropItem crop : crops) {
			if(crop.getTotalWeight() >= rand) {
				return crop.getCrop();
			}
		}
		
		return null;
	}
	
	public static class WeightedCropItem {
		public int totalWeight;
		private int weight;
		private Item crop;
		
		public WeightedCropItem(Item crop, int weight) {
			this.weight = weight;
			this.crop = crop;
			this.totalWeight = 0;
		}
		
		public int getWeight() {
			return weight;
		}
		
		public Item getCrop() {
			return crop;
		}
		
		public void setTotalWeight(int weight) {
			this.totalWeight = weight;
		}
		
		public int getTotalWeight() {
			return this.totalWeight;
		}
		
		public static WeightedCropItem create(Item crop, int weight) {
			return new WeightedCropItem(crop, weight);
		}
	}
}
