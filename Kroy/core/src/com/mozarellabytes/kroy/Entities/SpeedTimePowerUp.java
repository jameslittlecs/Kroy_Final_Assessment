package com.mozarellabytes.kroy.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class SpeedTimePowerUp extends PowerUp{
	
	private float SPEEDCHANGE = 100f;
	
	public SpeedTimePowerUp(Vector2 position) {
		super(position);
		this.setTexture(new Texture(Gdx.files.internal("powerUps/speed.png")));
		this.setPowerUpDuration(1);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void activatePowerUp(FireTruck truck) {
		// TODO Auto-generated method stub
		this.setTruck(truck);
		this.setPickedUp(true);
		this.getTruck().setSpeed(this.getTruck().getSpeed() + SPEEDCHANGE);
		startTime();
	}

	@Override
	public void deactivatePowerUp() {
		// TODO Auto-generated method stub
		getTruck().setSpeed(getTruck().getSpeed() - SPEEDCHANGE);
	}
	
	public void drawSprite(Batch mapBatch) {
        mapBatch.draw(this.getTexture(), getPosition().x, getPosition().y, 1, 1);
    }

}
