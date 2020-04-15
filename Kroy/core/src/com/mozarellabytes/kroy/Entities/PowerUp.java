package com.mozarellabytes.kroy.Entities;

import com.badlogic.gdx.math.Vector2;

public abstract class PowerUp {
	private FireTruck truck;
	private Vector2 position;
	
	abstract void activatePowerUp();
	
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
}
