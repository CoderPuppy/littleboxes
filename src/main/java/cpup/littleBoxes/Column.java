package cpup.littleBoxes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Column extends Part {
	protected final Game game;
	protected final int bigX;

	public Column(Game _game, int _bigX) {
		game = _game;
		bigX = _bigX;
	}

	// Getters and Setters
	@Override
	public Game getGame() {
		return game;
	}

	public int getBigX() {
		return bigX;
	}

	@Override
	public int getX() {
		return bigX * game.getBoxSize();
	}

	@Override
	public int getY() {
		return 0;
	}

	@Override
	public int getWidth() {
		return 1;
	}

	@Override
	public int getHeight() {
		return game.getRawBoxes().length;
	}

	@Override
	public Set<Box> getBoxes() {
		return new HashSet<>(Arrays.asList(game.getRawBoxes()[bigX]));
	}
}