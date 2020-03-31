package hangman;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

/**
 * Defines a word that should be guessed by user.
 * 
 * @author Alexander Ovchinnikov
 *
 */
public final class Secret {
	/** The word in question */
	private final String secret;
	/** The {@link PrintStream} where Secret instance shoul be printed */
	private final PrintStream out;
	/** 
	 * The array of bits for printing. True bit allows to print real letter,
	 * false bit indicates that question sign ('?') should be printed instead of letter */  
	private final boolean[] visible;
	
	/**
	 * Secondary constructor 
	 * @param variants - array of strings to choose randomly one as a secret
	 */
	public Secret(final String[] variants, final PrintStream out) {
		this(variants[new Random().nextInt(variants.length)], out);
	}
	
	/** 
	 * Secondary constructor. Builds Secret with all letters masked
	 * @param str - {@link String} encapsulated as secret
	 */
	public Secret(final String str, final PrintStream out) {
		this(str, new boolean[str.length()], out);
	}
	
	/** 
	 * Main constructor. Builds Secret with letters masked using {@link m} array
	 * @param str - {@link String} encapsulated as secret
	 * @param m - mask of visible positions, visible position should be marked with true bits 
	 */
	public Secret(final String str, final boolean[] m, final PrintStream out) {
		if (str.length() != m.length) {
			throw new IllegalArgumentException("Provided string length and mask length don't match");
		}
		this.secret = str;
		this.visible = m;
		this.out = out;
	}
	
	/**
	 * Check whether secret word contains the symbol {@link c}
	 * @param c - symbol that tried
	 * @return true - if secret word contains the symbol {@link c}, otherwise - false 
	 */
	public boolean contains(final char c) {
		return this.secret.indexOf(c) >=0 ;
	}
	
	/**
	 * Print masked secret to encapsulated {@link PrintStream}
	 */
	public void print() {
		for (int i = 0; i < this.secret.length(); ++i) {
			if (this.visible[i]) {
                this.out.print(this.secret.charAt(i));
            } else {
                this.out.print("?");
            }
		}
		this.out.print("\n\n");
	}
	
	/**
	 * 
	 */
/*	public Secret unmask(final char c) {
		boolean[] m = new boolean[this.secret.length()];
        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) == chr && !visible[i]) {
                visible[i] = true;
                hit = true;
            }
        }

		return new Secret(this.secret,)
	}
*/

}
