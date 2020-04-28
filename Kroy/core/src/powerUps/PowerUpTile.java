package powerUps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.mozarellabytes.kroy.Entities.FireTruck;

/**
 * 
 * PowerUpTile is the object holding the information about which power up is where on the map.
 * Extends Sprite so it is a physical entity to be rendered on screen
 */
public class PowerUpTile extends Sprite{
	/** Position on map*/
	private Vector2 position;
	/** Power which is on this tile*/
	private Power power;
	/** Texture of tile*/
	private Texture texture;
	
	/**
	 * Constructs PowerUpTile with specific power up
	 * 
	 * @param pos position on map
	 * @param power PowerUp to be on the pos on map
	 */
	public PowerUpTile(Vector2 pos, Power power) {
		this.position = pos;
		this.power = power;
		this.texture = new Texture(Gdx.files.internal("powerUps/" + this.power.toString() + ".png"));
	}
	
	/**
	 * Constructs PowerUpTile with a random PowerUp
	 * 
	 * @param pos Position on map for this powerUp
	 */
	public PowerUpTile(Vector2 pos) {
		this(pos, Power.values()[(int)(Math.random() * Power.values().length)]);
	}
	
	/**
	 * Draws PowerUpTile to the Batch given
	 * @param mapBatch
	 */
	public void drawSprite(Batch mapBatch) {
        mapBatch.draw(this.texture, position.x, position.y, 1, 1);
    }
	
	/**
	 * Creates PowerUp assigned to a specific FireTruck
	 * 
	 * @param truck the FireTruck to have PowerUp assigned to
	 * @return A powerUp if power is valid, null if not
	 */
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
	
	/**
	 * Draws PowerUpTile to the Batch given
	 * @param mapBatch
	 */
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
