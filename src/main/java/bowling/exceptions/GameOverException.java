package bowling.exceptions;

/**
 * Throws exception when the game is over but another roll is tried to be added.
 * @author KM
 *
 */
public class GameOverException extends Exception {
	
	  public GameOverException() { super(); }
	  public GameOverException(String message) { super(message); }
	  public GameOverException(String message, Throwable cause) { super(message, cause); }
	  public GameOverException(Throwable cause) { super(cause); }

}
