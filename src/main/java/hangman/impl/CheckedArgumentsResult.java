package hangman.impl;

import java.io.PrintStream;

import hangman.Game;
import hangman.Result;

/**
 * Wrapper around {@link SimpleResult} that checks arguments before constructing an instance.
 * 
 * @author Alexander Ovchinnikov
 *
 */
public final class CheckedArgumentsResult implements Result {
	/**
	 * Encapsulated {@link SimpleResult} 
	 */
	private final SimpleResult inner;
	
	/**
	 * Main constructor
	 * @param out - {@link PrintStream} where result should be printed
	 * @throws NullPointerException if any argument is <b>null</b>
	 */
	public CheckedArgumentsResult(final PrintStream out, final Game game) {
		if (out == null) {
			throw new NullPointerException("Provided PrintStream is null");
		}
		if (game == null) {
			throw new NullPointerException("Provided Game is null");
		}
		this.inner = new SimpleResult(out, game);
	}
	
	@Override
	public void print() {
		this.inner.print();
	}

}
