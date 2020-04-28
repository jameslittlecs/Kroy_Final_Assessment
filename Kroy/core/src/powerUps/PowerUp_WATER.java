package powerUps;

import com.mozarellabytes.kroy.Entities.FireTruck;

/** Handles the water refill power up */
public class PowerUp_WATER extends PowerUp {

	public PowerUp_WATER(FireTruck truck) {
		super(truck);
		this.power = Power.WATER;
	}
	
	public PowerUp_WATER(FireTruck truck, long duration) {
		super(truck, duration);
		this.power = Power.WATER;
	}

	/**sets the trucks water back to maximum
	 * 
	 */
	@Override
	protected void activate() {
		this.truck.setReserve(this.truck.getType().getMaxReserve());
	}

	@Override
	protected void deactivate() {}

}
