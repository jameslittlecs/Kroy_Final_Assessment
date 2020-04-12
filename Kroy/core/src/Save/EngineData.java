package Save;

import com.badlogic.gdx.math.Vector2;
import com.mozarellabytes.kroy.Entities.FireTruck;
import com.mozarellabytes.kroy.Entities.FireTruckType;
import com.mozarellabytes.kroy.Screens.GameScreen;

public class EngineData{
	private Vector2 position;
	private float HP;
	private float reserve;
	private FireTruckType type;
	
	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public void setHP(float hP) {
		HP = hP;
	}

	public void setReserve(float reserve) {
		this.reserve = reserve;
	}

	public void setType(FireTruckType type) {
		this.type = type;
	}

	public FireTruck createEngine(GameScreen gameScreen) {
		FireTruck truck = new FireTruck(gameScreen, position, type);
		truck.setHP(this.HP);
		truck.setReserve(this.reserve);
		return truck;
	}
}
