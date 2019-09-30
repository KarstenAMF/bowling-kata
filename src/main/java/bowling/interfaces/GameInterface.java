package bowling.interfaces;

import bowling.exceptions.GameOverException;

public interface GameInterface {
	
	void AddRoll(int pins) throws GameOverException;
	// unused
	//List<SuperFrame> Frames();
	int TotalScore();
	boolean Over();

}
