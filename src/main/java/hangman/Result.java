package hangman;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Represents result of the {@link Game} that can be printed to encapsulated {@link OutputStream}
 * 
 * @author Alexander Ovchinnikov
 */
public final class Result {
	/** Encapsulated {@link OutputStream} where result should be printed */
	private final OutputStream output;
	/** Encapsulated {@link Game} which result is printed */
	private final Game game;

	/**
	 * Main constructor
	 * 
	 * @param out - {@link OutputStream} where result should be printed
	 */
	public Result(final OutputStream out, final Game game) {
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
