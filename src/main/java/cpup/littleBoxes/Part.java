package cpup.littleBoxes;

import java.util.HashSet;
import java.util.Set;

public abstract class Part {
	public abstract Game getGame();
	public Set<Box> getBoxes() {
		Set<Box> boxes = new HashSet<>();

		final Game game = getGame();
		final int baseX = getX();
		final int baseY = getY();
		final int width = getWidth();
		final int height = getHeight();
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				boxes.add(game.getBox(baseX + x, baseY + y));
			}
		}

		return boxes;
	}
	public abstract int getX();
	public abstract int getY();
	public abstract int getWidth();
	public abstract int getHeight();
	public boolean isValid() {
		Set<Box> boxes = getBoxes();
		Set<Integer> seen = new HashSet<>();
		boolean isValid = true;

		for(Box box : boxes) {
			if(box.getValue() == -1) {
				isValid = false;
			} else if(seen.contains(box.getValue())) {
				isValid = false;
			} else {
				seen.add(box.getValue());
			}
		}

		return isValid;
	}
}