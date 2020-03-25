package hangman;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Guess {
	private final InputStream input;
	private final OutputStream output;
	
	/**
	 * @param input
	 * @param output
	 */
	public Guess(InputStream input, OutputStream output) {
		this.input = input;
		this.output = output;
	}

	public char next() {
		try (
			final PrintStream out = new PrintStream(this.output);
			final Scanner scanner = new Scanner(this.input)
		) {
			out.print("Guess a letter: ");
            return scanner.next().charAt(0);
		}
	}
}
