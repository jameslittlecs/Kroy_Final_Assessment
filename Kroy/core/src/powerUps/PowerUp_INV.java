package powerUps;

import com.mozarellabytes.kroy.Entities.FireTruck;

public class PowerUp_INV extends PowerUp {

	public PowerUp_INV(FireTruck truck) {
		super(truck);
		this.power = Power.INV;
	}
	
	public PowerUp_INV(FireTruck truck, long duration) {
		super(truck, duration);
		this.power = Power.INV;
	}

	@Override
	protected void activate() {
		this.truck.setCanTakeDamage(false);
	}

	@Override
	protected void deactivate() {
		this.truck.setCanTakeDamage(true);
	}

}
