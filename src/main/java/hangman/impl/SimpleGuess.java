package hangman.impl;

import java.io.PrintStream;
import java.util.Iterator;

import hangman.Guess;

/**
 * Implementation of {@link Guess} that takes first character of strings 
 * provided by encapsulated {@link Iterator} instance as a guess attempt
 * 
 * @author Alexander Ovchinnikov
 *
 */
public class SimpleGuess implements Guess {
	private final Iterator<String> iterator;
	private final PrintStream output;

	/**
	 * Main constructor
	 * @param iterator - {@link Iterator} instance, source of strings
	 * @param output - {@link PrintStream} instance where decorating messages should be printed
	 */
	public SimpleGuess(Iterator<String> iterator, PrintStream output) {
		this.iterator = iterator;
		this.output = output;
	}

	@Override
	public char next() {
		this.output.print("Guess a letter: ");
		return iterator.next().charAt(0);
	}
}
