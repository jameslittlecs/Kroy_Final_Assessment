package powerUps;

import com.mozarellabytes.kroy.Entities.FireTruck;

/** Handles the speed increase power up */
public class PowerUp_SPEED extends PowerUp {
	
	/** @param SPEEDCHANGE is the value added to increase the speed
	 * 
	 */
	private static final int SPEEDCHANGE = 5;

	public PowerUp_SPEED(FireTruck truck) {
		super(truck);
		this.power = Power.SPEED;
	}
	public PowerUp_SPEED(FireTruck truck, long duration) {
		super(truck, duration);
		this.power = Power.SPEED;
	}

	@Override
	protected void activate() {
		this.truck.setSpeed(this.truck.getSpeed() + SPEEDCHANGE);
	}

	@Override
	protected void deactivate() {
		this.truck.setSpeed(this.truck.getSpeed() - SPEEDCHANGE);
		this.expired = true;
	}

}
