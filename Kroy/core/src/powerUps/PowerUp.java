package powerUps;

import com.mozarellabytes.kroy.Entities.FireTruck;

public abstract class PowerUp {
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
