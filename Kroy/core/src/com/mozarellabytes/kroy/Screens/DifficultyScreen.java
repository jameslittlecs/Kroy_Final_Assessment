package com.mozarellabytes.kroy.Screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mozarellabytes.kroy.Kroy;
import com.mozarellabytes.kroy.Utilities.MenuInputHandler;
import com.mozarellabytes.kroy.Utilities.SoundFX;

import Save.SaveManager;

/** This screen is shown after the splash screen and is
 * where the player can choose to start the game or view
 * the control screen */
public class DifficultyScreen implements Screen, InputProcessor {
	
	private final Kroy game;
	private Screen parent;
	private boolean mode;
	public OrthographicCamera camera;
	private Texture backgroundImage;
	
	
    private Rectangle easyButton;
    private Texture easyTexture;
    private Rectangle mediumButton;
    private Texture mediumTexture;
    private Rectangle hardButton;
    private Texture hardTexture;
    private Rectangle backButton;
    private Texture backTexture;
	
	 public DifficultyScreen(final Kroy game, Screen parent) {//true - load, false - save
		 this.game = game;
		 this.parent = parent;
		
		 if (parent.getClass().getSimpleName() != null) {
		 }
		 camera = new OrthographicCamera();
		 camera.setToOrtho(false, Gdx.graphics.getDisplayMode().width, Gdx.graphics.getDisplayMode().height);
		 backgroundImage = new Texture(Gdx.files.internal("menuscreen_blank_2.png"), true);
		 backgroundImage.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.MipMapLinearNearest);
		 
		 this.easyTexture = new Texture(Gdx.files.internal("ui/easy_difficulty.png"), true);
		 this.mediumTexture = new Texture(Gdx.files.internal("ui/medium_difficulty.png"), true);
		 this.hardTexture = new Texture(Gdx.files.internal("ui/hard_difficulty.png"), true);
		 this.backTexture = new Texture(Gdx.files.internal("ui/exit.png"), true);
		 
		 this.easyTexture.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.MipMapLinearNearest);
		 this.mediumTexture.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.MipMapLinearNearest);
		 this.hardTexture.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.MipMapLinearNearest);
		 
		 float width = (float) (mediumTexture.getWidth()*0.75);
		 float height = (float) (mediumTexture.getHeight()*0.75);
		 int y = (int) ((camera.viewportHeight/2 - (height)/2)*0.7);
		 
		 mediumButton = new Rectangle((int) (camera.viewportWidth/2 - ((float) (width/2))), y, width, height);
		 hardButton = new Rectangle((int) (camera.viewportWidth/2 - ((float) (width/2)) + width * 1.25), y, width, height);
		 easyButton = new Rectangle((int) (camera.viewportWidth/2 - ((float) (width/2)) - width * 1.25), y, width, height);
		 backButton = new Rectangle(camera.viewportWidth - 45, camera.viewportHeight - 45, 50, 50);
		 
		 Gdx.input.setInputProcessor(this);
	 }

	@Override
	public void dispose() {
		backgroundImage.dispose();
		easyTexture.dispose();
		mediumTexture.dispose();
		hardTexture.dispose();
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float arg0) {
		 Gdx.gl.glClearColor(51/255f, 34/255f, 99/255f, 1);
	     Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	     camera.update();
	     game.batch.setProjectionMatrix(camera.combined);
	     game.batch.begin();
	     game.batch.draw(backgroundImage, 0, 0, camera.viewportWidth, camera.viewportHeight);
	     game.batch.draw(easyTexture, easyButton.x, easyButton.y, easyButton.width, easyButton.height);
	     game.batch.draw(mediumTexture, mediumButton.x, mediumButton.y, mediumButton.width, mediumButton.height);
	     game.batch.draw(hardTexture, hardButton.x, hardButton.y, hardButton.width, hardButton.height);
	     game.batch.draw(backTexture, backButton.x, backButton.y, backButton.width, backButton.height);
		game.batch.end();
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean keyDown(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		Vector3 position = this.camera.unproject(new Vector3(arg0, arg1, 0));
		
		if (easyButton.contains(position.x, position.y)) {
		    game.setScreen(new GameScreen(game, null));
		    this.dispose();
		} else if (mediumButton.contains(position.x, position.y)) {
				game.setScreen(new GameScreen(game, null));
		        this.dispose();
		} else if (hardButton.contains(position.x, position.y)) {
				game.setScreen(new GameScreen(game, null));
		        this.dispose();
		} else if (backButton.contains(position.x, position.y)) {
				game.setScreen(new MenuScreen(game));
				this.dispose();
		}
		
		return true;
	}

	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

}
