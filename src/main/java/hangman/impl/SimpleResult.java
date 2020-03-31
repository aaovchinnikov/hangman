package hangman.impl;

import java.io.OutputStream;
import java.io.PrintStream;

import hangman.Game;
import hangman.Result;

/**
 * Represents result of the {@link Game} that can be printed to encapsulated {@link PrintStream}.
 * Doesn't check provided arguments for constructors. If you need these checks, use {@link CheckedArgumentsResult} instead.
 * 
 * @author Alexander Ovchinnikov
 */
public final class SimpleResult implements Result {
	/** Encapsulated {@link PrintStream} where result should be printed */
	private final PrintStream output;
	/** Encapsulated {@link Game} which result should be printed */
	private final Game game;

	/**
	 * Main constructor
	 * 
	 * @param out - {@link PrintStream} where result should be printed
	 * @param game - {@link Game} which result should be printed
	 */
	public SimpleResult(final PrintStream out, final Game game) {
		this.output = out;
		this.game = game;
	}

	/**
	 * Prints result of the game to encapsulated {@link OutputStream}
	 */
	@Override
	public void print() {
		if (this.game.won()) {
			this.output.print("You won!\n");
		} else {
			this.output.print("You lost.\n");
		}
	}
}
