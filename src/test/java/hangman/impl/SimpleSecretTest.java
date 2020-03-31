package hangman.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import hangman.Secret;
import hangman.impl.SimpleSecret;

public final class SimpleSecretTest {

	@Test
	public void containTest() {
		assertTrue(new SimpleSecret("test", System.out).contains('t'));
	}

	@Test
	public void notContainTest() {
		assertFalse(new SimpleSecret("test", System.out).contains('c'));
	}
	
	@Test
	public void notContainMaskedTest() {
		assertFalse(new SimpleSecret("test", new boolean[]{true, false, false, true}, System.out).contains('t'));
	}
	
	@Test
	public void printMasked() {
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		final PrintStream out = new PrintStream(baos);
		SimpleSecret secret = new SimpleSecret("test", out);
		secret.print();
		String output = baos.toString();
		assertTrue(output.equals("The word: ????\n\n"));
	}

	@Test 
	public void createPartiallyMaskedSecret() {
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		final PrintStream out = new PrintStream(baos);
		final SimpleSecret secret = new SimpleSecret("secret", new boolean[]{false,true,false,true,false,true}, out);
		secret.print();
		String output = baos.toString();
		assertTrue(output.equals("The word: ?e?r?t\n\n"));
	}
	
	@Test
	public void unmaskIncluded() {
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		final PrintStream out = new PrintStream(baos);
		Secret secret = new SimpleSecret("test", out);
		secret = secret.unmask('e');
		secret.print();
		String output = baos.toString();
		assertTrue(output.equals("The word: ?e??\n\n"));
	}
	
	@Test
	public void unmaskNothing() {
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		final PrintStream out = new PrintStream(baos);
		Secret secret = new SimpleSecret("test", out);
		secret = secret.unmask('F');
		secret.print();
		String output = baos.toString();
		assertTrue(output.equals("The word: ????\n\n"));
	}
	
	@Test
	public void secretHasMasked() {
		SimpleSecret secret = new SimpleSecret("test", System.out);
		assertFalse(secret.unmasked());
	}
	
	@Test
	public void secretAllUnmasked() {
		SimpleSecret secret = new SimpleSecret("test", new boolean[]{true, true, true, true} ,System.out);
		assertTrue(secret.unmasked());
	}
}
