package hangman;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;

import org.junit.Test;

public class ResultTest {

	@Test
	public void winTest() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		new Result(baos, true).print();		
		assertTrue(new String(baos.toByteArray()).equals("You won!\n"));
	}
	
	@Test
	public void looseTest() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		new Result(baos, false).print();		
		assertTrue(new String(baos.toByteArray()).equals("You lost.\n"));
	}
}
