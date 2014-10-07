package cpup.littleBoxes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BoxPos extends Part {
	protected final Game game;
	protected final int x;
	protected final int y;

	public BoxPos(Game _game, int _x, int _y) {
		game = _game;
		x = _x;
		y = _y;
	}

	// Getters and Setters
	public Box getBox() {
		return game.getBox(x, y);
	}

	@Override
	public Game getGame() {
		return game;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getWidth() {
		return 1;
	}

	@Override
	public int getHeight() {
		return 1;
	}

	@Override
	public Set<Box> getBoxes() {
		return new HashSet<>(Arrays.asList(game.getBox(x, y)));
	}

	@Override
	public boolean isValid() {
		return getBox().getValue() != -1;
	}
}