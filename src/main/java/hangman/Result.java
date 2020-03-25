package hangman;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Represents result of the Hangman game
 * 
 * @author Alexander Ovchinnikov
 */
public final class Result {
	/** Encapsulated {@link OutputStream} where result should be printed */
	private final OutputStream output;
	/** Temporary var for tests */
	private final boolean success;

	/**
	 * Main constructor
	 * 
	 * @param out - {@link OutputStream} where result should be printed
	 */
	public Result(final OutputStream out, final boolean success) {
		this.output = out;
		this.success = success;
	}

	/**
	 * Prints result of the game to encapsulated {@link OutputStream}
	 */
	public void print() {
		final PrintStream out = new PrintStream(this.output);
		if (this.success) {
			out.print("You won!\n");
		} else {
			out.print("You lost.\n");
		}
	}
}
