package com.projectvibrantjourneys.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.projectvibrantjourneys.core.ProjectVibrantJourneys;
import com.projectvibrantjourneys.util.TreeFeatureUtils.WeightedBiomeEntry;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.loading.FMLPaths;

public class TreeFeatureUtils {

	public static boolean isIn(Set<WeightedBiomeEntry> Set, ResourceLocation biome) {
		for(WeightedBiomeEntry entry : Set) {
			if(entry.biomeName().equals(biome.toString())) {
				return true;
			}
		}
		return false;
	}
	
	public static WeightedBiomeEntry entry(String biomeName, int weight) {
		return new WeightedBiomeEntry(biomeName, weight);
	}
	
	public static int getWeight(String biomeName, Set<WeightedBiomeEntry> data) {
		for(WeightedBiomeEntry entry : data) {
			if(entry.biomeName().equals(biomeName))
				return entry.weight();
		}
		return -1;
	}
	
	public static int getWeight(ResourceLocation biomeName, Set<WeightedBiomeEntry> data) {
		return getWeight(biomeName.toString(), data);
	}
	
	public static void serializeAndLoad(String name, String loc, Set<WeightedBiomeEntry> defaults, Set<WeightedBiomeEntry> data) {
		Path path = FMLPaths.CONFIGDIR.get().resolve(ProjectVibrantJourneys.MOD_ID + "/" + loc + "/" + name + ".json");
		if(!path.toFile().exists()) {
			try {
				Files.createDirectories(path.getParent());
				Files.write(path, new GsonBuilder().setPrettyPrinting().create().toJson(defaults).getBytes());
			} catch(Exception e) {
				ProjectVibrantJourneys.LOGGER.error(e.toString());
			}
		}
		
		try {
			String input = Files.readString(path);
			JsonArray array = JsonParser.parseString(input).getAsJsonArray();
			
			array.forEach((element) -> {
				JsonObject object = element.getAsJsonObject();
				String biomeName = object.getAsJsonPrimitive("biomeName").getAsString();
				int weight = object.getAsJsonPrimitive("weight").getAsInt();
				
				data.add(new WeightedBiomeEntry(biomeName, weight));
			});
		} catch(Exception e) {
			ProjectVibrantJourneys.LOGGER.error(e.toString());
		}
	}
	
	public record WeightedBiomeEntry(String biomeName, int weight) {
		
		public static final Codec<WeightedBiomeEntry> CODEC = RecordCodecBuilder.create((builder) -> {
			   return builder.group(
					   Codec.STRING.fieldOf("biomeName").forGetter(WeightedBiomeEntry::biomeName),
					   Codec.intRange(0, 100).fieldOf("weight").forGetter(WeightedBiomeEntry::weight)
					   ).apply(builder, WeightedBiomeEntry::new);
		   });
	}

}
