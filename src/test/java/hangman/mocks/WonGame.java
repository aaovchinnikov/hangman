package hangman.mocks;

import hangman.Game;

public final class WonGame implements Game {

	@Override
	public boolean won() {
		return true;
	}
	
}
