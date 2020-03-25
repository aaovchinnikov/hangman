package hangman;

/**
 * Represents any game that can be won or lost. No tie or standoff situations allowed.
 * @author Alexander Ovchinnikov
 *
 */
public interface Game {
	/**
	 * @return true - if the game is won, false - if game is lost
	 */
	boolean won();
}
