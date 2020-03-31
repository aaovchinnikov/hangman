package hangman.main;

import java.util.Scanner;

import hangman.impl.Hangman;
import hangman.impl.SimpleGuess;
import hangman.impl.SimpleResult;
import hangman.impl.SimpleSecret;

public class Main {

	public static void main(String[] args) {
		new SimpleResult(
			System.out, 
			new Hangman(
				new SimpleSecret("secret", System.out),
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
