package hangman.impl;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import hangman.impl.SimpleResult;
import hangman.mocks.LostGame;
import hangman.mocks.WonGame;

public final class SimpleResultTest {

	@Test
	public void winTest() {
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		final PrintStream out = new PrintStream(baos);
		new SimpleResult(out, new WonGame()).print();		
		assertTrue(new String(baos.toByteArray()).equals("You won!\n"));
	}
	
	@Test
	public void looseTest() {
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		final PrintStream out = new PrintStream(baos);
		new SimpleResult(out, new LostGame()).print();		
		assertTrue(new String(baos.toByteArray()).equals("You lost.\n"));
	}
}
