package hangman;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;

import org.junit.Test;

import hangman.mocks.LostGame;
import hangman.mocks.WonGame;

public class ResultTest {

	@Test
	public void winTest() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		new Result(baos, new WonGame()).print();		
		assertTrue(new String(baos.toByteArray()).equals("You won!\n"));
	}
	
	@Test
	public void looseTest() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		new Result(baos, new LostGame()).print();		
		assertTrue(new String(baos.toByteArray()).equals("You lost.\n"));
	}
}
