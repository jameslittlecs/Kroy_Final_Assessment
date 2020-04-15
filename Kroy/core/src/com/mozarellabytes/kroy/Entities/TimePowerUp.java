package com.mozarellabytes.kroy.Entities;

import java.util.concurrent.TimeUnit;

public abstract class TimePowerUp extends PowerUp{
	abstract void deactivatePowerUp();
	
	private final int POWERUPDURATION = 5;
	long startTime, currentTime, endTime;
	
	
	public void startTime() {
		startTime = System.currentTimeMillis();
		endTime = startTime + TimeUnit.MINUTES.toMillis(POWERUPDURATION);
	}
	
	public void checkTime() {
		currentTime = System.currentTimeMillis();
		if(currentTime > endTime) {
			activatePowerUp();
		}
	}
	
}