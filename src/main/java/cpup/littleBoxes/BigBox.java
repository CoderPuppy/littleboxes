package cpup.littleBoxes;

public class BigBox extends Part {
	protected final Game game;
	protected final int bigX;
	protected final int bigY;

	public BigBox(Game _game, int _bigX, int _bigY) {
		game = _game;
		bigX = _bigX;
		bigY = _bigY;
	}

	// Getters and Setters
	@Override
	public Game getGame() {
		return game;
	}

	public int getBigX() {
		return bigX;
	}

	public int getBigY() {
		return bigY;
	}

	@Override
	public int getX() {
		return bigX * game.getBoxSize();
	}

	@Override
	public int getY() {
		return bigY * game.getBoxSize();
	}

	@Override
	public int getWidth() {
		return game.getBoxSize();
	}

	@Override
	public int getHeight() {
		return game.getBoxSize();
	}
}