package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import vibrantjourneys.init.PVJBiomes;
import vibrantjourneys.util.BiomeReference;
import vibrantjourneys.util.PVJConfig;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PVJTerrainGenEvents
{
	@SubscribeEvent
	public void onDecorate(PopulateChunkEvent.Populate event)
	{
		//Add PVJ Dungeon decorations
		if(event.getType().equals(PopulateChunkEvent.Populate.EventType.DUNGEON) && PVJConfig.worldgen.modifyDungeons)
		{
			int chunkX = event.getChunkX();
			int chunkZ = event.getChunkZ();
			
			ChunkGeneratorSettings settings = ChunkGeneratorSettings.Factory.jsonToFactory(event.getWorld().getWorldInfo().getGeneratorOptions()).build();
			Random rand = event.getWorld().rand;
			int dungeonSpawnChance = settings.dungeonChance;
			
			for(int i = 0; i < dungeonSpawnChance; i++)
			{
				int x = chunkX * 16 + 6;
				int y = rand.nextInt(256);
				int z = chunkZ * 16 + 6;
				(new WorldGenPVJDungeon()).generate(event.getWorld(), rand, new BlockPos(x, y, z));
			}
			event.setResult(Result.DENY);
		}
	}
	
	@SubscribeEvent
	public void spawnBaobab(DecorateBiomeEvent.Decorate event)
	{
		if(event.getType() == Decorate.EventType.TREE)
		{
			Biome biome = event.getWorld().getBiomeForCoordsBody(event.getChunkPos().getBlock(8, 0, 8));
			if(BiomeReference.BAOBAB_TREES.contains(biome))
			{
				if(event.getRand().nextInt(150) <= PVJConfig.worldgen.baobabDensity)
				{
					BlockPos pos = event.getWorld().getTopSolidOrLiquidBlock(event.getChunkPos().getBlock(8, 0, 8));
					(new WorldGenBaobabTree(false, 15, 6)).generate(event.getWorld(), event.getRand(), pos);
					event.setResult(Result.DENY);
				}
			}
			if(BiomeReference.COTTONWOOD_TREES.contains(biome))
			{
				if(event.getRand().nextInt(25) < PVJConfig.worldgen.cottonwoodDensity)
				{
					BlockPos pos = event.getWorld().getTopSolidOrLiquidBlock(event.getChunkPos().getBlock(8, 0, 8));
					(new WorldGenCottonwoodTree(false)).generate(event.getWorld(), event.getRand(), pos);
					event.setResult(Result.DENY);
				}
			}
		}
		//remove water lakes in red rock badlands
		if(event.getType() == Decorate.EventType.LAKE_WATER)
		{
			Biome biome = event.getWorld().getBiomeForCoordsBody(event.getChunkPos().getBlock(8, 0, 8));
			if(biome == PVJBiomes.red_rock_badlands)
			{
				event.setResult(Result.DENY);
			}
		}
	}
}
