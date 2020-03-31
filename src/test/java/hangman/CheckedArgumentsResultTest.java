package hangman;

import org.junit.Test;

import hangman.impl.CheckedArgumentsResult;

public class CheckedArgumentsResultTest {
	@Test(expected = NullPointerException.class)
	public void nullOut() {
		new CheckedArgumentsResult(null, new Game() {
			@Override
			public boolean won() {
				return false;
			}
		});
	}
	
	@Test(expected = NullPointerException.class)
	public void nullGame() {
		new CheckedArgumentsResult(System.out, null);
	}
}
