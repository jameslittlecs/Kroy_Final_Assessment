package save;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.mozarellabytes.kroy.Entities.DestroyedEntity;

public class DestroyedEntityData {
	private  String deadTexture;
    private Rectangle area;
    
	public void setDeadTexture(String deadTexture) {
		this.deadTexture = deadTexture;
	}
	public void setArea(Rectangle area) {
		this.area = area;
	}
	public DestroyedEntity create() {
		return new DestroyedEntity(new Texture(this.deadTexture), this.area);
	}
}
