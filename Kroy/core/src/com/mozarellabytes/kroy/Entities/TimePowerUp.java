package com.mozarellabytes.kroy.Entities;

import java.util.concurrent.TimeUnit;

public abstract class TimePowerUp extends PowerUp{
	int powerUpDuration = 5;
	long startTime, currentTime, endTime;
	
	public void startTime() {
		startTime = System.currentTimeMillis();
		endTime = startTime + TimeUnit.MINUTES.toMillis(5);
	}
	
	public void checkTime() {
		currentTime = System.currentTimeMillis();
		if(currentTime > endTime) {
			activatePowerUp();
		}
	}
	
}