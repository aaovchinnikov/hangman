package hangman;

import java.util.Scanner;

public class OopMain {

	public static void main(String[] args) {
		new Result(
			System.out, 
			new Hangman(
				new Secret("secret", System.out),
				5,
				new Guess(
					new Scanner(System.in),
					System.out
				),
				System.out
			)
		).print();
	}
}
