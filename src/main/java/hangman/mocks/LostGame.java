package hangman.mocks;

import hangman.Game;

public final class LostGame implements Game {

	@Override
	public boolean won() {
		return false;
	}
}
