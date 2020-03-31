package hangman;

/**
 * Represents secret word for guessing in Hangman-like game.
 * 
 * @author Alexander Ovchinnikov
 *
 */
public interface Secret {
	/**
	 * Check whether secret word contains masked symbol {@link chr}
	 * @param chr - symbol that tried
	 * @return true - if secret word contains the symbol {@link c}, otherwise - false 
	 */
	public boolean contains(final char chr);
	
	/**
	 * Print masked secret
	 */
	public void print();
	
	/**
	 * Unmasks all positions of provided character {@link chr} if it's contained in {@link Secret} instance (i.e. if {@link Secret#contains(chr)} returns true)
	 * @param chr - unmasked character 
	 * @return new instance of Secret with unmasked positions or <b>this</b>-pointer if no positions are unmasked 
	 */
	public Secret unmask(final char chr);
	
	/**
	 * Checks whether secret has any masked letters 
	 * @return true if secret has any masked letters, false otherwise
	 */
	public boolean unmasked();
}
