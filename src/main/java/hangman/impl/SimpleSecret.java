package hangman.impl;

import java.io.PrintStream;
import java.util.Random;

import hangman.Secret;

/**
 * Defines a word that should be guessed by user. Doesn't check provided arguments for constructors.
 * If you need these checks, use {@link CheckedArgumentsSecret} instead.
 * 
 * @author Alexander Ovchinnikov
 *
 */
public final class SimpleSecret implements Secret{
	/** The word in question */
	private final String secret;
	/** The {@link PrintStream} where Secret instance should be printed */
	private final PrintStream out;
	/** 
	 * The array of bits for printing. True bit allows to print real letter,
	 * false bit indicates that question sign ('?') should be printed instead of letter
	 */  
	private final boolean[] visible;
	
	/**
	 * Secondary constructor 
	 * @param variants - array of strings to choose randomly one as a secret
	 */
	public SimpleSecret(final String[] variants, final PrintStream out) {
		this(variants[new Random().nextInt(variants.length)], out);
	}
	
	/** 
	 * Secondary constructor. Builds Secret with all letters masked
	 * @param str - {@link String} encapsulated as secret
	 */
	public SimpleSecret(final String str, final PrintStream out) {
		this(str, new boolean[str.length()], out);
	}
	
	/** 
	 * Main constructor. Builds Secret with letters masked using {@link m} array. Doesn't check provided arguments.
	 * If you need these checks, use {@link CheckedArgumentsSecret} instead.
	 * @param str - {@link String} encapsulated as secret
	 * @param m - mask of visible positions, visible position should be marked with true bits
	 * @param out - {@link PrintStream} where Secret instance should be printed
	 */
	public SimpleSecret(final String str, final boolean[] m, final PrintStream out) {
		this.secret = str;
		this.visible = m;
		this.out = out;
	}
	
	@Override
	public boolean contains(final char chr) {
        for (int i = 0; i < this.secret.length(); ++i) {
            if (this.secret.charAt(i) == chr && !this.visible[i]) {
                return true;
            }
        }
		return false;
	}
	
	/**
	 * Print masked secret to encapsulated {@link PrintStream}
	 */
	@Override
	public void print() {
		this.out.print("The word: ");
		for (int i = 0; i < this.secret.length(); ++i) {
			if (this.visible[i]) {
                this.out.print(this.secret.charAt(i));
            } else {
                this.out.print("?");
            }
		}
		this.out.print("\n\n");
	}
	
	@Override
	public Secret unmask(final char chr) {
		boolean[] m = new boolean[this.secret.length()];
		for (int i = 0; i < this.secret.length(); ++i) {
			m[i] = this.visible[i];
		}
		boolean hit = false;
        for (int i = 0; i < this.secret.length(); ++i) {
        	if ((this.secret.charAt(i) == chr) && !m[i]) {
                m[i] = true;
                hit = true;
            }
        }
        if (hit) {
        	return new SimpleSecret(this.secret, m, this.out);
        } else {
        	return this;
        }
	}
	
	@Override
	public boolean unmasked() {
		for(int i = 0; i < this.visible.length; i++) {
			if (!this.visible[i]) {
				return false;
			}
		}
		return true;
	}
}
