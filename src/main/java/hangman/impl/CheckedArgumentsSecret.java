package hangman.impl;

import java.io.PrintStream;
import java.util.Random;

import hangman.Secret;

/**
 * Wrapper around {@link SimpleSecret} that checks arguments before constructing an instance.
 * 
 * @author Alexander Ovchinnikov
 *
 */
public final class CheckedArgumentsSecret implements Secret {
	/**
	 * Encapsulated {@link SimpleSecret} 
	 */
	private final Secret inner;

	/**
	 * Secondary constructor. Randomly chooses one string from provided variants array for the secret.
	 * @param variants - array of strings to choose randomly one as a secret
	 * @param out - {@link PrintStream} where Secret instance should be printed
	 * @throws NullPointerException if variants array is <b>null</b>
	 */
	public CheckedArgumentsSecret(final String[] variants, final PrintStream out) {
		if (variants == null) {
			throw new NullPointerException("Provided variants array is null");
		}
		if (variants.length == 0) {
			throw new IllegalArgumentException("Provided variants array is empty");
		}
		this.inner = new CheckedArgumentsSecret(variants[new Random().nextInt(variants.length)], out);
	}
	
	/**
	 * Secondary constructor. Builds secret with all characters masked. 
	 * Delegates to {@link #CheckedArgumentsSecret(String, boolean[], PrintStream)}.
	 * @param str - {@link String} encapsulated as secret
	 * @param out - {@link PrintStream} where Secret instance should be printed
	 */
	public CheckedArgumentsSecret(final String str, final PrintStream out) {
		this(str, new boolean[str.length()], out);
	}
	
	/**
	 * Main constructor.
	 * @param str - {@link String} encapsulated as secret
	 * @param m - mask of visible positions, visible position should be marked with true bits
	 * @param out - {@link PrintStream} where Secret instance should be printed
	 * @throws NullPointerException if any argument is <b>null</b>
	 * @throws IllegalArgumentException if provided {@link str} is empty or has non-lowercase letters or
	 * if provided {@link m} array length doesn't match provided {@link str} length
	 * 
	 */
	public CheckedArgumentsSecret(final String str, final boolean[] m, final PrintStream out) {
		if (str == null) {
			throw new NullPointerException("Provided string is null");
		}
		if (str.isEmpty()) {
			throw new IllegalArgumentException("Provided string length and mask length don't match");
		}
		if (!str.matches("[a-z]+")) {
			throw new IllegalArgumentException("Provided string has unsupported chars. Only ['a'-'z'] chars allowed");
		}
		if (m == null) {
			throw new NullPointerException("Provided mask array is null");
		}
		if (str.length() != m.length) {
			throw new IllegalArgumentException("Provided string length and mask length don't match");
		}
		if (out == null) {
			throw new NullPointerException("Provided PrintStream is null");
		}
		this.inner = new SimpleSecret(str, m, out);
	}
	
	@Override
	public boolean contains(char chr) {
		return this.inner.contains(chr);
	}

	@Override
	public void print() {
		this.inner.print();
	}

	@Override
	public Secret unmask(char chr) {
		return this.inner.unmask(chr);
	}

	@Override
	public boolean unmasked() {
		return this.inner.unmasked();
	}
}
