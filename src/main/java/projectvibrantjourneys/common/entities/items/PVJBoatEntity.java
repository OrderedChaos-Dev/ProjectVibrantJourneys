package projectvibrantjourneys.common.entities.items;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import projectvibrantjourneys.init.object.PVJBlocks;
import projectvibrantjourneys.init.object.PVJEntities;
import projectvibrantjourneys.init.object.PVJItems;

public class PVJBoatEntity extends BoatEntity {

	private static final DataParameter<Integer> PVJ_BOAT_TYPE = EntityDataManager.defineId(PVJBoatEntity.class, DataSerializers.INT);

	public PVJBoatEntity(EntityType<? extends PVJBoatEntity> type, World world) {
		super(type, world);
	    this.blocksBuilding = true;
	}

	public PVJBoatEntity(World worldIn, double x, double y, double z) {
		this(PVJEntities.PVJ_BOAT, worldIn);
		this.setPos(x, y, z);
		this.setDeltaMovement(Vector3d.ZERO);
		this.xo = x;
		this.yo = y;
		this.zo = z;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(PVJ_BOAT_TYPE, PVJBoatEntity.PVJBoatType.FIR.ordinal());
	}

	@Override
	public Item getDropItem() {
		switch (this.getCCBoatType()) {
		case FIR:
		default:
			return PVJItems.fir_boat;
		case PINE:
			return PVJItems.pine_boat;
		case REDWOOD:
			return PVJItems.redwood_boat;
		}
	}

	@Override
	protected void addAdditionalSaveData(CompoundNBT compound) {
		compound.putString("Type", this.getCCBoatType().getName());
	}

	@Override
	protected void readAdditionalSaveData(CompoundNBT compound) {
		if (compound.contains("Type", 8)) {
			this.setBoatType(PVJBoatEntity.PVJBoatType.getTypeFromString(compound.getString("Type")));
		}
	}

	public void setBoatType(PVJBoatEntity.PVJBoatType boatType) {
		this.entityData.set(PVJ_BOAT_TYPE, boatType.ordinal());
	}

	public PVJBoatEntity.PVJBoatType getCCBoatType() {
		return PVJBoatEntity.PVJBoatType.byId(this.entityData.get(PVJ_BOAT_TYPE));
	}

	@Override
	public IPacket<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	public static enum PVJBoatType {
		FIR(PVJBlocks.fir_planks, "fir"),
		PINE(PVJBlocks.pine_planks, "pine"),
		REDWOOD(PVJBlocks.redwood_planks, "redwood"),
		WILLOW(PVJBlocks.willow_planks, "willow"),
		MANGROVE(PVJBlocks.mangrove_planks, "mangrove"),
		PALM(PVJBlocks.palm_planks, "palm"),
		ASPEN(PVJBlocks.aspen_planks, "aspen"),
		JUNIPER(PVJBlocks.juniper_planks, "juniper"),
		COTTONWOOD(PVJBlocks.cottonwood_planks, "cottonwood"),
		BAOBAB(PVJBlocks.baobab_planks, "baobab"),
		MAPLE(PVJBlocks.maple_planks, "maple"),
		SAKURA(PVJBlocks.sakura_planks, "sakura");

		private final String name;
		private final Block block;

		private PVJBoatType(Block block, String name) {
			this.name = name;
			this.block = block;
		}

		public String getName() {
			return this.name;
		}

		public Block asPlank() {
			return this.block;
		}

		public String toString() {
			return this.name;
		}

		public static PVJBoatEntity.PVJBoatType byId(int id) {
			PVJBoatEntity.PVJBoatType[] aboatentity$type = values();
			if (id < 0 || id >= aboatentity$type.length) {
				id = 0;
			}

			return aboatentity$type[id];
		}

		public static PVJBoatEntity.PVJBoatType getTypeFromString(String nameIn) {
			PVJBoatEntity.PVJBoatType[] aboatentity$type = values();

			for (int i = 0; i < aboatentity$type.length; ++i) {
				if (aboatentity$type[i].getName().equals(nameIn)) {
					return aboatentity$type[i];
				}
			}

			return aboatentity$type[0];
		}
	}
}
