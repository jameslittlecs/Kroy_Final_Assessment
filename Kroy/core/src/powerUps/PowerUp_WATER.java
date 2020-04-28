package powerUps;

import com.mozarellabytes.kroy.Entities.FireTruck;

public class PowerUp_WATER extends PowerUp {

	public PowerUp_WATER(FireTruck truck) {
		super(truck);
		this.power = Power.WATER;
	}
	
	public PowerUp_WATER(FireTruck truck, long duration) {
		super(truck, duration);
		this.power = Power.WATER;
	}

	@Override
	protected void activate() {
		this.truck.setReserve(this.truck.getType().getMaxReserve());
	}

	@Override
	protected void deactivate() {}

}
