package hangman.impl;

import java.io.PrintStream;

import hangman.Game;
import hangman.Guess;
import hangman.Secret;

/**
 * 
 * @author Alexander Ovchinnikov
 *
 */
public final class Hangman implements Game {
	private final Secret secret;
	private final int max;
	private final Guess guess;
	private final PrintStream output;

	/**
	 * @param secret
	 * @param max
	 */
	public Hangman(Secret secret, int max, Guess guess, PrintStream out) {
		this.secret = secret;
		this.max = max;
		this.guess = guess;
		this.output = out;
	}

	public boolean won() {
		int mistakes = 0;
		char chr;
		Secret sec = this.secret;
		while (mistakes < this.max) {
			chr = guess.next();
			if (sec.contains(chr)) {
				this.output.print("Hit!\n");
				sec = sec.unmask(chr);
            } else {
              	mistakes++;
              	this.output.printf(
              		"Missed, mistake #%d out of %d\n",
                    mistakes, this.max
              	);
            }
			sec.print();
			if (sec.unmasked()) {
				return true; 
			}
		}
		return false;
	}
}
