package com.mozarellabytes.kroy.Entities;

public class RefillWaterPowerUp extends PowerUp{

	@Override
	void activatePowerUp() {
		// TODO Auto-generated method stub
		getTruck().setReserve(getTruck().getType().getMaxReserve());
	}

}
