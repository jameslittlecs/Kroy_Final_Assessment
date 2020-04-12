package Save;

import java.util.ArrayList;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.Json;
import com.mozarellabytes.kroy.Entities.FireTruck;
import com.mozarellabytes.kroy.Screens.GameScreen;

public class SaveManager {
	
	private static Json json = new Json();
	
	public static GameData loadGame(FileHandle fileHandle) {
		if (fileHandle.exists()) {
			return json.fromJson(GameData.class, Base64Coder.decodeString(fileHandle.readString()));
		}
		else {
			return null;
		}
	}
	public static void saveGame(GameScreen gameScreen, FileHandle fileHandle) {
		
		GameData gameData = new GameData();
		
		gameData.setDifficultyControl(gameScreen.getDifficultyControl());
		gameData.setGameState(gameScreen.gameState);

		ArrayList<EngineData> engines = new ArrayList<EngineData>();
		for (FireTruck truck : gameScreen.getStation().getTrucks()) {
			
			EngineData engineData = new EngineData();
			engineData.setPosition(truck.getPosition());
			engineData.setHP(truck.getHP());
			engineData.setReserve(truck.getReserve());
			engineData.setType(truck.getType());
			
			engines.add(engineData);
		}
		gameData.setEngines(engines);

		fileHandle.writeString(Base64Coder.encodeString(json.prettyPrint(gameData)), false);
	}
}
