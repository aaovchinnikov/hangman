package hangman;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class SecretTest {

	@Test
	public void containTest() {
		assertTrue(new Secret("Test", System.out).contains('t'));
	}

	@Test
	public void notContainTest() {
		assertFalse(new Secret("Test", System.out).contains('c'));
	}
	
	@Test
	public void printMasked() {
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		final PrintStream out = new PrintStream(baos);
		Secret secret = new Secret("Test", out);
		secret.print();
		String output = baos.toString();
		assertTrue(output.equals("????\n\n"));
	}
}
