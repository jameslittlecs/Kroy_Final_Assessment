package powerUps;

import com.mozarellabytes.kroy.Entities.FireTruck;

/** Handles all the common features of the power up such as duration */
public abstract class PowerUp {
	/** @param duration is the length of time each power up lasts
	 *  @param start is the start time of the power up
	 *  @param power is the type of power up
	 *  @param truck is the truck that the power up is tied to
	 *  @param DEFAULT_DURATION is the default length of time for a power up if no other one is supplied
	 *  @param expired is true when the power up time has expired and the power up is no longer active
	 *  */
	private long duration;
	private long start;
	protected Power power;
	protected FireTruck truck;
	private final static long DEFAULT_DURATION = 600000;
	public boolean expired = false;
	
	public PowerUp(FireTruck truck) {
		this(truck, DEFAULT_DURATION);
	}
	
	public PowerUp(FireTruck truck, long duration) {
		this.duration = duration;
		this.start = System.currentTimeMillis();
		this.truck = truck;
		this.activate();
	}
	public void checkTime() {
		if (System.currentTimeMillis() - this.start > duration) {
			deactivate();
			this.duration = 0;
			this.expired = true;
		}
	}
	protected abstract void activate();
	protected abstract void deactivate();
	
	public long getDuration() {
		return duration;
	}
	public Power getPower() {
		return power;
	}
}
