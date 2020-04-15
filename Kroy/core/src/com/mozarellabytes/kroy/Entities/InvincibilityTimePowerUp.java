package com.mozarellabytes.kroy.Entities;

public class InvincibilityTimePowerUp extends TimePowerUp{

	@Override
	void activatePowerUp() {
		// TODO Auto-generated method stub
		getTruck().setCanTakeDamage(false);
		startTime();
		
	}

	@Override
	void deactivatePowerUp() {
		// TODO Auto-generated method stub
		getTruck().setCanTakeDamage(false);
	}

	
}
