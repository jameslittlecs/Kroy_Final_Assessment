package com.mozarellabytes.kroy.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public abstract class PowerUp extends Sprite{
	private FireTruck truck;
	private Vector2 position;
	private boolean pickedUp;
	private Texture texture;
	
	public PowerUp(Vector2 position) {
		this.position = position;
	}
	
	abstract void activatePowerUp();
	
	public void drawSprite(Batch mapBatch) {
        mapBatch.draw(this.texture, this.position.x, this.position.y, 1, 1);
    }
	
	public FireTruck getTruck() {
		return truck;
	}
	public void setTruck(FireTruck truck) {
		this.truck = truck;
	}
	public void setPosition(Vector2 position) {
		this.position = position;
	}
	public Vector2 getPosition() {
		return this.position;
	}

	public boolean isPickedUp() {
		return pickedUp;
	}

	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}
}
