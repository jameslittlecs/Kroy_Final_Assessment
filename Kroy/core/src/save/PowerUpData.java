package Save;

import com.mozarellabytes.kroy.Entities.FireTruck;

import powerUps.Power;
import powerUps.PowerUp;
import powerUps.PowerUp_DMG;
import powerUps.PowerUp_HP;
import powerUps.PowerUp_INV;
import powerUps.PowerUp_SPEED;
import powerUps.PowerUp_WATER;

public class PowerUpData {
	private Power power;
	private long duration;
	
	public Power getPower() {
		return power;
	}
	public void setPower(Power power) {
		this.power = power;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public PowerUp create(FireTruck truck) {
		
		switch (this.power){
			case DMG:
				return new PowerUp_DMG(truck, this.duration);
			case HP:
				return new PowerUp_HP(truck, this.duration);
			case INV:
				return new PowerUp_INV(truck, this.duration);
			case SPEED:
				return new PowerUp_SPEED(truck, this.duration);
			case WATER:
				return new PowerUp_WATER(truck, this.duration);
		}
		return null;		
	}

}
