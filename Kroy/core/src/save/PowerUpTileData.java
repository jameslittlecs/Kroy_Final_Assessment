package save;

import com.badlogic.gdx.math.Vector2;

import powerUps.Power;
import powerUps.PowerUpTile;

public class PowerUpTileData {
	private Vector2 position;
	private Power power;
	
	public Vector2 getPosition() {
		return position;
	}
	public void setPosition(Vector2 position) {
		this.position = position;
	}
	public Power getPower() {
		return power;
	}
	public void setPower(Power power) {
		this.power = power;
	}
	public PowerUpTile create() {
		return new PowerUpTile(this.position, this.power);
	}
}
