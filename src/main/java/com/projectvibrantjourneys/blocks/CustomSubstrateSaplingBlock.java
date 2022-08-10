package com.projectvibrantjourneys.blocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;

public class CustomSubstrateSaplingBlock extends SaplingBlock {

	private List<TagKey<Block>> substrates = new ArrayList<TagKey<Block>>();
	private Block[] extras = null;
	
	public CustomSubstrateSaplingBlock(AbstractTreeGrower grower, List<TagKey<Block>> substrates) {
		super(grower, Properties.copy(Blocks.OAK_SAPLING));
		this.substrates = substrates;
	}
	
	public CustomSubstrateSaplingBlock(AbstractTreeGrower grower, List<TagKey<Block>> substrates, Block[] extras) {
		super(grower, Properties.copy(Blocks.OAK_SAPLING));
		this.substrates = substrates;
		this.extras = extras;
	}

	@Override
	protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
		for(TagKey<Block> tag : substrates) {
			if(state.is(tag))
				return true;
		}
		if(extras != null) {
			for(Block block: extras) {
				if(block == state.getBlock())
					return true;
			}
		}
		return super.mayPlaceOn(state, level, pos);
	}
}
