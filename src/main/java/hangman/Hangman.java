package hangman;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * 
 * @author Alexander Ovchinnikov
 *
 */
public final class Hangman implements Game {
	private final Secret secret;
	private final int max;
	private final Guess guess;
	private final OutputStream output;

	/**
	 * @param secret
	 * @param max
	 */
	public Hangman(Secret secret, int max, Guess guess, OutputStream out) {
		this.secret = secret;
		this.max = max;
		this.guess = guess;
		this.output = out;
	}

	public boolean won() {
		int mistakes = 0;
		final PrintStream out = new PrintStream(this.output);
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
