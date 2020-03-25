package hangman;

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
	
	/**
	 * Secondary constructor 
	 * @param variants - array of strings to choose randomly one as a secret
	 */
	public Secret(final String[] variants) {
		this(variants[new Random().nextInt(variants.length)]);
	}
	
	/** Main constructor
	 * @param str - {@link String} encapsulated as secret
	 */
	public Secret(final String str) {
		this.secret = str;
	}
	
	/**
	 * Check whether secret word contains the symbol {@link c}
	 * @param c - symbol that tried
	 * @return true - if secret word contains the symbol {@link c}, otherwise - false 
	 */
	public boolean contains(final char c) {
		return this.secret.indexOf(c) >=0 ;
	}
}
