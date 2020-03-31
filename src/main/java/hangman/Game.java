package hangman;

/**
 * Represents any game that can be won or lost. The Game doesn't support any tie or standoff situations.
 * @author Alexander Ovchinnikov
 *
 */
public interface Game {
	/**
	 * @return true - if the game is won, false - if game is lost
	 */
	boolean won();
}
