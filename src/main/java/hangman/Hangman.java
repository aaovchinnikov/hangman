package hangman;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 
 * @author Alexander Ovchinnikov
 *
 */
public final class Hangman implements Game {
	private final Secret secret;
	private final int max;
	private final InputStream input;
	private final OutputStream output;

	/**
	 * @param secret
	 * @param max
	 */
	public Hangman(Secret secret, int max, InputStream in, OutputStream out) {
		this.secret = secret;
		this.max = max;
		this.input = in;
		this.output = out;
	}

	public boolean won() {
		int mistakes = 0;
		Guess guess = new Guess(this.input, this.output);
		try (final PrintStream out = new PrintStream(this.output)){
			while (mistakes < this.max) {
				if (this.secret.contains(guess.next())) {
	                	out.print("Hit!\n");
	                } else {
	                	mistakes++;
	                    out.printf(
	                    		"Missed, mistake #%d out of %d\n",
	                    		mistakes, this.max
	                    );
	                }
				}
			return false;
		}	
	}
}
