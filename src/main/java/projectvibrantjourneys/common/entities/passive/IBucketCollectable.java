package projectvibrantjourneys.common.entities.passive;

/*
 * Used for clams and starfish bucket items - see PVJFishBucketItem
 * the vanilla one does not support entities not children of AbstractFishEntity
 */
public interface IBucketCollectable {
	void setFromBucket(boolean value);
}