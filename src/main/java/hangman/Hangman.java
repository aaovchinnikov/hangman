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
		char chr;
		Secret sec = this.secret;
		while (mistakes < this.max) {
			chr = guess.next();
			if (this.secret.contains(chr)) {
				out.print("Hit!\n");
				sec = sec.unmask(chr);
            } else {
              	mistakes++;
              	out.printf(
              		"Missed, mistake #%d out of %d\n",
                    mistakes, this.max
              	);
            }
			sec.print();
			if (this.secret.unmasked()) {
				return true;
			}
		}
		return false;
	}
}
