package Save;

import java.util.ArrayList;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.glutils.FileTextureData;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.Json;
import com.mozarellabytes.kroy.Entities.DestroyedEntity;
import com.mozarellabytes.kroy.Entities.FireTruck;
import com.mozarellabytes.kroy.Entities.Fortress;
import com.mozarellabytes.kroy.Entities.Patrol;
import com.mozarellabytes.kroy.Screens.GameScreen;
import com.mozarellabytes.kroy.Utilities.DifficultyControl.DifficultyMode;

import powerUps.PowerUp;
import powerUps.PowerUpTile;

public class SaveManager {
	

	// libgdx json loader
	private static Json json = new Json();
	
	/**
	 * 
	 * @param fileHandle - file path of save data
	 * @return - GameData object of decoded savefile, null if file doesn't exist
	 */
	public static GameData loadGame(FileHandle fileHandle) {
		if (fileHandle.exists()) {
			return json.fromJson(GameData.class, Base64Coder.decodeString(fileHandle.readString()));
		}
		else {
			return null;
		}
	}
	/**
	 * creates a GameData object, sets it values, encodes it and writes it to json file
	 * @param gameScreen 
	 * @param fileHandle - file path of where to save to
	 */
	public static void saveGame(GameScreen gameScreen, FileHandle fileHandle) {
		
		GameData gameData = new GameData();
		
		gameData.setDifficultyControl(gameScreen.difficultyControl);
		gameData.setGameState(gameScreen.gameState);
		gameData.setDestroyedEntities(getDestroyedEntityData(gameScreen));
		gameData.setEngines(getEngineData(gameScreen));
		gameData.setPatrols(getPatrolData(gameScreen));
		gameData.setFortresses(getFortressData(gameScreen));
		gameData.setPowerUpTiles(getPowerUpTileData(gameScreen));

		fileHandle.writeString(Base64Coder.encodeString(json.prettyPrint(gameData)), false);
	}
	/**
	 * creates an ArrayList of EngineData each one corresponding to an engine in the game
	 * @param gameScreen
	 * @return
	 */
	private static ArrayList<EngineData> getEngineData(GameScreen gameScreen) {
		ArrayList<EngineData> engines = new ArrayList<EngineData>();
		for (FireTruck truck : gameScreen.getStation().getTrucks()) {
			
			EngineData engineData = new EngineData();
			engineData.setPosition(truck.getPosition());
			engineData.setHP(truck.getHP());
			engineData.setReserve(truck.getReserve());
			engineData.setType(truck.getType());
			
			ArrayList<PowerUpData> powerUps = new ArrayList<PowerUpData>();
			for (PowerUp powerUp : truck.getPowerUps()) {
				PowerUpData powerUpData = new PowerUpData();
				powerUpData.setDuration(powerUp.getDuration());
				powerUpData.setPower(powerUp.getPower());
				powerUps.add(powerUpData);
			}
			engineData.setPowerUps(powerUps);
			
			engines.add(engineData);
		}
		return engines;
	}
	/**
	 * creates an ArrayList of PatrolData each one corresponding to a Patrol in the game
	 * @param gameScreen
	 * @return
	 */
	private static ArrayList<PatrolData> getPatrolData(GameScreen gameScreen) {
		ArrayList<PatrolData> patrols = new ArrayList<PatrolData>();
		for (Patrol patrol : gameScreen.getPatrols()) {
			PatrolData patrolData = new PatrolData();
			patrolData.setPosition(new Vector2(Math.round(patrol.getPosition().x),Math.round(patrol.getPosition().y)));
			patrolData.setHP(patrol.getHP());
			patrolData.setType(patrol.type);
			patrols.add(patrolData);
		}
		return patrols;
	}
	/**
	 * creates an ArrayList of FortressData each one corresponding to a Fortress in the game
	 * @param gameScreen
	 * @return
	 */
	private static ArrayList<FortressData> getFortressData(GameScreen gameScreen){
		ArrayList<FortressData> fortresses = new ArrayList<FortressData>();
		for (Fortress fortress : gameScreen.getFortresses()) {
			FortressData fortressData = new FortressData();
			fortressData.setHP(fortress.getHP());
			fortressData.setPosition(fortress.getPosition());
			fortressData.setType(fortress.getFortressType());
			fortresses.add(fortressData);
		}
		return fortresses;
	}
	/**
	 * creates an ArrayList of DestroyedEntityData each one corresponding to a DestroyedEntity in the game
	 * @param gameScreen
	 * @return
	 */
	private static ArrayList<DestroyedEntityData> getDestroyedEntityData(GameScreen gameScreen){
		ArrayList<DestroyedEntityData> destroyedEntities = new ArrayList<DestroyedEntityData>();
		for (DestroyedEntity destroyedEntity : gameScreen.getDeadEntities()) {
			DestroyedEntityData destroyedEntityData = new DestroyedEntityData();
			destroyedEntityData.setArea(destroyedEntity.getArea());
			destroyedEntityData.setDeadTexture(((FileTextureData)destroyedEntity.getDeadTexture().getTextureData()).getFileHandle().path());;
			destroyedEntities.add(destroyedEntityData);
		}
		return destroyedEntities;
	}
	/**
	 * creates an ArrayList of PowerUpData each one corresponding to a PowerUpTile in the game
	 * @param gameScreen
	 * @return
	 */
	private static ArrayList<PowerUpTileData> getPowerUpTileData(GameScreen gameScreen){
		ArrayList<PowerUpTileData> powerUpTiles = new ArrayList<PowerUpTileData>();
		for (PowerUpTile powerUpTile : gameScreen.getPowerUpTiles()) {
			PowerUpTileData powerUpTileData = new PowerUpTileData();
			powerUpTileData.setPosition(powerUpTile.getPosition());
			powerUpTileData.setPower(powerUpTile.getPower());
			powerUpTiles.add(powerUpTileData);
		}
		return powerUpTiles;
	}
}
