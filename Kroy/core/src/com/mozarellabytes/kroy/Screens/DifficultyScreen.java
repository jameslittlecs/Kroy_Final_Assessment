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
	
    private Rectangle save1Button;
    private Texture save1Texture;
    private Rectangle save2Button;
    private Texture save2Texture;
    private Rectangle save3Button;
    private Texture save3Texture;
    private Rectangle backButton;
    private Texture backTexture;
	
	 public DifficultyScreen(final Kroy game, Screen parent, boolean mode) {//true - load, false - save
		 this.game = game;
		 this.parent = parent;
		 this.mode = mode;
		 if (parent.getClass().getSimpleName() != null) {
		 }
		 camera = new OrthographicCamera();
		 camera.setToOrtho(false, Gdx.graphics.getDisplayMode().width, Gdx.graphics.getDisplayMode().height);
		 backgroundImage = new Texture(Gdx.files.internal("menuscreen_blank_2.png"), true);
		 backgroundImage.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.MipMapLinearNearest);
		 
		 this.save1Texture = new Texture(Gdx.files.internal("ui/save1.png"), true);
		 this.save2Texture = new Texture(Gdx.files.internal("ui/save2.png"), true);
		 this.save3Texture = new Texture(Gdx.files.internal("ui/save3.png"), true);
		 this.backTexture = new Texture(Gdx.files.internal("ui/exit.png"), true);
		 
		 this.save1Texture.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.MipMapLinearNearest);
		 this.save2Texture.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.MipMapLinearNearest);
		 this.save3Texture.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.MipMapLinearNearest);
		 
		 float width = (float) (save1Texture.getWidth()*0.75);
		 float height = (float) (save1Texture.getHeight()*0.75);
		 int y = (int) ((camera.viewportHeight/2 - (height)/2)*0.7);
		 
		 save2Button = new Rectangle((int) (camera.viewportWidth/2 - ((float) (width/2))), y, width, height);
		 save3Button = new Rectangle((int) (camera.viewportWidth/2 - ((float) (width/2)) + width * 1.25), y, width, height);
		 save1Button = new Rectangle((int) (camera.viewportWidth/2 - ((float) (width/2)) - width * 1.25), y, width, height);
		 backButton = new Rectangle(camera.viewportWidth - 45, camera.viewportHeight - 45, 50, 50);
		 
		 Gdx.input.setInputProcessor(this);
	 }

	@Override
	public void dispose() {
		backgroundImage.dispose();
		save1Texture.dispose();
		save2Texture.dispose();
		save3Texture.dispose();
		
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
	     game.batch.draw(save1Texture, save1Button.x, save1Button.y, save1Button.width, save1Button.height);
	     game.batch.draw(save2Texture, save2Button.x, save2Button.y, save2Button.width, save2Button.height);
	     game.batch.draw(save3Texture, save3Button.x, save3Button.y, save3Button.width, save3Button.height);
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
		if (this.mode == true) {
			if (save1Button.contains(position.x, position.y)) {
		        game.setScreen(new GameScreen(game, SaveManager.loadGame(Gdx.files.local("saves/save1.json"))));
		        this.dispose();
			} else if (save2Button.contains(position.x, position.y)) {
				game.setScreen(new GameScreen(game, SaveManager.loadGame(Gdx.files.local("saves/save2.json"))));
		        this.dispose();
			} else if (save3Button.contains(position.x, position.y)) {
				game.setScreen(new GameScreen(game, SaveManager.loadGame(Gdx.files.local("saves/save3.json"))));
		        this.dispose();
			} else if (backButton.contains(position.x, position.y)) {
				game.setScreen(new MenuScreen(game));
				this.dispose();
			}
		}
		else {
			if (save1Button.contains(position.x, position.y)) {
				SaveManager.saveGame((GameScreen)parent, Gdx.files.local("saves/save1.json"));
				game.setScreen(new MenuScreen(game));
		        this.dispose();
			} else if (save2Button.contains(position.x, position.y)) {
				SaveManager.saveGame((GameScreen)parent, Gdx.files.local("saves/save2.json"));
				game.setScreen(new MenuScreen(game));
		        this.dispose();
			} else if (save3Button.contains(position.x, position.y)) {
				SaveManager.saveGame((GameScreen)parent, Gdx.files.local("saves/save3.json"));
				game.setScreen(new MenuScreen(game));
		        this.dispose();
			} else if (backButton.contains(position.x, position.y)) {
				game.setScreen(parent);
				this.dispose();
			}
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
