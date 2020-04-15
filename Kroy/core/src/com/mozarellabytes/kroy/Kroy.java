package com.mozarellabytes.kroy;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.mozarellabytes.kroy.Entities.FireTruck;
import com.mozarellabytes.kroy.Entities.FireTruckType;
import com.mozarellabytes.kroy.Entities.Patrol;
import com.mozarellabytes.kroy.Entities.PatrolType;
import com.mozarellabytes.kroy.Screens.*;

/**
 * Our main class where everything starts from. It contains
 * a number of heavy objects which are shared and accessed by
 * different screens so that each screen doesn't need to
 * create their own heavy objects.
 */
public class Kroy extends Game {

	public SpriteBatch batch;
	public ShapeRenderer shapeRenderer;

	public BitmapFont font26;
	public BitmapFont font26b;
	public BitmapFont font19;
	public BitmapFont font15;
	public BitmapFont font11;
	public BitmapFont font60;
	public BitmapFont font50;
	public BitmapFont font50b;
	public BitmapFont font25;
	public BitmapFont font33;
	public BitmapFont font33Red;
	public BitmapFont font120;

	@Override
	public void create () {
		//Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());

		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		generateFonts();
		this.setScreen(new SplashScreen(this));

	}
	
	//Kroy game, Screen previousScreen, FireTruck firetruck, Patrol patrol
	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		batch.dispose();
		shapeRenderer.dispose();
		font19.dispose();
		font15.dispose();
		font11.dispose();
		font25.dispose();
		font26.dispose();
		font33.dispose();
		font33Red.dispose();
		font50.dispose();
		font60.dispose();
		font26b.dispose();
	}
	private void generateFonts() {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Magero.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

		font60 = generator.generateFont(changeParameterSize(parameter, 60));
		font26 = generator.generateFont(changeParameterSize(parameter, 26));
		font19 = generator.generateFont(changeParameterSize(parameter, 19));
		font15 = generator.generateFont(changeParameterSize(parameter, 15));
		font11 = generator.generateFont(changeParameterSize(parameter, 11));
		font50 = generator.generateFont(changeParameterSize(parameter, 50));
		font25 = generator.generateFont(changeParameterSize(parameter, 25));
		font33 = generator.generateFont(changeParameterSize(parameter, 33));
		parameter.color = Color.FIREBRICK;
		font33Red = generator.generateFont(changeParameterSize(parameter, 33));
		font120 = generator.generateFont(changeParameterSize(parameter, 120));
		parameter.color = Color.BLACK;
		font26b = generator.generateFont(changeParameterSize(parameter, 26));
		font50b = generator.generateFont(changeParameterSize(parameter, 50));
	}

	private FreeTypeFontGenerator.FreeTypeFontParameter changeParameterSize(FreeTypeFontGenerator.FreeTypeFontParameter parameter, int size) {
		parameter.size = size;
		return parameter;
	}
}
