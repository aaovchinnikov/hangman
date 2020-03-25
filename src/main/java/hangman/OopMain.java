package hangman;

import java.io.OutputStream;

public class OopMain {

	public static void main(String[] args) {
		OutputStream out = System.out;
		new PrintedResult(
			out, 
			new Hangman(
				new Secret("secret"),
				5,
				System.in,
				out
			)
		).print();
	}
}
