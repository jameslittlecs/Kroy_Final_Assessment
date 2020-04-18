package com.mozarellabytes.kroy.Entities;

public class SpeedTimePowerUp extends TimePowerUp{

	private final float SPEEDCHANGE = 2f;
	
	public SpeedTimePowerUp() {
		
	}
	
	@Override
	void activatePowerUp() {
		// TODO Auto-generated method stub
		getTruck().setSpeed(getTruck().getSpeed() + SPEEDCHANGE);
		startTime();
	}

	@Override
	void deactivatePowerUp() {
		// TODO Auto-generated method stub
		getTruck().setSpeed(getTruck().getSpeed() - SPEEDCHANGE);
	}

}
