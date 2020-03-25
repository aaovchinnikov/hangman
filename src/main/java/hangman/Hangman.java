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
		try (
			final PrintStream out = new PrintStream(this.output);
			final Scanner scanner = new Scanner(this.input)
		) {
			int mistakes = 0;
			while (mistakes < this.max) {
				out.print("Guess a letter: ");
                char chr = scanner.next().charAt(0);
                if (this.secret.contains(chr)) {
                	out.print("Hit!\n");
                } else {
                    out.printf(
                    		"Missed, mistake #%d out of %d\n",
                    		mistakes + 1, this.max
                    );
                    ++mistakes;
                }
			}
			return false;
		}
	}
}
