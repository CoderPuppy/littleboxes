package cpup.littleBoxes;

public class Row extends Part {
	protected final Game game;
	protected final int bigY;

	public Row(Game _game, int _bigY) {
		game = _game;
		bigY = _bigY;
	}

	// Getters and Setters
	@Override
	public Game getGame() {
		return game;
	}

	public int getBigY() {
		return bigY;
	}

	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return bigY * game.getBoxSize();
	}

	@Override
	public int getWidth() {
		return game.getRawBoxes().length;
	}

	@Override
	public int getHeight() {
		return 1;
	}
}