package com.mozarellabytes.kroy.Entities;

import com.badlogic.gdx.math.Vector2;

public class InvincibilityTimePowerUp extends TimePowerUp{

	public InvincibilityTimePowerUp(Vector2 position) {
		super(position);
		// TODO Auto-generated constructor stub
	}

	@Override
	void activatePowerUp() {
		// TODO Auto-generated method stub
		getTruck().setCanTakeDamage(false);
		startTime();
		
	}

	@Override
	public void deactivatePowerUp() {
		// TODO Auto-generated method stub
		getTruck().setCanTakeDamage(false);
	}

	
}
