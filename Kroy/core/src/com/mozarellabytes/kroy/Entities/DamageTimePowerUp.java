package com.mozarellabytes.kroy.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class DamageTimePowerUp extends PowerUp{

	public DamageTimePowerUp(Vector2 position) {
		super(position);
		this.setTexture(new Texture(Gdx.files.internal("powerUps/dmg.png")));
		this.setPowerUpDuration(1);
		// TODO Auto-generated constructor stub
	}

	private final float DAMAGECHANGE = 10f;
	
	@Override
	public void activatePowerUp(FireTruck truck) {
		// TODO Auto-generated method stub
		this.setTruck(truck);
		this.setPickedUp(true);
		getTruck().setAP(getTruck().getAP() + DAMAGECHANGE);
		startTime();
	}

	@Override
	public void deactivatePowerUp() {
		// TODO Auto-generated method stub
		getTruck().setAP(getTruck().getAP() - DAMAGECHANGE);
	}

}
