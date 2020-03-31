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

	@Test 
	public void createPartiallyMaskedSecret() {
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		final PrintStream out = new PrintStream(baos);
		final Secret secret = new Secret("secret", new boolean[]{false,true,false,true,false,true}, out);
		secret.print();
		String output = baos.toString();
		assertTrue(output.equals("?e?r?t\n\n"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createSecretWithWrongMask() {
		new Secret("secret", new boolean[]{false}, System.out);
	}
	
	@Test
	public void unmaskIncluded() {
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		final PrintStream out = new PrintStream(baos);
		Secret secret = new Secret("Test", out);
		secret = secret.unmask('e');
		secret.print();
		String output = baos.toString();
		assertTrue(output.equals("?e??\n\n"));
	}
	
	@Test
	public void unmaskNothing() {
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		final PrintStream out = new PrintStream(baos);
		Secret secret = new Secret("Test", out);
		secret = secret.unmask('F');
		secret.print();
		String output = baos.toString();
		assertTrue(output.equals("????\n\n"));
	}
	
	@Test
	public void secretHasMasked() {
		Secret secret = new Secret("Test", System.out);
		assertFalse(secret.unmasked());
	}
	
	@Test
	public void secretAllUnmasked() {
		Secret secret = new Secret("Test", new boolean[]{true, true, true, true} ,System.out);
		assertTrue(secret.unmasked());
	}
	
}
