package com.mozarellabytes.kroy.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class InvincibilityTimePowerUp extends PowerUp{

	public InvincibilityTimePowerUp(Vector2 position) {
		super(position);
		this.setTexture(new Texture(Gdx.files.internal("powerUps/inv.png")));
		this.setPowerUpDuration(1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void activatePowerUp(FireTruck truck) {
		// TODO Auto-generated method stub
		this.setTruck(truck);
		this.setPickedUp(true);
		getTruck().setCanTakeDamage(false);
		startTime();
		
	}

	@Override
	public void deactivatePowerUp() {
		// TODO Auto-generated method stub
		getTruck().setCanTakeDamage(false);
	}

	
}
