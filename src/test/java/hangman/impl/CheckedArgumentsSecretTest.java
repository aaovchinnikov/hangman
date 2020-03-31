package hangman.impl;

import org.junit.Test;

import hangman.impl.CheckedArgumentsSecret;

public final class CheckedArgumentsSecretTest {

	@Test(expected = IllegalArgumentException.class)
	public void createSecretWithWrongMask() {
		new CheckedArgumentsSecret("secret", new boolean[]{false}, System.out);
	}

	@Test(expected = NullPointerException.class)
	public void nullMask() {
		new CheckedArgumentsSecret("secret", null, System.out);
	}
}
