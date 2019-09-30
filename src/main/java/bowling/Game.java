package bowling;

import java.util.ArrayList;
import java.util.List;

import bowling.constants.Constants;
import bowling.exceptions.GameOverException;
import bowling.interfaces.GameInterface;

public class Game implements GameInterface {
	
	private List<Frame> frames;
	private int currentFrame;
	private boolean midFrame;
	
	public Game() {
		frames = new ArrayList<>();
		currentFrame = 0;
		midFrame = false;
	}
	

	public void AddRoll(int pins) throws GameOverException {
		if(Over()) {
			throw new GameOverException("Game ended.");
		}
		Frame frame = null;
		if(!midFrame) {
			frame = new Frame();
			frames.add(frame);
			midFrame = true;
		} else {
			frame = frames.get(currentFrame);
		}
		if(pins == 10) {
			frame.addPinsRolled(pins);
			// TODO sonderregel zehn würfe
			midFrame = false;
			currentFrame++;
		} else {
			frame.addPinsRolled(pins);
			if(frame.getPinsRolled().size() > 1) {
				midFrame = false;
				currentFrame++;
			}
		}

	}
	
	/**
	 * 
	 * @return
	 */
	public int lastRoundThrow() {
		// If new frame to be started, -1
		if(!midFrame) {
			return -1;
		}
		return frames.get(currentFrame).getScore();
	}
	
	public List<Frame> Frames() {
		return frames;
	}
	
	/**
	 * Returns total score.
	 * @return int
	 */
	public int TotalScore() {
		return frames.get(frames.size()-1).getScore();
	}
	
	/**
	 * Returns true if game is over.
	 * @return boolean 
	 */
	public boolean Over() {
		if(frames.size() < 10) return false;
		return !midFrame;
	}
	
	/**
	 * Adds the game scores and prints result.
	 */
	public void printGame() {
		int score = 0;
		for(int x = 0; x<frames.size(); x++) {
			Frame f = frames.get(x);
			score += f.getScore();
			f.setScore(score);
			f.setType(Constants.NORMAL);
			
			if(f.getLocalScore() == 10 && x<9) {
				// SPARE
				if(f.getPinsRolled().size() > 1) {
					score += frames.get(x+1).getPinsRolled().get(0);
					f.setScore(score);
					f.setType(Constants.SPARE);
				} else {
					// STRIKE
					score += frames.get(x+1).getPinsRolled().get(0);
					if(frames.get(x+1).getPinsRolled().size() > 1) {
						score += frames.get(x+1).getPinsRolled().get(1);
					} else if((x+2) <9) {
						score += frames.get(x+2).getPinsRolled().get(0);
					}
					f.setScore(score);
					f.setType(Constants.STRIKE);
				}
			}
		}

		for(Frame f : frames) {
			System.out.print(f.getPinsRolled() + " | ");
			System.out.print(f.getScore() + " | ");
			System.out.println(f.getType());
		}
	}

}
