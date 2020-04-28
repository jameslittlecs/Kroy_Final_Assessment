package powerUps;

import com.mozarellabytes.kroy.Entities.FireTruck;

/** Handles the HP refill power up */
public class PowerUp_HP extends PowerUp {

	public PowerUp_HP(FireTruck truck) {
		super(truck);
		this.power = Power.HP;
	}
	
	public PowerUp_HP(FireTruck truck, long duration) {
		super(truck, duration);
		this.power = Power.HP;
	}

	/** sets the truck collecting the power ups damage to max
	 * 
	 */
	@Override
	protected void activate() {
		this.truck.setHP(this.truck.getType().getMaxHP());
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void deactivate() {}
}
