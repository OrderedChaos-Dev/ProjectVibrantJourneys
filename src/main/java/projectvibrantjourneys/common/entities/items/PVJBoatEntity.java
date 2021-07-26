package projectvibrantjourneys.common.entities.items;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fmllegacy.network.NetworkHooks;
import projectvibrantjourneys.init.object.PVJBlocks;
import projectvibrantjourneys.init.object.PVJEntities;
import projectvibrantjourneys.init.object.PVJItems;

public class PVJBoatEntity extends Boat {

	private static final EntityDataAccessor<Integer> PVJ_BOAT_TYPE = SynchedEntityData.defineId(PVJBoatEntity.class, EntityDataSerializers.INT);

	public PVJBoatEntity(EntityType<? extends PVJBoatEntity> type, Level world) {
		super(type, world);
	    this.blocksBuilding = true;
	}

	public PVJBoatEntity(Level worldIn, double x, double y, double z) {
		this(PVJEntities.PVJ_BOAT, worldIn);
		this.setPos(x, y, z);
		this.setDeltaMovement(Vec3.ZERO);
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
		case WILLOW:
			return PVJItems.willow_boat;
		case MANGROVE:
			return PVJItems.mangrove_boat;
		case PALM:
			return PVJItems.palm_boat;
		case ASPEN:
			return PVJItems.aspen_boat;
		case JUNIPER:
			return PVJItems.juniper_boat;
		case COTTONWOOD:
			return PVJItems.cottonwood_boat;
		case BAOBAB:
			return PVJItems.baobab_boat;
		case MAPLE:
			return PVJItems.maple_boat;
		case SAKURA:
			return PVJItems.sakura_boat;
		case TAMARACK:
			return PVJItems.tamarack_boat;
		case JOSHUA:
			return PVJItems.joshua_boat;
		}
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag compound) {
		compound.putString("Type", this.getCCBoatType().getName());
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag compound) {
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
	public Packet<?> getAddEntityPacket() {
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
		SAKURA(PVJBlocks.sakura_planks, "sakura"),
		TAMARACK(PVJBlocks.tamarack_planks, "tamarack"),
		JOSHUA(PVJBlocks.joshua_planks, "joshua");

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
