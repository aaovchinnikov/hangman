package hangman;

/**
 * Represents object for getting guess attempts, specifically characters, from some source.
 * 
 * @author Alexander Ovchinnikov
 *
 */
public interface Guess {
	/**
	 * Gets next guess attempt
	 * @return next character
	 */
	char next();
}