package hangman;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Represents result of the Hangman game
 * 
 * @author Alexander Ovchinnikov
 */
public final class PrintedResult {
	/** Encapsulated {@link OutputStream} where result should be printed */
	private final OutputStream output;
	/** Encapsulated {@link Hangman} which result is printed */
	private final Game game;

	/**
	 * Main constructor
	 * 
	 * @param out - {@link OutputStream} where result should be printed
	 */
	public PrintedResult(final OutputStream out, final Game game) {
		this.output = out;
		this.game = game;
	}

	/**
	 * Prints result of the game to encapsulated {@link OutputStream}
	 */
	public void print() {
		final PrintStream out = new PrintStream(this.output);
		if (this.game.won()) {
			out.print("You won!\n");
		} else {
			out.print("You lost.\n");
		}
	}
}
