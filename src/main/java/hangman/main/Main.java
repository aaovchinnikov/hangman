package hangman.main;

import java.util.Scanner;

import hangman.impl.CheckedArgumentsResult;
import hangman.impl.CheckedArgumentsSecret;
import hangman.impl.Hangman;
import hangman.impl.SimpleGuess;

public class Main {

	public static void main(String[] args) {
		new CheckedArgumentsResult(
			System.out, 
			new Hangman(
				new CheckedArgumentsSecret(
						new String[] {
							"simplicity", "equality", "grandmother",
							"neighborhood", "relationship", "mathematics",
							"university", "explanation"
						},
						System.out
				),
				5,
				new SimpleGuess(
					new Scanner(System.in),
					System.out
				),
				System.out
			)
		).print();
	}
}
