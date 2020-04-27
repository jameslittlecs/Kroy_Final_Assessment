package save;

import com.badlogic.gdx.math.Vector2;
import com.mozarellabytes.kroy.Entities.Fortress;
import com.mozarellabytes.kroy.Entities.FortressType;

public class FortressData {
	private Vector2 position;
	private float HP;
	private FortressType type;
	
	public void setPosition(Vector2 position) {
		this.position = position;
	}
	public void setHP(float hP) {
		HP = hP;
	}
	public void setType(FortressType type) {
		this.type = type;
	}
	public Fortress create() {
		Fortress fortress = new Fortress(position.x, position.y, this.type);
		fortress.setHP(this.HP);
		return fortress;
	}
}
