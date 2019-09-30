package bowling;

import java.util.ArrayList;
import java.util.List;

import bowling.constants.Constants;
import bowling.interfaces.SuperFrame;

public class Frame extends SuperFrame {
	
	private List<Integer> pinsRolled;
	private int score;
	private int localScore;
	private Constants type;
	
	public Frame() {
		pinsRolled = new ArrayList<>();
		score = 0;
	}
	
	public List<Integer> getPinsRolled() {
		return pinsRolled;
	}
	
	public void setPinsRolled(List<Integer> pinsRolled) {
		this.pinsRolled = pinsRolled;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void addPinsRolled(int pins) {
		pinsRolled.add(pins);
		score += pins;
		localScore = score;
	}
	
	public int getLocalScore() {
		return this.localScore;
	}

	public Constants getType() {
		return type;
	}

	public void setType(Constants type) {
		this.type = type;
	}

}
