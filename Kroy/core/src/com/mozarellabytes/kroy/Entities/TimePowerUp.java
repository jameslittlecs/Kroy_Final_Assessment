package com.mozarellabytes.kroy.Entities;

import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class TimePowerUp extends PowerUp{
	public TimePowerUp(Vector2 position) {
		super(position);
		// TODO Auto-generated constructor stub
	}

	public abstract void deactivatePowerUp();
	
	private final int POWERUPDURATION = 5;
	long startTime, currentTime, endTime;
	
	public void startTime() {
		startTime = System.currentTimeMillis();
		endTime = startTime + TimeUnit.MINUTES.toMillis(POWERUPDURATION);
		activatePowerUp();
	}
	
	public boolean checkTime() {
		currentTime = System.currentTimeMillis();
		if(currentTime > endTime) {
			return true;
		}
		else {
			return false;
		}
	}
	
}