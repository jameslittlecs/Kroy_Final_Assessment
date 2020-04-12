package Save;

import java.util.ArrayList;

import com.mozarellabytes.kroy.GameState;
import com.mozarellabytes.kroy.Utilities.DifficultyControl;

public class GameData {
	private DifficultyControl difficultyControl;
	private GameState gameState;
	private ArrayList<EngineData> engines;
//	private ArrayList<FortressData> fortresses;
//	private ArrayList<PatrolData> patrols;

	public DifficultyControl getDifficultyControl() {
		return difficultyControl;
	}

	public void setDifficultyControl(DifficultyControl difficultyControl) {
		this.difficultyControl = difficultyControl;
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public ArrayList<EngineData> getEngines() {
		return engines;
	}

	public void setEngines(ArrayList<EngineData> engines) {
		this.engines = engines;
	}

//	public ArrayList<FortressData> getFortresses() {
//		return fortresses;
//	}
//
//	public void setFortresses(ArrayList<FortressData> fortresses) {
//		this.fortresses = fortresses;
//	}
//
//	public ArrayList<PatrolData> getPatrols() {
//		return patrols;
//	}
//
//	public void setPatrols(ArrayList<PatrolData> patrols) {
//		this.patrols = patrols;
//	}
}