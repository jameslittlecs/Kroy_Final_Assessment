package com.mozarellabytes.kroy.Utilities;

import java.text.DecimalFormat;

public class DifficultyControl {
    /** The value of the current difficulty level */
    private Integer currentDifficulty;
    
    private difficultyMode difficulty;               
    private Integer modeMultiplier;

    /** The amount of time, in seconds, for the difficulty to increment by one */
    private float difficultyChangeInterval;

    /** The amount of time that has passed since the last increment of difficulty */
    private float currentTime;
    
    enum difficultyMode {
        EASY, MEDIUM, HARD
    }


    /** The constructor for DifficultyControl
	 */
	public DifficultyControl(){
		difficulty = difficultyMode.MEDIUM;
		currentTime = 60;
	    currentDifficulty = 1;
	    
	    
	    switch (difficulty) {
	    case EASY:	    	
	    	setModeMultiplier(10);
	    	setDifficultyChangeInterval(90f);
	    	currentTime = 90;
	        break;
	    case MEDIUM:	    	
	    	setModeMultiplier(50);
	    	setDifficultyChangeInterval(60f);
	    	currentTime = 60;
	    	break;
	    case HARD:
	    	setModeMultiplier(70);
	    	setDifficultyChangeInterval(45f);
	    	currentTime = 45;
	    	break;
	    	
	    }
		System.out.println(difficulty);

	}


    /** Updates the amount of time to a change in difficulty
     *
     * @param TimeDelta The amount of time since the last time update
     */
    public void incrementCurrentTime(float TimeDelta){
        currentTime -= TimeDelta;
        changeDifficulty();
    }

    /** Gives the difficulty information as String that can be displayed by the GUI
     *
     * @return A String containing the current difficulty and time to the next difficulty increment
     */
    public String getDifficultyOutput(){
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        return ("Difficulty:" + String.valueOf(currentDifficulty) + "\n" +
                "Time To Increase:" + decimalFormat.format(currentTime));
    }

    /** Checks if enough time has passed for the difficulty to increment
     * Increases difficulty by 1 if needed
     */
    private void changeDifficulty(){
        if (currentTime <= 0){
            currentTime = difficultyChangeInterval;
            currentDifficulty++;
        }
    }

    /** Returns the current difficulty level as a multiplier to be used
     *
     * @return A float equal to one tenth of the current difficulty level
     */
    public float getDifficultyMultiplier(){
        return (currentDifficulty + modeMultiplier)/10;
    }


	public void setModeMultiplier(Integer modeMultiplier) {
		this.modeMultiplier = modeMultiplier;
	}


	public float getDifficultyChangeInterval() {
		return difficultyChangeInterval;
	}


	public void setDifficultyChangeInterval(float difficultyChangeInterval) {
		this.difficultyChangeInterval = difficultyChangeInterval;
	}
	
	public void setDifficultyMedium() {
		difficulty = difficultyMode.MEDIUM;
	}
	
	public void setDifficultyHard() {
		difficulty = difficultyMode.HARD;
		System.out.println(currentTime);
	}
	
	public void setDifficultyEasy() {
		difficulty = difficultyMode.EASY;
		System.out.println(currentTime);
	}


	public difficultyMode getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(difficultyMode difficulty) {
		this.difficulty = difficulty;
	}


	public Integer getCurrentDifficulty() {
		return currentDifficulty;
	}


	public Integer getModeMultiplier() {
		return modeMultiplier;
	}


	public float getCurrentTime() {
		return currentTime;
	}
	
	
}
