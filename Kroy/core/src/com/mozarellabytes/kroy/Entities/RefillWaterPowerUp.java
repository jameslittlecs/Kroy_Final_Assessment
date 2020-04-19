package com.mozarellabytes.kroy.Entities;

import com.badlogic.gdx.math.Vector2;

public class RefillWaterPowerUp extends PowerUp{

	public RefillWaterPowerUp(Vector2 position) {
		super(position);
		// TODO Auto-generated constructor stub
	}

	@Override
	void activatePowerUp() {
		// TODO Auto-generated method stub
		getTruck().setReserve(getTruck().getType().getMaxReserve());
	}

}
