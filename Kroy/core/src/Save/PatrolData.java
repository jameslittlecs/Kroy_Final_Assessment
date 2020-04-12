package Save;

import com.badlogic.gdx.math.Vector2;
import com.mozarellabytes.kroy.Entities.Patrol;
import com.mozarellabytes.kroy.Entities.PatrolType;

public class PatrolData {
	private Vector2 position;
	private float HP;
	private PatrolType type;
	
	public void setPosition(Vector2 position) {
		this.position = position;
	}
	public void setHP(float hP) {
		HP = hP;
	}
	public void setType(PatrolType type) {
		this.type = type;
	}
	public Patrol createPatrol() {
		Patrol patrol = new Patrol(this.type, this.position);
		patrol.setHP(this.HP);
		return patrol;
	}
}