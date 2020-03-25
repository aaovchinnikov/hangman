package hangman;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayInputStream;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class GuessTest {

	@Test
	public void guessTest() {
		char five = '5';
		final String str = new StringBuilder().append(five).append('\n').toString();
		Guess guess = new Guess(
			new ByteArrayInputStream(str.getBytes()),
			System.out
		);
		assertThat(guess.guess(), CoreMatchers.equalTo(five));
	}
}
