package hangman.impl;

import static org.junit.Assert.assertFalse;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import org.junit.Test;

import hangman.impl.Hangman;
import hangman.impl.SimpleGuess;
import hangman.impl.SimpleSecret;

public class HangmanTest {

    @Test
    public void failsAfterManyWrongAttempts() throws Exception {
        final ByteArrayInputStream input = new ByteArrayInputStream(
            "a\na\na\na\na\n".getBytes()
        );
        assertFalse(
        	new Hangman(
        		new SimpleSecret("test", System.out),
        		1,
        		new SimpleGuess(
        			new Scanner(input),
        			System.out
        		),
        		System.out
        	).won()
        );
    }
}
