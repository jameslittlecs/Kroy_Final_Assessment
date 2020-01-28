package com.mozarellabytes.kroy.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mozarellabytes.kroy.Kroy;
import com.mozarellabytes.kroy.Minigame.DanceMove;
import com.mozarellabytes.kroy.Minigame.DanceManager;

/**
 * The screen for the minigame that triggers when a firetruck meets an ET patrol
 */



public class DanceScreen implements Screen {

    /** Instance of our game that allows us the change screens */
    private final Kroy game;

    /** Camera to set the projection for the screen */
    private final OrthographicCamera camera;

    /** Object for handling those funky beats */
    private final DanceManager danceMan;

    private final Texture arrowUpTexture;
    private final Texture arrowDownTexture;
    private final Texture arrowLeftTexture;
    private final Texture arrowRightTexture;
    private final Texture targetBoxTexture;

    private final int ARROW_DISPLACEMENT = 128;
    private final int ARROW_SIZE = 96;

    public DanceScreen(Kroy game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getDisplayMode().width, Gdx.graphics.getDisplayMode().height);

        this.danceMan = new DanceManager(60f);

        arrowUpTexture = new Texture(Gdx.files.internal("sprites/dance/arrowUp.png"), true);
        arrowUpTexture.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.MipMapLinearNearest);
        arrowDownTexture = new Texture(Gdx.files.internal("sprites/dance/arrowDown.png"), true);
        arrowDownTexture.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.MipMapLinearNearest);
        arrowLeftTexture = new Texture(Gdx.files.internal("sprites/dance/arrowLeft.png"), true);
        arrowLeftTexture.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.MipMapLinearNearest);
        arrowRightTexture = new Texture(Gdx.files.internal("sprites/dance/arrowRight.png"), true);
        arrowRightTexture.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.MipMapLinearNearest);
        targetBoxTexture = new Texture(Gdx.files.internal("sprites/dance/targetBox.png"), true);
        targetBoxTexture.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.MipMapLinearNearest);

        System.out.println("Got to the dance Screen");
    }

    /**
     * Manages all of the updates/checks during the game
     *
     * @param delta The time in seconds since the last render
     */
    @Override
    public void render(float delta)
    {
        danceMan.update(delta);
//        System.out.println(danceMan.getBeatProxemity());

        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            danceMan.takeMove(DanceMove.UP);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            danceMan.takeMove(DanceMove.DOWN);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            danceMan.takeMove(DanceMove.LEFT);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            danceMan.takeMove(DanceMove.RIGHT);
        }

        Gdx.gl.glClearColor(51/255f, 34/255f, 99/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        game.batch.setProjectionMatrix(camera.combined);

        Vector2 arrowsOrigin = new Vector2(camera.viewportWidth/2-ARROW_SIZE/2, camera.viewportHeight/3);
        game.batch.begin();
        int i = 0;
        for (DanceMove d : danceMan.getMoveList()) {
            switch (d) {
                case UP:
            game.batch.draw(arrowUpTexture, arrowsOrigin.x, arrowsOrigin.y + i * ARROW_DISPLACEMENT - danceMan.getPhase() * ARROW_DISPLACEMENT, ARROW_SIZE, ARROW_SIZE);
                break;
                case DOWN:
            game.batch.draw(arrowDownTexture, arrowsOrigin.x, arrowsOrigin.y + i * ARROW_DISPLACEMENT - danceMan.getPhase() * ARROW_DISPLACEMENT, ARROW_SIZE, ARROW_SIZE);
                break;
                case LEFT:
            game.batch.draw(arrowLeftTexture, arrowsOrigin.x, arrowsOrigin.y + i * ARROW_DISPLACEMENT - danceMan.getPhase() * ARROW_DISPLACEMENT, ARROW_SIZE, ARROW_SIZE);
                break;
                case RIGHT:
            game.batch.draw(arrowRightTexture, arrowsOrigin.x, arrowsOrigin.y + i * ARROW_DISPLACEMENT - danceMan.getPhase() * ARROW_DISPLACEMENT, ARROW_SIZE, ARROW_SIZE);
                break;
            }
            i++;
        }
        game.batch.draw(targetBoxTexture, arrowsOrigin.x, arrowsOrigin.y, ARROW_SIZE, ARROW_SIZE);

        game.batch.end();
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public void drawArrow(DanceMove move) {

    }
}