package hangman;

import static org.junit.Assert.*;

import org.junit.Test;

public class SecretTest {

	@Test
	public void containTest() {
		assertTrue(new Secret("Test").contains('t'));
	}

	@Test
	public void notContainTest() {
		assertFalse(new Secret("Test").contains('c'));
	}
}
