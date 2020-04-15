package com.mozarellabytes.kroy.Entities;

public class DamageTimePowerUp extends TimePowerUp{

	private final float DAMAGECHANGE = 10f;
	
	@Override
	void activatePowerUp() {
		// TODO Auto-generated method stub
		getTruck().setAP(getTruck().getAP() + DAMAGECHANGE);
		startTime();
	}

	@Override
	void deactivatePowerUp() {
		// TODO Auto-generated method stub
		getTruck().setAP(getTruck().getAP() - DAMAGECHANGE);
	}

}
