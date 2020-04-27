package powerUps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.mozarellabytes.kroy.Entities.FireTruck;

public class PowerUpTile extends Sprite{
	private Vector2 position;
	private Power power;
	private Texture texture;
	
	public PowerUpTile(Vector2 pos, Power power) {
		this.position = pos;
		this.power = power;
		this.texture = new Texture(Gdx.files.internal("powerUps/" + this.power.toString() + ".png"));
	}
	public PowerUpTile(Vector2 pos) {
		this(pos, Power.values()[(int)(Math.random() * Power.values().length)]);
	}
	public void drawSprite(Batch mapBatch) {
        mapBatch.draw(this.texture, position.x, position.y, 1, 1);
    }
	public PowerUp createPowerUp(FireTruck truck) {
		switch (this.power){
			case DMG:
				return new PowerUp_DMG(truck);
			case HP:
				return new PowerUp_HP(truck);
			case INV:
				return new PowerUp_INV(truck);
			case SPEED:
				return new PowerUp_SPEED(truck);
			case WATER:
				return new PowerUp_WATER(truck);
		}
		
		return null;
	}
	@Override
	public void draw(Batch batch) {
		batch.draw(this.texture,this.position.x, this.position.y, 1, 1);
	}
	public Vector2 getPosition() {
		return position;
	}
	public Power getPower() {
		return power;
	}
}
