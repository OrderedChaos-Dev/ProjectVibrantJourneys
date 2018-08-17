package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import vibrantjourneys.util.PVJConfig;

public class PVJDecorateEventHandler
{
	@SubscribeEvent
	public void onDecorate(PopulateChunkEvent.Populate event)
	{
		if(event.getType().equals(PopulateChunkEvent.Populate.EventType.DUNGEON) && PVJConfig.worldgen.modifyDungeons)
		{
			int chunkX = event.getChunkX();
			int chunkZ = event.getChunkZ();
			
			ChunkGeneratorSettings settings = ChunkGeneratorSettings.Factory.jsonToFactory(event.getWorld().getWorldInfo().getGeneratorOptions()).build();
			Random rand = event.getWorld().rand;
			int dungeonSpawnChance = settings.dungeonChance;
			
			for(int i = 0; i < dungeonSpawnChance; i++)
			{
				int x = chunkX * 16 + 8 + rand.nextInt(16) - rand.nextInt(16);
				int y = rand.nextInt(256);
				int z = chunkZ * 16 + 8 + rand.nextInt(16) - rand.nextInt(16);
				(new WorldGenPVJDungeon()).generate(event.getWorld(), rand, new BlockPos(x, y, z));
			}
			event.setResult(Result.DENY);
		}
	}
}
