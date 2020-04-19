package com.mozarellabytes.kroy.Entities;

import com.badlogic.gdx.math.Vector2;

public class DamageTimePowerUp extends TimePowerUp{

	public DamageTimePowerUp(Vector2 position) {
		super(position);
		// TODO Auto-generated constructor stub
	}

	private final float DAMAGECHANGE = 10f;
	
	@Override
	void activatePowerUp() {
		// TODO Auto-generated method stub
		getTruck().setAP(getTruck().getAP() + DAMAGECHANGE);
		startTime();
	}

	@Override
	public void deactivatePowerUp() {
		// TODO Auto-generated method stub
		getTruck().setAP(getTruck().getAP() - DAMAGECHANGE);
	}

}
