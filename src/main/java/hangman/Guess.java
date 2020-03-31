package hangman;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;

public class Guess {
	private final Iterator<String> iterator;
	private final OutputStream output;

	/**
	 * @param input
	 * @param output
	 */
	public Guess(Iterator<String> iterator, OutputStream output) {
		this.iterator = iterator;
		this.output = output;
	}

	public char next() {
		final PrintStream out = new PrintStream(this.output);
		out.print("Guess a letter: ");
		return iterator.next().charAt(0);
	}
}
