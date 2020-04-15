package com.mozarellabytes.kroy.Entities;

public class HealthPowerUp extends PowerUp{

	@Override
	void activatePowerUp() {
		// TODO Auto-generated method stub
		getTruck().setHP(getTruck().getType().getMaxHP());
	}

}
