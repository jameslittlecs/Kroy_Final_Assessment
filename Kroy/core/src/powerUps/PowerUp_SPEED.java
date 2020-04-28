package powerUps;

import com.mozarellabytes.kroy.Entities.FireTruck;

public class PowerUp_SPEED extends PowerUp {
	
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
