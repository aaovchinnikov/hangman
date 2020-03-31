package hangman;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import hangman.impl.SimpleGuess;

public final class SimpleGuessTest {

	@Test
	public void guessTest() {
		char five = '5';
		final String str = new StringBuilder().append(five).append('\n').toString();
		Guess guess = new SimpleGuess(
			new Scanner(new ByteArrayInputStream(str.getBytes())),
			System.out
		);
		assertThat(guess.next(), CoreMatchers.equalTo(five));
	}

	@Test
	public void twoGuessesTest() {
		final char five = '5';
		final char six = '6';
		final String str = new StringBuilder().append(five).append('\n').append(six).append('\n').toString();
		final Guess guess = new SimpleGuess(
			new Scanner(new ByteArrayInputStream(str.getBytes())),
			System.out
		);
		assertThat(guess.next(), CoreMatchers.equalTo(five));
		assertThat(guess.next(), CoreMatchers.equalTo(six));
	}
}
