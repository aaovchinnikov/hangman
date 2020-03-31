package hangman;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Represents result of the {@link Game} that can be printed to encapsulated {@link OutputStream}
 * 
 * @author Alexander Ovchinnikov
 */
public final class SimpleResult {
	/** Encapsulated {@link PrintStream} where result should be printed */
	private final PrintStream output;
	/** Encapsulated {@link Game} which result is printed */
	private final Game game;

	/**
	 * Main constructor
	 * 
	 * @param out - {@link PrintStream} where result should be printed
	 */
	public SimpleResult(final PrintStream out, final Game game) {
		this.output = out;
		this.game = game;
	}

	/**
	 * Prints result of the game to encapsulated {@link OutputStream}
	 */
	public void print() {
		if (this.game.won()) {
			this.output.print("You won!\n");
		} else {
			this.output.print("You lost.\n");
		}
	}
}
