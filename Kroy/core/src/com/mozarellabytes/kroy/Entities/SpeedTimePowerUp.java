package com.mozarellabytes.kroy.Entities;

import com.badlogic.gdx.math.Vector2;

public class SpeedTimePowerUp extends TimePowerUp{

	public SpeedTimePowerUp(Vector2 position) {
		super(position);
		// TODO Auto-generated constructor stub
	}

	private final float SPEEDCHANGE = 2f;
	
	@Override
	void activatePowerUp() {
		// TODO Auto-generated method stub
		getTruck().setSpeed(getTruck().getSpeed() + SPEEDCHANGE);
		startTime();
	}

	@Override
	public void deactivatePowerUp() {
		// TODO Auto-generated method stub
		getTruck().setSpeed(getTruck().getSpeed() - SPEEDCHANGE);
	}

}
