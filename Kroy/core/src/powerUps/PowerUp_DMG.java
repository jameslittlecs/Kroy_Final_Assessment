package powerUps;

import com.mozarellabytes.kroy.Entities.FireTruck;

/** Handles the damage power up */
public class PowerUp_DMG extends PowerUp {
	
	/** @param DAMAGECHANGE is the amount the damage is incremented
	 * 
	 */
	
	private final float DAMAGECHANGE = 0.3f;

	public PowerUp_DMG(FireTruck truck) {
		super(truck);
		this.power = Power.DMG;
	}
	public PowerUp_DMG(FireTruck truck, long duration) {
		super(truck, duration);
		this.power = Power.DMG;
	}

	@Override
	protected void activate() {
		this.truck.setAP(this.truck.getAP() + DAMAGECHANGE);
	}

	@Override
	protected void deactivate() {
		this.truck.setAP(this.truck.getAP() - DAMAGECHANGE);
	}

}
