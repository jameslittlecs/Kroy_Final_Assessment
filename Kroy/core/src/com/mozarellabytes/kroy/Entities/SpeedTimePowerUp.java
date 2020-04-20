package com.mozarellabytes.kroy.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class SpeedTimePowerUp extends TimePowerUp{
	
	public SpeedTimePowerUp(Vector2 position) {
		super(position);
		this.setTexture(new Texture(Gdx.files.internal("powerUps/speed.png")));
		// TODO Auto-generated constructor stub
	}

	private final float SPEEDCHANGE = 2f;
	
	@Override
	void activatePowerUp() {
		// TODO Auto-generated method stub
		getTruck().setSpeed(getTruck().getSpeed() + SPEEDCHANGE);
		startTime();
	}

	@Override
	public void deactivatePowerUp() {
		// TODO Auto-generated method stub
		getTruck().setSpeed(getTruck().getSpeed() - SPEEDCHANGE);
	}

}
