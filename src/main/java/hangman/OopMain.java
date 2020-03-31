package hangman;

import java.io.OutputStream;
import java.util.Scanner;

public class OopMain {

	public static void main(String[] args) {
		final OutputStream out = System.out;
		new Result(
			out, 
			new Hangman(
				new Secret("secret"),
				5,
				new Guess(
					new Scanner(System.in),
					out
				),
				out
			)
		).print();
	}
}
