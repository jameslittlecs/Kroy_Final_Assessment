package com.mozarellabytes.kroy.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class HealthPowerUp extends PowerUp{

	public HealthPowerUp(Vector2 position) {
		super(position);
		this.setTexture(new Texture(Gdx.files.internal("powerUps/hp.png")));
		this.setPowerUpDuration(0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void activatePowerUp(FireTruck truck) {
		// TODO Auto-generated method stub
		this.setTruck(truck);
		this.setPickedUp(true);
		getTruck().setHP(getTruck().getType().getMaxHP());
	}

	@Override
	public void deactivatePowerUp() {
		// TODO Auto-generated method stub
		
	}

}
